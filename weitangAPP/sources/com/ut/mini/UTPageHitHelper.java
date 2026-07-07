package com.ut.mini;

import android.app.Activity;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.mtl.log.d.i;
import com.taobao.accs.common.Constants;
import com.ut.mini.base.UTMIVariables;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes2.dex */
public class UTPageHitHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static UTPageHitHelper f12348a = new UTPageHitHelper();
    private boolean O = false;
    private Map<String, String> z = new HashMap();
    private Map<String, UTPageEventObject> A = new HashMap();
    private String al = null;
    private Map<String, String> B = new HashMap();
    private String am = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Queue<UTPageEventObject> f152a = new LinkedList();
    private Map<Object, String> C = new HashMap();

    public static class UTPageEventObject {
        private Map<String, String> z = new HashMap();
        private long A = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Uri f12349a = null;
        private String an = null;
        private String ao = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private UTPageStatus f153a = null;
        private boolean P = false;
        private boolean Q = false;
        private boolean R = false;
        private String ap = null;

        public String getCacheKey() {
            return this.ap;
        }

        public String getPageName() {
            return this.an;
        }

        public Map<String, String> getPageProperties() {
            return this.z;
        }

        public UTPageStatus getPageStatus() {
            return this.f153a;
        }

        public long getPageStayTimstamp() {
            return this.A;
        }

        public Uri getPageUrl() {
            return this.f12349a;
        }

        public String getRefPage() {
            return this.ao;
        }

        public boolean isH5Called() {
            return this.R;
        }

        public boolean isPageAppearCalled() {
            return this.P;
        }

        public boolean isSkipPage() {
            return this.Q;
        }

        public void resetPropertiesWithoutSkipFlagAndH5Flag() {
            this.z = new HashMap();
            this.A = 0L;
            this.f12349a = null;
            this.an = null;
            this.ao = null;
            UTPageStatus uTPageStatus = this.f153a;
            if (uTPageStatus == null || uTPageStatus != UTPageStatus.UT_H5_IN_WebView) {
                this.f153a = null;
            }
            this.P = false;
            this.R = false;
        }

        public void setCacheKey(String str) {
            this.ap = str;
        }

        public void setH5Called() {
            this.R = true;
        }

        public void setPageAppearCalled() {
            this.P = true;
        }

        public void setPageName(String str) {
            this.an = str;
        }

        public void setPageProperties(Map<String, String> map) {
            this.z = map;
        }

        public void setPageStatus(UTPageStatus uTPageStatus) {
            this.f153a = uTPageStatus;
        }

        public void setPageStayTimstamp(long j) {
            this.A = j;
        }

        public void setPageUrl(Uri uri) {
            this.f12349a = uri;
        }

        public void setRefPage(String str) {
            this.ao = str;
        }

        public void setToSkipPage() {
            this.Q = true;
        }
    }

    private synchronized void b(UTPageEventObject uTPageEventObject) {
        if (this.A.containsKey(uTPageEventObject.getCacheKey())) {
            this.A.remove(uTPageEventObject.getCacheKey());
        }
    }

    public static UTPageHitHelper getInstance() {
        return f12348a;
    }

    public synchronized void a(UTPageEventObject uTPageEventObject) {
        uTPageEventObject.resetPropertiesWithoutSkipFlagAndH5Flag();
        if (!this.f152a.contains(uTPageEventObject)) {
            this.f152a.add(uTPageEventObject);
        }
        if (this.f152a.size() > 200) {
            for (int i2 = 0; i2 < 100; i2++) {
                UTPageEventObject uTPageEventObjectPoll = this.f152a.poll();
                if (uTPageEventObjectPoll != null && this.A.containsKey(uTPageEventObjectPoll.getCacheKey())) {
                    this.A.remove(uTPageEventObjectPoll.getCacheKey());
                }
            }
        }
    }

    public synchronized Map<String, String> c() {
        Map<String, String> map = this.B;
        if (map == null || map.size() <= 0) {
            return null;
        }
        HashMap map2 = new HashMap();
        map2.putAll(this.B);
        this.B.clear();
        return map2;
    }

    public String getCurrentPageName() {
        return this.am;
    }

    @Deprecated
    public synchronized void pageAppear(Object obj) {
        a(obj, null, false);
    }

    public void pageAppearByAuto(Activity activity) {
        if (this.O) {
            return;
        }
        pageAppear(activity);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e4 A[Catch: all -> 0x0132, TryCatch #0 {all -> 0x0132, blocks: (B:52:0x00b4, B:54:0x00c5, B:58:0x00de, B:60:0x00e4, B:62:0x00ed, B:66:0x00fc, B:67:0x0106, B:69:0x0112, B:70:0x0117, B:72:0x0121, B:73:0x0128, B:75:0x012e, B:57:0x00db), top: B:100:0x00b4, outer: #2, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0112 A[Catch: all -> 0x0132, TryCatch #0 {all -> 0x0132, blocks: (B:52:0x00b4, B:54:0x00c5, B:58:0x00de, B:60:0x00e4, B:62:0x00ed, B:66:0x00fc, B:67:0x0106, B:69:0x0112, B:70:0x0117, B:72:0x0121, B:73:0x0128, B:75:0x012e, B:57:0x00db), top: B:100:0x00b4, outer: #2, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0121 A[Catch: all -> 0x0132, TryCatch #0 {all -> 0x0132, blocks: (B:52:0x00b4, B:54:0x00c5, B:58:0x00de, B:60:0x00e4, B:62:0x00ed, B:66:0x00fc, B:67:0x0106, B:69:0x0112, B:70:0x0117, B:72:0x0121, B:73:0x0128, B:75:0x012e, B:57:0x00db), top: B:100:0x00b4, outer: #2, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x012e A[Catch: all -> 0x0132, TRY_LEAVE, TryCatch #0 {all -> 0x0132, blocks: (B:52:0x00b4, B:54:0x00c5, B:58:0x00de, B:60:0x00e4, B:62:0x00ed, B:66:0x00fc, B:67:0x0106, B:69:0x0112, B:70:0x0117, B:72:0x0121, B:73:0x0128, B:75:0x012e, B:57:0x00db), top: B:100:0x00b4, outer: #2, inners: #1 }] */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void pageDisAppear(java.lang.Object r12) {
        /*
            Method dump skipped, instruction units count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.UTPageHitHelper.pageDisAppear(java.lang.Object):void");
    }

    public void pageDisAppearByAuto(Activity activity) {
        if (this.O) {
            return;
        }
        pageDisAppear(activity);
    }

    public synchronized void skipPage(Object obj) {
        if (obj == null) {
            return;
        }
        a(obj).setToSkipPage();
    }

    @Deprecated
    public synchronized void turnOffAutoPageTrack() {
        this.O = true;
    }

    public synchronized void updateNextPageProperties(Map<String, String> map) {
        if (map != null) {
            HashMap map2 = new HashMap();
            map2.putAll(map);
            this.B = map2;
        }
    }

    public synchronized void updatePageName(Object obj, String str) {
        if (obj != null) {
            if (!TextUtils.isEmpty(str)) {
                a(obj).setPageName(str);
                this.am = str;
            }
        }
    }

    @Deprecated
    public synchronized void updatePageProperties(Map<String, String> map) {
        if (map != null) {
            this.z.putAll(map);
        }
    }

    public synchronized void updatePageStatus(Object obj, UTPageStatus uTPageStatus) {
        if (obj == null || uTPageStatus == null) {
            return;
        }
        a(obj).setPageStatus(uTPageStatus);
    }

    public synchronized void updatePageUrl(Object obj, Uri uri) {
        if (obj == null || uri == null) {
            return;
        }
        Log.i(AgooConstants.OPEN_URL, AgooConstants.OPEN_URL + uri.toString());
        a(obj).setPageUrl(uri);
    }

    public synchronized void pageAppear(Object obj, String str) {
        a(obj, str, false);
    }

    public synchronized void updatePageProperties(Object obj, Map<String, String> map) {
        if (obj != null && map != null) {
            if (map.size() != 0) {
                HashMap map2 = new HashMap();
                map2.putAll(map);
                UTPageEventObject uTPageEventObjectA = a(obj);
                Map<String, String> pageProperties = uTPageEventObjectA.getPageProperties();
                if (pageProperties == null) {
                    uTPageEventObjectA.setPageProperties(map2);
                } else {
                    HashMap map3 = new HashMap();
                    map3.putAll(pageProperties);
                    map3.putAll(map2);
                    uTPageEventObjectA.setPageProperties(map3);
                }
                return;
            }
        }
        i.a("updatePageProperties", "failed to update project, parameters should not be null and the map should not be empty");
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private synchronized void m89b(Object obj) {
        String strM88a = m88a(obj);
        if (this.A.containsKey(strM88a)) {
            this.A.remove(strM88a);
        }
    }

    private static String b(Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        return simpleName.toLowerCase().endsWith("activity") ? simpleName.substring(0, simpleName.length() - 8) : simpleName;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private String m88a(Object obj) {
        String simpleName;
        if (obj instanceof String) {
            simpleName = (String) obj;
        } else {
            simpleName = obj.getClass().getSimpleName();
        }
        return simpleName + obj.hashCode();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized boolean m91a(Object obj) {
        if (obj != null) {
            UTPageEventObject uTPageEventObjectA = a(obj);
            if (uTPageEventObjectA.getPageStatus() != null) {
                if (uTPageEventObjectA.getPageStatus() == UTPageStatus.UT_H5_IN_WebView) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m90a(Object obj) {
        if (obj != null) {
            UTPageEventObject uTPageEventObjectA = a(obj);
            if (uTPageEventObjectA.getPageStatus() != null) {
                uTPageEventObjectA.setH5Called();
            }
        }
    }

    private synchronized UTPageEventObject a(Object obj) {
        String strM88a = m88a(obj);
        if (this.A.containsKey(strM88a)) {
            return this.A.get(strM88a);
        }
        UTPageEventObject uTPageEventObject = new UTPageEventObject();
        this.A.put(strM88a, uTPageEventObject);
        uTPageEventObject.setCacheKey(strM88a);
        return uTPageEventObject;
    }

    private synchronized void a(String str, UTPageEventObject uTPageEventObject) {
        this.A.put(str, uTPageEventObject);
    }

    public synchronized void a(Object obj, String str, boolean z) {
        if (obj != null) {
            String strM88a = m88a(obj);
            if (strM88a != null && strM88a.equals(this.al)) {
                return;
            }
            if (this.al != null) {
                i.a("lost 2001", "Last page requires leave(" + this.al + ").");
            }
            UTPageEventObject uTPageEventObjectA = a(obj);
            if (!z && uTPageEventObjectA.isSkipPage()) {
                i.a("skip page[pageAppear]", "page name:" + obj.getClass().getSimpleName());
                return;
            }
            String h5Url = UTMIVariables.getInstance().getH5Url();
            if (h5Url != null) {
                try {
                    this.z.put("spm", Uri.parse(h5Url).getQueryParameter("spm"));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                UTMIVariables.getInstance().setH5Url(null);
            }
            String strB = b(obj);
            if (TextUtils.isEmpty(str)) {
                str = strB;
            }
            if (!TextUtils.isEmpty(uTPageEventObjectA.getPageName())) {
                str = uTPageEventObjectA.getPageName();
            }
            this.am = str;
            uTPageEventObjectA.setPageName(str);
            uTPageEventObjectA.setPageStayTimstamp(SystemClock.elapsedRealtime());
            uTPageEventObjectA.setRefPage(UTMIVariables.getInstance().getRefPage());
            uTPageEventObjectA.setPageAppearCalled();
            if (this.B != null) {
                Map<String, String> pageProperties = uTPageEventObjectA.getPageProperties();
                if (pageProperties == null) {
                    uTPageEventObjectA.setPageProperties(this.B);
                } else {
                    HashMap map = new HashMap();
                    map.putAll(pageProperties);
                    map.putAll(this.B);
                    uTPageEventObjectA.setPageProperties(map);
                }
            }
            this.B = null;
            this.al = m88a(obj);
            b(uTPageEventObjectA);
            a(m88a(obj), uTPageEventObjectA);
        } else {
            i.a("pageAppear", "The page object should not be null");
        }
    }

    private static String a(Uri uri) {
        List<String> queryParameters;
        if (uri == null || (queryParameters = uri.getQueryParameters(Constants.KEY_TTID)) == null) {
            return null;
        }
        for (String str : queryParameters) {
            if (!str.contains("@") && !str.contains("%40")) {
                return str;
            }
        }
        return null;
    }
}
