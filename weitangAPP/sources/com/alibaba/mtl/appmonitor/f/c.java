package com.alibaba.mtl.appmonitor.f;

import com.alibaba.mtl.appmonitor.SdkMeta;
import com.alibaba.mtl.appmonitor.a.d;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.a.h;
import com.alibaba.mtl.appmonitor.model.UTDimensionValueSet;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.model.LogField;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a(UTDimensionValueSet uTDimensionValueSet, d dVar) {
        Integer eventId = uTDimensionValueSet.getEventId();
        if (eventId != null) {
            f fVarA = f.a(eventId.intValue());
            h hVar = (h) com.alibaba.mtl.appmonitor.c.a.a().a(h.class, new Object[0]);
            hVar.f4488e = 6699;
            if (uTDimensionValueSet.getMap() != null) {
                hVar.m.putAll(uTDimensionValueSet.getMap());
            }
            HashMap map = new HashMap();
            map.put(TTDownloadField.TT_META, SdkMeta.getSDKMetaData());
            map.put("_event_id", eventId);
            com.alibaba.mtl.appmonitor.c.d dVar2 = (com.alibaba.mtl.appmonitor.c.d) com.alibaba.mtl.appmonitor.c.a.a().a(com.alibaba.mtl.appmonitor.c.d.class, new Object[0]);
            dVar2.put(dVar.a());
            com.alibaba.mtl.appmonitor.c.a.a().a(dVar);
            map.put("data", dVar2);
            hVar.m.put(fVarA.m20a(), new JSONObject(map).toString());
            hVar.m.put(LogField.EVENTID.toString(), String.valueOf(6699));
            b(hVar);
            com.alibaba.mtl.appmonitor.c.a.a().a(dVar2);
        }
    }

    public static void b(Map<UTDimensionValueSet, List<d>> map) {
        Integer eventId;
        for (Map.Entry<UTDimensionValueSet, List<d>> entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            UTDimensionValueSet key = entry.getKey();
            List<d> value = entry.getValue();
            if (value.size() != 0 && (eventId = key.getEventId()) != null) {
                f fVarA = f.a(eventId.intValue());
                int i2 = 0;
                h hVar = (h) com.alibaba.mtl.appmonitor.c.a.a().a(h.class, new Object[0]);
                hVar.f4488e = eventId.intValue();
                if (key.getMap() != null) {
                    hVar.m.putAll(key.getMap());
                }
                HashMap map2 = new HashMap();
                map2.put(TTDownloadField.TT_META, SdkMeta.getSDKMetaData());
                com.alibaba.mtl.appmonitor.c.d dVar = (com.alibaba.mtl.appmonitor.c.d) com.alibaba.mtl.appmonitor.c.a.a().a(com.alibaba.mtl.appmonitor.c.d.class, new Object[0]);
                for (d dVar2 : value) {
                    dVar.put(dVar2.a());
                    if (i2 == 0) {
                        sb.append(dVar2.o);
                        sb2.append(dVar2.p);
                    } else {
                        sb.append(",");
                        sb.append(dVar2.o);
                        sb2.append(",");
                        sb2.append(dVar2.p);
                    }
                    i2++;
                    com.alibaba.mtl.appmonitor.c.a.a().a(dVar2);
                }
                map2.put("data", dVar);
                hVar.m.put(fVarA.m20a(), new JSONObject(map2).toString());
                String string = sb.toString();
                String string2 = sb2.toString();
                hVar.m.put(LogField.ARG1.toString(), string);
                hVar.m.put(LogField.ARG2.toString(), string2);
                hVar.v = string;
                hVar.w = string2;
                b(hVar);
                com.alibaba.mtl.appmonitor.c.a.a().a(dVar);
            }
            com.alibaba.mtl.appmonitor.c.a.a().a(key);
        }
    }

    public static void a(h hVar) {
        if (hVar == null) {
            return;
        }
        com.alibaba.mtl.log.a.a(hVar.u, String.valueOf(hVar.f4488e), hVar.v, hVar.w, hVar.x, hVar.m);
        com.alibaba.mtl.appmonitor.c.a.a().a(hVar);
    }

    public static void b(h hVar) {
        i.a("UTUtil", "upload without flowback. args:", hVar.m);
        com.alibaba.mtl.appmonitor.e.a.a().a(hVar.m);
        com.alibaba.mtl.appmonitor.c.a.a().a(hVar);
    }
}
