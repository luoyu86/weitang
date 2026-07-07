@echo off
echo Installing frida-tools...
python -m pip install frida-tools frida
echo.
echo Done! Next steps:
echo 1. Download frida-server from https://github.com/frida/frida/releases
echo 2. adb push frida-server /data/local/tmp/
echo 3. adb shell chmod 755 /data/local/tmp/frida-server
echo 4. adb shell /data/local/tmp/frida-server &
echo 5. frida -U -f com.chinavisionary.microtang -l hook_token.js --no-pause
pause