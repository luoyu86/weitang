package com.chinavisionary.weitanglock

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCallback
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor
import android.bluetooth.BluetoothProfile
import android.content.Context
import android.os.Handler
import android.os.Looper
import java.io.ByteArrayOutputStream
import java.util.UUID
import java.util.concurrent.atomic.AtomicBoolean

/**
 * 门锁 BLE 管理器：连接 -> 发现服务 -> 启用通知 -> 取随机串 -> 开锁/关锁 -> 解析结果。
 * 协议见 LockProtocol。与电脑脚本逻辑一致，离线运行。
 */
class LockBleManager(
    private val context: Context,
    private val listener: Listener
) {

    interface Listener {
        fun onLog(msg: String)
        fun onResult(success: Boolean, message: String)
        fun onState(state: State)
    }

    enum class State { IDLE, CONNECTING, DISCOVERING, READY, GET_RANGE, ACTION_SENT, DONE }
    enum class Action { OPEN, CLOSE }

    private val adapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
    private var gatt: BluetoothGatt? = null
    private var writeChar: BluetoothGattCharacteristic? = null
    private var notifyChar: BluetoothGattCharacteristic? = null

    private val rx = ByteArrayOutputStream()
    private var state = State.IDLE
    private var pendingAction = Action.OPEN
    private var randStr: ByteArray? = null
    private val busy = AtomicBoolean(false)
    private val handler = Handler(Looper.getMainLooper())

    fun execute(action: Action) {
        if (busy.get()) { listener.onLog("忙，请稍候"); return }
        val adp = adapter
        if (adp == null) { listener.onResult(false, "设备不支持蓝牙"); return }
        if (!adp.isEnabled) { listener.onResult(false, "蓝牙未开启"); return }

        busy.set(true)
        pendingAction = action
        randStr = null
        rx.reset()
        state = State.CONNECTING
        listener.onState(State.CONNECTING)
        listener.onLog("连接门锁 ${Constants.LOCK_MAC} ...")
        try {
            val device = adp.getRemoteDevice(Constants.LOCK_MAC)
            gatt = device.connectGatt(context, false, gattCallback, BluetoothDevice.TRANSPORT_LE)
        } catch (e: Exception) {
            busy.set(false)
            listener.onResult(false, "连接异常: ${e.message}")
        }
    }

    fun disconnect() {
        try { gatt?.disconnect() } catch (_: Exception) {}
        try { gatt?.close() } catch (_: Exception) {}
        gatt = null
    }

    @SuppressLint("MissingPermission")
    private val gattCallback = object : BluetoothGattCallback() {

        override fun onConnectionStateChange(g: BluetoothGatt, status: Int, newState: Int) {
            if (newState == BluetoothProfile.STATE_CONNECTED) {
                listener.onLog("已连接，发现服务中...")
                state = State.DISCOVERING
                listener.onState(State.DISCOVERING)
                g.discoverServices()
            } else {
                listener.onLog("连接断开 (status=$status)")
                finish(false, "蓝牙连接断开")
            }
        }

        @SuppressLint("MissingPermission")
        override fun onServicesDiscovered(g: BluetoothGatt, status: Int) {
            if (status != BluetoothGatt.GATT_SUCCESS) { finish(false, "发现服务失败"); return }
            val svc = g.getService(Constants.SERVICE_UUID)
            if (svc == null) { finish(false, "未找到门锁服务"); return }
            writeChar = svc.getCharacteristic(Constants.WRITE_UUID)
            notifyChar = svc.getCharacteristic(Constants.NOTIFY_UUID)
            if (writeChar == null || notifyChar == null) { finish(false, "未找到特征值"); return }
            writeChar!!.writeType = BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE
            // 启用通知（先写 CCC，写完再发命令）
            g.setCharacteristicNotification(notifyChar, true)
            val ccc = notifyChar!!.getDescriptor(CCC_UUID)
            if (ccc != null) {
                ccc.value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
                g.writeDescriptor(ccc)
            } else {
                listener.onLog("无 CCC 描述符，直接发送")
                sendGetRangeCode()
            }
        }

        @SuppressLint("MissingPermission")
        override fun onDescriptorWrite(g: BluetoothGatt, descriptor: BluetoothGattDescriptor, status: Int) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                listener.onLog("通知已启用")
                sendGetRangeCode()
            } else {
                finish(false, "启用通知失败")
            }
        }

        @SuppressLint("MissingPermission")
        override fun onCharacteristicChanged(g: BluetoothGatt, characteristic: BluetoothGattCharacteristic) {
            onData(characteristic.value ?: return)
        }

        @SuppressLint("MissingPermission")
        override fun onCharacteristicChanged(
            g: BluetoothGatt,
            characteristic: BluetoothGattCharacteristic,
            value: ByteArray
        ) {
            onData(value)
        }
    }

    @SuppressLint("MissingPermission")
    private fun sendGetRangeCode() {
        if (state != State.DISCOVERING && state != State.READY) return
        state = State.GET_RANGE
        listener.onState(State.GET_RANGE)
        val pkg = LockProtocol.buildGetRangeCode(Constants.DATA_SECRET)
        listener.onLog("发送获取随机串 (${pkg.size}字节): ${pkg.toHex()}")
        writeChunked(pkg)
    }

    @SuppressLint("MissingPermission")
    private fun sendAction() {
        val rs = randStr
        if (rs == null) { finish(false, "缺少随机串"); return }
        val pkg = if (pendingAction == Action.OPEN)
            LockProtocol.buildOpenLock(Constants.USER_KEY, rs, Constants.AUTO_LOCK, Constants.DATA_SECRET)
        else
            LockProtocol.buildCloseLock(rs, Constants.DATA_SECRET)
        state = State.ACTION_SENT
        listener.onState(State.ACTION_SENT)
        listener.onLog(
            "发送${if (pendingAction == Action.OPEN) "开锁" else "关锁"}命令 (${pkg.size}字节): ${pkg.toHex()}"
        )
        writeChunked(pkg)
    }

    @SuppressLint("MissingPermission")
    private fun writeChunked(pkg: ByteArray) {
        val g = gatt
        val wc = writeChar
        if (g == null || wc == null) { finish(false, "GATT/写特征为空"); return }
        val chunk = 20
        var off = 0
        while (off < pkg.size) {
            val end = minOf(off + chunk, pkg.size)
            wc.value = pkg.copyOfRange(off, end)
            g.writeCharacteristic(wc)
            off = end
            try { Thread.sleep(50) } catch (_: InterruptedException) {}
        }
        listener.onLog("已发送 $off 字节")
    }

    private fun onData(value: ByteArray) {
        rx.write(value)
        val buf = rx.toByteArray()
        val parsed = LockProtocol.tryParsePacket(buf, Constants.DATA_SECRET) ?: return
        val (tlvs, consumed) = parsed
        // 保留未消费的尾随字节
        val remaining = buf.copyOfRange(consumed, buf.size)
        rx.reset()
        rx.write(remaining)

        listener.onLog("收到响应 TLV: ${tlvs.keys}")

        when (state) {
            State.GET_RANGE -> {
                val rs = tlvs[100]
                if (rs != null) {
                    randStr = rs
                    listener.onLog("随机串 randStr=${rs.toHex()}")
                    rx.reset() // 清空，准备接收动作响应
                    sendAction()
                } else {
                    listener.onLog("响应中无 randStr，继续等待")
                }
            }
            State.ACTION_SENT -> {
                val rc = tlvs[1]
                if (rc != null) {
                    val ok = rc.contentEquals(byteArrayOf(0, 0))
                    val msg = if (ok) {
                        if (pendingAction == Action.OPEN) "开锁成功" else "关锁成功"
                    } else "锁返回错误码: ${rc.toHex()}"
                    finish(ok, msg)
                } else {
                    listener.onLog("响应中无 resultCode，继续等待")
                }
            }
            else -> { /* 其他状态忽略 */ }
        }
    }

    private fun finish(success: Boolean, message: String) {
        if (!busy.get()) return
        busy.set(false)
        state = State.DONE
        listener.onState(State.DONE)
        listener.onLog(message)
        listener.onResult(success, message)
        handler.postDelayed({ disconnect() }, 600)
    }

    companion object {
        val CCC_UUID: UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb")
    }
}
