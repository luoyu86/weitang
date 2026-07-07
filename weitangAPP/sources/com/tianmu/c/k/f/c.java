package com.tianmu.c.k.f;

import android.os.Handler;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.tianmu.biz.utils.f;
import com.tianmu.biz.utils.n;
import com.tianmu.c.i.l;
import com.tianmu.config.TianmuErrorConfig;
import com.tianmu.utils.TianmuPackageUtil;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f11803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11804d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11805e = 2;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f11806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f11807b;

        public a(int i2, String str) {
            this.f11806a = i2;
            this.f11807b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.onFailed(this.f11806a, this.f11807b);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f11809a;

        public b(l lVar) {
            this.f11809a = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a(this.f11809a);
        }
    }

    public c(String str, String str2, Handler handler) {
        this.f11801a = str;
        this.f11802b = str2;
        this.f11803c = handler;
    }

    private void b(l lVar) {
        Handler handler = this.f11803c;
        if (handler == null || lVar == null) {
            return;
        }
        handler.post(new b(lVar));
    }

    public abstract void a(int i2, String str);

    public abstract void a(l lVar);

    @Override // com.tianmu.c.k.f.d
    public void a(String str, String str2) {
        com.tianmu.c.i.c cVarG;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("code");
            String strOptString = jSONObject.optString(Constants.SHARED_MESSAGE_ID_FILE);
            if (200 != iOptInt) {
                onRequestFailed(iOptInt, strOptString);
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                onRequestFailed(TianmuErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空");
                return;
            }
            JSONObject jSONObjectA = f.a();
            if (jSONObjectA != null) {
                jSONObjectOptJSONObject = jSONObjectA;
            }
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("ads");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
                    if (jSONObjectOptJSONObject2 != null && (cVarG = n.g(jSONObjectOptJSONObject2)) != null) {
                        arrayList.add(cVarG);
                        if (arrayList.size() == this.f11805e) {
                            break;
                        }
                    }
                }
                b(new l(jSONObjectOptJSONObject.optInt("bidPrice"), arrayList));
                return;
            }
            onRequestFailed(TianmuErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空");
        } catch (Exception e2) {
            e2.printStackTrace();
            onRequestFailed(-2012, "获取广告时发生未知异常");
        }
    }

    @Override // com.tianmu.c.k.f.d
    public boolean isMock() {
        return false;
    }

    public void onFailed(int i2, String str) {
        if (i2 != -1003 || this.f11804d <= 0 || TextUtils.isEmpty(this.f11801a)) {
            a(i2, str);
        } else {
            this.f11804d--;
            com.tianmu.c.b.a.a(this.f11801a, this.f11802b, this);
        }
    }

    @Override // com.tianmu.http.listener.SimpleHttpListener, com.tianmu.http.listener.HttpListener
    public final void onRequestFailed(int i2, String str) {
        if (TianmuPackageUtil.isMainThread()) {
            onFailed(i2, str);
            return;
        }
        Handler handler = this.f11803c;
        if (handler != null) {
            handler.post(new a(i2, str));
        }
    }
}
