package com.tianmu.g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import com.tianmu.g.i;
import com.tianmu.g.q;
import com.tianmu.g.r;
import com.tianmu.g.x;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Runnable {
    private static final Object t = new Object();
    private static final ThreadLocal<StringBuilder> u = new a();
    private static final AtomicInteger v = new AtomicInteger();
    private static final x w = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12044a = v.incrementAndGet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f12045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f12046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.tianmu.g.d f12047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final z f12048e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f12049f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final v f12050g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f12051h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12052i;
    public final x j;
    public com.tianmu.g.a k;
    public List<com.tianmu.g.a> l;
    public Bitmap m;
    public Future<?> n;
    public r.e o;
    public Exception p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12053q;
    public int r;
    public r.f s;

    public static class a extends ThreadLocal<StringBuilder> {
        @Override // java.lang.ThreadLocal
        public StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    }

    public static class b extends x {
        @Override // com.tianmu.g.x
        public x.a a(v vVar, int i2) {
            throw new IllegalStateException("Unrecognized type of request: " + vVar);
        }

        @Override // com.tianmu.g.x
        public boolean a(v vVar) {
            return true;
        }
    }

    /* JADX INFO: renamed from: com.tianmu.g.c$c, reason: collision with other inner class name */
    public static class RunnableC0222c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d0 f12054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RuntimeException f12055b;

        public RunnableC0222c(d0 d0Var, RuntimeException runtimeException) {
            this.f12054a = d0Var;
            this.f12055b = runtimeException;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw new RuntimeException("Transformation " + this.f12054a.a() + " crashed with exception.", this.f12055b);
        }
    }

    public static class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StringBuilder f12056a;

        public d(StringBuilder sb) {
            this.f12056a = sb;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw new NullPointerException(this.f12056a.toString());
        }
    }

    public static class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d0 f12057a;

        public e(d0 d0Var) {
            this.f12057a = d0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw new IllegalStateException("Transformation " + this.f12057a.a() + " returned input Bitmap but recycled it.");
        }
    }

    public static class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d0 f12058a;

        public f(d0 d0Var) {
            this.f12058a = d0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw new IllegalStateException("Transformation " + this.f12058a.a() + " mutated input Bitmap but failed to recycle the original.");
        }
    }

    public c(r rVar, h hVar, com.tianmu.g.d dVar, z zVar, com.tianmu.g.a aVar, x xVar) {
        this.f12045b = rVar;
        this.f12046c = hVar;
        this.f12047d = dVar;
        this.f12048e = zVar;
        this.k = aVar;
        this.f12049f = aVar.c();
        this.f12050g = aVar.h();
        this.s = aVar.g();
        this.f12051h = aVar.d();
        this.f12052i = aVar.e();
        this.j = xVar;
        this.r = xVar.a();
    }

    public static Bitmap a(InputStream inputStream, v vVar) throws IOException {
        m mVar = new m(inputStream);
        long jA = mVar.a(65536);
        BitmapFactory.Options optionsB = x.b(vVar);
        boolean zA = x.a(optionsB);
        boolean zB = f0.b(mVar);
        mVar.a(jA);
        if (zB) {
            byte[] bArrC = f0.c(mVar);
            if (zA) {
                BitmapFactory.decodeByteArray(bArrC, 0, bArrC.length, optionsB);
                x.a(vVar.f12163h, vVar.f12164i, optionsB, vVar);
            }
            return BitmapFactory.decodeByteArray(bArrC, 0, bArrC.length, optionsB);
        }
        if (zA) {
            BitmapFactory.decodeStream(mVar, null, optionsB);
            x.a(vVar.f12163h, vVar.f12164i, optionsB, vVar);
            mVar.a(jA);
        }
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(mVar, null, optionsB);
        if (bitmapDecodeStream != null) {
            return bitmapDecodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    private static boolean a(boolean z, int i2, int i3, int i4, int i5) {
        return !z || i2 > i4 || i3 > i5;
    }

    private r.f o() {
        r.f fVarG = r.f.f12140a;
        List<com.tianmu.g.a> list = this.l;
        boolean z = true;
        boolean z2 = (list == null || list.isEmpty()) ? false : true;
        com.tianmu.g.a aVar = this.k;
        if (aVar == null && !z2) {
            z = false;
        }
        if (!z) {
            return fVarG;
        }
        if (aVar != null) {
            fVarG = aVar.g();
        }
        if (z2) {
            int size = this.l.size();
            for (int i2 = 0; i2 < size; i2++) {
                r.f fVarG2 = this.l.get(i2).g();
                if (fVarG2.ordinal() > fVarG.ordinal()) {
                    fVarG = fVarG2;
                }
            }
        }
        return fVarG;
    }

    public void b(com.tianmu.g.a aVar) {
        boolean zRemove;
        if (this.k == aVar) {
            this.k = null;
            zRemove = true;
        } else {
            List<com.tianmu.g.a> list = this.l;
            zRemove = list != null ? list.remove(aVar) : false;
        }
        if (zRemove && aVar.g() == this.s) {
            this.s = o();
        }
        if (this.f12045b.n) {
            f0.a("Hunter", "removed", aVar.f12024b.d(), f0.a(this, "from "));
        }
    }

    public List<com.tianmu.g.a> c() {
        return this.l;
    }

    public v d() {
        return this.f12050g;
    }

    public Exception e() {
        return this.p;
    }

    public String f() {
        return this.f12049f;
    }

    public r.e g() {
        return this.o;
    }

    public int h() {
        return this.f12051h;
    }

    public r i() {
        return this.f12045b;
    }

    public r.f j() {
        return this.s;
    }

    public Bitmap k() {
        return this.m;
    }

    public Bitmap l() {
        Bitmap bitmapA;
        if (o.a(this.f12051h)) {
            bitmapA = this.f12047d.get(this.f12049f);
            if (bitmapA != null) {
                this.f12048e.b();
                this.o = r.e.f12136b;
                if (this.f12045b.n) {
                    f0.a("Hunter", "decoded", this.f12050g.d(), "from cache");
                }
                return bitmapA;
            }
        } else {
            bitmapA = null;
        }
        v vVar = this.f12050g;
        vVar.f12158c = this.r == 0 ? p.f12110d.f12111a : this.f12052i;
        x.a aVarA = this.j.a(vVar, this.f12052i);
        if (aVarA != null) {
            this.o = aVarA.c();
            this.f12053q = aVarA.b();
            bitmapA = aVarA.a();
            if (bitmapA == null) {
                InputStream inputStreamD = aVarA.d();
                try {
                    Bitmap bitmapA2 = a(inputStreamD, this.f12050g);
                    f0.a(inputStreamD);
                    bitmapA = bitmapA2;
                } catch (Throwable th) {
                    f0.a(inputStreamD);
                    throw th;
                }
            }
        }
        if (bitmapA != null) {
            if (this.f12045b.n) {
                f0.a("Hunter", "decoded", this.f12050g.d());
            }
            this.f12048e.a(bitmapA);
            if (this.f12050g.f() || this.f12053q != 0) {
                synchronized (t) {
                    if (this.f12050g.e() || this.f12053q != 0) {
                        bitmapA = a(this.f12050g, bitmapA, this.f12053q);
                        if (this.f12045b.n) {
                            f0.a("Hunter", "transformed", this.f12050g.d());
                        }
                    }
                    if (this.f12050g.b()) {
                        bitmapA = a(this.f12050g.f12162g, bitmapA);
                        if (this.f12045b.n) {
                            f0.a("Hunter", "transformed", this.f12050g.d(), "from custom transformations");
                        }
                    }
                }
                if (bitmapA != null) {
                    this.f12048e.b(bitmapA);
                }
            }
        }
        return bitmapA;
    }

    public boolean m() {
        Future<?> future = this.n;
        return future != null && future.isCancelled();
    }

    public boolean n() {
        return this.j.b();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                try {
                    try {
                        a(this.f12050g);
                        if (this.f12045b.n) {
                            f0.a("Hunter", "executing", f0.a(this));
                        }
                        Bitmap bitmapL = l();
                        this.m = bitmapL;
                        if (bitmapL == null) {
                            this.f12046c.b(this);
                        } else {
                            this.f12046c.a(this);
                        }
                    } catch (i.b e2) {
                        if (!e2.f12084a || e2.f12085b != 504) {
                            this.p = e2;
                        }
                        this.f12046c.b(this);
                    } catch (q.a e3) {
                        this.p = e3;
                        this.f12046c.c(this);
                    }
                } catch (Exception e4) {
                    this.p = e4;
                    this.f12046c.b(this);
                } catch (OutOfMemoryError e5) {
                    StringWriter stringWriter = new StringWriter();
                    this.f12048e.a().a(new PrintWriter(stringWriter));
                    this.p = new RuntimeException(stringWriter.toString(), e5);
                    this.f12046c.b(this);
                }
            } catch (IOException e6) {
                this.p = e6;
                this.f12046c.c(this);
            }
        } finally {
            Thread.currentThread().setName("Picasso-Idle");
        }
    }

    public com.tianmu.g.a b() {
        return this.k;
    }

    public void a(com.tianmu.g.a aVar) {
        boolean z = this.f12045b.n;
        v vVar = aVar.f12024b;
        if (this.k == null) {
            this.k = aVar;
            if (z) {
                List<com.tianmu.g.a> list = this.l;
                if (list != null && !list.isEmpty()) {
                    f0.a("Hunter", "joined", vVar.d(), f0.a(this, "to "));
                    return;
                } else {
                    f0.a("Hunter", "joined", vVar.d(), "to empty hunter");
                    return;
                }
            }
            return;
        }
        if (this.l == null) {
            this.l = new ArrayList(3);
        }
        this.l.add(aVar);
        if (z) {
            f0.a("Hunter", "joined", vVar.d(), f0.a(this, "to "));
        }
        r.f fVarG = aVar.g();
        if (fVarG.ordinal() > this.s.ordinal()) {
            this.s = fVarG;
        }
    }

    public boolean a() {
        Future<?> future;
        if (this.k != null) {
            return false;
        }
        List<com.tianmu.g.a> list = this.l;
        return (list == null || list.isEmpty()) && (future = this.n) != null && future.cancel(false);
    }

    public boolean a(boolean z, NetworkInfo networkInfo) {
        int i2 = this.r;
        if (!(i2 > 0)) {
            return false;
        }
        this.r = i2 - 1;
        return this.j.a(z, networkInfo);
    }

    public static void a(v vVar) {
        String strA = vVar.a();
        StringBuilder sb = u.get();
        sb.ensureCapacity(strA.length() + 8);
        sb.replace(8, sb.length(), strA);
        Thread.currentThread().setName(sb.toString());
    }

    public static c a(r rVar, h hVar, com.tianmu.g.d dVar, z zVar, com.tianmu.g.a aVar) {
        v vVarH = aVar.h();
        List<x> listA = rVar.a();
        int size = listA.size();
        for (int i2 = 0; i2 < size; i2++) {
            x xVar = listA.get(i2);
            if (xVar.a(vVarH)) {
                return new c(rVar, hVar, dVar, zVar, aVar, xVar);
            }
        }
        return new c(rVar, hVar, dVar, zVar, aVar, w);
    }

    public static Bitmap a(List<d0> list, Bitmap bitmap) {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            d0 d0Var = list.get(i2);
            try {
                Bitmap bitmapA = d0Var.a(bitmap);
                if (bitmapA == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Transformation ");
                    sb.append(d0Var.a());
                    sb.append(" returned null after ");
                    sb.append(i2);
                    sb.append(" previous transformation(s).\n\nTransformation list:\n");
                    Iterator<d0> it = list.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next().a());
                        sb.append('\n');
                    }
                    r.p.post(new d(sb));
                    return null;
                }
                if (bitmapA == bitmap && bitmap.isRecycled()) {
                    r.p.post(new e(d0Var));
                    return null;
                }
                if (bitmapA != bitmap && !bitmap.isRecycled()) {
                    r.p.post(new f(d0Var));
                    return null;
                }
                i2++;
                bitmap = bitmapA;
            } catch (RuntimeException e2) {
                r.p.post(new RunnableC0222c(d0Var, e2));
                return null;
            }
        }
        return bitmap;
    }

    public static Bitmap a(v vVar, Bitmap bitmap, int i2) {
        int i3;
        int i4;
        int i5;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        int iCeil;
        int i6;
        int i7;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        boolean z = vVar.l;
        Matrix matrix = new Matrix();
        int i8 = 0;
        if (vVar.e()) {
            int i9 = vVar.f12163h;
            int i10 = vVar.f12164i;
            float f7 = vVar.m;
            if (f7 != 0.0f) {
                if (vVar.p) {
                    matrix.setRotate(f7, vVar.n, vVar.o);
                } else {
                    matrix.setRotate(f7);
                }
            }
            if (vVar.j) {
                float f8 = i9;
                float f9 = f8 / width;
                float f10 = i10;
                float f11 = f10 / height;
                if (f9 > f11) {
                    iCeil = (int) Math.ceil(r10 * (f11 / f9));
                    i7 = (height - iCeil) / 2;
                    f11 = f10 / iCeil;
                    f6 = f9;
                    i6 = width;
                } else {
                    int iCeil2 = (int) Math.ceil(r6 * (f9 / f11));
                    f6 = f8 / iCeil2;
                    iCeil = height;
                    i8 = (width - iCeil2) / 2;
                    i6 = iCeil2;
                    i7 = 0;
                }
                if (a(z, width, height, i9, i10)) {
                    matrix.preScale(f6, f11);
                }
                i5 = i7;
                i3 = i6;
                i4 = iCeil;
            } else {
                if (vVar.k) {
                    float f12 = i9 / width;
                    float f13 = i10 / height;
                    if (f12 >= f13) {
                        f12 = f13;
                    }
                    if (a(z, width, height, i9, i10)) {
                        matrix.preScale(f12, f12);
                    }
                } else if ((i9 != 0 || i10 != 0) && (i9 != width || i10 != height)) {
                    if (i9 != 0) {
                        f2 = i9;
                        f3 = width;
                    } else {
                        f2 = i10;
                        f3 = height;
                    }
                    float f14 = f2 / f3;
                    if (i10 != 0) {
                        f4 = i10;
                        f5 = height;
                    } else {
                        f4 = i9;
                        f5 = width;
                    }
                    float f15 = f4 / f5;
                    if (a(z, width, height, i9, i10)) {
                        matrix.preScale(f14, f15);
                    }
                }
                i3 = width;
                i4 = height;
                i5 = 0;
            }
        } else {
            i3 = width;
            i4 = height;
            i5 = 0;
        }
        if (i2 != 0) {
            matrix.preRotate(i2);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i8, i5, i3, i4, matrix, true);
        if (bitmapCreateBitmap == bitmap) {
            return bitmap;
        }
        bitmap.recycle();
        return bitmapCreateBitmap;
    }
}
