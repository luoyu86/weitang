package cn.admobiletop.adsuyi.a.a;

import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public static void a(List<i> list, String str, long j, String str2) {
        String strA = (list == null || list.size() <= 0) ? "" : a(list);
        HashMap map = new HashMap(4);
        map.put("adPositionId", str);
        map.put("groupId", Long.valueOf(j));
        map.put("sceneId", str2);
        map.put("events", strA);
        if (ADSuyiLogUtil.needShowLog()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adPositionId", str);
                jSONObject.put("groupId", j);
                jSONObject.put("sceneId", str2);
                jSONObject.put("events", strA);
                StringBuilder sb = new StringBuilder();
                sb.append("-------------- ReportBidApi ");
                sb.append(jSONObject.toString());
                sb.append(" --------------");
                ADSuyiLogUtil.d(sb.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        String string = b.f3174q;
        if (ADSuyiSdk.getInstance().getConfig() != null && ADSuyiSdk.getInstance().getConfig().isDebug()) {
            try {
                String strEncode = URLEncoder.encode(new String(new String(strA.getBytes("gbk"), "utf-8").getBytes("UTF-8")), "UTF-8");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append("?adPositionId=");
                sb2.append(str);
                sb2.append("&groupId=");
                sb2.append(j);
                sb2.append("&sceneId=");
                sb2.append(str2);
                sb2.append("&events=");
                sb2.append(strEncode);
                string = sb2.toString();
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
            }
        }
        cn.admobiletop.adsuyi.a.h.d.c().a(string, map, null, new g());
    }

    public static String a(List<i> list) {
        try {
            JSONArray jSONArray = new JSONArray();
            for (i iVar : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(iVar.b(), iVar.d());
                jSONObject.put(iVar.a(), iVar.c());
                jSONObject.put(iVar.f(), iVar.e());
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
