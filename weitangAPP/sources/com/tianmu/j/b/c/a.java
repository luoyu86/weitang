package com.tianmu.j.b.c;

import android.content.res.AssetFileDescriptor;
import android.view.Surface;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC0229a f12279a;

    /* JADX INFO: renamed from: com.tianmu.j.b.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0229a {
        void a();

        void a(int i2, int i3);

        void b();

        void b(int i2, int i3);

        void onError();
    }

    public abstract long a();

    public abstract void a(float f2, float f3);

    public abstract void a(long j);

    public abstract void a(AssetFileDescriptor assetFileDescriptor);

    public abstract void a(Surface surface);

    public void a(InterfaceC0229a interfaceC0229a) {
        this.f12279a = interfaceC0229a;
    }

    public abstract void a(String str, Map<String, String> map);

    public abstract void a(boolean z);

    public abstract long b();

    public abstract float c();

    public abstract void d();

    public abstract boolean e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract void j();

    public abstract void k();
}
