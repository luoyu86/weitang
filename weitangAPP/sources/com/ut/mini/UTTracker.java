package com.ut.mini;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.mtl.log.a;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.q;
import com.alibaba.mtl.log.model.LogField;
import com.ut.mini.base.UTMIVariables;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class UTTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Pattern f12351a = Pattern.compile("(\\|\\||[\t\r\n])+");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f12352g;
    private String aq = null;
    private Map<String, String> D = new HashMap();

    private static String b(String str) {
        return d(str);
    }

    private static String d(String str) {
        return (str == null || "".equals(str)) ? str : f12351a.matcher(str).replaceAll("");
    }

    private static void f(Map<String, String> map) {
        if (map != null) {
            LogField logField = LogField.IMEI;
            if (map.containsKey(logField.toString())) {
                map.remove(logField.toString());
            }
            LogField logField2 = LogField.IMSI;
            if (map.containsKey(logField2.toString())) {
                map.remove(logField2.toString());
            }
            LogField logField3 = LogField.CARRIER;
            if (map.containsKey(logField3.toString())) {
                map.remove(logField3.toString());
            }
            LogField logField4 = LogField.ACCESS;
            if (map.containsKey(logField4.toString())) {
                map.remove(logField4.toString());
            }
            LogField logField5 = LogField.ACCESS_SUBTYPE;
            if (map.containsKey(logField5.toString())) {
                map.remove(logField5.toString());
            }
            LogField logField6 = LogField.CHANNEL;
            if (map.containsKey(logField6.toString())) {
                map.remove(logField6.toString());
            }
            LogField logField7 = LogField.LL_USERNICK;
            if (map.containsKey(logField7.toString())) {
                map.remove(logField7.toString());
            }
            LogField logField8 = LogField.USERNICK;
            if (map.containsKey(logField8.toString())) {
                map.remove(logField8.toString());
            }
            LogField logField9 = LogField.LL_USERID;
            if (map.containsKey(logField9.toString())) {
                map.remove(logField9.toString());
            }
            LogField logField10 = LogField.USERID;
            if (map.containsKey(logField10.toString())) {
                map.remove(logField10.toString());
            }
            LogField logField11 = LogField.SDKVERSION;
            if (map.containsKey(logField11.toString())) {
                map.remove(logField11.toString());
            }
            LogField logField12 = LogField.START_SESSION_TIMESTAMP;
            if (map.containsKey(logField12.toString())) {
                map.remove(logField12.toString());
            }
            LogField logField13 = LogField.UTDID;
            if (map.containsKey(logField13.toString())) {
                map.remove(logField13.toString());
            }
            LogField logField14 = LogField.SDKTYPE;
            if (map.containsKey(logField14.toString())) {
                map.remove(logField14.toString());
            }
            LogField logField15 = LogField.RESERVE2;
            if (map.containsKey(logField15.toString())) {
                map.remove(logField15.toString());
            }
            LogField logField16 = LogField.RESERVE3;
            if (map.containsKey(logField16.toString())) {
                map.remove(logField16.toString());
            }
            LogField logField17 = LogField.RESERVE4;
            if (map.containsKey(logField17.toString())) {
                map.remove(logField17.toString());
            }
            LogField logField18 = LogField.RESERVE5;
            if (map.containsKey(logField18.toString())) {
                map.remove(logField18.toString());
            }
            LogField logField19 = LogField.RESERVES;
            if (map.containsKey(logField19.toString())) {
                map.remove(logField19.toString());
            }
            LogField logField20 = LogField.RECORD_TIMESTAMP;
            if (map.containsKey(logField20.toString())) {
                map.remove(logField20.toString());
            }
        }
    }

    private Map<String, String> g(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        HashMap map2 = new HashMap();
        Iterator<String> it = map.keySet().iterator();
        if (it != null) {
            while (it.hasNext()) {
                String next = it.next();
                if (next != null) {
                    map2.put(next, b(map.get(next)));
                }
            }
        }
        return map2;
    }

    private static void h(Map<String, String> map) {
        HashMap map2 = new HashMap();
        if (map.containsKey(UTFields.TRACK_ID)) {
            String str = map.get(UTFields.TRACK_ID);
            map.remove(UTFields.TRACK_ID);
            if (!TextUtils.isEmpty(str)) {
                map2.put("_tkid", str);
            }
        }
        if (map2.size() > 0) {
            map.put(LogField.RESERVES.toString(), q.d(map2));
        }
        LogField logField = LogField.PAGE;
        if (map.containsKey(logField.toString())) {
            return;
        }
        map.put(logField.toString(), "UT");
    }

    public synchronized String getGlobalProperty(String str) {
        if (str == null) {
            return null;
        }
        return this.D.get(str);
    }

    public void pageAppear(Object obj) {
        UTPageHitHelper.getInstance().pageAppear(obj);
    }

    public void pageAppearDonotSkip(Object obj) {
        UTPageHitHelper.getInstance().a(obj, null, true);
    }

    public void pageDisAppear(Object obj) {
        UTPageHitHelper.getInstance().pageDisAppear(obj);
    }

    public void q(String str) {
        this.aq = str;
    }

    public void r(String str) {
        this.f12352g = str;
    }

    public synchronized void removeGlobalProperty(String str) {
        if (str != null) {
            if (this.D.containsKey(str)) {
                this.D.remove(str);
            }
        }
    }

    public void send(Map<String, String> map) {
        if (map != null) {
            HashMap map2 = new HashMap();
            map2.putAll(this.D);
            map2.putAll(map);
            if (!TextUtils.isEmpty(this.f12352g)) {
                map2.put(LogField.APPKEY.toString(), this.f12352g);
            }
            Map<String, String> mapG = g((Map<String, String>) map2);
            if (!TextUtils.isEmpty(this.aq)) {
                mapG.put(UTFields.TRACK_ID, this.aq);
            }
            UTMIVariables.getInstance().isAliyunOSPlatform();
            f(mapG);
            d(mapG);
            m92g(mapG);
            h(mapG);
            a.a(mapG.remove(LogField.PAGE.toString()), mapG.remove(LogField.EVENTID.toString()), mapG.remove(LogField.ARG1.toString()), mapG.remove(LogField.ARG2.toString()), mapG.remove(LogField.ARG3.toString()), mapG);
        }
    }

    public synchronized void setGlobalProperty(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            i.a("setGlobalProperty", "key is null or key is empty or value is null,please check it!");
        } else {
            this.D.put(str, str2);
        }
    }

    public void skipPage(Object obj) {
        UTPageHitHelper.getInstance().skipPage(obj);
    }

    public void updateNextPageProperties(Map<String, String> map) {
        UTPageHitHelper.getInstance().updateNextPageProperties(map);
    }

    public void updatePageName(Object obj, String str) {
        UTPageHitHelper.getInstance().updatePageName(obj, str);
    }

    public void updatePageProperties(Object obj, Map<String, String> map) {
        UTPageHitHelper.getInstance().updatePageProperties(obj, map);
    }

    public void updatePageStatus(Object obj, UTPageStatus uTPageStatus) {
        UTPageHitHelper.getInstance().updatePageStatus(obj, uTPageStatus);
    }

    public void updatePageUrl(Object obj, Uri uri) {
        UTPageHitHelper.getInstance().updatePageUrl(obj, uri);
    }

    public void pageAppear(Object obj, String str) {
        UTPageHitHelper.getInstance().pageAppear(obj, str);
    }

    public void pageAppearDonotSkip(Object obj, String str) {
        UTPageHitHelper.getInstance().a(obj, str, true);
    }

    private static void d(Map<String, String> map) {
        if (map != null) {
            if (map.containsKey(UTFields.OS)) {
                String str = map.get(UTFields.OS);
                map.remove(UTFields.OS);
                map.put(LogField.OS.toString(), str);
            }
            if (map.containsKey(UTFields.OS_VERSION)) {
                String str2 = map.get(UTFields.OS_VERSION);
                map.remove(UTFields.OS_VERSION);
                map.put(LogField.OSVERSION.toString(), str2);
            }
        }
    }

    /* JADX INFO: renamed from: g, reason: collision with other method in class */
    private static void m92g(Map<String, String> map) {
        map.put(LogField.SDKTYPE.toString(), "mini");
    }
}
