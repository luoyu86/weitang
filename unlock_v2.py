#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
智能门锁蓝牙开锁脚本 (v2 - 基于反编译源码精确还原)
====================================================================
已根据 weitangAPP 反编译源码精确还原协议：

加密: TEA(16轮), 密钥与数据均为 BIG-ENDIAN 32位整数
外层帧: [tag(2字节BE), length(2字节BE), payload, XOR(1字节)]
  - tag = (cmd_type<<8) | cmd_code
  - length = payload(所有TLV单元) 的总长度
  - 末尾1字节为 XOR 校验 (= 除末字节外所有字节的异或)

命令构造 (见 CommandUtil.java):
  getRangeCode(d):  CommandTlv(31,3) + TLV(25, d)
  openLock(u,r,n,a):CommandTlv(31,7) + TLV(101,u) + TLV(100,r) + TLV(25,n) + TLV(66,a)
  iamMiLockCode(e): CommandTlv(106,1) + TLV(29, e)   # e = TEA加密后的内层命令

发送流程 (getCommunicationPackage):
  1) 内层命令 TLV 末尾补 XOR 占位字节 -> 计算 XOR 填入
  2) 用 DATA_SECRET 做 TEA 加密
  3) 包进 iamMiLockCode(106,1)[TLV 29] -> 末尾补 XOR -> 填入
  4) 写 WRITE_UUID

响应 (subPackageOnce / getBluetoothResultTLV):
  锁返回外层 [106,1] (或 [31,2])，payload 含 TLV(29)=TEA密文；
  解密后得到内层命令 TLV，其中 TLV(100)=randStr(随机串/挑战值)，
  TLV(25)=randNum。开锁命令的 TLV(100) 必须填回锁返回的 randStr。
  开锁成功响应中包含 EE08。
