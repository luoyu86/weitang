// test_protocol.mjs — 用 Node 验证 protocol.js 与已实测 Python 字节级一致
import * as P from "./src/common/protocol.js";

const DATA_SECRET = P.hexToBytes("DBCCB54D6E2E655958FF9E29CBF8A764");
const USER_KEY = P.hexToBytes("0F80D3A7AF16E51B5BAA1A829A144B04C9878901EB6377ACB525214E3820E0D2");

let pass = 0,
  fail = 0;
const check = (n, c, d = "") => {
  if (c) {
    pass++;
    console.log("PASS ", n);
  } else {
    fail++;
    console.log("FAIL ", n, d);
  }
};
const eq = (a, b) => {
  if (a.length !== b.length) return false;
  for (let i = 0; i < a.length; i++) if ((a[i] & 0xff) !== (b[i] & 0xff)) return false;
  return true;
};

// 1) getRangeCode 必须是确定值 (与 unlock_v2.py 实测一致)
const grc = P.buildGetRangeCode(DATA_SECRET);
const grcHex = P.bytesToHex(grc);
console.log("getRangeCode =", grcHex, `(${grc.length} bytes)`);
check(
  "getRangeCode 字节匹配",
  grcHex === "6a010014001d0010c7a71df6948bb6f4a686293dc560ed3fe7",
  "got " + grcHex
);

// 2) TEA 加解密可逆
const samples = [
  new Uint8Array(0),
  P.hexToBytes("616263"),
  P.hexToBytes("3132333435363738"),
  P.hexToBytes("68656c6c6f20776f726c642121"),
  (() => {
    const a = new Uint8Array(17);
    for (let i = 0; i < 17; i++) a[i] = i;
    return a;
  })(),
];
let teaOk = true;
for (const s of samples) {
  const e = P.teaEncrypt(s, DATA_SECRET);
  const d = P.teaDecrypt(e, DATA_SECRET);
  if (!eq(d, s)) teaOk = false;
}
check("TEA 加解密可逆", teaOk);

// 3) openLock / closeLock 结构与 XOR 尾
const rs = P.hexToBytes("663e2bf0");
const op = P.buildOpenLock(USER_KEY, rs, true, DATA_SECRET);
const cl = P.buildCloseLock(rs, DATA_SECRET);
console.log("openLock  =", P.bytesToHex(op), `(${op.length} bytes)`);
console.log("closeLock =", P.bytesToHex(cl), `(${cl.length} bytes)`);
check(
  "openLock 外层 6a01 + XOR尾",
  op[0] === 0x6a && op[1] === 0x01 && P.xorOf(op.slice(0, op.length - 1)) === op[op.length - 1]
);
check(
  "closeLock 外层 6a01 + XOR尾",
  cl[0] === 0x6a && cl[1] === 0x01 && P.xorOf(cl.slice(0, cl.length - 1)) === cl[cl.length - 1]
);

// 4) 模拟锁 openLock 响应并解析
//    响应内层 = CommandTlv(31,8, [TLV(1,0000), TLV(25,...)]) + XOR
const respInner = P.buildTlv(
  0x1f08,
  P.concatBytes(
    P.buildTlv(1, Uint8Array.from([0, 0])),
    P.buildTlv(25, Uint8Array.from([3, 3, 3, 3]))
  )
);
const respInnerX = P.concatBytes(respInner, Uint8Array.from([P.xorOf(respInner)]));
const encInner = P.teaEncrypt(respInnerX, DATA_SECRET);
const tlv29 = P.buildTlv(29, encInner);
const outerTlv = P.buildTlv(0x6a01, tlv29);
const resp = P.concatBytes(outerTlv, Uint8Array.from([P.xorOf(outerTlv)]));
const parsed = P.tryParsePacket(resp, DATA_SECRET);
const rc = parsed && parsed.tlvs[1];
console.log("模拟锁响应 resultCode =", rc ? P.bytesToHex(rc) : null);
check("响应解析 resultCode=0000", rc && eq(rc, Uint8Array.from([0, 0])));

console.log(`\n==== 结果: ${pass} 通过, ${fail} 失败 ====`);
if (fail > 0) process.exit(1);
