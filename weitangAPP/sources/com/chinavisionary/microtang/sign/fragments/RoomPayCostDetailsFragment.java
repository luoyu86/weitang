package com.chinavisionary.microtang.sign.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import c.e.c.j0.b.h;
import c.e.c.j0.c.a;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.bill.model.BillModel;
import com.chinavisionary.microtang.bill.vo.PayBillVo;
import com.chinavisionary.microtang.contract.model.ContractModel;
import com.chinavisionary.microtang.contract.vo.ContractRentFeeVo;
import com.chinavisionary.microtang.contract.vo.UpdateContractEventVo;
import com.chinavisionary.microtang.sign.vo.ResponseFirstFeeVo;
import com.chinavisionary.microtang.sign.vo.RoomPayCostVo;
import com.chinavisionary.paymentlibrary.PayTypeFragment;
import com.chinavisionary.paymentlibrary.vo.PayTypeVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RoomPayCostDetailsFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public String B;
    public ContractModel C;
    public BillModel D;
    public String E;
    public a F;

    @BindView(R.id.btn_confirm_pay_cost)
    public Button mConfirmPayCostBtn;

    @BindView(R.id.swipe_refresh_layout_pay_cost)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public static RoomPayCostDetailsFragment getInstance(String str) {
        RoomPayCostDetailsFragment roomPayCostDetailsFragment = new RoomPayCostDetailsFragment();
        roomPayCostDetailsFragment.setArguments(CoreBaseFragment.q(str));
        return roomPayCostDetailsFragment;
    }

    public final void E1(ResponseStateVo responseStateVo) {
        H();
        z0(R.string.loading_text);
        this.D.getBillFirstFee(this.f6484b);
    }

    public final void F1(ResponseFirstFeeVo responseFirstFeeVo) {
        S1(null);
        if (responseFirstFeeVo == null) {
            F0(R.string.tip_submit_failed);
        } else {
            if (!responseFirstFeeVo.isSuccess()) {
                G0(x.getNotNullStr(responseFirstFeeVo.getMessage(), x.getString(R.string.tip_submit_failed)));
                return;
            }
            k(new UpdateContractEventVo());
            this.E = responseFirstFeeVo.getPaymentKey();
            N1();
        }
    }

    public final void G1(ResponseRowsVo<ContractRentFeeVo> responseRowsVo) {
        S1(null);
        if (responseRowsVo != null) {
            H1(responseRowsVo.getRows());
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void H1(List<ContractRentFeeVo> list) {
        RoomPayCostVo adapterData = this.F.getAdapterData(list);
        this.B = adapterData.getPayPrice();
        this.t.initListData((List<T>) adapterData.getRightArrowVoList());
        this.mConfirmPayCostBtn.setText(x.appendStringToResId(R.string.placeholder_confirm_pay_first_cost, this.B));
    }

    public final void I1() {
        this.mTitleTv.setText(R.string.title_pay_cost_details);
        this.mConfirmPayCostBtn.setText("");
        this.mConfirmPayCostBtn.setOnClickListener(this.y);
        this.F = new a();
    }

    public final void N1() {
        PayBillVo payBillVo = new PayBillVo();
        payBillVo.setPaymentKey(this.E);
        PayTypeVo payTypeVo = new PayTypeVo();
        payTypeVo.setResStrId(R.string.title_pay_first);
        payTypeVo.setPrice(this.B);
        payTypeVo.setType(10);
        payTypeVo.setExtJson(JSON.toJSONString(payBillVo));
        payTypeVo.setBaseKey(this.f6484b);
        K0(PayTypeFragment.getInstance(payTypeVo), R.id.flayout_content);
    }

    public final void O1() {
        if (x.isNotNull(this.E)) {
            N1();
        } else {
            z0(R.string.tip_submit_data_loading);
            this.D.confirmBillFirstFee(this.f6484b);
        }
    }

    public final void P1() {
        BillModel billModel = (BillModel) h(BillModel.class);
        this.D = billModel;
        billModel.getBillFirstFeeLiveData().observe(this, new Observer() { // from class: c.e.c.j0.b.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1602a.F1((ResponseFirstFeeVo) obj);
            }
        });
        this.D.getBillConfirmResult().observe(this, new Observer() { // from class: c.e.c.j0.b.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1605a.E1((ResponseStateVo) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new h(this));
    }

    public final void Q1() {
        ContractModel contractModel = (ContractModel) h(ContractModel.class);
        this.C = contractModel;
        contractModel.getContractRentFeeList().observe(this, new Observer() { // from class: c.e.c.j0.b.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1604a.G1((ResponseRowsVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new h(this));
    }

    public final void R1() {
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        LeftTitleToRightArrowAdapter leftTitleToRightArrowAdapter = new LeftTitleToRightArrowAdapter();
        this.t = leftTitleToRightArrowAdapter;
        leftTitleToRightArrowAdapter.addHeadView(this.F.getAdapterHeadView(this.f6487e));
    }

    public final void S1(RequestErrDto requestErrDto) {
        C(requestErrDto);
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (M0(view) && view.getId() == R.id.btn_confirm_pay_cost) {
            O1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        I1();
        P1();
        Q1();
        R1();
        j0();
    }

    @OnClick({R.id.tv_back})
    public void finishFragment(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_room_pay_cost_details;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        z0(R.string.loading_text);
        this.C.getContactRentFeeList(this.f6484b);
    }
}
