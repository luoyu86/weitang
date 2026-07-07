package com.tom_roush.harmony.javax.imageio.stream;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class MemoryCacheImageInputStream extends ImageInputStreamImpl {
    private InputStream is;
    private RandomAccessMemoryCache ramc = new RandomAccessMemoryCache();

    public MemoryCacheImageInputStream(InputStream inputStream) {
        if (inputStream == null) {
            throw new IllegalArgumentException("stream == null!");
        }
        this.is = inputStream;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStreamImpl, com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public void close() throws IOException {
        super.close();
        this.ramc.close();
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStreamImpl, com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public void flushBefore(long j) throws IOException {
        super.flushBefore(j);
        this.ramc.freeBefore(getFlushedPosition());
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
    public int read() throws IOException {
        this.bitOffset = 0;
        if (this.streamPos >= this.ramc.length()) {
            int length = (int) ((this.streamPos - this.ramc.length()) + 1);
            if (this.ramc.appendData(this.is, length) < length) {
                return -1;
            }
        }
        int data = this.ramc.getData(this.streamPos);
        if (data >= 0) {
            this.streamPos++;
        }
        return data;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStreamImpl, com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        this.bitOffset = 0;
        if (this.streamPos >= this.ramc.length()) {
            this.ramc.appendData(this.is, (int) ((this.streamPos - this.ramc.length()) + ((long) i3)));
        }
        int data = this.ramc.getData(bArr, i2, i3, this.streamPos);
        if (data > 0) {
            this.streamPos += (long) data;
        }
        return data;
    }
}
