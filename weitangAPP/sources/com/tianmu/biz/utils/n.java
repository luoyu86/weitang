package com.tianmu.biz.utils;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tianmu.c.i.a;
import com.tianmu.c.i.c;
import com.tianmu.c.i.f;
import com.tianmu.c.i.h;
import com.tianmu.c.i.o;
import com.tianmu.c.i.p;
import com.tianmu.utils.TianmuLogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class n {
    public static com.tianmu.c.i.k a(JSONObject jSONObject, boolean z) {
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return null;
        }
        try {
            String strOptString = jSONObject.optString("packageName");
            String strOptString2 = jSONObject.optString("sha1");
            String strOptString3 = jSONObject.optString("testSha1");
            int iOptInt = jSONObject.optInt("downloadTip");
            int iOptInt2 = jSONObject.optInt("configReloadCount", 0);
            String strOptString4 = jSONObject.optString("debugFlag");
            String strOptString5 = jSONObject.optString("androidKey");
            com.tianmu.c.i.k kVar = new com.tianmu.c.i.k(strOptString, strOptString2, strOptString3, iOptInt, iOptInt2, strOptString4, strOptString5, (!jSONObject.has("admApi") || (jSONObjectOptJSONObject = jSONObject.optJSONObject("admApi")) == null) ? null : new com.tianmu.c.i.i(jSONObjectOptJSONObject.optString("appId"), jSONObjectOptJSONObject.optString("appToken"), jSONObjectOptJSONObject.optDouble("apiInterval"), jSONObjectOptJSONObject.optString("apiPollIntervalRegx"), strOptString5, jSONObjectOptJSONObject.optInt("quickAppMonitor", 0), jSONObjectOptJSONObject.optJSONArray("quickAppKeywords"), jSONObjectOptJSONObject.optInt("requestHeaderCtl"), jSONObjectOptJSONObject.optInt("apiRequestMode")), jSONObject.optInt("appInstallDetect", 0), jSONObject.optString("wechatAppId"), jSONObject.optInt("privateOaidRead", 0));
            if (jSONObject.has("adPositions") && (jSONArrayOptJSONArray = jSONObject.optJSONArray("adPositions")) != null && jSONArrayOptJSONArray.length() > 0) {
                HashMap map = new HashMap(jSONArrayOptJSONArray.length());
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
                    if (jSONObjectOptJSONObject2 != null) {
                        String strOptString6 = jSONObjectOptJSONObject2.optString("posId");
                        String strOptString7 = jSONObjectOptJSONObject2.optString("adType");
                        boolean zOptBoolean = jSONObjectOptJSONObject2.optBoolean("headBidding");
                        int iOptInt3 = jSONObjectOptJSONObject2.optInt("admApiCtl", 0);
                        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("attributes");
                        if (jSONObjectOptJSONObject3 != null) {
                            map.put(strOptString6, new com.tianmu.c.i.e(strOptString6, strOptString7, zOptBoolean, iOptInt3, jSONObjectOptJSONObject3.optInt("splashHotArea"), jSONObjectOptJSONObject3.optInt("renderType"), jSONObjectOptJSONObject3.optString("size"), jSONObjectOptJSONObject3.optString("adLayout"), jSONObjectOptJSONObject3.optInt("autoRefresh", 0), jSONObjectOptJSONObject3.optInt("skipShowTime", 0), jSONObjectOptJSONObject3.optInt("callback"), jSONObjectOptJSONObject3.optInt("contentSize", 1), jSONObjectOptJSONObject3.optInt("rewardQuitHint", 1), jSONObjectOptJSONObject3.optInt("closeBtnPosition", 0)));
                        }
                    }
                }
                kVar.a(map);
            }
            return kVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static com.tianmu.c.i.a b(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("appPromotion");
            int iOptInt = jSONObject.optInt("downloadType", 0);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("appName");
                String strOptString2 = jSONObjectOptJSONObject.optString("appVersion");
                String strOptString3 = jSONObjectOptJSONObject.optString("appIconUrl");
                String strOptString4 = jSONObjectOptJSONObject.optString("advertiserName");
                String strOptString5 = jSONObjectOptJSONObject.optString("privacyPolicyUrl");
                String strOptString6 = jSONObjectOptJSONObject.optString("privacyPolicyInfo");
                String strOptString7 = jSONObjectOptJSONObject.optString("appBundle");
                String strOptString8 = jSONObjectOptJSONObject.optString("privacyAuthUrl");
                return new a.C0209a().d(strOptString).f(strOptString2).c(strOptString3).a(strOptString4).i(strOptString5).h(strOptString6).b(strOptString7).g(strOptString8).a(iOptInt).e(jSONObjectOptJSONObject.optString("appUpdateTime")).a();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static com.tianmu.c.i.o c(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("tracker");
            if (jSONObjectOptJSONObject == null) {
                return null;
            }
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("display");
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("click");
            JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("deeplink");
            JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray("tryDeeplink");
            JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray("downloadStart");
            JSONArray jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray("downloadEnd");
            JSONArray jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray("installStart");
            JSONArray jSONArrayOptJSONArray8 = jSONObjectOptJSONObject.optJSONArray("installEnd");
            JSONArray jSONArrayOptJSONArray9 = jSONObjectOptJSONObject.optJSONArray("open");
            JSONArray jSONArrayOptJSONArray10 = jSONObjectOptJSONObject.optJSONArray("wechatOpen");
            JSONArray jSONArrayOptJSONArray11 = jSONObjectOptJSONObject.optJSONArray("appStoreOpen");
            JSONArray jSONArrayOptJSONArray12 = jSONObjectOptJSONObject.optJSONArray("videoLoaded");
            JSONArray jSONArrayOptJSONArray13 = jSONObjectOptJSONObject.optJSONArray("videoError");
            JSONArray jSONArrayOptJSONArray14 = jSONObjectOptJSONObject.optJSONArray("videoStart");
            JSONArray jSONArrayOptJSONArray15 = jSONObjectOptJSONObject.optJSONArray("videoQuarter");
            JSONArray jSONArrayOptJSONArray16 = jSONObjectOptJSONObject.optJSONArray("videoMiddle");
            JSONArray jSONArrayOptJSONArray17 = jSONObjectOptJSONObject.optJSONArray("videoThirdQuarter");
            JSONArray jSONArrayOptJSONArray18 = jSONObjectOptJSONObject.optJSONArray("videoEnd");
            JSONArray jSONArrayOptJSONArray19 = jSONObjectOptJSONObject.optJSONArray("videoPause");
            JSONArray jSONArrayOptJSONArray20 = jSONObjectOptJSONObject.optJSONArray("videoResume");
            JSONArray jSONArrayOptJSONArray21 = jSONObjectOptJSONObject.optJSONArray("videoSkip");
            JSONArray jSONArrayOptJSONArray22 = jSONObjectOptJSONObject.optJSONArray("videoMute");
            JSONArray jSONArrayOptJSONArray23 = jSONObjectOptJSONObject.optJSONArray("videoUnmute");
            JSONArray jSONArrayOptJSONArray24 = jSONObjectOptJSONObject.optJSONArray("videoReplay");
            JSONArray jSONArrayOptJSONArray25 = jSONObjectOptJSONObject.optJSONArray("videoClose");
            JSONArray jSONArrayOptJSONArray26 = jSONObjectOptJSONObject.optJSONArray("videoFullScreen");
            JSONArray jSONArrayOptJSONArray27 = jSONObjectOptJSONObject.optJSONArray("videoExitFullScreen");
            JSONArray jSONArrayOptJSONArray28 = jSONObjectOptJSONObject.optJSONArray("rewardSuccess");
            List<String> listA = a(jSONArrayOptJSONArray);
            List<String> listA2 = a(jSONArrayOptJSONArray2);
            List<String> listA3 = a(jSONArrayOptJSONArray3);
            List<String> listA4 = a(jSONArrayOptJSONArray4);
            List<String> listA5 = a(jSONArrayOptJSONArray5);
            List<String> listA6 = a(jSONArrayOptJSONArray6);
            List<String> listA7 = a(jSONArrayOptJSONArray7);
            List<String> listA8 = a(jSONArrayOptJSONArray8);
            List<String> listA9 = a(jSONArrayOptJSONArray9);
            List<String> listA10 = a(jSONArrayOptJSONArray12);
            List<String> listA11 = a(jSONArrayOptJSONArray13);
            List<String> listA12 = a(jSONArrayOptJSONArray14);
            List<String> listA13 = a(jSONArrayOptJSONArray15);
            List<String> listA14 = a(jSONArrayOptJSONArray16);
            List<String> listA15 = a(jSONArrayOptJSONArray17);
            List<String> listA16 = a(jSONArrayOptJSONArray18);
            List<String> listA17 = a(jSONArrayOptJSONArray19);
            List<String> listA18 = a(jSONArrayOptJSONArray20);
            List<String> listA19 = a(jSONArrayOptJSONArray21);
            List<String> listA20 = a(jSONArrayOptJSONArray22);
            List<String> listA21 = a(jSONArrayOptJSONArray23);
            List<String> listA22 = a(jSONArrayOptJSONArray24);
            List<String> listA23 = a(jSONArrayOptJSONArray25);
            List<String> listA24 = a(jSONArrayOptJSONArray26);
            List<String> listA25 = a(jSONArrayOptJSONArray27);
            List<String> listA26 = a(jSONArrayOptJSONArray28);
            List<String> listA27 = a(jSONArrayOptJSONArray10);
            return new o.a().e(listA).b(listA2).d(listA3).c(listA4).g(listA5).f(listA6).i(listA7).h(listA8).j(listA9).q(listA10).n(listA11).y(listA12).u(listA13).r(listA14).z(listA15).m(listA16).t(listA17).w(listA18).x(listA19).s(listA20).A(listA21).v(listA22).l(listA23).p(listA24).o(listA25).k(listA26).B(listA27).a(a(jSONArrayOptJSONArray11)).a();
        } catch (Exception unused) {
            return null;
        }
    }

    private static com.tianmu.c.i.o d(JSONObject jSONObject) {
        return c(jSONObject);
    }

    private static com.tianmu.c.i.p e(JSONObject jSONObject) {
        return h(jSONObject);
    }

    public static com.tianmu.c.i.b f(JSONObject jSONObject) {
        try {
            com.tianmu.c.i.b bVar = new com.tianmu.c.i.b();
            String strOptString = jSONObject.optString("appInstallJudgeList");
            if (!TextUtils.isEmpty(strOptString)) {
                List<String> listA = a(new JSONArray(strOptString));
                if (listA.size() > 0) {
                    bVar.a(listA);
                }
            }
            String strOptString2 = jSONObject.optString("appInstallMatchList");
            if (!TextUtils.isEmpty(strOptString2)) {
                List<String> listA2 = a(new JSONArray(strOptString2));
                if (listA2.size() > 0) {
                    bVar.b(listA2);
                }
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("interactStyleTextMap");
            if (jSONObjectOptJSONObject != null) {
                bVar.a(jSONObjectOptJSONObject);
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("interactSubStyleTextMap");
            if (jSONObjectOptJSONObject2 != null) {
                bVar.b(jSONObjectOptJSONObject2);
            }
            return bVar;
        } catch (Exception unused) {
            return null;
        }
    }

    public static com.tianmu.c.i.c g(JSONObject jSONObject) {
        List<String> listA;
        int i2;
        int i3;
        String strOptString;
        int i4;
        String str;
        long jOptLong;
        long jOptLong2;
        if (jSONObject == null) {
            return null;
        }
        try {
            int iOptInt = jSONObject.optInt("isGdt");
            String strOptString2 = jSONObject.optString("title");
            String strOptString3 = jSONObject.optString("desc");
            String strOptString4 = jSONObject.optString("imageUrl");
            String strOptString5 = jSONObject.optString("imageUrlList");
            if (TextUtils.isEmpty(strOptString5)) {
                listA = null;
            } else {
                listA = a(new JSONArray(strOptString5));
                if (listA != null && listA.size() > 0) {
                    TianmuLogUtil.iD(listA.toString());
                }
            }
            if (!TextUtils.isEmpty(strOptString4)) {
                TianmuLogUtil.iD(strOptString4);
            }
            String strOptString6 = jSONObject.optString("deeplinkUrl");
            String strOptString7 = jSONObject.optString("landingPageUrl");
            String strOptString8 = jSONObject.optString("adType");
            int iOptInt2 = jSONObject.optInt("materialType");
            int iOptInt3 = jSONObject.optInt("action");
            int iOptInt4 = jSONObject.optInt("bidPrice");
            int iOptInt5 = jSONObject.optInt("bidFloor");
            String strOptString9 = jSONObject.optString("winNoticeUrl");
            String strOptString10 = jSONObject.optString("lossNoticeUrl");
            String strOptString11 = jSONObject.optString("adSource");
            int iOptInt6 = jSONObject.optInt("interactStyle", 0);
            int iOptInt7 = jSONObject.optInt("interactSubStyle", 0);
            String strOptString12 = jSONObject.optString("shakeSensitivity");
            String strOptString13 = jSONObject.optString("adStyle");
            boolean zOptBoolean = jSONObject.optBoolean("supportOptimize");
            List<String> listA2 = a(jSONObject.optJSONArray("dropEffectIcons"));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(c.e.b.c.d.o.VIDEO_TYPE);
            if (jSONObjectOptJSONObject != null) {
                strOptString = jSONObjectOptJSONObject.optString(AgooConstants.OPEN_URL);
                str = strOptString9;
                jOptLong2 = jSONObjectOptJSONObject.optLong(MediationConstant.EXTRA_DURATION);
                i4 = iOptInt4;
                i3 = iOptInt5;
                jOptLong = jSONObjectOptJSONObject.optLong("forceDuration");
                i2 = iOptInt7;
            } else {
                i2 = iOptInt7;
                i3 = iOptInt5;
                strOptString = null;
                i4 = iOptInt4;
                str = strOptString9;
                jOptLong = 0;
                jOptLong2 = 0;
            }
            com.tianmu.c.i.o oVarD = d(jSONObject);
            com.tianmu.c.i.p pVarE = e(jSONObject);
            com.tianmu.c.i.a aVarA = a(jSONObject);
            if ("rewardvod".equals(strOptString8)) {
                return new f.a().k(strOptString).a(jOptLong2).f(iOptInt).b(jOptLong).j(strOptString2).e(strOptString3).f(strOptString4).b(listA).d(strOptString6).g(strOptString7).a(oVarD).a(pVarE).a(aVarA).c(strOptString8).g(iOptInt2).a(iOptInt3).c(i4).b(i3).l(str).h(strOptString10).a(strOptString11).d(iOptInt6).e(i2).i(strOptString12).a(listA2).b(strOptString13).a(zOptBoolean).a();
            }
            String str2 = str;
            int i5 = i2;
            long j = jOptLong2;
            int i6 = i4;
            int i7 = i3;
            return TextUtils.isEmpty(strOptString) ? new c.a().f(iOptInt).j(strOptString2).e(strOptString3).f(strOptString4).b(listA).d(strOptString6).g(strOptString7).a(oVarD).a(pVarE).a(aVarA).c(strOptString8).g(iOptInt2).a(iOptInt3).c(i6).b(i7).k(str2).h(strOptString10).a(strOptString11).d(iOptInt6).e(i5).i(strOptString12).a(listA2).b(strOptString13).a(zOptBoolean).a() : new h.b().k(strOptString).a(j).f(iOptInt).j(strOptString2).e(strOptString3).f(strOptString4).b(listA).d(strOptString6).g(strOptString7).a(oVarD).a(pVarE).a(aVarA).c(strOptString8).g(iOptInt2).a(iOptInt3).c(i6).b(i7).l(str2).h(strOptString10).a(strOptString11).d(iOptInt6).e(i5).i(strOptString12).a(listA2).b(strOptString13).a(zOptBoolean).a();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static com.tianmu.c.i.p h(JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("wechatId");
            return new p.a().a(strOptString).b(jSONObject.optString("wechatPath")).a();
        } catch (Exception unused) {
            return null;
        }
    }

    private static com.tianmu.c.i.a a(JSONObject jSONObject) {
        return b(jSONObject);
    }

    public static String a(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                String strA = com.tianmu.c.d.c.a(str);
                if (strA != null) {
                    return com.tianmu.c.d.a.a(str2, strA);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    private static List<String> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String strOptString = jSONArray.optString(i2);
                if (!TextUtils.isEmpty(strOptString)) {
                    arrayList.add(strOptString);
                }
            }
        }
        return arrayList;
    }
}
