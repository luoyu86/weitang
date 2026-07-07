package com.alibaba.sdk.android.man.crashreporter;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface IUTCrashCaughtListener {
    Map<String, Object> onCrashCaught(Thread thread, Throwable th);
}
