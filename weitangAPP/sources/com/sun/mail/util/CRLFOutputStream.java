package com.sun.mail.util;

import com.tom_roush.pdfbox.pdfparser.BaseParser;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class CRLFOutputStream extends FilterOutputStream {
    private static final byte[] newline = {BaseParser.ASCII_CR, 10};
    public boolean atBOL;
    public int lastb;

    public CRLFOutputStream(OutputStream outputStream) {
        super(outputStream);
        this.lastb = -1;
        this.atBOL = true;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        if (i2 == 13) {
            writeln();
        } else if (i2 != 10) {
            ((FilterOutputStream) this).out.write(i2);
            this.atBOL = false;
        } else if (this.lastb != 13) {
            writeln();
        }
        this.lastb = i2;
    }

    public void writeln() throws IOException {
        ((FilterOutputStream) this).out.write(newline);
        this.atBOL = true;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = i3 + i2;
        int i5 = i2;
        while (i2 < i4) {
            if (bArr[i2] == 13) {
                ((FilterOutputStream) this).out.write(bArr, i5, i2 - i5);
                writeln();
            } else if (bArr[i2] == 10) {
                if (this.lastb != 13) {
                    ((FilterOutputStream) this).out.write(bArr, i5, i2 - i5);
                    writeln();
                }
            } else {
                this.lastb = bArr[i2];
                i2++;
            }
            i5 = i2 + 1;
            this.lastb = bArr[i2];
            i2++;
        }
        int i6 = i4 - i5;
        if (i6 > 0) {
            ((FilterOutputStream) this).out.write(bArr, i5, i6);
            this.atBOL = false;
        }
    }
}
