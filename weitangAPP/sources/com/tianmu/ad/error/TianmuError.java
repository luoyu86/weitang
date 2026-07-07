package com.tianmu.ad.error;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.utl.BaseMonitor;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TianmuError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f10681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<ADSuyiErrorDesc> f10682e;

    public static class ADSuyiErrorDesc {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f10683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f10684b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f10685c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f10686d;

        public ADSuyiErrorDesc(String str, String str2, int i2, String str3) {
            this.f10684b = str;
            this.f10683a = str2;
            this.f10685c = i2;
            this.f10686d = str3;
        }

        public int getCode() {
            return this.f10685c;
        }

        public String getError() {
            return this.f10686d;
        }

        public String getPlatform() {
            return this.f10684b;
        }

        public String getPlatformPosId() {
            return this.f10683a;
        }
    }

    public TianmuError() {
    }

    public static TianmuError createErrorDesc(String str, String str2, int i2, String str3) {
        TianmuError tianmuError = new TianmuError();
        tianmuError.setCode(-1);
        ADSuyiErrorDesc aDSuyiErrorDesc = new ADSuyiErrorDesc(str, str2, i2, str3);
        ArrayList arrayList = new ArrayList();
        tianmuError.f10682e = arrayList;
        arrayList.add(aDSuyiErrorDesc);
        return tianmuError;
    }

    public void appendDesc(TianmuError tianmuError) {
        List<ADSuyiErrorDesc> list;
        if (tianmuError == null || (list = tianmuError.f10682e) == null || list.size() <= 0) {
            return;
        }
        if (this.f10682e == null) {
            this.f10682e = new ArrayList();
        }
        this.f10682e.addAll(tianmuError.f10682e);
    }

    public int getCode() {
        return this.f10678a;
    }

    public String getError() {
        return this.f10681d;
    }

    public void release() {
        List<ADSuyiErrorDesc> list = this.f10682e;
        if (list != null) {
            list.clear();
            this.f10682e = null;
        }
    }

    public void setAdType(String str) {
        this.f10680c = str;
    }

    public void setCode(int i2) {
        this.f10678a = i2;
    }

    public void setDescList(List<ADSuyiErrorDesc> list) {
        this.f10682e = list;
    }

    public void setError(String str) {
        this.f10681d = str;
    }

    public void setPosId(String str) {
        this.f10679b = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("posId", this.f10679b);
            jSONObject.put("adType", this.f10680c);
            jSONObject.put("code", this.f10678a);
            jSONObject.put(BaseMonitor.COUNT_ERROR, this.f10681d);
            List<ADSuyiErrorDesc> list = this.f10682e;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < this.f10682e.size(); i2++) {
                    ADSuyiErrorDesc aDSuyiErrorDesc = this.f10682e.get(i2);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(DispatchConstants.PLATFORM, aDSuyiErrorDesc.getPlatform());
                    jSONObject2.put("platformPosId", aDSuyiErrorDesc.getPlatformPosId());
                    jSONObject2.put("code", aDSuyiErrorDesc.getCode());
                    jSONObject2.put(BaseMonitor.COUNT_ERROR, aDSuyiErrorDesc.getError());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("descList", jSONArray);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public TianmuError(int i2, String str) {
        this.f10678a = i2;
        this.f10681d = str;
    }
}
