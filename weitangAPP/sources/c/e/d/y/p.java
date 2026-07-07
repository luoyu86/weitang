package c.e.d.y;

import android.view.View;
import c.e.a.d.x;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.event.EventProductPayVo;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.paymentlibrary.model.BillModel;
import com.chinavisionary.paymentlibrary.vo.CreateCleanOrderVo;
import com.chinavisionary.paymentlibrary.vo.CreateIncrementOrderParamBo;
import com.chinavisionary.paymentlibrary.vo.PayBillVo;
import com.chinavisionary.paymentlibrary.vo.PayTypeVo;
import com.chinavisionary.paymentlibrary.vo.ResponseH5BillDetailsVo;

/* JADX INFO: loaded from: classes2.dex */
public class p extends l {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2346h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2347i;
    public int j;

    public p(View view, BillModel billModel, o oVar) {
        super(view, billModel, oVar);
    }

    @Override // c.e.d.y.l
    public void handlePayFailed() {
        l(false);
    }

    @Override // c.e.d.y.l
    public void handlePaySuccessResult() {
        l(true);
    }

    @Override // c.e.d.y.l
    public void initData(BaseVo baseVo) {
        if (baseVo instanceof PayTypeVo) {
            PayTypeVo payTypeVo = (PayTypeVo) baseVo;
            this.f2346h = payTypeVo.isBill();
            this.j = payTypeVo.getType();
            this.f2347i = payTypeVo.isOpenOrderList();
        }
    }

    public final void l(boolean z) {
        a(this.f2346h);
        c.e.a.d.q.d(p.class.getSimpleName(), "handlePayResult mType:" + this.j + ", isBill:" + this.f2346h);
        if (z) {
            if (this.j == 19) {
                m();
            } else {
                g(this.f2347i);
            }
        }
    }

    public final void m() {
        g.b.a.c.getDefault().post(new EventProductPayVo());
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00be -> B:31:0x00c9). Please report as a decompilation issue!!! */
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
        this.f2346h = payTypeVo.isBill();
        this.j = payTypeVo.getType();
        String extJson = payTypeVo.getExtJson();
        String responseH5BillDetailsVoJson = payTypeVo.getResponseH5BillDetailsVoJson();
        ResponseH5BillDetailsVo responseH5BillDetailsVo = null;
        if (responseH5BillDetailsVoJson != null) {
            try {
                responseH5BillDetailsVo = (ResponseH5BillDetailsVo) JSON.parseObject(responseH5BillDetailsVoJson, ResponseH5BillDetailsVo.class);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            CreateCleanOrderVo createCleanOrderVo = (CreateCleanOrderVo) JSON.parseObject(extJson, CreateCleanOrderVo.class);
            createCleanOrderVo.setPayChannel(i2);
            if (c.e.a.a.a.getInstance().isBjIncrement()) {
                String extJson2 = payTypeVo.getExtJson();
                if (x.isNotNull(extJson2)) {
                    PayBillVo payBillVo = (PayBillVo) JSON.parseObject(extJson2, PayBillVo.class);
                    payBillVo.setPayChannel(i2);
                    if (x.isNotNull(payBillVo.getPaymentKey())) {
                        this.f2341f.postPayBill(payBillVo);
                    } else if (responseH5BillDetailsVo != null) {
                        this.f2341f.getPayOrderCreateResult().postValue(responseH5BillDetailsVo);
                    } else {
                        CreateIncrementOrderParamBo createIncrementOrderParamBo = new CreateIncrementOrderParamBo();
                        createIncrementOrderParamBo.setCommodityId(createCleanOrderVo.getValueaddedKey());
                        createIncrementOrderParamBo.setSpaceId(createCleanOrderVo.getRoomKey());
                        createIncrementOrderParamBo.setPayChannel(i2);
                        this.f2341f.createNewCleanOrder(createIncrementOrderParamBo);
                    }
                } else if (responseH5BillDetailsVo != null) {
                    this.f2341f.getPayOrderCreateResult().postValue(responseH5BillDetailsVo);
                } else {
                    CreateIncrementOrderParamBo createIncrementOrderParamBo2 = new CreateIncrementOrderParamBo();
                    createIncrementOrderParamBo2.setCommodityId(createCleanOrderVo.getValueaddedKey());
                    createIncrementOrderParamBo2.setSpaceId(createCleanOrderVo.getRoomKey());
                    createIncrementOrderParamBo2.setPayChannel(i2);
                    this.f2341f.createNewCleanOrder(createIncrementOrderParamBo2);
                }
            } else {
                this.f2340e.createCleanOrder(createCleanOrderVo);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
