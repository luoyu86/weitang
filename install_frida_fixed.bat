@echo off
chcp 65001 >nul
echo ========================================
echo Frida Installation Script
echo ========================================

echo.
echo [1/3] Installing frida-tools...
pip install frida-tools frida
if %errorlevel% neq 0 (
    echo Failed to install frida-tools
    echo Please ensure Python and pip are installed
    pause
    exit /b 1
)
echo Done!

echo.
echo [2/3] Checking ADB...
adb devices
if %errorlevel% neq 0 (
    echo ADB not found
    echo Please install Android SDK Platform Tools
    pause
    exit /b 1
)

echo.
echo ========================================
echo Installation Complete!
echo.
echo Next steps:
echo 1. Download frida-server from GitHub
echo 2. Push to phone: adb push frida-server /data/local/tmp/
echo 3. Run: adb shell /data/local/tmp/frida-server &
echo 4. Run: frida -U -f com.chinavisionary.microtang -l hook_token.js --no-pause
echo ========================================
pause