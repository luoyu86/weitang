#!/usr/bin/env python3
"""
智能门锁APP登录脚本（命令行参数版）
使用方法: python login_sms.py <手机号> <验证码>
"""

import requests
import json
import base64
import sys
from Crypto.Cipher import PKCS1_v1_5
from Crypto.PublicKey import RSA

# API基础URL
BASE_URL = "https://n-rent-vtown-app.yuanjingweitang.com/server-api"

# 公钥接口返回的secretKey
SECRET_KEY_HEADER = "Q611KlggYabS2RQMGe0gLrVdjyw7Onhd0Wb6//DKAbJF2I/D9Kc4pwOT6pCFRLJbw533j7OroKiDX5qTE03KFqFs+b2pEOmScGBDZXWk6EitBgS1oneAdvLqmkEY98sX+xH6e5T9Sr7fnTatysq53kTEWX/tCsvhJGmmskk3bt6xZ4sbB0FLknnRbyZgQA6bZf5upDnvqiqVSxPGNMGKHNRYuQKP2cqp0NgO9EOiLd0=cvdata_separatorEEuGXxFbBti/U5Cnw4EViM2HT6cp6jqTmGdW8n4Kwepv5EL23XjV4tcth2gE0+E33vnA6iUuk0MIPW/g24Cwvg=="

def encrypt_with_rsa(data, public_key_b64):
    """使用RSA公钥加密数据"""
    try:
        public_key_der = base64.b64decode(public_key_b64)
        rsa_key = RSA.import_key(public_key_der)
        cipher = PKCS1_v1_5.new(rsa_key)
        encrypted = cipher.encrypt(data.encode('utf-8'))
        return base64.b64encode(encrypted).decode('utf-8')
    except Exception as e:
        print(f"加密失败: {e}")
        return None

def get_public_key_and_token():
    """获取公钥和token"""
    url = f"{BASE_URL}/uas-2/v1/uas/security"
    headers = {"Content-Type": "application/json", "secretKey": SECRET_KEY_HEADER}
    response = requests.post(url, json={}, headers=headers, timeout=10)
    result = response.json()
    return result.get("token"), result.get("publicSecurityCode")

def send_sms_code(phone, token, public_key):
    """发送短信验证码"""
    url = f"{BASE_URL}/vtapp/v1/frameworks/systems/user/send/verification/code"
    params = {"phone": phone, "identityType": "phone"}
    encrypted = encrypt_with_rsa(json.dumps(params), public_key)
    headers = {"Content-Type": "application/json", "Token": token}
    response = requests.post(url, json={"data": encrypted}, headers=headers, timeout=10)
    return response.json()

def login_with_sms(phone, sms_code, token, public_key):
    """使用短信验证码登录"""
    url = f"{BASE_URL}/vtapp/v1/frameworks/systems/user/app/login"
    params = {"identifier": phone, "credential": sms_code, "identityType": "phone"}
    encrypted = encrypt_with_rsa(json.dumps(params), public_key)
    headers = {"Content-Type": "application/json", "Token": token}
    response = requests.post(url, json={"data": encrypted}, headers=headers, timeout=10)
    result = response.json()
    return result.get("data", {}).get("token") if result.get("success") else None

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("使用方法:")
        print("  步骤1: python login_sms.py send <手机号>")
        print("  步骤2: python login_sms.py login <手机号> <验证码>")
        sys.exit(1)
    
    action = sys.argv[1]
    
    if action == "send":
        phone = sys.argv[2]
        token, public_key = get_public_key_and_token()
        result = send_sms_code(phone, token, public_key)
        print(f"发送结果: {json.dumps(result, ensure_ascii=False)}")
    
    elif action == "login":
        phone = sys.argv[2]
        sms_code = sys.argv[3]
        token, public_key = get_public_key_and_token()
        login_token = login_with_sms(phone, sms_code, token, public_key)
        if login_token:
            print(f"\n登录成功！")
            print(f"Token: {login_token}")
            with open("token.txt", "w") as f:
                f.write(login_token)
            print("Token已保存到 token.txt")
        else:
            print("登录失败")