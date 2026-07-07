package com.bytedance.pangle.util.b.a;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.pangle.util.b.b.d;
import com.tom_roush.pdfbox.pdmodel.common.PDPageLabelRange;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static d a(String str) throws Throwable {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(str, PDPageLabelRange.STYLE_ROMAN_LOWER);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (randomAccessFile.length() < 22) {
                throw new IOException("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
            }
            d dVar = new d(str);
            long length = randomAccessFile.length();
            if (length < 22) {
                throw new IOException("Zip file size less than size of zip headers. Probably not a zip file.");
            }
            long jB = length - 22;
            randomAccessFile.seek(jB);
            if (dVar.f6280c.a(randomAccessFile) != 101010256) {
                jB = b(randomAccessFile, dVar);
            }
            randomAccessFile.seek(jB + 4);
            com.bytedance.pangle.util.b.b.b bVar = new com.bytedance.pangle.util.b.b.b();
            randomAccessFile.skipBytes(6);
            bVar.f6267a = dVar.f6280c.b(randomAccessFile);
            randomAccessFile.skipBytes(4);
            bVar.f6268b = dVar.f6280c.a(randomAccessFile);
            dVar.f6279b = bVar;
            if (bVar.f6267a == 0) {
                try {
                    randomAccessFile.close();
                } catch (IOException unused) {
                }
                return dVar;
            }
            a(randomAccessFile, dVar);
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
            return dVar;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    private static long b(RandomAccessFile randomAccessFile, d dVar) throws IOException {
        long length = randomAccessFile.length() - 22;
        long length2 = randomAccessFile.length();
        long length3 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        if (length2 < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
            length3 = randomAccessFile.length();
        }
        while (length3 > 0 && length > 0) {
            length--;
            randomAccessFile.seek(length);
            if (dVar.f6280c.a(randomAccessFile) == 101010256) {
                return length;
            }
            length3--;
        }
        throw new IOException("Zip headers not found. Probably not a zip file");
    }

    private static void a(RandomAccessFile randomAccessFile, d dVar) throws IOException {
        com.bytedance.pangle.util.b.b.a aVar = new com.bytedance.pangle.util.b.b.a();
        ArrayList arrayList = new ArrayList();
        com.bytedance.pangle.util.b.b.b bVar = dVar.f6279b;
        long j = bVar.f6268b;
        long j2 = bVar.f6267a;
        randomAccessFile.seek(j);
        for (int i2 = 0; i2 < j2; i2++) {
            com.bytedance.pangle.util.b.b.c cVar = new com.bytedance.pangle.util.b.b.c();
            if (dVar.f6280c.a(randomAccessFile) == 33639248) {
                randomAccessFile.skipBytes(6);
                cVar.f6269a = dVar.f6280c.b(randomAccessFile);
                randomAccessFile.skipBytes(4);
                cVar.f6270b = dVar.f6280c.a(randomAccessFile);
                cVar.f6271c = dVar.f6280c.a(randomAccessFile);
                cVar.f6272d = dVar.f6280c.a(randomAccessFile);
                int iB = dVar.f6280c.b(randomAccessFile);
                cVar.f6273e = iB;
                cVar.f6274f = dVar.f6280c.b(randomAccessFile);
                int iB2 = dVar.f6280c.b(randomAccessFile);
                randomAccessFile.skipBytes(8);
                cVar.f6277i = dVar.f6280c.a(randomAccessFile);
                if (iB > 0) {
                    byte[] bArr = new byte[iB];
                    randomAccessFile.readFully(bArr);
                    cVar.f6276h = new String(bArr, Charset.forName("UTF-8"));
                    randomAccessFile.skipBytes(cVar.f6274f);
                    if (iB2 > 0) {
                        randomAccessFile.skipBytes(iB2);
                    }
                    long filePointer = randomAccessFile.getFilePointer();
                    randomAccessFile.seek(cVar.f6277i + 28);
                    cVar.f6275g = dVar.f6280c.b(randomAccessFile);
                    randomAccessFile.seek(filePointer);
                    arrayList.add(cVar);
                } else {
                    throw new IOException("Invalid entry name in file header");
                }
            } else {
                throw new IOException("Expected central directory entry not found (#" + (i2 + 1) + ")");
            }
        }
        aVar.f6266a = arrayList;
        dVar.f6278a = aVar;
    }
}
