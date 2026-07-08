// ble.js — 微棠门锁 Vela 快应用 BLE 客户端 (基于 @system.bluetooth.ble)
// 把回调式 API 封装成 Promise，并实现 连接→取随机串→开锁/关锁→解析 的状态机。
// 注意: 官方文档注明 JS BLE GATT API 仅 Xiaomi Watch S5 明确支持；
//       其它型号(如 S4 Sport / 澎湃OS3)需真机实测，本文件在 connect 时做了能力探测。

import * as P from './protocol.js'

// 延迟获取 @system.bluetooth.ble：
// 关键 —— 模块加载阶段【完全不触碰】蓝牙系统模块，确保即使设备未开放 JS 蓝牙
// （如 S4 模拟器、或部分 S4 真机），ble.js 也能正常加载，App 界面照常渲染、绝不白屏。
// 蓝牙模块仅在真正要连接时才动态获取，缺失则安全降级为 null（UI 友好提示）。
function getBleModule() {
  try {
    if (typeof require !== 'undefined') {
      const m = require('@system.bluetooth.ble')
      if (m) return m
    }
  } catch (e) {
    // 模块不存在或运行时加载失败 → 降级，不抛出，保证模块可加载
  }
  try {
    if (typeof globalThis !== 'undefined') {
      return globalThis['@system.bluetooth.ble'] || null
    }
  } catch (e) {
    // ignore
  }
  return null
}

const SERVICE_UUID = '000018f0-0000-1000-8000-00805f9b34fb'
const WRITE_UUID = '00002af1-0000-1000-8000-00805f9b34fb'
const NOTIFY_UUID = '00002af0-0000-1000-8000-00805f9b34fb'

// Vela 真机 MTU 默认 23，减去 3 字节头后单包 20 字节（与 Python 脚本一致）
const WRITE_CHUNK = 20

function bufToBytes(buf) {
  if (buf instanceof ArrayBuffer) return new Uint8Array(buf)
  if (typeof ArrayBuffer !== 'undefined' && ArrayBuffer.isView(buf)) {
    return new Uint8Array(buf.buffer, buf.byteOffset, buf.byteLength)
  }
  if (Array.isArray(buf)) return Uint8Array.from(buf)
  return new Uint8Array(0)
}

function bytesToArrayBuffer(bytes) {
  const ab = new ArrayBuffer(bytes.length)
  const u = new Uint8Array(ab)
  u.set(bytes)
  return ab
}

export class LockClient {
  constructor(opts) {
    this.mac = opts.mac
    this.dataSecret = opts.dataSecret
    this.userKey = opts.userKey
    this.autoLock = opts.autoLock !== false // 默认开锁后自动回锁
    this.device = null
    this.writeChar = null
    this.notifyChar = null
    this.recvBuf = new Uint8Array(0)
    this.pending = [] // 等待特定响应包的 resolver 列表
    this.connected = false
    this.log = opts.log || function () {}
  }

  _onNotify(data) {
    try {
      const val = data && data.characteristicValue
      if (!val) return
      const chunk = bufToBytes(val)
      if (chunk.length === 0) return
      this.log('RECV ' + P.bytesToHex(chunk))
      this.recvBuf = P.concatBytes(this.recvBuf, chunk)
      // 循环解析所有完整包（锁偶发先发 0000 前导，tryParsePacket 会跳过非法 tag）
      while (true) {
        const res = P.tryParsePacket(this.recvBuf, this.dataSecret)
        if (!res) break
        this.recvBuf = this.recvBuf.slice(res.consumed)
        this._dispatch(res.tlvs)
      }
    } catch (e) {
      this.log('onNotify error: ' + (e && e.message ? e.message : e))
    }
  }

  _dispatch(tlvs) {
    for (let i = 0; i < this.pending.length; i++) {
      const p = this.pending[i]
      if (p.match(tlvs)) {
        this.pending.splice(i, 1)
        p.resolve(tlvs)
        return
      }
    }
  }

  _waitPacket(matchFn, timeoutMs) {
    const self = this
    return new Promise((resolve, reject) => {
      const timer = setTimeout(function () {
        const idx = self.pending.findIndex(function (p) {
          return p.resolve === resolve
        })
        if (idx >= 0) self.pending.splice(idx, 1)
        reject(new Error('等待响应超时'))
      }, timeoutMs || 8000)
      self.pending.push({
        match: matchFn,
        resolve: function (tlvs) {
          clearTimeout(timer)
          resolve(tlvs)
        }
      })
    })
  }

  // 探测本设备是否支持 JS BLE（S4 等多型号可能不可用）
  static isBleSupported() {
    const ble = getBleModule()
    return !!(ble && typeof ble.createGattClientDevice === 'function')
  }

