/**
 * 智能门锁APP登录信息Hook脚本
 * 用于捕获和显示登录token、公钥等信息
 */

// 等待Java虚拟机准备好
Java.perform(function() {
    console.log("[*] Frida Hook已启动");
    console.log("[*] 正在Hook智能门锁APP...");
    
    // ========== 1. Hook BaseModel.saveToken ==========
    try {
        var BaseModel = Java.use('com.chinavisionary.core.app.net.base.model.BaseModel');
        
        BaseModel.saveToken.implementation = function(str) {
            console.log("\n============================");
            console.log("[TOKEN] 捕获到登录Token:");
            console.log("[TOKEN] " + str);
            console.log("============================\n");
            
            // 显示Toast
            try {
                var context = Java.use('c.e.a.a.b').getInstance().getContext();
                var Toast = Java.use('android.widget.Toast');
                Toast.makeText(context, "Token: " + str, Toast.LENGTH_LONG).show();
            } catch (e) {}
            
            // 复制到剪贴板
            try {
                var context = Java.use('c.e.a.a.b').getInstance().getContext();
                var ClipboardManager = Java.use('android.content.ClipboardManager');
                var ClipData = Java.use('android.content.ClipData');
                var clipboard = context.getSystemService('clipboard');
                clipboard.setPrimaryClip(ClipData.newPlainText('token', str));
                console.log("[TOKEN] 已复制到剪贴板");
            } catch (e) {}
            
            return this.saveToken(str);
        };
        console.log("[✓] 已Hook: BaseModel.saveToken");
    } catch (e) {
        console.log("[✗] Hook BaseModel.saveToken 失败: " + e);
    }
    
    // ========== 2. Hook BaseModel.savePublicKey ==========
    try {
        var BaseModel = Java.use('com.chinavisionary.core.app.net.base.model.BaseModel');
        
        BaseModel.savePublicKey.implementation = function(str) {
            console.log("\n============================");
            console.log("[PUBLIC_KEY] 捕获到公钥:");
            console.log("[PUBLIC_KEY] " + str);
            console.log("============================\n");
            
            return this.savePublicKey(str);
        };
        console.log("[✓] 已Hook: BaseModel.savePublicKey");
    } catch (e) {
        console.log("[✗] Hook BaseModel.savePublicKey 失败: " + e);
    }
    
    // ========== 3. Hook w.putString (SharedPreferences) ==========
    try {
        var w = Java.use('c.e.a.d.w');
        
        w.putString.implementation = function(key, value) {
            // 只显示重要的key
            if (key && (key.includes('Token') || key.includes('token') || 
                key.includes('user') || key.includes('User') ||
                key.includes('key') || key.includes('Key') ||
                key.includes('secret') || key.includes('Secret'))) {
                console.log("\n[SP] SharedPreferences存储:");
                console.log("[SP] Key: " + key);
                console.log("[SP] Value: " + value);
            }
            
            return this.putString(key, value);
        };
        console.log("[✓] 已Hook: w.putString");
    } catch (e) {
        console.log("[✗] Hook w.putString 失败: " + e);
    }
    
    // ========== 4. Hook SecretKeyBo ==========
    try {
        var SecretKeyBo = Java.use('com.chinavisionary.microtang.login.bo.SecretKeyBo');
        
        // Hook所有getter方法
        var methods = SecretKeyBo.class.getDeclaredMethods();
        for (var i = 0; i < methods.length; i++) {
            var methodName = methods[i].getName();
            if (methodName.startsWith('get')) {
                console.log("[SECRET_KEY] 发现方法: " + methodName);
            }
        }
    } catch (e) {
        console.log("[✗] 分析SecretKeyBo失败: " + e);
    }
    
    // ========== 5. Hook NewUserModel登录相关 ==========
    try {
        var NewUserModel = Java.use('com.chinavisionary.microtang.me.model.NewUserModel');
        
        NewUserModel.doLogin.implementation = function(loginBo) {
            console.log("\n============================");
            console.log("[LOGIN] 执行登录操作:");
            console.log("[LOGIN] 参数: " + JSON.stringify(loginBo));
            console.log("============================\n");
            
            return this.doLogin(loginBo);
        };
        console.log("[✓] 已Hook: NewUserModel.doLogin");
    } catch (e) {
        console.log("[✗] Hook NewUserModel.doLogin 失败: " + e);
    }
    
    // ========== 6. Hook网络请求 ==========
    try {
        var b = Java.use('c.e.c.x.a.b');
        
        // 查看所有方法
        var methods = b.class.getDeclaredMethods();
        console.log("\n[API] 发现API接口方法:");
        for (var i = 0; i < methods.length; i++) {
            var methodName = methods[i].getName();
            if (methodName.includes('login') || methodName.includes('Login') ||
                methodName.includes('token') || methodName.includes('Token') ||
                methodName.includes('key') || methodName.includes('Key')) {
                console.log("[API] " + methodName);
            }
        }
    } catch (e) {
        console.log("[✗] 分析API接口失败: " + e);
    }
    
    console.log("\n========================================");
    console.log("[*] Hook安装完成!");
    console.log("[*] 请在APP中执行登录操作");
    console.log("[*] 登录信息将显示在控制台和Toast中");
    console.log("[*] Token会自动复制到剪贴板");
    console.log("========================================\n");
});

/**
 * 使用方法:
 * 1. 安装Frida: pip install frida-tools
 * 2. 手机安装frida-server并运行
 * 3. 运行: frida -U -f com.chinavisionary.microtang -l hook_token.js --no-pause
 * 4. 在APP中执行登录操作
 * 5. 查看控制台输出的Token信息
 */