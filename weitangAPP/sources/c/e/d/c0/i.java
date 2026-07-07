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
public class i extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IWXAPI f2295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2296d;

    public i(Activity activity) {
        super(activity);
        this.f2296d = false;
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(this.f2291a, "wx566d59045c104e04");
        this.f2295c = iwxapiCreateWXAPI;
        iwxapiCreateWXAPI.registerApp("wx566d59045c104e04");
        if (g.b.a.c.getDefault().isRegistered(this)) {
            return;
        }
        g.b.a.c.getDefault().register(this);
    }

    public final void f(String str) {
        try {
            this.f2296d = false;
            WXminiiPorgramePayRequestParamVo wXminiiPorgramePayRequestParamVo = new WXminiiPorgramePayRequestParamVo();
            wXminiiPorgramePayRequestParamVo.setToken(c.e.a.a.b.getInstance().getToken());
            wXminiiPorgramePayRequestParamVo.setPayId(str);
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = "gh_e64a1a89a0ad";
            req.path = str;
            q.d(getClass().getSimpleName(), "requestTlWxPay req.path = " + req.path);
            this.f2295c.sendReq(req);
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
            if (this.f2296d) {
                return;
            }
            this.f2296d = true;
            b(a(eventWxMiniProgramPayResult.getMsg()));
        }
    }
}