  connect() {
    const self = this
    return new Promise(function (resolve, reject) {
      const ble = getBleModule()
      if (!ble || typeof ble.createGattClientDevice !== 'function') {
        reject(new Error('@system.bluetooth.ble 不可用：本设备(可能 S4/澎湃OS3)未开放 JS 蓝牙，需改用 Vela 原生 C 开发'))
        return
      }
      let dev
      try {
        dev = ble.createGattClientDevice(self.mac, 'PUBLIC')
      } catch (e) {
        reject(new Error('createGattClientDevice 失败: ' + (e.message || e)))
        return
      }
      self.device = dev
      dev.onBLEConnectionStateChange = function (state) {
        self.log('conn state = ' + state)
        if (state === 2) self.connected = true
        else if (state === 0 || state === 3) self.connected = false
      }
      dev.onBLECharacteristicChange = function (data) {
        self._onNotify(data)
      }
      dev.connect({
        success: function () {
          const started = Date.now()
          const iv = setInterval(function () {
            if (self.connected) {
              clearInterval(iv)
              resolve()
            } else if (Date.now() - started > 8000) {
              clearInterval(iv)
              reject(new Error('连接超时（门锁是否在附近/已开机？）'))
            }
          }, 100)
        },
        fail: function (d, code) {
          reject(new Error('连接失败 code=' + code))
        }
      })
    })
  }

  _getServices() {
    const self = this
    return new Promise(function (resolve, reject) {
      self.device.getServices({
        success: function (services) {
          let writeChar = null
          let notifyChar = null
          for (const s of services || []) {
            for (const c of s.characteristics || []) {
              const u = (c.characteristicUuid || '').toLowerCase()
              if (u === WRITE_UUID.toLowerCase()) writeChar = c
              if (u === NOTIFY_UUID.toLowerCase()) notifyChar = c
            }
          }
          if (!writeChar || !notifyChar) {
            reject(new Error('未在锁服务中找到写/通知特征值'))
            return
          }
          self.writeChar = writeChar
          self.notifyChar = notifyChar
          resolve()
        },
        fail: function (d, code) {
          reject(new Error('发现服务失败 code=' + code))
        }
      })
    })
  }

  _enableNotify() {
    const self = this
    return new Promise(function (resolve, reject) {
      self.device.setNotifyCharacteristicChanged({
        characteristic: self.notifyChar,
        enable: true,
        success: function () {
          resolve()
        },
        fail: function (d, code) {
          reject(new Error('启用通知失败 code=' + code))
        }
      })
    })
  }

  _write(bytes) {
    const self = this
    return new Promise(function (resolve, reject) {
      let off = 0
      function writeNext() {
        if (off >= bytes.length) {
          resolve()
          return
        }
        const n = Math.min(WRITE_CHUNK, bytes.length - off)
        const chunk = bytes.slice(off, off + n)
        off += n
        const characteristic = {
          serviceUuid: self.writeChar.serviceUuid,
          characteristicUuid: WRITE_UUID,
          characteristicValue: bytesToArrayBuffer(chunk)
        }
        self.log('SEND ' + P.bytesToHex(chunk))
        self.device.writeCharacteristicValue({
          characteristic: characteristic,
          success: function () {
            setTimeout(writeNext, 20)
          },
          fail: function (d, code) {
            reject(new Error('写特征失败 code=' + code))
          }
        })
      }
      writeNext()
    })
  }

  openLock() {
    const self = this
    return self.connect()
      .then(function () { return self._getServices() })
      .then(function () { return self._enableNotify() })
      .then(function () {
        const grc = P.buildGetRangeCode(self.dataSecret)
        const randWaiter = self._waitPacket(function (tlvs) { return !!tlvs[100] }, 8000)
        return self._write(grc).then(function () { return randWaiter })
      })
      .then(function (r1) {
        const randStr = r1[100]
        const op = P.buildOpenLock(self.userKey, randStr, self.autoLock, self.dataSecret)
        const openWaiter = self._waitPacket(function (tlvs) { return !!tlvs[1] }, 8000)
        return self._write(op).then(function () { return openWaiter })
      })
      .then(function (r2) {
        const rc = r2[1]
        const ok = !!rc && rc.length >= 2 && rc[0] === 0 && rc[1] === 0
        return self.disconnect().then(function () {
          return {
            success: ok,
            resultCode: P.bytesToHex(rc || new Uint8Array(0)),
            autoLock: self.autoLock
          }
        })
      })
  }

  closeLock() {
    const self = this
    return self.connect()
      .then(function () { return self._getServices() })
      .then(function () { return self._enableNotify() })
      .then(function () {
        const grc = P.buildGetRangeCode(self.dataSecret)
        const randWaiter = self._waitPacket(function (tlvs) { return !!tlvs[100] }, 8000)
        return self._write(grc).then(function () { return randWaiter })
      })
      .then(function (r1) {
        const randStr = r1[100]
        const cl = P.buildCloseLock(randStr, self.dataSecret)
        const closeWaiter = self._waitPacket(function (tlvs) { return !!tlvs[1] || !!tlvs[25] }, 8000)
        return self._write(cl).then(function () { return closeWaiter })
      })
      .then(function (r2) {
        return self.disconnect().then(function () {
          return {
            success: true,
            resultCode: P.bytesToHex(r2[1] || new Uint8Array(0))
          }
        })
      })
  }

  disconnect() {
    const self = this
    return new Promise(function (resolve) {
      if (!self.device) {
        resolve()
        return
      }
      self.device.disconnect({
        success: function () {
          resolve()
        },
        fail: function () {
          resolve()
        },
        complete: function () {
          resolve()
        }
      })
    })
  }
}
