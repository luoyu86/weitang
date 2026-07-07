package com.tianmu.d.a;

import android.text.TextUtils;
import com.tianmu.biz.utils.n0;
import com.tianmu.biz.utils.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f11967e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f11968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<String> f11969g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<String> f11970h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<String> f11971i;
    private long j = o.b();

    public a() {
    }

    public static String n() {
        return "create table download_apk (package_name text,path text,name text,cover text,click_id text,scheme text,starts text,ends text,opens text,create_time integer,primary key(package_name))";
    }

    public static String o() {
        return "drop table download_apk";
    }

    public String a() {
        return this.f11967e;
    }

    public String b() {
        return this.f11966d;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f11970h = new ArrayList();
        } else {
            this.f11970h = Arrays.asList(str.split(","));
        }
    }

    public void d(String str) {
        this.f11965c = str;
    }

    public String e() {
        return n0.a(this.f11970h);
    }

    public void f(String str) {
        this.f11964b = str;
    }

    public void g(String str) {
        this.f11963a = str;
    }

    public String h() {
        return n0.a(this.f11971i);
    }

    public String i() {
        return this.f11964b;
    }

    public String j() {
        return this.f11963a;
    }

    public String k() {
        return this.f11968f;
    }

    public List<String> l() {
        return this.f11969g;
    }

    public String m() {
        return n0.a(this.f11969g);
    }

    public String toString() {
        return "path: " + this.f11963a + ", package_name: " + this.f11964b + ", name: " + this.f11965c + ", cover: " + this.f11966d + ", click_id: " + this.f11967e + ", scheme: " + this.f11968f + ", starts: " + this.f11969g + ", ends: " + this.f11970h + ", opens: " + this.f11971i + ", create_time: " + this.j;
    }

    public void a(String str) {
        this.f11967e = str;
    }

    public void b(String str) {
        this.f11966d = str;
    }

    public List<String> d() {
        return this.f11970h;
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f11971i = new ArrayList();
        } else {
            this.f11971i = Arrays.asList(str.split(","));
        }
    }

    public String f() {
        return this.f11965c;
    }

    public List<String> g() {
        return this.f11971i;
    }

    public void h(String str) {
        this.f11968f = str;
    }

    public void i(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f11969g = new ArrayList();
        } else {
            this.f11969g = Arrays.asList(str.split(","));
        }
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, List<String> list, List<String> list2, List<String> list3) {
        this.f11963a = str;
        this.f11964b = str2;
        this.f11965c = str3;
        this.f11966d = str4;
        this.f11967e = str5;
        this.f11968f = str6;
        this.f11969g = list;
        this.f11970h = list2;
        this.f11971i = list3;
    }

    public void a(long j) {
        this.j = j;
    }

    public long c() {
        return this.j;
    }
}
