# APK修改指南：显示登录信息

## 目标
修改 `com.chinavisionary.microtang` APP，在登录成功后显示Token信息。

## 方法一：使用jadx-gui手动修改（推荐）

### 步骤1：找到关键文件
在jadx-gui中打开 `D:\code\weitang\base.apk`，找到以下文件：
```
sources/com/chinavisionary/core/app/net/base/model/BaseModel.java
```

### 步骤2：找到saveToken方法
在BaseModel.java中找到 `saveToken` 方法：
```java
public final void saveToken(String str) {
    b.getInstance().setToken(str);
    w.getInstance().putString("Token", str);
}
```

### 步骤3：添加显示代码
在方法末尾添加以下代码：
```java
public final void saveToken(String str) {
    b.getInstance().setToken(str);
    w.getInstance().putString("Token", str);
    
    // 添加的代码：显示Token
    try {
        android.widget.Toast.makeText(
            b.getInstance().getContext(), 
            "Token: " + str, 
            android.widget.Toast.LENGTH_LONG
        ).show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

### 步骤4：添加剪贴板功能（可选）
如果想复制到剪贴板，添加以下代码：
```java
// 在saveToken方法中
try {
    android.content.ClipboardManager clipboard = 
        (android.content.ClipboardManager) b.getInstance().getContext()
            .getSystemService(android.content.Context.CLIPBOARD_SERVICE);
    clipboard.setPrimaryClip(
        android.content.ClipData.newPlainText("token", str)
    );
    android.widget.Toast.makeText(
        b.getInstance().getContext(), 
        "Token已复制到剪贴板", 
        android.widget.Toast.LENGTH_SHORT
    ).show();
} catch (Exception e) {
    e.printStackTrace();
}
```

## 方法二：使用Smali修改（需要apktool）

### 步骤1：反编译APK
```bash
java -jar apktool.jar d base.apk -o output
```

### 步骤2：找到smali文件
```
output/smali/com/chinavisionary/core/app/net/base/model/BaseModel.smali
```

### 步骤3：修改smali代码
在 `saveToken` 方法中添加：
```smali
# 原代码
invoke-virtual {p0, p1}, Lc/e/a/a/b;->setToken(Ljava/lang/String;)V
invoke-static {}, Lc/e/a/d/w;->getInstance()Lc/e/a/d/w;
move-result-object v0
const-string v1, "Token"
invoke-virtual {v0, v1, p1}, Lc/e/a/d/w;->putString(Ljava/lang/String;Ljava/lang/String;)V

# 添加的代码：显示Toast
:try_start
invoke-static {}, Lc/e/a/a/b;->getInstance()Lc/e/a/a/b;
move-result-object v0
invoke-virtual {v0}, Lc/e/a/a/b;->getContext()Landroid/content/Context;
move-result-object v0
new-instance v1, Ljava/lang/StringBuilder;
invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V
const-string v2, "Token: "
invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
move-result-object v1
const/4 v2, 0x1
invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
move-result-object v0
invoke-virtual {v0}, Landroid/widget/Toast;->show()V
:try_end
.catchall {:try_start .. :try_end} :catchall
```

### 步骤4：重新打包
```bash
java -jar apktool.jar b output -o modified.apk
```

### 步骤5：签名APK
```bash
# 生成签名密钥
keytool -genkey -v -keystore my.keystore -alias alias_name -keyalg RSA -keysize 2048 -validity 10000

# 签名APK
jarsigner -verbose -sigalg SHA1withRSA -digestalg SHA1 -keystore my.keystore modified.apk alias_name

# 或使用apksigner
apksigner sign --ks my.keystore modified.apk
```

## 方法三：使用Frida动态Hook（无需修改APK）

### 步骤1：安装Frida
```bash
pip install frida-tools
```

### 步骤2：Hook saveToken方法
创建文件 `hook_token.js`：
```javascript
Java.perform(function() {
    var BaseModel = Java.use('com.chinavisionary.core.app.net.base.model.BaseModel');
    
    BaseModel.saveToken.implementation = function(str) {
        console.log('Token: ' + str);
        
        // 显示Toast
        var context = Java.use('c.e.a.a.b').getInstance().getContext();
        var Toast = Java.use('android.widget.Toast');
        Toast.makeText(context, 'Token: ' + str, Toast.LENGTH_LONG).show();
        
        // 复制到剪贴板
        var ClipboardManager = Java.use('android.content.ClipboardManager');
        var ClipData = Java.use('android.content.ClipData');
        var clipboard = context.getSystemService('clipboard');
        clipboard.setPrimaryClip(ClipData.newPlainText('token', str));
        
        return this.saveToken(str);
    };
});
```

### 步骤3：运行Hook
```bash
frida -U -f com.chinavisionary.microtang -l hook_token.js --no-pause
```

## 推荐方案

对于你的需求，我推荐**方法三：使用Frida动态Hook**，原因：
1. 无需修改APK
2. 无需重新签名
3. 可以动态查看和修改
4. 更安全，不会破坏原有功能

## 注意事项

1. **备份原APK**：修改前先备份
2. **签名问题**：重新打包需要签名，否则无法安装
3. **兼容性**：不同Android版本可能有差异
4. **安全风险**：修改APK可能触发安全检测

## 手表应用集成建议

获取到Token后，可以通过以下方式传递给手表应用：
1. **蓝牙传输**：手机APP通过蓝牙发送Token给手表
2. **共享存储**：使用ContentProvider共享数据
3. **网络同步**：通过服务器中转
4. **Wear OS Data Layer**：使用官方API同步

选择哪种方式取决于你的具体需求和技术栈。