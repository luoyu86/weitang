#!/usr/bin/env python3
"""
修改APK，添加显示登录信息的功能
"""

import sys
import os
import shutil
from androguard.misc import AnalyzeAPK

def modify_apk(apk_path, output_path):
    """修改APK，添加显示登录信息的代码"""
    print(f"修改APK: {apk_path}")
    
    if not os.path.exists(apk_path):
        print(f"错误: 文件不存在 {apk_path}")
        return
    
    try:
        # 复制APK文件
        shutil.copy2(apk_path, output_path)
        print(f"已复制APK到: {output_path}")
        
        # 分析APK
        a, d, dx = AnalyzeAPK(apk_path)
        
        print(f"\n=== APK信息 ===")
        print(f"包名: {a.get_package()}")
        print(f"版本: {a.get_androidversion_name()}")
        
        # 查找需要修改的类
        print(f"\n=== 查找关键类 ===")
        
        # 查找BaseModel类中的saveToken方法
        target_class = None
        for cls in dx.get_classes():
            class_name = str(cls.name)
            if 'BaseModel' in class_name and 'saveToken' in str([m.name for m in cls.get_methods()]):
                target_class = cls
                print(f"找到目标类: {class_name}")
                break
        
        if target_class:
            print(f"\n=== 分析saveToken方法 ===")
            # 查找saveToken方法
            for method in target_class.get_methods():
                if 'saveToken' in str(method.name):
                    print(f"找到方法: {method.name}")
                    # 这里可以进一步分析方法实现
        
        # 生成修改说明
        print(f"\n=== 修改说明 ===")
        print("由于androguard无法直接修改Java代码，建议使用以下方法：")
        print("1. 使用jadx-gui查看代码")
        print("2. 找到saveToken方法")
        print("3. 添加以下代码：")
        print("""
// 在saveToken方法中添加：
android.widget.Toast.makeText(
    c.e.a.a.b.getInstance().getContext(), 
    "Token: " + str, 
    android.widget.Toast.LENGTH_LONG
).show();

// 或者复制到剪贴板：
android.content.ClipboardManager clipboard = 
    (android.content.ClipboardManager) c.e.a.a.b.getInstance().getContext()
        .getSystemService(android.content.Context.CLIPBOARD_SERVICE);
clipboard.setPrimaryClip(
    android.content.CllipData.newPlainText("token", str)
);
        """)
        
        print(f"\n=== 输出文件 ===")
        print(f"原始APK: {apk_path}")
        print(f"建议使用jadx-gui手动修改后重新打包")
        
    except Exception as e:
        print(f"修改APK时出错: {e}")
        import traceback
        traceback.print_exc()

if __name__ == "__main__":
    if len(sys.argv) < 3:
        print("用法: python modify_apk.py <输入APK> <输出APK>")
        sys.exit(1)
    
    apk_path = sys.argv[1]
    output_path = sys.argv[2]
    modify_apk(apk_path, output_path)