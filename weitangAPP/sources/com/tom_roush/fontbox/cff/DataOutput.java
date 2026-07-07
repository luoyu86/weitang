package com.tom_roush.fontbox.cff;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class DataOutput {
    private ByteArrayOutputStream outputBuffer;
    private String outputEncoding;

    public DataOutput() {
        this("ISO-8859-1");
    }

    public byte[] getBytes() {
        return this.outputBuffer.toByteArray();
    }

    public void print(String str) throws IOException {
        write(str.getBytes(this.outputEncoding));
    }

    public void println(String str) throws IOException {
        write(str.getBytes(this.outputEncoding));
        write(10);
    }

    public void write(int i2) {
        this.outputBuffer.write(i2);
    }

    public DataOutput(String str) {
        this.outputBuffer = new ByteArrayOutputStream();
        this.outputEncoding = null;
        this.outputEncoding = str;
    }

    public void write(byte[] bArr) {
        this.outputBuffer.write(bArr, 0, bArr.length);
    }

    public void println() {
        write(10);
    }

    public void write(byte[] bArr, int i2, int i3) {
        this.outputBuffer.write(bArr, i2, i3);
    }
}
