package com.alibaba.sdk.android.logger.b;

import com.alibaba.sdk.android.logger.LogLevel;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final LogLevel f4652a = LogLevel.WARN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4653b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LogLevel f4654c = f4652a;

    public void a(LogLevel logLevel) {
        this.f4654c = logLevel;
    }

    public void a(boolean z) {
        this.f4653b = z;
    }

    public boolean b(LogLevel logLevel) {
        return this.f4653b && logLevel.ordinal() >= this.f4654c.ordinal();
    }
}
