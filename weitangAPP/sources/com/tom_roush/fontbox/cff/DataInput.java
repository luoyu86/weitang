package com.tom_roush.fontbox.cff;

import com.tom_roush.fontbox.util.Charsets;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class DataInput {
    private int bufferPosition = 0;
    private final byte[] inputBuffer;

    public DataInput(byte[] bArr) {
        this.inputBuffer = bArr;
    }

    private int peek(int i2) {
        try {
            return this.inputBuffer[this.bufferPosition + i2] & 255;
        } catch (RuntimeException unused) {
            return -1;
        }
    }

    private int read() {
        try {
            byte[] bArr = this.inputBuffer;
            int i2 = this.bufferPosition;
            int i3 = bArr[i2] & 255;
            this.bufferPosition = i2 + 1;
            return i3;
        } catch (RuntimeException unused) {
            return -1;
        }
    }

    public int getPosition() {
        return this.bufferPosition;
    }

    public String getString() throws IOException {
        return new String(this.inputBuffer, Charsets.ISO_8859_1);
    }

    public boolean hasRemaining() {
        return this.bufferPosition < this.inputBuffer.length;
    }

    public int length() {
        return this.inputBuffer.length;
    }

    public int peekUnsignedByte(int i2) throws IOException {
        int iPeek = peek(i2);
        if (iPeek >= 0) {
            return iPeek;
        }
        throw new EOFException();
    }

    public byte readByte() throws IOException {
        try {
            byte[] bArr = this.inputBuffer;
            int i2 = this.bufferPosition;
            byte b2 = bArr[i2];
            this.bufferPosition = i2 + 1;
            return b2;
        } catch (RuntimeException unused) {
            return (byte) -1;
        }
    }

    public byte[] readBytes(int i2) throws IOException {
        if (i2 < 0) {
            throw new IOException("length is negative");
        }
        byte[] bArr = this.inputBuffer;
        int length = bArr.length;
        int i3 = this.bufferPosition;
        if (length - i3 < i2) {
            throw new EOFException();
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i3, bArr2, 0, i2);
        this.bufferPosition += i2;
        return bArr2;
    }

    public int readInt() throws IOException {
        int i2 = read();
        int i3 = read();
        int i4 = read();
        int i5 = read();
        if ((i2 | i3 | i4 | i5) >= 0) {
            return (i2 << 24) | (i3 << 16) | (i4 << 8) | i5;
        }
        throw new EOFException();
    }

    public short readShort() throws IOException {
        return (short) readUnsignedShort();
    }

    public int readUnsignedByte() throws IOException {
        int i2 = read();
        if (i2 >= 0) {
            return i2;
        }
        throw new EOFException();
    }

    public int readUnsignedShort() throws IOException {
        int i2 = read();
        int i3 = read();
        if ((i2 | i3) >= 0) {
            return (i2 << 8) | i3;
        }
        throw new EOFException();
    }

    public void setPosition(int i2) {
        this.bufferPosition = i2;
    }
}
