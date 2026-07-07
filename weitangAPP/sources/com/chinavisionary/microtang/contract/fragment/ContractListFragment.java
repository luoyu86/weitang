package com.chinavisionary.microtang.contract.fragment;

import android.content.Intent;
import android.view.View;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import c.e.a.a.c.c.a;
import c.e.a.d.x;
import c.e.c.o.d.b;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.bill.model.BillModel;
import com.chinavisionary.microtang.contract.adapter.ContractListAdapter;
import com.chinavisionary.microtang.contract.model.ContractModel;
import com.chinavisionary.microtang.contract.vo.ContractListVo;
import com.chinavisionary.microtang.contract.vo.EventUpdateContractList;
import com.chinavisionary.microtang.contract.vo.ResponseFddSignUrlVo;
import com.chinavisionary.microtang.contract.vo.UpdateContractEventVo;
import com.chinavisionary.microtang.me.vo.EventContract;
import com.chinavisionary.microtang.prelook.fragment.PreLookCommentFragment;
import com.chinavisionary.microtang.room.KeepRentActivity;
import com.chinavisionary.microtang.sign.fragments.RoomSignContractNearbyFragment;
import com.chinavisionary.microtang.sign.vo.ResponseFddVo;
import com.chinavisionary.microtang.sign.vo.ResponseFirstFeeVo;
import com.chinavisionary.microtang.web.WebFragment;
import com.chinavisionary.paymentlibrary.vo.EventPayStateVo;
import g.b.a.m;
import g.b.a.r;

