#!/usr/bin/env python3
"""
搜索智能门锁协议的具体命令格式
"""

import sys
import os
import re
from androguard.misc import AnalyzeAPK

def search_protocol_details(apk_path):
    """搜索协议的具体细节"""
    print(f"搜索协议细节: {apk_path}")
    
    if not os.path.exists(apk_path):
        print(f"错误: 文件不存在 {apk_path}")
        return
    
    try:
        # 分析APK
        a, d, dx = AnalyzeAPK(apk_path)
        
        print(f"\n=== 搜索协议相关字符串 ===")
        
        # 从DEX文件中提取字符串
        strings = []
        for dex in d:
            try:
                for string_class in dex.get_strings():
                    strings.append(str(string_class))
            except:
                pass
        
        print(f"总字符串数量: {len(strings)}")
        
        # 搜索特定的协议模式
        protocol_patterns = {
            'TLV格式': r'TLV|Type.*Length.*Value',
            '命令格式': r'cmd.*=|command.*=|opcode.*=',
            '蓝牙服务': r'service.*uuid|characteristic.*uuid',
            '加密相关': r'encrypt|decrypt|AES|DES|RSA',
            '认证相关': r'auth|token|key|password|pwd',
            '开锁相关': r'unlock|open.*lock|lock.*open',
            '时间同步': r'time.*sync|utc.*time|timezone',
            '设备信息': r'device.*id|lock.*id|door.*id',
            '状态码': r'status.*code|result.*code|error.*code',
        }
        
        found_patterns = {}
        for pattern_name, pattern in protocol_patterns.items():
            matches = []
            for s in strings:
                if re.search(pattern, s, re.IGNORECASE):
                    if len(s) < 200:  # 过滤太长的字符串
                        matches.append(s)
            if matches:
                found_patterns[pattern_name] = matches[:10]  # 每个模式最多10个
        
        # 显示找到的模式
        for pattern_name, matches in found_patterns.items():
            print(f"\n--- {pattern_name} ({len(matches)} 个) ---")
            for s in matches[:5]:  # 每个模式显示5个
                print(f"  {s}")
        
        # 搜索具体的蓝牙协议字符串
        print(f"\n=== 搜索具体蓝牙协议字符串 ===")
        
        # 搜索可能的协议字符串
        protocol_keywords = [
            'BluetoothResultTLV',
            'performGetPwd',
            'lockTimeZone',
            'lockUtcTime',
            'subCmd',
            'zwaveCommand',
            'openLock',
            'unlock',
            'BleNotOpen',
            'OtaCmd',
            'LockResponse',
            'LockRequest',
            'Command',
            'Response',
        ]
        
        protocol_strings = []
        for s in strings:
            if any(keyword.lower() in s.lower() for keyword in protocol_keywords):
                if len(s) < 300:
                    protocol_strings.append(s)
        
        if protocol_strings:
            print(f"找到 {len(protocol_strings)} 个协议相关字符串:")
            for s in protocol_strings[:20]:
                print(f"  {s}")
        
        # 搜索十六进制数据模式
        print(f"\n=== 搜索十六进制数据模式 ===")
        hex_patterns = [
            r'0x[0-9a-fA-F]{2,}',  # 十六进制数
            r'[0-9a-fA-F]{2}:[0-9a-fA-F]{2}:[0-9a-fA-F]{2}:[0-9a-fA-F]{2}:[0-9a-fA-F]{2}:[0-9a-fA-F]{2}',  # MAC地址
            r'[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}',  # UUID
        ]
        
        hex_strings = []
        for s in strings:
            if any(re.search(pattern, s) for pattern in hex_patterns):
                if len(s) < 100:
                    hex_strings.append(s)
        
        if hex_strings:
            print(f"找到 {len(hex_strings)} 个十六进制数据字符串:")
            for s in hex_strings[:10]:
                print(f"  {s}")
        
        # 保存协议分析结果
        output_file = apk_path.replace('.apk', '_protocol_details.txt')
        with open(output_file, 'w', encoding='utf-8') as f:
            f.write("智能门锁协议细节分析报告\n")
            f.write(f"文件: {apk_path}\n")
            f.write(f"包名: {a.get_package()}\n")
            f.write(f"版本: {a.get_androidversion_name()}\n\n")
            
            f.write("=== 协议模式分析 ===\n")
            for pattern_name, matches in found_patterns.items():
                f.write(f"\n{pattern_name} ({len(matches)} 个):\n")
                for s in matches:
                    f.write(f"  - {s}\n")
            
            f.write(f"\n=== 具体协议字符串 ({len(protocol_strings)} 个) ===\n")
            for s in protocol_strings:
                f.write(f"  - {s}\n")
            
            f.write(f"\n=== 十六进制数据 ({len(hex_strings)} 个) ===\n")
            for s in hex_strings:
                f.write(f"  - {s}\n")
        
        print(f"\n协议细节分析报告已保存到: {output_file}")
        
    except Exception as e:
        print(f"搜索协议细节时出错: {e}")
        import traceback
        traceback.print_exc()

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("用法: python protocol_details.py <apk文件路径>")
        sys.exit(1)
    
    apk_path = sys.argv[1]
    search_protocol_details(apk_path)