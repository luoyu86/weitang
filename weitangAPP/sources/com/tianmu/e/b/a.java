package com.tianmu.e.b;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.tianmu.http.constant.a f11999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, String> f12000e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, String> f12001f;

    public a(String str, String str2, com.tianmu.http.constant.a aVar) {
        this.f11996a = str;
        this.f11997b = str2;
        this.f11999d = aVar;
    }

    public void a(String str) {
        this.f11998c = str;
    }

    public com.tianmu.http.constant.a b() {
        return this.f11999d;
    }

    public String c() {
        return this.f11998c;
    }

    public String d() {
        return this.f11996a;
    }

    public Map<String, String> e() {
        return this.f12000e;
    }

    public String f() {
        return this.f11997b;
    }

    public Map<String, String> a() {
        return this.f12001f;
    }

    public void b(Map<String, String> map) {
        this.f12000e = map;
    }

    public void a(Map<String, String> map) {
        this.f12001f = map;
    }
}
