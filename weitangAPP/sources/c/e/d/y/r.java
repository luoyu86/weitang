package c.e.d.y;

import android.view.View;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.paymentlibrary.model.BillModel;
import com.chinavisionary.paymentlibrary.model.NewBillModel;
import com.chinavisionary.paymentlibrary.vo.PayTypeVo;

/* JADX INFO: loaded from: classes2.dex */
public class r extends l {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l f2352h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public q f2353i;

    public r(View view, BillModel billModel, o oVar) {
        super(view, billModel, oVar);
        this.f2353i = new q(view, billModel, oVar);
    }

    @Override // c.e.d.y.l
    public void handlePayFailed() {
        l lVar = this.f2352h;
        if (lVar != null) {
            lVar.handlePayFailed();
        }
    }

    @Override // c.e.d.y.l
    public void handlePaySuccessResult() {
        l lVar = this.f2352h;
        if (lVar != null) {
            lVar.handlePaySuccessResult();
            if (this.f2342g != null) {
                g(false);
            }
        }
    }

    @Override // c.e.d.y.l
    public void initData(BaseVo baseVo) {
        if (baseVo instanceof PayTypeVo) {
            l((PayTypeVo) baseVo);
        }
    }

    public final void l(PayTypeVo payTypeVo) {
        c.e.a.d.q.d(r.class.getSimpleName(), "initBasePayHandle type :" + payTypeVo.getType());
        l lVarA = this.f2353i.a(payTypeVo.getType());
        this.f2352h = lVarA;
        if (lVarA != null) {
            lVarA.initData(payTypeVo);
        }
    }

    @Override // c.e.d.y.l
    public void requestGetPaySign(BaseVo baseVo, int i2) {
        l lVar = this.f2352h;
        if (lVar != null) {
            lVar.requestGetPaySign(baseVo, i2);
        }
    }

    @Override // c.e.d.y.l
    public void setNewBillModel(NewBillModel newBillModel) {
        this.f2341f = newBillModel;
        this.f2353i.b(newBillModel);
    }

    @Override // c.e.d.y.l
    public void setupAppletJsonData(String str) {
        super.setupAppletJsonData(str);
        l lVar = this.f2352h;
        if (lVar != null) {
            lVar.setupAppletJsonData(str);
        }
    }
}
