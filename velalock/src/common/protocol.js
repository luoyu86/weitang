// protocol.js — 微棠智能门锁协议 (Vela 快应用版)
// 与 unlock_v2.py / Kotlin LockProtocol 字节级一致；纯 JS，可用 Node 直接测试。
//
// 加密: TEA(16轮, delta=0x9E3779B9), 密钥与数据均为 BIG-ENDIAN 32位整数
// 外层帧: [tag(2B BE), length(2B BE), payload, XOR(1B)]
//   tag = (cmd_type<<8)|cmd_code
// 命令:
//   getRangeCode : CommandTlv(31,3) + TLV(25,{11,11,11,11})
//   openLock     : CommandTlv(31,7) + TLV(101,用户密钥) + TLV(100,随机串) + TLV(25,{3,3,3,3}) + TLV(66,自动锁)
//   closeLock    : CommandTlv(31,9) + TLV(100,随机串) + TLV(25,{4,4,4,4})

const DELTA = 0x9e3779b9 >>> 0;
const ROUNDS = 16;
const BLOCK = 8;

function readIntBE(b, off) {
  return (
    ((b[off] & 0xff) << 24) |
    ((b[off + 1] & 0xff) << 16) |
    ((b[off + 2] & 0xff) << 8) |
    (b[off + 3] & 0xff)
  ) >>> 0;
}

function writeIntBE(b, off, v) {
  b[off] = (v >>> 24) & 0xff;
  b[off + 1] = (v >>> 16) & 0xff;
  b[off + 2] = (v >>> 8) & 0xff;
  b[off + 3] = v & 0xff;
}

export function hexToBytes(hex) {
  const s = hex.replace(/\s/g, "");
  const out = new Uint8Array(s.length / 2);
  for (let i = 0; i < out.length; i++) {
    out[i] = parseInt(s.substr(i * 2, 2), 16);
  }
  return out;
}

export function bytesToHex(bytes) {
  let s = "";
  for (let i = 0; i < bytes.length; i++) s += (bytes[i] & 0xff).toString(16).padStart(2, "0");
  return s;
}

export function xorOf(data) {
  let x = 0;
  for (let i = 0; i < data.length; i++) x ^= data[i] & 0xff;
  return x & 0xff;
}

function pkcs7Pad(data, block) {
  const rem = data.length % block;
  const pad = rem === 0 ? block : block - rem;
  const out = new Uint8Array(data.length + pad);
  out.set(data, 0);
  for (let i = data.length; i < out.length; i++) out[i] = pad;
  return out;
}

// TEA 加密 (big-endian, 标准 delta, 16 轮)
export function teaEncrypt(data, key) {
  const padded = pkcs7Pad(data, BLOCK);
  const out = new Uint8Array(padded.length);
  const k = [readIntBE(key, 0), readIntBE(key, 4), readIntBE(key, 8), readIntBE(key, 12)];
  let off = 0;
  while (off + BLOCK <= padded.length) {
    let v0 = readIntBE(padded, off) >>> 0;
    let v1 = readIntBE(padded, off + 4) >>> 0;
    let sum = 0;
    for (let i = 0; i < ROUNDS; i++) {
      sum = (sum + DELTA) >>> 0;
      const k0 = k[0] >>> 0, k1 = k[1] >>> 0, k2 = k[2] >>> 0, k3 = k[3] >>> 0;
      v0 = (v0 + ((((v1 << 4) >>> 0) + k0) ^ (v1 + sum) ^ ((v1 >>> 5) + k1))) >>> 0;
      v1 = (v1 + ((((v0 << 4) >>> 0) + k2) ^ (v0 + sum) ^ ((v0 >>> 5) + k3))) >>> 0;
    }
    writeIntBE(out, off, v0);
    writeIntBE(out, off + 4, v1);
    off += BLOCK;
  }
  return out;
}

// TEA 解密
export function teaDecrypt(data, key) {
  const out = new Uint8Array(data.length);
  const k = [readIntBE(key, 0), readIntBE(key, 4), readIntBE(key, 8), readIntBE(key, 12)];
  let off = 0;
  while (off + BLOCK <= data.length) {
    let v0 = readIntBE(data, off) >>> 0;
    let v1 = readIntBE(data, off + 4) >>> 0;
    let sum = (DELTA * ROUNDS) >>> 0;
    for (let i = 0; i < ROUNDS; i++) {
      const k0 = k[0] >>> 0, k1 = k[1] >>> 0, k2 = k[2] >>> 0, k3 = k[3] >>> 0;
      v1 = (v1 - ((((v0 << 4) >>> 0) + k2) ^ (v0 + sum) ^ ((v0 >>> 5) + k3))) >>> 0;
      v0 = (v0 - ((((v1 << 4) >>> 0) + k0) ^ (v1 + sum) ^ ((v1 >>> 5) + k1))) >>> 0;
      sum = (sum - DELTA) >>> 0;
    }
    writeIntBE(out, off, v0);
    writeIntBE(out, off + 4, v1);
    off += BLOCK;
  }
  // PKCS7 去填充 (与 Python tea_decrypt 一致)
  const padLen = out[out.length - 1] & 0xff;
  if (padLen >= 1 && padLen <= BLOCK) {
    return out.slice(0, out.length - padLen);
  }
  return out;
}

