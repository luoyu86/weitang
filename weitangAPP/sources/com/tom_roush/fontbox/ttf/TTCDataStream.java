package com.tom_roush.fontbox.ttf;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class TTCDataStream extends TTFDataStream {
    private final TTFDataStream stream;

    public TTCDataStream(TTFDataStream tTFDataStream) {
        this.stream = tTFDataStream;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // com.tom_roush.fontbox.ttf.TTFDataStream
    public long getCurrentPosition() throws IOException {
        return this.stream.getCurrentPosition();
    }

    @Override // com.tom_roush.fontbox.ttf.TTFDataStream
    public InputStream getOriginalData() throws IOException {
        return this.stream.getOriginalData();
    }

    @Override // com.tom_roush.fontbox.ttf.TTFDataStream
    public long getOriginalDataSize() {
        return this.stream.getOriginalDataSize();
    }

    @Override // com.tom_roush.fontbox.ttf.TTFDataStream
    public int read() throws IOException {
        return this.stream.read();
    }

    @Override // com.tom_roush.fontbox.ttf.TTFDataStream
    public long readLong() throws IOException {
        return this.stream.readLong();
    }

    @Override // com.tom_roush.fontbox.ttf.TTFDataStream
    public short readSignedShort() throws IOException {
        return this.stream.readSignedShort();
    }

    @Override // com.tom_roush.fontbox.ttf.TTFDataStream
    public int readUnsignedShort() throws IOException {
        return this.stream.readUnsignedShort();
    }

    @Override // com.tom_roush.fontbox.ttf.TTFDataStream
    public void seek(long j) throws IOException {
        this.stream.seek(j);
    }

    @Override // com.tom_roush.fontbox.ttf.TTFDataStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        return this.stream.read(bArr, i2, i3);
    }
}
