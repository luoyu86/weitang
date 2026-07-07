package c.e.d.y;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import c.e.a.d.v;
import c.e.a.d.x;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.paymentlibrary.R;
import com.chinavisionary.paymentlibrary.model.BillModel;
import com.chinavisionary.paymentlibrary.model.NewBillModel;
import com.chinavisionary.paymentlibrary.vo.PayBillVo;
import com.chinavisionary.paymentlibrary.vo.PayTypeVo;
import com.chinavisionary.paymentlibrary.vo.ReserveFddContractVo;
import com.chinavisionary.paymentlibrary.vo.ResponseFddSignUrlVo;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class s extends l {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2354h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2355i;
    public boolean j;
    public boolean k;
    public String l;
    public int m;
    public View.OnClickListener n;

    public class a implements Observer<ReserveFddContractVo> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable ReserveFddContractVo reserveFddContractVo) {
            c.e.a.d.q.d(a.class.getSimpleName(), "mNewBillModel");
            s.this.o(reserveFddContractVo);
        }
    }

    public class b implements Observer<ReserveFddContractVo> {
        public b() {
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable ReserveFddContractVo reserveFddContractVo) {
            c.e.a.d.q.d(b.class.getSimpleName(), "mBillModel");
            s sVar = s.this;
            if (sVar.f2341f == null) {
                sVar.o(reserveFddContractVo);
            }
        }
    }

    public s(View view, BillModel billModel, o oVar) {
        super(view, billModel, oVar);
        this.n = new View.OnClickListener() { // from class: c.e.d.y.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f2334a.s(view2);
            }
        };
        u();
        c.e.a.d.q.d(s.class.getSimpleName(), "RentRoomPayHandleAdapter");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(View view) {
        int id = view.getId();
        if (id == R.id.tv_alert_cancel) {
            if (this.f2354h) {
                a(false);
                if (this.k) {
                    t();
                    return;
                } else {
                    f();
                    return;
                }
            }
            return;
        }
        if (id == R.id.tv_alert_confirm) {
            if (this.f2354h) {
                m();
            } else if (this.k) {
                t();
            } else {
                e(0);
            }
        }
    }

    @Override // c.e.d.y.l
    public void handlePayFailed() {
        if (this.j) {
            a(true);
            return;
        }
        a(false);
        if (this.f2355i) {
            e(0);
        } else if (this.k) {
            t();
        } else {
            f();
        }
    }

    @Override // c.e.d.y.l
    public void handlePaySuccessResult() {
        this.f2354h = true;
        if (this.f2355i) {
            this.f2338c.finishFragmentOrActivity(true);
        } else {
            j(x.getString(this.k ? R.string.payment_lib_title_sign_reserve_electron_contract : R.string.payment_lib_title_sign_rent_electron_contract), this.n);
        }
    }

    @Override // c.e.d.y.l
    public void initData(BaseVo baseVo) {
        if (!(baseVo instanceof PayTypeVo)) {
            b();
            return;
        }
        PayTypeVo payTypeVo = (PayTypeVo) baseVo;
        this.j = payTypeVo.isBill();
        int type = payTypeVo.getType();
        this.m = type;
        this.k = type == 16;
        this.f2355i = type == 12;
        this.l = baseVo.getBaseKey();
    }

    public final void m() {
        if (this.f2338c == null) {
            b();
            return;
        }
        if (!x.isNotNull(this.l)) {
            b();
            return;
        }
        h(R.string.payment_lib_tip_get_contract);
        if (!this.k) {
            NewBillModel newBillModel = this.f2341f;
            if (newBillModel != null) {
                newBillModel.getFddContactUrl(this.l);
                return;
            } else {
                this.f2340e.getFddContactUrl(this.l);
                return;
            }
        }
        if (p()) {
            NewBillModel newBillModel2 = this.f2341f;
            if (newBillModel2 != null) {
                newBillModel2.getReserveFdd(this.l);
            } else {
                this.f2340e.getReserveFdd(this.l);
            }
        }
    }

    public final void n(ResponseFddSignUrlVo responseFddSignUrlVo) {
        c();
        if (responseFddSignUrlVo == null || !x.isNotNull(responseFddSignUrlVo.getContractSignUrl())) {
            i(x.getString(R.string.payment_lib_tip_alert_fdd_contract_get_failed_retry), this.n);
        } else {
            if (v.getInstance().isRepeatedlyAction(responseFddSignUrlVo.getContractSignUrl())) {
                c.e.a.d.q.d(s.class.getSimpleName(), "handleFddContract isRepeatedlyAction");
                return;
            }
            ARouter.getInstance().build("/webview/webview").withBoolean("isFddContract", true).withInt("payFeeType", this.m).withString("signUrl", responseFddSignUrlVo.getContractSignUrl()).withString("returnUrl", responseFddSignUrlVo.getNotifyUrl()).navigation();
            c.e.a.d.q.d(s.class.getSimpleName(), "handleFddContract");
            a(false);
        }
    }

    public final void o(ReserveFddContractVo reserveFddContractVo) {
        ResponseFddSignUrlVo responseFddSignUrlVo = new ResponseFddSignUrlVo();
        responseFddSignUrlVo.setContractSignUrl(reserveFddContractVo.getReserveSignUrl());
        responseFddSignUrlVo.setNotifyUrl(reserveFddContractVo.getNotifyUrl());
        n(responseFddSignUrlVo);
    }

    public final boolean p() {
        o oVar = this.f2338c;
        if (oVar == null || oVar.userIsAuth()) {
            return true;
        }
        this.f2338c.hiedAlertLoading();
        this.f2338c.showToast(R.string.payment_lib_tip_auth_sign_protocol);
        a(false);
        t();
        k("/id_auth/id_auth");
        return false;
    }

    @Override // c.e.d.y.l
    public void requestGetPaySign(BaseVo baseVo, int i2) {
        if (this.f2354h) {
            m();
            return;
        }
        if (!(baseVo instanceof PayTypeVo)) {
            b();
            return;
        }
        PayTypeVo payTypeVo = (PayTypeVo) baseVo;
        if (!x.isNotNull(payTypeVo.getExtJson())) {
            b();
            return;
        }
        PayBillVo payBillVo = (PayBillVo) JSON.parseObject(payTypeVo.getExtJson(), PayBillVo.class);
        if (payBillVo == null) {
            b();
            return;
        }
        payBillVo.setPayChannel(i2);
        NewBillModel newBillModel = this.f2341f;
        if (newBillModel != null) {
            newBillModel.postPayBill(payBillVo);
        }
    }

    @Override // c.e.d.y.l
    public void setNewBillModel(NewBillModel newBillModel) {
        super.setNewBillModel(newBillModel);
        NewBillModel newBillModel2 = this.f2341f;
        if (newBillModel2 != null) {
            newBillModel2.getContractFddResult().observe(this.f2338c.getCurrentFragment(), new k(this));
            MutableLiveData<RequestErrDto> errRequestLiveData = this.f2341f.getErrRequestLiveData();
            CoreBaseFragment currentFragment = this.f2338c.getCurrentFragment();
            o oVar = this.f2338c;
            Objects.requireNonNull(oVar);
            errRequestLiveData.observe(currentFragment, new h(oVar));
            this.f2341f.getReserveFddResult().observe(this.f2338c.getCurrentFragment(), new a());
        }
    }

    public final void t() {
        k("/reserve_list/reserve_list");
    }

    public final void u() {
        o oVar = this.f2338c;
        if (oVar == null || oVar.getCurrentFragment() == null) {
            return;
        }
        this.f2340e.getContractFddResult().observe(this.f2338c.getCurrentFragment(), new k(this));
        MutableLiveData<RequestErrDto> errRequestLiveData = this.f2340e.getErrRequestLiveData();
        CoreBaseFragment currentFragment = this.f2338c.getCurrentFragment();
        o oVar2 = this.f2338c;
        Objects.requireNonNull(oVar2);
        errRequestLiveData.observe(currentFragment, new h(oVar2));
        this.f2340e.getReserveFddResult().observe(this.f2338c.getCurrentFragment(), new b());
    }
}
