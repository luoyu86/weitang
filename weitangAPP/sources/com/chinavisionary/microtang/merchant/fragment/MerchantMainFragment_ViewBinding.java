package com.chinavisionary.microtang.merchant.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes.dex */
public class MerchantMainFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MerchantMainFragment f7904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f7908f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f7909g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f7910h;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MerchantMainFragment f7911c;

        public a(MerchantMainFragment merchantMainFragment) {
            this.f7911c = merchantMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7911c.foodBuyCartClick();
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MerchantMainFragment f7913c;

        public b(MerchantMainFragment merchantMainFragment) {
            this.f7913c = merchantMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7913c.callMerchant();
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MerchantMainFragment f7915c;

        public c(MerchantMainFragment merchantMainFragment) {
            this.f7915c = merchantMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7915c.openSettlementActivity();
        }
    }

    public class d extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MerchantMainFragment f7917c;

        public d(MerchantMainFragment merchantMainFragment) {
            this.f7917c = merchantMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7917c.openBuyCartClick();
        }
    }

    public class e extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MerchantMainFragment f7919c;

        public e(MerchantMainFragment merchantMainFragment) {
            this.f7919c = merchantMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7919c.catMoreClick();
        }
    }

    public class f extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MerchantMainFragment f7921c;

        public f(MerchantMainFragment merchantMainFragment) {
            this.f7921c = merchantMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7921c.backClick(view);
        }
    }

    @UiThread
    public MerchantMainFragment_ViewBinding(MerchantMainFragment merchantMainFragment, View view) {
        this.f7904b = merchantMainFragment;
        merchantMainFragment.mTitleTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        merchantMainFragment.mTitleBgView = b.c.d.findRequiredView(view, R.id.view_title_bg, "field 'mTitleBgView'");
        merchantMainFragment.mAppBarLayout = (AppBarLayout) b.c.d.findRequiredViewAsType(view, R.id.app_bar_layout, "field 'mAppBarLayout'", AppBarLayout.class);
        merchantMainFragment.mTabLayout = (TabLayout) b.c.d.findRequiredViewAsType(view, R.id.tab_layout, "field 'mTabLayout'", TabLayout.class);
        merchantMainFragment.mMerchantProductViewPager = (ViewPager) b.c.d.findRequiredViewAsType(view, R.id.view_page_merchant_product, "field 'mMerchantProductViewPager'", ViewPager.class);
        merchantMainFragment.mBottomView = b.c.d.findRequiredView(view, R.id.include_bottom_layout, "field 'mBottomView'");
        View viewFindRequiredView = b.c.d.findRequiredView(view, R.id.view_bottom_bg, "method 'foodBuyCartClick'");
        this.f7905c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(merchantMainFragment));
        View viewFindRequiredView2 = b.c.d.findRequiredView(view, R.id.tv_contact_merchant, "method 'callMerchant'");
        this.f7906d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(merchantMainFragment));
        View viewFindRequiredView3 = b.c.d.findRequiredView(view, R.id.tv_settlement, "method 'openSettlementActivity'");
        this.f7907e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(merchantMainFragment));
        View viewFindRequiredView4 = b.c.d.findRequiredView(view, R.id.img_buy_cart, "method 'openBuyCartClick'");
        this.f7908f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(merchantMainFragment));
        View viewFindRequiredView5 = b.c.d.findRequiredView(view, R.id.img_more, "method 'catMoreClick'");
        this.f7909g = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(merchantMainFragment));
        View viewFindRequiredView6 = b.c.d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7910h = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(merchantMainFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MerchantMainFragment merchantMainFragment = this.f7904b;
        if (merchantMainFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7904b = null;
        merchantMainFragment.mTitleTv = null;
        merchantMainFragment.mTitleBgView = null;
        merchantMainFragment.mAppBarLayout = null;
        merchantMainFragment.mTabLayout = null;
        merchantMainFragment.mMerchantProductViewPager = null;
        merchantMainFragment.mBottomView = null;
        this.f7905c.setOnClickListener(null);
        this.f7905c = null;
        this.f7906d.setOnClickListener(null);
        this.f7906d = null;
        this.f7907e.setOnClickListener(null);
        this.f7907e = null;
        this.f7908f.setOnClickListener(null);
        this.f7908f = null;
        this.f7909g.setOnClickListener(null);
        this.f7909g = null;
        this.f7910h.setOnClickListener(null);
        this.f7910h = null;
    }
}
