package com.chinavisionary.microtang.contract.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.a.c.c.a;
import c.e.a.d.x;
import c.e.c.m0.j;
import c.e.c.o.d.c;
import c.e.e.a.s.e;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.contract.model.ContractModel;
import com.chinavisionary.microtang.contract.vo.ContractExitRentStateDetailsVo;
import com.chinavisionary.microtang.contract.vo.UpdateContractEventVo;
import com.chinavisionary.microtang.view.ExitStateView;
import com.chinavisionary.twlib.open.model.OpenDoorModel;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ContractRescissionDetailsFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public boolean B;
    public ExitStateView C;
    public AppCompatButton D;
    public TextView E;
    public OpenDoorModel F;
    public ContractModel G;
    public ContractExitRentStateDetailsVo H;
    public c I;
    public a J = new a() { // from class: c.e.c.o.c.t0
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1773a.I1(view, i2);
        }
    };

    @BindView(R.id.cb_confirm)
    public CheckBox mConfirmCb;

    @BindView(R.id.btn_finish_exit_rent)
    public AppCompatButton mConfirmFinishBtn;

    @BindView(R.id.swipe_refresh_layout_rescission)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: H1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I1(View view, int i2) {
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = (LeftTitleToRightArrowVo) this.t.getList().get(i2);
        int onlyKey = leftTitleToRightArrowVo.getOnlyKey();
        if (onlyKey == 3) {
            V1(leftTitleToRightArrowVo);
        } else {
            if (onlyKey != 4) {
                return;
            }
            W1(leftTitleToRightArrowVo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: J1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K1(ResponseStateVo responseStateVo) {
        Y1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: L1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M1(RequestErrDto requestErrDto) {
        Y1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: N1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O1(ResponseRowsVo responseRowsVo) {
        if (responseRowsVo == null) {
            Y1();
            return;
        }
        List<e> listSignLockToLock = j.getInstance().signLockToLock(responseRowsVo.getRows());
        if (listSignLockToLock == null || listSignLockToLock.isEmpty()) {
            Y1();
            return;
        }
        e eVar = listSignLockToLock.get(0);
        if (eVar != null) {
            this.F.postSelectRoom(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: P1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q1(ResponseStateVo responseStateVo) {
        boolean z = this.B;
        if (F(responseStateVo, z ? R.string.tip_cancel_success : R.string.tip_submit_success, z ? R.string.tip_cancel_failed : R.string.tip_submit_failed)) {
            this.F.getSignLockList();
            j0();
        }
        d2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: R1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S1(ContractExitRentStateDetailsVo contractExitRentStateDetailsVo) {
        d2();
        G1(contractExitRentStateDetailsVo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: T1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U1(RequestErrDto requestErrDto) {
        d2();
        C(requestErrDto);
    }

    public static ContractRescissionDetailsFragment getInstance(String str) {
        ContractRescissionDetailsFragment contractRescissionDetailsFragment = new ContractRescissionDetailsFragment();
        contractRescissionDetailsFragment.setArguments(CoreBaseFragment.q(str));
        return contractRescissionDetailsFragment;
    }

    public final void E1() {
        View viewInflate = LayoutInflater.from(this.f6487e).inflate(R.layout.item_exit_rent_state, (ViewGroup) null, false);
        this.C = (ExitStateView) viewInflate.findViewById(R.id.tv_exit_state);
        this.D = (AppCompatButton) viewInflate.findViewById(R.id.btn_cancel_exit_rent);
        this.E = (TextView) viewInflate.findViewById(R.id.tv_exit_rent_state);
        this.D.setOnClickListener(this.y);
        this.t.addHeadView(viewInflate);
    }

    public final String F1() {
        String string = x.getString(R.string.alert_tip_finish_exit_rent);
        ContractExitRentStateDetailsVo contractExitRentStateDetailsVo = this.H;
        if (contractExitRentStateDetailsVo == null) {
            return string;
        }
        return "请确认退款总金额:" + x.bigDecimalToPlainString(contractExitRentStateDetailsVo.getRefundTotalAmount()) + "元";
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void G1(ContractExitRentStateDetailsVo contractExitRentStateDetailsVo) {
        if (contractExitRentStateDetailsVo != null) {
            this.H = contractExitRentStateDetailsVo;
            a2(contractExitRentStateDetailsVo.getRentBackStatus());
            this.t.initListData((List<T>) this.I.getAdapterData(contractExitRentStateDetailsVo, 4));
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.btn_cancel_exit_rent) {
            this.B = true;
            u0(x.getString(R.string.title_confirm_cancel_exit_rent));
        } else {
            if (id != R.id.tv_alert_confirm) {
                return;
            }
            if (this.B) {
                X1();
            } else {
                e2();
            }
        }
    }

    public final void V1(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_exit_rent_details);
        Z1();
        b2();
        c2();
        z0(R.string.loading_text);
        j0();
    }

    public final void W1(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
        K0(ContractExitRentPropertyStateFragment.getInstance(this.I.getRentBackKey()), R.id.flayout_content);
    }

    public final void X1() {
        z0(R.string.tip_cancel_exit_rent);
        this.G.cancelExitRent(this.I.getRentBackKey());
    }

    public final void Y1() {
        k(new UpdateContractEventVo());
    }

    public final void Z1() {
        OpenDoorModel openDoorModel = (OpenDoorModel) h(OpenDoorModel.class);
        this.F = openDoorModel;
        openDoorModel.getRoomSelectLiveData().observe(this, new Observer() { // from class: c.e.c.o.c.r0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1769a.K1((ResponseStateVo) obj);
            }
        });
        this.F.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.o.c.q0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1767a.M1((RequestErrDto) obj);
            }
        });
        this.F.getSignLockListLiveData().observe(this, new Observer() { // from class: c.e.c.o.c.s0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1771a.O1((ResponseRowsVo) obj);
            }
        });
    }

    public final void a2(int i2) {
        this.C.setStateVoList(this.I.getStateVoList(i2));
        boolean z = 1 == i2;
        boolean z2 = 3 == i2;
        boolean z3 = 5 == i2;
        boolean z4 = 2 == i2;
        this.D.setVisibility(z ? 0 : 8);
        this.C.setVisibility(z2 ? 8 : 0);
        this.E.setVisibility(z2 ? 0 : 8);
        boolean z5 = 4 == i2;
        this.mConfirmCb.setVisibility(z5 ? 0 : 8);
        this.mConfirmFinishBtn.setVisibility(z5 ? 0 : 8);
        if (z3 || z4) {
            this.mConfirmFinishBtn.getLayoutParams().width = -1;
            this.mConfirmFinishBtn.setText(x.getString(z4 ? R.string.title_exit_state_accept : R.string.title_exit_rent_finish));
            this.mConfirmFinishBtn.setEnabled(false);
            this.mConfirmFinishBtn.setTextColor(getResources().getColor(R.color.color000000));
            this.mConfirmFinishBtn.setBackgroundColor(getResources().getColor(R.color.color_bg));
            this.mConfirmFinishBtn.setVisibility(0);
        }
    }

    public final void b2() {
        this.I = new c();
        ContractModel contractModel = (ContractModel) h(ContractModel.class);
        this.G = contractModel;
        contractModel.getRequestResult().observe(this, new Observer() { // from class: c.e.c.o.c.u0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1775a.Q1((ResponseStateVo) obj);
            }
        });
        this.G.getExitRentDetails().observe(this, new Observer() { // from class: c.e.c.o.c.w0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1779a.S1((ContractExitRentStateDetailsVo) obj);
            }
        });
        this.G.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.o.c.v0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1777a.U1((RequestErrDto) obj);
            }
        });
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    public final void c2() {
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        LeftTitleToRightArrowAdapter leftTitleToRightArrowAdapter = new LeftTitleToRightArrowAdapter();
        this.t = leftTitleToRightArrowAdapter;
        leftTitleToRightArrowAdapter.setOnItemClickListener(this.J);
        E1();
    }

    public final void d2() {
        H();
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    public final void e2() {
        z0(R.string.tip_submit_data_loading);
        this.G.finishExitRent(this.I.getRentBackKey());
    }

    @OnClick({R.id.btn_finish_exit_rent})
    public void finishExitRent(View view) {
        if (!this.mConfirmCb.isChecked()) {
            F0(R.string.title_confirm_all_rent_msg);
        } else {
            this.B = false;
            A1(F1());
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_contract_rescission;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.G.getContractExitRentDetails(this.f6484b);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.H = null;
    }
}
