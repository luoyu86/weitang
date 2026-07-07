package c.a.a.a.a.n;

import android.os.Build;
import com.taobao.accs.utl.ALog;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ArrayList<Integer> f820a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f825f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f826g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f827h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f828i;
    public int j;
    public int k;
    public int l;
    public String m;
    public String n;
    public String o;
    public String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f829q;
    public String r;

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f820a.add(-2);
            f820a.add(0);
            f820a.add(1);
            f820a.add(-1);
            f820a.add(2);
            return;
        }
        f820a.add(-2);
        f820a.add(0);
        f820a.add(1);
        f820a.add(-1);
        f820a.add(2);
    }

    public a() {
        int i2 = Build.VERSION.SDK_INT;
        this.l = 0;
    }

    public int a() {
        return this.j;
    }

    public String b() {
        return this.f824e;
    }

    public String c() {
        return this.f825f;
    }

    public String d() {
        return this.f826g;
    }

    public Map<String, String> e() {
        return this.f821b;
    }

    public String f() {
        return this.f822c;
    }

    public String g() {
        return this.f823d;
    }

    public String h() {
        return this.f827h;
    }

    public int i() {
        return this.k;
    }

    public int j() {
        return this.l;
    }

    public String k() {
        return this.m;
    }

    public String l() {
        return this.n;
    }

    public String m() {
        return this.f828i;
    }

    public String n() {
        return this.o;
    }

    public String o() {
        return this.p;
    }

    public String p() {
        return this.f829q;
    }

    public void a(int i2) {
        this.j = i2;
    }

    public void b(String str) {
        this.f825f = str;
    }

    public void c(String str) {
        this.f826g = str;
    }

    public void d(String str) {
        this.f822c = str;
    }

    public void e(String str) {
        this.f823d = str;
    }

    public void f(String str) {
        this.f827h = str;
    }

    public void g(String str) {
        try {
            if (f820a.contains(Integer.valueOf(Integer.parseInt(str)))) {
                this.l = Integer.parseInt(str);
            }
        } catch (NumberFormatException e2) {
            ALog.e("MPS:CPushNotification", "formar error:数字格式错误", e2, new Object[0]);
        }
    }

    public void h(String str) {
        this.m = str;
    }

    public void i(String str) {
        this.n = str;
    }

    public void j(String str) {
        this.f828i = str;
    }

    public void k(String str) {
        this.o = str;
    }

    public void l(String str) {
        this.p = str;
    }

    public void m(String str) {
        this.f829q = str;
    }

    public void n(String str) {
        this.r = str;
    }

    public void a(String str) {
        this.f824e = str;
    }

    public void b(int i2) {
        if (i2 < 0) {
            this.k = i2 * (-1);
        } else {
            this.k = i2;
        }
    }

    public void a(Map<String, String> map) {
        this.f821b = map;
    }
}
