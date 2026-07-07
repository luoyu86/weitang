package f;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f12996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Inflater f12997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f12998d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12995a = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CRC32 f12999e = new CRC32();

    public j(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.f12997c = inflater;
        e eVarBuffer = l.buffer(tVar);
        this.f12996b = eVarBuffer;
        this.f12998d = new k(eVarBuffer, inflater);
    }

    public final void a(String str, int i2, int i3) throws IOException {
        if (i3 != i2) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i3), Integer.valueOf(i2)));
        }
    }

    public final void b() throws IOException {
        this.f12996b.require(10L);
        byte b2 = this.f12996b.buffer().getByte(3L);
        boolean z = ((b2 >> 1) & 1) == 1;
        if (z) {
            d(this.f12996b.buffer(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.f12996b.readShort());
        this.f12996b.skip(8L);
        if (((b2 >> 2) & 1) == 1) {
            this.f12996b.require(2L);
            if (z) {
                d(this.f12996b.buffer(), 0L, 2L);
            }
            long shortLe = this.f12996b.buffer().readShortLe();
            this.f12996b.require(shortLe);
            if (z) {
                d(this.f12996b.buffer(), 0L, shortLe);
            }
            this.f12996b.skip(shortLe);
        }
        if (((b2 >> 3) & 1) == 1) {
            long jIndexOf = this.f12996b.indexOf((byte) 0);
            if (jIndexOf == -1) {
                throw new EOFException();
            }
            if (z) {
                d(this.f12996b.buffer(), 0L, jIndexOf + 1);
            }
            this.f12996b.skip(jIndexOf + 1);
        }
        if (((b2 >> 4) & 1) == 1) {
            long jIndexOf2 = this.f12996b.indexOf((byte) 0);
            if (jIndexOf2 == -1) {
                throw new EOFException();
            }
            if (z) {
                d(this.f12996b.buffer(), 0L, jIndexOf2 + 1);
            }
            this.f12996b.skip(jIndexOf2 + 1);
        }
        if (z) {
            a("FHCRC", this.f12996b.readShortLe(), (short) this.f12999e.getValue());
            this.f12999e.reset();
        }
    }

    public final void c() throws IOException {
        a("CRC", this.f12996b.readIntLe(), (int) this.f12999e.getValue());
        a("ISIZE", this.f12996b.readIntLe(), (int) this.f12997c.getBytesWritten());
    }

    @Override // f.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f12998d.close();
    }

    public final void d(c cVar, long j, long j2) {
        p pVar = cVar.f12979b;
        while (true) {
            int i2 = pVar.f13021c;
            int i3 = pVar.f13020b;
            if (j < i2 - i3) {
                break;
            }
            j -= (long) (i2 - i3);
            pVar = pVar.f13024f;
        }
        while (j2 > 0) {
            int i4 = (int) (((long) pVar.f13020b) + j);
            int iMin = (int) Math.min(pVar.f13021c - i4, j2);
            this.f12999e.update(pVar.f13019a, i4, iMin);
            j2 -= (long) iMin;
            pVar = pVar.f13024f;
            j = 0;
        }
    }

    @Override // f.t
    public long read(c cVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        if (this.f12995a == 0) {
            b();
            this.f12995a = 1;
        }
        if (this.f12995a == 1) {
            long j2 = cVar.f12980c;
            long j3 = this.f12998d.read(cVar, j);
            if (j3 != -1) {
                d(cVar, j2, j3);
                return j3;
            }
            this.f12995a = 2;
        }
        if (this.f12995a == 2) {
            c();
            this.f12995a = 3;
            if (!this.f12996b.exhausted()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // f.t
    public u timeout() {
        return this.f12996b.timeout();
    }
}
