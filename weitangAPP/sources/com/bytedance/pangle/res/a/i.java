package com.bytedance.pangle.res.a;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class i extends FilterInputStream implements DataInput {
    public i(e eVar) {
        super(eVar);
    }

    private static int a(byte b2, byte b3, byte b4, byte b5) {
        return (b2 << 24) | ((b3 & 255) << 16) | ((b4 & 255) << 8) | (b5 & 255);
    }

    private byte b() throws IOException {
        int i2 = ((FilterInputStream) this).in.read();
        if (-1 != i2) {
            return (byte) i2;
        }
        throw new EOFException();
    }

    public final e a() {
        return (e) ((FilterInputStream) this).in;
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        return readUnsignedByte() != 0;
    }

    @Override // java.io.DataInput
    public final byte readByte() {
        return (byte) readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        return (char) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i2, int i3) throws IOException {
        d.a(this, bArr, i2, i3);
    }

    @Override // java.io.DataInput
    public final int readInt() throws IOException {
        byte b2 = b();
        byte b3 = b();
        return a(b(), b(), b3, b2);
    }

    @Override // java.io.DataInput
    public final String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    @Override // java.io.DataInput
    public final long readLong() throws IOException {
        byte b2 = b();
        byte b3 = b();
        byte b4 = b();
        byte b5 = b();
        byte b6 = b();
        byte b7 = b();
        return ((((long) b()) & 255) << 56) | ((((long) b()) & 255) << 48) | ((((long) b7) & 255) << 40) | ((((long) b6) & 255) << 32) | ((((long) b5) & 255) << 24) | ((((long) b4) & 255) << 16) | ((((long) b3) & 255) << 8) | (((long) b2) & 255);
    }

    @Override // java.io.DataInput
    public final short readShort() {
        return (short) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        return new DataInputStream(((FilterInputStream) this).in).readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() throws IOException {
        int i2 = ((FilterInputStream) this).in.read();
        if (i2 >= 0) {
            return i2;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() throws IOException {
        return a((byte) 0, (byte) 0, b(), b());
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i2) {
        return (int) ((FilterInputStream) this).in.skip(i2);
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) throws IOException {
        d.a(this, bArr, 0, bArr.length);
    }
}
