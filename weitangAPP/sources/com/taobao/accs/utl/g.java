package com.taobao.accs.utl;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class g extends ByteArrayOutputStream {
    public g(int i2) {
        super(i2);
    }

    public g a(byte b2) {
        write(b2);
        return this;
    }

    public g() {
    }

    public g a(short s) {
        write(s >> 8);
        write(s);
        return this;
    }
}
