package cn.admobiletop.adsuyi.a.a;

import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.tsplugin.adapter.AdEventPluginAdapter;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public static void a(String str, String str2, int i2, String str3, ADSuyiPlatformPosId aDSuyiPlatformPosId, long j) {
        a(str, str2, i2, str3, aDSuyiPlatformPosId, 0, j, "");
    }

    public static void a(String str, String str2, int i2, String str3, ADSuyiPlatformPosId aDSuyiPlatformPosId, long j, String str4) {
        a(str, str2, i2, str3, aDSuyiPlatformPosId, 0, j, str4);
    }

    public static void a(String str, String str2, int i2, String str3, ADSuyiPlatformPosId aDSuyiPlatformPosId, int i3, long j, String str4) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        HashMap map;
        String str5;
        String appId = ADSuyiSdk.getInstance().getAppId();
        if (TextUtils.isEmpty(appId) || aDSuyiPlatformPosId == null) {
            return;
        }
        HashMap map2 = new HashMap(7);
        map2.put("appId", appId);
        map2.put("platformAdPosUniqueId", Long.valueOf(aDSuyiPlatformPosId.getId()));
        map2.put("number", Integer.valueOf(i2));
        map2.put("optimize", Integer.valueOf(i3));
        map2.put("groupId", Long.valueOf(j));
        map2.put("sceneId", str4);
        String platform = aDSuyiPlatformPosId.getPlatform();
        if (ADSuyiLogUtil.needShowLog()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", appId);
                jSONObject.put("posId", str2);
                jSONObject.put(DispatchConstants.PLATFORM, platform);
                jSONObject.put("platformPosId", aDSuyiPlatformPosId.getPlatformPosId());
                jSONObject.put("event", str);
                jSONObject.put("adType", str3);
                jSONObject.put("number", i2);
                jSONObject.put("groupId", j);
                jSONObject.put("sceneId", str4);
                obj = "event";
                try {
                    jSONObject.put("platformAdPosUniqueId", aDSuyiPlatformPosId.getId());
                    StringBuilder sb = new StringBuilder();
                    sb.append("--------------  AdSourceReport : ");
                    sb.append(jSONObject.toString());
                    sb.append(" --------------");
                    ADSuyiLogUtil.d(sb.toString());
                    AdEventPluginAdapter adEventPluginAdapter = AdEventPluginAdapter.getInstance();
                    String platformPosId = aDSuyiPlatformPosId.getPlatformPosId();
                    long id = aDSuyiPlatformPosId.getId();
                    obj2 = DispatchConstants.PLATFORM;
                    obj3 = "sceneId";
                    obj5 = "groupId";
                    map = map2;
                    str5 = platform;
                    obj4 = "adType";
                    try {
                        adEventPluginAdapter.addReportInfo(appId, str2, platform, platformPosId, str, str3, i2, j, str4, id);
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                } catch (Exception e3) {
                    e = e3;
                    obj2 = DispatchConstants.PLATFORM;
                    obj3 = "sceneId";
                    obj4 = "adType";
                    obj5 = "groupId";
                    map = map2;
                    str5 = platform;
                    e.printStackTrace();
                    HashMap map3 = new HashMap(1);
                    map3.put(obj4, str3);
                    map3.put(obj, str);
                    String str6 = str5;
                    map3.put(obj2, str6);
                    map3.put(obj5, Long.valueOf(j));
                    map3.put(obj3, str4);
                    cn.admobiletop.adsuyi.a.h.d.c().a(b.n + "?adType=" + str3 + "&event=" + str + "&platform=" + str6 + "&groupId=" + j + "&sceneId=" + str4, map, map3, null);
                }
            } catch (Exception e4) {
                e = e4;
                obj = "event";
            }
        } else {
            obj = "event";
            obj2 = DispatchConstants.PLATFORM;
            obj3 = "sceneId";
            obj4 = "adType";
            obj5 = "groupId";
            map = map2;
            str5 = platform;
        }
        HashMap map32 = new HashMap(1);
        map32.put(obj4, str3);
        map32.put(obj, str);
        String str62 = str5;
        map32.put(obj2, str62);
        map32.put(obj5, Long.valueOf(j));
        map32.put(obj3, str4);
        cn.admobiletop.adsuyi.a.h.d.c().a(b.n + "?adType=" + str3 + "&event=" + str + "&platform=" + str62 + "&groupId=" + j + "&sceneId=" + str4, map, map32, null);
    }
}
