package com.intelligoo.sdk.utils;

import android.util.SparseArray;
import com.intelligoo.sdk.a.a.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AdRecordUtil {
    private AdRecordUtil() {
    }

    public static String getRecordDataAsString(a aVar) {
        return aVar == null ? "" : new String(aVar.a());
    }

    public static byte[] getServiceData(a aVar) {
        if (aVar == null || aVar.c() != 22) {
            return null;
        }
        byte[] bArrA = aVar.a();
        return Arrays.copyOfRange(bArrA, 2, bArrA.length);
    }

    public static int getServiceDataUuid(a aVar) {
        if (aVar == null || aVar.c() != 22) {
            return -1;
        }
        byte[] bArrA = aVar.a();
        return ((bArrA[1] & 255) << 8) + (bArrA[0] & 255);
    }

    public static List<a> parseScanRecordAsList(byte[] bArr) {
        int intFromByte;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            if (i4 == 0 || (intFromByte = ConvertUtil.getIntFromByte(bArr[i3])) == 0) {
                break;
            }
            int i5 = i3 + 1;
            int i6 = i3 + i4;
            arrayList.add(new a(i4, intFromByte, Arrays.copyOfRange(bArr, i5, i6)));
            i2 = i6;
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static Map<Integer, a> parseScanRecordAsMap(byte[] bArr) {
        int intFromByte;
        HashMap map = new HashMap();
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            if (i4 == 0 || (intFromByte = ConvertUtil.getIntFromByte(bArr[i3])) == 0) {
                break;
            }
            int i5 = i3 + 1;
            int i6 = i3 + i4;
            map.put(Integer.valueOf(intFromByte), new a(i4, intFromByte, Arrays.copyOfRange(bArr, i5, i6)));
            i2 = i6;
        }
        return Collections.unmodifiableMap(map);
    }

    public static SparseArray<a> parseScanRecordAsSparseArray(byte[] bArr) {
        int intFromByte;
        SparseArray<a> sparseArray = new SparseArray<>();
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            if (i4 == 0 || (intFromByte = ConvertUtil.getIntFromByte(bArr[i3])) == 0) {
                break;
            }
            int i5 = i3 + 1;
            int i6 = i3 + i4;
            sparseArray.put(intFromByte, new a(i4, intFromByte, Arrays.copyOfRange(bArr, i5, i6)));
            i2 = i6;
        }
        return sparseArray;
    }
}
