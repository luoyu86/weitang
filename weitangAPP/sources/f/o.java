package f;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f13015a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f13016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13017c;

    public o(t tVar) {
        Objects.requireNonNull(tVar, "source == null");
        this.f13016b = tVar;
    }

    @Override // f.e, f.d
    public c buffer() {
        return this.f13015a;
    }

    @Override // f.e, f.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f13017c) {
            return;
        }
        this.f13017c = true;
        this.f13016b.close();
        this.f13015a.clear();
    }

    @Override // f.e
    public boolean exhausted() throws IOException {
        if (this.f13017c) {
            throw new IllegalStateException("closed");
        }
        return this.f13015a.exhausted() && this.f13016b.read(this.f13015a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
    }

    @Override // f.e
    public long indexOf(byte b2) throws IOException {
        return indexOf(b2, 0L, RecyclerView.FOREVER_NS);
    }

    @Override // f.e
    public long indexOfElement(f fVar) throws IOException {
        return indexOfElement(fVar, 0L);
    }

    @Override // f.e
    public InputStream inputStream() {
        return new a();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f13017c;
    }

    @Override // f.e
    public boolean rangeEquals(long j, f fVar) throws IOException {
        return rangeEquals(j, fVar, 0, fVar.size());
    }

    @Override // f.e, f.t
    public long read(c cVar, long j) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f13017c) {
            throw new IllegalStateException("closed");
        }
        c cVar2 = this.f13015a;
        if (cVar2.f12980c == 0 && this.f13016b.read(cVar2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1L;
        }
        return this.f13015a.read(cVar, Math.min(j, this.f13015a.f12980c));
    }

    @Override // f.e
    public long readAll(s sVar) throws IOException {
        if (sVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j = 0;
        while (this.f13016b.read(this.f13015a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
            long jCompleteSegmentByteCount = this.f13015a.completeSegmentByteCount();
            if (jCompleteSegmentByteCount > 0) {
                j += jCompleteSegmentByteCount;
                sVar.write(this.f13015a, jCompleteSegmentByteCount);
            }
        }
        if (this.f13015a.size() <= 0) {
            return j;
        }
        long size = j + this.f13015a.size();
        c cVar = this.f13015a;
        sVar.write(cVar, cVar.size());
        return size;
    }

    @Override // f.e
    public byte readByte() throws IOException {
        require(1L);
        return this.f13015a.readByte();
    }

    @Override // f.e
    public byte[] readByteArray() throws IOException {
        this.f13015a.writeAll(this.f13016b);
        return this.f13015a.readByteArray();
    }

    @Override // f.e
    public f readByteString() throws IOException {
        this.f13015a.writeAll(this.f13016b);
        return this.f13015a.readByteString();
    }

    @Override // f.e
    public long readDecimalLong() throws IOException {
        byte b2;
        require(1L);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (!request(i3)) {
                break;
            }
            b2 = this.f13015a.getByte(i2);
            if ((b2 < 48 || b2 > 57) && !(i2 == 0 && b2 == 45)) {
                break;
            }
            i2 = i3;
        }
        if (i2 == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(b2)));
        }
        return this.f13015a.readDecimalLong();
    }

    @Override // f.e
    public void readFully(byte[] bArr) throws IOException {
        try {
            require(bArr.length);
            this.f13015a.readFully(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (true) {
                c cVar = this.f13015a;
                long j = cVar.f12980c;
                if (j <= 0) {
                    throw e2;
                }
                int i3 = cVar.read(bArr, i2, (int) j);
                if (i3 == -1) {
                    throw new AssertionError();
                }
                i2 += i3;
            }
        }
    }

    @Override // f.e
    public long readHexadecimalUnsignedLong() throws IOException {
        byte b2;
        require(1L);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (!request(i3)) {
                break;
            }
            b2 = this.f13015a.getByte(i2);
            if ((b2 < 48 || b2 > 57) && ((b2 < 97 || b2 > 102) && (b2 < 65 || b2 > 70))) {
                break;
            }
            i2 = i3;
        }
        if (i2 == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(b2)));
        }
        return this.f13015a.readHexadecimalUnsignedLong();
    }

    @Override // f.e
    public int readInt() throws IOException {
        require(4L);
        return this.f13015a.readInt();
    }

    @Override // f.e
    public int readIntLe() throws IOException {
        require(4L);
        return this.f13015a.readIntLe();
    }

    @Override // f.e
    public long readLong() throws IOException {
        require(8L);
        return this.f13015a.readLong();
    }

    @Override // f.e
    public long readLongLe() throws IOException {
        require(8L);
        return this.f13015a.readLongLe();
    }

    @Override // f.e
    public short readShort() throws IOException {
        require(2L);
        return this.f13015a.readShort();
    }

    @Override // f.e
    public short readShortLe() throws IOException {
        require(2L);
        return this.f13015a.readShortLe();
    }

    @Override // f.e
    public String readString(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.f13015a.writeAll(this.f13016b);
        return this.f13015a.readString(charset);
    }

    @Override // f.e
    public String readUtf8() throws IOException {
        this.f13015a.writeAll(this.f13016b);
        return this.f13015a.readUtf8();
    }

    @Override // f.e
    public int readUtf8CodePoint() throws IOException {
        require(1L);
        byte b2 = this.f13015a.getByte(0L);
        if ((b2 & 224) == 192) {
            require(2L);
        } else if ((b2 & 240) == 224) {
            require(3L);
        } else if ((b2 & 248) == 240) {
            require(4L);
        }
        return this.f13015a.readUtf8CodePoint();
    }

    @Override // f.e
    @Nullable
    public String readUtf8Line() throws IOException {
        long jIndexOf = indexOf((byte) 10);
        if (jIndexOf != -1) {
            return this.f13015a.e(jIndexOf);
        }
        long j = this.f13015a.f12980c;
        if (j != 0) {
            return readUtf8(j);
        }
        return null;
    }

    @Override // f.e
    public String readUtf8LineStrict() throws IOException {
        return readUtf8LineStrict(RecyclerView.FOREVER_NS);
    }

    @Override // f.e
    public boolean request(long j) throws IOException {
        c cVar;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f13017c) {
            throw new IllegalStateException("closed");
        }
        do {
            cVar = this.f13015a;
            if (cVar.f12980c >= j) {
                return true;
            }
        } while (this.f13016b.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return false;
    }

    @Override // f.e
    public void require(long j) throws IOException {
        if (!request(j)) {
            throw new EOFException();
        }
    }

    @Override // f.e
    public int select(m mVar) throws IOException {
        c cVar;
        if (this.f13017c) {
            throw new IllegalStateException("closed");
        }
        do {
            int iF = this.f13015a.f(mVar);
            if (iF == -1) {
                return -1;
            }
            long size = mVar.f13010a[iF].size();
            cVar = this.f13015a;
            if (size <= cVar.f12980c) {
                cVar.skip(size);
                return iF;
            }
        } while (this.f13016b.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return -1;
    }

    @Override // f.e
    public void skip(long j) throws IOException {
        if (this.f13017c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            c cVar = this.f13015a;
            if (cVar.f12980c == 0 && this.f13016b.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.f13015a.size());
            this.f13015a.skip(jMin);
            j -= jMin;
        }
    }

    @Override // f.e, f.t
    public u timeout() {
        return this.f13016b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f13016b + ")";
    }

    @Override // f.e
    public long indexOf(byte b2, long j) throws IOException {
        return indexOf(b2, j, RecyclerView.FOREVER_NS);
    }

    @Override // f.e
    public long indexOfElement(f fVar, long j) throws IOException {
        if (this.f13017c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jIndexOfElement = this.f13015a.indexOfElement(fVar, j);
            if (jIndexOfElement != -1) {
                return jIndexOfElement;
            }
            c cVar = this.f13015a;
            long j2 = cVar.f12980c;
            if (this.f13016b.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j = Math.max(j, j2);
        }
    }

    @Override // f.e
    public boolean rangeEquals(long j, f fVar, int i2, int i3) throws IOException {
        if (this.f13017c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || i2 < 0 || i3 < 0 || fVar.size() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            long j2 = ((long) i4) + j;
            if (!request(1 + j2) || this.f13015a.getByte(j2) != fVar.getByte(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    @Override // f.e
    public String readUtf8LineStrict(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j == RecyclerView.FOREVER_NS ? Long.MAX_VALUE : j + 1;
        long jIndexOf = indexOf((byte) 10, 0L, j2);
        if (jIndexOf != -1) {
            return this.f13015a.e(jIndexOf);
        }
        if (j2 < RecyclerView.FOREVER_NS && request(j2) && this.f13015a.getByte(j2 - 1) == 13 && request(1 + j2) && this.f13015a.getByte(j2) == 10) {
            return this.f13015a.e(j2);
        }
        c cVar = new c();
        c cVar2 = this.f13015a;
        cVar2.copyTo(cVar, 0L, Math.min(32L, cVar2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f13015a.size(), j) + " content=" + cVar.readByteString().hex() + (char) 8230);
    }

    @Override // f.e
    public long indexOf(byte b2, long j, long j2) throws IOException {
        if (this.f13017c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long jIndexOf = this.f13015a.indexOf(b2, j, j2);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            c cVar = this.f13015a;
            long j3 = cVar.f12980c;
            if (j3 >= j2 || this.f13016b.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                break;
            }
            j = Math.max(j, j3);
        }
        return -1L;
    }

    @Override // f.e
    public byte[] readByteArray(long j) throws IOException {
        require(j);
        return this.f13015a.readByteArray(j);
    }

    @Override // f.e
    public f readByteString(long j) throws IOException {
        require(j);
        return this.f13015a.readByteString(j);
    }

    @Override // f.e
    public String readUtf8(long j) throws IOException {
        require(j);
        return this.f13015a.readUtf8(j);
    }

    @Override // f.e
    public String readString(long j, Charset charset) throws IOException {
        require(j);
        if (charset != null) {
            return this.f13015a.readString(j, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            o oVar = o.this;
            if (oVar.f13017c) {
                throw new IOException("closed");
            }
            return (int) Math.min(oVar.f13015a.f12980c, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            o.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            o oVar = o.this;
            if (oVar.f13017c) {
                throw new IOException("closed");
            }
            c cVar = oVar.f13015a;
            if (cVar.f12980c == 0 && oVar.f13016b.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1;
            }
            return o.this.f13015a.readByte() & 255;
        }

        public String toString() {
            return o.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            if (!o.this.f13017c) {
                v.checkOffsetAndCount(bArr.length, i2, i3);
                o oVar = o.this;
                c cVar = oVar.f13015a;
                if (cVar.f12980c == 0 && oVar.f13016b.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return o.this.f13015a.read(bArr, i2, i3);
            }
            throw new IOException("closed");
        }
    }

    @Override // f.e
    public void readFully(c cVar, long j) throws IOException {
        try {
            require(j);
            this.f13015a.readFully(cVar, j);
        } catch (EOFException e2) {
            cVar.writeAll(this.f13015a);
            throw e2;
        }
    }

    @Override // f.e
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // f.e
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        long j = i3;
        v.checkOffsetAndCount(bArr.length, i2, j);
        c cVar = this.f13015a;
        if (cVar.f12980c == 0 && this.f13016b.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.f13015a.read(bArr, i2, (int) Math.min(j, this.f13015a.f12980c));
    }

    @Override // f.e
    public long indexOf(f fVar) throws IOException {
        return indexOf(fVar, 0L);
    }

    @Override // f.e
    public long indexOf(f fVar, long j) throws IOException {
        if (this.f13017c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jIndexOf = this.f13015a.indexOf(fVar, j);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            c cVar = this.f13015a;
            long j2 = cVar.f12980c;
            if (this.f13016b.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j = Math.max(j, (j2 - ((long) fVar.size())) + 1);
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        c cVar = this.f13015a;
        if (cVar.f12980c == 0 && this.f13016b.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.f13015a.read(byteBuffer);
    }
}
