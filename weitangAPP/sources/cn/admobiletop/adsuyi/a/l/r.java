package cn.admobiletop.adsuyi.a.l;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class r {
    public static String a() {
        String strC = s.a().c("adsuyi_pis_sp", "adsuyi_ANDROID_ID");
        return !TextUtils.isEmpty(strC) ? cn.admobiletop.adsuyi.a.d.a.a(strC, "1170kz5abc171b56") : "";
    }

    public static String b() {
        String strC = s.a().c("adsuyi_pis_sp", "adsuyi_IMEI");
        return !TextUtils.isEmpty(strC) ? cn.admobiletop.adsuyi.a.d.a.a(strC, "1170kz5abc171b56") : "";
    }

    public static String c() {
        String strC = s.a().c("adsuyi_pis_sp", "adsuyi_MAC");
        return !TextUtils.isEmpty(strC) ? cn.admobiletop.adsuyi.a.d.a.a(strC, "1170kz5abc171b56") : "";
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strB = cn.admobiletop.adsuyi.a.d.a.b(str, "1170kz5abc171b56");
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        s.a().a("adsuyi_pis_sp", "adsuyi_ANDROID_ID", strB);
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strB = cn.admobiletop.adsuyi.a.d.a.b(str, "1170kz5abc171b56");
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        s.a().a("adsuyi_pis_sp", "adsuyi_IMEI", strB);
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strB = cn.admobiletop.adsuyi.a.d.a.b(str, "1170kz5abc171b56");
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        s.a().a("adsuyi_pis_sp", "adsuyi_MAC", strB);
    }
}
