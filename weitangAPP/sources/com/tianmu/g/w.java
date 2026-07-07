package com.tianmu.g;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.RemoteViews;
import com.tianmu.g.r;
import com.tianmu.g.u;
import com.tianmu.g.v;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class w {
    private static final AtomicInteger m = new AtomicInteger();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r f12175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final v.b f12176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f12177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f12178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f12179e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f12180f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f12181g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f12182h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f12183i;
    private Drawable j;
    private Drawable k;
    private Object l;

    public w(r rVar, Uri uri, int i2) {
        if (rVar.o) {
            throw new IllegalStateException("Picasso getInstance already shut down. Cannot submit new requests.");
        }
        this.f12175a = rVar;
        this.f12176b = new v.b(uri, i2, rVar.l);
    }

    private Drawable c() {
        return this.f12180f != 0 ? this.f12175a.f12119e.getResources().getDrawable(this.f12180f) : this.j;
    }

    public w a(int i2, int i3) {
        this.f12176b.a(i2, i3);
        return this;
    }

    public w b() {
        this.f12178d = false;
        return this;
    }

    public w a() {
        this.f12176b.b();
        return this;
    }

    public w a(Bitmap.Config config) {
        this.f12176b.a(config);
        return this;
    }

    public void a(b0 b0Var) {
        Bitmap bitmapB;
        long jNanoTime = System.nanoTime();
        f0.a();
        if (b0Var != null) {
            if (!this.f12178d) {
                if (!this.f12176b.c()) {
                    this.f12175a.a(b0Var);
                    b0Var.onPrepareLoad(this.f12179e ? c() : null);
                    return;
                }
                v vVarA = a(jNanoTime);
                String strA = f0.a(vVarA);
                if (o.a(this.f12182h) && (bitmapB = this.f12175a.b(strA)) != null) {
                    this.f12175a.a(b0Var);
                    b0Var.onBitmapLoaded(bitmapB, r.e.f12136b);
                    return;
                } else {
                    b0Var.onPrepareLoad(this.f12179e ? c() : null);
                    this.f12175a.a((a) new c0(this.f12175a, b0Var, vVarA, this.f12182h, this.f12183i, this.k, strA, this.l, this.f12181g));
                    return;
                }
            }
            throw new IllegalStateException("Fit cannot be used with a Target.");
        }
        throw new IllegalArgumentException("Target must not be null.");
    }

    public void a(RemoteViews remoteViews, int i2, int i3, Notification notification) {
        long jNanoTime = System.nanoTime();
        if (remoteViews == null) {
            throw new IllegalArgumentException("RemoteViews must not be null.");
        }
        if (notification != null) {
            if (!this.f12178d) {
                if (this.j == null && this.f12180f == 0 && this.k == null) {
                    v vVarA = a(jNanoTime);
                    a(new u.a(this.f12175a, vVarA, remoteViews, i2, i3, notification, this.f12182h, this.f12183i, f0.a(vVarA, new StringBuilder()), this.l, this.f12181g));
                    return;
                }
                throw new IllegalArgumentException("Cannot use placeholder or error drawables with remote views.");
            }
            throw new IllegalStateException("Fit cannot be used with RemoteViews.");
        }
        throw new IllegalArgumentException("Notification must not be null.");
    }

    public void a(ImageView imageView) {
        a(imageView, (e) null);
    }

    public void a(ImageView imageView, e eVar) {
        Bitmap bitmapB;
        long jNanoTime = System.nanoTime();
        f0.a();
        if (imageView != null) {
            if (!this.f12176b.c()) {
                this.f12175a.a(imageView);
                if (this.f12179e) {
                    s.a(imageView, c());
                    return;
                }
                return;
            }
            if (this.f12178d) {
                if (!this.f12176b.d()) {
                    int width = imageView.getWidth();
                    int height = imageView.getHeight();
                    if (width != 0 && height != 0) {
                        this.f12176b.a(width, height);
                    } else {
                        if (this.f12179e) {
                            s.a(imageView, c());
                        }
                        this.f12175a.a(imageView, new g(this, imageView, eVar));
                        return;
                    }
                } else {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
            }
            v vVarA = a(jNanoTime);
            String strA = f0.a(vVarA);
            if (o.a(this.f12182h) && (bitmapB = this.f12175a.b(strA)) != null) {
                this.f12175a.a(imageView);
                r rVar = this.f12175a;
                Context context = rVar.f12119e;
                r.e eVar2 = r.e.f12136b;
                s.a(imageView, context, bitmapB, eVar2, this.f12177c, rVar.m);
                if (this.f12175a.n) {
                    f0.a("Main", "completed", vVarA.g(), "from " + eVar2);
                }
                if (eVar != null) {
                    eVar.onSuccess();
                    return;
                }
                return;
            }
            if (this.f12179e) {
                s.a(imageView, c());
            }
            this.f12175a.a((a) new k(this.f12175a, imageView, vVarA, this.f12182h, this.f12183i, this.f12181g, this.k, strA, this.l, eVar, this.f12177c));
            return;
        }
        throw new IllegalArgumentException("Target must not be null.");
    }

    private v a(long j) {
        int andIncrement = m.getAndIncrement();
        v vVarA = this.f12176b.a();
        vVarA.f12156a = andIncrement;
        vVarA.f12157b = j;
        boolean z = this.f12175a.n;
        if (z) {
            f0.a("Main", "created", vVarA.g(), vVarA.toString());
        }
        v vVarA2 = this.f12175a.a(vVarA);
        if (vVarA2 != vVarA) {
            vVarA2.f12156a = andIncrement;
            vVarA2.f12157b = j;
            if (z) {
                f0.a("Main", "changed", vVarA2.d(), "into " + vVarA2);
            }
        }
        return vVarA2;
    }

    private void a(u uVar) {
        Bitmap bitmapB;
        if (o.a(this.f12182h) && (bitmapB = this.f12175a.b(uVar.c())) != null) {
            uVar.a(bitmapB, r.e.f12136b);
            return;
        }
        int i2 = this.f12180f;
        if (i2 != 0) {
            uVar.a(i2);
        }
        this.f12175a.a((a) uVar);
    }
}
