package cn.admobiletop.adsuyi.a.l;

import android.content.SharedPreferences;
import cn.admobiletop.adsuyi.ADSuyiSdk;

/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static s f3429a;

    public static s a() {
        if (f3429a == null) {
            synchronized (s.class) {
                if (f3429a == null) {
                    f3429a = new s();
                }
            }
        }
        return f3429a;
    }

    public String b(String str) {
        return c(null, str);
    }

    public String c(String str, String str2) {
        try {
            return c(str).getString(str2, null);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void d(String str, String str2) {
        a((String) null, str, str2);
    }

    public long b(String str, String str2) {
        try {
            return c(str).getLong(str2, 0L);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public final SharedPreferences c(String str) {
        if (str == null) {
            return ADSuyiSdk.getInstance().getContext().getSharedPreferences("cn.admobiletop.adsuyi", 0);
        }
        return ADSuyiSdk.getInstance().getContext().getSharedPreferences("cn.admobiletop.adsuyi." + str, 0);
    }

    public void b(String str, String str2, boolean z) {
        try {
            c(str).edit().putBoolean(str2, z).apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, String str2, String str3) {
        try {
            c(str).edit().putString(str2, str3).apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, String str2, long j) {
        try {
            c(str).edit().putLong(str2, j).apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean a(String str, String str2) {
        try {
            return c(str).getBoolean(str2, false);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean a(String str, String str2, boolean z) {
        try {
            return c(str).getBoolean(str2, z);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean a(String str) {
        return a((String) null, str);
    }

    public void a(String str, boolean z) {
        b(null, str, z);
    }
}
