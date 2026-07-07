package com.chinavisionary.microtang.merchant.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class FoodDetailsTabFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FoodDetailsTabFragment f7865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7868e;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FoodDetailsTabFragment f7869c;

        public a(FoodDetailsTabFragment foodDetailsTabFragment) {
            this.f7869c = foodDetailsTabFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7869c.foodBuyCartClick();
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FoodDetailsTabFragment f7871c;

        public b(FoodDetailsTabFragment foodDetailsTabFragment) {
            this.f7871c = foodDetailsTabFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7871c.callMerchant();
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FoodDetailsTabFragment f7873c;

        public c(FoodDetailsTabFragment foodDetailsTabFragment) {
            this.f7873c = foodDetailsTabFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7873c.openSettlementActivity();
        }
    }

    @UiThread
    public FoodDetailsTabFragment_ViewBinding(FoodDetailsTabFragment foodDetailsTabFragment, View view) {
        this.f7865b = foodDetailsTabFragment;
        foodDetailsTabFragment.mFoodSpecViewPager = (ViewPager) d.findRequiredViewAsType(view, R.id.view_pager_food_spec, "field 'mFoodSpecViewPager'", ViewPager.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.view_bottom_bg, "method 'foodBuyCartClick'");
        this.f7866c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(foodDetailsTabFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_contact_merchant, "method 'callMerchant'");
        this.f7867d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(foodDetailsTabFragment));
        View viewFindRequiredView3 = d.findRequiredView(view, R.id.tv_settlement, "method 'openSettlementActivity'");
        this.f7868e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(foodDetailsTabFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FoodDetailsTabFragment foodDetailsTabFragment = this.f7865b;
        if (foodDetailsTabFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7865b = null;
        foodDetailsTabFragment.mFoodSpecViewPager = null;
        this.f7866c.setOnClickListener(null);
        this.f7866c = null;
        this.f7867d.setOnClickListener(null);
        this.f7867d = null;
        this.f7868e.setOnClickListener(null);
        this.f7868e = null;
    }
}
