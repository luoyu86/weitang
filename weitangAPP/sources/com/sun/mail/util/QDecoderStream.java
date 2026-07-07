package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class QDecoderStream extends QPDecoderStream {
    public QDecoderStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // com.sun.mail.util.QPDecoderStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i2 = ((FilterInputStream) this).in.read();
        if (i2 == 95) {
            return 32;
        }
        if (i2 != 61) {
            return i2;
        }
        this.ba[0] = (byte) ((FilterInputStream) this).in.read();
        this.ba[1] = (byte) ((FilterInputStream) this).in.read();
        try {
            return ASCIIUtility.parseInt(this.ba, 0, 2, 16);
        } catch (NumberFormatException e2) {
            throw new DecodingException("QDecoder: Error in QP stream " + e2.getMessage());
        }
    }
}
