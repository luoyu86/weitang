package cn.admobiletop.adsuyi.a.f.b;

import cn.admobiletop.adsuyi.a.m.e;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3241e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f3242f;

    public a() {
        this.f3240d = 0;
        this.f3241e = 0;
        this.f3242f = e.b();
    }

    public static String a() {
        return "create table frequency (pos_id text(32),platform_pos_id text(32),fre_date text(32),fre_count integer,total_count integer,update_time integer,primary key(pos_id,platform_pos_id))";
    }

    public static String b() {
        return "drop table frequency";
    }

    public void a(String str) {
        this.f3239c = str;
    }

    public void b(String str) {
        this.f3238b = str;
    }

    public void c(String str) {
        this.f3237a = str;
    }

    public String d() {
        return this.f3239c;
    }

    public String e() {
        return this.f3238b;
    }

    public String f() {
        return this.f3237a;
    }

    public int g() {
        return this.f3241e;
    }

    public long h() {
        return this.f3242f;
    }

    public String toString() {
        return "posId: " + this.f3237a + ", platform_pos_id: " + this.f3238b + ", freDate: " + this.f3239c + ", totalCount: " + this.f3241e + ", updateTime: " + this.f3242f + ", freCount: " + this.f3240d;
    }

    public void a(int i2) {
        this.f3240d = i2;
    }

    public void b(int i2) {
        this.f3241e = i2;
    }

    public int c() {
        return this.f3240d;
    }

    public void a(long j) {
        this.f3242f = j;
    }

    public a(String str, String str2, String str3, int i2) {
        this.f3240d = 0;
        this.f3241e = 0;
        this.f3242f = e.b();
        this.f3237a = str;
        this.f3238b = str2;
        this.f3239c = str3;
        this.f3241e = i2;
    }
}
