package com.tom_roush.pdfbox.pdfparser;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class EndstreamOutputStream extends BufferedOutputStream {
    private boolean hasCR;
    private boolean hasLF;
    private boolean mustFilter;
    private int pos;

    public EndstreamOutputStream(OutputStream outputStream) {
        super(outputStream);
        this.hasCR = false;
        this.hasLF = false;
        this.pos = 0;
        this.mustFilter = true;
    }

    @Override // java.io.BufferedOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.hasCR && !this.hasLF) {
            super.write(13);
            this.pos++;
        }
        this.hasCR = false;
        this.hasLF = false;
        super.flush();
    }

    @Override // java.io.BufferedOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i2, int i3) throws IOException {
        if (this.pos == 0 && i3 > 10) {
            this.mustFilter = false;
            for (int i4 = 0; i4 < 10; i4++) {
                if (bArr[i4] >= 9 && (bArr[i4] <= 10 || bArr[i4] >= 32 || bArr[i4] == 13)) {
                }
                this.mustFilter = true;
                break;
            }
        }
        if (this.mustFilter) {
            if (this.hasCR) {
                this.hasCR = false;
                if (!this.hasLF && i3 == 1 && bArr[i2] == 10) {
                    return;
                } else {
                    super.write(13);
                }
            }
            if (this.hasLF) {
                super.write(10);
                this.hasLF = false;
            }
            if (i3 > 0) {
                int i5 = (i2 + i3) - 1;
                if (bArr[i5] == 13) {
                    this.hasCR = true;
                } else if (bArr[i5] == 10) {
                    this.hasLF = true;
                    i3--;
                    if (i3 > 0 && bArr[(i2 + i3) - 1] == 13) {
                        this.hasCR = true;
                    }
                }
                i3--;
            }
        }
        super.write(bArr, i2, i3);
        this.pos += i3;
    }
}
