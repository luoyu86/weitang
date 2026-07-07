package com.sun.mail.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes2.dex */
public class LogOutputStream extends OutputStream {
    public MailLogger logger;
    private int lastb = -1;
    private byte[] buf = new byte[80];
    private int pos = 0;
    public Level level = Level.FINEST;

    public LogOutputStream(MailLogger mailLogger) {
        this.logger = mailLogger;
    }

    private void expandCapacity(int i2) {
        while (true) {
            int i3 = this.pos;
            int i4 = i3 + i2;
            byte[] bArr = this.buf;
            if (i4 <= bArr.length) {
                return;
            }
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, i3);
            this.buf = bArr2;
        }
    }

    private void logBuf() {
        String str = new String(this.buf, 0, this.pos);
        this.pos = 0;
        log(str);
    }

    public void log(String str) {
        this.logger.log(this.level, str);
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        if (this.logger.isLoggable(this.level)) {
            if (i2 == 13) {
                logBuf();
            } else if (i2 != 10) {
                expandCapacity(1);
                byte[] bArr = this.buf;
                int i3 = this.pos;
                this.pos = i3 + 1;
                bArr[i3] = (byte) i2;
            } else if (this.lastb != 13) {
                logBuf();
            }
            this.lastb = i2;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        if (this.logger.isLoggable(this.level)) {
            int i4 = i3 + i2;
            int i5 = i2;
            while (i2 < i4) {
                if (bArr[i2] == 13) {
                    int i6 = i2 - i5;
                    expandCapacity(i6);
                    System.arraycopy(bArr, i5, this.buf, this.pos, i6);
                    this.pos += i6;
                    logBuf();
                } else if (bArr[i2] == 10) {
                    if (this.lastb != 13) {
                        int i7 = i2 - i5;
                        expandCapacity(i7);
                        System.arraycopy(bArr, i5, this.buf, this.pos, i7);
                        this.pos += i7;
                        logBuf();
                    }
                } else {
                    this.lastb = bArr[i2];
                    i2++;
                }
                i5 = i2 + 1;
                this.lastb = bArr[i2];
                i2++;
            }
            int i8 = i4 - i5;
            if (i8 > 0) {
                expandCapacity(i8);
                System.arraycopy(bArr, i5, this.buf, this.pos, i8);
                this.pos += i8;
            }
        }
    }
}
