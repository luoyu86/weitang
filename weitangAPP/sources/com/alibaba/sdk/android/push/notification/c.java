package com.alibaba.sdk.android.push.notification;

import android.app.Notification;
import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f5012e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f5013f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5014g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f5015h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f5016i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;

    public c() {
        int i2 = Build.VERSION.SDK_INT;
        this.f5010c = 0;
        this.f5014g = 0;
    }

    public abstract Notification a(Context context, PushData pushData, NotificationConfigure notificationConfigure);

    public String a() {
        return this.f5008a;
    }

    public void a(int i2) {
        this.f5010c = i2;
    }

    public void a(String str) {
        this.f5008a = str;
    }

    public abstract Notification b(Context context, PushData pushData, NotificationConfigure notificationConfigure);

    public String b() {
        return this.f5009b;
    }

    public void b(int i2) {
        this.f5014g = i2;
    }

    public void b(String str) {
        this.f5009b = str;
    }

    public int c() {
        return this.f5010c;
    }

    public void c(String str) {
        this.f5011d = str;
    }

    public String d() {
        return this.f5011d;
    }

    public void d(String str) {
        this.f5013f = str;
    }

    public String e() {
        return this.l;
    }

    public void e(String str) {
        this.f5015h = str;
    }

    public String f() {
        return this.m;
    }

    public void f(String str) {
        this.f5016i = str;
    }

    public String g() {
        return this.n;
    }

    public void g(String str) {
        this.j = str;
    }

    public void h(String str) {
        this.k = str;
    }

    public void i(String str) {
        this.f5012e = str;
    }

    public void j(String str) {
        this.l = str;
    }

    public void k(String str) {
        this.m = str;
    }

    public void l(String str) {
        this.n = str;
    }
}
