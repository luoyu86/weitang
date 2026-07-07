package com.tianmu.c.n;

import android.text.TextUtils;
import com.tianmu.http.listener.SimpleHttpListener;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static j f11872b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tianmu.biz.web.c f11873a;

    public class a extends SimpleHttpListener {
        public a() {
        }

        @Override // com.tianmu.http.listener.SimpleHttpListener, com.tianmu.http.listener.HttpListener
        public void onRequestFailed(int i2, String str, String str2) {
            if (i2 != -2001 || TextUtils.isEmpty(str2)) {
                return;
            }
            j.this.f11873a.a(str2, null, null);
        }
    }

    public class b extends SimpleHttpListener {
        public b() {
        }

        @Override // com.tianmu.http.listener.SimpleHttpListener, com.tianmu.http.listener.HttpListener
        public void onRequestFailed(int i2, String str, String str2) {
            if (i2 != -2001 || TextUtils.isEmpty(str2)) {
                return;
            }
            j.this.f11873a.a(str2, null, null);
        }
    }

    public class c extends SimpleHttpListener {
        public c() {
        }

        @Override // com.tianmu.http.listener.SimpleHttpListener, com.tianmu.http.listener.HttpListener
        public void onRequestFailed(int i2, String str, String str2) {
            if (i2 != -2001 || TextUtils.isEmpty(str2)) {
                return;
            }
            j.this.f11873a.a(str2, null, null);
        }
    }

    private j() {
        com.tianmu.c.k.d.d().a(com.tianmu.c.n.c.c().b());
        this.f11873a = com.tianmu.c.k.d.d().a();
    }

    public static j b() {
        if (f11872b == null) {
            synchronized (j.class) {
                if (f11872b == null) {
                    f11872b = new j();
                }
            }
        }
        return f11872b;
    }

    public void a(List<String> list, boolean z) {
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            if (this.f11873a != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    String str = list.get(i2);
                    if (str != null) {
                        String strReplace = str.replace("[", "%5b").replace("]", "%5d").replace(" ", "");
                        if (!z) {
                            this.f11873a.a(strReplace, null, new b());
                        } else if (!strReplace.contains("{play_time}")) {
                            this.f11873a.a(strReplace, null, new a());
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(List<String> list, HashMap<String, String> map) {
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            if (this.f11873a != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    String str = list.get(i2);
                    if (str != null) {
                        String strReplace = str.replace("[", "%5b").replace("]", "%5d").replace(" ", "");
                        if (map != null) {
                            for (String str2 : map.keySet()) {
                                if (strReplace.contains(str2)) {
                                    strReplace = strReplace.replace(str2, map.get(str2));
                                }
                            }
                        }
                        this.f11873a.a(strReplace, null, new c());
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public com.tianmu.biz.web.c a() {
        return this.f11873a;
    }
}
