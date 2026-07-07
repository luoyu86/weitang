# 微棠智能门锁 · 手表控制 App（Wear OS）

为小米手表（Wear OS / HyperOS for Wear）开发的蓝牙开锁/关锁应用。
协议完全逆向自微棠 APP（com.chinavisionary.microtang），与电脑脚本 `unlock_v2.py` / `closelock_v2.py` 字节级一致。

## 功能
- 一键**开锁** / **关锁**
- 完全离线：密钥内置，不联网、不依赖手机
- 开锁后**自动回锁**（默认开启，见 `Constants.AUTO_LOCK`）

## 协议要点（详见 LockProtocol.kt）
- 加密：TEA（16 轮，big-endian 32 位整数）
- 外层帧：`[tag(2B BE), length(2B BE), payload, XOR(1B)]`
- 流程：`getRangeCode(31,3)` 取随机串 → `openLock(31,7)` / `closeLock(31,9)`（带随机串）→ 解析 `resultCode`

## 构建与部署

### 1. 用 Android Studio 打开
直接打开 `wearlock/` 目录，IDE 会自动生成 Gradle wrapper 并同步依赖。

> 需要 Android SDK（API 34 平台）+ Gradle 8.6。第一次同步会联网下载依赖。

### 2. 连接手表
手表开启 **开发者选项 → 无线调试（或 USB 调试）**，与电脑同一网络后用 adb 连接：
```bash
adb connect 手表IP:端口      # 无线调试
# 或
adb devices                 # USB 连接
```

### 3. 安装运行
```bash
./gradlew installDebug      # 或 Android Studio 点 Run
```
安装后在手表应用列表里找到「微棠门锁」。

### 4. 使用
- 首次打开会请求蓝牙权限，授予即可。
- 点击 **开锁** / **关锁**，等待状态变为「开锁成功 / 关锁成功」。
- 手表需靠近门锁（蓝牙范围内）。

## 注意事项
- **离线可用**：本 App 不联网。需要联网的是早期"登录/换密钥"用的脚本（与本 App 无关）。
- **自动回锁**：`Constants.AUTO_LOCK = true`。若想开锁后保持开着，改成 `false`（不建议）。
- **配对**：电脑实测无需配对即可连接。若手表连接后锁无响应，可能需要在手表蓝牙里先配对门锁。
- 本 App 仅用于控制你**自己**的门锁。

## 文件结构
```
wearlock/
├── app/build.gradle.kts
├── app/src/main/AndroidManifest.xml
├── app/src/main/res/...           # 布局/主题/字符串
└── app/src/main/java/com/chinavisionary/weitanglock/
    ├── Constants.kt               # MAC / UUID / 密钥 / auto-lock 开关
    ├── LockProtocol.kt            # TEA + TLV + 命令构造 + 响应解析
    ├── LockBleManager.kt          # BLE 连接/写/通知/流程状态机
    └── MainActivity.kt            # 界面 + 权限
```
