# 微棠门锁 · 小米手表 Vela 快应用

> 目标：在小米手表上（脱离手机）直接用 BLE 对话门锁，实现「开锁 / 关锁」。
> 纯离线，密钥内置在 `index.ux` 中。

## ⚠️ 平台重要说明（务必先看）

你的手表是 **小米手表 S4 Sport / 澎湃OS3（Xiaomi Vela，RTOS，非安卓）**。

- 之前 `wearlock/`（Kotlin/安卓 Wear OS 工程）**装不到这块表上，已停用**。
- 本工程是 **Vela 快应用（JS）**，产物 `.rpk`，用 **AIoT-IDE** 开发/调试/安装。
- 官方文档注明：**`@system.bluetooth.ble` JS API 仅 Xiaomi Watch S5 明确支持**，其余型号（含 S4 / 澎湃OS3）未承诺支持。
- 因此请先按下面「步骤 2 探测」确认你的表是否放行 JS 蓝牙；若探测不支持，需改走 **Vela 原生 C 开发**（工作量显著更大）。

## 目录结构

```
velalock/
├── src/
│   ├── manifest.json          # 应用配置 (deviceTypeList: watch, features: system.bluetooth.ble)
│   ├── app.ux                 # 应用级生命周期
│   ├── common/
│   │   ├── icon.png            # 192x192 图标
│   │   ├── protocol.js         # 协议层: TEA(big-endian,16轮)+TLV+命令+解析 (已 Node 验证字节级正确)
│   │   └── ble.js              # BLE 客户端状态机 (基于 @system.bluetooth.ble)
│   └── index/index.ux          # 主界面: 探测BLE / 开锁 / 关锁 + 日志 (入口页, 对应 manifest 的 entry "index")
└── test_protocol.mjs           # Node 自测: 与 unlock_v2.py 字节级对齐验证
```

## 协议层已验证

`protocol.js` 与已实测通过的 `unlock_v2.py` **字节级一致**（确定性常数）：

```bash
node test_protocol.mjs
# getRangeCode = 6a010014001d0010c7a71df6948bb6f4a686293dc560ed3fe7  ✅
# 5 项全部通过
```

门锁常量（来自反编译，已写入 `ble.js` / `index.ux`）：
- 服务 UUID：`000018f0-0000-1000-8000-00805f9b34fb`
- 写特征：`00002af1-…`，通知特征：`00002af0-…`
- 门锁 MAC：`1E:98:6C:02:A7:77`

## 使用步骤

### 1. 安装 AIoT-IDE
从小米 Vela 官方文档页下载 **AIoT-IDE**（基于 VS Code 的 GUI，含 Vela 快应用模板与真机调试）。
下载页：https://iot.mi.com/vela/quickapp/zh/guide/start/use-ide.html

### 2. 打开工程 & 探测兼容性
1. AIoT-IDE → 打开 `velalock/` 目录（或导入为 Vela 快应用工程）。
2. 在手表上确保已开启「开发者选项 / 无线调试」（Vela 走 AIoT-IDE 自带设备连接，不是安卓 adb）。
3. 点手表 App 里的 **「探测 BLE」** 按钮：
   - 显示 ✅ 支持 → 可继续真机开锁。
   - 显示 ❌ 不支持 → S4 未开放 JS 蓝牙，需转 Vela 原生 C。

   > **注意（模拟器 vs 真机）**：AIoT-IDE 自带的 `xiaomi_s4_41` 模拟器**没有真蓝牙芯片**。
   > 在模拟器里点「探测 BLE」可能因模块占位而显示 ✅ 支持，但点「开锁」会因无硬件而失败（日志会报具体错误，不会白屏）。
   > **模拟器结果仅供参考，务必在真 S4 手表上连 AIoT-IDE 跑一次「探测 BLE」才算数。**

### 3. 真机开锁验证
1. 手表与门锁处于同一物理范围、门锁已上电。
2. 点 **「开锁」** → 日志区应出现 `SEND …` / `RECV …`，最终状态 `✅ 开锁成功`。
3. 点 **「关锁」** → 验证关锁指令。

## 已知风险 / TODO
- **S4 JS 蓝牙未确认**：这是最大不确定项，必须先探测。
- BLE 写按 20 字节分包（与 Python 一致）；若手表默认 MTU 不同导致写失败，可在 `ble.js` 连接成功后调用 `setBLEMtuSize`。
- 真机端到端尚未跑过（无 S4 真机 + 锁在 Mac 侧），协议字节已对齐但写/通知时序需真机验证。

## 当前进度（2026-07-07）

- ✅ 协议层 `protocol.js` 与 `unlock_v2.py` 字节级一致（Node 验证 5/5 通过）。
- ✅ `velalock/` 工程被 `aiot-toolkit 2.0.5` 成功构建为 `.rpk`（修复了页面路径 `src/index/` 扁平结构）。
- ✅ 已成功 push 到 **S4 模拟器 `xiaomi_s4_41`** 并启动运行（验证框架/manifest/ux/资源打包全部正确）。
- ✅ BLE 层 `ble.js` 改为运行时 `require('@system.bluetooth.ble')` + 容错：模块缺失时降级为 null、`isBleSupported()` 返回 false、UI 友好提示，**绝不因蓝牙模块不存在而白屏**。
- ⏳ 待办：在**真 S4 手表**上用 AIoT-IDE 连设备 → 点「探测 BLE」确认 JS 蓝牙是否放行；若放行则实测开锁/关锁，若不放行则转 Vela 原生 C。

## 无蓝牙也能正常显示界面（2026-07-08 加固）

> 用户要求：设备没有蓝牙能力时，App 界面也必须正常展示，不能白屏。

- **根因预防**：最初 `ble.js` 在**模块加载阶段**就 `require('@system.bluetooth.ble')`。若 Vela 运行时在模块解析阶段因该模块缺失而抛错（try/catch 未必兜得住运行时的模块解析错误），`ble.js` 加载失败会连带 `index.ux` 一起白屏。
- **修复**：把蓝牙模块获取**延迟到真正 `connect()` 时才做**（`getBleModule()` 函数，模块加载阶段**零依赖蓝牙**）；缺失时安全降级为 `null`，`isBleSupported()` 返回 `false`，UI 友好提示「不支持」。
- `index.ux` 的 `onInit` **启动即自动探测**：界面先渲染，再显示蓝牙状态；无论支持与否都不白屏。
- **验证**：`test_no_ble.mjs` 在「无蓝牙运行时」（ESM 环境，无 `require` / 无全局蓝牙模块）下 **4/4 通过**：① 模块加载成功 ② `isBleSupported()=false` ③ `LockClient` 可实例化 ④ `connect()` 友好拒绝（不崩溃）。`aiot build` 也成功。
- 因此即使 S4 真机/模拟器完全没开放 JS 蓝牙，App 打开也是**完整界面 + 明确的不支持提示**，绝不会白屏。
