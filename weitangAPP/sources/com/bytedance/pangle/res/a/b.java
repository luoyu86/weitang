package com.bytedance.pangle.res.a;

import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f6206c;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final h f6212i;
    private final byte[] j;
    private int[] l;
    private boolean n;
    private int o;
    private int[] p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f6213q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<Integer, Integer> f6204a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6205b = false;
    private boolean k = false;
    private final a m = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6207d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6208e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6209f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6210g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6211h = 4;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f6214a = new int[32];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6216c;

        public final void a() {
            b();
            int i2 = this.f6215b;
            int[] iArr = this.f6214a;
            iArr[i2] = 0;
            iArr[i2 + 1] = 0;
            this.f6215b = i2 + 2;
            this.f6216c++;
        }

        public final void b() {
            int[] iArr = this.f6214a;
            int length = iArr.length;
            int i2 = this.f6215b;
            int i3 = length - i2;
            if (i3 > 2) {
                return;
            }
            int[] iArr2 = new int[(iArr.length + i3) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f6214a = iArr2;
        }
    }

    public b(byte[] bArr, h hVar) {
        this.f6212i = hVar;
        this.j = bArr;
        c();
    }

    private void c() {
        this.o = -1;
        this.p = null;
        this.f6213q = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0296, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r6 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x012b, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r6 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 663
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.res.a.b.d():void");
    }

    public final void a() {
        if (this.k) {
            this.k = false;
            this.f6206c = null;
            this.l = null;
            a aVar = this.m;
            aVar.f6215b = 0;
            aVar.f6216c = 0;
            c();
        }
    }

    public final int b() throws IOException {
        if (this.f6206c == null) {
            throw new RuntimeException("Parser is not opened.");
        }
        try {
            d();
            return this.o;
        } catch (IOException e2) {
            a();
            throw e2;
        }
    }
}
