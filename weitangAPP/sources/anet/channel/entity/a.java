package anet.channel.entity;

import anet.channel.strategy.IConnStrategy;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IConnStrategy f454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f455b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f456c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f458e;

    public a(String str, String str2, IConnStrategy iConnStrategy) {
        this.f454a = iConnStrategy;
        this.f457d = str;
        this.f458e = str2;
    }

    public String a() {
        IConnStrategy iConnStrategy = this.f454a;
        if (iConnStrategy != null) {
            return iConnStrategy.getIp();
        }
        return null;
    }

    public int b() {
        IConnStrategy iConnStrategy = this.f454a;
        if (iConnStrategy != null) {
            return iConnStrategy.getPort();
        }
        return 0;
    }

    public ConnType c() {
        IConnStrategy iConnStrategy = this.f454a;
        return iConnStrategy != null ? ConnType.valueOf(iConnStrategy.getProtocol()) : ConnType.HTTP;
    }

    public int d() {
        IConnStrategy iConnStrategy = this.f454a;
        return (iConnStrategy == null || iConnStrategy.getConnectionTimeout() == 0) ? com.alipay.sdk.m.m.a.e0 : this.f454a.getConnectionTimeout();
    }

    public int e() {
        IConnStrategy iConnStrategy = this.f454a;
        return (iConnStrategy == null || iConnStrategy.getReadTimeout() == 0) ? com.alipay.sdk.m.m.a.e0 : this.f454a.getReadTimeout();
    }

    public String f() {
        return this.f457d;
    }

    public int g() {
        IConnStrategy iConnStrategy = this.f454a;
        if (iConnStrategy != null) {
            return iConnStrategy.getHeartbeat();
        }
        return 45000;
    }

    public String h() {
        return this.f458e;
    }

    public String toString() {
        return "ConnInfo [ip=" + a() + ",port=" + b() + ",type=" + c() + ",hb" + g() + "]";
    }
}
