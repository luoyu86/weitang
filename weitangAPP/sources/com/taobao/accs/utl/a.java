package com.taobao.accs.utl;

import anet.channel.util.ALog;
import com.alibaba.sdk.android.logger.ILogger;
import com.alibaba.sdk.android.logger.LogLevel;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ILogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ALog.ILog f10472a;

    public a(ALog.ILog iLog) {
        this.f10472a = iLog;
    }

    @Override // com.alibaba.sdk.android.logger.ILogger
    public void print(LogLevel logLevel, String str, String str2) {
        try {
            int i2 = b.f10473a[logLevel.ordinal()];
            if (i2 == 1) {
                this.f10472a.d(str, str2);
            } else if (i2 == 2) {
                this.f10472a.i(str, str2);
            } else if (i2 == 3) {
                this.f10472a.w(str, str2);
            } else if (i2 == 4) {
                this.f10472a.e(str, str2);
            }
        } catch (Throwable unused) {
        }
    }
}
