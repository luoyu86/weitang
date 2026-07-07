#!/usr/bin/env python3
"""
深入分析智能门锁开锁协议
专注于BluetoothOperation类的openLock方法
"""

import sys
import os
import re
from androguard.misc import AnalyzeAPK

def analyze_openlock_protocol(apk_path):
    """深入分析开锁协议"""
    print(f"深入分析开锁协议: {apk_path}")
    
    if not os.path.exists(apk_path):
        print(f"错误: 文件不存在 {apk_path}")
        return
    
    try:
        # 分析APK
        a, d, dx = AnalyzeAPK(apk_path)
        
        print(f"\n=== 分析BluetoothOperation类 ===")
        
        # 查找BluetoothOperation类
        target_classes = []
        for cls in dx.get_classes():
            class_name = str(cls.name)
            if 'BluetoothOperation' in class_name:
                target_classes.append(cls)
                print(f"找到类: {class_name}")
        
        # 分析每个BluetoothOperation类
        for cls in target_classes:
            print(f"\n--- 分析类: {cls.name} ---")
            
            # 获取所有方法
            methods = list(cls.get_methods())
            print(f"方法数量: {len(methods)}")
            
            # 查找openLock相关方法
            openlock_methods = []
            for method in methods:
                method_name = str(method.name)
                if 'openlock' in method_name.lower() or 'unlock' in method_name.lower():
                    openlock_methods.append(method)
                    print(f"  开锁方法: {method_name}")
            
            # 分析每个开锁方法
            for method in openlock_methods:
                print(f"\n=== 分析方法: {method.name} ===")
                
                # 尝试获取方法的字节码
                try:
                    # 获取方法的源代码（如果可能）
                    code = method.get_code()
                    if code:
                        print(f"  方法有字节码实现")
                        
                        # 分析字节码中的字符串常量
                        print(f"  分析字符串常量...")
                        for const in code.get_bc().get_raw():
                            try:
                                # 尝试解码字节码
                                pass
                            except:
                                pass
                except Exception as e:
                    print(f"  分析方法时出错: {e}")
        
        # 分析CommandUtil类
        print(f"\n=== 分析CommandUtil类 ===")
        command_util_classes = []
        for cls in dx.get_classes():
            class_name = str(cls.name)
            if 'CommandUtil' in class_name:
                command_util_classes.append(cls)
                print(f"找到CommandUtil类: {class_name}")
        
        for cls in command_util_classes:
            print(f"\n--- 分析CommandUtil类: {cls.name} ---")
            methods = list(cls.get_methods())
            print(f"方法数量: {len(methods)}")
            
            # 查找openLock方法
            for method in methods:
                method_name = str(method.name)
                if 'openlock' in method_name.lower():
                    print(f"  找到openLock方法: {method_name}")
        
        # 搜索蓝牙数据格式
        print(f"\n=== 搜索蓝牙数据格式 ===")
        
        # 从DEX文件中提取字符串
        strings = []
        for dex in d:
            try:
                for string_class in dex.get_strings():
                    strings.append(str(string_class))
            except:
                pass
        
        # 搜索可能的命令格式
        command_patterns = [
            r'0x[0-9a-fA-F]{2}',  # 十六进制命令
            r'cmd',  # 命令
            r'command',  # 命令
            r'opcode',  # 操作码
            r'指令',  # 中文指令
            r'开锁',  # 中文开锁
            r'unlock',  # 英文开锁
            r'open',  # 打开
            r'lock',  # 锁
        ]
        
        command_strings = []
        for s in strings:
            if any(re.search(pattern, s, re.IGNORECASE) for pattern in command_patterns):
                if len(s) < 200:  # 过滤太长的字符串
                    command_strings.append(s)
        
        if command_strings:
            print(f"找到 {len(command_strings)} 个命令相关字符串:")
            for s in command_strings[:30]:
                print(f"  {s}")
        
        # 保存详细分析结果
        output_file = apk_path.replace('.apk', '_openlock_analysis.txt')
        with open(output_file, 'w', encoding='utf-8') as f:
            f.write("智能门锁开锁协议深入分析报告\n")
            f.write(f"文件: {apk_path}\n")
            f.write(f"包名: {a.get_package()}\n")
            f.write(f"版本: {a.get_androidversion_name()}\n\n")
            
            f.write("=== BluetoothOperation类分析 ===\n")
            for cls in target_classes:
                f.write(f"类: {cls.name}\n")
                methods = list(cls.get_methods())
                for method in methods:
                    method_name = str(method.name)
                    if 'openlock' in method_name.lower() or 'unlock' in method_name.lower():
                        f.write(f"  - {method_name}\n")
            
            f.write(f"\n=== CommandUtil类分析 ===\n")
            for cls in command_util_classes:
                f.write(f"类: {cls.name}\n")
                methods = list(cls.get_methods())
                for method in methods:
                    method_name = str(method.name)
                    if 'openlock' in method_name.lower():
                        f.write(f"  - {method_name}\n")
            
            f.write(f"\n=== 命令相关字符串 ({len(command_strings)} 个) ===\n")
            for s in command_strings[:50]:
                f.write(f"  - {s}\n")
        
        print(f"\n详细分析报告已保存到: {output_file}")
        
    except Exception as e:
        print(f"分析开锁协议时出错: {e}")
        import traceback
        traceback.print_exc()

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("用法: python openlock_analyzer.py <apk文件路径>")
        sys.exit(1)
    
    apk_path = sys.argv[1]
    analyze_openlock_protocol(apk_path)