export function buildTlv(tag, value) {
  const out = new Uint8Array(4 + value.length);
  out[0] = (tag >>> 8) & 0xff;
  out[1] = tag & 0xff;
  out[2] = (value.length >>> 8) & 0xff;
  out[3] = value.length & 0xff;
  out.set(value, 4);
  return out;
}

export function parseTlv(data) {
  const result = {};
  let i = 0;
  while (i + 4 <= data.length) {
    const tag = ((data[i] & 0xff) << 8) | (data[i + 1] & 0xff);
    const length = ((data[i + 2] & 0xff) << 8) | (data[i + 3] & 0xff);
    if (i + 4 + length > data.length) break;
    result[tag] = data.slice(i + 4, i + 4 + length);
    i += 4 + length;
  }
  return result;
}

export function concatBytes(...arrs) {
  let len = 0;
  for (const a of arrs) len += a.length;
  const out = new Uint8Array(len);
  let off = 0;
  for (const a of arrs) {
    out.set(a, off);
    off += a.length;
  }
  return out;
}

// 完整命令:
//   内层 = CommandTlv(cmdType<<8|cmdCode, 各参数TLV拼接) + XOR
//   外层 = CommandTlv(106,1, TLV(29, TEA(内层))) + XOR
export function buildFullCommand(cmdType, cmdCode, units, key) {
  const cmdValue = concatBytes(...units.map(([t, v]) => buildTlv(t, v)));
  const innerTag = ((cmdType << 8) | cmdCode) >>> 0;
  const innerTlv = buildTlv(innerTag, cmdValue);
  const inner = concatBytes(innerTlv, Uint8Array.from([xorOf(innerTlv)]));
  const enc = teaEncrypt(inner, key);
  const tlv29 = buildTlv(29, enc);
  const outerTlv = buildTlv(0x6a01, tlv29);
  return concatBytes(outerTlv, Uint8Array.from([xorOf(outerTlv)]));
}

export function buildGetRangeCode(key) {
  return buildFullCommand(31, 3, [[25, Uint8Array.from([11, 11, 11, 11])]], key);
}

export function buildOpenLock(userKey, randStr, autoLock, key) {
  const a = Uint8Array.from([autoLock ? 1 : 0]);
  return buildFullCommand(
    31,
    7,
    [
      [101, userKey],
      [100, randStr],
      [25, Uint8Array.from([3, 3, 3, 3])],
      [66, a],
    ],
    key
  );
}

export function buildCloseLock(randStr, key) {
  return buildFullCommand(31, 9, [[100, randStr], [25, Uint8Array.from([4, 4, 4, 4])]], key);
}

// 从累计通知字节中解析一个完整外层包并解密, 返回 { tlvs, consumed } 或 null
export function tryParsePacket(buffer, key) {
  let i = 0;
  while (i + 5 <= buffer.length) {
    const tag = ((buffer[i] & 0xff) << 8) | (buffer[i + 1] & 0xff);
    const valid = tag === 0x6a01 || tag === 0x6a02 || tag === 0x6a03 || tag === 0x6a04 || tag === 0x1f02;
    if (!valid) {
      i++;
      continue;
    }
    const length = ((buffer[i + 2] & 0xff) << 8) | (buffer[i + 3] & 0xff);
    const end = i + 4 + length + 1;
    if (buffer.length < end) return null;
    const pkg = buffer.slice(i, end);
    const x = xorOf(pkg.slice(0, pkg.length - 1));
    if (x !== pkg[pkg.length - 1]) {
      i++;
      continue;
    }
    const payload = buffer.slice(i + 4, i + 4 + length);
    const units = parseTlv(payload);
    if (units[29]) {
      const inner = teaDecrypt(units[29], key);
      if (inner.length >= 5 && xorOf(inner.slice(0, inner.length - 1)) === inner[inner.length - 1]) {
        const innerTlvs = parseTlv(inner.slice(4, inner.length - 1));
        return { tlvs: innerTlvs, consumed: end };
      }
      return null;
    } else if (units[100] || units[25]) {
      return { tlvs: units, consumed: end };
    }
    return { tlvs: units, consumed: end };
  }
  return null;
}
