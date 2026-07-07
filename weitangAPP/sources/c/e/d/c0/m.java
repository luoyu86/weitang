package c.e.d.c0;

import android.app.Activity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.chinavisionary.framework.mobile.payment.WxPayBaseCloudDto;
import com.chinavisionary.paymentlibrary.vo.EventWxPayResult;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import g.b.a.r;

/* JADX INFO: loaded from: classes2.dex */
public class m extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IWXAPI f2299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2300d;

    public m(Activity activity) {
        super(activity);
        this.f2300d = false;
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(this.f2291a, "wx566d59045c104e04");
        this.f2299c = iwxapiCreateWXAPI;
        iwxapiCreateWXAPI.registerApp("wx566d59045c104e04");
        if (g.b.a.c.getDefault().isRegistered(this)) {
            return;
        }
        g.b.a.c.getDefault().register(this);
    }

    public final PayReq f(WxPayBaseCloudDto wxPayBaseCloudDto) {
        PayReq payReq = new PayReq();
        payReq.appId = "wx566d59045c104e04";
        payReq.partnerId = wxPayBaseCloudDto.getPartnerId();
        payReq.prepayId = wxPayBaseCloudDto.getPrepayId();
        payReq.packageValue = wxPayBaseCloudDto.getWxPackage();
        payReq.nonceStr = wxPayBaseCloudDto.getNonceStr();
        payReq.timeStamp = String.valueOf(wxPayBaseCloudDto.getTimeStamp());
        payReq.sign = wxPayBaseCloudDto.getSign();
        return payReq;
    }

    public final void g(String str) {
        try {
            this.f2300d = false;
            this.f2299c.sendReq(f((WxPayBaseCloudDto) JSON.parseObject(str, WxPayBaseCloudDto.class)));
        } catch (JSONException e2) {
            e2.printStackTrace();
            d();
        }
    }

    @Override // c.e.d.c0.d
    public void recycler() {
        super.recycler();
        if (g.b.a.c.getDefault().isRegistered(this)) {
            g.b.a.c.getDefault().unregister(this);
        }
    }

    @Override // c.e.d.c0.d
    public void requestPay(String str) {
        g(str);
    }

    @g.b.a.m(threadMode = r.MAIN)
    public void wxPayResult(EventWxPayResult eventWxPayResult) {
        if (eventWxPayResult.getIsPaySuccess()) {
            c();
        } else {
            if (this.f2300d) {
                return;
            }
            this.f2300d = true;
            b(a(eventWxPayResult.getMsg()));
        }
    }
}
