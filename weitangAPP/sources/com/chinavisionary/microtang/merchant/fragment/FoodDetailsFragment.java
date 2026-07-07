package com.chinavisionary.microtang.merchant.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import anet.channel.util.ErrorConstant;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.y.c.d;
import c.e.c.y.c.e;
import c.e.c.y.c.f;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.base.TabFragmentAdapter;
import com.chinavisionary.microtang.buycart.BuyCartActivity;
import com.chinavisionary.microtang.buycart.fragment.BuyCartSubmitOrderFragment;
import com.chinavisionary.microtang.buycart.vo.BuyCartProductVo;
import com.chinavisionary.microtang.buycart.vo.BuyCartVo;
import com.chinavisionary.microtang.merchant.model.MerchantCommodityModel;
import com.chinavisionary.microtang.merchant.vo.BuyCartCountVo;
import com.chinavisionary.microtang.merchant.vo.CommodityVo;
import com.chinavisionary.microtang.merchant.vo.EventUpdateBuyCartPrice;
import com.chinavisionary.microtang.merchant.vo.FoodDetailsInParam;
import com.chinavisionary.microtang.merchant.vo.SpecificationsVo;
import com.chinavisionary.microtang.web.WebFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import g.b.a.c;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FoodDetailsFragment extends BaseFragment<String> {
    public WebFragment C;
    public e D;
    public f E;
    public FoodDetailsInParam F;
    public BuyCartCountVo G;
    public String H;
    public boolean I;
    public c.e.c.y.e.b J;
    public d K;
    public CommodityVo L;
    public MerchantCommodityModel M;
    public List<BuyCartVo> N;

    @BindView(R.id.app_bar_layout)
    public AppBarLayout mAppBarLayout;

    @BindView(R.id.view_page_merchant_product)
    public ViewPager mMerchantProductViewPager;

    @BindView(R.id.tab_layout)
    public TabLayout mTabLayout;

    @BindView(R.id.view_title_bg)
    public View mTitleBgView;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;
    public int B = ErrorConstant.ERROR_NO_NETWORK;
    public c.e.c.y.e.b O = new a();
    public c.e.c.y.e.d P = new c.e.c.y.e.d() { // from class: c.e.c.y.b.e
        @Override // c.e.c.y.e.d
        public final void updateToPositionSelectedSpec(int i2, SpecificationsVo specificationsVo) {
            this.f2229a.X1(i2, specificationsVo);
        }
    };
    public c.e.c.y.e.a Q = new b();

    public class a implements c.e.c.y.e.b {
        public a() {
        }

        @Override // c.e.c.y.e.b
        public void buyCartList(List<BuyCartVo> list) {
            FoodDetailsFragment.this.N = list;
            q.d(FoodDetailsFragment.class.getSimpleName(), "buyCartList");
            if (FoodDetailsFragment.this.K.getBuyCartToCommodity(list, FoodDetailsFragment.this.L) != null) {
                FoodDetailsFragment.this.D.updateFoodDetails(FoodDetailsFragment.this.L);
            }
            if (FoodDetailsFragment.this.J != null) {
                FoodDetailsFragment.this.J.buyCartList(list);
            }
        }

        @Override // c.e.c.y.e.b
        public Fragment getCurrentFragment() {
            return FoodDetailsFragment.this;
        }

        @Override // c.e.c.y.e.b
        public void setupBuyCartCountVo(BuyCartCountVo buyCartCountVo) {
            FoodDetailsFragment.this.G = buyCartCountVo;
            if (FoodDetailsFragment.this.J != null) {
                FoodDetailsFragment.this.J.setupBuyCartCountVo(buyCartCountVo);
            }
            q.d(FoodDetailsFragment.class.getSimpleName(), "setupBuyCartCountVo");
        }
    }

    public class b implements c.e.c.y.e.a {
        public b() {
        }

        @Override // c.e.c.y.e.a
        public void clearBuyCart() {
            FoodDetailsFragment.this.g2();
        }

        @Override // c.e.c.y.e.a
        public void updateSelectedSpecToFoodVo(BuyCartProductVo buyCartProductVo) {
            if (FoodDetailsFragment.this.f6484b.equals(buyCartProductVo.getCommodityKey())) {
                FoodDetailsFragment.this.i2(buyCartProductVo.getQuantity());
            } else {
                FoodDetailsFragment.this.g2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: W1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X1(int i2, SpecificationsVo specificationsVo) {
        g2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Y1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z1(AppBarLayout appBarLayout, int i2) {
        int i3 = i2 < this.B ? 0 : 4;
        if (this.mTitleBgView.getVisibility() != i3) {
            this.mTitleBgView.setVisibility(i3);
            this.mTitleTv.setVisibility(i3);
        }
    }

    public static FoodDetailsFragment getInstance(FoodDetailsInParam foodDetailsInParam) {
        FoodDetailsFragment foodDetailsFragment = new FoodDetailsFragment();
        foodDetailsFragment.d2(foodDetailsInParam);
        return foodDetailsFragment;
    }

    private void o0() {
        this.mTabLayout.setupWithViewPager(this.mMerchantProductViewPager);
        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter(getChildFragmentManager(), O1());
        tabFragmentAdapter.setTitleList(N1());
        this.mMerchantProductViewPager.setAdapter(tabFragmentAdapter);
    }

    public final List<String> N1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(x.getString(R.string.title_details));
        return arrayList;
    }

    public final List<Fragment> O1() {
        WebFragment webFragment = WebFragment.getInstance(null);
        this.C = webFragment;
        webFragment.setShowTitle(false);
        this.C.setIsArticle(true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.C);
        return arrayList;
    }

    public final void P1(CommodityVo commodityVo) {
        if (commodityVo != null) {
            this.L = commodityVo;
            this.D.updateFoodDetails(commodityVo);
            a2(commodityVo);
            g2();
        }
    }

    public final void Q1(View view, boolean z) {
        int iIntValue = ((Integer) view.getTag(R.id.tv_spec_number)).intValue();
        if (m1()) {
            i2(iIntValue);
        } else {
            this.D.getSpecView().setupData(0, z ? iIntValue - 1 : iIntValue + 1, this.L.getMaxLimit());
        }
    }

    public final void R1() {
        this.mTitleTv.setText(x.getNotNullStr(this.F.getMerchantName(), ""));
        this.E = new f(this.u);
        this.D = new e(this.u, this.y);
        this.K = new d(this.O, this.H);
        e2();
    }

    public final boolean S1() {
        boolean zK = K(FoodBuyCartFragment.class);
        if (zK) {
            g0();
        }
        return !zK;
    }

    public final boolean T1() {
        if (!this.I) {
            F0(R.string.tip_merchant_close);
        }
        return this.I;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        switch (view.getId()) {
            case R.id.img_add_spec /* 2131231181 */:
            case R.id.img_btn_add /* 2131231196 */:
                Q1(view, true);
                break;
            case R.id.img_btn_reduce /* 2131231200 */:
                Q1(view, false);
                break;
            case R.id.tv_add_buy_cart /* 2131231933 */:
                c2();
                break;
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        R1();
        o0();
        f2();
        I1();
    }

    public final void a2(CommodityVo commodityVo) {
        String detailArticleKey = commodityVo.getDetailArticleKey();
        if (x.isNotNull(detailArticleKey)) {
            this.C.setHtmlContent(detailArticleKey);
            this.C.reloadArticle();
        }
    }

    public final void b2() {
        if (m1() && S1() && x.isNotNull(this.H)) {
            d(FoodBuyCartFragment.getInstance(this.Q, this.H), R.id.flayout_content);
        }
    }

    @OnClick({R.id.tv_back})
    public void backClick() {
        n();
    }

    public final void c2() {
        if (m1()) {
            FoodSpecFragment foodSpecFragment = FoodSpecFragment.getInstance(this.f6484b, 0);
            foodSpecFragment.setCommoditySelectSpecVo(this.L.getSelectCommoditySpec());
            foodSpecFragment.setSelCommodityVo(this.L);
            foodSpecFragment.setIFoodSpecUpdateCallback(this.P);
            d(foodSpecFragment, R.id.flayout_content);
        }
    }

    @OnClick({R.id.tv_contact_merchant})
    public void callMerchant() {
        S1();
        f(this.F.getMerchantPhone());
    }

    @OnClick({R.id.img_more})
    public void catMoreClick() {
    }

    public final void d2(FoodDetailsInParam foodDetailsInParam) {
        this.F = foodDetailsInParam;
        this.f6484b = foodDetailsInParam.getProductKey();
        this.H = foodDetailsInParam.getMerchantKey();
        this.I = foodDetailsInParam.isOpenMerchant();
        this.J = foodDetailsInParam.getiBuyCartView();
    }

    public final void e2() {
        this.mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: c.e.c.y.b.h
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
                this.f2232a.Z1(appBarLayout, i2);
            }
        });
    }

    public final void f2() {
        MerchantCommodityModel merchantCommodityModel = (MerchantCommodityModel) h(MerchantCommodityModel.class);
        this.M = merchantCommodityModel;
        merchantCommodityModel.getCommodityResult().observe(this, new Observer() { // from class: c.e.c.y.b.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2230a.P1((CommodityVo) obj);
            }
        });
        this.M.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.y.b.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2231a.C((RequestErrDto) obj);
            }
        });
    }

    @OnClick({R.id.view_bottom_bg})
    public void foodBuyCartClick() {
        b2();
    }

    public final void g2() {
        d dVar;
        if (!O() || (dVar = this.K) == null) {
            return;
        }
        dVar.getBuyCartToMerchantKey();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_food_details_layout;
    }

    public final void h2() {
        this.E.updateBuyCountAndPrice(this.G);
    }

    public final void i2(int i2) {
        this.L.setBuyNumber(i2);
        this.D.updateFoodDetails(this.L);
        h2();
        SpecificationsVo specificationsVo = (SpecificationsVo) o.getFirstElement(this.L.getSpecifications());
        if (specificationsVo != null) {
            specificationsVo.setBuyNumber(i2);
            this.K.addToBuyCart(specificationsVo);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
        this.M.getCommodityDetails(this.f6484b);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        g2();
        q.d(getClass().getSimpleName(), "on resume");
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        c.getDefault().post(new EventUpdateBuyCartPrice());
        q.d(getClass().getSimpleName(), "on stop");
    }

    @OnClick({R.id.img_buy_cart})
    public void openBuyCartClick() {
        if (m1()) {
            d0(BuyCartActivity.class);
        }
    }

    @OnClick({R.id.tv_settlement})
    public void openSettlementActivity() {
        S1();
        if (m1() && T1()) {
            if (!o.isNotEmpty(this.N)) {
                F0(R.string.tip_setting_buy_cart_is_empty);
                return;
            }
            BuyCartSubmitOrderFragment buyCartSubmitOrderFragment = BuyCartSubmitOrderFragment.getInstance(5);
            buyCartSubmitOrderFragment.setSelectBuyCartList(this.N);
            K0(buyCartSubmitOrderFragment, R.id.flayout_content);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            g2();
        }
        q.d(getClass().getSimpleName(), "isVisibleToUser:" + z);
    }
}
