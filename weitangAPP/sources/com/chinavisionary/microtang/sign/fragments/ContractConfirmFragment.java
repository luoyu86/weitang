package com.chinavisionary.microtang.sign.fragments;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.contract.ContractActivity;
import com.chinavisionary.microtang.pre.ReserveListActivity;
import com.chinavisionary.microtang.sign.vo.EventSwitchToMeVo;

/* JADX INFO: loaded from: classes2.dex */
public class ContractConfirmFragment extends BaseFragment {
    public int B;

    @BindView(R.id.tv_contract_tip)
    public TextView mContractTipTv;

    public static ContractConfirmFragment getInstance(int i2) {
        ContractConfirmFragment contractConfirmFragment = new ContractConfirmFragment();
        contractConfirmFragment.setPayFeeType(i2);
        return contractConfirmFragment;
    }

    public final void E1() {
        d0(ContractActivity.class);
    }

    public final void F1() {
        d0(ReserveListActivity.class);
    }

    public final void G1() {
        k(new EventSwitchToMeVo());
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        AppConfigExtVo appConfigExtVoO = o();
        if (appConfigExtVoO != null) {
            if (16 == this.B) {
                this.mContractTipTv.setText(R.string.tip_reserve_contract_success);
            } else if (x.isNotNull(appConfigExtVoO.getCheckinTip())) {
                this.mContractTipTv.setText(appConfigExtVoO.getCheckinTip());
            }
        }
    }

    @OnClick({R.id.btn_confirm})
    public void confirmClick(View view) {
        if (!M0(view) || this.f6487e == null) {
            return;
        }
        G1();
        m();
        int i2 = this.B;
        if (i2 == 10) {
            E1();
        } else {
            if (i2 != 16) {
                return;
            }
            F1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_contract_confirm;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    public final void setPayFeeType(int i2) {
        this.B = i2;
    }
}
