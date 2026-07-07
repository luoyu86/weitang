#!/usr/bin/env python3
"""
智能门锁蓝牙测试脚本 v3
尝试读取特征值和直接写入
"""

import asyncio
from bleak import BleakClient, BleakScanner

LOCK_MAC = "1E:98:6C:02:A7:77"
WRITE_UUID = "00002af1-0000-1000-8000-00805f9b34fb"
NOTIFY_UUID = "00002af0-0000-1000-8000-00805f9b34fb"

async def main():
    print("=" * 50)
    print("智能门锁蓝牙测试 v3")
    print("=" * 50)
    
    async with BleakClient(LOCK_MAC) as client:
        print("连接成功!")
        
        # 读取设备名称
        try:
            name = await client.read_gatt_char("00002a00-0000-1000-8000-00805f9b34fb")
            print(f"设备名称: {name.decode('utf-8', errors='ignore')}")
        except:
            print("无法读取设备名称")
        
        # 读取设备外观
        try:
            appearance = await client.read_gatt_char("00002a01-0000-1000-8000-00805f9b34fb")
            print(f"设备外观: {appearance.hex()}")
        except:
            print("无法读取设备外观")
        
        # 尝试读取其他特征
        other_chars = [
            "122e8cc0-8508-11e3-baa7-0800200c9a66",
            "210f99f0-8508-11e3-baa7-0800200c9a66",
            "2691aa80-8508-11e3-baa7-0800200c9a66",
        ]
        
        for char_uuid in other_chars:
            try:
                value = await client.read_gatt_char(char_uuid)
                print(f"特征 {char_uuid}: {value.hex()}")
            except Exception as e:
                print(f"特征 {char_uuid}: 读取失败 - {e}")
        
        # 尝试写入简单数据
        print("\n尝试写入简单数据...")
        test_data = bytes([0x01, 0x02, 0x03, 0x04])
        try:
            await client.write_gatt_char(WRITE_UUID, test_data)
            print(f"写入成功: {test_data.hex()}")
            await asyncio.sleep(1)
        except Exception as e:
            print(f"写入失败: {e}")
        
        print("\n测试完成!")

if __name__ == "__main__":
    asyncio.run(main())