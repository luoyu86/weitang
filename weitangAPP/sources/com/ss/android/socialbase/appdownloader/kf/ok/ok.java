package com.ss.android.socialbase.appdownloader.kf.ok;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class ok implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private s f9935a;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f9936h;
    private int[] j;
    private int k;
    private int[] n;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f9937q;
    private int r;
    private int rh;
    private kf s;
    private int t;
    private int z;
    private boolean bl = false;
    private C0145ok kf = new C0145ok();

    public ok() {
        h();
    }

    private final void h() {
        this.p = -1;
        this.f9937q = -1;
        this.k = -1;
        this.r = -1;
        this.j = null;
        this.z = -1;
        this.rh = -1;
        this.t = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0095, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r2 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x018e, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r5 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void p() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.kf.ok.ok.p():void");
    }

    public int a() throws p, IOException {
        if (this.f9935a == null) {
            throw new p("Parser is not opened.", this, null);
        }
        try {
            p();
            return this.p;
        } catch (IOException e2) {
            ok();
            throw e2;
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.kf.ok.h
    public int bl() {
        return this.f9937q;
    }

    @Override // com.ss.android.socialbase.appdownloader.kf.ok.h
    public int kf() {
        return -1;
    }

    public int n() {
        if (this.p != 2) {
            return -1;
        }
        return this.j.length / 5;
    }

    public void ok(InputStream inputStream) {
        ok();
        if (inputStream != null) {
            this.f9935a = new s(inputStream, false);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.kf.ok.h
    public String s() {
        return "XML line #" + bl();
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.kf.ok.ok$ok, reason: collision with other inner class name */
    public static final class C0145ok {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9938a;
        private int bl;
        private int[] ok = new int[32];

        public final int a() {
            int i2 = this.f9938a;
            if (i2 == 0) {
                return 0;
            }
            return this.ok[i2 - 1];
        }

        public final boolean bl() {
            int i2;
            int[] iArr;
            int i3;
            int i4 = this.f9938a;
            if (i4 == 0 || (i3 = (iArr = this.ok)[i4 - 1]) == 0) {
                return false;
            }
            int i5 = i3 - 1;
            int i6 = i2 - 2;
            iArr[i6] = i5;
            iArr[i6 - ((i5 * 2) + 1)] = i5;
            this.f9938a = i4 - 2;
            return true;
        }

        public final void kf() {
            int i2 = this.f9938a;
            if (i2 != 0) {
                int i3 = i2 - 1;
                int i4 = this.ok[i3] * 2;
                if ((i3 - 1) - i4 != 0) {
                    this.f9938a = i2 - (i4 + 2);
                    this.bl--;
                }
            }
        }

        public final void n() {
            ok(2);
            int i2 = this.f9938a;
            int[] iArr = this.ok;
            iArr[i2] = 0;
            iArr[i2 + 1] = 0;
            this.f9938a = i2 + 2;
            this.bl++;
        }

        public final void ok() {
            this.f9938a = 0;
            this.bl = 0;
        }

        public final int s() {
            return this.bl;
        }

        public final void ok(int i2, int i3) {
            if (this.bl == 0) {
                n();
            }
            ok(2);
            int i4 = this.f9938a;
            int i5 = i4 - 1;
            int[] iArr = this.ok;
            int i6 = iArr[i5];
            int i7 = (i5 - 1) - (i6 * 2);
            int i8 = i6 + 1;
            iArr[i7] = i8;
            iArr[i5] = i2;
            iArr[i5 + 1] = i3;
            iArr[i5 + 2] = i8;
            this.f9938a = i4 + 2;
        }

        private void ok(int i2) {
            int[] iArr = this.ok;
            int length = iArr.length;
            int i3 = this.f9938a;
            int i4 = length - i3;
            if (i4 <= i2) {
                int[] iArr2 = new int[(iArr.length + i4) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i3);
                this.ok = iArr2;
            }
        }
    }

    private final int n(int i2) {
        if (this.p != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i3 = i2 * 5;
        if (i3 < this.j.length) {
            return i3;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i2 + ").");
    }

    public int bl(int i2) {
        return this.j[n(i2) + 4];
    }

    public String s(int i2) {
        int iN = n(i2);
        int[] iArr = this.j;
        if (iArr[iN + 3] == 3) {
            return this.s.ok(iArr[iN + 2]);
        }
        int i3 = iArr[iN + 4];
        return "";
    }

    public void ok() {
        if (this.bl) {
            this.bl = false;
            this.f9935a.ok();
            this.f9935a = null;
            this.s = null;
            this.n = null;
            this.kf.ok();
            h();
        }
    }

    public int a(int i2) {
        return this.j[n(i2) + 3];
    }

    public String ok(int i2) {
        int i3 = this.j[n(i2) + 1];
        return i3 == -1 ? "" : this.s.ok(i3);
    }
}
