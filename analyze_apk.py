#!/usr/bin/env python3
"""
APK蓝牙协议分析工具
用于分析智能门锁APP的蓝牙通信协议
"""

import sys
import os
from androguard.core.apk import APK
from androguard.core.dex import DEX
from androguard.misc import AnalyzeAPK

def analyze_apk(apk_path):
    """分析APK文件，提取蓝牙相关信息"""
    print(f"分析APK文件: {apk_path}")
    
    # 检查文件是否存在
    if not os.path.exists(apk_path):
        print(f"错误: 文件不存在 {apk_path}")
        return
    
    try:
        # 分析APK
        a, d, dx = AnalyzeAPK(apk_path)
        
        print(f"\n=== APK基本信息 ===")
        print(f"包名: {a.get_package()}")
        print(f"版本: {a.get_androidversion_name()}")
        print(f"最小SDK: {a.get_min_sdk_version()}")
        print(f"目标SDK: {a.get_target_sdk_version()}")
        
        # 检查蓝牙权限
        print(f"\n=== 蓝牙权限 ===")
        permissions = a.get_permissions()
        bluetooth_permissions = [p for p in permissions if 'bluetooth' in p.lower()]
        if bluetooth_permissions:
            for perm in bluetooth_permissions:
                print(f"  ✓ {perm}")
        else:
            print("  未发现蓝牙权限")
        
        # 搜索蓝牙相关的类和方法
        print(f"\n=== 蓝牙相关代码分析 ===")
        
        # 蓝牙关键词
        bluetooth_keywords = [
            'BluetoothGatt', 'BluetoothDevice', 'BluetoothAdapter',
            'BluetoothSocket', 'BluetoothServerSocket',
            'BluetoothProfile', 'BluetoothManager',
            'BLE', 'GATT', 'UUID', 'characteristic',
            'service', 'notify', 'write', 'read',
            'onCharacteristicChanged', 'onCharacteristicWrite',
            'connect', 'disconnect', 'discoverServices'
        ]
        
        # 搜索包含蓝牙关键词的类
        bluetooth_classes = []
        for cls in dx.get_classes():
            class_name = str(cls.name)
            if any(keyword.lower() in class_name.lower() for keyword in bluetooth_keywords):
                bluetooth_classes.append(cls)
        
        print(f"找到 {len(bluetooth_classes)} 个蓝牙相关类")
        
        # 显示前10个蓝牙相关类
        for i, cls in enumerate(bluetooth_classes[:10]):
            print(f"\n--- 类 {i+1}: {cls.name} ---")
            
            # 获取类的方法
            methods = list(cls.get_methods())[:5]  # 转换为列表并取前5个
            for method in methods:
                print(f"  方法: {method.name}")
                
                # 尝试获取方法的源代码（如果可能）
                try:
                    # 这里可以进一步分析方法的字节码
                    pass
                except:
                    pass
        
        # 搜索蓝牙UUID
        print(f"\n=== 蓝牙UUID搜索 ===")
        uuid_pattern = r'[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}'
        
        # 在字符串中搜索UUID
        strings = a.get_strings()
        uuids_found = []
        for s in strings:
            if 'uuid' in s.lower() or 'UUID' in s:
                uuids_found.append(s)
        
        if uuids_found:
            print(f"找到 {len(uuids_found)} 个UUID相关字符串:")
            for uuid_str in uuids_found[:10]:
                print(f"  {uuid_str}")
        else:
            print("未找到明显的UUID字符串")
        
        # 搜索蓝牙服务
        print(f"\n=== 蓝牙服务搜索 ===")
        service_keywords = ['service', 'gatt', 'profile', 'characteristic']
        services_found = []
        
        for s in strings:
            if any(keyword in s.lower() for keyword in service_keywords):
                if len(s) < 100:  # 过滤掉太长的字符串
                    services_found.append(s)
        
        if services_found:
            print(f"找到 {len(services_found)} 个服务相关字符串:")
            for service_str in services_found[:10]:
                print(f"  {service_str}")
        
        # 保存分析结果
        output_file = apk_path.replace('.apk', '_analysis.txt')
        with open(output_file, 'w', encoding='utf-8') as f:
            f.write(f"APK蓝牙协议分析报告\n")
            f.write(f"文件: {apk_path}\n")
            f.write(f"包名: {a.get_package()}\n")
            f.write(f"版本: {a.get_androidversion_name()}\n\n")
            
            f.write("蓝牙权限:\n")
            for perm in bluetooth_permissions:
                f.write(f"  - {perm}\n")
            
            f.write(f"\n蓝牙相关类 ({len(bluetooth_classes)} 个):\n")
            for cls in bluetooth_classes[:20]:
                f.write(f"  - {cls.name}\n")
            
            f.write(f"\nUUID相关字符串 ({len(uuids_found)} 个):\n")
            for uuid_str in uuids_found[:20]:
                f.write(f"  - {uuid_str}\n")
        
        print(f"\n分析结果已保存到: {output_file}")
        
    except Exception as e:
        print(f"分析APK时出错: {e}")
        import traceback
        traceback.print_exc()

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("用法: python analyze_apk.py <apk文件路径>")
        sys.exit(1)
    
    apk_path = sys.argv[1]
    analyze_apk(apk_path)