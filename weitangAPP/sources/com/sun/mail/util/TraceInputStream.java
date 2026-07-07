package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes2.dex */
public class TraceInputStream extends FilterInputStream {
    private boolean quote;
    private boolean trace;
    private OutputStream traceOut;

    public TraceInputStream(InputStream inputStream, MailLogger mailLogger) {
        super(inputStream);
        this.trace = false;
        this.quote = false;
        this.trace = mailLogger.isLoggable(Level.FINEST);
        this.traceOut = new LogOutputStream(mailLogger);
    }

    private final void writeByte(int i2) throws IOException {
        int i3 = i2 & 255;
        if (i3 > 127) {
            this.traceOut.write(77);
            this.traceOut.write(45);
            i3 &= 127;
        }
        if (i3 == 13) {
            this.traceOut.write(92);
            this.traceOut.write(114);
            return;
        }
        if (i3 == 10) {
            this.traceOut.write(92);
            this.traceOut.write(110);
            this.traceOut.write(10);
        } else if (i3 == 9) {
            this.traceOut.write(92);
            this.traceOut.write(116);
        } else if (i3 >= 32) {
            this.traceOut.write(i3);
        } else {
            this.traceOut.write(94);
            this.traceOut.write(i3 + 64);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i2 = ((FilterInputStream) this).in.read();
        if (this.trace && i2 != -1) {
            if (this.quote) {
                writeByte(i2);
            } else {
                this.traceOut.write(i2);
            }
        }
        return i2;
    }

    public void setQuote(boolean z) {
        this.quote = z;
    }

    public void setTrace(boolean z) {
        this.trace = z;
    }

    public TraceInputStream(InputStream inputStream, OutputStream outputStream) {
        super(inputStream);
        this.trace = false;
        this.quote = false;
        this.traceOut = outputStream;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = ((FilterInputStream) this).in.read(bArr, i2, i3);
        if (this.trace && i4 != -1) {
            if (this.quote) {
                for (int i5 = 0; i5 < i4; i5++) {
                    writeByte(bArr[i2 + i5]);
                }
            } else {
                this.traceOut.write(bArr, i2, i4);
            }
        }
        return i4;
    }
}
