package com.alibaba.sdk.android.man.crashreporter.handler.nativeCrashHandler;

/* JADX INFO: loaded from: classes.dex */
public interface NativeExceptionHandler {
    void onNativeException(int i2, int i3, long j, long j2, String str, String str2, String str3, String str4, int i4, String str5, int i5, int i6, int i7, String str6, String str7);

    void onNativeExceptionStart(String str, String str2, String str3);
}
