package com.bytedance.pangle.res.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class g extends f {
    public g(i iVar) {
        super(iVar);
    }

    public final int[] a(int i2) {
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = readInt();
        }
        return iArr;
    }

    public final void b() throws IOException {
        byte b2 = readByte();
        if (b2 != 0) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", (byte) 0, Byte.valueOf(b2)));
        }
    }

    @Override // com.bytedance.pangle.res.a.f, java.io.DataInput
    public final int skipBytes(int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int iSkipBytes = super.skipBytes(i2 - i3);
            if (iSkipBytes <= 0) {
                break;
            }
            i3 += iSkipBytes;
        }
        return i3;
    }

    public final void a() throws IOException {
        short s = readShort();
        if (s != 8) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", (short) 8, Short.valueOf(s)));
        }
    }

    public final void b(int i2) throws IOException {
        int i3;
        while (true) {
            i3 = readInt();
            if (i3 != i2 && i3 >= 1835009) {
                break;
            } else {
                i2 = -1;
            }
        }
        if (i3 != 1835009) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", 1835009, Integer.valueOf(i3)));
        }
    }
}
