package com.tom_roush.harmony.javax.imageio.stream;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImageOutputStreamImpl extends ImageInputStreamImpl implements ImageOutputStream {
    private final byte[] buff = new byte[8];

    public final void flushBits() throws IOException {
        checkClosed();
        int i2 = this.bitOffset;
        if (i2 == 0) {
            return;
        }
        int i3 = read();
        int i4 = 0;
        if (i3 == -1) {
            this.bitOffset = 0;
        } else {
            seek(getStreamPosition() - 1);
            i4 = i3 & ((-1) << (8 - i2));
        }
        write(i4);
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public abstract void write(int i2) throws IOException;

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public abstract void write(byte[] bArr, int i2, int i3) throws IOException;

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream
    public void writeBit(int i2) throws IOException {
        writeBits(i2, 1);
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream
    public void writeBits(long j, int i2) throws IOException {
        checkClosed();
        int i3 = this.bitOffset;
        if (i3 > 0) {
            int i4 = read();
            if (i4 == -1) {
                i4 = 0;
            } else {
                seek(getStreamPosition() - 1);
            }
            int i5 = 8 - i3;
            if (i2 >= i5) {
                int i6 = (-1) >>> (32 - i5);
                i2 -= i5;
                write((int) ((((long) i6) & (j >> i2)) | ((long) ((~i6) & i4))));
            } else {
                int i7 = i3 + i2;
                int i8 = (-1) >>> i2;
                int i9 = 8 - i7;
                write((int) (((((long) i8) & j) << i9) | ((long) (i4 & (~(i8 << i9))))));
                seek(getStreamPosition() - 1);
                this.bitOffset = i7;
                i2 = 0;
            }
        }
        while (i2 > 7) {
            write((int) (((long) 255) & (j >> (i2 - 8))));
            i2 -= 8;
        }
        if (i2 > 0) {
            write((int) ((j << (8 - i2)) & ((long) 255)));
            seek(getStreamPosition() - 1);
            this.bitOffset = i2;
        }
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void writeBoolean(boolean z) throws IOException {
        write(z ? 1 : 0);
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void writeByte(int i2) throws IOException {
        write(i2);
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void writeBytes(String str) throws IOException {
        write(str.getBytes());
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void writeChar(int i2) throws IOException {
        writeShort(i2);
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void writeChars(String str) throws IOException {
        char[] charArray = str.toCharArray();
        writeChars(charArray, 0, charArray.length);
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void writeDouble(double d2) throws IOException {
        writeLong(Double.doubleToLongBits(d2));
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream
    public void writeDoubles(double[] dArr, int i2, int i3) throws IOException {
        if (i2 < 0 || i3 < 0 || i2 + i3 > dArr.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i4 = 0; i4 < i3; i4++) {
            writeDouble(dArr[i2 + i4]);
        }
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void writeFloat(float f2) throws IOException {
        writeInt(Float.floatToIntBits(f2));
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream
    public void writeFloats(float[] fArr, int i2, int i3) throws IOException {
        if (i2 < 0 || i3 < 0 || i2 + i3 > fArr.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i4 = 0; i4 < i3; i4++) {
            writeFloat(fArr[i2 + i4]);
        }
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void writeInt(int i2) throws IOException {
        if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.buff;
            bArr[0] = (byte) (i2 >> 24);
            bArr[1] = (byte) (i2 >> 16);
            bArr[2] = (byte) (i2 >> 8);
            bArr[3] = (byte) i2;
        } else {
            byte[] bArr2 = this.buff;
            bArr2[3] = (byte) (i2 >> 24);
            bArr2[2] = (byte) (i2 >> 16);
            bArr2[1] = (byte) (i2 >> 8);
            bArr2[0] = (byte) i2;
        }
        write(this.buff, 0, 4);
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream
    public void writeInts(int[] iArr, int i2, int i3) throws IOException {
        if (i2 < 0 || i3 < 0 || i2 + i3 > iArr.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i4 = 0; i4 < i3; i4++) {
            writeInt(iArr[i2 + i4]);
        }
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void writeLong(long j) throws IOException {
        if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.buff;
            bArr[0] = (byte) (j >> 56);
            bArr[1] = (byte) (j >> 48);
            bArr[2] = (byte) (j >> 40);
            bArr[3] = (byte) (j >> 32);
            bArr[4] = (byte) (j >> 24);
            bArr[5] = (byte) (j >> 16);
            bArr[6] = (byte) (j >> 8);
            bArr[7] = (byte) j;
        } else {
            byte[] bArr2 = this.buff;
            bArr2[7] = (byte) (j >> 56);
            bArr2[6] = (byte) (j >> 48);
            bArr2[5] = (byte) (j >> 40);
            bArr2[4] = (byte) (j >> 32);
            bArr2[3] = (byte) (j >> 24);
            bArr2[2] = (byte) (j >> 16);
            bArr2[1] = (byte) (j >> 8);
            bArr2[0] = (byte) j;
        }
        write(this.buff, 0, 8);
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream
    public void writeLongs(long[] jArr, int i2, int i3) throws IOException {
        if (i2 < 0 || i3 < 0 || i2 + i3 > jArr.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i4 = 0; i4 < i3; i4++) {
            writeLong(jArr[i2 + i4]);
        }
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void writeShort(int i2) throws IOException {
        if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.buff;
            bArr[0] = (byte) (i2 >> 8);
            bArr[1] = (byte) i2;
        } else {
            byte[] bArr2 = this.buff;
            bArr2[1] = (byte) (i2 >> 8);
            bArr2[0] = (byte) i2;
        }
        write(this.buff, 0, 2);
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream
    public void writeShorts(short[] sArr, int i2, int i3) throws IOException {
        if (i2 < 0 || i3 < 0 || i2 + i3 > sArr.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i4 = 0; i4 < i3; i4++) {
            writeShort(sArr[i2 + i4]);
        }
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void writeUTF(String str) throws IOException {
        ByteOrder byteOrder = getByteOrder();
        setByteOrder(ByteOrder.BIG_ENDIAN);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new DataOutputStream(byteArrayOutputStream).writeUTF(str);
        write(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
        setByteOrder(byteOrder);
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream
    public void writeChars(char[] cArr, int i2, int i3) throws IOException {
        if (i2 < 0 || i3 < 0 || i2 + i3 > cArr.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i4 = 0; i4 < i3; i4++) {
            writeShort(cArr[i2 + i4]);
        }
    }
}
