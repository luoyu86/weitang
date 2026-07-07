#!/usr/bin/env python3
"""
智能门锁蓝牙开锁脚本
完整的开锁流程：获取随机串 -> 发送开锁命令
"""

import asyncio
from bleak import BleakClient

LOCK_MAC = '1E:98:6C:02:A7:77'
WRITE_UUID = '00002af1-0000-1000-8000-00805f9b34fb'
NOTIFY_UUID = '00002af0-0000-1000-8000-00805f9b34fb'

DATA_SECRET = bytes.fromhex('DBCCB54D6E2E655958FF9E29CBF8A764')
USER_KEY = bytes.fromhex('0F80D3A7AF16E51B5BAA1A829A144B04C9878901EB6377ACB525214E3820E0D2')

# TEA encryption
def xor_code(data):
    r = 0
    for b in data:
        r ^= b
    return r & 0xFF

def tea_encrypt_block(v0, v1, k, rounds=16):
    delta = 0x9E3779B9
    s = 0
    for _ in range(rounds):
        s = (s + delta) & 0xFFFFFFFF
        v0 = (v0 + (((v1 << 4) + k[0]) ^ (v1 + s) ^ ((v1 >> 5) + k[1]))) & 0xFFFFFFFF
        v1 = (v1 + (((v0 << 4) + k[2]) ^ (v0 + s) ^ ((v0 >> 5) + k[3]))) & 0xFFFFFFFF
    return v0, v1

def tea_encrypt(data, key, rounds=16):
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

# TLV encoding
def build_tlv(unit_type, data):
    return unit_type.to_bytes(2, 'big') + len(data).to_bytes(2, 'big') + data

# Command building
def get_range_code(random_num):
    """构建获取随机串命令 (类型31, 命令码3)"""
    command = bytes([31, 3]) + build_tlv(25, random_num)
    # XOR checksum
    xor = xor_code(command[:-1])
    command = command[:-1] + bytes([xor])
    return command

def get_unlock_command(user_key, random_str):
    """构建开锁命令 (类型31, 命令码7)"""
    command = bytearray([31, 7])
    command += build_tlv(101, user_key)
    command += build_tlv(100, random_str)
    command += build_tlv(25, bytes([3, 3, 3, 3]))
    command += build_tlv(66, bytes([0]))  # 不自动锁
    command = bytes(command)
    # XOR checksum
    xor = xor_code(command[:-1])
    command = command[:-1] + bytes([xor])
    return command

def get_communication_package(key, command):
    """构建通信包（加密+米家锁包装）"""
    encrypted = tea_encrypt(key, command, 16)
    package = bytearray([106, 1]) + build_tlv(29, encrypted)
    xor = xor_code(package[:-1])
    package = package[:-1] + bytes([xor])
    return bytes(package)

# Write with splitting (20 bytes per packet)
async def write_data(client, data, delay=0.05):
    """分包写入数据"""
    pack_len = 20
    for i in range(0, len(data), pack_len):
        pack = data[i:i+pack_len]
        await client.write_gatt_char(WRITE_UUID, pack, response=False)
        await asyncio.sleep(delay)

async def main():
    print("=" * 50)
    print("智能门锁开锁测试")
    print("=" * 50)
    
    all_responses = bytearray()
    random_str = None
    
    def on_notify(char, data):
        nonlocal all_responses
        all_responses.extend(data)
        print(f'  收到: {data.hex()}')
    
    try:
        async with BleakClient(LOCK_MAC, timeout=10.0) as client:
            print("连接成功!")
            
            # 启用通知
            await client.start_notify(NOTIFY_UUID, on_notify)
            await asyncio.sleep(1)
            
            # 步骤1: 发送获取随机串命令
            print("\n--- 步骤1: 获取随机串 ---")
            random_num = bytes([11, 11, 11, 11])
            command = get_range_code(random_num)
            package = get_communication_package(DATA_SECRET, command)
            
            print(f"命令长度: {len(package)} 字节")
            await write_data(client, package)
            print("获取随机串命令已发送")
            
            # 等待门锁响应
            print("等待门锁响应...")
            for i in range(20):
                await asyncio.sleep(0.5)
                if len(all_responses) > 4:
                    print(f"收到响应数据: {all_responses.hex()}")
                    break
                print(f"  等待中... ({i+1}/20)")
            
            # 步骤2: 尝试使用固定随机串发送开锁命令
            print("\n--- 步骤2: 发送开锁命令 ---")
            random_str = bytes([1, 2, 3, 4, 5, 6, 7, 8])
            
            command = get_unlock_command(USER_KEY, random_str)
            package = get_communication_package(DATA_SECRET, command)
            
            print(f"命令长度: {len(package)} 字节")
            await write_data(client, package)
            print("开锁命令已发送")
            
            # 等待响应
            print("等待响应...")
            await asyncio.sleep(3)
            
            if all_responses:
                print(f"\n最终响应: {all_responses.hex()}")
                # 检查是否包含EE08（成功标志）
                resp_hex = all_responses.hex()
                if 'ee08' in resp_hex.lower():
                    print("\n✓ 门锁开锁成功!")
                elif 'ee' in resp_hex.lower():
                    print(f"\n✗ 门锁返回错误")
                else:
                    print("\n? 未识别的响应")
            else:
                print("\n未收到响应")
            
    except Exception as e:
        print(f"错误: {e}")

asyncio.run(main())
