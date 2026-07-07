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
public class FoodDetailsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FoodDetailsFragment f7844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7847e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f7848f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f7849g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f7850h;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FoodDetailsFragment f7851c;

        public a(FoodDetailsFragment foodDetailsFragment) {
            this.f7851c = foodDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7851c.foodBuyCartClick();
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FoodDetailsFragment f7853c;

        public b(FoodDetailsFragment foodDetailsFragment) {
            this.f7853c = foodDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7853c.callMerchant();
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FoodDetailsFragment f7855c;

        public c(FoodDetailsFragment foodDetailsFragment) {
            this.f7855c = foodDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7855c.openSettlementActivity();
        }
    }

    public class d extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FoodDetailsFragment f7857c;

        public d(FoodDetailsFragment foodDetailsFragment) {
            this.f7857c = foodDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7857c.backClick();
        }
    }

    public class e extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FoodDetailsFragment f7859c;

        public e(FoodDetailsFragment foodDetailsFragment) {
            this.f7859c = foodDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7859c.openBuyCartClick();
        }
    }

    public class f extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FoodDetailsFragment f7861c;

        public f(FoodDetailsFragment foodDetailsFragment) {
            this.f7861c = foodDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7861c.catMoreClick();
        }
    }

    @UiThread
    public FoodDetailsFragment_ViewBinding(FoodDetailsFragment foodDetailsFragment, View view) {
        this.f7844b = foodDetailsFragment;
        foodDetailsFragment.mTitleTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        foodDetailsFragment.mTitleBgView = b.c.d.findRequiredView(view, R.id.view_title_bg, "field 'mTitleBgView'");
        foodDetailsFragment.mAppBarLayout = (AppBarLayout) b.c.d.findRequiredViewAsType(view, R.id.app_bar_layout, "field 'mAppBarLayout'", AppBarLayout.class);
        foodDetailsFragment.mTabLayout = (TabLayout) b.c.d.findRequiredViewAsType(view, R.id.tab_layout, "field 'mTabLayout'", TabLayout.class);
        foodDetailsFragment.mMerchantProductViewPager = (ViewPager) b.c.d.findRequiredViewAsType(view, R.id.view_page_merchant_product, "field 'mMerchantProductViewPager'", ViewPager.class);
        View viewFindRequiredView = b.c.d.findRequiredView(view, R.id.view_bottom_bg, "method 'foodBuyCartClick'");
        this.f7845c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(foodDetailsFragment));
        View viewFindRequiredView2 = b.c.d.findRequiredView(view, R.id.tv_contact_merchant, "method 'callMerchant'");
        this.f7846d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(foodDetailsFragment));
        View viewFindRequiredView3 = b.c.d.findRequiredView(view, R.id.tv_settlement, "method 'openSettlementActivity'");
        this.f7847e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(foodDetailsFragment));
        View viewFindRequiredView4 = b.c.d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7848f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(foodDetailsFragment));
        View viewFindRequiredView5 = b.c.d.findRequiredView(view, R.id.img_buy_cart, "method 'openBuyCartClick'");
        this.f7849g = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(foodDetailsFragment));
        View viewFindRequiredView6 = b.c.d.findRequiredView(view, R.id.img_more, "method 'catMoreClick'");
        this.f7850h = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(foodDetailsFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FoodDetailsFragment foodDetailsFragment = this.f7844b;
        if (foodDetailsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7844b = null;
        foodDetailsFragment.mTitleTv = null;
        foodDetailsFragment.mTitleBgView = null;
        foodDetailsFragment.mAppBarLayout = null;
        foodDetailsFragment.mTabLayout = null;
        foodDetailsFragment.mMerchantProductViewPager = null;
        this.f7845c.setOnClickListener(null);
        this.f7845c = null;
        this.f7846d.setOnClickListener(null);
        this.f7846d = null;
        this.f7847e.setOnClickListener(null);
        this.f7847e = null;
        this.f7848f.setOnClickListener(null);
        this.f7848f = null;
        this.f7849g.setOnClickListener(null);
        this.f7849g = null;
        this.f7850h.setOnClickListener(null);
        this.f7850h = null;
    }
}
