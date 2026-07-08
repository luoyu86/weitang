// 无蓝牙环境冒烟测试：模拟 Vela 运行时未开放 @system.bluetooth.ble 的情况
// （ESM 里无 require、globalThis 也无该模块）→ 验证 ble.js 仍能加载、界面所需的
// LockClient 可创建、isBleSupported 返回 false、connect 友好拒绝（绝不白屏/抛未捕获异常）
import * as B from './src/common/ble.js'

let ok = true
function check(name, cond) {
  console.log((cond ? '✅' : '❌') + ' ' + name)
  if (!cond) ok = false
}

// 1) 模块加载成功（未因蓝牙缺失而抛错）
check('ble.js 模块加载成功', !!B && !!B.LockClient)

// 2) 无蓝牙时探测返回 false（UI 据此显示「不支持」）
const supported = B.LockClient.isBleSupported()
check('isBleSupported() 在无蓝牙环境返回 false', supported === false)

// 3) LockClient 可实例化（界面 onInit 需要）
const c = new B.LockClient({
  mac: 'AA:BB:CC:DD:EE:FF',
  dataSecret: new Uint8Array(16),
  userKey: new Uint8Array(32)
})
check('LockClient 可实例化', !!c)

// 4) connect 在无蓝牙下应友好 reject，而非抛未捕获异常/白屏
let rejected = false
let errMsg = ''
try {
  await c.connect()
} catch (e) {
  rejected = true
  errMsg = e && e.message ? e.message : String(e)
}
check('connect() 在无蓝牙下友好拒绝(不崩溃)', rejected && errMsg.length > 0)
console.log('   connect 拒绝原因: ' + errMsg)

console.log(ok ? '\n全部通过：无蓝牙环境下界面必定可展示' : '\n存在失败项')
process.exit(ok ? 0 : 1)
