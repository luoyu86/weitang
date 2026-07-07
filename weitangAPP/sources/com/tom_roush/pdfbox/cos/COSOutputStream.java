package com.tom_roush.pdfbox.cos;

import com.tom_roush.pdfbox.filter.Filter;
import com.tom_roush.pdfbox.io.RandomAccess;
import com.tom_roush.pdfbox.io.RandomAccessInputStream;
import com.tom_roush.pdfbox.io.RandomAccessOutputStream;
import com.tom_roush.pdfbox.io.ScratchFile;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class COSOutputStream extends FilterOutputStream {
    private RandomAccess buffer;
    private final List<Filter> filters;
    private final COSDictionary parameters;
    private final ScratchFile scratchFile;

    public COSOutputStream(List<Filter> list, COSDictionary cOSDictionary, OutputStream outputStream, ScratchFile scratchFile) throws IOException {
        super(outputStream);
        this.filters = list;
        this.parameters = cOSDictionary;
        this.scratchFile = scratchFile;
        if (list.isEmpty()) {
            this.buffer = null;
        } else {
            this.buffer = scratchFile.createBuffer();
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        RandomAccessOutputStream randomAccessOutputStream;
        try {
            if (this.buffer != null) {
                try {
                    for (int size = this.filters.size() - 1; size >= 0; size--) {
                        RandomAccessInputStream randomAccessInputStream = new RandomAccessInputStream(this.buffer);
                        if (size == 0) {
                            try {
                                this.filters.get(size).encode(randomAccessInputStream, ((FilterOutputStream) this).out, this.parameters, size);
                            } finally {
                                randomAccessInputStream.close();
                            }
                        } else {
                            RandomAccess randomAccessCreateBuffer = this.scratchFile.createBuffer();
                            try {
                                randomAccessOutputStream = new RandomAccessOutputStream(randomAccessCreateBuffer);
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                                this.filters.get(size).encode(randomAccessInputStream, randomAccessOutputStream, this.parameters, size);
                                randomAccessOutputStream.close();
                                RandomAccess randomAccess = this.buffer;
                                try {
                                    this.buffer = randomAccessCreateBuffer;
                                    randomAccess.close();
                                } catch (Throwable th2) {
                                    th = th2;
                                    randomAccessCreateBuffer = randomAccess;
                                    randomAccessCreateBuffer.close();
                                    throw th;
                                }
                            } finally {
                            }
                        }
                    }
                    this.buffer.close();
                    this.buffer = null;
                } catch (Throwable th3) {
                    this.buffer.close();
                    this.buffer = null;
                    throw th3;
                }
            }
        } finally {
            super.close();
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.buffer == null) {
            super.flush();
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        RandomAccess randomAccess = this.buffer;
        if (randomAccess != null) {
            randomAccess.write(bArr);
        } else {
            super.write(bArr);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        RandomAccess randomAccess = this.buffer;
        if (randomAccess != null) {
            randomAccess.write(bArr, i2, i3);
        } else {
            super.write(bArr, i2, i3);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        RandomAccess randomAccess = this.buffer;
        if (randomAccess != null) {
            randomAccess.write(i2);
        } else {
            super.write(i2);
        }
    }
}