"""

import asyncio
import sys
import traceback

try:
    from bleak import BleakClient, BleakScanner
except ImportError:
    sys.exit("请先安装 bleak: pip install bleak")

# ---------------- 门锁与密钥配置 ----------------
LOCK_MAC = "1E:98:6C:02:A7:77"
SERVICE_UUID = "000018f0-0000-1000-8000-00805f9b34fb"
WRITE_UUID = "00002af1-0000-1000-8000-00805f9b34fb"
NOTIFY_UUID = "00002af0-0000-1000-8000-00805f9b34fb"

DATA_SECRET = bytes.fromhex("DBCCB54D6E2E655958FF9E29CBF8A764")   # miyao3 加密密钥
USER_KEY = bytes.fromhex("0F80D3A7AF16E51B5BAA1A829A144B04C9878901EB6377ACB525214E3820E0D2")  # TLV 101

# ---------------- TEA (big-endian, 标准delta) ----------------
MASK = 0xFFFFFFFF
DELTA = 0x9E3779B9


def _tea_enc_block(v0, v1, k, rounds):
    s = 0
    for _ in range(rounds):
        s = (s + DELTA) & MASK
        v0 = (v0 + (((v1 << 4) + k[0]) ^ (v1 + s) ^ ((v1 >> 5) + k[1]))) & MASK
        v1 = (v1 + (((v0 << 4) + k[2]) ^ (v0 + s) ^ ((v0 >> 5) + k[3]))) & MASK
    return v0, v1


def _tea_dec_block(v0, v1, k, rounds):
    s = (DELTA * rounds) & MASK
    for _ in range(rounds):
        v1 = (v1 - (((v0 << 4) + k[2]) ^ (v0 + s) ^ ((v0 >> 5) + k[3]))) & MASK
        v0 = (v0 - (((v1 << 4) + k[0]) ^ (v1 + s) ^ ((v1 >> 5) + k[1]))) & MASK
        s = (s - DELTA) & MASK
    return v0, v1


def tea_encrypt(data, key, rounds=16):
    pad_len = 8 - (len(data) % 8)
    if pad_len == 0:
        pad_len = 8
    padded = data + bytes([pad_len]) * pad_len
    k = [int.from_bytes(key[i:i + 4], "big") for i in range(0, 16, 4)]
    out = b""
    for i in range(0, len(padded), 8):
        v0 = int.from_bytes(padded[i:i + 4], "big")
        v1 = int.from_bytes(padded[i + 4:i + 8], "big")
        v0, v1 = _tea_enc_block(v0, v1, k, rounds)
        out += v0.to_bytes(4, "big") + v1.to_bytes(4, "big")
    return out


def tea_decrypt(data, key, rounds=16):
    k = [int.from_bytes(key[i:i + 4], "big") for i in range(0, 16, 4)]
    out = b""
    for i in range(0, len(data), 8):
        v0 = int.from_bytes(data[i:i + 4], "big")
        v1 = int.from_bytes(data[i + 4:i + 8], "big")
        v0, v1 = _tea_dec_block(v0, v1, k, rounds)
        out += v0.to_bytes(4, "big") + v1.to_bytes(4, "big")
    pad_len = out[-1]
    if 1 <= pad_len <= 8:
        out = out[:-pad_len]
    return out


def xor_code(data):
    r = 0
    for b in data:
        r ^= b
    return r & 0xFF


# ---------------- TLV 构造 ----------------
def build_tlv_unit(tag, value):
    # TlvByteUnit: [tag(2 BE), length(2 BE), value]
    return tag.to_bytes(2, "big") + len(value).to_bytes(2, "big") + value


def build_full_command(cmd_type, cmd_code, units, key, is_super=False):
    """构造完整通信包 (内层命令 + TEA + 外层 106 包装 + XOR)"""
    inner_units = b"".join(build_tlv_unit(t, v) for t, v in units)
    inner_tag = (cmd_type * 256 + cmd_code)
    inner_len = len(inner_units)
    inner = inner_tag.to_bytes(2, "big") + inner_len.to_bytes(2, "big") + inner_units
    # 内层 XOR 占位 + 计算
    inner = inner + b"\x00"
    inner = inner[:-1] + bytes([xor_code(inner[:-1])])
    # TEA 加密 (含 XOR 字节)
    encrypted = tea_encrypt(inner, key, 16)
    # 外层 iamMiLockCode(106,1/3)[TLV 29]
    outer_units = build_tlv_unit(29, encrypted)
    outer_tag = (106 * 256 + (3 if is_super else 1))
    outer_len = len(outer_units)
    outer = outer_tag.to_bytes(2, "big") + outer_len.to_bytes(2, "big") + outer_units
    # 外层 XOR
    outer = outer + b"\x00"
    outer = outer[:-1] + bytes([xor_code(outer[:-1])])
    return outer


# ---------------- TLV 解析 ----------------
def parse_tlv_units(data):
    result = {}
    i = 0
    while i + 4 <= len(data):
        tag = (data[i] << 8) | data[i + 1]
        length = (data[i + 2] << 8) | data[i + 3]
        if i + 4 + length > len(data):
            break
        result[tag] = data[i + 4:i + 4 + length]
        i += 4 + length
    return result


VALID_TAGS = {(106, 1), (106, 2), (106, 3), (106, 4), (31, 2)}


def decode_response(raw, key):
    """从累计通知字节中找出一个完整外层包并解密，返回内层 TLV 字典或 None"""
    i = 0
    while i + 5 <= len(raw):
        tag = (raw[i] << 8) | raw[i + 1]
        if (raw[i], raw[i + 1]) in VALID_TAGS:
            length = (raw[i + 2] << 8) | raw[i + 3]
            pkg_end = i + 4 + length + 1
            if len(raw) < pkg_end:
                return None  # 还不完整
            pkg = raw[i:pkg_end]
            if xor_code(pkg[:-1]) != pkg[-1]:
                i += 1
                continue
            payload = pkg[4:4 + length]
            units = parse_tlv_units(payload)
            if 29 in units:  # 加密响应
                inner = tea_decrypt(units[29], key, 16)
                if xor_code(inner[:-1]) == inner[-1]:
                    inner_units = parse_tlv_units(inner[4:-1])
                    return inner_units
                return None
            elif 100 in units or 25 in units:  # 明文响应
                return units
            return units
        i += 1
    return None


# ---------------- BLE 交互 ----------------
class LockSession:
    def __init__(self):
        self.responses = bytearray()
        self.ready = asyncio.Event()

    def on_notify(self, char, data):
        self.responses.extend(data)
        print(f"  [通知] {data.hex()}")
        self.ready.set()


async def scan_lock():
    print("扫描蓝牙设备 ...")
    devs = await BleakScanner.discover(timeout=8)
    for d in devs:
        name = d.name or "未知"
        print(f"  {d.address} - {name}")
        if d.address.upper() == LOCK_MAC.upper():
            print(f"  *** 找到目标门锁: {d.address} ***")
            return d
    print("未找到目标门锁 (请确认在范围内且蓝牙已开启)")
    return None


async def main():
    print("=" * 60)
    print("智能门锁开锁 (v2 - 源码精确协议)")
    print("=" * 60)

    # 1) 构造并打印命令字节 (即使无BLE也可核对)
    get_range_cmd = build_full_command(
        31, 3, [(25, bytes([11, 11, 11, 11]))], DATA_SECRET)
    print(f"\n[构造] 获取随机串命令包 ({len(get_range_cmd)} 字节):")
    print(f"  {get_range_cmd.hex()}")

    # 2) 扫描 + 连接
    device = await scan_lock()
    if not device:
        print("\n无法连接: 门锁不在范围内。脚本已就绪，请将本机移至门锁附近重试。")
        return

    session = LockSession()
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
            else:
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

        # 3) 发送获取随机串
        print("\n--- 步骤1: 发送获取随机串 (CommandTlv 31,3) ---")
        await write_split(client, get_range_cmd)

        # 等待响应
        rand_str = None
        for t in range(40):
            await asyncio.sleep(0.5)
            if session.responses:
                decoded = decode_response(bytes(session.responses), DATA_SECRET)
                if decoded and 100 in decoded:
                    rand_str = decoded[100]
                    print(f"\n  ✓ 收到随机串(randStr, TLV100, {len(rand_str)}字节): {rand_str.hex()}")
                    break
                if decoded and 100 not in decoded:
                    print(f"  (已解析响应但无randStr, 当前TLV: {list(decoded.keys())})")
            if t % 10 == 9:
                print(f"  ... 等待响应 ({t+1}/40)")

        if not rand_str:
            print("\n✗ 未获取到随机串，无法构造合法开锁命令。")
            print(f"  累计通知: {bytes(session.responses).hex()}")
            return

        # 4) 发送开锁命令 (使用真实随机串)
        print("\n--- 步骤2: 发送开锁命令 (CommandTlv 31,7) ---")
        open_cmd = build_full_command(
            31, 7,
            [(101, USER_KEY), (100, rand_str),
             (25, bytes([3, 3, 3, 3])), (66, bytes([0]))],
            DATA_SECRET)
        print(f"  开锁命令包 ({len(open_cmd)} 字节): {open_cmd.hex()}")
        await write_split(client, open_cmd)

        # 等待开锁结果
        print("\n等待开锁响应 ...")
        for t in range(30):
            await asyncio.sleep(0.5)
            raw = bytes(session.responses)
            if "ee08" in raw.hex().lower():
                print("\n✓✓✓ 门锁返回 EE08 —— 开锁成功!")
                print(f"  完整响应: {raw.hex()}")
                return
            if t % 10 == 9:
                print(f"  ... 等待结果 ({t+1}/30)")

        print("\n? 已发送开锁命令，但未检测到 EE08 成功标志。")
        print(f"  累计通知: {bytes(session.responses).hex()}")

    except Exception as e:
        print(f"\n连接/通信错误: {e}")
        traceback.print_exc()
    finally:
        try:
            await client.disconnect()
        except Exception:
            pass


async def write_split(client, data, chunk=20, delay=0.05):
    """分包写入 (write-without-response)，模拟 app 的 MTU 分包"""
    for i in range(0, len(data), chunk):
        await client.write_gatt_char(WRITE_UUID, data[i:i + chunk], response=False)
        await asyncio.sleep(delay)
    print(f"  已发送 {len(data)} 字节 (分 { (len(data)+chunk-1)//chunk } 包)")


if __name__ == "__main__":
    # 自检: TEA 加解密必须可逆
    _t = b"HELLO\x03\x03\x03"
    assert tea_decrypt(tea_encrypt(_t, DATA_SECRET), DATA_SECRET) == _t, "TEA 自检失败"
    asyncio.run(main())
