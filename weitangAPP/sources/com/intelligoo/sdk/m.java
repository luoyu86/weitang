package com.intelligoo.sdk;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.intelligoo.sdk.utils.BleLog;
import com.vivo.identifier.IdentifierConstant;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static com.intelligoo.sdk.a.b f9280b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f9281c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f9282d = 600;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f9283e = 600;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static BluetoothManager f9284f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static BluetoothAdapter f9285g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static ScanCallback f9286h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static ScanCallBackSort f9287i;
    private static ScanCallBackSort j;
    private static ScanCallBackSort k;
    private static ScanCallBackSortWithElectricity l;
    private static ArrayList<String> p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static ArrayList<Integer> f9288q;
    private static Map<String, List<Integer>> m = new HashMap();
    private static Map<String, List<Integer>> n = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ArrayList<String> f9279a = new ArrayList<>();
    private static com.intelligoo.sdk.b.a.a o = new com.intelligoo.sdk.b.a.a() { // from class: com.intelligoo.sdk.m.1
        @Override // com.intelligoo.sdk.b.a.a
        public void a() {
            BleLog.i("scan timeout");
            m.b((Map<String, List<Integer>>) m.m);
            if (m.f9286h != null) {
                m.f9286h.onScanResult((ArrayList) m.p.clone(), (ArrayList) m.f9288q.clone());
                ScanCallback unused = m.f9286h = null;
            }
            ArrayList<Map<String, Integer>> arrayListB = m.b((ArrayList<String>) m.p, (ArrayList<Integer>) m.f9288q);
            if (m.f9287i != null) {
                m.f9287i.onScanResult(arrayListB);
                ScanCallBackSort unused2 = m.f9287i = null;
            }
            if (m.j != null) {
                m.j.onScanResult(arrayListB);
                ScanCallBackSort unused3 = m.j = null;
            }
            if (m.f9280b == com.intelligoo.sdk.a.b.NONFILTERSCAN && m.k != null) {
                m.b((Map<String, List<Integer>>) m.n);
                m.k.onScanResult(m.b((ArrayList<String>) m.p, (ArrayList<Integer>) m.f9288q));
                ScanCallBackSort unused4 = m.k = null;
            }
            if (m.l != null) {
                l.a("扫描设备并且获取电量");
                m.l.onScanResult(m.b(arrayListB));
                ScanCallBackSortWithElectricity unused5 = m.l = null;
            }
        }

        @Override // com.intelligoo.sdk.b.a.a
        public void a(com.intelligoo.sdk.a.a aVar) {
            String strC = aVar.c();
            if (strC == null || strC.length() == 0) {
                return;
            }
            int iD = aVar.d();
            if (m.f9280b == com.intelligoo.sdk.a.b.NONFILTERSCAN) {
                m.d(strC, iD);
                if (m.k != null) {
                    m.k.onScanResultAtOnce(strC, iD);
                }
            }
            String strB = m.b(strC);
            if (strB == null || strB.length() == 0) {
                return;
            }
            if (m.f9286h != null) {
                m.f9286h.onScanResultAtOnce(strB, iD);
            }
            if (m.f9287i != null) {
                m.f9287i.onScanResultAtOnce(strB, iD);
            }
            if (m.j != null) {
                m.j.onScanResultAtOnce(strB, iD);
            }
            if (!m.f9279a.contains(strB)) {
                m.f9279a.add(strB);
            }
            m.c(strB, iD);
        }
    };

    private static int a(int i2) {
        return p.a().a(i2).a(o);
    }

    public static int a(Context context, int i2, ScanCallBackSort scanCallBackSort) {
        f9280b = com.intelligoo.sdk.a.b.ORDEREDSCANBG;
        if (!a(context)) {
            return -100;
        }
        p.a().a(context.getApplicationContext());
        if ((i2 < 0 && i2 != -1) || i2 > 60000) {
            return ConstantsUtils.SET_RESULT_ERROR_SEC_RANGE;
        }
        j = scanCallBackSort;
        m.clear();
        return b(i2);
    }

    public static int a(Context context, boolean z, int i2, ScanCallBackSort scanCallBackSort) {
        f9280b = com.intelligoo.sdk.a.b.ORDEREDSCAN;
        return a(context, z, i2, null, scanCallBackSort, null);
    }

    public static int a(Context context, boolean z, int i2, ScanCallBackSortWithElectricity scanCallBackSortWithElectricity) {
        f9280b = com.intelligoo.sdk.a.b.ORDEREDSCANWITHELE;
        return a(context, z, i2, null, null, scanCallBackSortWithElectricity);
    }

    public static int a(Context context, boolean z, int i2, ScanCallback scanCallback) {
        f9280b = com.intelligoo.sdk.a.b.UNORDERED;
        return a(context, z, i2, scanCallback, null, null);
    }

    private static int a(Context context, boolean z, int i2, ScanCallback scanCallback, ScanCallBackSort scanCallBackSort, ScanCallBackSortWithElectricity scanCallBackSortWithElectricity) {
        if (!a(context) || !f.a(context)) {
            return -100;
        }
        l.b(p.a().d().toString());
        p.a().a(context.getApplicationContext());
        if ((i2 < 0 && i2 != -1) || i2 > 60000) {
            return ConstantsUtils.SET_RESULT_ERROR_SEC_RANGE;
        }
        if (f9286h != null || f9287i != null || l != null) {
            return ConstantsUtils.SET_RESULT_ERROR_SCANING;
        }
        f9281c = z;
        f9286h = scanCallback;
        f9287i = scanCallBackSort;
        l = scanCallBackSortWithElectricity;
        m.clear();
        int iA = a(i2);
        if (iA != 0) {
            f9286h = null;
            f9287i = null;
        }
        return iA;
    }

    public static void a() {
        p.a().b(o);
    }

    private static boolean a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    private static int b(int i2) {
        return p.a().a(i2).a(o);
    }

    public static int b(Context context, int i2, ScanCallBackSort scanCallBackSort) {
        f9280b = com.intelligoo.sdk.a.b.NONFILTERSCAN;
        if (!a(context) || !f.a(context)) {
            return -100;
        }
        p.a().a(context.getApplicationContext());
        if ((i2 < 0 && i2 != -1) || i2 > 60000) {
            return ConstantsUtils.SET_RESULT_ERROR_SEC_RANGE;
        }
        k = scanCallBackSort;
        n.clear();
        return b(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public static String b(String str) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf(45) + 1;
        if (c(str.trim().substring(iIndexOf))) {
            return str.trim().substring(iIndexOf);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<Map<String, String>> b(ArrayList<Map<String, Integer>> arrayList) {
        ArrayList<Map<String, String>> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() > 0) {
            for (Map<String, Integer> map : arrayList) {
                HashMap map2 = new HashMap();
                for (String str : map.keySet()) {
                    map2.put(ConstantsUtils.DEV_SN, str);
                    map2.put(ConstantsUtils.DEVICE_RSSI, String.valueOf(map.get(str)));
                    if (!str.startsWith("#") || str.length() <= 5) {
                        map2.put(ConstantsUtils.DEVICE_ELECTRICITY, IdentifierConstant.OAID_STATE_DEFAULT);
                    } else {
                        String strSubstring = str.substring(1, 2);
                        l.a("sn subStr:" + strSubstring);
                        byte[] bytes = strSubstring.getBytes(Charset.forName("UTF-8"));
                        if (bytes == null || bytes.length <= 0) {
                            l.a("decode electri is null");
                            map2.put(ConstantsUtils.DEVICE_ELECTRICITY, IdentifierConstant.OAID_STATE_DEFAULT);
                        } else {
                            l.a("decode electri:" + ((int) bytes[0]));
                            map2.put(ConstantsUtils.DEVICE_ELECTRICITY, String.valueOf((int) bytes[0]));
                        }
                    }
                    arrayList2.add(map2);
                }
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<Map<String, Integer>> b(ArrayList<String> arrayList, ArrayList<Integer> arrayList2) {
        ArrayList<Map<String, Integer>> arrayList3 = new ArrayList<>();
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            map.put(arrayList.get(i2), arrayList2.get(i2));
        }
        Collections.sort(arrayList2);
        int iIntValue = -1;
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            if (iIntValue != arrayList2.get(size).intValue()) {
                iIntValue = arrayList2.get(size).intValue();
                for (String str : map.keySet()) {
                    if (((Integer) map.get(str)).equals(Integer.valueOf(iIntValue))) {
                        HashMap map2 = new HashMap();
                        map2.put(str, Integer.valueOf(iIntValue));
                        arrayList3.add(map2);
                    }
                }
            }
        }
        return arrayList3;
    }

    public static void b() {
        p.a().b((BluetoothAdapter.LeScanCallback) o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Map<String, List<Integer>> map) {
        p = new ArrayList<>();
        f9288q = new ArrayList<>();
        for (String str : map.keySet()) {
            p.add(str);
            int iIntValue = 0;
            Iterator<Integer> it = map.get(str).iterator();
            while (it.hasNext()) {
                iIntValue += it.next().intValue();
            }
            f9288q.add(Integer.valueOf(iIntValue / map.get(str).size()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str, int i2) {
        if (m.containsKey(str)) {
            m.get(str).add(Integer.valueOf(i2));
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(i2));
        m.put(str, arrayList);
    }

    private static boolean c(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return Pattern.compile("^\\d{10}$").matcher(str).matches();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, int i2) {
        if (n.containsKey(str)) {
            n.get(str).add(Integer.valueOf(i2));
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(i2));
        n.put(str, arrayList);
    }
}
