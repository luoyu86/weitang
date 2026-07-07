package cn.admobiletop.adsuyi.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import cn.admobiletop.adsuyi.c.A;
import cn.admobiletop.adsuyi.c.InterfaceC0337q;
import cn.admobiletop.adsuyi.c.y;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.c.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0329i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f4225a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<StringBuilder> f4226b = new C0323c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicInteger f4227c = new AtomicInteger();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final I f4228d = new C0324d();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f4229e = f4227c.incrementAndGet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final A f4230f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C0336p f4231g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final InterfaceC0331k f4232h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final L f4233i;
    public final String j;
    public final G k;
    public final int l;
    public int m;
    public final I n;
    public AbstractC0321a o;
    public List<AbstractC0321a> p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Bitmap f4234q;
    public Future<?> r;
    public A.d s;
    public Exception t;
    public int u;
    public int v;
    public A.e w;

    public RunnableC0329i(A a2, C0336p c0336p, InterfaceC0331k interfaceC0331k, L l, AbstractC0321a abstractC0321a, I i2) {
        this.f4230f = a2;
        this.f4231g = c0336p;
        this.f4232h = interfaceC0331k;
        this.f4233i = l;
        this.o = abstractC0321a;
        this.j = abstractC0321a.c();
        this.k = abstractC0321a.h();
        this.w = abstractC0321a.g();
        this.l = abstractC0321a.d();
        this.m = abstractC0321a.e();
        this.n = i2;
        this.v = i2.a();
    }

    public static Bitmap a(G g2, Bitmap bitmap, int i2) {
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
        boolean z = g2.m;
        Matrix matrix = new Matrix();
        int i8 = 0;
        if (g2.e()) {
            int i9 = g2.f4157i;
            int i10 = g2.j;
            float f7 = g2.n;
            if (f7 != 0.0f) {
                if (g2.f4158q) {
                    matrix.setRotate(f7, g2.o, g2.p);
                } else {
                    matrix.setRotate(f7);
                }
            }
            if (g2.k) {
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
                if (h(z, width, height, i9, i10)) {
                    matrix.preScale(f6, f11);
                }
                i5 = i7;
                i3 = i6;
                i4 = iCeil;
            } else {
                if (g2.l) {
                    float f12 = i9 / width;
                    float f13 = i10 / height;
                    if (f12 >= f13) {
                        f12 = f13;
                    }
                    if (h(z, width, height, i9, i10)) {
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
                    if (h(z, width, height, i9, i10)) {
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

    public static Bitmap b(InputStream inputStream, G g2) throws IOException {
        u uVar = new u(inputStream);
        long jA = uVar.a(65536);
        BitmapFactory.Options optionsF = I.f(g2);
        boolean zD = I.d(optionsF);
        boolean zU = S.u(uVar);
        uVar.a(jA);
        if (zU) {
            byte[] bArrW = S.w(uVar);
            if (zD) {
                BitmapFactory.decodeByteArray(bArrW, 0, bArrW.length, optionsF);
                I.c(g2.f4157i, g2.j, optionsF, g2);
            }
            return BitmapFactory.decodeByteArray(bArrW, 0, bArrW.length, optionsF);
        }
        if (zD) {
            BitmapFactory.decodeStream(uVar, null, optionsF);
            I.c(g2.f4157i, g2.j, optionsF, g2);
            uVar.a(jA);
        }
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(uVar, null, optionsF);
        if (bitmapDecodeStream != null) {
            return bitmapDecodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    public static Bitmap c(List<N> list, Bitmap bitmap) {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            N n = list.get(i2);
            try {
                Bitmap bitmapA = n.a(bitmap);
                if (bitmapA == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Transformation ");
                    sb.append(n.a());
                    sb.append(" returned null after ");
                    sb.append(i2);
                    sb.append(" previous transformation(s).\n\nTransformation list:\n");
                    Iterator<N> it = list.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next().a());
                        sb.append('\n');
                    }
                    A.f4107a.post(new RunnableC0326f(sb));
                    return null;
                }
                if (bitmapA == bitmap && bitmap.isRecycled()) {
                    A.f4107a.post(new RunnableC0327g(n));
                    return null;
                }
                if (bitmapA != bitmap && !bitmap.isRecycled()) {
                    A.f4107a.post(new RunnableC0328h(n));
                    return null;
                }
                i2++;
                bitmap = bitmapA;
            } catch (RuntimeException e2) {
                A.f4107a.post(new RunnableC0325e(n, e2));
                return null;
            }
        }
        return bitmap;
    }

    public static RunnableC0329i d(A a2, C0336p c0336p, InterfaceC0331k interfaceC0331k, L l, AbstractC0321a abstractC0321a) {
        G gH = abstractC0321a.h();
        List<I> listC = a2.c();
        int size = listC.size();
        for (int i2 = 0; i2 < size; i2++) {
            I i3 = listC.get(i2);
            if (i3.a(gH)) {
                return new RunnableC0329i(a2, c0336p, interfaceC0331k, l, abstractC0321a, i3);
            }
        }
        return new RunnableC0329i(a2, c0336p, interfaceC0331k, l, abstractC0321a, f4228d);
    }

    public static void e(G g2) {
        String strA = g2.a();
        StringBuilder sb = f4226b.get();
        sb.ensureCapacity(strA.length() + 8);
        sb.replace(8, sb.length(), strA);
        Thread.currentThread().setName(sb.toString());
    }

    public static boolean h(boolean z, int i2, int i3, int i4, int i5) {
        return !z || i2 > i4 || i3 > i5;
    }

    public void f(AbstractC0321a abstractC0321a) {
        boolean z = this.f4230f.p;
        G g2 = abstractC0321a.f4209b;
        if (this.o == null) {
            this.o = abstractC0321a;
            if (z) {
                List<AbstractC0321a> list = this.p;
                if (list == null || list.isEmpty()) {
                    S.p("Hunter", "joined", g2.d(), "to empty hunter");
                    return;
                } else {
                    S.p("Hunter", "joined", g2.d(), S.k(this, "to "));
                    return;
                }
            }
            return;
        }
        if (this.p == null) {
            this.p = new ArrayList(3);
        }
        this.p.add(abstractC0321a);
        if (z) {
            S.p("Hunter", "joined", g2.d(), S.k(this, "to "));
        }
        A.e eVarG = abstractC0321a.g();
        if (eVarG.ordinal() > this.w.ordinal()) {
            this.w = eVarG;
        }
    }

    public boolean g() {
        Future<?> future;
        if (this.o != null) {
            return false;
        }
        List<AbstractC0321a> list = this.p;
        return (list == null || list.isEmpty()) && (future = this.r) != null && future.cancel(false);
    }

    public boolean i(boolean z, NetworkInfo networkInfo) {
        int i2 = this.v;
        if (!(i2 > 0)) {
            return false;
        }
        this.v = i2 - 1;
        return this.n.e(z, networkInfo);
    }

    public AbstractC0321a j() {
        return this.o;
    }

    public void k(AbstractC0321a abstractC0321a) {
        boolean zRemove;
        if (this.o == abstractC0321a) {
            this.o = null;
            zRemove = true;
        } else {
            List<AbstractC0321a> list = this.p;
            zRemove = list != null ? list.remove(abstractC0321a) : false;
        }
        if (zRemove && abstractC0321a.g() == this.w) {
            this.w = x();
        }
        if (this.f4230f.p) {
            S.p("Hunter", "removed", abstractC0321a.f4209b.d(), S.k(this, "from "));
        }
    }

    public List<AbstractC0321a> l() {
        return this.p;
    }

    public G m() {
        return this.k;
    }

    public Exception n() {
        return this.t;
    }

    public String o() {
        return this.j;
    }

    public A.d p() {
        return this.s;
    }

    public int q() {
        return this.l;
    }

    public A r() {
        return this.f4230f;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                try {
                    try {
                        e(this.k);
                        if (this.f4230f.p) {
                            S.o("Hunter", "executing", S.j(this));
                        }
                        Bitmap bitmapU = u();
                        this.f4234q = bitmapU;
                        if (bitmapU == null) {
                            this.f4231g.m(this);
                        } else {
                            this.f4231g.e(this);
                        }
                    } catch (InterfaceC0337q.b e2) {
                        if (!e2.f4257a || e2.f4258b != 504) {
                            this.t = e2;
                        }
                        this.f4231g.m(this);
                    } catch (y.a e3) {
                        this.t = e3;
                        this.f4231g.q(this);
                    }
                } catch (Exception e4) {
                    this.t = e4;
                    this.f4231g.m(this);
                } catch (OutOfMemoryError e5) {
                    StringWriter stringWriter = new StringWriter();
                    this.f4233i.b().a(new PrintWriter(stringWriter));
                    this.t = new RuntimeException(stringWriter.toString(), e5);
                    this.f4231g.m(this);
                }
            } catch (IOException e6) {
                this.t = e6;
                this.f4231g.q(this);
            }
        } finally {
            Thread.currentThread().setName("Picasso-Idle");
        }
    }

    public A.e s() {
        return this.w;
    }

    public Bitmap t() {
        return this.f4234q;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0070 A[PHI: r0
  0x0070: PHI (r0v4 android.graphics.Bitmap) = (r0v3 android.graphics.Bitmap), (r0v17 android.graphics.Bitmap) binds: [B:16:0x0049, B:18:0x005b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap u() {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.admobiletop.adsuyi.c.RunnableC0329i.u():android.graphics.Bitmap");
    }

    public boolean v() {
        Future<?> future = this.r;
        return future != null && future.isCancelled();
    }

    public boolean w() {
        return this.n.g();
    }

    public final A.e x() {
        A.e eVarG = A.e.LOW;
        List<AbstractC0321a> list = this.p;
        boolean z = true;
        boolean z2 = (list == null || list.isEmpty()) ? false : true;
        AbstractC0321a abstractC0321a = this.o;
        if (abstractC0321a == null && !z2) {
            z = false;
        }
        if (!z) {
            return eVarG;
        }
        if (abstractC0321a != null) {
            eVarG = abstractC0321a.g();
        }
        if (z2) {
            int size = this.p.size();
            for (int i2 = 0; i2 < size; i2++) {
                A.e eVarG2 = this.p.get(i2).g();
                if (eVarG2.ordinal() > eVarG.ordinal()) {
                    eVarG = eVarG2;
                }
            }
        }
        return eVarG;
    }
}
