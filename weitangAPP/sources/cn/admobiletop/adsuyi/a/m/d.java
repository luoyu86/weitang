package cn.admobiletop.adsuyi.a.m;

import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import cn.admobiletop.adsuyi.a.l.s;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdType;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatform;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPosId;
import cn.admobiletop.adsuyi.config.ADSuyiConfig;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static cn.admobiletop.adsuyi.a.g.a a(String str, JSONObject jSONObject, boolean z) {
        int iOptInt;
        int i2;
        int i3;
        String str2;
        String str3;
        int i4;
        String str4;
        JSONArray jSONArray;
        int i5;
        String str5;
        String str6;
        String str7;
        if (jSONObject == null) {
            return null;
        }
        try {
            int iOptInt2 = jSONObject.optInt(AgooConstants.MESSAGE_FLAG);
            int iOptInt3 = jSONObject.optInt("downTip", 1);
            int iOptInt4 = jSONObject.optInt("isJava");
            String strOptString = jSONObject.optString("androidKey");
            String strOptString2 = jSONObject.optString("packageName");
            double dOptDouble = jSONObject.optDouble("apiInterval", 0.75d);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("apiRate");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("novel");
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("initSubscribeTimes");
            long jOptLong = jSONObject.optLong("updateTime");
            if (jSONObject.has("log")) {
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("log");
                int iOptInt5 = jSONObjectOptJSONObject2.optInt("adMaterialReport");
                int iOptInt6 = jSONObjectOptJSONObject2.optInt("installListRead");
                i3 = iOptInt5;
                iOptInt = jSONObjectOptJSONObject2.optInt("enabled");
                i2 = iOptInt6;
            } else {
                iOptInt = 1;
                i2 = 0;
                i3 = 0;
            }
            try {
                int iOptInt7 = jSONObject.optInt("configReloadCount");
                str2 = "adType";
                str3 = "posId";
                try {
                    if (iOptInt7 == 30) {
                        try {
                            i4 = iOptInt7;
                            s.a().a("packageNameFlag", true);
                        } catch (Exception unused) {
                            i4 = iOptInt7;
                        }
                    } else {
                        i4 = iOptInt7;
                        s.a().a("packageNameFlag", false);
                    }
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                str2 = "adType";
                str3 = "posId";
                i4 = 0;
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("recipe");
            int iOptInt8 = jSONObject.optInt("quickAppMonitor", 0);
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("quickAppKeywords");
            JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("splashHotAreaSdk");
            JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("splashCustomSkipSdk");
            String str8 = "id";
            int iOptInt9 = jSONObject.optInt("requestHeaderCtl", 0);
            boolean zOptBoolean = jSONObject.optBoolean("auditMatch", false);
            cn.admobiletop.adsuyi.a.g.a aVar = new cn.admobiletop.adsuyi.a.g.a(iOptInt2, iOptInt3, iOptInt4, strOptString, strOptString2, dOptDouble, jSONArrayOptJSONArray, jSONObjectOptJSONObject == null ? null : jSONObjectOptJSONObject.toString(), jSONArrayOptJSONArray2, jOptLong, i3, i2, i4, jSONObjectOptJSONObject3 == null ? null : jSONObjectOptJSONObject3.toString(), iOptInt8, iOptInt9);
            aVar.a(iOptInt);
            aVar.c(a(jSONArrayOptJSONArray4));
            aVar.b(a(jSONArrayOptJSONArray5));
            aVar.a(a(jSONArrayOptJSONArray3));
            aVar.a(zOptBoolean);
            b(jSONObject, aVar, str, zOptBoolean);
            JSONArray jSONArrayOptJSONArray6 = jSONObject.optJSONArray("adPosList");
            if (jSONArrayOptJSONArray6 != null && jSONArrayOptJSONArray6.length() > 0) {
                Map<String, ADSuyiPosId> map = new HashMap<>(jSONArrayOptJSONArray6.length());
                int i6 = 0;
                while (i6 < jSONArrayOptJSONArray6.length()) {
                    JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray6.optJSONObject(i6);
                    if (jSONObjectOptJSONObject4 == null) {
                        jSONArray = jSONArrayOptJSONArray6;
                        i5 = i6;
                        str4 = str2;
                    } else {
                        String str9 = str8;
                        long jOptLong2 = jSONObjectOptJSONObject4.optLong(str9);
                        long jOptLong3 = jSONObjectOptJSONObject4.optLong("groupId", 0L);
                        String str10 = str3;
                        String strOptString3 = jSONObjectOptJSONObject4.optString(str10);
                        int iOptInt10 = jSONObjectOptJSONObject4.optInt("api");
                        int iOptInt11 = jSONObjectOptJSONObject4.optInt("reward");
                        str4 = str2;
                        String strOptString4 = jSONObjectOptJSONObject4.optString(str4);
                        int iOptInt12 = jSONObjectOptJSONObject4.optInt("frequencyMode");
                        int iOptInt13 = jSONObjectOptJSONObject4.optInt("clickOptimize");
                        int iOptInt14 = jSONObjectOptJSONObject4.optInt("compelRefresh");
                        double dOptDouble2 = jSONObjectOptJSONObject4.optDouble("hbBidFloor");
                        String strOptString5 = jSONObjectOptJSONObject4.optString("requestMode", ADSuyiConfig.RequestMode.SERIAL);
                        int iOptInt15 = jSONObjectOptJSONObject4.optInt("biddingTimeout");
                        int iOptInt16 = jSONObjectOptJSONObject4.optInt("singleSourceTimeout");
                        int iOptInt17 = jSONObjectOptJSONObject4.optInt("totalTimeout");
                        cn.admobiletop.adsuyi.a.g.e eVar = new cn.admobiletop.adsuyi.a.g.e(jOptLong2, jOptLong3, strOptString3, iOptInt10, iOptInt11, strOptString4, z, iOptInt13, iOptInt12, iOptInt14, dOptDouble2, strOptString5);
                        eVar.a(iOptInt15, iOptInt16, iOptInt17);
                        JSONArray jSONArrayOptJSONArray7 = jSONObjectOptJSONObject4.optJSONArray("networkAdPosList");
                        if (jSONArrayOptJSONArray7 == null || jSONArrayOptJSONArray7.length() <= 0) {
                            jSONArray = jSONArrayOptJSONArray6;
                            str8 = str9;
                            str3 = str10;
                            i5 = i6;
                        } else {
                            ArrayList arrayList = new ArrayList();
                            jSONArray = jSONArrayOptJSONArray6;
                            int i7 = 0;
                            boolean z2 = false;
                            boolean z3 = false;
                            while (true) {
                                i5 = i6;
                                if (i7 >= jSONArrayOptJSONArray7.length()) {
                                    break;
                                }
                                JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray7.optJSONObject(i7);
                                JSONArray jSONArray2 = jSONArrayOptJSONArray7;
                                if (jSONObjectOptJSONObject5 == null) {
                                    str5 = str9;
                                    str6 = str10;
                                    str7 = strOptString3;
                                } else {
                                    int iOptInt18 = jSONObjectOptJSONObject5.optInt(str9);
                                    str5 = str9;
                                    String strOptString6 = jSONObjectOptJSONObject5.optString(DispatchConstants.PLATFORM);
                                    String strOptString7 = jSONObjectOptJSONObject5.optString(str10);
                                    int iOptInt19 = jSONObjectOptJSONObject5.optInt("frequency");
                                    str6 = str10;
                                    int iOptInt20 = jSONObjectOptJSONObject5.optInt("screenDirect", 1);
                                    int iOptInt21 = jSONObjectOptJSONObject5.optInt("renderType", 2);
                                    String strOptString8 = jSONObjectOptJSONObject5.optString("template", ADSuyiConfig.TemplateType.FLOW);
                                    String strOptString9 = jSONObjectOptJSONObject5.optString("adSize");
                                    String strOptString10 = jSONObjectOptJSONObject5.optString("placementId");
                                    int iOptInt22 = jSONObjectOptJSONObject5.optInt("skipShowTime", -1);
                                    int iOptInt23 = jSONObjectOptJSONObject5.optInt("splashHotAreaCtl", 0);
                                    boolean zOptBoolean2 = jSONObjectOptJSONObject5.optBoolean("bottom", false);
                                    int iOptInt24 = jSONObjectOptJSONObject5.optInt("contentSize", 1);
                                    str7 = strOptString3;
                                    double dOptDouble3 = jSONObjectOptJSONObject5.optDouble(MediationConstant.KEY_ECPM, 0.0d);
                                    int iOptInt25 = jSONObjectOptJSONObject5.optInt("requestRate", 100);
                                    boolean zOptBoolean3 = jSONObjectOptJSONObject5.optBoolean("headerBidding", false);
                                    String strOptString11 = jSONObjectOptJSONObject5.optString(str4);
                                    if (zOptBoolean3) {
                                        z2 = true;
                                    }
                                    if (!z3) {
                                        z3 = iOptInt19 > 0;
                                    }
                                    cn.admobiletop.adsuyi.a.g.d dVar = new cn.admobiletop.adsuyi.a.g.d(iOptInt18, strOptString6, strOptString7, iOptInt19, iOptInt21, strOptString8, iOptInt20, strOptString9, strOptString10, iOptInt22, iOptInt23, zOptBoolean2, iOptInt12, iOptInt24, zOptBoolean3, dOptDouble3, iOptInt25, strOptString11);
                                    if (ADSuyiAdType.TYPE_INNER_NOTICE.equals(strOptString4)) {
                                        dVar.a(jSONObjectOptJSONObject5.optLong("firstShowTime"));
                                        dVar.b(jSONObjectOptJSONObject5.optLong("intervalShowTime"));
                                    }
                                    arrayList.add(dVar);
                                }
                                i7++;
                                jSONArrayOptJSONArray7 = jSONArray2;
                                i6 = i5;
                                strOptString3 = str7;
                                str10 = str6;
                                str9 = str5;
                            }
                            str8 = str9;
                            str3 = str10;
                            eVar.b(z3);
                            eVar.a(z2);
                            eVar.a(arrayList);
                            map.put(strOptString3, eVar);
                            if (ADSuyiAdType.TYPE_INNER_NOTICE.equals(strOptString4)) {
                                aVar.a(eVar);
                            }
                        }
                    }
                    i6 = i5 + 1;
                    jSONArrayOptJSONArray6 = jSONArray;
                    str2 = str4;
                }
                aVar.b(map);
            }
            return aVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static List<cn.admobiletop.adsuyi.a.g.j> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String strOptString = jSONArray.optString(i2);
            if (!TextUtils.isEmpty(strOptString) && strOptString.contains("-")) {
                String[] strArrSplit = strOptString.split("-");
                if (strArrSplit.length >= 2) {
                    arrayList.add(new cn.admobiletop.adsuyi.a.g.j(strArrSplit[0], strArrSplit[1]));
                }
            }
        }
        return arrayList;
    }

    public static void b(JSONObject jSONObject, cn.admobiletop.adsuyi.a.g.a aVar, String str, boolean z) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("networkList");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return;
        }
        Map<String, ADSuyiPlatform> map = new HashMap<>(jSONArrayOptJSONArray.length());
        int i2 = 0;
        while (true) {
            if (i2 >= jSONArrayOptJSONArray.length()) {
                break;
            }
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString(DispatchConstants.PLATFORM);
                String strOptString2 = jSONObjectOptJSONObject.optString("appId");
                String strOptString3 = jSONObjectOptJSONObject.optString(Constants.KEY_APP_KEY);
                int iOptInt = jSONObjectOptJSONObject.optInt("priority", 0);
                cn.admobiletop.adsuyi.a.g.c cVar = new cn.admobiletop.adsuyi.a.g.c(strOptString, strOptString2, strOptString3, str);
                cVar.a(iOptInt);
                if (z) {
                    if ("tianmu".equals(strOptString)) {
                        map.put(strOptString, cVar);
                        break;
                    }
                } else {
                    map.put(strOptString, cVar);
                }
            }
            i2++;
        }
        if (aVar != null) {
            aVar.a(map);
        }
    }

    public static String a(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                String strA = cn.admobiletop.adsuyi.a.d.b.a(str);
                if (strA != null) {
                    return cn.admobiletop.adsuyi.a.d.a.a(str2, strA);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static List<String> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() != 0) {
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
