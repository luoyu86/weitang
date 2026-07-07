#!/usr/bin/env python3
"""
智能门锁蓝牙测试脚本
用于测试电脑蓝牙是否能连接门锁
"""

import asyncio
import json
import uuid
import time
from bleak import BleakClient, BleakScanner

# 门锁信息
LOCK_MAC = "1E:98:6C:02:A7:77"

# 蓝牙UUID
SERVICE_UUID = "000018f0-0000-1000-8000-00805f9b34fb"
WRITE_UUID = "00002af1-0000-1000-8000-00805f9b34fb"
NOTIFY_UUID = "00002af0-0000-1000-8000-00805f9b34fb"

# 开锁密钥
DATA_SECRET = "DBCCB54D6E2E655958FF9E29CBF8A764"
USER_KEY = "0F80D3A7AF16E51B5BAA1A829A144B04C9878901EB6377ACB525214E3820E0D2"

# TEA加密
def tea_encrypt(data: bytes, key: bytes, rounds: int = 16) -> bytes:
    """TEA加密算法"""
    def encrypt_block(v0: int, v1: int, k: list) -> tuple:
        delta = 0x9E3779B9
        s = 0
        for _ in range(rounds):
            s = (s + delta) & 0xFFFFFFFF
            v0 = (v0 + (((v1 << 4) + k[0]) ^ (v1 + s) ^ ((v1 >> 5) + k[1]))) & 0xFFFFFFFF
            v1 = (v1 + (((v0 << 4) + k[2]) ^ (v0 + s) ^ ((v0 >> 5) + k[3]))) & 0xFFFFFFFF
        return v0, v1
    
    # 转换key为4个32位整数
    k = [int.from_bytes(key[i:i+4], 'little') for i in range(0, 16, 4)]
    
    # 填充数据到8字节的倍数
    padded_data = data + b'\x00' * (8 - len(data) % 8) if len(data) % 8 != 0 else data
    
    result = b''
    for i in range(0, len(padded_data), 8):
        block = padded_data[i:i+8]
        v0 = int.from_bytes(block[0:4], 'little')
        v1 = int.from_bytes(block[4:8], 'little')
        v0, v1 = encrypt_block(v0, v1, k)
        result += v0.to_bytes(4, 'little') + v1.to_bytes(4, 'little')
    
    return result

def xor_code(data: bytes) -> bytes:
    """计算XOR校验码"""
    result = data[0]
    for i in range(1, len(data) - 1):
        result ^= data[i]
    return bytes([result])

def build_tlv_command(cmd_type: int, cmd_code: int, units: list) -> bytes:
    """构建TLV格式的命令"""
    # 命令头：类型 + 命令码
    command = bytes([cmd_type, cmd_code])
    
    # 添加TLV单元
    for unit_type, unit_data in units:
        # 类型（2字节）
        command += unit_type.to_bytes(2, 'big')
        # 长度（2字节）
        command += len(unit_data).to_bytes(2, 'big')
        # 数据
        command += unit_data
    
    return command

def build_communication_package(key: bytes, command: bytes, is_super: bool = False) -> bytes:
    """构建通信包（加密+包装）"""
    # 计算XOR校验码
    command_with_xor = command[:-1] + xor_code(command)
    
    # TEA加密
    encrypted = tea_encrypt(command_with_xor, key, 16)
    
    # 包装成米家锁命令
    if is_super:
        # 超级模式：106, 3
        package = bytes([106, 3]) + len(encrypted).to_bytes(2, 'big') + encrypted
    else:
        # 普通模式：106, 1
        package = bytes([106, 1]) + len(encrypted).to_bytes(2, 'big') + encrypted
    
    # 计算最终XOR校验码
    package = package[:-1] + xor_code(package)
    
    return package

async def notification_handler(characteristic, data):
    """处理通知数据"""
    print(f"收到通知: {data.hex()}")
    
    # 解析响应
    if len(data) >= 4:
        # 检查是否是成功响应
        if data[0] == 106:  # 米家锁响应
            print("  -> 米家锁响应")
            if len(data) > 4:
                # 尝试解密
                print(f"  -> 响应数据: {data[4:].hex()}")

async def scan_for_lock():
    """扫描门锁设备"""
    print("扫描蓝牙设备...")
    devices = await BleakScanner.discover(timeout=10)
    
    print(f"\n找到 {len(devices)} 个设备:")
    for device in devices:
        print(f"  {device.address} - {device.name or '未知'}")
        
        # 检查是否是目标门锁
        if device.address.upper() == LOCK_MAC.upper():
            print(f"  *** 找到目标门锁: {device.address} ***")
            return device
    
    print("\n未找到目标门锁，请确保门锁在附近且已开启蓝牙")
    return None

async def test_connection():
    """测试连接门锁"""
    print(f"尝试连接门锁: {LOCK_MAC}")
    
    try:
        async with BleakClient(LOCK_MAC) as client:
            print("连接成功!")
            
            # 启用通知
            await client.start_notify(NOTIFY_UUID, notification_handler)
            print("已启用通知监听")
            
            # 等待一下让连接稳定
            await asyncio.sleep(1)
            
            # 构建获取随机串的命令
            # 命令类型31，命令码3（获取随机串）
            command = build_tlv_command(31, 3, [(25, bytes([1, 1, 1, 1]))])
            package = build_communication_package(bytes.fromhex(DATA_SECRET), command)
            
            print(f"\n发送获取随机串命令: {package.hex()}")
            await client.write_gatt_char(WRITE_UUID, package)
            
            # 等待响应
            await asyncio.sleep(2)
            
            print("\n测试完成!")
            return True
            
    except Exception as e:
        print(f"连接失败: {e}")
        return False

async def main():
    """主函数"""
    print("=" * 50)
    print("智能门锁蓝牙测试")
    print("=" * 50)
    
    # 先扫描设备
    device = await scan_for_lock()
    
    if device:
        print(f"\n开始连接测试...")
        success = await test_connection()
        
        if success:
            print("\n✓ 蓝牙连接测试成功!")
        else:
            print("\n✗ 蓝牙连接测试失败")
    else:
        print("\n无法进行连接测试，未找到门锁设备")

if __name__ == "__main__":
    asyncio.run(main())