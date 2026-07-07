package cn.admobiletop.adsuyi.ad.error;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.utl.BaseMonitor;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<ADSuyiErrorDesc> f3528e;

    public static class ADSuyiErrorDesc {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f3529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f3530b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3531c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f3532d;

        public ADSuyiErrorDesc(String str, String str2, int i2, String str3) {
            this.f3530b = str;
            this.f3529a = str2;
            this.f3531c = i2;
            this.f3532d = str3;
        }

        public int getCode() {
            return this.f3531c;
        }

        public String getError() {
            return this.f3532d;
        }

        public String getPlatform() {
            return this.f3530b;
        }

        public String getPlatformPosId() {
            return this.f3529a;
        }
    }

    public ADSuyiError() {
    }

    public static ADSuyiError createErrorDesc(String str, String str2, int i2, String str3) {
        ADSuyiError aDSuyiError = new ADSuyiError();
        aDSuyiError.setCode(-1);
        ADSuyiErrorDesc aDSuyiErrorDesc = new ADSuyiErrorDesc(str, str2, i2, str3);
        ArrayList arrayList = new ArrayList();
        aDSuyiError.f3528e = arrayList;
        arrayList.add(aDSuyiErrorDesc);
        return aDSuyiError;
    }

    public void appendDesc(ADSuyiError aDSuyiError) {
        List<ADSuyiErrorDesc> list;
        if (aDSuyiError == null || (list = aDSuyiError.f3528e) == null || list.size() <= 0) {
            return;
        }
        if (this.f3528e == null) {
            this.f3528e = new ArrayList();
        }
        this.f3528e.addAll(aDSuyiError.f3528e);
    }

    public String getAdType() {
        return this.f3526c;
    }

    public int getCode() {
        return this.f3524a;
    }

    public String getError() {
        return this.f3527d;
    }

    public String getPosId() {
        return this.f3525b;
    }

    public void release() {
        List<ADSuyiErrorDesc> list = this.f3528e;
        if (list != null) {
            list.clear();
            this.f3528e = null;
        }
    }

    public void setAdType(String str) {
        this.f3526c = str;
    }

    public void setCode(int i2) {
        this.f3524a = i2;
    }

    public void setDescList(List<ADSuyiErrorDesc> list) {
        this.f3528e = list;
    }

    public void setError(String str) {
        this.f3527d = str;
    }

    public void setPosId(String str) {
        this.f3525b = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("posId", this.f3525b);
            jSONObject.put("adType", this.f3526c);
            jSONObject.put("code", this.f3524a);
            jSONObject.put(BaseMonitor.COUNT_ERROR, this.f3527d);
            List<ADSuyiErrorDesc> list = this.f3528e;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < this.f3528e.size(); i2++) {
                    ADSuyiErrorDesc aDSuyiErrorDesc = this.f3528e.get(i2);
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

    public ADSuyiError(int i2, String str) {
        this.f3524a = i2;
        this.f3527d = str;
    }
}
