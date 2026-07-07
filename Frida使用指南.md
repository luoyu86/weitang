# Frida动态Hook使用指南

## 什么是Frida
Frida是一个动态 instrumentation工具，可以在运行时修改应用程序行为，无需重新打包APK。

## 安装步骤

### 1. 安装Frida（电脑端）
```bash
pip install frida-tools
pip install frida
```

### 2. 下载frida-server（手机端）
访问 https://github.com/frida/frida/releases
下载与你手机架构匹配的frida-server：
- arm64-v8a: 适用于大多数现代Android手机
- arm-v7a: 适用于较旧的手机

### 3. 手机端设置
```bash
# 1. 手机开启USB调试
# 2. 连接电脑
adb push frida-server /data/local/tmp/
adb shell chmod 755 /data/local/tmp/frida-server
adb shell /data/local/tmp/frida-server &
```

## 使用方法

### 方法1：Hook已安装的APP
```bash
frida -U -l hook_token.js com.chinavisionary.microtang
```

### 方法2：Hook新安装的APP（推荐）
```bash
frida -U -f com.chinavisionary.microtang -l hook_token.js --no-pause
```

## 输出示例

当APP执行登录时，控制台会显示：
```
============================
[TOKEN] 捕获到登录Token:
[TOKEN] eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
============================

[PUBLIC_KEY] 捕获到公钥:
[PUBLIC_KEY] MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD...

[SP] SharedPreferences存储:
[SP] Key: Token
[SP] Value: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```

同时手机会显示Toast提示，Token会复制到剪贴板。

## 注意事项

1. **Root权限**：frida-server需要Root权限运行
2. **USB调试**：手机需要开启USB调试模式
3. **SELinux**：可能需要关闭SELinux（`adb shell setenforce 0`）
4. **64位支持**：确保下载正确架构的frida-server

## 常见问题

### Q: 提示"Unable to connect to server"
A: 确保frida-server正在运行：
```bash
adb shell ps | grep frida
```

### Q: 提示"Failed to attach"
A: 可能是SELinux阻止，尝试：
```bash
adb shell setenforce 0
```

### Q: 看不到输出
A: 确保APP正在运行，并且执行了登录操作

## 获取的信息

通过Hook可以获取：
1. **登录Token** - 用于API认证
2. **公钥** - 用于加密数据
3. **用户信息** - 手机号、昵称等
4. **蓝牙密钥** - BluetoothDataSecret、BluetoothUserKey

## 手表应用集成

获取到Token后，可以通过以下方式传递给小米手表：

### 方案1：蓝牙传输
```kotlin
// 手机APP中
fun sendTokenToWatch(token: String) {
    // 使用BLE发送Token给手表
    bluetoothLeService.writeCharacteristic(token.toByteArray())
}
```

### 方案2：Wear OS Data Layer
```kotlin
// 手机APP中
val dataClient = Wearable.getDataClient(context)
val putDataRequest = PutDataMapRequest.create("/token").apply {
    dataMap.putString("token", token)
}.asPutDataRequest().setUrgent()
dataClient.putDataItem(putDataRequest)
```

### 方案3：共享服务器
```kotlin
// 手机APP上传Token到服务器
// 手表APP从服务器获取Token
```

## 安全提示

1. **仅用于学习**：此技术仅用于个人学习和开发
2. **不要分享**：获取的Token不要分享给他人
3. **及时失效**：Token通常有时效性，过期需重新获取
4. **保护隐私**：注意保护个人隐私信息

## 下一步

1. 安装Frida环境
2. 运行Hook脚本
3. 在APP中执行登录
4. 获取Token信息
5. 集成到手表应用