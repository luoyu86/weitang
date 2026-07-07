package com.taobao.accs.utl;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class h extends ByteArrayInputStream {
    public h(byte[] bArr) {
        super(bArr);
    }

    public int a() {
        return read() & 255;
    }

    public int b() {
        return (a() << 8) | a();
    }

    public byte[] c() throws IOException {
        byte[] bArr = new byte[available()];
        read(bArr);
        return bArr;
    }

    public String a(int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = read(bArr);
        if (i3 == i2) {
            return new String(bArr, "utf-8");
        }
        throw new IOException("read len not match. ask for " + i2 + " but read for " + i3);
    }
}
