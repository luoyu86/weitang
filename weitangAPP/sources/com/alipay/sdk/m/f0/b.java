package com.alipay.sdk.m.f0;

import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static c a(DataReportResult dataReportResult) {
        c cVar = new c();
        if (dataReportResult == null) {
            return null;
        }
        cVar.f5317a = dataReportResult.success;
        cVar.f5318b = dataReportResult.resultCode;
        Map<String, String> map = dataReportResult.resultData;
        if (map != null) {
            cVar.f5319c = map.get("apdid");
            cVar.f5320d = map.get("apdidToken");
            cVar.f5323g = map.get("dynamicKey");
            cVar.f5324h = map.get("timeInterval");
            cVar.f5325i = map.get("webrtcUrl");
            cVar.j = "";
            String str = map.get("drmSwitch");
            if (com.alipay.sdk.m.z.a.b(str)) {
                if (str.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str.charAt(0));
                    cVar.f5321e = sb.toString();
                }
                if (str.length() >= 3) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str.charAt(2));
                    cVar.f5322f = sb2.toString();
                }
            }
            if (map.containsKey("apse_degrade")) {
                cVar.k = map.get("apse_degrade");
            }
        }
        return cVar;
    }

    public static DataReportRequest a(d dVar) {
        DataReportRequest dataReportRequest = new DataReportRequest();
        if (dVar == null) {
            return null;
        }
        dataReportRequest.os = dVar.f5326a;
        dataReportRequest.rpcVersion = dVar.j;
        dataReportRequest.bizType = "1";
        HashMap map = new HashMap();
        dataReportRequest.bizData = map;
        map.put("apdid", dVar.f5327b);
        dataReportRequest.bizData.put("apdidToken", dVar.f5328c);
        dataReportRequest.bizData.put("umidToken", dVar.f5329d);
        dataReportRequest.bizData.put("dynamicKey", dVar.f5330e);
        dataReportRequest.deviceData = dVar.f5331f;
        return dataReportRequest;
    }
}
