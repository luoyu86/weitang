package com.chinavisionary.microtang.buycart.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.y.e.d;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.buycart.adapter.BuyCartAdapter;
import com.chinavisionary.microtang.buycart.model.BuyCartModel;
import com.chinavisionary.microtang.buycart.vo.BuyCartVo;
import com.chinavisionary.microtang.buycart.vo.RequestDelBuyCartBo;
import com.chinavisionary.microtang.merchant.MerchantMainActivity;
import com.chinavisionary.microtang.merchant.vo.SpecificationsVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BuyCartFragment extends BaseFragment<BuyCartVo> {
    public c.e.c.k.c.a B;
    public BuyCartModel C;
    public d D = new a();

    @BindView(R.id.cb_all_select)
    public AppCompatCheckBox mAllSelectCb;

    @BindView(R.id.tv_buy_cart_count_price)
    public TextView mCountPriceTv;

    @BindView(R.id.tv_title_right)
    public TextView mRightTv;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements d {
        public a() {
        }

        @Override // c.e.c.y.e.d
        public void updateToPositionSelectedSpec(int i2, SpecificationsVo specificationsVo) {
            BuyCartFragment.this.j0();
        }
    }

    public static BuyCartFragment getInstance() {
        return new BuyCartFragment();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void E1() {
        BuyCartVo buyCartVo = new BuyCartVo();
        buyCartVo.setItemType(34952);
        this.t.initListData(null);
        this.t.addDataToList((T) buyCartVo);
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
    public final void F1(View view) {
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) view;
        if (o.isNotEmpty(this.t.getList()) && this.t.getItemViewType(0) != 34952) {
            this.B.handleAllSelect(appCompatCheckBox.isChecked(), this.t);
        } else {
            appCompatCheckBox.setChecked(false);
            F0(R.string.tip_buy_cart_is_empty);
        }
    }

    public final void G1(View view) {
        BuyCartVo buyCartVo = (BuyCartVo) this.t.getList().get(((Integer) view.getTag(view.getId())).intValue());
        if (buyCartVo != null) {
            q.d(getClass().getSimpleName(), "merchant key :" + buyCartVo.getMerchantKey());
            c0(MerchantMainActivity.class, buyCartVo.getMerchantKey());
        }
    }

    public final void H1(ResponseRowsVo<BuyCartVo> responseRowsVo) {
        this.mSwipeRefreshLayout.setRefreshing(false);
        if (responseRowsVo == null || !responseRowsVo.getSuccess()) {
            E1();
            return;
        }
        List<BuyCartVo> rows = responseRowsVo.getRows();
        this.B.handleSelectCartKey(this.t.getList(), rows);
        D(rows);
        if (o.listIsEmpty(rows)) {
            E1();
        }
    }

    public final void I1() {
        List<String> selectSpecKey = this.B.getSelectSpecKey(this.t.getList());
        RequestDelBuyCartBo requestDelBuyCartBo = new RequestDelBuyCartBo();
        requestDelBuyCartBo.setCartKeys(selectSpecKey);
        this.C.delBuyCart(requestDelBuyCartBo);
    }

    public final void J1() {
        List<String> selectSpecKey = this.B.getSelectSpecKey(this.t.getList());
        if (selectSpecKey == null || selectSpecKey.isEmpty()) {
            F0(R.string.tip_not_select_product);
        } else {
            u0(x.getString(R.string.tip_alert_del_buy_cart));
        }
    }

    public final void K1(ResponseStateVo responseStateVo) {
        F0(R.string.tip_del_success);
        j0();
    }

    public final void L1(RequestErrDto requestErrDto) {
        this.mSwipeRefreshLayout.setRefreshing(false);
        C(requestErrDto);
    }

    public final void M1(ResponseStateVo responseStateVo) {
    }

    public final void R1() {
        BuyCartModel buyCartModel = (BuyCartModel) h(BuyCartModel.class);
        this.C = buyCartModel;
        buyCartModel.getBuyCartResult().observe(this, new Observer() { // from class: c.e.c.k.b.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1629a.H1((ResponseRowsVo) obj);
            }
        });
        this.C.getDelResult().observe(this, new Observer() { // from class: c.e.c.k.b.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1631a.K1((ResponseStateVo) obj);
            }
        });
        this.C.getUpdateResult().observe(this, new Observer() { // from class: c.e.c.k.b.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1630a.M1((ResponseStateVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.k.b.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1628a.L1((RequestErrDto) obj);
            }
        });
        this.B.setBuyCartModel(this.C);
    }

    public final void S1() {
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        BuyCartAdapter buyCartAdapter = new BuyCartAdapter(1);
        this.t = buyCartAdapter;
        buyCartAdapter.setOnClickListener(this.y);
    }

    public final void T1() {
        this.B = new c.e.c.k.c.a(this.mAllSelectCb, this.mCountPriceTv);
        this.mTitleTv.setText(R.string.title_buy_cart);
        this.mRightTv.setText(R.string.title_delete);
        this.mRightTv.setVisibility(0);
        this.mRightTv.setOnClickListener(this.y);
        this.mAllSelectCb.setOnClickListener(this.y);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        switch (view.getId()) {
            case R.id.cb_all_select /* 2131230934 */:
                F1(view);
                break;
            case R.id.cb_business /* 2131230938 */:
                this.B.selectAllBusinessProduct(view, this.t);
                break;
            case R.id.cb_product /* 2131230956 */:
                this.B.handleCbProductBusiness(view, this.t);
                break;
            case R.id.img_btn_add /* 2131231196 */:
                this.B.handleAddOrReduceSpecNumber(view, true, this.t);
                break;
            case R.id.img_btn_reduce /* 2131231200 */:
                this.B.handleAddOrReduceSpecNumber(view, false, this.t);
                break;
            case R.id.img_business_cover /* 2131231202 */:
                G1(view);
                break;
            case R.id.tv_alert_confirm /* 2131231942 */:
                I1();
                break;
            case R.id.tv_title_right /* 2131232481 */:
                J1();
                break;
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        T1();
        S1();
        R1();
        z0(R.string.loading_text);
    }

    @OnClick({R.id.tv_back})
    public void finishFragment(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_buy_cart;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.C.getAllBuyCartList(r());
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        j0();
    }

    @OnClick({R.id.btn_submit_order})
    public void submitOrder(View view) {
        if (!o.isNotEmpty(this.B.getSelectSpecKey(this.t.getList()))) {
            F0(R.string.tip_not_select_product);
            return;
        }
        BuyCartSubmitOrderFragment buyCartSubmitOrderFragment = BuyCartSubmitOrderFragment.getInstance(3);
        buyCartSubmitOrderFragment.setSelectBuyCartList(this.B.getSelectProductList(this.t.getList()));
        K0(buyCartSubmitOrderFragment, R.id.flayout_content);
    }
}