/* JADX INFO: loaded from: classes.dex */
public class ContractListFragment extends BaseFragment<ContractListVo> {
    public BillModel C;
    public ContractModel D;
    public int E;
    public b F;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;
    public int B = 1;
    public a G = new a() { // from class: c.e.c.o.c.y
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1782a.K1(view, i2);
        }
    };
    public Runnable H = new Runnable() { // from class: c.e.c.o.c.b0
        @Override // java.lang.Runnable
        public final void run() {
            this.f1736a.M1();
        }
    };
    public Runnable I = new Runnable() { // from class: c.e.c.o.c.x0
        @Override // java.lang.Runnable
        public final void run() {
            this.f1781a.j0();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: J1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K1(View view, int i2) {
        ContractListVo contractListVo = (ContractListVo) this.t.getList().get(i2);
        ContractListDetailsFragment contractListDetailsFragment = ContractListDetailsFragment.getInstance(contractListVo.getContractKey(), contractListVo.getContractStatus(), contractListVo.getContractStatusName());
        contractListDetailsFragment.setContractListFragment(this);
        K0(contractListDetailsFragment, R.id.flayout_content);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: L1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M1() {
        boolean zIsUpdateDownToListData = this.F.isUpdateDownToListData(this.t.getList());
        l2();
        if (zIsUpdateDownToListData) {
            m2();
            this.t.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: N1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O1(ResponseFirstFeeVo responseFirstFeeVo) {
        k2();
        if (responseFirstFeeVo == null || !responseFirstFeeVo.isSuccess()) {
            F0(R.string.tip_pay_failed);
        } else {
            c2(responseFirstFeeVo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: P1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q1(RequestErrDto requestErrDto) {
        k2();
        C(requestErrDto);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: R1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S1(ResponseRowsVo responseRowsVo) {
        k2();
        if (responseRowsVo == null || responseRowsVo.getRows() == null || responseRowsVo.getRows().isEmpty()) {
            D(null);
            E1();
        } else {
            D(responseRowsVo.getRows());
        }
        l2();
        m2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: T1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U1(ResponseFddSignUrlVo responseFddSignUrlVo) {
        k2();
        if (responseFddSignUrlVo == null || !responseFddSignUrlVo.isSuccess()) {
            F0(R.string.title_get_contract_failed);
            return;
        }
        ResponseFddVo responseFddVo = new ResponseFddVo();
        responseFddVo.setSignUrl(responseFddSignUrlVo.getContractSignUrl());
        responseFddVo.setReturnUrl(responseFddSignUrlVo.getNotifyUrl());
        f2(responseFddVo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: V1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W1(ResponseStateVo responseStateVo) {
        k2();
        if (F(responseStateVo, R.string.tip_cancel_success, R.string.tip_cancel_failed)) {
            l2();
            this.f6483a = 1;
            j0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: X1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y1(RequestErrDto requestErrDto) {
        B();
        k2();
        C(requestErrDto);
    }

    public static ContractListFragment getInstance(int i2) {
        ContractListFragment contractListFragment = new ContractListFragment();
        contractListFragment.g2(i2);
        return contractListFragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void E1() {
        ContractListVo contractListVo = new ContractListVo();
        contractListVo.setContractStatus(34952);
        this.t.addDataToList((T) contractListVo);
    }

    public final void F1() {
        z0(R.string.tip_cancel_contract);
        this.D.cancelPay(((ContractListVo) this.t.getList().get(this.E)).getContractKey());
    }

    public final void G1(View view) {
        this.E = ((Integer) view.getTag()).intValue();
        ContractListVo contractListVo = (ContractListVo) this.t.getList().get(this.E);
        d(ChangeRentFragment.getInstance(contractListVo.getContractKey(), contractListVo.getAddress()), R.id.flayout_content);
    }

    public final void H1(View view) {
        this.E = ((Integer) view.getTag()).intValue();
        String assetKey = ((ContractListVo) this.t.getList().get(this.E)).getAssetKey();
        if (x.isNotNull(assetKey)) {
            Intent intent = new Intent(this.f6487e, (Class<?>) KeepRentActivity.class);
            intent.putExtra("key", assetKey);
            startActivity(intent);
        }
    }

    public final void I1(String str) {
        z0(R.string.tip_get_pay_data_load);
        this.C.getBillFirstFee(str);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        switch (view.getId()) {
            case R.id.btn_action /* 2131230831 */:
                handlerAction(view);
                break;
            case R.id.btn_change_rent /* 2131230855 */:
                G1(view);
                break;
            case R.id.btn_keep_rent /* 2131230875 */:
                H1(view);
                break;
            case R.id.btn_rent_change /* 2131230895 */:
                d2(view);
                break;
            case R.id.tv_alert_confirm /* 2131231942 */:
                F1();
                break;
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.F = new b();
        h2();
        i2();
        j2();
        z0(R.string.loading_text);
        j0();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void X() {
        l2();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void Z() {
        m2();
    }

    public final void Z1(String str) {
        K0(PreLookCommentFragment.getInstance(str), R.id.flayout_content);
    }

    public final void a2(String str) {
        z0(R.string.tip_get_contract);
        this.D.getFddSignUrl(str);
    }

    public final void b2(String str) {
        K0(RoomSignContractNearbyFragment.getInstance(str), R.id.flayout_content);
    }

    public final void c2(ResponseFirstFeeVo responseFirstFeeVo) {
        K0(this.F.getPayTypeFragmentToResponseFirstFeeVo(responseFirstFeeVo, ((ContractListVo) this.t.getList().get(this.E)).getContractKey()), R.id.flayout_content);
    }

    public final void d2(View view) {
        this.E = ((Integer) view.getTag()).intValue();
        ContractListVo contractListVo = (ContractListVo) this.t.getList().get(this.E);
        int contractStatus = contractListVo.getContractStatus();
        if (contractStatus == 10 || contractStatus == 11) {
            u0(x.getString(R.string.title_alert_confirm_cancel_contract));
        } else {
            if (contractStatus != 16) {
                return;
            }
            K0(ContractExitRentFragment.getInstance(contractListVo.getContractKey()), R.id.flayout_content);
        }
    }

    public final void e2(String str) {
        K0(ContractRescissionDetailsFragment.getInstance(str), R.id.flayout_content);
    }

    public final void f2(ResponseFddVo responseFddVo) {
        H();
        if (responseFddVo == null || !x.isNotNull(responseFddVo.getSignUrl())) {
            F0(R.string.title_get_contract_failed);
            return;
        }
        WebFragment webFragment = WebFragment.getInstance(responseFddVo.getSignUrl());
        webFragment.setResponseFddVo(responseFddVo);
        webFragment.setTitle(x.getString(R.string.title_electron_contract));
        K0(webFragment, R.id.flayout_content);
    }

    public final void g2(int i2) {
        this.B = i2;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_contract_list_layout;
    }

    public final void h2() {
        BillModel billModel = (BillModel) h(BillModel.class);
        this.C = billModel;
        billModel.getBillFirstFeeLiveData().observe(this, new Observer() { // from class: c.e.c.o.c.c0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1738a.O1((ResponseFirstFeeVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.o.c.e0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1742a.Q1((RequestErrDto) obj);
            }
        });
    }

    public final void handlerAction(View view) {
        this.E = ((Integer) view.getTag()).intValue();
        ContractListVo contractListVo = (ContractListVo) this.t.getList().get(this.E);
        int contractStatus = contractListVo.getContractStatus();
        if (contractListVo.isRentBackInfoFlag()) {
            e2(contractListVo.getContractKey());
        }
        switch (contractStatus) {
            case 10:
                b2(contractListVo.getContractKey());
                break;
            case 11:
                I1(contractListVo.getContractKey());
                break;
            case 13:
                a2(contractListVo.getContractKey());
                break;
            case 15:
            case 17:
            case 18:
                e2(contractListVo.getContractKey());
                break;
            case 16:
                Z1(contractListVo.getContractKey());
                break;
        }
    }

    public final void i2() {
        h0(this);
        this.f6488f = new CoreBaseFragment.c(this);
        ContractModel contractModel = (ContractModel) h(ContractModel.class);
        this.D = contractModel;
        contractModel.getContactList().observe(this, new Observer() { // from class: c.e.c.o.c.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1783a.S1((ResponseRowsVo) obj);
            }
        });
        this.D.getResultFddSign().observe(this, new Observer() { // from class: c.e.c.o.c.d0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1740a.U1((ResponseFddSignUrlVo) obj);
            }
        });
        this.D.getCancelPayLiveData().observe(this, new Observer() { // from class: c.e.c.o.c.a0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1734a.W1((ResponseStateVo) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.o.c.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1780a.Y1((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.D.getContractList(r(), this.B);
    }

    public final void j2() {
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        ContractListAdapter contractListAdapter = new ContractListAdapter();
        this.t = contractListAdapter;
        contractListAdapter.setEmptyTipMsg(x.getString(R.string.title_contract_empty));
        this.t.setOnItemClickListener(this.G);
        this.t.setOnClickListener(this.y);
    }

    public final void k2() {
        H();
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    public final void l2() {
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            cVar.removeCallbacks(this.H);
        }
    }

    public final void m2() {
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            cVar.postDelayed(this.H, 1000L);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            cVar.removeCallbacks(this.I);
        }
        L0(this);
        l2();
    }

    @m(threadMode = r.MAIN)
    public void subscribePayResult(EventPayStateVo eventPayStateVo) {
        H();
        if (!eventPayStateVo.isSuccess()) {
            G0(eventPayStateVo.getMsg());
        } else {
            this.f6483a = 1;
            j0();
        }
    }

    @m(threadMode = r.MAIN)
    public void updateEventContract(EventContract eventContract) {
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            cVar.postDelayed(this.I, 1000L);
        }
    }

    @m
    public void updateEventUpdateContractList(EventUpdateContractList eventUpdateContractList) {
        j0();
    }

    @m(threadMode = r.MAIN)
    public void updateList(UpdateContractEventVo updateContractEventVo) {
        j0();
    }
}
