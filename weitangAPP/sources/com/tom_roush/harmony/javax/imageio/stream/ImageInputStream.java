package com.tom_roush.harmony.javax.imageio.stream;

import java.io.DataInput;
import java.io.IOException;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public interface ImageInputStream extends DataInput {
    void close() throws IOException;

    void flush() throws IOException;

    void flushBefore(long j) throws IOException;

    int getBitOffset() throws IOException;

    ByteOrder getByteOrder();

    long getFlushedPosition();

    long getStreamPosition() throws IOException;

    boolean isCached();

    boolean isCachedFile();

    boolean isCachedMemory();

    long length() throws IOException;

    void mark();

    int read() throws IOException;

    int read(byte[] bArr) throws IOException;

    int read(byte[] bArr, int i2, int i3) throws IOException;

    int readBit() throws IOException;

    long readBits(int i2) throws IOException;

    @Override // java.io.DataInput
    boolean readBoolean() throws IOException;

    @Override // java.io.DataInput
    byte readByte() throws IOException;

    void readBytes(IIOByteBuffer iIOByteBuffer, int i2) throws IOException;

    @Override // java.io.DataInput
    char readChar() throws IOException;

    @Override // java.io.DataInput
    double readDouble() throws IOException;

    @Override // java.io.DataInput
    float readFloat() throws IOException;

    @Override // java.io.DataInput
    void readFully(byte[] bArr) throws IOException;

    @Override // java.io.DataInput
    void readFully(byte[] bArr, int i2, int i3) throws IOException;

    void readFully(char[] cArr, int i2, int i3) throws IOException;

    void readFully(double[] dArr, int i2, int i3) throws IOException;

    void readFully(float[] fArr, int i2, int i3) throws IOException;

    void readFully(int[] iArr, int i2, int i3) throws IOException;

    void readFully(long[] jArr, int i2, int i3) throws IOException;

    void readFully(short[] sArr, int i2, int i3) throws IOException;

    @Override // java.io.DataInput
    int readInt() throws IOException;

    @Override // java.io.DataInput
    String readLine() throws IOException;

    @Override // java.io.DataInput
    long readLong() throws IOException;

    @Override // java.io.DataInput
    short readShort() throws IOException;

    @Override // java.io.DataInput
    String readUTF() throws IOException;

    @Override // java.io.DataInput
    int readUnsignedByte() throws IOException;

    long readUnsignedInt() throws IOException;

    @Override // java.io.DataInput
    int readUnsignedShort() throws IOException;

    void reset() throws IOException;

    void seek(long j) throws IOException;

    void setBitOffset(int i2) throws IOException;

    void setByteOrder(ByteOrder byteOrder);

    @Override // java.io.DataInput
    int skipBytes(int i2) throws IOException;

    long skipBytes(long j) throws IOException;
}
