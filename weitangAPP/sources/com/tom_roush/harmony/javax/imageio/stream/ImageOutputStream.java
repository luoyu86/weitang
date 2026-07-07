package com.tom_roush.harmony.javax.imageio.stream;

import java.io.DataOutput;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface ImageOutputStream extends DataOutput, ImageInputStream {
    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    void flushBefore(long j) throws IOException;

    @Override // java.io.DataOutput
    void write(int i2) throws IOException;

    @Override // java.io.DataOutput
    void write(byte[] bArr) throws IOException;

    @Override // java.io.DataOutput
    void write(byte[] bArr, int i2, int i3) throws IOException;

    void writeBit(int i2) throws IOException;

    void writeBits(long j, int i2) throws IOException;

    @Override // java.io.DataOutput
    void writeBoolean(boolean z) throws IOException;

    @Override // java.io.DataOutput
    void writeByte(int i2) throws IOException;

    @Override // java.io.DataOutput
    void writeBytes(String str) throws IOException;

    @Override // java.io.DataOutput
    void writeChar(int i2) throws IOException;

    @Override // java.io.DataOutput
    void writeChars(String str) throws IOException;

    void writeChars(char[] cArr, int i2, int i3) throws IOException;

    @Override // java.io.DataOutput
    void writeDouble(double d2) throws IOException;

    void writeDoubles(double[] dArr, int i2, int i3) throws IOException;

    @Override // java.io.DataOutput
    void writeFloat(float f2) throws IOException;

    void writeFloats(float[] fArr, int i2, int i3) throws IOException;

    @Override // java.io.DataOutput
    void writeInt(int i2) throws IOException;

    void writeInts(int[] iArr, int i2, int i3) throws IOException;

    @Override // java.io.DataOutput
    void writeLong(long j) throws IOException;

    void writeLongs(long[] jArr, int i2, int i3) throws IOException;

    @Override // java.io.DataOutput
    void writeShort(int i2) throws IOException;

    void writeShorts(short[] sArr, int i2, int i3) throws IOException;

    @Override // java.io.DataOutput
    void writeUTF(String str) throws IOException;
}
