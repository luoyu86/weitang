package com.taobao.accs.utl;

import anet.channel.util.ALog;

/* JADX INFO: loaded from: classes2.dex */
public class k implements ALog.ILog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ALog.ILog f10487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f10488b;

    public interface a {
        void a(String str);
    }

    public k(ALog.ILog iLog, a aVar) {
        this.f10487a = iLog;
        this.f10488b = aVar;
    }

    @Override // anet.channel.util.ALog.ILog
    public void d(String str, String str2) {
        this.f10487a.d(str, str2);
        this.f10488b.a(str2);
    }

    @Override // anet.channel.util.ALog.ILog
    public void e(String str, String str2) {
        this.f10487a.e(str, str2);
        this.f10488b.a(str2);
    }

    @Override // anet.channel.util.ALog.ILog
    public void i(String str, String str2) {
        this.f10487a.i(str, str2);
        this.f10488b.a(str2);
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
        this.f10487a.w(str, str2);
        this.f10488b.a(str2);
    }

    @Override // anet.channel.util.ALog.ILog
    public void e(String str, String str2, Throwable th) {
        this.f10487a.e(str, str2, th);
        this.f10488b.a(str2 + " " + th.getMessage());
    }

    @Override // anet.channel.util.ALog.ILog
    public void w(String str, String str2, Throwable th) {
        this.f10487a.w(str, str2, th);
        this.f10488b.a(str2 + " " + th.getMessage());
    }
}
