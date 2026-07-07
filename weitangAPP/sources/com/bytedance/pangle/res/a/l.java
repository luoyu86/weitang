package com.bytedance.pangle.res.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    public static void a(g gVar) throws IOException {
        gVar.b(0);
        int i2 = gVar.readInt();
        int i3 = gVar.readInt();
        int i4 = gVar.readInt();
        gVar.skipBytes(4);
        int i5 = gVar.readInt();
        int i6 = gVar.readInt();
        gVar.skipBytes(i3 * 4);
        if (i4 != 0) {
            gVar.skipBytes(i4 * 4);
        }
        gVar.skipBytes((i6 == 0 ? i2 : i6) - i5);
        if (i6 == 0) {
            return;
        }
        int i7 = i2 - i6;
        gVar.skipBytes(i7);
        int i8 = i7 % 4;
        if (i8 <= 0) {
            return;
        }
        while (true) {
            int i9 = i8 - 1;
            if (i8 <= 0) {
                return;
            }
            gVar.readByte();
            i8 = i9;
        }
    }
}
