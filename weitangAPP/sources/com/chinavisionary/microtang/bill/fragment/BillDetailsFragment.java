package com.chinavisionary.microtang.bill.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.j.c.a;
import c.e.c.j.c.b;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.bill.model.BillModel;
import com.chinavisionary.microtang.bill.vo.BillDetailsVo;
import com.chinavisionary.microtang.bill.vo.BillVo;
import com.chinavisionary.microtang.main.bo.EventUpdateAlertVo;
import com.chinavisionary.microtang.me.model.UserOperateModel;
import com.chinavisionary.microtang.me.vo.WalletRecordDetailsVo;
import com.chinavisionary.paymentlibrary.PayTypeFragment;
import com.chinavisionary.paymentlibrary.vo.EventPayStateVo;
import com.chinavisionary.paymentlibrary.vo.PayTypeVo;
import g.b.a.m;
import g.b.a.r;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BillDetailsFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public boolean B;
    public int C;
    public BillVo D;
    public BillDetailsVo E;
    public BillModel F;
    public String G;
    public UserOperateModel H;
    public a I;
    public b J;

    @BindView(R.id.btn_next)
    public AppCompatButton mNextBtn;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public static BillDetailsFragment getInstance(BillVo billVo, int i2) {
        BillDetailsFragment billDetailsFragment = new BillDetailsFragment();
        billDetailsFragment.O1(billVo);
        billDetailsFragment.N1(i2);
        return billDetailsFragment;
    }

    public final void E1() {
        if (this.C == 12340) {
            WalletRecordDetailsVo dataToKey = c.e.c.x.c.a.getInstance().getDataToKey(this.G);
            if (dataToKey == null) {
                q.d(this.f6485c, "getBillDetails mWalletRecordKey = " + this.G + "detailsVo = null");
                z0(R.string.loading_text);
            } else {
                F1(dataToKey);
            }
        } else {
            z0(R.string.loading_text);
        }
        j0();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void F1(WalletRecordDetailsVo walletRecordDetailsVo) {
        T1(null);
        if (walletRecordDetailsVo == null || !walletRecordDetailsVo.isSuccess()) {
            return;
        }
        c.e.c.x.c.a.getInstance().addData(this.G, walletRecordDetailsVo);
        q.d(this.f6485c, "addData mWalletRecordKey = " + this.G);
        BillDetailsVo billDetailsVo = new BillDetailsVo();
        this.E = billDetailsVo;
        billDetailsVo.setBody(walletRecordDetailsVo.getBody());
        this.E.setAmount(walletRecordDetailsVo.getAmount());
        this.t.initListData((List<T>) this.I.getWalletDetailsAdapterData(walletRecordDetailsVo.getDetailList()));
        U1();
    }

    public final void G1(String str, Integer num) {
        if (this.C == 12340 || num == null) {
            return;
        }
        this.mNextBtn.setVisibility(num.intValue() == 0 ? 0 : 8);
        this.J.updateBillState(str, num);
    }

    public final void H1() {
        h0(this);
        this.mTitleTv.setText(R.string.title_bill_details);
        this.f6488f = new CoreBaseFragment.c(this);
        this.I = new a();
        if (this.C != 12340) {
            Q1();
            return;
        }
        S1();
        this.mNextBtn.setVisibility(8);
        this.mTitleTv.setText(R.string.title_wallet_details);
    }

    public final void L1() {
        BillDetailsVo billDetailsVo = this.E;
        if (billDetailsVo != null) {
            PayTypeVo payTypeVo = this.I.getPayTypeVo(billDetailsVo, this.C);
            if (payTypeVo != null) {
                K0(PayTypeFragment.getInstance(payTypeVo), R.id.flayout_content);
            } else {
                F0(R.string.payment_lib_title_init_pay_failed);
            }
        }
    }

    public final void M1() {
        if (this.B) {
            this.B = false;
            k(new EventUpdateAlertVo());
        }
    }

    public final void N1(int i2) {
        this.C = i2;
    }

    public final void O1(BillVo billVo) {
        this.D = billVo;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void P1(BillDetailsVo billDetailsVo) {
        T1(null);
        if (billDetailsVo != null) {
            this.E = billDetailsVo;
            if (billDetailsVo.getLateFee() != null && billDetailsVo.getLateFee().floatValue() > 0.0f) {
                this.B = true;
            }
            this.t.initListData((List<T>) this.I.getAdapterData(this.C, billDetailsVo));
            U1();
        }
    }

    public final void Q1() {
        BillModel billModel = (BillModel) h(BillModel.class);
        this.F = billModel;
        billModel.getBillDetailsLiveData().observe(this, new Observer() { // from class: c.e.c.j.b.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1579a.P1((BillDetailsVo) obj);
            }
        });
        this.F.getErrRequestLiveData().observe(this, new c.e.c.j.b.a(this));
    }

    public final void R1() {
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        this.t = new LeftTitleToRightArrowAdapter();
        View viewInflate = LayoutInflater.from(this.f6487e).inflate(R.layout.item_bill_details_head, (ViewGroup) null, false);
        b bVar = new b(viewInflate, this.C);
        this.J = bVar;
        bVar.setBaseHandler(this.f6488f);
        this.t.addHeadView(viewInflate);
        U1();
    }

    public final void S1() {
        UserOperateModel userOperateModel = (UserOperateModel) h(UserOperateModel.class);
        this.H = userOperateModel;
        userOperateModel.getWalletRecordDetails().observe(this, new Observer() { // from class: c.e.c.j.b.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1580a.F1((WalletRecordDetailsVo) obj);
            }
        });
        this.H.getErrRequestLiveData().observe(this, new c.e.c.j.b.a(this));
    }

    public final void T1(RequestErrDto requestErrDto) {
        H();
        if (requestErrDto != null) {
            C(requestErrDto);
        }
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    public final void U1() {
        BillDetailsVo billDetailsVo = this.E;
        if (billDetailsVo != null) {
            this.J.updateHeadViewData(billDetailsVo);
            G1(this.E.getBillStatusName(), this.E.getBillStatus());
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        H1();
        R1();
        E1();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_bill_details;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        if (this.C == 12340) {
            this.H.getWalletRecordList(this.G);
            return;
        }
        BillVo billVo = this.D;
        if (billVo != null) {
            this.F.getBillDetails(billVo.getPaymentKey());
        } else if (x.isNotNull(this.f6484b)) {
            this.F.getBillDetails(this.f6484b);
        }
    }

    @OnClick({R.id.btn_next})
    public void nextClick(View view) {
        if (M0(view)) {
            L1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.B = false;
        this.J.stopCountdown();
        L0(this);
    }

    public void setRecordKey(String str) {
        this.G = str;
    }

    public void setupBillKey(String str) {
        this.f6484b = str;
    }

    @m(threadMode = r.MAIN)
    public void subscribePayResult(EventPayStateVo eventPayStateVo) {
        H();
        if (!eventPayStateVo.isSuccess()) {
            G0(eventPayStateVo.getMsg());
        } else {
            M1();
            E1();
        }
    }
}
