package com.tianmu.apilib.api;

import android.webkit.WebView;
import com.tianmu.apilib.ad.IAdHttp;
import com.tianmu.apilib.utils.QuickAppLinkUtil;
import com.tianmu.apilib.utils.g;
import com.tianmu.apilib.utils.h;
import com.tianmu.apilib.utils.j;
import com.tianmu.c.i.i;
import com.tianmu.c.n.n;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class AdmobApiAdDataManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AdmobApiAdDataManager f10792a = new AdmobApiAdDataManager();

    private AdmobApiAdDataManager() {
    }

    public static synchronized AdmobApiAdDataManager getInstance() {
        return f10792a;
    }

    public IAdHttp getAdHttp() {
        return com.tianmu.b.b.a.c().a(com.tianmu.b.c.a.c().b());
    }

    public Map<String, String> getApiParams() {
        return com.tianmu.b.c.b.g().b();
    }

    public String getApiUrl(String str, String str2) {
        return com.tianmu.b.c.b.g().a(str, str2);
    }

    public String getAppId() {
        i iVarD = n.D().d();
        return iVarD == null ? "" : iVarD.c();
    }

    public String getCode200Url(String str, String str2) {
        j.b().a(str2);
        return g.b(str, getUserAgent(), 0, new ArrayList());
    }

    public String getMachine() {
        return com.tianmu.b.c.b.g().c();
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return com.tianmu.b.c.a.c().b();
    }

    public String getUserAgent() {
        return com.tianmu.b.c.b.g().e();
    }

    public boolean isGoogle() {
        return false;
    }

    public void loadResource(String str) {
        loadResource(str, null);
    }

    public boolean needCheckRedirect(String str) {
        return com.tianmu.b.a.a().a(str);
    }

    public void removeJavascriptInterfaces(WebView webView) {
        h.a(webView);
    }

    public void loadResource(String str, String str2) {
        if (QuickAppLinkUtil.isFilterQuickAppLink(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            QuickAppLinkUtil.reportAppLink(arrayList);
        } else {
            j.b().a(str2);
            g.a(str, getUserAgent(), 0, new ArrayList());
        }
    }
}
