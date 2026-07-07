package f;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f13000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Inflater f13001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13003d;

    public k(t tVar, Inflater inflater) {
        this(l.buffer(tVar), inflater);
    }

    public final void a() throws IOException {
        int i2 = this.f13002c;
        if (i2 == 0) {
            return;
        }
        int remaining = i2 - this.f13001b.getRemaining();
        this.f13002c -= remaining;
        this.f13000a.skip(remaining);
    }

    @Override // f.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f13003d) {
            return;
        }
        this.f13001b.end();
        this.f13003d = true;
        this.f13000a.close();
    }

    @Override // f.t
    public long read(c cVar, long j) throws IOException {
        boolean zRefill;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f13003d) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            zRefill = refill();
            try {
                p pVarG = cVar.g(1);
                int iInflate = this.f13001b.inflate(pVarG.f13019a, pVarG.f13021c, (int) Math.min(j, 8192 - pVarG.f13021c));
                if (iInflate > 0) {
                    pVarG.f13021c += iInflate;
                    long j2 = iInflate;
                    cVar.f12980c += j2;
                    return j2;
                }
                if (!this.f13001b.finished() && !this.f13001b.needsDictionary()) {
                }
                a();
                if (pVarG.f13020b != pVarG.f13021c) {
                    return -1L;
                }
                cVar.f12979b = pVarG.pop();
                q.a(pVarG);
                return -1L;
            } catch (DataFormatException e2) {
                throw new IOException(e2);
            }
        } while (!zRefill);
        throw new EOFException("source exhausted prematurely");
    }

    public boolean refill() throws IOException {
        if (!this.f13001b.needsInput()) {
            return false;
        }
        a();
        if (this.f13001b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.f13000a.exhausted()) {
            return true;
        }
        p pVar = this.f13000a.buffer().f12979b;
        int i2 = pVar.f13021c;
        int i3 = pVar.f13020b;
        int i4 = i2 - i3;
        this.f13002c = i4;
        this.f13001b.setInput(pVar.f13019a, i3, i4);
        return false;
    }

    @Override // f.t
    public u timeout() {
        return this.f13000a.timeout();
    }

    public k(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f13000a = eVar;
        this.f13001b = inflater;
    }
}
