package com.bytedance.pangle.util.b.a;

import com.bytedance.pangle.util.b.b.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static void a(d dVar, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        List<com.bytedance.pangle.util.b.b.c> list;
        com.bytedance.pangle.util.b.b.a aVar = dVar.f6278a;
        if (aVar == null || (list = aVar.f6266a) == null || list.size() <= 0) {
            return;
        }
        for (com.bytedance.pangle.util.b.b.c cVar : dVar.f6278a.f6266a) {
            c cVar2 = dVar.f6280c;
            if (cVar == null) {
                throw new IOException("input parameters is null, cannot write local file header");
            }
            byte[] bArr = {0, 0};
            cVar2.a((OutputStream) byteArrayOutputStream, 33639248);
            cVar2.a(byteArrayOutputStream, 0);
            cVar2.a(byteArrayOutputStream, 0);
            cVar2.a(byteArrayOutputStream, 0);
            cVar2.a(byteArrayOutputStream, cVar.f6269a);
            cVar2.a(byteArrayOutputStream, 2081);
            cVar2.a(byteArrayOutputStream, 545);
            cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.f6270b);
            cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.f6271c);
            cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.f6272d);
            byte[] bytes = new byte[0];
            String str = cVar.f6276h;
            if (str != null && str.trim().length() > 0) {
                bytes = cVar.f6276h.getBytes(Charset.forName("UTF-8"));
            }
            cVar2.a(byteArrayOutputStream, bytes.length);
            int i2 = cVar.f6274f;
            cVar2.a(byteArrayOutputStream, i2);
            cVar2.a(byteArrayOutputStream, 0);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.f6277i);
            if (bytes.length > 0) {
                byteArrayOutputStream.write(bytes);
            }
            if (i2 > 0) {
                byteArrayOutputStream.write(new byte[i2]);
            }
        }
    }
}
