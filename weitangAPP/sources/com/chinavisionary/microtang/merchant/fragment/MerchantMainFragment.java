package com.chinavisionary.microtang.merchant.fragment;

import android.app.Activity;
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
import c.e.c.y.c.f;
import c.e.c.y.c.h;
import c.e.c.y.e.e;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.event.EventProductPayVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.base.TabFragmentAdapter;
import com.chinavisionary.microtang.buycart.BuyCartActivity;
import com.chinavisionary.microtang.buycart.fragment.BuyCartSubmitOrderFragment;
import com.chinavisionary.microtang.buycart.vo.BuyCartVo;
import com.chinavisionary.microtang.merchant.model.MerchantModel;
import com.chinavisionary.microtang.merchant.vo.BuyCartCountVo;
import com.chinavisionary.microtang.merchant.vo.MerchantDetailsVo;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import g.b.a.m;
import g.b.a.r;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MerchantMainFragment extends BaseFragment {
    public h C;
    public f D;
    public MerchantMainBuyProductFragment E;
    public MerchantModel F;
    public MerchantDetailsVo G;
    public List<BuyCartVo> H;

    @BindView(R.id.app_bar_layout)
    public AppBarLayout mAppBarLayout;

    @BindView(R.id.include_bottom_layout)
    public View mBottomView;

    @BindView(R.id.view_page_merchant_product)
    public ViewPager mMerchantProductViewPager;

    @BindView(R.id.tab_layout)
    public TabLayout mTabLayout;

    @BindView(R.id.view_title_bg)
    public View mTitleBgView;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;
    public int B = ErrorConstant.ERROR_NO_NETWORK;
    public e I = new a();
    public c.e.c.y.e.c J = new b();

    public class a implements e {
        public a() {
        }

        @Override // c.e.c.y.e.e
        public Activity getCurrentActivity() {
            return MerchantMainFragment.this.f6487e;
        }

        @Override // c.e.c.y.e.e
        public void showHideBottomView(boolean z) {
            MerchantMainFragment.this.mBottomView.setVisibility(z ? 0 : 8);
        }
    }

    public class b implements c.e.c.y.e.c {
        public b() {
        }

        @Override // c.e.c.y.e.c
        public void buyCartList(List<BuyCartVo> list) {
            MerchantMainFragment.this.H = list;
            MerchantMainFragment.this.E.o2(list);
        }

        @Override // c.e.c.y.e.c
        public void updateBuyCart(BuyCartCountVo buyCartCountVo) {
            MerchantMainFragment.this.D.updateBuyCountAndPrice(buyCartCountVo);
        }
    }

    public class c extends ViewPager.SimpleOnPageChangeListener {
        public c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            super.onPageSelected(i2);
            MerchantMainFragment.this.i("position :" + i2);
            MerchantMainFragment.this.mBottomView.setVisibility(i2 == 1 ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: R1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S1(AppBarLayout appBarLayout, int i2) {
        int i3 = i2 < this.B ? 0 : 4;
        if (this.mTitleBgView.getVisibility() != i3) {
            this.mTitleBgView.setVisibility(i3);
            this.mTitleTv.setVisibility(i3);
        }
    }

    public static MerchantMainFragment getInstance(String str) {
        MerchantMainFragment merchantMainFragment = new MerchantMainFragment();
        merchantMainFragment.setArguments(CoreBaseFragment.q(str));
        return merchantMainFragment;
    }

    public final List<Fragment> J1() {
        MerchantMainBuyProductFragment merchantMainBuyProductFragment = MerchantMainBuyProductFragment.getInstance(this.G);
        this.E = merchantMainBuyProductFragment;
        merchantMainBuyProductFragment.setIBuyProductCallback(this.J);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.E);
        arrayList.add(MerchantMainCommentFragment.getInstance(this.f6484b, 1));
        return arrayList;
    }

    public final List<String> K1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(x.getString(R.string.title_buy_card_food));
        arrayList.add(x.getString(R.string.title_comment));
        return arrayList;
    }

    public final void L1(MerchantDetailsVo merchantDetailsVo) {
        if (merchantDetailsVo != null) {
            this.G = merchantDetailsVo;
            this.C.setupData(merchantDetailsVo);
            this.mTitleTv.setText(this.G.getMerchantName());
            V1();
        }
    }

    public final void M1() {
        h0(this);
        h hVar = new h(this.u);
        this.C = hVar;
        hVar.setIView(this.I);
        f fVar = new f(this.u);
        this.D = fVar;
        fVar.updateProductExpressFee(new BigDecimal("0"));
        U1();
    }

    public final void N1() {
        MerchantMainBuyProductFragment merchantMainBuyProductFragment = this.E;
        if (merchantMainBuyProductFragment != null) {
            merchantMainBuyProductFragment.S1();
        }
    }

    public final boolean O1() {
        MerchantDetailsVo merchantDetailsVo = this.G;
        if (merchantDetailsVo != null) {
            z = merchantDetailsVo.getMerchantOpeningStatus() != null && this.G.getMerchantOpeningStatus().intValue() == 1;
            if (!z) {
                F0(R.string.tip_merchant_close);
            }
        }
        return z;
    }

    public final void T1() {
        this.mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: c.e.c.y.b.y
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
                this.f2249a.S1(appBarLayout, i2);
            }
        });
    }

    public final void U1() {
        MerchantModel merchantModel = (MerchantModel) h(MerchantModel.class);
        this.F = merchantModel;
        merchantModel.getMerchantDetailsResult().observe(this, new Observer() { // from class: c.e.c.y.b.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2247a.L1((MerchantDetailsVo) obj);
            }
        });
        this.F.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.y.b.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2248a.C((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    public final void V1() {
        if (this.mMerchantProductViewPager.getAdapter() != null) {
            this.mMerchantProductViewPager.removeAllViewsInLayout();
        }
        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter(getFragmentManager(), J1());
        tabFragmentAdapter.setTitleList(K1());
        this.mMerchantProductViewPager.setAdapter(tabFragmentAdapter);
        this.mTabLayout.setupWithViewPager(this.mMerchantProductViewPager);
        this.mMerchantProductViewPager.addOnPageChangeListener(new c());
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        M1();
        T1();
        I1();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @OnClick({R.id.tv_contact_merchant})
    public void callMerchant() {
        N1();
        MerchantDetailsVo merchantDetailsVo = this.G;
        if (merchantDetailsVo != null) {
            f(merchantDetailsVo.getPhone());
        }
    }

    @OnClick({R.id.img_more})
    public void catMoreClick() {
    }

    @OnClick({R.id.view_bottom_bg})
    public void foodBuyCartClick() {
        MerchantMainBuyProductFragment merchantMainBuyProductFragment;
        if (!m1() || (merchantMainBuyProductFragment = this.E) == null) {
            return;
        }
        merchantMainBuyProductFragment.d2();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_merchant_main_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
        this.F.getMerchantDetails(this.f6484b);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        q.d(MerchantListFragment.class.getCanonicalName(), "onResume start time:" + System.currentTimeMillis());
    }

    @OnClick({R.id.img_buy_cart})
    public void openBuyCartClick() {
        if (m1()) {
            d0(BuyCartActivity.class);
        }
    }

    @OnClick({R.id.tv_settlement})
    public void openSettlementActivity() {
        N1();
        if (m1() && O1()) {
            if (!o.isNotEmpty(this.H)) {
                F0(R.string.tip_setting_buy_cart_is_empty);
                return;
            }
            BuyCartSubmitOrderFragment buyCartSubmitOrderFragment = BuyCartSubmitOrderFragment.getInstance(5);
            buyCartSubmitOrderFragment.setSelectBuyCartList(this.H);
            K0(buyCartSubmitOrderFragment, R.id.flayout_content);
        }
    }

    @m(threadMode = r.MAIN)
    public void updateBuyCart(EventProductPayVo eventProductPayVo) {
        q.d(getClass().getSimpleName(), "on updateBuyCart");
        m();
    }
}
