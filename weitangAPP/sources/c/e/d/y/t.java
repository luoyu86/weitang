package c.e.d.y;

import android.view.View;
import c.e.a.d.x;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.event.EventUpdateUserInfoVo;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.paymentlibrary.model.BillModel;
import com.chinavisionary.paymentlibrary.vo.H5CreatePayBillBo;
import com.chinavisionary.paymentlibrary.vo.PayBillVo;
import com.chinavisionary.paymentlibrary.vo.PayTypeVo;
import com.chinavisionary.paymentlibrary.vo.RechargeWaterEleVo;

/* JADX INFO: loaded from: classes2.dex */
public class t extends l {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2358h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2359i;

    public t(View view, BillModel billModel, o oVar) {
        super(view, billModel, oVar);
    }

    @Override // c.e.d.y.l
    public void handlePayFailed() {
        l();
    }

    @Override // c.e.d.y.l
    public void handlePaySuccessResult() {
        EventUpdateUserInfoVo eventUpdateUserInfoVo = new EventUpdateUserInfoVo();
        eventUpdateUserInfoVo.setWhatMsg(2);
        g.b.a.c.getDefault().post(eventUpdateUserInfoVo);
        l();
    }

    @Override // c.e.d.y.l
    public void initData(BaseVo baseVo) {
        if (baseVo instanceof PayTypeVo) {
            this.f2359i = ((PayTypeVo) baseVo).getType();
        }
    }

    public final void l() {
        a(true);
        if (this.f2358h || this.f2359i == 7) {
            return;
        }
        e(1);
    }

    @Override // c.e.d.y.l
    public void requestGetPaySign(BaseVo baseVo, int i2) {
        if (baseVo == null) {
            b();
            return;
        }
        if (!(baseVo instanceof PayTypeVo)) {
            b();
            return;
        }
        PayTypeVo payTypeVo = (PayTypeVo) baseVo;
        String extJson = payTypeVo.getExtJson();
        this.f2358h = payTypeVo.isBill();
        if (payTypeVo.isBill() || payTypeVo.isRetryPay()) {
            PayBillVo payBillVo = (PayBillVo) JSON.parseObject(extJson, PayBillVo.class);
            payBillVo.setPayChannel(i2);
            if (this.f2341f != null) {
                H5CreatePayBillBo h5CreatePayBillBo = new H5CreatePayBillBo();
                h5CreatePayBillBo.setPayType(Integer.valueOf(i2));
                h5CreatePayBillBo.setOrderId(payBillVo.getPaymentKey());
                payBillVo.setCreatePayBillBo(h5CreatePayBillBo);
                this.f2341f.postPayBill(payBillVo);
                return;
            }
            return;
        }
        RechargeWaterEleVo rechargeWaterEleVo = (RechargeWaterEleVo) new c.i.b.f().fromJson(extJson, RechargeWaterEleVo.class);
        rechargeWaterEleVo.setPayChannel(i2);
        if (!c.e.a.a.a.getInstance().isJHModel()) {
            this.f2340e.postPayWaterEle(rechargeWaterEleVo);
            return;
        }
        String extJson2 = payTypeVo.getExtJson();
        if (!x.isNotNull(extJson2)) {
            this.f2341f.postPayWaterEle(rechargeWaterEleVo);
            return;
        }
        PayBillVo payBillVo2 = (PayBillVo) JSON.parseObject(extJson2, PayBillVo.class);
        payBillVo2.setPayChannel(i2);
        if (x.isNotNull(payBillVo2.getPaymentKey())) {
            this.f2341f.postPayBill(payBillVo2);
        } else {
            this.f2341f.postPayWaterEle(rechargeWaterEleVo);
        }
    }
}
