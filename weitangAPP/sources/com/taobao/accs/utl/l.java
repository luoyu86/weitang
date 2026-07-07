package com.taobao.accs.utl;

import anet.channel.util.ALog;
import com.alibaba.sdk.android.logger.ILog;

/* JADX INFO: loaded from: classes2.dex */
public class l implements ALog.ILog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ILog f10489a = AccsLogger.getLogger("NetworkSdk");

    private String a(String str, String str2) {
        return "[" + str + "]" + str2;
    }

    @Override // anet.channel.util.ALog.ILog
    public void d(String str, String str2) {
        this.f10489a.d(a(str, str2));
    }

    @Override // anet.channel.util.ALog.ILog
    public void e(String str, String str2) {
        this.f10489a.e(a(str, str2));
    }

    @Override // anet.channel.util.ALog.ILog
    public void i(String str, String str2) {
        this.f10489a.i(a(str, str2));
    }

    @Override // anet.channel.util.ALog.ILog
    public boolean isPrintLog(int i2) {
        return true;
    }

    @Override // anet.channel.util.ALog.ILog
    public boolean isValid() {
        return true;
    }

    @Override // anet.channel.util.ALog.ILog
    public void setLogLevel(int i2) {
    }

    @Override // anet.channel.util.ALog.ILog
    public void w(String str, String str2) {
        this.f10489a.w(a(str, str2));
    }

    @Override // anet.channel.util.ALog.ILog
    public void e(String str, String str2, Throwable th) {
        this.f10489a.e(a(str, str2), th);
    }

    @Override // anet.channel.util.ALog.ILog
    public void w(String str, String str2, Throwable th) {
        this.f10489a.w(a(str, str2), th);
    }
}
