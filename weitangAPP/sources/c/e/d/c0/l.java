package c.e.d.c0;

import android.app.Activity;
import c.e.a.d.q;
import com.chinavisionary.paymentlibrary.vo.EventWxMiniProgramPayResult;
import com.chinavisionary.paymentlibrary.vo.WXminiiPorgramePayRequestParamVo;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import g.b.a.r;

/* JADX INFO: loaded from: classes2.dex */
public class l extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IWXAPI f2297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2298d;

    public l(Activity activity) {
        super(activity);
        this.f2298d = false;
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(this.f2291a, "wx566d59045c104e04");
        this.f2297c = iwxapiCreateWXAPI;
        iwxapiCreateWXAPI.registerApp("wx566d59045c104e04");
        if (g.b.a.c.getDefault().isRegistered(this)) {
            return;
        }
        g.b.a.c.getDefault().register(this);
    }

    public final void f(String str) {
        try {
            this.f2298d = false;
            WXminiiPorgramePayRequestParamVo wXminiiPorgramePayRequestParamVo = new WXminiiPorgramePayRequestParamVo();
            wXminiiPorgramePayRequestParamVo.setToken(c.e.a.a.b.getInstance().getToken());
            wXminiiPorgramePayRequestParamVo.setPayId(str);
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = "gh_45a49016c54f";
            req.path = "pages/order/index?token=" + wXminiiPorgramePayRequestParamVo.getToken() + "&payId=" + wXminiiPorgramePayRequestParamVo.getPayId() + "&type=" + c.e.a.d.j.getInstance().f1216b;
            if (c.e.a.a.a.getInstance().isDebug()) {
                req.miniprogramType = 2;
            } else {
                req.miniprogramType = 0;
            }
            q.d(getClass().getSimpleName(), "requestWxPay req.path = " + req.path);
            this.f2297c.sendReq(req);
        } catch (Exception e2) {
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
        f(str);
    }

    @g.b.a.m(threadMode = r.MAIN)
    public void wxPayResult(EventWxMiniProgramPayResult eventWxMiniProgramPayResult) {
        if (eventWxMiniProgramPayResult.getIsPaySuccess()) {
            c();
        } else {
            if (this.f2298d) {
                return;
            }
            this.f2298d = true;
            b(a(eventWxMiniProgramPayResult.getMsg()));
        }
    }
}
