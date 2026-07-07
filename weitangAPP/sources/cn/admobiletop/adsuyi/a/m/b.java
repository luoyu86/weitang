package cn.admobiletop.adsuyi.a.m;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static <T> T b(String str) {
        try {
            return (T) Class.forName(str).newInstance();
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T c(String str) {
        return (T) b("cn.admobiletop.adsuyi.adapter." + str + ".ADSuyiIniter");
    }

    public static boolean a() {
        return a("cn.admobiletop.adsuyi.adapter.tianmu.ADSuyiIniter");
    }
}
