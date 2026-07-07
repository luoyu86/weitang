package c.a.a.a.a.n;

import android.app.Notification;
import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f835e;

    public e() {
        int i2 = Build.VERSION.SDK_INT;
        this.f833c = 0;
    }

    public abstract Notification a(Context context);

    public String a() {
        return this.f831a;
    }

    public String b() {
        return this.f832b;
    }

    public int c() {
        return this.f833c;
    }

    public String d() {
        return this.f834d;
    }

    public String e() {
        return this.f835e;
    }

    public void a(String str) {
        this.f831a = str;
    }

    public void b(String str) {
        this.f832b = str;
    }

    public void c(String str) {
        this.f834d = str;
    }

    public void d(String str) {
        this.f835e = str;
    }

    public void a(int i2) {
        this.f833c = i2;
    }
}
