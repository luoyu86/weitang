package org.apache.commons.codec.binary;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import org.apache.commons.codec.binary.BaseNCodec;

/* JADX INFO: loaded from: classes2.dex */
public class BaseNCodecInputStream extends FilterInputStream {
    private final BaseNCodec baseNCodec;
    private final BaseNCodec.Context context;
    private final boolean doEncode;
    private final byte[] singleByte;

    public BaseNCodecInputStream(InputStream inputStream, BaseNCodec baseNCodec, boolean z) {
        super(inputStream);
        this.singleByte = new byte[1];
        this.context = new BaseNCodec.Context();
        this.doEncode = z;
        this.baseNCodec = baseNCodec;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return !this.context.eof ? 1 : 0;
    }

    public boolean isStrictDecoding() {
        return this.baseNCodec.isStrictDecoding();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i2 = read(this.singleByte, 0, 1);
        while (i2 == 0) {
            i2 = read(this.singleByte, 0, 1);
        }
        if (i2 <= 0) {
            return -1;
        }
        byte b2 = this.singleByte[0];
        return b2 < 0 ? b2 + 256 : b2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        int i2;
        if (j < 0) {
            throw new IllegalArgumentException("Negative skip length: " + j);
        }
        byte[] bArr = new byte[512];
        long j2 = j;
        while (j2 > 0 && (i2 = read(bArr, 0, (int) Math.min(512, j2))) != -1) {
            j2 -= (long) i2;
        }
        return j - j2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        Objects.requireNonNull(bArr, "array");
        if (i2 >= 0 && i3 >= 0) {
            if (i2 > bArr.length || i2 + i3 > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            if (i3 == 0) {
                return 0;
            }
            int results = 0;
            while (results == 0) {
                if (!this.baseNCodec.hasData(this.context)) {
                    byte[] bArr2 = new byte[this.doEncode ? 4096 : 8192];
                    int i4 = ((FilterInputStream) this).in.read(bArr2);
                    if (this.doEncode) {
                        this.baseNCodec.encode(bArr2, 0, i4, this.context);
                    } else {
                        this.baseNCodec.decode(bArr2, 0, i4, this.context);
                    }
                }
                results = this.baseNCodec.readResults(bArr, i2, i3, this.context);
            }
            return results;
        }
        throw new IndexOutOfBoundsException();
    }
}
