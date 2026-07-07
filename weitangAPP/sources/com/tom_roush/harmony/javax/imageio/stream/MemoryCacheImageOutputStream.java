package com.tom_roush.harmony.javax.imageio.stream;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class MemoryCacheImageOutputStream extends ImageOutputStreamImpl {
    public OutputStream os;
    public RandomAccessMemoryCache ramc = new RandomAccessMemoryCache();

    public MemoryCacheImageOutputStream(OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalArgumentException("stream == null!");
        }
        this.os = outputStream;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStreamImpl, com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public void close() throws IOException {
        long length = length();
        seek(length);
        flushBefore(length);
        super.close();
        this.ramc.close();
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStreamImpl, com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public void flushBefore(long j) throws IOException {
        long flushedPosition = getFlushedPosition();
        super.flushBefore(j);
        long flushedPosition2 = getFlushedPosition();
        this.ramc.getData(this.os, (int) (flushedPosition2 - flushedPosition), flushedPosition);
        this.ramc.freeBefore(flushedPosition2);
        this.os.flush();
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStreamImpl, com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public boolean isCached() {
        return true;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStreamImpl, com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public boolean isCachedFile() {
        return false;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStreamImpl, com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public boolean isCachedMemory() {
        return true;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStreamImpl, com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public long length() {
        return this.ramc.length();
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStreamImpl, com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public int read() throws IOException {
        this.bitOffset = 0;
        int data = this.ramc.getData(this.streamPos);
        if (data >= 0) {
            this.streamPos++;
        }
        return data;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStreamImpl, com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void write(int i2) throws IOException {
        flushBits();
        this.ramc.putData(i2, this.streamPos);
        this.streamPos++;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStreamImpl, com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        this.bitOffset = 0;
        int data = this.ramc.getData(bArr, i2, i3, this.streamPos);
        if (data > 0) {
            this.streamPos += (long) data;
        }
        return data;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageOutputStreamImpl, com.tom_roush.harmony.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        flushBits();
        this.ramc.putData(bArr, i2, i3, this.streamPos);
        this.streamPos += (long) i3;
    }
}
