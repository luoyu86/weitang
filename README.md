# 智能门锁APP逆向工程工具包

## 项目概述
本项目包含智能门锁APP的逆向工程分析结果，用于开发小米手表蓝牙开锁应用。

## 文件结构

```
D:\code\weitang\
├── base.apk                          # 原始APK文件
├── weitangAPP/                        # 反编译后的源代码
│   └── sources/                       # Java源代码
│       └── cn/com/heaton/blelibrary/  # 蓝牙库核心代码
├── hook_token.js                      # Frida Hook脚本
├── install_frida.bat                  # Frida安装脚本
├── Frida使用指南.md                    # Frida使用说明
├── 修改APK指南.md                      # APK修改方法
├── analyze_apk.py                     # APK分析脚本
├── bluetooth_protocol_analyzer.py     # 蓝牙协议分析
└── protocol_details.py                # 协议细节分析
```

## 核心发现

### 1. 蓝牙协议
- **服务UUID**: `000018f0-0000-1000-8000-00805f9b34fb`
- **写入UUID**: `00002af1-0000-1000-8000-00805f9b34fb`
- **通知UUID**: `00002af0-0000-1000-8000-00805f9b34fb`
- **加密算法**: TEA加密（16轮，16字节密钥）
- **数据格式**: TLV（Type-Length-Value）

### 2. 登录态存储
- **存储位置**: SharedPreferences `app_config`
- **Token字段**: `"Token"`
- **公钥字段**: `"public_key"`
- **用户信息**: `"userInfoKey"`、`"userDetailsInfoKey"`

### 3. 开锁流程
1. 获取随机串: `CommandTlv(31, 3)`
2. 发送开锁命令: `CommandTlv(31, 7)`
3. 加密: TEA加密 + XOR校验

## 使用方法

### 方法一：Frida动态Hook（推荐）
```bash
# 1. 安装Frida
pip install frida-tools frida

# 2. 运行安装脚本
install_frida.bat

# 3. 启动frida-server
adb shell /data/local/tmp/frida-server &

# 4. 运行Hook
frida -U -f com.chinavisionary.microtang -l hook_token.js --no-pause

# 5. 在APP中登录，查看输出
```

### 方法二：修改APK
参考 `修改APK指南.md` 中的步骤。

### 方法三：蓝牙协议分析
```bash
# 运行协议分析
py bluetooth_protocol_analyzer.py base.apk
py protocol_details.py base.apk
```

## 手表应用开发

### 1. 创建Wear OS项目
```kotlin
// build.gradle
dependencies {
    implementation 'com.google.android.support:wearable:2.9.0'
    implementation 'com.google.android.gms:play-services-wearable:18.0.0'
}
```

### 2. 实现BLE通信
```kotlin
// 核心UUID
val SERVICE_UUID = UUID.fromString("000018f0-0000-1000-8000-00805f9b34fb")
val WRITE_UUID = UUID.fromString("00002af1-0000-1000-8000-00805f9b34fb")
val NOTIFY_UUID = UUID.fromString("00002af0-0000-1000-8000-00805f9b34fb")
```

### 3. 实现TEA加密
```kotlin
class TEACipher {
    fun encrypt(data: ByteArray, key: ByteArray): ByteArray {
        // 16轮TEA加密
    }
}
```

### 4. 实现TLV协议
```kotlin
class CommandTlv(cmd: Int, subCmd: Int) {
    fun addUnit(type: Int, data: ByteArray)
    fun getByte(): ByteArray
}
```

## 常见问题

### Q: Frida连接失败
A: 确保：
1. 手机已Root
2. frida-server正在运行
3. SELinux已关闭：`adb shell setenforce 0`

### Q: 无法反编译APK
A: 尝试使用最新版jadx或apktool

### Q: 蓝牙连接失败
A: 检查：
1. 手机蓝牙已开启
2. 门锁在范围内
3. 使用正确的UUID

## 下一步

1. **获取登录Token** - 使用Frida Hook
2. **分析蓝牙协议** - 使用协议分析脚本
3. **开发手表应用** - 参考Wear OS开发指南
4. **测试开锁功能** - 连接真实门锁测试

## 注意事项

1. **合法使用** - 仅用于个人学习和开发
2. **安全存储** - Token等敏感信息要安全存储
3. **兼容性** - 不同门锁型号协议可能不同
4. **测试环境** - 先在测试环境验证功能