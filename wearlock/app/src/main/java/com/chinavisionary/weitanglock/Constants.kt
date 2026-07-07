package com.chinavisionary.weitanglock

import java.util.UUID

/**
 * 门锁与密钥配置（与电脑脚本 unlock_v2.py / closelock_v2.py 完全一致，离线可用）。
 * 密钥来自微棠 APP 反编译（lock_keys.json），已硬编码。
 */
object Constants {

    /** 门锁蓝牙 MAC（逸秀新村-8-807） */
    const val LOCK_MAC = "1E:98:6C:02:A7:77"

    val SERVICE_UUID: UUID = UUID.fromString("000018f0-0000-1000-8000-00805f9b34fb")
    val WRITE_UUID: UUID = UUID.fromString("00002af1-0000-1000-8000-00805f9b34fb")
    val NOTIFY_UUID: UUID = UUID.fromString("00002af0-0000-1000-8000-00805f9b34fb")

    /** 加密密钥 miyao3 = BluetoothDataSecret */
    val DATA_SECRET: ByteArray = hexToBytes("DBCCB54D6E2E655958FF9E29CBF8A764")

    /** TLV 101 用户密钥 BluetoothUserKey */
    val USER_KEY: ByteArray = hexToBytes("0F80D3A7AF16E51B5BAA1A829A144B04C9878901EB6377ACB525214E3820E0D2")

    /**
     * 开锁后是否自动回锁。源码 BluetoothOperation:1006 -> TLV66 = z ? {1} : {0}
     * 之前电脑脚本用 false 导致门开着不锁；手表默认 true（开锁后自动重新锁定，更安全）。
     */
    const val AUTO_LOCK = true

    fun hexToBytes(hex: String): ByteArray {
        val s = hex.replace(" ", "")
        require(s.length % 2 == 0) { "hex 长度必须为偶数" }
        return ByteArray(s.length / 2) { s.substring(it * 2, it * 2 + 2).toInt(16).toByte() }
    }
}
