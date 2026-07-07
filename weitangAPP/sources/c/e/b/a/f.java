package c.e.b.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f1255e;

    public static List<f> toArrayList(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                f fVar = new f();
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                fVar.setHandlerName(jSONObject.has("handlerName") ? jSONObject.getString("handlerName") : null);
                fVar.setCallbackId(jSONObject.has("callbackId") ? jSONObject.getString("callbackId") : null);
                fVar.setResponseData(jSONObject.has("responseData") ? jSONObject.getString("responseData") : null);
                fVar.setResponseId(jSONObject.has("responseId") ? jSONObject.getString("responseId") : null);
                fVar.setData(jSONObject.has("data") ? jSONObject.getString("data") : null);
                arrayList.add(fVar);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public static f toObject(String str) {
        f fVar = new f();
        try {
            JSONObject jSONObject = new JSONObject(str);
            fVar.setHandlerName(jSONObject.has("handlerName") ? jSONObject.getString("handlerName") : null);
            fVar.setCallbackId(jSONObject.has("callbackId") ? jSONObject.getString("callbackId") : null);
            fVar.setResponseData(jSONObject.has("responseData") ? jSONObject.getString("responseData") : null);
            fVar.setResponseId(jSONObject.has("responseId") ? jSONObject.getString("responseId") : null);
            fVar.setData(jSONObject.has("data") ? jSONObject.getString("data") : null);
            return fVar;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return fVar;
        }
    }

    public String getCallbackId() {
        return this.f1251a;
    }

    public String getData() {
        return this.f1254d;
    }

    public String getHandlerName() {
        return this.f1255e;
    }

    public String getResponseData() {
        return this.f1253c;
    }

    public String getResponseId() {
        return this.f1252b;
    }

    public void setCallbackId(String str) {
        this.f1251a = str;
    }

    public void setData(String str) {
        this.f1254d = str;
    }

    public void setHandlerName(String str) {
        this.f1255e = str;
    }

    public void setResponseData(String str) {
        this.f1253c = str;
    }

    public void setResponseId(String str) {
        this.f1252b = str;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("callbackId", getCallbackId());
            jSONObject.put("data", getData());
            jSONObject.put("handlerName", getHandlerName());
            String responseData = getResponseData();
            if (TextUtils.isEmpty(responseData)) {
                jSONObject.put("responseData", responseData);
            } else {
                jSONObject.put("responseData", new JSONTokener(responseData).nextValue());
            }
            jSONObject.put("responseData", getResponseData());
            jSONObject.put("responseId", getResponseId());
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
