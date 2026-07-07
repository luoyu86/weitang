package cn.admobiletop.adsuyi.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import cn.admobiletop.adsuyi.c.A;
import cn.admobiletop.adsuyi.c.G;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f4168a = new AtomicInteger();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final A f4169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final G.a f4170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f4172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4173f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4174g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4175h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4176i;
    public int j;
    public Drawable k;
    public Drawable l;
    public Object m;

    public H(A a2, Uri uri, int i2) {
        if (a2.f4116q) {
            throw new IllegalStateException("Picasso getInstance already shut down. Cannot submit new requests.");
        }
        this.f4169b = a2;
        this.f4170c = new G.a(uri, i2, a2.n);
    }

    public H a(int i2, int i3) {
        this.f4170c.a(i2, i3);
        return this;
    }

    public H b() {
        this.f4172e = false;
        return this;
    }

    public final Drawable c() {
        return this.f4174g != 0 ? this.f4169b.f4113g.getResources().getDrawable(this.f4174g) : this.k;
    }

    public void a(ImageView imageView) {
        a(imageView, (InterfaceC0332l) null);
    }

    public void a(ImageView imageView, InterfaceC0332l interfaceC0332l) {
        Bitmap bitmapJ;
        long jNanoTime = System.nanoTime();
        S.l();
        if (imageView != null) {
            if (!this.f4170c.b()) {
                this.f4169b.a(imageView);
                if (this.f4173f) {
                    D.d(imageView, c());
                    return;
                }
                return;
            }
            if (this.f4172e) {
                if (!this.f4170c.c()) {
                    int width = imageView.getWidth();
                    int height = imageView.getHeight();
                    if (width != 0 && height != 0) {
                        this.f4170c.a(width, height);
                    } else {
                        if (this.f4173f) {
                            D.d(imageView, c());
                        }
                        this.f4169b.e(imageView, new ViewTreeObserverOnPreDrawListenerC0334n(this, imageView, interfaceC0332l));
                        return;
                    }
                } else {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
            }
            G gA = a(jNanoTime);
            String strH = S.h(gA);
            if (w.a(this.f4176i) && (bitmapJ = this.f4169b.j(strH)) != null) {
                this.f4169b.a(imageView);
                A a2 = this.f4169b;
                Context context = a2.f4113g;
                A.d dVar = A.d.MEMORY;
                D.c(imageView, context, bitmapJ, dVar, this.f4171d, a2.o);
                if (this.f4169b.p) {
                    S.p("Main", "completed", gA.g(), "from " + dVar);
                }
                if (interfaceC0332l != null) {
                    interfaceC0332l.onSuccess();
                    return;
                }
                return;
            }
            if (this.f4173f) {
                D.d(imageView, c());
            }
            this.f4169b.g(new C0338s(this.f4169b, imageView, gA, this.f4176i, this.j, this.f4175h, this.l, strH, this.m, interfaceC0332l, this.f4171d));
            return;
        }
        throw new IllegalArgumentException("Target must not be null.");
    }

    public final G a(long j) {
        int andIncrement = f4168a.getAndIncrement();
        G gA = this.f4170c.a();
        gA.f4150b = andIncrement;
        gA.f4151c = j;
        boolean z = this.f4169b.p;
        if (z) {
            S.p("Main", "created", gA.g(), gA.toString());
        }
        G gB = this.f4169b.b(gA);
        if (gB != gA) {
            gB.f4150b = andIncrement;
            gB.f4151c = j;
            if (z) {
                S.p("Main", "changed", gB.d(), "into " + gB);
            }
        }
        return gB;
    }
}
