package com.bytedance.pangle.res.a;

import androidx.core.view.InputDeviceCompat;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Logger f6193f = Logger.getLogger(a.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f6194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f6195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f6196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f6197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private C0107a f6198e;

    /* JADX INFO: renamed from: com.bytedance.pangle.res.a.a$a, reason: collision with other inner class name */
    public static class C0107a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final short f6199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f6200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f6201c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f6202d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f6203e;

        private C0107a(short s, int i2, int i3, int i4) {
            this.f6199a = s;
            this.f6200b = i2;
            this.f6201c = i3;
            this.f6202d = i4;
            this.f6203e = i4 + i3;
        }

        public static C0107a a(g gVar, e eVar) {
            int iA = eVar.a();
            try {
                return new C0107a(gVar.readShort(), gVar.readShort(), gVar.readInt(), iA);
            } catch (EOFException unused) {
                return new C0107a((short) -1, 0, 0, eVar.a());
            }
        }
    }

    public a(byte[] bArr, h hVar) {
        e eVar = new e(new ByteArrayInputStream(bArr));
        this.f6197d = eVar;
        this.f6196c = new g(new i(eVar));
        this.f6194a = bArr;
        this.f6195b = hVar;
    }

    private String a(int i2) {
        int i3;
        short s;
        StringBuilder sb = new StringBuilder(16);
        while (true) {
            i3 = i2 - 1;
            if (i2 == 0 || this.f6196c.readByte() == 0) {
                break;
            }
            sb.append((char) s);
            i2 = i3;
        }
        this.f6196c.skipBytes(i3);
        return sb.toString();
    }

    private void b() throws IOException {
        b(515);
        int i2 = this.f6196c.readInt();
        for (int i3 = 0; i3 < i2; i3++) {
            this.f6196c.readInt();
            this.f6196c.skipBytes(256);
        }
        while (j().f6199a == 513) {
            c();
        }
    }

    private void c() throws IOException {
        d();
        short s = j().f6199a;
        while (s == 514) {
            d();
            s = j().f6199a;
        }
        while (s == 513) {
            e();
            if (this.f6197d.a() < this.f6198e.f6203e) {
                f6193f.warning("Unknown data detected. Skipping: " + (this.f6198e.f6203e - this.f6197d.a()) + " byte(s)");
                e eVar = this.f6197d;
                eVar.skip((long) (this.f6198e.f6203e - eVar.a()));
            }
            s = j().f6199a;
        }
    }

    private void d() {
        b(514);
        this.f6196c.readUnsignedByte();
        this.f6196c.skipBytes(3);
        this.f6196c.skipBytes(this.f6196c.readInt() * 4);
    }

    private void e() throws IOException {
        b(InputDeviceCompat.SOURCE_DPAD);
        this.f6196c.readUnsignedByte();
        this.f6196c.readByte();
        this.f6196c.skipBytes(2);
        int i2 = this.f6196c.readInt();
        int i3 = this.f6196c.readInt();
        i();
        int i4 = (this.f6198e.f6202d + i3) - (i2 * 4);
        if (i4 != this.f6197d.a()) {
            f6193f.warning("Invalid data detected. Skipping: " + (i4 - this.f6197d.a()) + " byte(s)");
            this.f6196c.skipBytes(i4 - this.f6197d.a());
        }
        int[] iArrA = this.f6196c.a(i2);
        HashSet hashSet = new HashSet();
        for (int i5 : iArrA) {
            if (i5 != -1 && !hashSet.contains(Integer.valueOf(i5))) {
                f();
                hashSet.add(Integer.valueOf(i5));
            }
        }
    }

    private void f() throws IOException {
        if (this.f6196c.readShort() < 0) {
            throw new RuntimeException("Entry size is under 0 bytes.");
        }
        short s = this.f6196c.readShort();
        this.f6196c.readInt();
        if ((s & 1) == 0) {
            h();
        } else {
            g();
        }
    }

    private void g() throws IOException {
        int iA = k.a(this.f6196c);
        k.a(this.f6194a, this.f6196c.readInt(), iA, this.f6195b);
        int i2 = this.f6196c.readInt();
        for (int i3 = 0; i3 < i2; i3++) {
            int iA2 = k.a(this.f6196c);
            k.a(this.f6194a, this.f6196c.readInt(), iA2, this.f6195b);
            h();
        }
    }

    private void h() throws IOException {
        this.f6196c.a();
        this.f6196c.b();
        byte b2 = this.f6196c.readByte();
        int iA = k.a(this.f6196c);
        int i2 = this.f6196c.readInt();
        if (b2 == 1) {
            k.a(this.f6194a, i2, iA, this.f6195b);
        }
        if (b2 == 2) {
            k.a(this.f6194a, i2, iA, this.f6195b);
        }
    }

    private void i() throws IOException {
        int i2 = this.f6196c.readInt();
        int i3 = 28;
        if (i2 < 28) {
            throw new RuntimeException("Config size < 28");
        }
        this.f6196c.readShort();
        this.f6196c.readShort();
        this.f6196c.readByte();
        this.f6196c.readByte();
        this.f6196c.readByte();
        this.f6196c.readByte();
        this.f6196c.readByte();
        this.f6196c.readByte();
        this.f6196c.readUnsignedShort();
        this.f6196c.readByte();
        this.f6196c.readByte();
        this.f6196c.readByte();
        this.f6196c.skipBytes(1);
        this.f6196c.readShort();
        this.f6196c.readShort();
        this.f6196c.readShort();
        this.f6196c.skipBytes(2);
        if (i2 >= 32) {
            this.f6196c.readByte();
            this.f6196c.readByte();
            this.f6196c.readShort();
            i3 = 32;
        }
        if (i2 >= 36) {
            this.f6196c.readShort();
            this.f6196c.readShort();
            i3 = 36;
        }
        if (i2 >= 48) {
            a(4).toCharArray();
            a(8).toCharArray();
            i3 = 48;
        }
        if (i2 >= 52) {
            this.f6196c.readByte();
            this.f6196c.readByte();
            this.f6196c.skipBytes(2);
            i3 = 52;
        }
        if (i2 >= 56) {
            this.f6196c.skipBytes(4);
            i3 = 56;
        }
        int i4 = i2 - 56;
        if (i4 > 0) {
            byte[] bArr = new byte[i4];
            i3 += i4;
            this.f6196c.readFully(bArr);
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.equals(BigInteger.ZERO)) {
                f6193f.fine(String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", 56));
            } else {
                f6193f.warning(String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", 56, Integer.valueOf(i2), bigInteger));
            }
        }
        int i5 = i2 - i3;
        if (i5 > 0) {
            this.f6196c.skipBytes(i5);
        }
    }

    private C0107a j() {
        C0107a c0107aA = C0107a.a(this.f6196c, this.f6197d);
        this.f6198e = c0107aA;
        return c0107aA;
    }

    public final void a() throws IOException {
        j();
        b(2);
        int i2 = this.f6196c.readInt();
        l.a(this.f6196c);
        j();
        for (int i3 = 0; i3 < i2; i3++) {
            b(512);
            this.f6196c.readInt();
            this.f6196c.skipBytes(256);
            this.f6196c.skipBytes(4);
            this.f6196c.skipBytes(4);
            this.f6196c.skipBytes(4);
            this.f6196c.skipBytes(4);
            if (this.f6198e.f6200b == 288 && this.f6196c.readInt() > 0) {
                throw new RuntimeException("don't support");
            }
            l.a(this.f6196c);
            l.a(this.f6196c);
            j();
            boolean z = true;
            while (z) {
                short s = this.f6198e.f6199a;
                if (s == 514) {
                    c();
                } else if (s != 515) {
                    z = false;
                } else {
                    b();
                }
            }
        }
    }

    private void b(int i2) {
        if (this.f6198e.f6199a != i2) {
            throw new RuntimeException(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", Integer.valueOf(i2), Short.valueOf(this.f6198e.f6199a)));
        }
    }
}
