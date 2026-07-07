#!/usr/bin/env python3
"""
智能门锁蓝牙测试脚本 v2
优化命令格式和响应处理
"""

import asyncio
import json
import struct
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

# TEA加密实现
def tea_encrypt(data: bytes, key: bytes, rounds: int = 16) -> bytes:
    """TEA加密"""
    def encrypt_block(v0: int, v1: int, k: list) -> tuple:
        delta = 0x9E3779B9
        s = 0
        for _ in range(rounds):
            s = (s + delta) & 0xFFFFFFFF
            v0 = (v0 + (((v1 << 4) + k[0]) ^ (v1 + s) ^ ((v1 >> 5) + k[1]))) & 0xFFFFFFFF
            v1 = (v1 + (((v0 << 4) + k[2]) ^ (v0 + s) ^ ((v0 >> 5) + k[3]))) & 0xFFFFFFFF
        return v0, v1
    
    k = [int.from_bytes(key[i:i+4], 'little') for i in range(0, 16, 4)]
    
    padded_data = data + b'\x00' * (8 - len(data) % 8) if len(data) % 8 != 0 else data
    
    result = b''
    for i in range(0, len(padded_data), 8):
        block = padded_data[i:i+8]
        v0 = int.from_bytes(block[0:4], 'little')
        v1 = int.from_bytes(block[4:8], 'little')
        v0, v1 = encrypt_block(v0, v1, k)
        result += v0.to_bytes(4, 'little') + v1.to_bytes(4, 'little')
    
    return result

def xor_code(data: bytes) -> int:
    """计算XOR校验码"""
    result = 0
    for b in data:
        result ^= b
    return result

def build_get_random_command() -> bytes:
    """构建获取随机串命令 (类型31, 命令码3)"""
    # 命令结构：类型(1) + 命令码(1) + TLV单元
    command = bytearray()
    command.append(31)  # 类型
    command.append(3)   # 命令码：获取随机串
    
    # 添加随机数单元 (类型25)
    command.extend((25).to_bytes(2, 'big'))  # 类型
    command.extend((4).to_bytes(2, 'big'))   # 长度
    command.extend(b'\x01\x01\x01\x01')     # 数据
    
    return bytes(command)

def build_unlock_command(user_key: bytes, random_str: bytes, is_super: bool = False) -> bytes:
    """构建开锁命令 (类型31, 命令码7)"""
    command = bytearray()
    command.append(31)  # 类型
    command.append(7)   # 命令码：开锁
    
    # 添加用户密钥单元 (类型101)
    command.extend((101).to_bytes(2, 'big'))
    command.extend(len(user_key).to_bytes(2, 'big'))
    command.extend(user_key)
    
    # 添加随机串单元 (类型100)
    command.extend((100).to_bytes(2, 'big'))
    command.extend(len(random_str).to_bytes(2, 'big'))
    command.extend(random_str)
    
    # 添加随机数单元 (类型25)
    command.extend((25).to_bytes(2, 'big'))
    command.extend((4).to_bytes(2, 'big'))
    command.extend(b'\x03\x03\x03\x03')
    
    # 添加自动锁单元 (类型66)
    command.extend((66).to_bytes(2, 'big'))
    command.extend((1).to_bytes(2, 'big'))
    command.extend(b'\x00')  # 不自动锁
    
    return bytes(command)

def encrypt_command(key: bytes, command: bytes, is_super: bool = False) -> bytes:
    """加密命令并构建通信包"""
    # 1. 计算XOR校验码
    xor = xor_code(command[:-1])
    command_with_xor = command[:-1] + bytes([xor])
    
    # 2. TEA加密
    encrypted = tea_encrypt(command_with_xor, key, 16)
    
    # 3. 包装成米家锁命令
    if is_super:
        package = bytearray([106, 3])  # 超级模式
    else:
        package = bytearray([106, 1])  # 普通模式
    
    package.extend(len(encrypted).to_bytes(2, 'big'))
    package.extend(encrypted)
    
    # 4. 计算最终XOR校验码
    final_xor = xor_code(package[:-1])
    package[-1] = final_xor
    
    return bytes(package)

class LockTester:
    def __init__(self):
        self.client = None
        self.response_data = bytearray()
        self.response_received = asyncio.Event()
        self.lock_random = None
    
    async def notification_handler(self, characteristic, data):
        """处理通知数据"""
        print(f"  收到响应 ({len(data)}字节): {data.hex()}")
        self.response_data.extend(data)
        self.response_received.set()
    
    async def connect(self):
        """连接门锁"""
        print(f"连接门锁: {LOCK_MAC}")
        self.client = BleakClient(LOCK_MAC)
        await self.client.connect()
        print("连接成功!")
        
        # 发现服务
        print("发现服务...")
        services = self.client.services
        for service in services:
            print(f"  服务: {service.uuid}")
            for char in service.characteristics:
                print(f"    特征: {char.uuid} ({char.properties})")
        
        # 启用通知
        await self.client.start_notify(NOTIFY_UUID, self.notification_handler)
        print("已启用通知监听")
        
        await asyncio.sleep(2)
    
    async def disconnect(self):
        """断开连接"""
        if self.client:
            await self.client.disconnect()
            print("已断开连接")
    
    async def send_command(self, command: bytes, description: str) -> bool:
        """发送命令并等待响应"""
        print(f"\n发送{description}...")
        print(f"  命令: {command.hex()}")
        
        self.response_data = bytearray()
        self.response_received.clear()
        
        try:
            await self.client.write_gatt_char(WRITE_UUID, command)
            print("  命令已发送")
            
            # 等待响应
            try:
                await asyncio.wait_for(self.response_received.wait(), timeout=10.0)
                print(f"  收到响应: {self.response_data.hex()}")
                return True
            except asyncio.TimeoutError:
                print("  等待响应超时")
                return False
                
        except Exception as e:
            print(f"  发送失败: {e}")
            return False
    
    async def test_get_random(self):
        """测试获取随机串"""
        command = build_get_random_command()
        encrypted = encrypt_command(bytes.fromhex(DATA_SECRET), command)
        return await self.send_command(encrypted, "获取随机串命令")
    
    async def test_unlock(self):
        """测试开锁命令"""
        # 先获取随机串
        if not await self.test_get_random():
            return False
        
        # 使用固定随机串测试
        random_str = b'\x12\x34\x56\x78\x9a\xbc\xde\xf0'
        
        command = build_unlock_command(bytes.fromhex(USER_KEY), random_str)
        encrypted = encrypt_command(bytes.fromhex(DATA_SECRET), command)
        return await self.send_command(encrypted, "开锁命令")

async def main():
    print("=" * 50)
    print("智能门锁蓝牙测试 v2")
    print("=" * 50)
    
    tester = LockTester()
    
    try:
        await tester.connect()
        
        # 测试获取随机串
        print("\n--- 测试1: 获取随机串 ---")
        success1 = await tester.test_get_random()
        
        # 测试开锁
        print("\n--- 测试2: 开锁命令 ---")
        success2 = await tester.test_unlock()
        
        print("\n" + "=" * 50)
        print("测试结果:")
        print(f"  获取随机串: {'成功' if success1 else '失败'}")
        print(f"  开锁命令: {'成功' if success2 else '失败'}")
        print("=" * 50)
        
    except Exception as e:
        print(f"\n测试出错: {e}")
        import traceback
        traceback.print_exc()
    finally:
        await tester.disconnect()

if __name__ == "__main__":
    asyncio.run(main())