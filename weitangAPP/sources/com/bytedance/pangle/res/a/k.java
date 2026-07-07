package com.bytedance.pangle.res.a;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class k {
    public static int a(g gVar) {
        return (int) gVar.f6223a.a().b();
    }

    private static byte[] a(int i2) {
        return new byte[]{(byte) (i2 >> 0), (byte) (i2 >> 8), (byte) (i2 >> 16), (byte) (i2 >> 24)};
    }

    public static int a(byte[] bArr, int i2, int i3, h hVar) {
        if (i2 < 2130706432) {
            return i2;
        }
        int iA = hVar.a(i2);
        byte[] bArrA = a(iA);
        bArr[i3] = bArrA[0];
        bArr[i3 + 1] = bArrA[1];
        bArr[i3 + 2] = bArrA[2];
        bArr[i3 + 3] = bArrA[3];
        return iA;
    }

    public static void a(byte[] bArr, h hVar) {
        b bVar = new b(bArr, hVar);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        bVar.a();
        bVar.f6206c = new g(new i(new e(byteArrayInputStream)));
        while (bVar.b() != 1) {
        }
    }

    public static void a(int i2, byte[] bArr, int[] iArr, int i3, HashMap<Integer, Integer> map) {
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        int i4 = -1;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = i5 * 5;
            int i7 = iArr[i6 + 1];
            if (map.containsKey(Integer.valueOf(i7))) {
                if (i4 == -1) {
                    i4 = i5;
                }
                int i8 = (i6 * 4) + i2;
                map2.put(Integer.valueOf(i5), Arrays.copyOfRange(bArr, i8, i8 + 20));
                map3.put(Integer.valueOf(map.get(Integer.valueOf(i7)).intValue()), Integer.valueOf(i5));
            }
        }
        ArrayList arrayList = new ArrayList(map3.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        int i9 = 0;
        while (it.hasNext()) {
            byte[] bArr2 = (byte[]) map2.get(Integer.valueOf(((Integer) map3.get((Integer) it.next())).intValue()));
            System.arraycopy(bArr2, 0, bArr, ((i9 + i4) * 5 * 4) + i2, bArr2.length);
            i9++;
        }
    }
}
