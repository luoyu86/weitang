package com.chinavisionary.microtang.contract.fragment;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.contract.adapter.ContractPropertyStateAdapter;
import com.chinavisionary.microtang.contract.fragment.ContractPropertyStateFragment;
import com.chinavisionary.microtang.contract.model.ContractModel;
import com.chinavisionary.microtang.contract.vo.ContractPropertyStateVo;
import com.chinavisionary.microtang.contract.vo.SubmitPropertyStateVo;
import com.chinavisionary.microtang.contract.vo.WaterElectricReadBalanceVo;
import com.chinavisionary.microtang.main.vo.ResponseWaterElectricVo;
import com.chinavisionary.microtang.me.model.UserOperateModel;
import com.chinavisionary.microtang.repair.RepairActivity;
import com.chinavisionary.microtang.repair.RepairHistoryActivity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ContractPropertyStateFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public Boolean B;
    public ContractModel C;
    public boolean D;
    public boolean E;
    public ContractListDetailsFragment F;
    public List<ContractPropertyStateVo> G = new ArrayList();
    public List<LeftTitleToRightArrowVo> H;

    @BindView(R.id.btn_next)
    public AppCompatButton mButton;

    @BindView(R.id.tv_title_right)
    public TextView mRightTv;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: L1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M1(ResponseRowsVo responseRowsVo) {
        X1();
        if (responseRowsVo == null) {
            F0(R.string.data_error);
            return;
        }
        if (!responseRowsVo.getSuccess()) {
            G0(responseRowsVo.getMessage());
        } else if (responseRowsVo.getRows() == null || responseRowsVo.getRows().isEmpty()) {
            this.mButton.setVisibility(8);
        } else {
            J1(responseRowsVo.getRows());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: N1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O1(ResponseStateVo responseStateVo) {
        X1();
        if (F(responseStateVo, R.string.tip_submit_success, R.string.tip_submit_failed)) {
            F1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: P1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q1(RequestErrDto requestErrDto) {
        C(requestErrDto);
        X1();
    }

    public static /* synthetic */ void R1(ResponseWaterElectricVo responseWaterElectricVo) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: S1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T1(RequestErrDto requestErrDto) {
        C(requestErrDto);
        X1();
    }

    public static ContractPropertyStateFragment getInstance(String str) {
        ContractPropertyStateFragment contractPropertyStateFragment = new ContractPropertyStateFragment();
        contractPropertyStateFragment.setArguments(CoreBaseFragment.q(str));
        return contractPropertyStateFragment;
    }

    public final SubmitPropertyStateVo E1() {
        SubmitPropertyStateVo submitPropertyStateVo = new SubmitPropertyStateVo();
        ArrayList arrayList = new ArrayList();
        for (LeftTitleToRightArrowVo leftTitleToRightArrowVo : this.t.getList()) {
            if (leftTitleToRightArrowVo != null) {
                Object extObj = leftTitleToRightArrowVo.getExtObj();
                if (extObj instanceof ContractPropertyStateVo) {
                    ContractPropertyStateVo contractPropertyStateVo = (ContractPropertyStateVo) extObj;
                    SubmitPropertyStateVo.AssetRecognitionItemsBean assetRecognitionItemsBean = new SubmitPropertyStateVo.AssetRecognitionItemsBean();
                    assetRecognitionItemsBean.setAssetKey(contractPropertyStateVo.getAssetKey());
                    assetRecognitionItemsBean.setAssetRecognitionKey(contractPropertyStateVo.getAssetRecognitionKey());
                    int recognitionStatus = contractPropertyStateVo.getRecognitionStatus();
                    if (recognitionStatus == 3 || recognitionStatus == 5) {
                        this.E = true;
                    } else if (recognitionStatus != 6) {
                        return null;
                    }
                    assetRecognitionItemsBean.setRecognitionStatus(recognitionStatus);
                    arrayList.add(assetRecognitionItemsBean);
                } else {
                    continue;
                }
            }
        }
        if (!this.G.isEmpty()) {
            for (ContractPropertyStateVo contractPropertyStateVo2 : this.G) {
                if (contractPropertyStateVo2 != null) {
                    SubmitPropertyStateVo.AssetRecognitionItemsBean assetRecognitionItemsBean2 = new SubmitPropertyStateVo.AssetRecognitionItemsBean();
                    assetRecognitionItemsBean2.setAssetKey(contractPropertyStateVo2.getAssetKey());
                    assetRecognitionItemsBean2.setAssetRecognitionKey(contractPropertyStateVo2.getAssetRecognitionKey());
                    assetRecognitionItemsBean2.setRecognitionStatus(6);
                    arrayList.add(assetRecognitionItemsBean2);
                }
            }
        }
        submitPropertyStateVo.setAssetRecognitionItems(arrayList);
        return submitPropertyStateVo;
    }

    public final void F1() {
        setShowConfirm(Boolean.FALSE);
        this.mButton.setVisibility(8);
        I1();
        j0();
        ContractListDetailsFragment contractListDetailsFragment = this.F;
        if (contractListDetailsFragment != null) {
            contractListDetailsFragment.j0();
        }
        if (this.D) {
            m();
            K1();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void G1(View view, int i2) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        ((ContractPropertyStateVo) ((LeftTitleToRightArrowVo) this.t.getList().get(iIntValue)).getExtObj()).setRecognitionStatus(i2);
        this.t.notifyItemChanged(iIntValue);
        Y1();
    }

    public final void H1() {
        if (!x.isNotNull(this.f6484b)) {
            F0(R.string.data_error);
            return;
        }
        SubmitPropertyStateVo submitPropertyStateVoE1 = E1();
        if (submitPropertyStateVoE1 == null) {
            F0(R.string.tip_confirm_all_property_order);
        } else {
            z0(R.string.tip_submit_data_loading);
            this.C.postPropertyStateList(this.f6484b, submitPropertyStateVoE1);
        }
    }

    public final void I1() {
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) this.mSwipeRefreshLayout.getLayoutParams())).bottomMargin = 0;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void J1(List<ContractPropertyStateVo> list) {
        int size = list.size();
        this.H = new ArrayList();
        this.G.clear();
        WaterElectricReadBalanceVo waterElectricReadBalanceVo = new WaterElectricReadBalanceVo();
        for (int i2 = 0; i2 < size; i2++) {
            ContractPropertyStateVo contractPropertyStateVo = list.get(i2);
            if (contractPropertyStateVo != null) {
                int assetType = contractPropertyStateVo.getAssetType();
                Double value = contractPropertyStateVo.getValue();
                if (1 == assetType) {
                    this.G.add(contractPropertyStateVo);
                    waterElectricReadBalanceVo.setWaterName(contractPropertyStateVo.getAssetName());
                    waterElectricReadBalanceVo.setWaterBalance(value);
                } else if (2 == assetType) {
                    this.G.add(contractPropertyStateVo);
                    waterElectricReadBalanceVo.setElectricityName(contractPropertyStateVo.getAssetName());
                    waterElectricReadBalanceVo.setElectricity(value);
                } else if (5 == assetType) {
                    this.G.add(contractPropertyStateVo);
                    waterElectricReadBalanceVo.setHotWaterName(contractPropertyStateVo.getAssetName());
                    waterElectricReadBalanceVo.setHotWaterBalance(value);
                } else if (4 == assetType) {
                    this.G.add(contractPropertyStateVo);
                    waterElectricReadBalanceVo.setGasWaterName(contractPropertyStateVo.getAssetName());
                    waterElectricReadBalanceVo.setGasWaterBalance(value);
                } else {
                    Boolean bool = this.B;
                    contractPropertyStateVo.setClick(bool != null ? bool.booleanValue() : true);
                    LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
                    leftTitleToRightArrowVo.setType(2333);
                    leftTitleToRightArrowVo.setExtObj(contractPropertyStateVo);
                    this.H.add(leftTitleToRightArrowVo);
                }
            }
        }
        Z1(waterElectricReadBalanceVo);
        this.t.initListData((List<T>) this.H);
        Boolean bool2 = this.B;
        if (bool2 == null) {
            this.mButton.setVisibility(0);
            return;
        }
        if (!bool2.booleanValue()) {
            I1();
        }
        this.mButton.setVisibility(this.B.booleanValue() ? 0 : 8);
    }

    public final void K1() {
        if (this.E) {
            F0(R.string.tip_repair_device);
            d0(RepairActivity.class);
        }
    }

    public final void U1() {
        Intent intent = new Intent(this.f6487e, (Class<?>) RepairHistoryActivity.class);
        intent.setFlags(268435456);
        startActivity(intent);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        switch (view.getId()) {
            case R.id.btn_next /* 2131230879 */:
                H1();
                break;
            case R.id.cb_abnormal /* 2131230931 */:
                G1(view, 3);
                break;
            case R.id.cb_need_repair /* 2131230946 */:
                G1(view, 5);
                break;
            case R.id.cb_perfect /* 2131230954 */:
                G1(view, 6);
                break;
            case R.id.tv_title_right /* 2131232481 */:
                U1();
                break;
        }
    }

    public final void V1() {
        ContractModel contractModel = (ContractModel) h(ContractModel.class);
        this.C = contractModel;
        contractModel.getPropertyList().observe(this, new Observer() { // from class: c.e.c.o.c.o0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1763a.M1((ResponseRowsVo) obj);
            }
        });
        this.C.getRequestResult().observe(this, new Observer() { // from class: c.e.c.o.c.p0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1765a.O1((ResponseStateVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.o.c.l0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1757a.Q1((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_exit_rent_property_state);
        this.mRightTv.setText(R.string.title_repair_order);
        this.mRightTv.setOnClickListener(this.y);
        this.mButton.setOnClickListener(this.y);
        this.mRightTv.setVisibility(0);
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        ContractPropertyStateAdapter contractPropertyStateAdapter = new ContractPropertyStateAdapter();
        this.t = contractPropertyStateAdapter;
        contractPropertyStateAdapter.setOnClickListener(this.y);
        W1();
        V1();
        z0(R.string.loading_text);
        j0();
    }

    public final void W1() {
        UserOperateModel userOperateModel = (UserOperateModel) h(UserOperateModel.class);
        userOperateModel.getWaterElectricBalance().observe(this, new Observer() { // from class: c.e.c.o.c.n0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ContractPropertyStateFragment.R1((ResponseWaterElectricVo) obj);
            }
        });
        userOperateModel.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.o.c.m0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1759a.T1((RequestErrDto) obj);
            }
        });
    }

    public final void X1() {
        H();
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    public final void Y1() {
        int i2 = R.string.title_confirm_property_perfect;
        for (LeftTitleToRightArrowVo leftTitleToRightArrowVo : this.t.getList()) {
            if (leftTitleToRightArrowVo.getType() == 2333) {
                int recognitionStatus = ((ContractPropertyStateVo) leftTitleToRightArrowVo.getExtObj()).getRecognitionStatus();
                if (recognitionStatus == 3) {
                    i2 = R.string.title_confirm_device_repair;
                } else if (recognitionStatus == 5) {
                    i2 = R.string.title_confirm_device_need_defect;
                }
            }
        }
        this.mButton.setText(i2);
    }

    public final void Z1(WaterElectricReadBalanceVo waterElectricReadBalanceVo) {
        Double d2;
        Double hotWaterBalance;
        Double gasWaterBalance;
        Double d3 = null;
        if (waterElectricReadBalanceVo != null) {
            Double electricity = waterElectricReadBalanceVo.getElectricity();
            Double waterBalance = waterElectricReadBalanceVo.getWaterBalance();
            hotWaterBalance = waterElectricReadBalanceVo.getHotWaterBalance();
            gasWaterBalance = waterElectricReadBalanceVo.getGasWaterBalance();
            d2 = electricity;
            d3 = waterBalance;
        } else {
            d2 = null;
            hotWaterBalance = null;
            gasWaterBalance = null;
        }
        ArrayList arrayList = new ArrayList();
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo.setTitle(x.getString(R.string.tip_confirm_property_order));
        leftTitleToRightArrowVo.setTitle(true);
        arrayList.add(leftTitleToRightArrowVo);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo2.setLeft(x.getNotNullStr(waterElectricReadBalanceVo.getWaterName(), x.getString(R.string.title_water)));
        if (d3 != null) {
            leftTitleToRightArrowVo2.setRight(d3.toString() + x.getString(R.string.title_water_unit));
        } else {
            leftTitleToRightArrowVo2.setRight("-");
        }
        arrayList.add(leftTitleToRightArrowVo2);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo3 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo3.setLeft(x.getNotNullStr(waterElectricReadBalanceVo.getElectricityName(), x.getString(R.string.title_electric)));
        if (d2 != null) {
            leftTitleToRightArrowVo3.setRight(d2.toString() + x.getString(R.string.title_electricity_unit));
        } else {
            leftTitleToRightArrowVo3.setRight("-");
        }
        arrayList.add(leftTitleToRightArrowVo3);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo4 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo4.setLeft(x.getNotNullStr(waterElectricReadBalanceVo.getGasWaterName(), x.getString(R.string.title_gas)));
        if (gasWaterBalance != null) {
            leftTitleToRightArrowVo4.setRight(gasWaterBalance.toString() + x.getString(R.string.title_cube_unit));
        } else {
            leftTitleToRightArrowVo4.setRight("-");
        }
        arrayList.add(leftTitleToRightArrowVo4);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo5 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo5.setLeft(x.getNotNullStr(waterElectricReadBalanceVo.getHotWaterName(), x.getString(R.string.title_hot_water)));
        if (hotWaterBalance != null) {
            leftTitleToRightArrowVo5.setRight(hotWaterBalance.toString() + x.getString(R.string.title_water_unit));
        } else {
            leftTitleToRightArrowVo5.setRight("-");
        }
        arrayList.add(leftTitleToRightArrowVo5);
        this.H.addAll(0, arrayList);
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_contract_property_state;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.C.getPropertyStateList(this.f6484b);
    }

    public void setContractListDetailsFragment(ContractListDetailsFragment contractListDetailsFragment) {
        this.F = contractListDetailsFragment;
    }

    public void setFinish(boolean z) {
        this.D = z;
    }

    public void setShowConfirm(Boolean bool) {
        this.B = bool;
    }
}
