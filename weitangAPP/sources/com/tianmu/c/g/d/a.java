package com.tianmu.c.g.d;

import androidx.core.app.NotificationCompat;
import com.tianmu.biz.utils.n0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f11590e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f11591f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f11592g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<String> f11593h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<String> f11594i;
    private List<String> j;
    private List<String> k;
    private List<String> l;
    private int m;
    private long n;
    private int o;

    public static String o() {
        return "create table download_app_info (key text,path text,name text,cover text,package_name text,click_id text,scheme text,start_downloads text,downloadeds text,start_installs text,installeds text,opens text,progress text,size integer,create_time integer,primary key(package_name))";
    }

    public static String p() {
        return "drop table download_app_info";
    }

    public String a() {
        return this.f11591f;
    }

    public String b() {
        return this.f11589d;
    }

    public String c() {
        return n0.a(this.f11594i);
    }

    public String d() {
        return n0.a(this.k);
    }

    public String e() {
        return this.f11586a;
    }

    public String f() {
        return this.f11588c;
    }

    public String g() {
        return n0.a(this.l);
    }

    public String h() {
        return this.f11590e;
    }

    public String i() {
        return this.f11587b;
    }

    public void j(String str) {
        this.f11592g = str;
    }

    public String k() {
        return this.f11592g;
    }

    public void l(String str) {
        this.j = n0.a(str);
    }

    public String m() {
        return n0.a(this.f11593h);
    }

    public String n() {
        return n0.a(this.j);
    }

    public String toString() {
        return "path: " + this.f11587b + ", key: " + this.f11586a + ", package_name: " + this.f11590e + ", name: " + this.f11588c + ", cover: " + this.f11589d + ", click_id: " + this.f11591f + ", scheme: " + this.f11592g + ", start_downloads: " + this.f11593h + ", downloadeds: " + this.f11594i + ", start_installs: " + this.j + ", installeds: " + this.k + ", opens: " + this.l + ", " + NotificationCompat.CATEGORY_PROGRESS + ": " + this.m + ", size: " + this.n + ", create_time: " + this.o;
    }

    public void a(String str) {
        this.f11591f = str;
    }

    public void b(String str) {
        this.f11589d = str;
    }

    public void c(String str) {
        this.f11594i = n0.a(str);
    }

    public void d(String str) {
        this.k = n0.a(str);
    }

    public void e(String str) {
        this.f11586a = str;
    }

    public void f(String str) {
        this.f11588c = str;
    }

    public void g(String str) {
        this.l = n0.a(str);
    }

    public void h(String str) {
        this.f11590e = str;
    }

    public void i(String str) {
        this.f11587b = str;
    }

    public int j() {
        return this.m;
    }

    public void k(String str) {
        this.f11593h = n0.a(str);
    }

    public long l() {
        return this.n;
    }

    public void a(long j) {
        this.n = j;
    }

    public void b(int i2) {
        this.m = i2;
    }

    public void a(int i2) {
        this.o = i2;
    }
}
