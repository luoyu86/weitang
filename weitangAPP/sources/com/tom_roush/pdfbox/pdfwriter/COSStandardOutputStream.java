package com.tom_roush.pdfbox.pdfwriter;

import com.tom_roush.pdfbox.pdfparser.BaseParser;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class COSStandardOutputStream extends FilterOutputStream {
    private boolean onNewLine;
    private long position;
    public static final byte[] CRLF = {BaseParser.ASCII_CR, 10};
    public static final byte[] LF = {10};
    public static final byte[] EOL = {10};

    public COSStandardOutputStream(OutputStream outputStream) {
        super(outputStream);
        this.position = 0L;
        this.onNewLine = false;
    }

    public long getPos() {
        return this.position;
    }

    public boolean isOnNewLine() {
        return this.onNewLine;
    }

    public void setOnNewLine(boolean z) {
        this.onNewLine = z;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        setOnNewLine(false);
        ((FilterOutputStream) this).out.write(bArr, i2, i3);
        this.position += (long) i3;
    }

    public void writeCRLF() throws IOException {
        write(CRLF);
    }

    public void writeEOL() throws IOException {
        if (isOnNewLine()) {
            return;
        }
        write(EOL);
        setOnNewLine(true);
    }

    public void writeLF() throws IOException {
        write(LF);
    }

    @Deprecated
    public COSStandardOutputStream(OutputStream outputStream, int i2) {
        super(outputStream);
        this.position = 0L;
        this.onNewLine = false;
        this.position = i2;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        setOnNewLine(false);
        ((FilterOutputStream) this).out.write(i2);
        this.position++;
    }

    public COSStandardOutputStream(OutputStream outputStream, long j) {
        super(outputStream);
        this.position = 0L;
        this.onNewLine = false;
        this.position = j;
    }
}
