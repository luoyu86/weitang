package com.alibaba.mtl.log.d;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.CharEncoding;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static final /* synthetic */ boolean J = true;

    public static abstract class a {
        public int op;
        public byte[] output;
    }

    public static class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int[] f4553a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int[] f4554b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f4555c;
        private int state;
        private int value;

        public b(int i2, byte[] bArr) {
            this.output = bArr;
            this.f4555c = (i2 & 8) == 0 ? f4553a : f4554b;
            this.state = 0;
            this.value = 0;
        }

        public boolean process(byte[] bArr, int i2, int i3, boolean z) {
            int i4 = this.state;
            if (i4 == 6) {
                return false;
            }
            int i5 = i3 + i2;
            int i6 = this.value;
            byte[] bArr2 = this.output;
            int[] iArr = this.f4555c;
            int i7 = i6;
            int i8 = 0;
            int i9 = i4;
            int i10 = i2;
            while (i10 < i5) {
                if (i9 == 0) {
                    while (true) {
                        int i11 = i10 + 4;
                        if (i11 > i5 || (i7 = (iArr[bArr[i10] & 255] << 18) | (iArr[bArr[i10 + 1] & 255] << 12) | (iArr[bArr[i10 + 2] & 255] << 6) | iArr[bArr[i10 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i8 + 2] = (byte) i7;
                        bArr2[i8 + 1] = (byte) (i7 >> 8);
                        bArr2[i8] = (byte) (i7 >> 16);
                        i8 += 3;
                        i10 = i11;
                    }
                    if (i10 >= i5) {
                        break;
                    }
                }
                int i12 = i10 + 1;
                int i13 = iArr[bArr[i10] & 255];
                if (i9 != 0) {
                    if (i9 == 1) {
                        if (i13 < 0) {
                            if (i13 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i13 |= i7 << 6;
                    } else if (i9 == 2) {
                        if (i13 < 0) {
                            if (i13 == -2) {
                                bArr2[i8] = (byte) (i7 >> 4);
                                i8++;
                                i9 = 4;
                            } else if (i13 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i13 |= i7 << 6;
                    } else if (i9 != 3) {
                        if (i9 != 4) {
                            if (i9 == 5 && i13 != -1) {
                                this.state = 6;
                                return false;
                            }
                        } else if (i13 == -2) {
                            i9++;
                        } else if (i13 != -1) {
                            this.state = 6;
                            return false;
                        }
                    } else if (i13 >= 0) {
                        int i14 = i13 | (i7 << 6);
                        bArr2[i8 + 2] = (byte) i14;
                        bArr2[i8 + 1] = (byte) (i14 >> 8);
                        bArr2[i8] = (byte) (i14 >> 16);
                        i8 += 3;
                        i7 = i14;
                        i9 = 0;
                    } else if (i13 == -2) {
                        bArr2[i8 + 1] = (byte) (i7 >> 2);
                        bArr2[i8] = (byte) (i7 >> 10);
                        i8 += 2;
                        i9 = 5;
                    } else if (i13 != -1) {
                        this.state = 6;
                        return false;
                    }
                    i9++;
                    i7 = i13;
                } else if (i13 >= 0) {
                    i9++;
                    i7 = i13;
                } else if (i13 != -1) {
                    this.state = 6;
                    return false;
                }
                i10 = i12;
            }
            if (!z) {
                this.state = i9;
                this.value = i7;
                this.op = i8;
                return true;
            }
            if (i9 == 1) {
                this.state = 6;
                return false;
            }
            if (i9 == 2) {
                bArr2[i8] = (byte) (i7 >> 4);
                i8++;
            } else if (i9 == 3) {
                int i15 = i8 + 1;
                bArr2[i8] = (byte) (i7 >> 10);
                i8 = i15 + 1;
                bArr2[i15] = (byte) (i7 >> 2);
            } else if (i9 == 4) {
                this.state = 6;
                return false;
            }
            this.state = i9;
            this.op = i8;
            return true;
        }
    }

    /* JADX INFO: renamed from: com.alibaba.mtl.log.d.c$c, reason: collision with other inner class name */
    public static class C0055c extends a {
        public static final /* synthetic */ boolean J = true;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final byte[] f4556a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final byte[] f4557b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        public int E;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final byte[] f4558c;
        private int count;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final byte[] f4559d;
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;

        public C0055c(int i2, byte[] bArr) {
            this.output = bArr;
            this.do_padding = (i2 & 1) == 0;
            boolean z = (i2 & 2) == 0;
            this.do_newline = z;
            this.do_cr = (i2 & 4) != 0;
            this.f4559d = (i2 & 8) == 0 ? f4556a : f4557b;
            this.f4558c = new byte[2];
            this.E = 0;
            this.count = z ? 19 : -1;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x00e6 A[SYNTHETIC] */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean process(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instruction units count: 513
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.d.c.C0055c.process(byte[], int, int, boolean):boolean");
        }
    }

    private c() {
    }

    public static byte[] decode(byte[] bArr, int i2) {
        return decode(bArr, 0, bArr.length, i2);
    }

    public static byte[] encode(byte[] bArr, int i2) {
        return encode(bArr, 0, bArr.length, i2);
    }

    public static String encodeToString(byte[] bArr, int i2) {
        try {
            return new String(encode(bArr, i2), CharEncoding.US_ASCII);
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public static byte[] decode(byte[] bArr, int i2, int i3, int i4) {
        b bVar = new b(i4, new byte[(i3 * 3) / 4]);
        if (!bVar.process(bArr, i2, i3, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        int i5 = bVar.op;
        byte[] bArr2 = bVar.output;
        if (i5 == bArr2.length) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i5];
        System.arraycopy(bArr2, 0, bArr3, 0, i5);
        return bArr3;
    }

    public static byte[] encode(byte[] bArr, int i2, int i3, int i4) {
        C0055c c0055c = new C0055c(i4, null);
        int i5 = (i3 / 3) * 4;
        if (!c0055c.do_padding) {
            int i6 = i3 % 3;
            if (i6 == 1) {
                i5 += 2;
            } else if (i6 == 2) {
                i5 += 3;
            }
        } else if (i3 % 3 > 0) {
            i5 += 4;
        }
        if (c0055c.do_newline && i3 > 0) {
            i5 += (((i3 - 1) / 57) + 1) * (c0055c.do_cr ? 2 : 1);
        }
        c0055c.output = new byte[i5];
        c0055c.process(bArr, i2, i3, true);
        if (J || c0055c.op == i5) {
            return c0055c.output;
        }
        throw new AssertionError();
    }
}
