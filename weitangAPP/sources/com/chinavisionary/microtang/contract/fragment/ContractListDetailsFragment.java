package com.chinavisionary.microtang.contract.fragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.a.c.c.a;
import c.e.a.d.x;
import c.e.c.o.d.b;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.bill.BillTabActivity;
import com.chinavisionary.microtang.bill.model.BillModel;
import com.chinavisionary.microtang.contract.adapter.ContractListDetailsAdapter;
import com.chinavisionary.microtang.contract.model.ContractModel;
import com.chinavisionary.microtang.contract.vo.ContractListDetailsVo;
import com.chinavisionary.microtang.contract.vo.EventUpdateContractList;
import com.chinavisionary.microtang.contract.vo.ResponseFddSignUrlVo;
import com.chinavisionary.microtang.contract.vo.UpdateContractEventVo;
import com.chinavisionary.microtang.me.vo.EventContract;
import com.chinavisionary.microtang.pdf.PdfActivity;
import com.chinavisionary.microtang.room.KeepRentActivity;
import com.chinavisionary.microtang.sign.fragments.RoomSignContractNearbyFragment;
import com.chinavisionary.microtang.sign.vo.ResponseFddVo;
import com.chinavisionary.microtang.sign.vo.ResponseFirstFeeVo;
import com.chinavisionary.microtang.web.WebFragment;
import com.chinavisionary.paymentlibrary.vo.EventPayStateVo;
import g.b.a.m;
import g.b.a.r;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ContractListDetailsFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public int B;
    public String C;
    public String D;
    public String E;
    public boolean F;
    public ContractListFragment G;
    public ContractModel H;
    public b I;
    public BillModel J;
    public a K = new a() { // from class: c.e.c.o.c.r
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1768a.O1(view, i2);
        }
    };

    @BindView(R.id.btn_action)
    public AppCompatButton mActionBtn;

    @BindView(R.id.btn_change_rent)
    public AppCompatButton mChangeRentBtn;

    @BindView(R.id.btn_keep_rent)
    public AppCompatButton mKeepRentBtn;

    @BindView(R.id.btn_rent_change)
    public AppCompatButton mRentChangeBtn;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: N1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O1(View view, int i2) {
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = (LeftTitleToRightArrowVo) this.t.getList().get(i2);
        switch (leftTitleToRightArrowVo.getOnlyKey()) {
            case 1:
                d2(leftTitleToRightArrowVo);
                break;
            case 2:
                Z1(leftTitleToRightArrowVo);
                break;
            case 3:
                Y1();
                break;
            case 4:
                f2(leftTitleToRightArrowVo);
                break;
            case 5:
                F1(leftTitleToRightArrowVo.getRight());
                break;
            case 6:
                E1((String) leftTitleToRightArrowVo.getExtObj());
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Q1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R1(ContractListDetailsVo contractListDetailsVo) {
        m2();
        if (contractListDetailsVo != null) {
            setState(contractListDetailsVo.getContractStatus());
            i2(contractListDetailsVo.getContractStatusName());
            j2(contractListDetailsVo);
            L1(contractListDetailsVo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: S1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T1(ResponseFddSignUrlVo responseFddSignUrlVo) {
        m2();
        if (responseFddSignUrlVo == null || !responseFddSignUrlVo.isSuccess()) {
            F0(R.string.title_get_contract_failed);
            return;
        }
        ResponseFddVo responseFddVo = new ResponseFddVo();
        responseFddVo.setSignUrl(responseFddSignUrlVo.getContractSignUrl());
        responseFddVo.setReturnUrl(responseFddSignUrlVo.getNotifyUrl());
        responseFddVo.setContractCode(this.f6484b);
        g2(responseFddVo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: U1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V1(ResponseStateVo responseStateVo) {
        m2();
        if (F(responseStateVo, R.string.tip_cancel_success, R.string.tip_cancel_failed)) {
            h2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: W1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X1(ResponseFirstFeeVo responseFirstFeeVo) {
        m2();
        if (responseFirstFeeVo == null || !responseFirstFeeVo.isSuccess()) {
            F0(R.string.tip_pay_failed);
        } else {
            c2(responseFirstFeeVo);
        }
    }

    public static ContractListDetailsFragment getInstance(String str, int i2, String str2) {
        ContractListDetailsFragment contractListDetailsFragment = new ContractListDetailsFragment();
        contractListDetailsFragment.setArguments(CoreBaseFragment.q(str));
        contractListDetailsFragment.setState(i2);
        contractListDetailsFragment.i2(str2);
        return contractListDetailsFragment;
    }

    public final void E1(String str) {
        ClipboardManager clipboardManager = (ClipboardManager) this.f6486d.getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText(null, str));
            F0(R.string.tip_download_address_copy_success);
        }
    }

    public final void F1(String str) {
        ClipboardManager clipboardManager = (ClipboardManager) this.f6486d.getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText(null, x.appendStringToResId(R.string.placeholder_wt_sign_code, str)));
            F0(R.string.tip_sign_code_copy_success);
        }
    }

    public final void G1() {
        z0(R.string.tip_cancel_contract);
        this.H.cancelPay(this.f6484b);
    }

    public final void H1() {
        if (x.isNotNull(this.E)) {
            d(ChangeRentFragment.getInstance(this.f6484b, this.E), R.id.flayout_content);
        } else {
            F0(R.string.tip_room_name_empty);
        }
    }

    public final void I1(RequestErrDto requestErrDto) {
        m2();
        C(requestErrDto);
    }

    public final void J1() {
        if (x.isNotNull(this.D)) {
            Intent intent = new Intent(this.f6487e, (Class<?>) KeepRentActivity.class);
            intent.putExtra("key", this.D);
            startActivity(intent);
        }
    }

    public final void K1(String str) {
        z0(R.string.tip_get_pay_data_load);
        this.J.getBillFirstFee(str);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void L1(ContractListDetailsVo contractListDetailsVo) {
        int i2;
        this.D = contractListDetailsVo.getAssetKey();
        this.E = contractListDetailsVo.getAssetAddress();
        this.F = contractListDetailsVo.isRentBackFlag();
        AppCompatButton appCompatButton = this.mKeepRentBtn;
        if (contractListDetailsVo.isRenewalFlag()) {
            i2 = 0;
        } else {
            this.mActionBtn.getVisibility();
            i2 = 8;
        }
        appCompatButton.setVisibility(i2);
        this.mChangeRentBtn.setVisibility(contractListDetailsVo.isChangeRentFlag() ? 0 : 8);
        this.t.initListData((List<T>) this.I.getAdapterData(contractListDetailsVo));
    }

    public final boolean M1() {
        int i2 = this.B;
        return i2 == 16 || i2 == 17;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.btn_keep_rent) {
            J1();
        } else {
            if (id != R.id.tv_alert_confirm) {
                return;
            }
            G1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_contract_details);
        k2();
        l2();
        j2(null);
        z0(R.string.loading_text);
        I1();
    }

    public final void Y1() {
        d0(BillTabActivity.class);
    }

    public final void Z1(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
        Object extObj = leftTitleToRightArrowVo.getExtObj();
        if (!(extObj instanceof String)) {
            F0(R.string.title_contract_is_empty);
            return;
        }
        Intent intent = new Intent(this.f6487e, (Class<?>) PdfActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key", (String) extObj);
        intent.putExtra("titleKey", this.E + x.getString(R.string.title_contact));
        startActivity(intent);
    }

    public final void a2(String str) {
        z0(R.string.tip_get_contract);
        this.H.getFddSignUrl(str);
    }

    public final void b2(String str) {
        K0(RoomSignContractNearbyFragment.getInstance(str), R.id.flayout_content);
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    public final void c2(ResponseFirstFeeVo responseFirstFeeVo) {
        K0(this.I.getPayTypeFragmentToResponseFirstFeeVo(responseFirstFeeVo, this.f6484b), R.id.flayout_content);
    }

    public final void d2(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
        ContractPropertyStateFragment contractPropertyStateFragment = ContractPropertyStateFragment.getInstance(leftTitleToRightArrowVo.getKey());
        if (leftTitleToRightArrowVo.getExtObj() != null) {
            boolean z = false;
            if ((((ContractListDetailsVo) leftTitleToRightArrowVo.getExtObj()).getAssetRecognitionStatus() == 1) && this.B == 16) {
                z = true;
            }
            contractPropertyStateFragment.setShowConfirm(Boolean.valueOf(z));
        }
        contractPropertyStateFragment.setContractListDetailsFragment(this);
        K0(contractPropertyStateFragment, R.id.flayout_content);
    }

    public final void e2(String str) {
        K0(ContractRescissionDetailsFragment.getInstance(str), R.id.flayout_content);
    }

    public final void f2(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
        ContractLiveTogetherFragment contractLiveTogetherFragment = ContractLiveTogetherFragment.getInstance(leftTitleToRightArrowVo.getKey());
        contractLiveTogetherFragment.setEdit(M1());
        K0(contractLiveTogetherFragment, R.id.flayout_content);
    }

    public final void g2(ResponseFddVo responseFddVo) {
        H();
        if (responseFddVo == null || !x.isNotNull(responseFddVo.getSignUrl())) {
            F0(R.string.title_get_contract_failed);
            return;
        }
        WebFragment webFragment = WebFragment.getInstance(responseFddVo.getSignUrl());
        webFragment.setResponseFddVo(responseFddVo);
        K0(webFragment, R.id.flayout_content);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_contract_list_details;
    }

    public final void h2() {
        I1();
        ContractListFragment contractListFragment = this.G;
        if (contractListFragment != null) {
            contractListFragment.I1();
        }
    }

    @OnClick({R.id.btn_action})
    public void handlerAction(View view) {
        ContractListDetailsVo contractListDetailsVo = (ContractListDetailsVo) view.getTag();
        if (contractListDetailsVo != null && contractListDetailsVo.isRentBackInfoFlag()) {
            e2(this.f6484b);
            return;
        }
        int i2 = this.B;
        if (i2 == 10) {
            b2(this.f6484b);
        } else if (i2 == 11) {
            K1(this.f6484b);
        } else {
            if (i2 != 13) {
                return;
            }
            a2(this.f6484b);
        }
    }

    public final void i2(String str) {
        this.C = str;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
        this.H.getContractListDetails(this.f6484b);
    }

    public final void j2(ContractListDetailsVo contractListDetailsVo) {
        boolean zIsRentBackFlag = this.B == 16;
        if (contractListDetailsVo != null && contractListDetailsVo.isRentBackInfoFlag()) {
            this.C = x.getString(R.string.title_cat_rescission);
        }
        int i2 = this.B;
        boolean z = i2 == 11 || i2 == 10;
        if (contractListDetailsVo != null) {
            this.mActionBtn.setTag(contractListDetailsVo);
            zIsRentBackFlag = contractListDetailsVo.isRentBackFlag();
        }
        this.mRentChangeBtn.setVisibility((z || zIsRentBackFlag) ? 0 : 8);
        this.mRentChangeBtn.setText(z ? R.string.title_cancel : R.string.title_apply_exit_rent);
        this.mActionBtn.setVisibility(zIsRentBackFlag ? 8 : 0);
        this.mKeepRentBtn.setVisibility(zIsRentBackFlag ? 8 : 4);
        this.mActionBtn.setText(x.getNotNullStr(zIsRentBackFlag ? x.getString(R.string.title_comment) : this.C, ""));
        boolean z2 = this.B > 17;
        int i3 = z2 ? R.color.color_bg : R.color.tab_item_select_color;
        int i4 = z2 ? R.color.colore757575 : R.color.color_white;
        this.mActionBtn.setBackgroundColor(getResources().getColor(i3));
        this.mActionBtn.setTextColor(getResources().getColor(i4));
        this.mKeepRentBtn.setOnClickListener(this.y);
    }

    public final void k2() {
        h0(this);
        this.I = new b();
        ContractModel contractModel = (ContractModel) h(ContractModel.class);
        this.H = contractModel;
        contractModel.getContactListDetailsLiveData().observe(this, new Observer() { // from class: c.e.c.o.c.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1776a.R1((ContractListDetailsVo) obj);
            }
        });
        this.H.getResultFddSign().observe(this, new Observer() { // from class: c.e.c.o.c.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1770a.T1((ResponseFddSignUrlVo) obj);
            }
        });
        this.H.getCancelPayLiveData().observe(this, new Observer() { // from class: c.e.c.o.c.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1772a.V1((ResponseStateVo) obj);
            }
        });
        this.H.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.o.c.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1778a.I1((RequestErrDto) obj);
            }
        });
        BillModel billModel = (BillModel) h(BillModel.class);
        this.J = billModel;
        billModel.getBillFirstFeeLiveData().observe(this, new Observer() { // from class: c.e.c.o.c.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1774a.X1((ResponseFirstFeeVo) obj);
            }
        });
        this.J.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.o.c.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1778a.I1((RequestErrDto) obj);
            }
        });
    }

    public final void l2() {
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        ContractListDetailsAdapter contractListDetailsAdapter = new ContractListDetailsAdapter();
        this.t = contractListDetailsAdapter;
        contractListDetailsAdapter.setOnClickListener(this.y);
        this.t.setOnItemClickListener(this.K);
    }

    public final void m2() {
        H();
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    @OnClick({R.id.btn_change_rent})
    public void openChangeRent(View view) {
        H1();
    }

    @OnClick({R.id.btn_rent_change})
    public void openContractChangeFragment(View view) {
        int i2 = this.B;
        if (i2 == 11 || i2 == 10) {
            u0(x.getString(R.string.title_alert_confirm_cancel_contract));
        } else {
            K0(ContractExitRentFragment.getInstance(this.f6484b), R.id.flayout_content);
        }
    }

    public void setContractListFragment(ContractListFragment contractListFragment) {
        this.G = contractListFragment;
    }

    public final void setState(int i2) {
        this.B = i2;
    }

    @m(threadMode = r.MAIN)
    public void subscribePayResult(EventPayStateVo eventPayStateVo) {
        H();
        if (eventPayStateVo.isSuccess()) {
            I1();
        } else {
            G0(eventPayStateVo.getMsg());
        }
    }

    @m(threadMode = r.MAIN)
    public void updateEventContract(EventContract eventContract) {
        I1();
    }

    @m
    public void updateEventUpdateContractList(EventUpdateContractList eventUpdateContractList) {
        I1();
    }

    @m(threadMode = r.MAIN)
    public void updateList(UpdateContractEventVo updateContractEventVo) {
        I1();
    }
}
