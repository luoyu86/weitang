package g.a.i.b.b;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteArrayOutputStream f14289a = new ByteArrayOutputStream();

    public static a compose() {
        return new a();
    }

    public a bool(boolean z) {
        this.f14289a.write(z ? 1 : 0);
        return this;
    }

    public byte[] build() {
        return this.f14289a.toByteArray();
    }

    public a bytes(g.a.j.d dVar) {
        try {
            this.f14289a.write(dVar.getEncoded());
            return this;
        } catch (Exception e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        }
    }

    public a bytes(byte[] bArr) {
        try {
            this.f14289a.write(bArr);
            return this;
        } catch (Exception e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        }
    }

    public a bytes(byte[] bArr, int i2, int i3) {
        try {
            this.f14289a.write(bArr, i2, i3);
            return this;
        } catch (Exception e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        }
    }

    public a bytes(g.a.j.d[] dVarArr) {
        try {
            for (g.a.j.d dVar : dVarArr) {
                this.f14289a.write(dVar.getEncoded());
            }
            return this;
        } catch (Exception e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        }
    }

    public a bytes(byte[][] bArr) {
        try {
            for (byte[] bArr2 : bArr) {
                this.f14289a.write(bArr2);
            }
            return this;
        } catch (Exception e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        }
    }

    public a bytes(byte[][] bArr, int i2, int i3) {
        while (i2 != i3) {
            try {
                this.f14289a.write(bArr[i2]);
                i2++;
            } catch (Exception e2) {
                throw new RuntimeException(e2.getMessage(), e2);
            }
        }
        return this;
    }

    public a pad(int i2, int i3) {
        while (i3 >= 0) {
            try {
                this.f14289a.write(i2);
                i3--;
            } catch (Exception e2) {
                throw new RuntimeException(e2.getMessage(), e2);
            }
        }
        return this;
    }

    public a padUntil(int i2, int i3) {
        while (this.f14289a.size() < i3) {
            this.f14289a.write(i2);
        }
        return this;
    }

    public a u16str(int i2) {
        int i3 = i2 & 65535;
        this.f14289a.write((byte) (i3 >>> 8));
        this.f14289a.write((byte) i3);
        return this;
    }

    public a u32str(int i2) {
        this.f14289a.write((byte) (i2 >>> 24));
        this.f14289a.write((byte) (i2 >>> 16));
        this.f14289a.write((byte) (i2 >>> 8));
        this.f14289a.write((byte) i2);
        return this;
    }

    public a u64str(long j) {
        u32str((int) (j >>> 32));
        u32str((int) j);
        return this;
    }
}
