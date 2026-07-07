package f;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public interface d extends s, WritableByteChannel {
    c buffer();

    @Override // f.s, java.io.Closeable, java.lang.AutoCloseable
    /* synthetic */ void close() throws IOException;

    d emit() throws IOException;

    d emitCompleteSegments() throws IOException;

    @Override // f.s, java.io.Flushable
    void flush() throws IOException;

    OutputStream outputStream();

    @Override // f.s
    /* synthetic */ u timeout();

    d write(f fVar) throws IOException;

    d write(t tVar, long j) throws IOException;

    d write(byte[] bArr) throws IOException;

    d write(byte[] bArr, int i2, int i3) throws IOException;

    @Override // f.s
    /* synthetic */ void write(c cVar, long j) throws IOException;

    long writeAll(t tVar) throws IOException;

    d writeByte(int i2) throws IOException;

    d writeDecimalLong(long j) throws IOException;

    d writeHexadecimalUnsignedLong(long j) throws IOException;

    d writeInt(int i2) throws IOException;

    d writeIntLe(int i2) throws IOException;

    d writeLong(long j) throws IOException;

    d writeLongLe(long j) throws IOException;

    d writeShort(int i2) throws IOException;

    d writeShortLe(int i2) throws IOException;

    d writeString(String str, int i2, int i3, Charset charset) throws IOException;

    d writeString(String str, Charset charset) throws IOException;

    d writeUtf8(String str) throws IOException;

    d writeUtf8(String str, int i2, int i3) throws IOException;

    d writeUtf8CodePoint(int i2) throws IOException;
}
