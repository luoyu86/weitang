package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes2.dex */
public class TraceOutputStream extends FilterOutputStream {
    private boolean quote;
    private boolean trace;
    private OutputStream traceOut;

    public TraceOutputStream(OutputStream outputStream, MailLogger mailLogger) {
        super(outputStream);
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

    public void setQuote(boolean z) {
        this.quote = z;
    }

    public void setTrace(boolean z) {
        this.trace = z;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        if (this.trace) {
            if (this.quote) {
                writeByte(i2);
            } else {
                this.traceOut.write(i2);
            }
        }
        ((FilterOutputStream) this).out.write(i2);
    }

    public TraceOutputStream(OutputStream outputStream, OutputStream outputStream2) {
        super(outputStream);
        this.trace = false;
        this.quote = false;
        this.traceOut = outputStream2;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        if (this.trace) {
            if (this.quote) {
                for (int i4 = 0; i4 < i3; i4++) {
                    writeByte(bArr[i2 + i4]);
                }
            } else {
                this.traceOut.write(bArr, i2, i3);
            }
        }
        ((FilterOutputStream) this).out.write(bArr, i2, i3);
    }
}
