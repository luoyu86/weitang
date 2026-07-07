package org.json.alipay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Reader f14996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public char f14997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14998d;

    public c(Reader reader) {
        this.f14996b = reader.markSupported() ? reader : new BufferedReader(reader);
        this.f14998d = false;
        this.f14995a = 0;
    }

    public c(String str) {
        this(new StringReader(str));
    }

    private String a(int i2) throws JSONException {
        if (i2 == 0) {
            return "";
        }
        char[] cArr = new char[i2];
        int i3 = 0;
        if (this.f14998d) {
            this.f14998d = false;
            cArr[0] = this.f14997c;
            i3 = 1;
        }
        while (i3 < i2) {
            try {
                int i4 = this.f14996b.read(cArr, i3, i2 - i3);
                if (i4 == -1) {
                    break;
                }
                i3 += i4;
            } catch (IOException e2) {
                throw new JSONException(e2);
            }
        }
        this.f14995a += i3;
        if (i3 < i2) {
            throw a("Substring bounds error");
        }
        this.f14997c = cArr[i2 - 1];
        return new String(cArr);
    }

    public final JSONException a(String str) {
        return new JSONException(str + toString());
    }

    public final void a() {
        int i2;
        if (this.f14998d || (i2 = this.f14995a) <= 0) {
            throw new JSONException("Stepping back two steps is not supported");
        }
        this.f14995a = i2 - 1;
        this.f14998d = true;
    }

    public final char b() throws JSONException {
        if (this.f14998d) {
            this.f14998d = false;
            char c2 = this.f14997c;
            if (c2 != 0) {
                this.f14995a++;
            }
            return c2;
        }
        try {
            int i2 = this.f14996b.read();
            if (i2 <= 0) {
                this.f14997c = (char) 0;
                return (char) 0;
            }
            this.f14995a++;
            char c3 = (char) i2;
            this.f14997c = c3;
            return c3;
        } catch (IOException e2) {
            throw new JSONException(e2);
        }
    }

    public final char c() {
        char cB;
        char cB2;
        char cB3;
        while (true) {
            cB = b();
            if (cB == '/') {
                char cB4 = b();
                if (cB4 == '*') {
                    while (true) {
                        char cB5 = b();
                        if (cB5 == 0) {
                            throw a("Unclosed comment");
                        }
                        if (cB5 == '*') {
                            if (b() != '/') {
                                a();
                            }
                        }
                    }
                } else {
                    if (cB4 != '/') {
                        a();
                        return '/';
                    }
                    do {
                        cB2 = b();
                        if (cB2 == '\n' || cB2 == '\r') {
                            break;
                        }
                    } while (cB2 != 0);
                }
            } else if (cB == '#') {
                do {
                    cB3 = b();
                    if (cB3 == '\n' || cB3 == '\r') {
                        break;
                    }
                } while (cB3 != 0);
            } else if (cB == 0 || cB > ' ') {
                break;
            }
        }
        return cB;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0146, code lost:
    
        throw a("Unterminated string");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d() {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.alipay.c.d():java.lang.Object");
    }

    public final String toString() {
        return " at character " + this.f14995a;
    }
}
