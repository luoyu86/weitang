package d.l0;

import d.k0.d.p;
import d.k0.d.t;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f12668b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f12667a = d.j0.b.f12610a.defaultPlatformRandom();

    public static final class a extends f {
        public a() {
        }

        @Override // d.l0.f
        public int nextBits(int i2) {
            return f.f12667a.nextBits(i2);
        }

        @Override // d.l0.f
        public boolean nextBoolean() {
            return f.f12667a.nextBoolean();
        }

        @Override // d.l0.f
        public byte[] nextBytes(byte[] bArr) {
            t.checkNotNullParameter(bArr, "array");
            return f.f12667a.nextBytes(bArr);
        }

        @Override // d.l0.f
        public double nextDouble() {
            return f.f12667a.nextDouble();
        }

        @Override // d.l0.f
        public float nextFloat() {
            return f.f12667a.nextFloat();
        }

        @Override // d.l0.f
        public int nextInt() {
            return f.f12667a.nextInt();
        }

        @Override // d.l0.f
        public long nextLong() {
            return f.f12667a.nextLong();
        }

        public /* synthetic */ a(p pVar) {
            this();
        }

        @Override // d.l0.f
        public byte[] nextBytes(int i2) {
            return f.f12667a.nextBytes(i2);
        }

        @Override // d.l0.f
        public double nextDouble(double d2) {
            return f.f12667a.nextDouble(d2);
        }

        @Override // d.l0.f
        public int nextInt(int i2) {
            return f.f12667a.nextInt(i2);
        }

        @Override // d.l0.f
        public long nextLong(long j) {
            return f.f12667a.nextLong(j);
        }

        @Override // d.l0.f
        public byte[] nextBytes(byte[] bArr, int i2, int i3) {
            t.checkNotNullParameter(bArr, "array");
            return f.f12667a.nextBytes(bArr, i2, i3);
        }

        @Override // d.l0.f
        public double nextDouble(double d2, double d3) {
            return f.f12667a.nextDouble(d2, d3);
        }

        @Override // d.l0.f
        public int nextInt(int i2, int i3) {
            return f.f12667a.nextInt(i2, i3);
        }

        @Override // d.l0.f
        public long nextLong(long j, long j2) {
            return f.f12667a.nextLong(j, j2);
        }
    }

    public static /* synthetic */ byte[] nextBytes$default(f fVar, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = bArr.length;
        }
        return fVar.nextBytes(bArr, i2, i3);
    }

    public abstract int nextBits(int i2);

    public boolean nextBoolean() {
        return nextBits(1) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] nextBytes(byte[] r7, int r8, int r9) {
        /*
            r6 = this;
            java.lang.String r0 = "array"
            d.k0.d.t.checkNotNullParameter(r7, r0)
            int r0 = r7.length
            r1 = 0
            r2 = 1
            if (r8 >= 0) goto Lb
            goto L15
        Lb:
            if (r0 < r8) goto L15
            int r0 = r7.length
            if (r9 >= 0) goto L11
            goto L15
        L11:
            if (r0 < r9) goto L15
            r0 = 1
            goto L16
        L15:
            r0 = 0
        L16:
            java.lang.String r3 = "fromIndex ("
            if (r0 == 0) goto L84
            if (r8 > r9) goto L1d
            goto L1e
        L1d:
            r2 = 0
        L1e:
            if (r2 == 0) goto L5e
            int r0 = r9 - r8
            int r0 = r0 / 4
            r2 = 0
        L25:
            if (r2 >= r0) goto L48
            int r3 = r6.nextInt()
            byte r4 = (byte) r3
            r7[r8] = r4
            int r4 = r8 + 1
            int r5 = r3 >>> 8
            byte r5 = (byte) r5
            r7[r4] = r5
            int r4 = r8 + 2
            int r5 = r3 >>> 16
            byte r5 = (byte) r5
            r7[r4] = r5
            int r4 = r8 + 3
            int r3 = r3 >>> 24
            byte r3 = (byte) r3
            r7[r4] = r3
            int r8 = r8 + 4
            int r2 = r2 + 1
            goto L25
        L48:
            int r9 = r9 - r8
            int r0 = r9 * 8
            int r0 = r6.nextBits(r0)
        L4f:
            if (r1 >= r9) goto L5d
            int r2 = r8 + r1
            int r3 = r1 * 8
            int r3 = r0 >>> r3
            byte r3 = (byte) r3
            r7[r2] = r3
            int r1 = r1 + 1
            goto L4f
        L5d:
            return r7
        L5e:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r3)
            r7.append(r8)
            java.lang.String r8 = ") must be not greater than toIndex ("
            r7.append(r8)
            r7.append(r9)
            java.lang.String r8 = ")."
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        L84:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r8)
            java.lang.String r8 = ") or toIndex ("
            r0.append(r8)
            r0.append(r9)
            java.lang.String r8 = ") are out of range: 0.."
            r0.append(r8)
            int r7 = r7.length
            r0.append(r7)
            r7 = 46
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: d.l0.f.nextBytes(byte[], int, int):byte[]");
    }

    public double nextDouble() {
        return e.doubleFromParts(nextBits(26), nextBits(27));
    }

    public float nextFloat() {
        return nextBits(24) / 16777216;
    }

    public int nextInt() {
        return nextBits(32);
    }

    public long nextLong() {
        return (((long) nextInt()) << 32) + ((long) nextInt());
    }

    public double nextDouble(double d2) {
        return nextDouble(0.0d, d2);
    }

    public int nextInt(int i2) {
        return nextInt(0, i2);
    }

    public long nextLong(long j) {
        return nextLong(0L, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double nextDouble(double r7, double r9) {
        /*
            r6 = this;
            d.l0.g.checkRangeBounds(r7, r9)
            double r0 = r9 - r7
            boolean r2 = java.lang.Double.isInfinite(r0)
            if (r2 == 0) goto L3e
            boolean r2 = java.lang.Double.isInfinite(r7)
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L1b
            boolean r2 = java.lang.Double.isNaN(r7)
            if (r2 != 0) goto L1b
            r2 = 1
            goto L1c
        L1b:
            r2 = 0
        L1c:
            if (r2 == 0) goto L3e
            boolean r2 = java.lang.Double.isInfinite(r9)
            if (r2 != 0) goto L2b
            boolean r2 = java.lang.Double.isNaN(r9)
            if (r2 != 0) goto L2b
            goto L2c
        L2b:
            r3 = 0
        L2c:
            if (r3 == 0) goto L3e
            double r0 = r6.nextDouble()
            r2 = 2
            double r2 = (double) r2
            double r4 = r9 / r2
            double r2 = r7 / r2
            double r4 = r4 - r2
            double r0 = r0 * r4
            double r7 = r7 + r0
            double r7 = r7 + r0
            goto L45
        L3e:
            double r2 = r6.nextDouble()
            double r2 = r2 * r0
            double r7 = r7 + r2
        L45:
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 < 0) goto L4f
            r7 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            double r7 = java.lang.Math.nextAfter(r9, r7)
        L4f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: d.l0.f.nextDouble(double, double):double");
    }

    public int nextInt(int i2, int i3) {
        int iNextInt;
        int i4;
        int iNextBits;
        g.checkRangeBounds(i2, i3);
        int i5 = i3 - i2;
        if (i5 > 0 || i5 == Integer.MIN_VALUE) {
            if (((-i5) & i5) == i5) {
                iNextBits = nextBits(g.fastLog2(i5));
            } else {
                do {
                    iNextInt = nextInt() >>> 1;
                    i4 = iNextInt % i5;
                } while ((iNextInt - i4) + (i5 - 1) < 0);
                iNextBits = i4;
            }
            return i2 + iNextBits;
        }
        while (true) {
            int iNextInt2 = nextInt();
            if (i2 <= iNextInt2 && i3 > iNextInt2) {
                return iNextInt2;
            }
        }
    }

    public long nextLong(long j, long j2) {
        long jNextLong;
        long j3;
        long jNextBits;
        int iNextInt;
        g.checkRangeBounds(j, j2);
        long j4 = j2 - j;
        if (j4 > 0) {
            if (((-j4) & j4) == j4) {
                int i2 = (int) j4;
                int i3 = (int) (j4 >>> 32);
                if (i2 != 0) {
                    iNextInt = nextBits(g.fastLog2(i2));
                } else if (i3 == 1) {
                    iNextInt = nextInt();
                } else {
                    jNextBits = (((long) nextBits(g.fastLog2(i3))) << 32) + ((long) nextInt());
                }
                jNextBits = ((long) iNextInt) & UIDFolder.MAXUID;
            } else {
                do {
                    jNextLong = nextLong() >>> 1;
                    j3 = jNextLong % j4;
                } while ((jNextLong - j3) + (j4 - 1) < 0);
                jNextBits = j3;
            }
            return j + jNextBits;
        }
        while (true) {
            long jNextLong2 = nextLong();
            if (j <= jNextLong2 && j2 > jNextLong2) {
                return jNextLong2;
            }
        }
    }

    public byte[] nextBytes(byte[] bArr) {
        t.checkNotNullParameter(bArr, "array");
        return nextBytes(bArr, 0, bArr.length);
    }

    public byte[] nextBytes(int i2) {
        return nextBytes(new byte[i2]);
    }
}
