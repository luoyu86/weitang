package com.chinavisionary.weitanglock

import java.io.ByteArrayOutputStream

/**
 * 智能门锁蓝牙协议（与 weitangAPP 反编译源码、Python unlock_v2.py 字节级一致）。
 *
 * 加密: TEA(16轮, delta=0x9E3779B9), 密钥与数据均为 BIG-ENDIAN 32位整数
 * 外层帧: [tag(2B BE), length(2B BE), payload, XOR(1B)]
 *   tag = (cmd_type<<8)|cmd_code
 *   length = payload(所有TLV单元) 的总长度
 *   XOR = 除末字节外所有字节异或
 *
 * 命令:
 *   getRangeCode : CommandTlv(31,3) + TLV(25,{11,11,11,11})
 *   openLock     : CommandTlv(31,7) + TLV(101,用户密钥) + TLV(100,随机串) + TLV(25,{3,3,3,3}) + TLV(66,自动锁)
 *   closeLock    : CommandTlv(31,9) + TLV(100,随机串) + TLV(25,{4,4,4,4})
 */
object LockProtocol {

    private const val DELTA: Long = 0x9E3779B9
    private const val ROUNDS = 16
    private const val BLOCK = 8

    // ===================== TEA (big-endian) =====================

    fun teaEncrypt(data: ByteArray, key: ByteArray): ByteArray {
        val padded = pkcs7Pad(data, BLOCK)
        val out = ByteArray(padded.size)
        val k = IntArray(4) { readIntBE(key, it * 4) }
        var off = 0
        while (off + BLOCK <= padded.size) {
            var v0 = readIntBE(padded, off).toLong() and 0xFFFFFFFFL
            var v1 = readIntBE(padded, off + 4).toLong() and 0xFFFFFFFFL
            var sum = 0L
            repeat(ROUNDS) {
                sum = (sum + DELTA) and 0xFFFFFFFFL
                val k0 = k[0].toLong() and 0xFFFFFFFFL
                val k1 = k[1].toLong() and 0xFFFFFFFFL
                val k2 = k[2].toLong() and 0xFFFFFFFFL
                val k3 = k[3].toLong() and 0xFFFFFFFFL
                v0 = (v0 + (((v1 shl 4) + k0) xor (v1 + sum) xor ((v1 ushr 5) + k1))) and 0xFFFFFFFFL
                v1 = (v1 + (((v0 shl 4) + k2) xor (v0 + sum) xor ((v0 ushr 5) + k3))) and 0xFFFFFFFFL
            }
            writeIntBE(out, off, v0.toInt())
            writeIntBE(out, off + 4, v1.toInt())
            off += BLOCK
        }
        return out
    }

    fun teaDecrypt(data: ByteArray, key: ByteArray): ByteArray {
        val out = ByteArray(data.size)
        val k = IntArray(4) { readIntBE(key, it * 4) }
        var off = 0
        while (off + BLOCK <= data.size) {
            var v0 = readIntBE(data, off).toLong() and 0xFFFFFFFFL
            var v1 = readIntBE(data, off + 4).toLong() and 0xFFFFFFFFL
            var sum = (DELTA * ROUNDS) and 0xFFFFFFFFL
            repeat(ROUNDS) {
                val k0 = k[0].toLong() and 0xFFFFFFFFL
                val k1 = k[1].toLong() and 0xFFFFFFFFL
                val k2 = k[2].toLong() and 0xFFFFFFFFL
                val k3 = k[3].toLong() and 0xFFFFFFFFL
                v1 = (v1 - (((v0 shl 4) + k2) xor (v0 + sum) xor ((v0 ushr 5) + k3))) and 0xFFFFFFFFL
                v0 = (v0 - (((v1 shl 4) + k0) xor (v1 + sum) xor ((v1 ushr 5) + k1))) and 0xFFFFFFFFL
                sum = (sum - DELTA) and 0xFFFFFFFFL
            }
            writeIntBE(out, off, v0.toInt())
            writeIntBE(out, off + 4, v1.toInt())
            off += BLOCK
        }
        return out
    }

    private fun pkcs7Pad(data: ByteArray, block: Int): ByteArray {
        val rem = data.size % block
        val pad = if (rem == 0) block else block - rem
        val out = ByteArray(data.size + pad)
        data.copyInto(out)
        for (i in data.size until out.size) out[i] = pad.toByte()
        return out
    }

    // ===================== 基础工具 =====================

    fun readIntBE(b: ByteArray, off: Int): Int =
        ((b[off].toInt() and 0xFF) shl 24) or
        ((b[off + 1].toInt() and 0xFF) shl 16) or
        ((b[off + 2].toInt() and 0xFF) shl 8) or
        (b[off + 3].toInt() and 0xFF)

    fun writeIntBE(b: ByteArray, off: Int, v: Int) {
        b[off] = (v ushr 24).toByte()
        b[off + 1] = (v ushr 16).toByte()
        b[off + 2] = (v ushr 8).toByte()
        b[off + 3] = v.toByte()
    }

