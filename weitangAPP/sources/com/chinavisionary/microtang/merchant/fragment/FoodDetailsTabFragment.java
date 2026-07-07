package com.chinavisionary.microtang.merchant.fragment;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.y.c.d;
import c.e.c.y.c.f;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.base.TabFragmentAdapter;
import com.chinavisionary.microtang.buycart.fragment.BuyCartSubmitOrderFragment;
import com.chinavisionary.microtang.buycart.vo.BuyCartProductVo;
import com.chinavisionary.microtang.buycart.vo.BuyCartVo;
import com.chinavisionary.microtang.merchant.vo.BuyCartCountVo;
import com.chinavisionary.microtang.merchant.vo.FoodDetailsInParam;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FoodDetailsTabFragment extends BaseFragment<String> {
    public int B;
    public boolean C;
    public String D;
    public List<String> E;
    public List<BuyCartVo> F;
    public FoodDetailsInParam G;
    public c.e.c.y.e.b H;
    public d I;
    public f J;
    public TabFragmentAdapter K;
    public c.e.c.y.e.a L = new a();
    public c.e.c.y.e.b M = new b();

    @BindView(R.id.view_pager_food_spec)
    public ViewPager mFoodSpecViewPager;

    public class a implements c.e.c.y.e.a {
        public a() {
        }

        @Override // c.e.c.y.e.a
        public void clearBuyCart() {
            FoodDetailsTabFragment.this.R1();
            FoodDetailsTabFragment.this.S1();
        }

        @Override // c.e.c.y.e.a
        public void updateSelectedSpecToFoodVo(BuyCartProductVo buyCartProductVo) {
            FoodDetailsTabFragment.this.R1();
            FoodDetailsTabFragment.this.S1();
        }
    }

    public class b implements c.e.c.y.e.b {
        public b() {
        }

        @Override // c.e.c.y.e.b
        public void buyCartList(List<BuyCartVo> list) {
            FoodDetailsTabFragment.this.F = list;
            q.d(FoodDetailsFragment.class.getSimpleName(), "buyCartList");
            if (FoodDetailsTabFragment.this.H != null) {
                FoodDetailsTabFragment.this.H.buyCartList(list);
            }
        }

        @Override // c.e.c.y.e.b
        public Fragment getCurrentFragment() {
            return FoodDetailsTabFragment.this;
        }

        @Override // c.e.c.y.e.b
        public void setupBuyCartCountVo(BuyCartCountVo buyCartCountVo) {
            FoodDetailsTabFragment.this.J.updateBuyCountAndPrice(buyCartCountVo);
            if (FoodDetailsTabFragment.this.H != null) {
                FoodDetailsTabFragment.this.H.setupBuyCartCountVo(buyCartCountVo);
            }
            q.d(FoodDetailsFragment.class.getSimpleName(), "setupBuyCartCountVo");
        }
    }

    public static FoodDetailsTabFragment getInstance(List<String> list, FoodDetailsInParam foodDetailsInParam, int i2) {
        FoodDetailsTabFragment foodDetailsTabFragment = new FoodDetailsTabFragment();
        foodDetailsTabFragment.P1(i2);
        foodDetailsTabFragment.N1(list);
        foodDetailsTabFragment.O1(foodDetailsInParam);
        return foodDetailsTabFragment;
    }

    public final List<Fragment> J1() {
        this.G.setiBuyCartView(this.M);
        ArrayList arrayList = new ArrayList();
        for (String str : this.E) {
            if (x.isNotNull(str)) {
                this.G.setProductKey(str);
                arrayList.add(FoodDetailsFragment.getInstance(this.G));
            }
        }
        return arrayList;
    }

    public final boolean K1() {
        boolean zK = K(FoodBuyCartFragment.class);
        if (zK) {
            g0();
        }
        return !zK;
    }

    public final boolean L1() {
        if (!this.C) {
            F0(R.string.tip_merchant_close);
        }
        return this.C;
    }

    public final void M1() {
        if (m1() && K1() && x.isNotNull(this.D)) {
            d(FoodBuyCartFragment.getInstance(this.L, this.D), R.id.flayout_content);
        }
    }

    public final void N1(List<String> list) {
        this.E = list;
    }

    public final void O1(FoodDetailsInParam foodDetailsInParam) {
        this.G = foodDetailsInParam;
        this.H = foodDetailsInParam.getiBuyCartView();
    }

    public final void P1(int i2) {
        this.B = i2;
    }

    public final void Q1() {
        if (!o.isNotEmpty(this.E) || this.G == null) {
            return;
        }
        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter(getChildFragmentManager(), J1());
        this.K = tabFragmentAdapter;
        this.mFoodSpecViewPager.setAdapter(tabFragmentAdapter);
        this.mFoodSpecViewPager.setCurrentItem(this.B);
    }

    public final void R1() {
        d dVar;
        if (!O() || (dVar = this.I) == null) {
            return;
        }
        dVar.getBuyCartToMerchantKey();
    }

    public final void S1() {
        ((FoodDetailsFragment) this.K.getFragments().get(this.mFoodSpecViewPager.getCurrentItem())).setUserVisibleHint(true);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.C = this.G.isOpenMerchant();
        this.D = this.G.getMerchantKey();
        Q1();
        this.J = new f(this.u);
        this.I = new d(this.M, this.D);
    }

    @OnClick({R.id.tv_contact_merchant})
    public void callMerchant() {
        K1();
        f(this.G.getMerchantPhone());
    }

    @OnClick({R.id.view_bottom_bg})
    public void foodBuyCartClick() {
        M1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_food_tab_details_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @OnClick({R.id.tv_settlement})
    public void openSettlementActivity() {
        K1();
        if (m1() && L1()) {
            if (!o.isNotEmpty(this.F)) {
                F0(R.string.tip_setting_buy_cart_is_empty);
                return;
            }
            BuyCartSubmitOrderFragment buyCartSubmitOrderFragment = BuyCartSubmitOrderFragment.getInstance(5);
            buyCartSubmitOrderFragment.setSelectBuyCartList(this.F);
            K0(buyCartSubmitOrderFragment, R.id.flayout_content);
        }
    }
}
