package com.tom_roush.pdfbox.io;

import android.util.Log;
import androidx.appcompat.widget.ActivityChooserView;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class RandomAccessInputStream extends InputStream {
    private final RandomAccessRead input;
    private long position = 0;

    public RandomAccessInputStream(RandomAccessRead randomAccessRead) {
        this.input = randomAccessRead;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        restorePosition();
        long length = this.input.length() - this.input.getPosition();
        return length > 2147483647L ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) length;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        restorePosition();
        if (this.input.isEOF()) {
            return -1;
        }
        int i2 = this.input.read();
        if (i2 != -1) {
            this.position++;
        } else {
            Log.e("PdfBox-Android", "read() returns -1, assumed position: " + this.position + ", actual position: " + this.input.getPosition());
        }
        return i2;
    }

    public void restorePosition() throws IOException {
        this.input.seek(this.position);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        restorePosition();
        this.input.seek(this.position + j);
        this.position += j;
        return j;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        restorePosition();
        if (this.input.isEOF()) {
            return -1;
        }
        int i4 = this.input.read(bArr, i2, i3);
        if (i4 != -1) {
            this.position += (long) i4;
        } else {
            Log.e("PdfBox-Android", "read() returns -1, assumed position: " + this.position + ", actual position: " + this.input.getPosition());
        }
        return i4;
    }
}