    fun xorOf(data: ByteArray): Byte {
        var x = 0
        for (b in data) x = x xor (b.toInt() and 0xFF)
        return x.toByte()
    }

    // ===================== TLV =====================

    fun buildTlvUnit(tag: Int, value: ByteArray): ByteArray {
        val out = ByteArray(4 + value.size)
        out[0] = (tag ushr 8).toByte()
        out[1] = tag.toByte()
        out[2] = (value.size ushr 8).toByte()
        out[3] = value.size.toByte()
        value.copyInto(out, 4)
        return out
    }

    fun parseTlv(data: ByteArray): Map<Int, ByteArray> {
        val result = LinkedHashMap<Int, ByteArray>()
        var i = 0
        while (i + 4 <= data.size) {
            val tag = ((data[i].toInt() and 0xFF) shl 8) or (data[i + 1].toInt() and 0xFF)
            val length = ((data[i + 2].toInt() and 0xFF) shl 8) or (data[i + 3].toInt() and 0xFF)
            if (i + 4 + length > data.size) break
            result[tag] = data.copyOfRange(i + 4, i + 4 + length)
            i += 4 + length
        }
        return result
    }

    // ===================== 完整命令 (getCommunicationPackage) =====================

    fun buildFullCommand(
        cmdType: Int,
        cmdCode: Int,
        units: List<Pair<Int, ByteArray>>,
        key: ByteArray
    ): ByteArray {
        val baos = ByteArrayOutputStream()
        baos.write(cmdType ushr 8); baos.write(cmdType and 0xFF)
        baos.write(cmdCode ushr 8); baos.write(cmdCode and 0xFF)
        for ((t, v) in units) baos.writeBytes(buildTlvUnit(t, v))
        var inner = baos.toByteArray()
        inner += xorOf(inner)
        val enc = teaEncrypt(inner, key)
        val tlv29 = buildTlvUnit(29, enc)
        val outer = ByteArrayOutputStream()
        outer.write(0x6a); outer.write(0x01)
        outer.write(tlv29.size ushr 8); outer.write(tlv29.size and 0xFF)
        outer.writeBytes(tlv29)
        var outerBytes = outer.toByteArray()
        outerBytes += xorOf(outerBytes)
        return outerBytes
    }

    fun buildGetRangeCode(key: ByteArray): ByteArray =
        buildFullCommand(31, 3, listOf(25 to byteArrayOf(11, 11, 11, 11)), key)

    fun buildOpenLock(userKey: ByteArray, randStr: ByteArray, autoLock: Boolean, key: ByteArray): ByteArray {
        val a = if (autoLock) byteArrayOf(1) else byteArrayOf(0)
        return buildFullCommand(
            31, 7,
            listOf(
                101 to userKey,
                100 to randStr,
                25 to byteArrayOf(3, 3, 3, 3),
                66 to a
            ),
            key
        )
    }

    fun buildCloseLock(randStr: ByteArray, key: ByteArray): ByteArray =
        buildFullCommand(31, 9, listOf(100 to randStr, 25 to byteArrayOf(4, 4, 4, 4)), key)

    /**
     * 从累计通知字节中解析一个完整外层包并解密，返回内层 TLV 字典与消费字节数。
     * 找不到完整/合法包时返回 null（调用方继续等待）。
     */
    fun tryParsePacket(buffer: ByteArray, key: ByteArray): Pair<Map<Int, ByteArray>, Int>? {
        var i = 0
        while (i + 5 <= buffer.size) {
            val tag = ((buffer[i].toInt() and 0xFF) shl 8) or (buffer[i + 1].toInt() and 0xFF)
            val valid = tag == 0x6a01 || tag == 0x6a02 || tag == 0x6a03 || tag == 0x6a04 || tag == 0x1f02
            if (!valid) { i++; continue }
            val length = ((buffer[i + 2].toInt() and 0xFF) shl 8) or (buffer[i + 3].toInt() and 0xFF)
            val end = i + 4 + length + 1
            if (buffer.size < end) return null // 还不完整
            val pkg = buffer.copyOfRange(i, end)
            val x = xorOf(pkg.copyOfRange(0, pkg.size - 1))
            if (x != pkg[pkg.size - 1]) { i++; continue }
            val payload = buffer.copyOfRange(i + 4, i + 4 + length)
            val units = parseTlv(payload)
            if (units.containsKey(29)) {
                val inner = teaDecrypt(units[29]!!, key)
                if (inner.size >= 5 &&
                    xorOf(inner.copyOfRange(0, inner.size - 1)) == inner[inner.size - 1]
                ) {
                    val innerTlvs = parseTlv(inner.copyOfRange(4, inner.size - 1))
                    return innerTlvs to end
                }
                return null
            } else if (units.containsKey(100) || units.containsKey(25)) {
                return units to end
            }
            return units to end
        }
        return null
    }
}

fun ByteArray.toHex(): String = joinToString("") { "%02x".format(it.toInt() and 0xFF) }
