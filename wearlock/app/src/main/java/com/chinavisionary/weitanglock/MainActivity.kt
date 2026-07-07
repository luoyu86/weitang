package com.chinavisionary.weitanglock

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.wear.ambient.WearableActivity
import com.chinavisionary.weitanglock.databinding.ActivityMainBinding

class MainActivity : WearableActivity(), LockBleManager.Listener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var manager: LockBleManager

    private val reqPerms = if (Build.VERSION.SDK_INT >= 33)
        arrayOf(Manifest.permission.BLUETOOTH_SCAN, Manifest.permission.BLUETOOTH_CONNECT)
    else
        arrayOf(Manifest.permission.BLUETOOTH, Manifest.permission.BLUETOOTH_ADMIN)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAmbientEnabled()

        manager = LockBleManager(this, this)

        binding.btnOpen.setOnClickListener {
            ensureReadyThen { manager.execute(LockBleManager.Action.OPEN) }
        }
        binding.btnClose.setOnClickListener {
            ensureReadyThen { manager.execute(LockBleManager.Action.CLOSE) }
        }

        binding.status.text = "微棠门锁控制\n点击按钮开 / 关锁\n(开锁后自动回锁: ${if (Constants.AUTO_LOCK) "开" else "关"})"

        if (!hasPerms()) {
            ActivityCompat.requestPermissions(this, reqPerms, REQ_PERMS)
        }
    }

    private fun hasPerms(): Boolean = reqPerms.all {
        ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED
    }

    private fun ensureReadyThen(action: () -> Unit) {
        if (!hasPerms()) {
            ActivityCompat.requestPermissions(this, reqPerms, REQ_PERMS)
            binding.status.text = "请先授予蓝牙权限"
            return
        }
        val adapter = BluetoothAdapter.getDefaultAdapter()
        if (adapter == null) {
            binding.status.text = "本设备不支持蓝牙"
            return
        }
        if (!adapter.isEnabled) {
            try {
                @Suppress("DEPRECATION")
                startActivityForResult(Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE), REQ_BT)
            } catch (_: Exception) {
                binding.status.text = "请手动开启蓝牙"
            }
            return
        }
        action()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQ_PERMS) {
            if (grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
                binding.status.text = "已授权，可操作"
            } else {
                binding.status.text = "缺少蓝牙权限，无法使用"
                Toast.makeText(this, "需要蓝牙权限才能控制门锁", Toast.LENGTH_LONG).show()
            }
        }
    }

    @Deprecated("Deprecated in API 33")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_BT) {
            binding.status.text = "蓝牙已开启，可操作"
        }
    }

    // ---- LockBleManager.Listener ----

    override fun onLog(msg: String) {
        runOnUiThread { binding.log.append("\n$msg") }
    }

    override fun onResult(success: Boolean, message: String) {
        runOnUiThread { binding.status.text = message }
    }

    override fun onState(state: LockBleManager.State) {
        runOnUiThread {
            binding.state.text = when (state) {
                LockBleManager.State.IDLE -> "空闲"
                LockBleManager.State.CONNECTING -> "连接中"
                LockBleManager.State.DISCOVERING -> "发现服务"
                LockBleManager.State.READY -> "就绪"
                LockBleManager.State.GET_RANGE -> "获取随机串"
                LockBleManager.State.ACTION_SENT -> "发送命令"
                LockBleManager.State.DONE -> "完成"
            }
        }
    }

    override fun onDestroy() {
        manager.disconnect()
        super.onDestroy()
    }

    companion object {
        private const val REQ_PERMS = 1
        private const val REQ_BT = 2
    }
}
