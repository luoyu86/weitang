#!/usr/bin/env python3
"""
智能门锁APP登录脚本
直接调用API获取登录token
"""

import requests
import json
import base64
import hashlib
from Crypto.Cipher import PKCS1_v1_5
from Crypto.PublicKey import RSA
import binascii

# API基础URL（从反编译代码中获取）
BASE_URL = "https://n-rent-vtown-app.yuanjingweitang.com/server-api"

# 公钥接口返回的secretKey（从APP代码中提取）
SECRET_KEY_HEADER = "Q611KlggYabS2RQMGe0gLrVdjyw7Onhd0Wb6//DKAbJF2I/D9Kc4pwOT6pCFRLJbw533j7OroKiDX5qTE03KFqFs+b2pEOmScGBDZXWk6EitBgS1oneAdvLqmkEY98sX+xH6e5T9Sr7fnTatysq53kTEWX/tCsvhJGmmskk3bt6xZ4sbB0FLknnRbyZgQA6bZf5upDnvqiqVSxPGNMGKHNRYuQKP2cqp0NgO9EOiLd0=cvdata_separatorEEuGXxFbBti/U5Cnw4EViM2HT6cp6jqTmGdW8n4Kwepv5EL23XjV4tcth2gE0+E33vnA6iUuk0MIPW/g24Cwvg=="

def get_public_key_and_token():
    """步骤1：获取公钥和token"""
    print("[1/4] 获取公钥和token...")
    
    url = f"{BASE_URL}/uas-2/v1/uas/security"
    headers = {
        "Content-Type": "application/json",
        "secretKey": SECRET_KEY_HEADER
    }
    data = {}
    
    try:
        response = requests.post(url, json=data, headers=headers, timeout=10)
        result = response.json()
        print(f"  响应: {json.dumps(result, indent=2)}")
        
        if result.get("code") == "21015" or result.get("success"):
            token = result.get("token")
            public_key = result.get("publicSecurityCode")
            key = result.get("key")
            return token, public_key, key
        else:
            print(f"  获取失败: {result}")
            return None, None, None
    except Exception as e:
        print(f"  请求失败: {e}")
        return None, None, None

def encrypt_with_rsa(data, public_key_b64):
    """使用RSA公钥加密数据"""
    try:
        # 解码公钥
        public_key_der = base64.b64decode(public_key_b64)
        
        # 构建RSA公钥对象
        rsa_key = RSA.import_key(public_key_der)
        
        # 使用PKCS1_v1_5加密
        cipher = PKCS1_v1_5.new(rsa_key)
        encrypted = cipher.encrypt(data.encode('utf-8'))
        
        return base64.b64encode(encrypted).decode('utf-8')
    except Exception as e:
        print(f"  加密失败: {e}")
        return None

def send_sms_code(phone, token, public_key):
    """步骤2：发送短信验证码"""
    print(f"\n[2/4] 发送短信验证码到 {phone}...")
    
    url = f"{BASE_URL}/vtapp/v1/frameworks/systems/user/send/verification/code"
    
    # 构建请求参数（只有phone字段）
    params = {
        "phone": phone
    }
    
    # 加密参数
    encrypted_params = encrypt_with_rsa(json.dumps(params), public_key)
    if not encrypted_params:
        print("  加密失败")
        return False
    
    headers = {
        "Content-Type": "application/json",
        "Token": token
    }
    
    try:
        # 直接发送加密后的字符串作为请求体
        response = requests.post(url, data=encrypted_params, headers=headers, timeout=10)
        result = response.json()
        print(f"  响应: {json.dumps(result, indent=2)}")
        
        if result.get("success"):
            print("  验证码发送成功！")
            return True
        else:
            print(f"  发送失败: {result}")
            return False
    except Exception as e:
        print(f"  请求失败: {e}")
        return False

def login_with_sms(phone, sms_code, token, public_key):
    """步骤3：使用短信验证码登录"""
    print(f"\n[3/4] 使用短信验证码登录...")
    
    url = f"{BASE_URL}/vtapp/v1/frameworks/systems/user/app/login"
    
    # 构建登录参数
    login_params = {
        "identifier": phone,
        "credential": sms_code,
        "code": sms_code,
        "identityType": "phone",
        "extend": {
            "deviceType": "android",
            "source": 1
        }
    }
    
    # 加密参数
    encrypted_params = encrypt_with_rsa(json.dumps(login_params), public_key)
    if not encrypted_params:
        print("  加密失败")
        return None
    
    headers = {
        "Content-Type": "application/json",
        "Token": token
    }
    
    try:
        # 直接发送加密后的字符串作为请求体
        response = requests.post(url, data=encrypted_params, headers=headers, timeout=10)
        result = response.json()
        print(f"  响应: {json.dumps(result, indent=2)}")
        
        if result.get("success"):
            login_token = result.get("data", {}).get("token") or result.get("token")
            print(f"  登录成功！Token: {login_token}")
            return login_token
        else:
            print(f"  登录失败: {result}")
            return None
    except Exception as e:
        print(f"  请求失败: {e}")
        return None

def main():
    print("=" * 50)
    print("智能门锁APP登录脚本")
    print("=" * 50)
    
    # 获取手机号
    phone = input("\n请输入手机号: ").strip()
    if not phone:
        print("手机号不能为空")
        return
    
    # 步骤1：获取公钥和token
    token, public_key, key = get_public_key_and_token()
    if not token or not public_key:
        print("获取公钥失败，请检查网络连接")
        return
    
    print(f"  Token: {token[:20]}...")
    print(f"  公钥: {public_key[:20]}...")
    
    # 步骤2：发送短信验证码
    if not send_sms_code(phone, token, public_key):
        return
    
    # 等待用户输入验证码
    sms_code = input("\n请输入收到的短信验证码: ").strip()
    if not sms_code:
        print("验证码不能为空")
        return
    
    # 步骤3：登录
    login_token = login_with_sms(phone, sms_code, token, public_key)
    if login_token:
        print("\n" + "=" * 50)
        print("登录成功！")
        print(f"Token: {login_token}")
        print("=" * 50)
        
        # 保存token到文件
        with open("token.txt", "w") as f:
            f.write(login_token)
        print("\nToken已保存到 token.txt")

if __name__ == "__main__":
    main()