package com.chinavisionary.microtang.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import c.e.a.d.q;
import c.e.a.d.x;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.microtang.R;
import com.chinavisionary.paymentlibrary.vo.EventWxPayResult;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mm.opensdk.utils.ILog;
import g.b.a.c;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IWXAPI f8723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f8724b;

    public class a implements ILog {
        public a() {
        }

        @Override // com.tencent.mm.opensdk.utils.ILog
        public void d(String str, String str2) {
            q.v(a.class.getSimpleName(), "s:" + str + ",s1" + str2);
        }

        @Override // com.tencent.mm.opensdk.utils.ILog
        public void e(String str, String str2) {
            q.e(a.class.getSimpleName(), "s:" + str + ",s1" + str2);
        }

        @Override // com.tencent.mm.opensdk.utils.ILog
        public void i(String str, String str2) {
            q.i(a.class.getSimpleName(), "s:" + str + ",s1" + str2);
        }

        @Override // com.tencent.mm.opensdk.utils.ILog
        public void v(String str, String str2) {
            q.v(a.class.getSimpleName(), "s:" + str + ",s1" + str2);
        }

        @Override // com.tencent.mm.opensdk.utils.ILog
        public void w(String str, String str2) {
            q.d(a.class.getSimpleName(), "s:" + str + ",s1" + str2);
        }
    }

    public static class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<Activity> f8726a;

        public b(Activity activity) {
            this.f8726a = new WeakReference<>(activity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            WXPayEntryActivity wXPayEntryActivity = (WXPayEntryActivity) this.f8726a.get();
            if (wXPayEntryActivity != null) {
                wXPayEntryActivity.a(message);
            }
        }

        public void recycler() {
            this.f8726a.get();
            this.f8726a.clear();
        }
    }

    public void a(Message message) {
        int i2 = message.what;
        if (i2 == -2) {
            b(false, x.getString(R.string.tip_pay_cancel));
        } else if (i2 == -1) {
            b(false, x.getString(R.string.tip_pay_failed));
        } else if (i2 == 0) {
            b(true, x.getString(R.string.tip_pay_success));
            finish();
        }
        finish();
    }

    public final void b(boolean z, String str) {
        EventWxPayResult eventWxPayResult = new EventWxPayResult();
        eventWxPayResult.setIsPaySuccess(z);
        eventWxPayResult.setMsg(str);
        c.getDefault().post(eventWxPayResult);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(this, "wx566d59045c104e04");
        this.f8723a = iwxapiCreateWXAPI;
        boolean zHandleIntent = iwxapiCreateWXAPI.handleIntent(getIntent(), this);
        q.d(getClass().getSimpleName(), "isSuccess : " + zHandleIntent);
        this.f8723a.setLogImpl(new a());
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b bVar = this.f8724b;
        if (bVar != null) {
            bVar.recycler();
            this.f8724b = null;
        }
        this.f8723a = null;
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        boolean zHandleIntent = this.f8723a.handleIntent(intent, this);
        q.d(getClass().getSimpleName(), "onNewIntent isSuccess : " + zHandleIntent);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        q.d(getClass().getSimpleName(), "req:" + JSON.toJSONString(baseReq));
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        PayResp payResp = (PayResp) baseResp;
        q.d("onResp", "onPayFinish, payResp.errCode = " + payResp.errCode);
        if (baseResp.getType() == 5) {
            if (this.f8724b == null) {
                this.f8724b = new b(this);
                q.d("onResp", "mBaseHandler is null.");
            }
            this.f8724b.obtainMessage(payResp.errCode, payResp.errStr).sendToTarget();
        }
    }
}
