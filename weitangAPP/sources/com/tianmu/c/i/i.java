package com.tianmu.c.i;

import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f11721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f11723e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11724f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONArray f11725g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11726h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11727i;

    public i(String str, String str2, double d2, String str3, String str4, int i2, JSONArray jSONArray, int i3, int i4) {
        this.f11719a = str;
        this.f11720b = str2;
        this.f11721c = d2;
        this.f11722d = str3;
        this.f11723e = str4;
        this.f11724f = i2;
        this.f11725g = jSONArray;
        this.f11726h = i3;
        this.f11727i = i4;
    }

    public double a() {
        return this.f11721c;
    }

    public String b() {
        return this.f11722d;
    }

    public String c() {
        return this.f11719a;
    }

    public String d() {
        return this.f11720b;
    }

    public String e() {
        return this.f11723e;
    }

    public JSONArray f() {
        return this.f11725g;
    }

    public boolean g() {
        return this.f11727i == 0;
    }

    public boolean h() {
        return this.f11726h == 3;
    }

    public boolean i() {
        return this.f11726h == 1;
    }

    public boolean j() {
        return this.f11724f == 1;
    }
}
