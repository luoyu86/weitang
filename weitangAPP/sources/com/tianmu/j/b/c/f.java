package com.tianmu.j.b.c;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tianmu.c.f.d1;
import com.tianmu.j.b.c.a;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class f<P extends com.tianmu.j.b.c.a> extends FrameLayout implements com.tianmu.j.b.a.e, a.InterfaceC0229a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public P f12296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g<P> f12297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public com.tianmu.j.b.a.a f12298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f12299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.tianmu.j.b.d.a f12300e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.tianmu.j.b.d.c f12301f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12302g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f12303h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f12304i;
    public String j;
    public Map<String, String> k;
    public AssetFileDescriptor l;
    public long m;
    public int n;
    public boolean o;
    public boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f12305q;
    public boolean r;

    @Nullable
    public d s;
    public List<a> t;

    @Nullable
    public h u;
    public boolean v;
    public final int w;

    public interface a {
        void a(int i2);

        void b(int i2);
    }

    public f(@NonNull Context context) {
        this(context, null);
    }

    private boolean E() {
        return this.n == 5;
    }

    private boolean F() {
        return this.n == 8;
    }

    public void A() {
        this.f12296a.a(this.v);
        float f2 = this.f12304i ? 0.0f : 1.0f;
        this.f12296a.a(f2, f2);
    }

    public boolean B() {
        com.tianmu.j.b.a.a aVar;
        return (r() || (aVar = this.f12298c) == null || !aVar.h()) ? false : true;
    }

    public void C() {
        this.f12296a.j();
        a(3);
        if (this.s != null && !s()) {
            this.s.b();
        }
        this.f12299d.setKeepScreenOn(true);
    }

    public boolean D() {
        if (B()) {
            a(8);
            return false;
        }
        if (this.r) {
            this.s = new d(this);
        }
        h hVar = this.u;
        if (hVar != null) {
            this.m = hVar.a(this.j);
        }
        n();
        f();
        d(false);
        return true;
    }

    public void a(long j) {
        if (q()) {
            this.f12296a.a(j);
        }
    }

    @Override // com.tianmu.j.b.a.e
    public void b(boolean z) {
        if (z) {
            this.m = 0L;
        }
        f();
        d(true);
    }

    public void c(boolean z) {
        this.r = z;
    }

    public void d(boolean z) {
        if (z) {
            this.f12296a.i();
            A();
        }
        if (v()) {
            this.f12296a.g();
            a(1);
            b(i() ? 11 : t() ? 12 : 10);
        }
    }

    @Override // com.tianmu.j.b.a.e
    public boolean e() {
        return q() && this.f12296a.e();
    }

    public void f() {
        com.tianmu.j.b.d.a aVar = this.f12300e;
        if (aVar != null) {
            this.f12299d.removeView(aVar.a());
            this.f12300e.release();
        }
        com.tianmu.j.b.d.a aVarA = this.f12301f.a(getContext());
        this.f12300e = aVarA;
        aVarA.a(this.f12296a);
        this.f12299d.addView(this.f12300e.a(), 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    @Override // com.tianmu.j.b.a.e
    public void g() {
        if (p() || F() || E()) {
            D();
        } else if (q()) {
            C();
        }
    }

    @Override // com.tianmu.j.b.a.e
    public long h() {
        if (q()) {
            return this.f12296a.b();
        }
        return 0L;
    }

    @Override // com.tianmu.j.b.a.e
    public boolean i() {
        return this.o;
    }

    @Override // com.tianmu.j.b.a.e
    public long j() {
        if (!q()) {
            return 0L;
        }
        long jA = this.f12296a.a();
        this.m = jA;
        return jA;
    }

    @Override // com.tianmu.j.b.a.e
    public void k() {
        ViewGroup viewGroupM;
        if (this.o && (viewGroupM = m()) != null) {
            this.o = false;
            b(viewGroupM);
            viewGroupM.removeView(this.f12299d);
            addView(this.f12299d);
            b(10);
        }
    }

    public Activity l() {
        com.tianmu.j.b.a.a aVar = this.f12298c;
        if (aVar == null) {
            return com.tianmu.j.b.e.b.c(getContext());
        }
        Activity activityC = com.tianmu.j.b.e.b.c(aVar.getContext());
        return activityC == null ? com.tianmu.j.b.e.b.c(getContext()) : activityC;
    }

    public ViewGroup m() {
        Activity activityL = l();
        if (activityL == null) {
            return null;
        }
        return (ViewGroup) activityL.getWindow().getDecorView();
    }

    public void n() {
        P p = (P) this.f12297b.a(getContext());
        this.f12296a = p;
        p.a(this);
        z();
        this.f12296a.d();
        A();
    }

    public void o() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f12299d = frameLayout;
        frameLayout.setBackgroundColor(0);
        addView(this.f12299d, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.tianmu.j.b.c.a.InterfaceC0229a
    public void onError() {
        this.f12299d.setKeepScreenOn(false);
        a(-1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        com.tianmu.j.b.e.c.a("onSaveInstanceState: " + this.m);
        y();
        return super.onSaveInstanceState();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.o) {
            a(m());
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (i2 == 8) {
            u();
        }
    }

    public boolean p() {
        return this.n == 0;
    }

    public boolean q() {
        int i2;
        return (this.f12296a == null || (i2 = this.n) == -1 || i2 == 0 || i2 == 1 || i2 == 8 || i2 == 5) ? false : true;
    }

    public boolean r() {
        if (this.l != null) {
            return true;
        }
        if (TextUtils.isEmpty(this.j)) {
            return false;
        }
        Uri uri = Uri.parse(this.j);
        return "android.resource".equals(uri.getScheme()) || "file".equals(uri.getScheme()) || "rawresource".equals(uri.getScheme());
    }

    public boolean s() {
        return this.f12304i;
    }

    @Override // android.view.View
    public void setRotation(float f2) {
        com.tianmu.j.b.d.a aVar = this.f12300e;
        if (aVar != null) {
            aVar.b((int) f2);
        }
    }

    public boolean t() {
        return this.p;
    }

    public void u() {
        if (q() && this.f12296a.e()) {
            this.f12296a.f();
            a(4);
            if (this.s != null && !s()) {
                this.s.a();
            }
            this.f12299d.setKeepScreenOn(false);
        }
    }

    public boolean v() {
        AssetFileDescriptor assetFileDescriptor = this.l;
        if (assetFileDescriptor != null) {
            this.f12296a.a(assetFileDescriptor);
            return true;
        }
        if (TextUtils.isEmpty(this.j)) {
            return false;
        }
        this.f12296a.a(this.j, this.k);
        return true;
    }

    public void w() {
        if (p()) {
            return;
        }
        P p = this.f12296a;
        if (p != null) {
            if (p.e()) {
                this.f12296a.k();
            }
            this.f12296a.i();
            this.f12296a.h();
            this.f12296a = null;
        }
        com.tianmu.j.b.d.a aVar = this.f12300e;
        if (aVar != null) {
            this.f12299d.removeView(aVar.a());
            this.f12300e.release();
            this.f12300e = null;
        }
        AssetFileDescriptor assetFileDescriptor = this.l;
        if (assetFileDescriptor != null) {
            try {
                assetFileDescriptor.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        d dVar = this.s;
        if (dVar != null) {
            dVar.a();
            this.s = null;
        }
        this.f12299d.setKeepScreenOn(false);
        y();
        this.m = 0L;
        a(0);
    }

    public void x() {
        if (!q() || this.f12296a.e()) {
            return;
        }
        this.f12296a.j();
        a(3);
        if (this.s != null && !s()) {
            this.s.b();
        }
        this.f12299d.setKeepScreenOn(true);
    }

    public void y() {
        if (this.u == null || this.m <= 0) {
            return;
        }
        com.tianmu.j.b.e.c.a("saveProgress: " + this.m);
        this.u.a(this.j, this.m);
    }

    public void z() {
    }

    public f(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.tianmu.j.b.a.e
    public void c() {
        ViewGroup viewGroupM;
        if (this.o || (viewGroupM = m()) == null) {
            return;
        }
        this.o = true;
        a(viewGroupM);
        removeView(this.f12299d);
        viewGroupM.addView(this.f12299d);
        b(11);
    }

    public f(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12303h = new int[]{0, 0};
        this.n = 0;
        j jVarB = k.b();
        this.r = jVarB.f12308c;
        this.u = jVarB.f12310e;
        this.f12297b = jVarB.f12311f;
        this.f12302g = jVarB.f12312g;
        this.f12301f = jVarB.f12313h;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d1.a.f11321a);
        this.r = typedArrayObtainStyledAttributes.getBoolean(d1.a.f11322b, this.r);
        this.v = typedArrayObtainStyledAttributes.getBoolean(d1.a.f11323c, false);
        this.f12302g = typedArrayObtainStyledAttributes.getInt(d1.a.f11324d, this.f12302g);
        this.w = typedArrayObtainStyledAttributes.getColor(d1.a.f11325e, -16777216);
        typedArrayObtainStyledAttributes.recycle();
        o();
    }

    @Override // com.tianmu.j.b.a.e
    public void a(boolean z) {
        this.f12304i = z;
        P p = this.f12296a;
        if (p != null) {
            float f2 = z ? 0.0f : 1.0f;
            p.a(f2, f2);
        }
    }

    @Override // com.tianmu.j.b.c.a.InterfaceC0229a
    public void b() {
        d dVar;
        a(2);
        if (!s() && (dVar = this.s) != null) {
            dVar.b();
        }
        long j = this.m;
        if (j > 0) {
            a(j);
        }
        this.f12305q = true;
    }

    @Override // com.tianmu.j.b.c.a.InterfaceC0229a
    public void a(int i2, int i3) {
        if (i2 == 3) {
            a(3);
            this.f12299d.setKeepScreenOn(true);
            return;
        }
        if (i2 == 10001) {
            com.tianmu.j.b.d.a aVar = this.f12300e;
            if (aVar != null) {
                aVar.b(i3);
                return;
            }
            return;
        }
        if (i2 == 701) {
            a(6);
        } else {
            if (i2 != 702) {
                return;
            }
            a(7);
        }
    }

    @Override // com.tianmu.j.b.a.e
    public float d() {
        if (q()) {
            return this.f12296a.c();
        }
        return 1.0f;
    }

    public void c(int i2) {
        this.f12302g = i2;
        com.tianmu.j.b.d.a aVar = this.f12300e;
        if (aVar != null) {
            aVar.a(i2);
        }
    }

    private void b(ViewGroup viewGroup) {
        int systemUiVisibility = viewGroup.getSystemUiVisibility() & (-3);
        if (Build.VERSION.SDK_INT >= 19) {
            systemUiVisibility &= -4097;
        }
        viewGroup.setSystemUiVisibility(systemUiVisibility);
        l().getWindow().clearFlags(1024);
    }

    @Override // com.tianmu.j.b.c.a.InterfaceC0229a
    public void a() {
        this.f12299d.setKeepScreenOn(false);
        this.m = 0L;
        h hVar = this.u;
        if (hVar != null) {
            hVar.a(this.j, 0L);
        }
        a(5);
    }

    public void b(int i2, int i3) {
        int[] iArr = this.f12303h;
        iArr[0] = i2;
        iArr[1] = i3;
        com.tianmu.j.b.d.a aVar = this.f12300e;
        if (aVar != null) {
            aVar.a(this.f12302g);
            this.f12300e.a(i2, i3);
        }
    }

    public void a(String str) {
        a(str, (Map<String, String>) null);
    }

    public void a(String str, Map<String, String> map) {
        this.l = null;
        this.j = str;
        this.k = map;
    }

    public void b(int i2) {
        com.tianmu.j.b.a.a aVar = this.f12298c;
        if (aVar != null) {
            aVar.e(i2);
        }
        List<a> list = this.t;
        if (list != null) {
            for (a aVar2 : com.tianmu.j.b.e.b.a(list)) {
                if (aVar2 != null) {
                    aVar2.b(i2);
                }
            }
        }
    }

    public void a(float f2, float f3) {
        P p = this.f12296a;
        if (p != null) {
            p.a(f2, f3);
        }
    }

    private void a(ViewGroup viewGroup) {
        int systemUiVisibility = viewGroup.getSystemUiVisibility() | 2;
        if (Build.VERSION.SDK_INT >= 19) {
            systemUiVisibility |= 4096;
        }
        viewGroup.setSystemUiVisibility(systemUiVisibility);
        l().getWindow().setFlags(1024, 1024);
    }

    public void a(@Nullable com.tianmu.j.b.a.a aVar) {
        this.f12299d.removeView(this.f12298c);
        this.f12298c = aVar;
        if (aVar != null) {
            aVar.a(this);
            this.f12299d.addView(this.f12298c, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void a(int i2) {
        this.n = i2;
        com.tianmu.j.b.a.a aVar = this.f12298c;
        if (aVar != null) {
            aVar.d(i2);
        }
        List<a> list = this.t;
        if (list != null) {
            for (a aVar2 : com.tianmu.j.b.e.b.a(list)) {
                if (aVar2 != null) {
                    aVar2.a(i2);
                }
            }
        }
    }
}
