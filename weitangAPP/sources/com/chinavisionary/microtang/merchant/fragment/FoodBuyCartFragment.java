package com.chinavisionary.microtang.merchant.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.o;
import c.e.a.d.x;
import c.e.c.y.e.a;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.core.weight.ItemDecoration;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.buycart.model.BuyCartModel;
import com.chinavisionary.microtang.buycart.vo.BuyCartProductVo;
import com.chinavisionary.microtang.buycart.vo.BuyCartVo;
import com.chinavisionary.microtang.buycart.vo.RequestDelBuyCartBo;
import com.chinavisionary.microtang.buycart.vo.RequestUpdateBuyCartBo;
import com.chinavisionary.microtang.merchant.adapter.FoodBuyCardAdapter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FoodBuyCartFragment extends BaseFragment<BuyCartProductVo> {
    public int B = -1;
    public a C;
    public BuyCartModel D;

    @BindView(R.id.tv_clear_buy_cart)
    public TextView mClearBuyCartTv;

    @BindView(R.id.recycler_food_buy_cart)
    public BaseRecyclerView mFoodBuyCartRecyclerView;

    public static FoodBuyCartFragment getInstance(a aVar, String str) {
        FoodBuyCartFragment foodBuyCartFragment = new FoodBuyCartFragment();
        foodBuyCartFragment.R1(aVar);
        foodBuyCartFragment.setArguments(CoreBaseFragment.q(str));
        return foodBuyCartFragment;
    }

    public final void E1(List<String> list) {
        if (o.isNotEmpty(list)) {
            RequestDelBuyCartBo requestDelBuyCartBo = new RequestDelBuyCartBo();
            requestDelBuyCartBo.setCartKeys(list);
            this.D.delBuyCart(requestDelBuyCartBo);
        }
    }

    public final void F1(ResponseStateVo responseStateVo) {
        H();
        if (this.B != -1) {
            this.t.getList().remove(this.B);
            this.t.notifyDataSetChanged();
        } else {
            this.t.initListData(null);
        }
        a aVar = this.C;
        if (aVar != null) {
            aVar.clearBuyCart();
        }
        j0();
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
    public final void G1(View view) {
        this.B = ((Integer) view.getTag()).intValue();
        int iIntValue = ((Integer) view.getTag(R.id.tv_spec_number)).intValue();
        BuyCartProductVo buyCartProductVo = (BuyCartProductVo) this.t.getList().get(this.B);
        buyCartProductVo.setQuantity(iIntValue);
        if (iIntValue == 0) {
            Q1(buyCartProductVo.getCartKey());
        } else {
            U1(buyCartProductVo);
            this.t.notifyItemChanged(this.B);
        }
    }

    public final void H1() {
        if (this.B != -1) {
            Q1(((BuyCartProductVo) this.t.getList().get(this.B)).getCartKey());
        } else {
            J1();
        }
    }

    public final void I1(ResponseRowsVo<BuyCartVo> responseRowsVo) {
        H();
        if (responseRowsVo == null) {
            T1();
            return;
        }
        BuyCartVo buyCartVo = (BuyCartVo) o.getFirstElement(responseRowsVo.getRows());
        if (buyCartVo == null) {
            T1();
        } else {
            this.mClearBuyCartTv.setVisibility(0);
            D(buyCartVo.getCommodities());
        }
    }

    public final void J1() {
        z0(R.string.tip_submit_data_loading);
        ArrayList arrayList = new ArrayList();
        for (BuyCartProductVo buyCartProductVo : this.t.getList()) {
            if (buyCartProductVo != null) {
                arrayList.add(buyCartProductVo.getCartKey());
            }
        }
        E1(arrayList);
    }

    public final void K1(ResponseStateVo responseStateVo) {
        i("update success");
        a aVar = this.C;
        if (aVar != null) {
            aVar.updateSelectedSpecToFoodVo((BuyCartProductVo) this.t.getList().get(this.B));
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
    public final void L1() {
        if (this.B != -1) {
            ((BuyCartProductVo) this.t.getList().get(this.B)).setQuantity(1);
            this.t.notifyItemChanged(this.B);
        }
    }

    public final void Q1(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        E1(arrayList);
    }

    public final void R1(a aVar) {
        this.C = aVar;
    }

    public final void S1() {
        BuyCartModel buyCartModel = (BuyCartModel) h(BuyCartModel.class);
        this.D = buyCartModel;
        buyCartModel.getMerchantBuyCartResult().observe(this, new Observer() { // from class: c.e.c.y.b.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2227a.I1((ResponseRowsVo) obj);
            }
        });
        this.D.getDelResult().observe(this, new Observer() { // from class: c.e.c.y.b.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2225a.F1((ResponseStateVo) obj);
            }
        });
        this.D.getUpdateResult().observe(this, new Observer() { // from class: c.e.c.y.b.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2226a.K1((ResponseStateVo) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.y.b.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2228a.C((RequestErrDto) obj);
            }
        });
    }

    public final void T1() {
        this.mClearBuyCartTv.setVisibility(8);
        ((FoodBuyCardAdapter) this.t).setupEmptyData();
    }

    public final void U1(BuyCartProductVo buyCartProductVo) {
        RequestUpdateBuyCartBo requestUpdateBuyCartBo = new RequestUpdateBuyCartBo();
        requestUpdateBuyCartBo.setCartKey(buyCartProductVo.getCartKey());
        requestUpdateBuyCartBo.setQuantity(buyCartProductVo.getQuantity());
        this.D.updateBuyCart(requestUpdateBuyCartBo);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        switch (view.getId()) {
            case R.id.img_btn_add /* 2131231196 */:
            case R.id.img_btn_reduce /* 2131231200 */:
                G1(view);
                break;
            case R.id.tv_alert_cancel /* 2131231941 */:
                L1();
                break;
            case R.id.tv_alert_confirm /* 2131231942 */:
                H1();
                break;
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.u.setOnTouchListener(null);
        this.r = this.mFoodBuyCartRecyclerView;
        this.r.addItemDecoration(new ItemDecoration(getResources().getDimensionPixelSize(R.dimen.dp_5), getResources().getDrawable(R.drawable.bg_food_buy_cart_recycler_item_line)));
        FoodBuyCardAdapter foodBuyCardAdapter = new FoodBuyCardAdapter();
        this.t = foodBuyCardAdapter;
        foodBuyCardAdapter.setOnClickListener(this.y);
        S1();
        z0(R.string.loading_text);
        j0();
    }

    @OnClick({R.id.tv_clear_buy_cart})
    public void clearBuyCart(View view) {
        this.B = -1;
        u0(x.getString(R.string.tip_alert_clear_buy_cart));
    }

    @OnClick({R.id.view_bg})
    public void finishFragment(View view) {
        g0();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_food_buy_cart;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.D.getMerchantBuyCartList(r(), this.f6484b);
    }
}
