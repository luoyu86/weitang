package com.chinavisionary.weitanglock

/**
 * 仅用于本机校验协议逻辑（纯 JVM，无 Android 依赖）。
 * 用 kotlinc 编译 LockProtocol.kt + Constants.kt + 本文件后运行，
 * 与已验证的 Python unlock_v2.py 输出做字节级比对。
 */
fun main() {
    var pass = 0
    var fail = 0
    fun check(name: String, cond: Boolean, detail: String = "") {
        if (cond) { pass++; println("PASS  $name") }
        else { fail++; println("FAIL  $name  $detail") }
    }

    // 1) getRangeCode 必须是确定值（与 Python 实测一致）
    val grc = LockProtocol.buildGetRangeCode(Constants.DATA_SECRET)
    val grcHex = grc.toHex()
    println("getRangeCode = $grcHex  (${grc.size} bytes)")
    check("getRangeCode 字节匹配", grcHex == "6a010014001d0010c7a71df6948bb6f4a686293dc560ed3fe7",
        "got $grcHex")

    // 2) TEA 加解密可逆
    val samples = listOf(
        byteArrayOf(),
        "abc".toByteArray(),
        "12345678".toByteArray(),
        "hello world!!".toByteArray(),
        ByteArray(17) { it.toByte() }
    )
    var teaOk = true
    for (s in samples) {
        val enc = LockProtocol.teaEncrypt(s, Constants.DATA_SECRET)
        val dec = LockProtocol.teaDecrypt(enc, Constants.DATA_SECRET)
        if (dec != s) teaOk = false
    }
    check("TEA 加解密可逆", teaOk)

    // 3) 用已知随机串构造 openLock / closeLock，并模拟锁响应、解析
    val randStr = Constants.hexToBytes("663e2bf0")
    val open = LockProtocol.buildOpenLock(Constants.USER_KEY, randStr, true, Constants.DATA_SECRET)
    val close = LockProtocol.buildCloseLock(randStr, Constants.DATA_SECRET)
    println("openLock  = $open (${open.size} bytes)")
    println("closeLock = $close (${close.size} bytes)")
    check("openLock 外层以 6a01 开头且有XOR尾", open[0] == 0x6a.toByte() && open[1] == 0x01.toByte()
        && LockProtocol.xorOf(open.copyOfRange(0, open.size - 1)) == open[open.size - 1])
    check("closeLock 外层以 6a01 开头且有XOR尾", close[0] == 0x6a.toByte() && close[1] == 0x01.toByte()
        && LockProtocol.xorOf(close.copyOfRange(0, close.size - 1)) == close[close.size - 1])

    // 4) 模拟锁的 openLock 响应: 内层 CommandTlv(31,8) + TLV(1,0000) + TLV(25,{3,3,3,3})
    val inner = byteArrayOf(31, 8) +
        LockProtocol.buildTlvUnit(1, byteArrayOf(0, 0)) +
        LockProtocol.buildTlvUnit(25, byteArrayOf(3, 3, 3, 3))
    val innerWithXor = inner + LockProtocol.xorOf(inner)
    val encInner = LockProtocol.teaEncrypt(innerWithXor, Constants.DATA_SECRET)
    val tlv29 = LockProtocol.buildTlvUnit(29, encInner)
    val outer = byteArrayOf(0x6a.toByte(), 0x01.toByte()) +
        byteArrayOf((tlv29.size ushr 8).toByte(), (tlv29.size and 0xFF).toByte()) + tlv29
    val respPkg = outer + LockProtocol.xorOf(outer)
    val parsed = LockProtocol.tryParsePacket(respPkg, Constants.DATA_SECRET)
    val rc = parsed?.first?.get(1)
    println("模拟锁响应解析: resultCode=${rc?.toHex()}")
    check("响应解析出 resultCode=0000", rc != null && rc.contentEquals(byteArrayOf(0, 0)))

    println("\n==== 结果: $pass 通过, $fail 失败 ====")
    if (fail > 0) throw RuntimeException("协议校验未通过")
}
