package com.chinavisionary.microtang.sign.fragments;

import android.app.AlertDialog;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.a.c.c.a;
import c.e.a.d.x;
import c.e.c.g.n;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.sign.adapter.SignRoomAdapter;
import com.chinavisionary.microtang.sign.model.SignRoomModel;
import com.chinavisionary.microtang.sign.vo.GetFddContactBo;
import com.chinavisionary.microtang.sign.vo.ResponseConfirmContactVo;
import com.chinavisionary.microtang.sign.vo.ResponseFddVo;
import com.chinavisionary.microtang.sign.vo.SignRoomVo;
import com.chinavisionary.microtang.web.WebFragment;
import com.chinavisionary.paymentlibrary.FragmentPay;
import com.chinavisionary.paymentlibrary.vo.EventPayStateVo;
import g.b.a.c;
import g.b.a.m;
import g.b.a.r;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ContractDetailsFragment extends BaseFragment<SignRoomVo> {
    public AlertDialog B;
    public ResponseConfirmContactVo C;
    public SignRoomModel D;
    public boolean E;
    public a F = new a() { // from class: c.e.c.j0.b.b
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1596a.L1(view, i2);
        }
    };

    @BindView(R.id.recycler_contract_list)
    public BaseRecyclerView mBaseRecyclerView;

    @BindView(R.id.tv_pay_tip_msg)
    public TextView mTipPaySuccessAlert;

    @BindView(R.id.tv_title_split_line)
    public TextView mTitleSplitLineTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: K1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L1(View view, int i2) {
        if (view.getTag() == null || this.t == null || !(view.getTag() instanceof SignRoomAdapter.PayModeVH)) {
            return;
        }
        if (this.E) {
            G1();
            return;
        }
        boolean z = R.mipmap.ic_pay_alipay == ((SignRoomVo) this.t.getList().get(i2)).getPayDrawableId();
        Q1(z);
        this.t.notifyDataSetChanged();
        F1(z);
    }

    public static ContractDetailsFragment getInstance(ResponseConfirmContactVo responseConfirmContactVo) {
        ContractDetailsFragment contractDetailsFragment = new ContractDetailsFragment();
        contractDetailsFragment.O1(responseConfirmContactVo);
        return contractDetailsFragment;
    }

    private void o0() {
        SignRoomAdapter signRoomAdapter = new SignRoomAdapter();
        this.t = signRoomAdapter;
        signRoomAdapter.setOnClickListener(this.y);
        this.t.setOnItemClickListener(this.F);
        this.mBaseRecyclerView.setAdapter(this.t);
    }

    public final void E1() {
        this.B = n.getInstance().showPayInfoAlert(this.f6487e, this.y, this.C);
    }

    public final void F1(boolean z) {
        d(FragmentPay.getInstance(this.C.getOrderKey(), z ? 1 : 2), R.id.flayout_content);
    }

    public final void G1() {
        this.E = true;
        if (this.C == null) {
            F0(R.string.title_contact_key_is_empty);
            return;
        }
        this.mTipPaySuccessAlert.setVisibility(0);
        A0(R.string.tip_get_contract, false);
        GetFddContactBo getFddContactBo = new GetFddContactBo();
        getFddContactBo.setContractKey(this.C.getContractKey());
        this.D.getFddContact(getFddContactBo);
    }

    public final void H1() {
        if (!c.getDefault().isRegistered(this)) {
            c.getDefault().register(this);
        }
        this.mTitleSplitLineTv.setVisibility(0);
        this.mTitleTv.setText(R.string.title_contract_details);
    }

    public final void M1(ResponseFddVo responseFddVo) {
        H();
        if (responseFddVo == null || !x.isNotNull(responseFddVo.getSignUrl())) {
            F0(R.string.title_get_contract_failed);
            return;
        }
        WebFragment webFragment = WebFragment.getInstance(responseFddVo.getSignUrl());
        webFragment.setResponseFddVo(responseFddVo);
        d(webFragment, R.id.flayout_content);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void N1() {
        ArrayList arrayList = new ArrayList();
        SignRoomVo signRoomVo = new SignRoomVo();
        signRoomVo.setItemTitle(x.getString(R.string.title_base_message));
        signRoomVo.setLeft(getString(R.string.title_address));
        signRoomVo.setRight(this.C.getAddress());
        arrayList.add(signRoomVo);
        SignRoomVo signRoomVo2 = new SignRoomVo();
        signRoomVo2.setLeft(x.getString(R.string.title_rent_period));
        signRoomVo2.setRight(this.C.getRentPeriod());
        arrayList.add(signRoomVo2);
        SignRoomVo signRoomVo3 = new SignRoomVo();
        signRoomVo3.setLeft(x.getString(R.string.title_pay_method));
        signRoomVo3.setRight(this.C.getPaymentMethod());
        arrayList.add(signRoomVo3);
        SignRoomVo signRoomVo4 = new SignRoomVo();
        signRoomVo4.setLeft(x.getString(R.string.title_month_rent_fee));
        signRoomVo4.setRight(x.appendStringToResId(R.string.rmb_placeholder, x.bigDecimalToString(this.C.getRentFee())));
        arrayList.add(signRoomVo4);
        SignRoomVo signRoomVo5 = new SignRoomVo();
        signRoomVo5.setLeft(x.getString(R.string.title_deposit_fee));
        signRoomVo5.setRight(x.appendStringToResId(R.string.rmb_placeholder, x.bigDecimalToString(this.C.getDepositFee())));
        arrayList.add(signRoomVo5);
        SignRoomVo signRoomVo6 = new SignRoomVo();
        signRoomVo6.setLeft(x.getString(R.string.title_manage_fee));
        signRoomVo6.setRight(x.appendStringToResId(R.string.rmb_placeholder, x.bigDecimalToString(this.C.getManagementFee())));
        signRoomVo6.setShowLine(true);
        arrayList.add(signRoomVo6);
        SignRoomVo signRoomVo7 = new SignRoomVo();
        signRoomVo7.setType(1);
        signRoomVo7.setPrice(x.bigDecimalToString(this.C.getPayFee()));
        signRoomVo7.setShowLine(true);
        arrayList.add(signRoomVo7);
        SignRoomVo signRoomVo8 = new SignRoomVo();
        signRoomVo8.setType(2);
        signRoomVo8.setItemTitle(getString(R.string.title_confirm_pay));
        signRoomVo8.setLeft(getString(R.string.title_alipay));
        signRoomVo8.setPayDrawableId(R.mipmap.ic_pay_alipay);
        arrayList.add(signRoomVo8);
        SignRoomVo signRoomVo9 = new SignRoomVo();
        signRoomVo9.setType(2);
        signRoomVo9.setLeft(getString(R.string.title_wx_pay));
        signRoomVo9.setPayDrawableId(R.mipmap.ic_pay_wx);
        arrayList.add(signRoomVo9);
        this.t.initListData(arrayList);
    }

    public final void O1(ResponseConfirmContactVo responseConfirmContactVo) {
        this.C = responseConfirmContactVo;
    }

    public final void P1() {
        SignRoomModel signRoomModel = (SignRoomModel) h(SignRoomModel.class);
        this.D = signRoomModel;
        signRoomModel.getFddContactLiveData().observe(this, new Observer() { // from class: c.e.c.j0.b.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1598a.M1((ResponseFddVo) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.j0.b.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1594a.C((RequestErrDto) obj);
            }
        });
    }

    public final void Q1(boolean z) {
        int size = this.t.getList().size() - 1;
        ((SignRoomVo) this.t.getList().get(size)).setCheck(!z);
        ((SignRoomVo) this.t.getList().get(size - 1)).setCheck(z);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (M0(view)) {
            int id = view.getId();
            if (id == R.id.btn_alert_confirm) {
                this.B.dismiss();
            } else {
                if (id != R.id.view_pay_info) {
                    return;
                }
                E1();
            }
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        H1();
        o0();
        N1();
        P1();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_contract_details;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (c.getDefault().isRegistered(this)) {
            c.getDefault().unregister(this);
        }
    }

    @m(threadMode = r.MAIN)
    public void subscribePayResult(EventPayStateVo eventPayStateVo) {
        H();
        if (eventPayStateVo.isSuccess()) {
            G1();
        } else {
            G0(eventPayStateVo.getMsg());
        }
    }
}
