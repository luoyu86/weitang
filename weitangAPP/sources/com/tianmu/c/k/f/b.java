package com.tianmu.c.k.f;

import android.os.Handler;
import com.taobao.accs.common.Constants;
import com.tianmu.biz.utils.n;
import com.tianmu.config.TianmuErrorConfig;
import com.tianmu.utils.TianmuPackageUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f11794a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f11795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f11796b;

        public a(int i2, String str) {
            this.f11795a = i2;
            this.f11796b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f11795a, this.f11796b);
        }
    }

    /* JADX INFO: renamed from: com.tianmu.c.k.f.b$b, reason: collision with other inner class name */
    public class RunnableC0212b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tianmu.c.i.b f11798a;

        public RunnableC0212b(com.tianmu.c.i.b bVar) {
            this.f11798a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f11798a);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a();
        }
    }

    public b(Handler handler) {
        this.f11794a = handler;
    }

    private void b(com.tianmu.c.i.b bVar) {
        Handler handler = this.f11794a;
        if (handler == null || bVar == null) {
            return;
        }
        handler.post(new RunnableC0212b(bVar));
    }

    public abstract void a();

    public abstract void a(int i2, String str);

    public abstract void a(com.tianmu.c.i.b bVar);

    @Override // com.tianmu.c.k.f.d
    public void a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("code");
            String strOptString = jSONObject.optString(Constants.SHARED_MESSAGE_ID_FILE);
            if (200 != iOptInt) {
                com.tianmu.biz.utils.a.b(null);
                onRequestFailed(iOptInt, strOptString);
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                onRequestFailed(TianmuErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空");
                return;
            }
            boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("updated");
            String strOptString2 = jSONObjectOptJSONObject.optString("tag");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("detail");
            if (!zOptBoolean) {
                b();
                return;
            }
            com.tianmu.c.i.b bVarF = n.f(jSONObjectOptJSONObject2);
            if (bVarF == null) {
                com.tianmu.biz.utils.a.a();
                onRequestFailed(TianmuErrorConfig.AD_RESULT_PARSE_FAILED, TianmuErrorConfig.MSG_AD_RESULT_PARSE_FAILED);
            } else {
                b(bVarF);
                com.tianmu.biz.utils.a.a(strOptString2);
                com.tianmu.biz.utils.a.a(jSONObjectOptJSONObject2, str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            com.tianmu.biz.utils.a.a();
            onRequestFailed(-2012, "获取广告时发生未知异常");
        }
    }

    @Override // com.tianmu.http.listener.SimpleHttpListener, com.tianmu.http.listener.HttpListener
    public final void onRequestFailed(int i2, String str) {
        if (TianmuPackageUtil.isMainThread()) {
            a(i2, str);
            return;
        }
        Handler handler = this.f11794a;
        if (handler != null) {
            handler.post(new a(i2, str));
        }
    }

    private void b() {
        Handler handler = this.f11794a;
        if (handler != null) {
            handler.post(new c());
        }
    }
}
