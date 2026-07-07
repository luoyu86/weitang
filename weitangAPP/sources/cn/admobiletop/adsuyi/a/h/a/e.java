package cn.admobiletop.adsuyi.a.h.a;

import android.os.Handler;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import cn.admobiletop.adsuyi.util.ADSuyiPackageUtil;
import com.taobao.accs.common.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f3331c;

    public e(String str, Handler handler) {
        this.f3329a = str;
        this.f3331c = handler;
    }

    @Override // cn.admobiletop.adsuyi.a.h.a.b
    public void c(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("code");
            String strOptString = jSONObject.optString(Constants.SHARED_MESSAGE_ID_FILE);
            if (200 != iOptInt) {
                this.f3330b = true;
                cn.admobiletop.adsuyi.a.m.h.b(null);
                onRequestFailed(iOptInt, strOptString);
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                onRequestFailed(ADSuyiErrorConfig.INIT_DATA_IS_NULL, "请求的初始化数据为空");
                return;
            }
            jSONObjectOptJSONObject.put("updateTime", cn.admobiletop.adsuyi.a.m.e.a());
            cn.admobiletop.adsuyi.a.g.a aVarA = cn.admobiletop.adsuyi.a.m.d.a(this.f3329a, jSONObjectOptJSONObject, false);
            if (aVarA == null) {
                onRequestFailed(ADSuyiErrorConfig.INIT_RESULT_PARSE_FAILED, "初始化接口数据解析失败");
            } else {
                h(aVarA);
                cn.admobiletop.adsuyi.a.m.h.a(jSONObjectOptJSONObject, str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            onRequestFailed(ADSuyiErrorConfig.INIT_RESULT_PARSE_FAILED, "初始化接口数据解析失败");
        }
    }

    public abstract void e(cn.admobiletop.adsuyi.a.g.a aVar);

    public abstract void f(boolean z, int i2, String str);

    public final void h(cn.admobiletop.adsuyi.a.g.a aVar) {
        Handler handler = this.f3331c;
        if (handler == null || aVar == null) {
            return;
        }
        handler.post(new d(this, aVar));
    }

    @Override // com.ciba.http.listener.SimpleHttpListener, com.ciba.http.listener.HttpListener
    public final void onRequestFailed(int i2, String str) {
        if (ADSuyiPackageUtil.isMainThread()) {
            f(this.f3330b, i2, str);
            return;
        }
        Handler handler = this.f3331c;
        if (handler != null) {
            handler.post(new c(this, i2, str));
        }
    }
}
