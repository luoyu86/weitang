@echo off
echo ========================================
echo Frida环境安装脚本
echo ========================================

echo.
echo [1/3] 安装Frida Python包...
pip install frida-tools frida
if %errorlevel% neq 0 (
    echo 安装失败，请检查Python和pip是否正确安装
    pause
    exit /b 1
)
echo 安装成功!

echo.
echo [2/3] 检查ADB连接...
adb devices
if %errorlevel% neq 0 (
    echo ADB未安装或未连接设备
    echo 请安装Android SDK Platform Tools
    pause
    exit /b 1
)

echo.
echo [3/3] 下载frida-server...
echo 请手动下载frida-server:
echo 1. 访问 https://github.com/frida/frida/releases
echo 2. 下载与你手机架构匹配的版本
echo    - 大多数手机: frida-server-XX.X.X-android-arm64.xz
echo 3. 解压后执行:
echo    adb push frida-server /data/local/tmp/
echo    adb shell chmod 755 /data/local/tmp/frida-server
echo    adb shell /data/local/tmp/frida-server &
echo.

echo ========================================
echo 安装完成!
echo.
echo 使用方法:
echo 1. 手机开启USB调试并连接电脑
echo 2. 运行: adb shell /data/local/tmp/frida-server &
echo 3. 运行: frida -U -f com.chinavisionary.microtang -l hook_token.js --no-pause
echo 4. 在APP中执行登录操作
echo ========================================
pause