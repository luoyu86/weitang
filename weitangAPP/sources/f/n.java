package f;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f13011a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f13012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13013c;

    public n(s sVar) {
        Objects.requireNonNull(sVar, "sink == null");
        this.f13012b = sVar;
    }

    @Override // f.d
    public c buffer() {
        return this.f13011a;
    }

    @Override // f.d, f.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f13013c) {
            return;
        }
        Throwable th = null;
        try {
            c cVar = this.f13011a;
            long j = cVar.f12980c;
            if (j > 0) {
                this.f13012b.write(cVar, j);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f13012b.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f13013c = true;
        if (th != null) {
            v.sneakyRethrow(th);
        }
    }

    @Override // f.d
    public d emit() throws IOException {
        if (this.f13013c) {
            throw new IllegalStateException("closed");
        }
        long size = this.f13011a.size();
        if (size > 0) {
            this.f13012b.write(this.f13011a, size);
        }
        return this;
    }

    @Override // f.d
    public d emitCompleteSegments() throws IOException {
        if (this.f13013c) {
            throw new IllegalStateException("closed");
        }
        long jCompleteSegmentByteCount = this.f13011a.completeSegmentByteCount();
        if (jCompleteSegmentByteCount > 0) {
            this.f13012b.write(this.f13011a, jCompleteSegmentByteCount);
        }
        return this;
    }

    @Override // f.d, f.s, java.io.Flushable
    public void flush() throws IOException {
        if (this.f13013c) {
            throw new IllegalStateException("closed");
        }
        c cVar = this.f13011a;
        long j = cVar.f12980c;
        if (j > 0) {
            this.f13012b.write(cVar, j);
        }
        this.f13012b.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f13013c;
    }

    @Override // f.d
    public OutputStream outputStream() {
        return new a();
    }

    @Override // f.d, f.s
    public u timeout() {
        return this.f13012b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f13012b + ")";
    }

    @Override // f.d, f.s
    public void write(c cVar, long j) throws IOException {
        if (this.f13013c) {
            throw new IllegalStateException("closed");
        }
        this.f13011a.write(cVar, j);
        emitCompleteSegments();
    }

    @Override // f.d
    public long writeAll(t tVar) throws IOException {
        if (tVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long j2 = tVar.read(this.f13011a, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (j2 == -1) {
                return j;
            }
            j += j2;
            emitCompleteSegments();
        }
    }

    @Override // f.d
    public d writeByte(int i2) throws IOException {
        if (this.f13013c) {
            throw new IllegalStateException("closed");
        }
        this.f13011a.writeByte(i2);
        return emitCompleteSegments();
    }

    @Override // f.d
    public d writeDecimalLong(long j) throws IOException {
        if (this.f13013c) {
            throw new IllegalStateException("closed");
        }
        this.f13011a.writeDecimalLong(j);
        return emitCompleteSegments();
    }

    @Override // f.d
    public d writeHexadecimalUnsignedLong(long j) throws IOException {
        if (this.f13013c) {
            throw new IllegalStateException("closed");
        }
        this.f13011a.writeHexadecimalUnsignedLong(j);
        return emitCompleteSegments();
    }

    @Override // f.d
    public d writeInt(int i2) throws IOException {
        if (this.f13013c) {
            throw new IllegalStateException("closed");
        }
        this.f13011a.writeInt(i2);
        return emitCompleteSegments();
    }

    @Override // f.d
    public d writeIntLe(int i2) throws IOException {
        if (this.f13013c) {
            throw new IllegalStateException("closed");
        }
        this.f13011a.writeIntLe(i2);
        return emitCompleteSegments();
    }

    @Override // f.d
    public d writeLong(long j) throws IOException {
        if (this.f13013c) {
            throw new IllegalStateException("closed");
        }
        this.f13011a.writeLong(j);
        return emitCompleteSegments();
    }

    @Override // f.d
    public d writeLongLe(long j) throws IOException {
        if (this.f13013c) {
            throw new IllegalStateException("closed");
        }
        this.f13011a.writeLongLe(j);
        return emitCompleteSegments();
    }

    @Override // f.d
    public d writeShort(int i2) throws IOException {
        if (this.f13013c) {
            throw new IllegalStateException("closed");
        }
        this.f13011a.writeShort(i2);
        return emitCompleteSegments();
    }

    @Override // f.d
    public d writeShortLe(int i2) throws IOException {
        if (this.f13013c) {
            throw new IllegalStateException("closed");
        }
        this.f13011a.writeShortLe(i2);
        return emitCompleteSegments();
    }

    @Override // f.d
    public d writeString(String str, Charset charset) throws IOException {
        if (this.f13013c) {
            throw new IllegalStateException("closed");
        }
        this.f13011a.writeString(str, charset);
        return emitCompleteSegments();
    }

    @Override // f.d
    public d writeUtf8(String str) throws IOException {
        if (this.f13013c) {
            throw new IllegalStateException("closed");
        }
        this.f13011a.writeUtf8(str);
        return emitCompleteSegments();
    }

    @Override // f.d
    public d writeUtf8CodePoint(int i2) throws IOException {
        if (this.f13013c) {
            throw new IllegalStateException("closed");
        }
        this.f13011a.writeUtf8CodePoint(i2);
        return emitCompleteSegments();
    }

    public class a extends OutputStream {
        public a() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws Throwable {
            n.this.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            n nVar = n.this;
            if (nVar.f13013c) {
                return;
            }
            nVar.flush();
        }

        public String toString() {
            return n.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i2) throws IOException {
            n nVar = n.this;
            if (nVar.f13013c) {
                throw new IOException("closed");
            }
            nVar.f13011a.writeByte((int) ((byte) i2));
            n.this.emitCompleteSegments();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            n nVar = n.this;
            if (!nVar.f13013c) {
                nVar.f13011a.write(bArr, i2, i3);
                n.this.emitCompleteSegments();
                return;
            }
            throw new IOException("closed");
        }
    }

    @Override // f.d
    public d write(f fVar) throws IOException {
        if (!this.f13013c) {
            this.f13011a.write(fVar);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // f.d
    public d writeString(String str, int i2, int i3, Charset charset) throws IOException {
        if (!this.f13013c) {
            this.f13011a.writeString(str, i2, i3, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // f.d
    public d writeUtf8(String str, int i2, int i3) throws IOException {
        if (!this.f13013c) {
            this.f13011a.writeUtf8(str, i2, i3);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // f.d
    public d write(byte[] bArr) throws IOException {
        if (!this.f13013c) {
            this.f13011a.write(bArr);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // f.d
    public d write(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.f13013c) {
            this.f13011a.write(bArr, i2, i3);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f13013c) {
            int iWrite = this.f13011a.write(byteBuffer);
            emitCompleteSegments();
            return iWrite;
        }
        throw new IllegalStateException("closed");
    }

    @Override // f.d
    public d write(t tVar, long j) throws IOException {
        while (j > 0) {
            long j2 = tVar.read(this.f13011a, j);
            if (j2 != -1) {
                j -= j2;
                emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return this;
    }
}
