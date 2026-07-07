package cn.admobiletop.adsuyi.c;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.LinkedHashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class t implements InterfaceC0331k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<String, Bitmap> f4259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4262e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4263f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4264g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4265h;

    public t(Context context) {
        this(S.a(context));
    }

    @Override // cn.admobiletop.adsuyi.c.InterfaceC0331k
    public Bitmap a(String str) {
        Objects.requireNonNull(str, "key == null");
        synchronized (this) {
            Bitmap bitmap = this.f4259b.get(str);
            if (bitmap != null) {
                this.f4264g++;
                return bitmap;
            }
            this.f4265h++;
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append(getClass().getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0066, code lost:
    
        r0.append(".sizeOf() is reporting inconsistent results!");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
    
        throw new java.lang.IllegalStateException(r0.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(int r4) {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            int r0 = r3.f4261d     // Catch: java.lang.Throwable -> L71
            if (r0 < 0) goto L52
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f4259b     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L11
            int r0 = r3.f4261d     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto L52
        L11:
            int r0 = r3.f4261d     // Catch: java.lang.Throwable -> L71
            if (r0 <= r4) goto L50
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f4259b     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L1e
            goto L50
        L1e:
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f4259b     // Catch: java.lang.Throwable -> L71
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L71
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L71
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L71
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L71
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0     // Catch: java.lang.Throwable -> L71
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r2 = r3.f4259b     // Catch: java.lang.Throwable -> L71
            r2.remove(r1)     // Catch: java.lang.Throwable -> L71
            int r1 = r3.f4261d     // Catch: java.lang.Throwable -> L71
            int r0 = cn.admobiletop.adsuyi.c.S.c(r0)     // Catch: java.lang.Throwable -> L71
            int r1 = r1 - r0
            r3.f4261d = r1     // Catch: java.lang.Throwable -> L71
            int r0 = r3.f4263f     // Catch: java.lang.Throwable -> L71
            int r0 = r0 + 1
            r3.f4263f = r0     // Catch: java.lang.Throwable -> L71
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L71
            goto L0
        L50:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L71
            return
        L52:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r0.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.Class r1 = r3.getClass()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L71
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L71
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L71
            throw r4     // Catch: java.lang.Throwable -> L71
        L71:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L71
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.admobiletop.adsuyi.c.t.b(int):void");
    }

    @Override // cn.admobiletop.adsuyi.c.InterfaceC0331k
    public final synchronized int size() {
        return this.f4261d;
    }

    public t(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("Max size must be positive.");
        }
        this.f4260c = i2;
        this.f4259b = new LinkedHashMap<>(0, 0.75f, true);
    }

    @Override // cn.admobiletop.adsuyi.c.InterfaceC0331k
    public void a(String str, Bitmap bitmap) {
        if (str != null && bitmap != null) {
            synchronized (this) {
                this.f4262e++;
                this.f4261d += S.c(bitmap);
                Bitmap bitmapPut = this.f4259b.put(str, bitmap);
                if (bitmapPut != null) {
                    this.f4261d -= S.c(bitmapPut);
                }
            }
            b(this.f4260c);
            return;
        }
        throw new NullPointerException("key == null || bitmap == null");
    }

    @Override // cn.admobiletop.adsuyi.c.InterfaceC0331k
    public final synchronized int a() {
        return this.f4260c;
    }
}
