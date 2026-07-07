package cn.admobiletop.adsuyi.a.f;

import android.content.ContentValues;
import android.text.TextUtils;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static h f3260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public cn.admobiletop.adsuyi.a.f.a.a f3261b;

    public static h b() {
        if (f3260a == null) {
            synchronized (h.class) {
                if (f3260a == null) {
                    f3260a = new h();
                }
            }
        }
        return f3260a;
    }

    public synchronized cn.admobiletop.adsuyi.a.f.a.a a() {
        if (ADSuyiSdk.getInstance().getContext() != null) {
            try {
                this.f3261b = cn.admobiletop.adsuyi.a.f.a.a.a(ADSuyiSdk.getInstance().getContext(), 3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.f3261b;
    }

    public void a(String str, List<ContentValues> list) {
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return;
        }
        cn.admobiletop.adsuyi.a.h.d.c().d().execute(new f(this, list, str));
    }

    public void a(String str, String str2, String[] strArr, String str3, cn.admobiletop.adsuyi.a.f.c.a aVar) {
        cn.admobiletop.adsuyi.a.h.d.c().d().execute(new g(this, str, str2, strArr, str3, aVar));
    }
}
