#!/usr/bin/env python3
"""
智能门锁蓝牙协议分析器
专门用于分析智能门锁APP的蓝牙通信协议
"""

import sys
import os
import re
from androguard.misc import AnalyzeAPK

def analyze_bluetooth_protocol(apk_path):
    """分析APK中的蓝牙协议"""
    print(f"分析APK文件: {apk_path}")
    
    if not os.path.exists(apk_path):
        print(f"错误: 文件不存在 {apk_path}")
        return
    
    try:
        # 分析APK
        a, d, dx = AnalyzeAPK(apk_path)
        
        print(f"\n=== APK基本信息 ===")
        print(f"包名: {a.get_package()}")
        print(f"版本: {a.get_androidversion_name()}")
        
        # 检查蓝牙权限
        print(f"\n=== 蓝牙权限 ===")
        permissions = a.get_permissions()
        bluetooth_permissions = [p for p in permissions if 'bluetooth' in p.lower()]
        for perm in bluetooth_permissions:
            print(f"  ✓ {perm}")
        
        # 1. 搜索蓝牙UUID模式
        print(f"\n=== 蓝牙UUID分析 ===")
        
        # 从DEX文件中提取字符串
        strings = []
        for dex in d:
            try:
                for string_class in dex.get_strings():
                    strings.append(str(string_class))
            except:
                pass
        
        # 搜索UUID格式的字符串
        uuid_pattern = r'[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}'
        uuids_found = []
        
        for s in strings:
            matches = re.findall(uuid_pattern, s)
            if matches:
                uuids_found.extend(matches)
        
        # 去重
        uuids_found = list(set(uuids_found))
        
        if uuids_found:
            print(f"找到 {len(uuids_found)} 个蓝牙UUID:")
            for uuid in uuids_found[:20]:  # 显示前20个
                print(f"  {uuid}")
        else:
            print("未找到标准格式的蓝牙UUID")
        
        # 2. 搜索蓝牙服务相关字符串
        print(f"\n=== 蓝牙服务分析 ===")
        service_keywords = [
            'service', 'gatt', 'profile', 'characteristic',
            'bluetooth', 'ble', 'ble_', '_ble', 'lock', 'unlock',
            'open', 'close', 'door', 'key'
        ]
        
        service_strings = []
        for s in strings:
            s_lower = s.lower()
            if any(keyword in s_lower for keyword in service_keywords):
                if len(s) < 200:  # 过滤太长的字符串
                    service_strings.append(s)
        
        if service_strings:
            print(f"找到 {len(service_strings)} 个服务相关字符串:")
            for s in service_strings[:30]:  # 显示前30个
                print(f"  {s}")
        
        # 3. 搜索蓝牙特征值操作
        print(f"\n=== 蓝牙特征值操作分析 ===")
        characteristic_keywords = [
            'onCharacteristicChanged', 'onCharacteristicWrite',
            'onCharacteristicRead', 'writeCharacteristic',
            'readCharacteristic', 'setCharacteristicNotification',
            'getCharacteristic', 'getService'
        ]
        
        characteristic_methods = []
        for cls in dx.get_classes():
            for method in cls.get_methods():
                method_name = str(method.name)
                if any(keyword in method_name for keyword in characteristic_keywords):
                    characteristic_methods.append((cls.name, method_name))
        
        if characteristic_methods:
            print(f"找到 {len(characteristic_methods)} 个特征值操作方法:")
            for class_name, method_name in characteristic_methods[:20]:
                print(f"  {class_name} -> {method_name}")
        
        # 4. 搜索开锁相关逻辑
        print(f"\n=== 开锁逻辑分析 ===")
        unlock_keywords = [
            'unlock', 'open_lock', 'openlock', 'unlock_door',
            'send_unlock', 'unlock_command', 'unlock_command',
            'open_command', 'unlock_request', 'unlock_response'
        ]
        
        unlock_methods = []
        for cls in dx.get_classes():
            for method in cls.get_methods():
                method_name = str(method.name).lower()
                if any(keyword in method_name for keyword in unlock_keywords):
                    unlock_methods.append((cls.name, method.name))
        
        if unlock_methods:
            print(f"找到 {len(unlock_methods)} 个开锁相关方法:")
            for class_name, method_name in unlock_methods[:20]:
                print(f"  {class_name} -> {method_name}")
        
        # 5. 搜索蓝牙数据格式
        print(f"\n=== 蓝牙数据格式分析 ===")
        data_patterns = [
            r'0x[0-9a-fA-F]{2}',  # 十六进制数据
            r'byte\[\]',  # 字节数组
            r'ByteArray',  # 字节数组
            r'hex',  # 十六进制
            r'encode',  # 编码
            r'decode',  # 解码
            r'encrypt',  # 加密
            r'decrypt',  # 解密
            r'AES',  # AES加密
            r'DES',  # DES加密
            r'RSA',  # RSA加密
        ]
        
        data_strings = []
        for s in strings:
            if any(re.search(pattern, s, re.IGNORECASE) for pattern in data_patterns):
                if len(s) < 100:
                    data_strings.append(s)
        
        if data_strings:
            print(f"找到 {len(data_strings)} 个数据格式相关字符串:")
            for s in data_strings[:20]:
                print(f"  {s}")
        
        # 6. 生成报告
        output_file = apk_path.replace('.apk', '_bluetooth_protocol.txt')
        with open(output_file, 'w', encoding='utf-8') as f:
            f.write("智能门锁蓝牙协议分析报告\n")
            f.write(f"文件: {apk_path}\n")
            f.write(f"包名: {a.get_package()}\n")
            f.write(f"版本: {a.get_androidversion_name()}\n\n")
            
            f.write("蓝牙权限:\n")
            for perm in bluetooth_permissions:
                f.write(f"  - {perm}\n")
            
            f.write(f"\n蓝牙UUID ({len(uuids_found)} 个):\n")
            for uuid in uuids_found:
                f.write(f"  - {uuid}\n")
            
            f.write(f"\n服务相关字符串 ({len(service_strings)} 个):\n")
            for s in service_strings[:50]:
                f.write(f"  - {s}\n")
            
            f.write(f"\n特征值操作方法 ({len(characteristic_methods)} 个):\n")
            for class_name, method_name in characteristic_methods:
                f.write(f"  - {class_name} -> {method_name}\n")
            
            f.write(f"\n开锁相关方法 ({len(unlock_methods)} 个):\n")
            for class_name, method_name in unlock_methods:
                f.write(f"  - {class_name} -> {method_name}\n")
            
            f.write(f"\n数据格式相关字符串 ({len(data_strings)} 个):\n")
            for s in data_strings:
                f.write(f"  - {s}\n")
        
        print(f"\n详细报告已保存到: {output_file}")
        
    except Exception as e:
        print(f"分析APK时出错: {e}")
        import traceback
        traceback.print_exc()

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("用法: python bluetooth_protocol_analyzer.py <apk文件路径>")
        sys.exit(1)
    
    apk_path = sys.argv[1]
    analyze_bluetooth_protocol(apk_path)