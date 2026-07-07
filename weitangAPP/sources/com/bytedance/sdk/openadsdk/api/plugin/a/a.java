package com.bytedance.sdk.openadsdk.api.plugin.a;

import javax.security.auth.x500.X500Principal;
import org.apache.commons.codec.net.RFC1522Codec;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6343a;
    private int bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private char[] f6344h;
    private int kf;
    private int n;
    private final String ok;
    private int s;

    public a(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.ok = name;
        this.f6343a = name.length();
    }

    private String a() {
        int i2 = this.bl + 1;
        this.bl = i2;
        this.s = i2;
        this.n = i2;
        while (true) {
            int i3 = this.bl;
            if (i3 == this.f6343a) {
                throw new IllegalStateException("Unexpected end of DN: " + this.ok);
            }
            char[] cArr = this.f6344h;
            if (cArr[i3] == '\"') {
                this.bl = i3 + 1;
                while (true) {
                    int i4 = this.bl;
                    if (i4 >= this.f6343a || this.f6344h[i4] != ' ') {
                        break;
                    }
                    this.bl = i4 + 1;
                }
                char[] cArr2 = this.f6344h;
                int i5 = this.s;
                return new String(cArr2, i5, this.n - i5);
            }
            if (cArr[i3] == '\\') {
                cArr[this.n] = n();
            } else {
                cArr[this.n] = cArr[i3];
            }
            this.bl++;
            this.n++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
    
        r6.n = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String bl() {
        /*
            r6 = this;
            int r0 = r6.bl
            int r1 = r0 + 4
            int r2 = r6.f6343a
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto La3
            r6.s = r0
            int r0 = r0 + 1
            r6.bl = r0
        L10:
            int r0 = r6.bl
            int r1 = r6.f6343a
            if (r0 == r1) goto L5f
            char[] r1 = r6.f6344h
            char r2 = r1[r0]
            r4 = 43
            if (r2 == r4) goto L5f
            char r2 = r1[r0]
            r4 = 44
            if (r2 == r4) goto L5f
            char r2 = r1[r0]
            r4 = 59
            if (r2 != r4) goto L2b
            goto L5f
        L2b:
            char r2 = r1[r0]
            r4 = 32
            if (r2 != r4) goto L48
            r6.n = r0
            int r0 = r0 + 1
            r6.bl = r0
        L37:
            int r0 = r6.bl
            int r1 = r6.f6343a
            if (r0 >= r1) goto L61
            char[] r1 = r6.f6344h
            char r1 = r1[r0]
            if (r1 != r4) goto L61
            int r0 = r0 + 1
            r6.bl = r0
            goto L37
        L48:
            char r2 = r1[r0]
            r5 = 65
            if (r2 < r5) goto L5a
            char r2 = r1[r0]
            r5 = 70
            if (r2 > r5) goto L5a
            char r2 = r1[r0]
            int r2 = r2 + r4
            char r2 = (char) r2
            r1[r0] = r2
        L5a:
            int r0 = r0 + 1
            r6.bl = r0
            goto L10
        L5f:
            r6.n = r0
        L61:
            int r0 = r6.n
            int r1 = r6.s
            int r0 = r0 - r1
            r2 = 5
            if (r0 < r2) goto L8c
            r2 = r0 & 1
            if (r2 == 0) goto L8c
            int r2 = r0 / 2
            byte[] r3 = new byte[r2]
            r4 = 0
            int r1 = r1 + 1
        L74:
            if (r4 >= r2) goto L82
            int r5 = r6.ok(r1)
            byte r5 = (byte) r5
            r3[r4] = r5
            int r1 = r1 + 2
            int r4 = r4 + 1
            goto L74
        L82:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f6344h
            int r3 = r6.s
            r1.<init>(r2, r3, r0)
            return r1
        L8c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.ok
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        La3:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.ok
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.plugin.a.a.bl():java.lang.String");
    }

    private char kf() {
        int i2;
        int i3;
        int iOk = ok(this.bl);
        this.bl++;
        if (iOk < 128) {
            return (char) iOk;
        }
        if (iOk < 192 || iOk > 247) {
            return RFC1522Codec.SEP;
        }
        if (iOk <= 223) {
            i3 = iOk & 31;
            i2 = 1;
        } else if (iOk <= 239) {
            i2 = 2;
            i3 = iOk & 15;
        } else {
            i2 = 3;
            i3 = iOk & 7;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = this.bl + 1;
            this.bl = i5;
            if (i5 == this.f6343a || this.f6344h[i5] != '\\') {
                return RFC1522Codec.SEP;
            }
            int i6 = i5 + 1;
            this.bl = i6;
            int iOk2 = ok(i6);
            this.bl++;
            if ((iOk2 & 192) != 128) {
                return RFC1522Codec.SEP;
            }
            i3 = (i3 << 6) + (iOk2 & 63);
        }
        return (char) i3;
    }

    private char n() {
        int i2 = this.bl + 1;
        this.bl = i2;
        if (i2 == this.f6343a) {
            throw new IllegalStateException("Unexpected end of DN: " + this.ok);
        }
        char[] cArr = this.f6344h;
        char c2 = cArr[i2];
        if (c2 != ' ' && c2 != '%' && c2 != '\\' && c2 != '_' && c2 != '\"' && c2 != '#') {
            switch (c2) {
                case '*':
                case '+':
                case ',':
                    break;
                default:
                    switch (c2) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            break;
                        default:
                            return kf();
                    }
                    break;
            }
        }
        return cArr[i2];
    }

    private String ok() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        while (true) {
            i2 = this.bl;
            i3 = this.f6343a;
            if (i2 >= i3 || this.f6344h[i2] != ' ') {
                break;
            }
            this.bl = i2 + 1;
        }
        if (i2 == i3) {
            return null;
        }
        this.s = i2;
        this.bl = i2 + 1;
        while (true) {
            i4 = this.bl;
            i5 = this.f6343a;
            if (i4 >= i5) {
                break;
            }
            char[] cArr = this.f6344h;
            if (cArr[i4] == '=' || cArr[i4] == ' ') {
                break;
            }
            this.bl = i4 + 1;
        }
        if (i4 >= i5) {
            throw new IllegalStateException("Unexpected end of DN: " + this.ok);
        }
        this.n = i4;
        if (this.f6344h[i4] == ' ') {
            while (true) {
                i6 = this.bl;
                i7 = this.f6343a;
                if (i6 >= i7) {
                    break;
                }
                char[] cArr2 = this.f6344h;
                if (cArr2[i6] == '=' || cArr2[i6] != ' ') {
                    break;
                }
                this.bl = i6 + 1;
            }
            if (this.f6344h[i6] != '=' || i6 == i7) {
                throw new IllegalStateException("Unexpected end of DN: " + this.ok);
            }
        }
        this.bl++;
        while (true) {
            int i8 = this.bl;
            if (i8 >= this.f6343a || this.f6344h[i8] != ' ') {
                break;
            }
            this.bl = i8 + 1;
        }
        int i9 = this.n;
        int i10 = this.s;
        if (i9 - i10 > 4) {
            char[] cArr3 = this.f6344h;
            if (cArr3[i10 + 3] == '.' && ((cArr3[i10] == 'O' || cArr3[i10] == 'o') && ((cArr3[i10 + 1] == 'I' || cArr3[i10 + 1] == 'i') && (cArr3[i10 + 2] == 'D' || cArr3[i10 + 2] == 'd')))) {
                this.s = i10 + 4;
            }
        }
        char[] cArr4 = this.f6344h;
        int i11 = this.s;
        return new String(cArr4, i11, this.n - i11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
    
        r1 = r8.f6344h;
        r2 = r8.s;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
    
        return new java.lang.String(r1, r2, r8.n - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String s() {
        /*
            r8 = this;
            int r0 = r8.bl
            r8.s = r0
            r8.n = r0
        L6:
            int r0 = r8.bl
            int r1 = r8.f6343a
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f6344h
            int r2 = r8.s
            int r3 = r8.n
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f6344h
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L60
            if (r2 == r5) goto L53
            r5 = 92
            if (r2 == r5) goto L40
            if (r2 == r4) goto L53
            if (r2 == r3) goto L53
            int r2 = r8.n
            int r3 = r2 + 1
            r8.n = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.bl = r0
            goto L6
        L40:
            int r0 = r8.n
            int r2 = r0 + 1
            r8.n = r2
            char r2 = r8.n()
            r1[r0] = r2
            int r0 = r8.bl
            int r0 = r0 + 1
            r8.bl = r0
            goto L6
        L53:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f6344h
            int r2 = r8.s
            int r3 = r8.n
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L60:
            int r2 = r8.n
            r8.kf = r2
            int r0 = r0 + 1
            r8.bl = r0
            int r0 = r2 + 1
            r8.n = r0
            r1[r2] = r6
        L6e:
            int r0 = r8.bl
            int r1 = r8.f6343a
            if (r0 >= r1) goto L87
            char[] r2 = r8.f6344h
            char r7 = r2[r0]
            if (r7 != r6) goto L87
            int r1 = r8.n
            int r7 = r1 + 1
            r8.n = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.bl = r0
            goto L6e
        L87:
            if (r0 == r1) goto L97
            char[] r1 = r8.f6344h
            char r2 = r1[r0]
            if (r2 == r3) goto L97
            char r2 = r1[r0]
            if (r2 == r4) goto L97
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L97:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f6344h
            int r2 = r8.s
            int r3 = r8.kf
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.plugin.a.a.s():java.lang.String");
    }

    private int ok(int i2) {
        int i3;
        int i4;
        int i5 = i2 + 1;
        if (i5 < this.f6343a) {
            char[] cArr = this.f6344h;
            char c2 = cArr[i2];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else {
                if (c2 < 'A' || c2 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.ok);
                }
                i3 = c2 - '7';
            }
            char c3 = cArr[i5];
            if (c3 >= '0' && c3 <= '9') {
                i4 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i4 = c3 - 'W';
            } else {
                if (c3 < 'A' || c3 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.ok);
                }
                i4 = c3 - '7';
            }
            return (i3 << 4) + i4;
        }
        throw new IllegalStateException("Malformed DN: " + this.ok);
    }

    public String ok(String str) {
        String strA;
        this.bl = 0;
        this.s = 0;
        this.n = 0;
        this.kf = 0;
        this.f6344h = this.ok.toCharArray();
        String strOk = ok();
        if (strOk == null) {
            return null;
        }
        do {
            int i2 = this.bl;
            if (i2 == this.f6343a) {
                return null;
            }
            char c2 = this.f6344h[i2];
            if (c2 == '\"') {
                strA = a();
            } else if (c2 != '#') {
                strA = (c2 == '+' || c2 == ',' || c2 == ';') ? "" : s();
            } else {
                strA = bl();
            }
            if (str.equalsIgnoreCase(strOk)) {
                return strA;
            }
            int i3 = this.bl;
            if (i3 >= this.f6343a) {
                return null;
            }
            char[] cArr = this.f6344h;
            if (cArr[i3] != ',' && cArr[i3] != ';' && cArr[i3] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.ok);
            }
            this.bl = i3 + 1;
            strOk = ok();
        } while (strOk != null);
        throw new IllegalStateException("Malformed DN: " + this.ok);
    }
}
