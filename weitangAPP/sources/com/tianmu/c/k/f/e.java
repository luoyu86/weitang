package com.tianmu.c.k.f;

import android.os.Handler;
import com.taobao.accs.common.Constants;
import com.tianmu.biz.utils.n;
import com.tianmu.biz.utils.u;
import com.tianmu.c.i.k;
import com.tianmu.config.TianmuErrorConfig;
import com.tianmu.utils.TianmuPackageUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f11815b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f11816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f11817b;

        public a(int i2, String str) {
            this.f11816a = i2;
            this.f11817b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            eVar.a(eVar.f11814a, this.f11816a, this.f11817b);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f11819a;

        public b(k kVar) {
            this.f11819a = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.a(this.f11819a);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.a();
        }
    }

    public e(Handler handler) {
        this.f11815b = handler;
    }

    private void b(k kVar) {
        Handler handler = this.f11815b;
        if (handler == null || kVar == null) {
            return;
        }
        handler.post(new b(kVar));
    }

    public abstract void a();

    public abstract void a(k kVar);

    public abstract void a(boolean z, int i2, String str);

    @Override // com.tianmu.http.listener.SimpleHttpListener, com.tianmu.http.listener.HttpListener
    public final void onRequestFailed(int i2, String str) {
        if (TianmuPackageUtil.isMainThread()) {
            a(this.f11814a, i2, str);
            return;
        }
        Handler handler = this.f11815b;
        if (handler != null) {
            handler.post(new a(i2, str));
        }
    }

    @Override // com.tianmu.c.k.f.d
    public void a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("code");
            String strOptString = jSONObject.optString(Constants.SHARED_MESSAGE_ID_FILE);
            if (200 != iOptInt) {
                this.f11814a = true;
                u.b(null);
                onRequestFailed(iOptInt, strOptString);
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                onRequestFailed(TianmuErrorConfig.INIT_DATA_IS_NULL, "请求的初始化数据为空");
                return;
            }
            boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("updated");
            String strOptString2 = jSONObjectOptJSONObject.optString("tag");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("detail");
            if (!zOptBoolean) {
                b();
                return;
            }
            k kVarA = n.a(jSONObjectOptJSONObject2, false);
            if (kVarA == null) {
                u.a();
                onRequestFailed(TianmuErrorConfig.INIT_RESULT_PARSE_FAILED, "初始化接口数据解析失败");
            } else {
                u.a(strOptString2);
                b(kVarA);
                u.a(jSONObjectOptJSONObject2, str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a();
            onRequestFailed(TianmuErrorConfig.INIT_RESULT_PARSE_FAILED, "初始化接口数据解析失败");
        }
    }

    private void b() {
        Handler handler = this.f11815b;
        if (handler != null) {
            handler.post(new c());
        }
    }
}
