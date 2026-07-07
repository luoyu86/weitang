package com.sun.mail.smtp;

import com.sun.mail.util.CRLFOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class SMTPOutputStream extends CRLFOutputStream {
    public SMTPOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void ensureAtBOL() throws IOException {
        if (this.atBOL) {
            return;
        }
        super.writeln();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    @Override // com.sun.mail.util.CRLFOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        int i3 = this.lastb;
        if ((i3 == 10 || i3 == 13 || i3 == -1) && i2 == 46) {
            ((FilterOutputStream) this).out.write(46);
        }
        super.write(i2);
    }

    @Override // com.sun.mail.util.CRLFOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.lastb;
        if (i4 == -1) {
            i4 = 10;
        }
        int i5 = i3 + i2;
        int i6 = i4;
        int i7 = i2;
        while (i2 < i5) {
            if ((i6 == 10 || i6 == 13) && bArr[i2] == 46) {
                super.write(bArr, i7, i2 - i7);
                ((FilterOutputStream) this).out.write(46);
                i7 = i2;
            }
            byte b2 = bArr[i2];
            i2++;
            i6 = b2;
        }
        int i8 = i5 - i7;
        if (i8 > 0) {
            super.write(bArr, i7, i8);
        }
    }
}
