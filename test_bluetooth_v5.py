#!/usr/bin/env python3
"""
智能门锁蓝牙测试脚本 v5
直接发送完整数据
"""

import asyncio
from bleak import BleakClient

LOCK_MAC = "1E:98:6C:02:A7:77"
WRITE_UUID = "00002af1-0000-1000-8000-00805f9b34fb"
NOTIFY_UUID = "00002af0-0000-1000-8000-00805f9b34fb"

DATA_SECRET = "DBCCB54D6E2E655958FF9E29CBF8A764"

def xor_code(data: bytes) -> int:
    result = 0
    for b in data:
        result ^= b
    return result & 0xFF

def tea_encrypt_block(v0: int, v1: int, k: list, rounds: int = 16) -> tuple:
    delta = 0x9E3779B9
    s = 0
    for _ in range(rounds):
        s = (s + delta) & 0xFFFFFFFF
        v0 = (v0 + (((v1 << 4) + k[0]) ^ (v1 + s) ^ ((v1 >> 5) + k[1]))) & 0xFFFFFFFF
        v1 = (v1 + (((v0 << 4) + k[2]) ^ (v0 + s) ^ ((v0 >> 5) + k[3]))) & 0xFFFFFFFF
    return v0, v1

def tea_encrypt(data: bytes, key: bytes, rounds: int = 16) -> bytes:
    pad_len = 8 - (len(data) % 8)
    padded_data = data + bytes([pad_len] * pad_len)
    
    k = [int.from_bytes(key[i:i+4], 'little') for i in range(0, 16, 4)]
    
    result = b''
    for i in range(0, len(padded_data), 8):
        block = padded_data[i:i+8]
        v0 = int.from_bytes(block[0:4], 'little')
        v1 = int.from_bytes(block[4:8], 'little')
        v0, v1 = tea_encrypt_block(v0, v1, k, rounds)
        result += v0.to_bytes(4, 'little') + v1.to_bytes(4, 'little')
    
    return result

def build_tlv(unit_type: int, data: bytes) -> bytes:
    return unit_type.to_bytes(2, 'big') + len(data).to_bytes(2, 'big') + data

def build_command(cmd_type: int, cmd_code: int, units: list) -> bytes:
    command = bytes([cmd_type, cmd_code])
    for unit_type, unit_data in units:
        command += build_tlv(unit_type, unit_data)
    return command

def get_communication_package(key: bytes, command: bytes, is_super: bool = False) -> bytes:
    xor = xor_code(command[:-1])
    command = command[:-1] + bytes([xor])
    
    encrypted = tea_encrypt(key, command, 16)
    
    if is_super:
        package = bytes([106, 3]) + build_tlv(29, encrypted)
    else:
        package = bytes([106, 1]) + build_tlv(29, encrypted)
    
    xor = xor_code(package[:-1])
    package = package[:-1] + bytes([xor])
    
    return package

async def main():
    print("=" * 50)
    print("智能门锁蓝牙测试 v5")
    print("=" * 50)
    
    response_received = asyncio.Event()
    response_data = bytearray()
    
    async def notification_handler(characteristic, data):
        nonlocal response_data
        response_data = bytearray(data)
        print(f"  收到响应: {data.hex()}")
        response_received.set()
    
    async with BleakClient(LOCK_MAC) as client:
        print("连接成功!")
        
        await client.start_notify(NOTIFY_UUID, notification_handler)
        print("已启用通知监听")
        
        await asyncio.sleep(2)
        
        # 构建获取随机串命令
        random_num = bytes([1, 1, 1, 1])
        command = build_command(31, 3, [(25, random_num)])
        
        print(f"\n原始命令: {command.hex()}")
        
        key = bytes.fromhex(DATA_SECRET)
        package = get_communication_package(key, command)
        
        print(f"加密后命令: {package.hex()}")
        print(f"命令长度: {len(package)} 字节")
        
        # 直接发送完整数据
        print("\n发送获取随机串命令...")
        await client.write_gatt_char(WRITE_UUID, package, response=True)
        print("  命令已发送")
        
        # 等待响应
        try:
            await asyncio.wait_for(response_received.wait(), timeout=10.0)
            print(f"收到响应: {response_data.hex()}")
        except asyncio.TimeoutError:
            print("等待响应超时")
            
            # 尝试读取通知特征
            print("\n尝试读取通知特征...")
            try:
                value = await client.read_gatt_char(NOTIFY_UUID)
                print(f"  通知特征值: {value.hex()}")
            except Exception as e:
                print(f"  读取失败: {e}")
        
        print("\n测试完成!")

if __name__ == "__main__":
    asyncio.run(main())