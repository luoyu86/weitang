package com.alibaba.sdk.android.push.notification;

import android.os.Build;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AmsLogger f4998a = AmsLogger.getLogger("MPS:CPushNotification");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ArrayList<Integer> f4999b = new ArrayList<>();
    private boolean A;
    private String B;
    private String C;
    private String D;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, String> f5000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f5001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f5002e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f5003f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f5004g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f5005h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f5006i = 0;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private boolean o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f5007q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    static {
        int i2 = Build.VERSION.SDK_INT;
        f4999b.add(-2);
        f4999b.add(0);
        f4999b.add(1);
        f4999b.add(-1);
        f4999b.add(2);
    }

    public b() {
        int i2 = Build.VERSION.SDK_INT;
        this.f5007q = 0;
        this.r = 0;
        this.s = 1;
        this.t = 0;
        this.u = 3;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.A = false;
    }

    public String a() {
        return this.f5004g;
    }

    public void a(int i2) {
        this.p = i2;
    }

    public void a(String str) {
        this.f5004g = str;
    }

    public void a(Map<String, String> map) {
        this.f5000c = map;
    }

    public void a(boolean z) {
        this.A = z;
    }

    public String b() {
        return this.f5001d;
    }

    public void b(int i2) {
        this.r = i2;
    }

    public void b(String str) {
        this.f5001d = str;
    }

    public String c() {
        return this.f5002e;
    }

    public void c(int i2) {
        this.s = i2;
    }

    public void c(String str) {
        this.f5002e = str;
    }

    public int d() {
        return this.p;
    }

    public void d(int i2) {
        this.t = i2;
    }

    public void d(String str) {
        this.f5003f = str;
    }

    public void e(int i2) {
        this.u = i2;
    }

    public void e(String str) {
        try {
            if (f4999b.contains(Integer.valueOf(Integer.parseInt(str)))) {
                this.f5007q = Integer.parseInt(str);
            }
        } catch (NumberFormatException e2) {
            f4998a.e("formar error:数字格式错误", e2);
        }
    }

    public boolean e() {
        return this.o;
    }

    public int f() {
        return this.r;
    }

    public void f(int i2) {
        this.v = i2;
    }

    public void f(String str) {
        this.n = str;
    }

    public int g() {
        return this.s;
    }

    public void g(int i2) {
        this.w = i2;
    }

    public void g(String str) {
        this.f5005h = str;
    }

    public int h() {
        return this.t;
    }

    public void h(int i2) {
        this.x = i2;
    }

    public void h(String str) {
        this.j = str;
    }

    public int i() {
        return this.u;
    }

    public void i(int i2) {
        this.y = i2;
    }

    public void i(String str) {
        this.k = str;
    }

    public int j() {
        return this.v;
    }

    public void j(int i2) {
        this.z = i2;
    }

    public void j(String str) {
        this.l = str;
    }

    public int k() {
        return this.w;
    }

    public void k(int i2) {
        this.f5006i = i2;
    }

    public void k(String str) {
        this.m = str;
    }

    public int l() {
        return this.x;
    }

    public void l(String str) {
        this.B = str;
    }

    public int m() {
        return this.y;
    }

    public void m(String str) {
        this.C = str;
    }

    public int n() {
        return this.z;
    }

    public void n(String str) {
        this.D = str;
    }

    public boolean o() {
        return this.A;
    }

    public int p() {
        return this.f5007q;
    }

    public String q() {
        return this.n;
    }

    public String r() {
        return this.f5005h;
    }

    public int s() {
        return this.f5006i;
    }

    public String t() {
        return this.j;
    }

    public String u() {
        return this.k;
    }

    public String v() {
        return this.l;
    }

    public String w() {
        return this.m;
    }

    public String x() {
        return this.B;
    }

    public String y() {
        return this.C;
    }

    public String z() {
        return this.D;
    }
}
