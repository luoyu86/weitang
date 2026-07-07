package com.tom_roush.fontbox.ttf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes2.dex */
public class MemoryTTFDataStream extends TTFDataStream {
    private int currentPosition = 0;
    private byte[] data;

    public MemoryTTFDataStream(InputStream inputStream) throws IOException {
        this.data = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    this.data = byteArrayOutputStream.toByteArray();
                    return;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
        } finally {
            inputStream.close();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // com.tom_roush.fontbox.ttf.TTFDataStream
    public long getCurrentPosition() throws IOException {
        return this.currentPosition;
    }

    @Override // com.tom_roush.fontbox.ttf.TTFDataStream
    public InputStream getOriginalData() throws IOException {
        return new ByteArrayInputStream(this.data);
    }

    @Override // com.tom_roush.fontbox.ttf.TTFDataStream
    public long getOriginalDataSize() {
        return this.data.length;
    }

    @Override // com.tom_roush.fontbox.ttf.TTFDataStream
    public int read() throws IOException {
        int i2 = this.currentPosition;
        byte[] bArr = this.data;
        if (i2 >= bArr.length) {
            return -1;
        }
        byte b2 = bArr[i2];
        this.currentPosition = i2 + 1;
        return (b2 + 256) % 256;
    }

    @Override // com.tom_roush.fontbox.ttf.TTFDataStream
    public long readLong() throws IOException {
        return (((long) readSignedInt()) << 32) + (((long) readSignedInt()) & UIDFolder.MAXUID);
    }

    public int readSignedInt() throws IOException {
        int i2 = read();
        int i3 = read();
        int i4 = read();
        int i5 = read();
        if ((i2 | i3 | i4 | i5) >= 0) {
            return (i2 << 24) + (i3 << 16) + (i4 << 8) + i5;
        }
        throw new EOFException();
    }

    @Override // com.tom_roush.fontbox.ttf.TTFDataStream
    public short readSignedShort() throws IOException {
        int i2 = read();
        int i3 = read();
        if ((i2 | i3) >= 0) {
            return (short) ((i2 << 8) + i3);
        }
        throw new EOFException();
    }

    @Override // com.tom_roush.fontbox.ttf.TTFDataStream
    public int readUnsignedShort() throws IOException {
        int i2 = read();
        int i3 = read();
        if ((i2 | i3) >= 0) {
            return (i2 << 8) + i3;
        }
        throw new EOFException();
    }

    @Override // com.tom_roush.fontbox.ttf.TTFDataStream
    public void seek(long j) throws IOException {
        if (j >= 0 && j <= 2147483647L) {
            this.currentPosition = (int) j;
            return;
        }
        throw new IOException("Illegal seek position: " + j);
    }

    @Override // com.tom_roush.fontbox.ttf.TTFDataStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.currentPosition;
        byte[] bArr2 = this.data;
        if (i4 >= bArr2.length) {
            return -1;
        }
        int iMin = Math.min(i3, bArr2.length - i4);
        System.arraycopy(this.data, this.currentPosition, bArr, i2, iMin);
        this.currentPosition += iMin;
        return iMin;
    }
}
