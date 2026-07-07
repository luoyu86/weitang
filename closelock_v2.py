#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
智能门锁蓝牙关锁脚本 (v2 - 基于反编译源码精确还原)
====================================================================
关锁协议 (见 CommandUtil.closeLock + BluetoothOperation.closeLock):
  closeLock(randStr, nonce): CommandTlv(31, 9)
      + TLV(100, randStr)     # 锁的挑战值(来自 getRangeCode 响应)
      + TLV(25,  nonce)        # 随机数, app 固定 {4,4,4,4}
  加密密钥 = DATA_SECRET (miyao3), 与开锁一致

完整流程:
  1) getRangeCode({11,11,11,11}) -> 取回 randStr(TLV100)
  2) closeLock(randStr, {4,4,4,4})  -> CommandTlv(31,9)
  3) 锁响应(31,10), TLV(1)=resultCode; 0000 表示成功
"""

import asyncio
import sys
import traceback

# 复用已验证的开锁协议实现
import unlock_v2 as u

from bleak import BleakClient

LOCK_MAC = u.LOCK_MAC
SERVICE_UUID = u.SERVICE_UUID
WRITE_UUID = u.WRITE_UUID
NOTIFY_UUID = u.NOTIFY_UUID
DATA_SECRET = u.DATA_SECRET


def build_close_command(rand_str):
    """构造关锁命令包: CommandTlv(31,9) + TLV(100,randStr) + TLV(25,{4,4,4,4})"""
    return u.build_full_command(
        31, 9,
        [(100, rand_str), (25, bytes([4, 4, 4, 4]))],
        DATA_SECRET)


async def main():
    print("=" * 60)
    print("智能门锁关锁 (v2 - 源码精确协议)")
    print("=" * 60)

    get_range_cmd = u.build_full_command(
        31, 3, [(25, bytes([11, 11, 11, 11]))], DATA_SECRET)
    print(f"\n[构造] 获取随机串命令包 ({len(get_range_cmd)} 字节): {get_range_cmd.hex()}")

    device = await u.scan_lock()
    if not device:
        print("\n无法连接: 门锁不在范围内。请将本机移至门锁附近重试。")
        return

    session = u.LockSession()
    client = None
    last_err = None
    for attempt in range(1, 4):
        try:
            print(f"\n[连接尝试 {attempt}/3] 连接 {LOCK_MAC} ...")
            client = BleakClient(LOCK_MAC, timeout=20.0)
            await client.connect()
            if client.is_connected:
                print(f"  已连接: {client.address}")
                break
            print("  连接返回但未建立，重试...")
        except Exception as e:
            last_err = e
            print(f"  连接失败: {e}")
            traceback.print_exc()
            await asyncio.sleep(2.0)
    if not client or not client.is_connected:
        print(f"\n✗ 无法建立蓝牙连接 (最后错误: {last_err})")
        return

    try:
        await client.start_notify(NOTIFY_UUID, session.on_notify)
        await asyncio.sleep(1.0)

        # 步骤1: 获取随机串
        print("\n--- 步骤1: 发送获取随机串 (CommandTlv 31,3) ---")
        await u.write_split(client, get_range_cmd)

        rand_str = None
        for t in range(40):
            await asyncio.sleep(0.5)
            if session.responses:
                decoded = u.decode_response(bytes(session.responses), DATA_SECRET)
                if decoded and 100 in decoded:
                    rand_str = decoded[100]
                    print(f"\n  ✓ 收到随机串(randStr, TLV100, {len(rand_str)}字节): {rand_str.hex()}")
                    break
                if decoded and 100 not in decoded:
                    print(f"  (已解析响应但无randStr, 当前TLV: {list(decoded.keys())})")
            if t % 10 == 9:
                print(f"  ... 等待响应 ({t+1}/40)")

        if not rand_str:
            print("\n✗ 未获取到随机串，无法构造合法关锁命令。")
            print(f"  累计通知: {bytes(session.responses).hex()}")
            return

        # 清空缓冲, 只保留关锁回包
        session.responses = bytearray()

        # 步骤2: 发送关锁命令
        close_cmd = build_close_command(rand_str)
        print("\n--- 步骤2: 发送关锁命令 (CommandTlv 31,9) ---")
        print(f"  关锁命令包 ({len(close_cmd)} 字节): {close_cmd.hex()}")
        await u.write_split(client, close_cmd)

        print("\n等待关锁响应 ...")
        result = None
        for t in range(30):
            await asyncio.sleep(0.5)
            if session.responses:
                decoded = u.decode_response(bytes(session.responses), DATA_SECRET)
                if decoded:
                    rc = decoded.get(1)
                    print(f"  [响应 TLV] resultCode={rc.hex() if rc else None} "
                          f"nonce={decoded.get(25).hex() if decoded.get(25) else None}")
                    if rc == b"\x00\x00":
                        result = "success"
                        break
                    if rc is not None and rc != b"\x00\x00":
                        result = f"fail({rc.hex()})"
                        # 继续等, 防止误判
            if t % 10 == 9:
                print(f"  ... 等待结果 ({t+1}/30)")

        print("\n" + "=" * 60)
        if result == "success":
            print("✓✓✓ 关锁成功! (resultCode = 0000)")
            print("  门锁已重新锁定，请确认门已关好。")
        elif result and result.startswith("fail"):
            print(f"✗ 关锁被锁拒绝: {result}")
            print(f"  累计通知: {bytes(session.responses).hex()}")
        else:
            print("? 已发送关锁命令，但未检测到明确结果码。")
            print(f"  累计通知: {bytes(session.responses).hex()}")
            print("  请现场确认门锁状态。")
        print("=" * 60)

    except Exception as e:
        print(f"\n连接/通信错误: {e}")
        traceback.print_exc()
    finally:
        try:
            await client.disconnect()
        except Exception:
            pass


if __name__ == "__main__":
    asyncio.run(main())
