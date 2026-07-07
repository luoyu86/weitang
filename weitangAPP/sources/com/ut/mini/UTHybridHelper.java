package com.ut.mini;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.mtl.log.d.i;
import com.ut.mini.base.UTMIVariables;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes2.dex */
public class UTHybridHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static UTHybridHelper f12347a = new UTHybridHelper();

    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.util.Date r10, java.util.Map<java.lang.String, java.lang.String> r11, java.lang.Object r12) {
        /*
            r9 = this;
            if (r11 == 0) goto Lb9
            int r10 = r11.size()
            if (r10 != 0) goto La
            goto Lb9
        La:
            java.lang.String r10 = "urlpagename"
            java.lang.Object r10 = r11.get(r10)
            java.lang.String r10 = (java.lang.String) r10
            java.lang.String r0 = "url"
            java.lang.Object r0 = r11.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r10 = r9.b(r10, r0)
            if (r10 == 0) goto Lb2
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 == 0) goto L28
            goto Lb2
        L28:
            com.ut.mini.base.UTMIVariables r0 = com.ut.mini.base.UTMIVariables.getInstance()
            java.lang.String r4 = r0.getRefPage()
            r0 = 0
            java.lang.String r1 = "utjstype"
            java.lang.Object r2 = r11.get(r1)
            java.lang.String r2 = (java.lang.String) r2
            r11.remove(r1)
            if (r2 == 0) goto L56
            java.lang.String r1 = "0"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L47
            goto L56
        L47:
            java.lang.String r1 = "1"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L54
            java.util.Map r11 = r9.d(r11)
            goto L5a
        L54:
            r7 = r0
            goto L5b
        L56:
            java.util.Map r11 = r9.c(r11)
        L5a:
            r7 = r11
        L5b:
            r11 = 2006(0x7d6, float:2.811E-42)
            com.ut.mini.UTPageHitHelper r0 = com.ut.mini.UTPageHitHelper.getInstance()
            boolean r0 = r0.m91a(r12)
            r8 = 2001(0x7d1, float:2.804E-42)
            if (r0 == 0) goto L6b
            r11 = 2001(0x7d1, float:2.804E-42)
        L6b:
            com.ut.mini.internal.UTOriginalCustomHitBuilder r0 = new com.ut.mini.internal.UTOriginalCustomHitBuilder
            r5 = 0
            r6 = 0
            r1 = r0
            r2 = r10
            r3 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7)
            if (r8 != r11) goto L7e
            com.ut.mini.base.UTMIVariables r11 = com.ut.mini.base.UTMIVariables.getInstance()
            r11.setRefPage(r10)
        L7e:
            com.ut.mini.UTPageHitHelper r10 = com.ut.mini.UTPageHitHelper.getInstance()
            java.util.Map r10 = r10.c()
            if (r10 == 0) goto L91
            int r11 = r10.size()
            if (r11 <= 0) goto L91
            r0.setProperties(r10)
        L91:
            com.ut.mini.UTAnalytics r10 = com.ut.mini.UTAnalytics.getInstance()
            com.ut.mini.UTTracker r10 = r10.getDefaultTracker()
            if (r10 == 0) goto La3
            java.util.Map r11 = r0.build()
            r10.send(r11)
            goto Laa
        La3:
            java.lang.String r10 = "h5Page event error"
            java.lang.String r11 = "Fatal Error,must call setRequestAuthentication method first."
            com.alibaba.mtl.log.d.i.a(r10, r11)
        Laa:
            com.ut.mini.UTPageHitHelper r10 = com.ut.mini.UTPageHitHelper.getInstance()
            r10.m90a(r12)
            return
        Lb2:
            java.lang.String r10 = "h5Page"
            java.lang.String r11 = "pageName is null,return"
            com.alibaba.mtl.log.d.i.a(r10, r11)
        Lb9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.UTHybridHelper.a(java.util.Date, java.util.Map, java.lang.Object):void");
    }

    private String b(String str, String str2) {
        if (str != null && !TextUtils.isEmpty(str)) {
            return str;
        }
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        int iIndexOf = str2.indexOf("?");
        return iIndexOf == -1 ? str2 : str2.substring(0, iIndexOf);
    }

    private Map<String, String> c(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap map2 = new HashMap();
        String str = map.get(AgooConstants.OPEN_URL);
        map2.put("_h5url", str == null ? "" : str);
        if (str != null) {
            Uri uri = Uri.parse(str);
            String queryParameter = uri.getQueryParameter("spm");
            if (queryParameter == null || TextUtils.isEmpty(queryParameter)) {
                map2.put("spm", "0.0.0.0");
            } else {
                map2.put("spm", queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("scm");
            if (queryParameter2 != null && !TextUtils.isEmpty(queryParameter2)) {
                map2.put("scm", queryParameter2);
            }
        } else {
            map2.put("spm", "0.0.0.0");
        }
        String str2 = map.get("spmcnt");
        if (str2 == null) {
            str2 = "";
        }
        map2.put("_spmcnt", str2);
        String str3 = map.get("spmpre");
        if (str3 == null) {
            str3 = "";
        }
        map2.put("_spmpre", str3);
        String str4 = map.get("lzsid");
        if (str4 == null) {
            str4 = "";
        }
        map2.put("_lzsid", str4);
        String str5 = map.get("extendargs");
        if (str5 == null) {
            str5 = "";
        }
        map2.put("_h5ea", str5);
        String str6 = map.get("cna");
        map2.put("_cna", str6 != null ? str6 : "");
        map2.put("_ish5", "1");
        return map2;
    }

    private Map<String, String> d(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap map2 = new HashMap();
        String str = map.get(AgooConstants.OPEN_URL);
        if (str == null) {
            str = "";
        }
        map2.put("_h5url", str);
        String str2 = map.get("extendargs");
        map2.put("_h5ea", str2 != null ? str2 : "");
        map2.put("_ish5", "1");
        return map2;
    }

    private Map<String, String> e(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap map2 = new HashMap();
        String str = map.get("logkeyargs");
        if (str == null) {
            str = "";
        }
        map2.put("_lka", str);
        String str2 = map.get("cna");
        if (str2 == null) {
            str2 = "";
        }
        map2.put("_cna", str2);
        String str3 = map.get("extendargs");
        map2.put("_h5ea", str3 != null ? str3 : "");
        map2.put("_ish5", "1");
        return map2;
    }

    private Map<String, String> f(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap map2 = new HashMap();
        String str = map.get("extendargs");
        if (str == null) {
            str = "";
        }
        map2.put("_h5ea", str);
        map2.put("_ish5", "1");
        return map2;
    }

    public static UTHybridHelper getInstance() {
        return f12347a;
    }

    public void h5UT(Map<String, String> map, Object obj) {
        if (map == null || map.size() == 0) {
            i.a("h5UT", "dataMap is empty");
            return;
        }
        String str = map.get("functype");
        if (str == null) {
            i.a("h5UT", "funcType is null");
            return;
        }
        String str2 = map.get("utjstype");
        if (str2 != null && !str2.equals("0") && !str2.equals("1")) {
            i.a("h5UT", "utjstype should be 1 or 0 or null");
            return;
        }
        map.remove("functype");
        Date date = new Date();
        if (str.equals("2001")) {
            a(date, map, obj);
        } else if (str.equals("2101")) {
            a(date, map);
        }
    }

    public void setH5Url(String str) {
        if (str != null) {
            UTMIVariables.getInstance().setH5Url(str);
        }
    }

    private void a(Date date, Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        String strB = b(map.get("urlpagename"), map.get(AgooConstants.OPEN_URL));
        if (strB != null && !TextUtils.isEmpty(strB)) {
            String str = map.get("logkey");
            if (str != null && !TextUtils.isEmpty(str)) {
                Map<String, String> mapE = null;
                String str2 = map.get("utjstype");
                map.remove("utjstype");
                if (str2 != null && !str2.equals("0")) {
                    if (str2.equals("1")) {
                        mapE = f(map);
                    }
                } else {
                    mapE = e(map);
                }
                UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(strB, 2101, str, null, null, mapE);
                UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
                if (defaultTracker != null) {
                    defaultTracker.send(uTOriginalCustomHitBuilder.build());
                    return;
                } else {
                    i.a("h5Ctrl event error", "Fatal Error,must call setRequestAuthentication method first.");
                    return;
                }
            }
            i.a("h5Ctrl", "logkey is null,return");
            return;
        }
        i.a("h5Ctrl", "pageName is null,return");
    }
}
