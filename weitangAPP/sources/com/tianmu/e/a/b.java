package com.tianmu.e.a;

import com.tianmu.e.a.b;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public class b<T extends b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tianmu.http.constant.a f11994a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f11995b;

    private com.tianmu.http.constant.a c() {
        return new com.tianmu.http.constant.a("application/x-www-form-urlencoded", "application/json", "UTF-8", 5000L, 5000L, false);
    }

    public T a(Map<String, String> map) {
        this.f11995b = map;
        return this;
    }

    public T b(long j) {
        this.f11994a.b(j);
        return this;
    }

    public Map<String, String> a() {
        return this.f11995b;
    }

    public com.tianmu.http.constant.a b() {
        return this.f11994a;
    }

    public T a(long j) {
        this.f11994a.a(j);
        return this;
    }

    public void a(HostnameVerifier hostnameVerifier) {
        this.f11994a.a(hostnameVerifier);
    }

    public void a(SSLSocketFactory sSLSocketFactory) {
        this.f11994a.a(sSLSocketFactory);
    }
}
