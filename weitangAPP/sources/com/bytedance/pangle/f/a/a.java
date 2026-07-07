package com.bytedance.pangle.f.a;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f6047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f6048c;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f6054i;
    private f k;
    private boolean j = false;
    private final c l = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6049d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6050e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6051f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6052g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6053h = 4;

    public a() {
        c();
    }

    private int e(int i2) {
        if (this.f6046a != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i3 = i2 * 5;
        if (i3 < this.f6048c.length) {
            return i3;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i2 + ").");
    }

    public final void a() {
        if (this.j) {
            this.j = false;
            b bVar = this.f6047b;
            InputStream inputStream = bVar.f6055a;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                bVar.a((InputStream) null);
            }
            this.k = null;
            this.f6047b = null;
            c cVar = this.l;
            cVar.f6058b = 0;
            cVar.f6059c = 0;
            c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0108, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r1 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0221, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r1 + ").");
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c2 A[Catch: IOException -> 0x022d, TryCatch #0 {IOException -> 0x022d, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x0009, B:8:0x0040, B:12:0x0048, B:14:0x004d, B:16:0x0057, B:18:0x005c, B:19:0x0062, B:20:0x0067, B:21:0x0068, B:22:0x0072, B:23:0x0077, B:24:0x0078, B:26:0x007e, B:27:0x0081, B:29:0x0086, B:31:0x008e, B:33:0x009b, B:34:0x00a5, B:36:0x00a9, B:38:0x00af, B:43:0x00bc, B:41:0x00b4, B:44:0x00c2, B:50:0x00da, B:52:0x00e4, B:54:0x00e8, B:55:0x00f2, B:56:0x0108, B:64:0x0118, B:65:0x011e, B:71:0x0137, B:72:0x0160, B:74:0x0165, B:75:0x016e, B:78:0x017e, B:80:0x0192, B:82:0x01a9, B:84:0x01bb, B:85:0x01be, B:86:0x01e1, B:88:0x01f1, B:90:0x01f9, B:91:0x020b, B:92:0x0221, B:47:0x00cd, B:93:0x0222, B:95:0x0225, B:96:0x022c), top: B:100:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int b() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 562
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.f.a.a.b():int");
    }

    public final int c(int i2) {
        return this.f6048c[e(i2) + 4];
    }

    public final String d(int i2) {
        int iE = e(i2);
        int[] iArr = this.f6048c;
        if (iArr[iE + 3] != 3) {
            return "";
        }
        return this.k.a(iArr[iE + 2]);
    }

    private void c() {
        this.f6048c = null;
        this.f6046a = -1;
    }

    public final String a(int i2) {
        int i3 = this.f6048c[e(i2) + 1];
        return i3 == -1 ? "" : this.k.a(i3);
    }

    public final int b(int i2) {
        return this.f6048c[e(i2) + 3];
    }
}
