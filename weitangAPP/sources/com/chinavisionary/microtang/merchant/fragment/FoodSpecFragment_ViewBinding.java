package com.chinavisionary.microtang.merchant.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.merchant.view.CommoditySpecLayout;
import com.chinavisionary.microtang.view.SpecView;

/* JADX INFO: loaded from: classes.dex */
public class FoodSpecFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FoodSpecFragment f7875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7877d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FoodSpecFragment f7878c;

        public a(FoodSpecFragment foodSpecFragment) {
            this.f7878c = foodSpecFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7878c.addBuyCart();
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FoodSpecFragment f7880c;

        public b(FoodSpecFragment foodSpecFragment) {
            this.f7880c = foodSpecFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7880c.finishFragment(view);
        }
    }

    @UiThread
    public FoodSpecFragment_ViewBinding(FoodSpecFragment foodSpecFragment, View view) {
        this.f7875b = foodSpecFragment;
        foodSpecFragment.mFoodTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_food_title, "field 'mFoodTitleTv'", TextView.class);
        foodSpecFragment.mSelectSpecValueTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_selected_spec_value, "field 'mSelectSpecValueTv'", TextView.class);
        foodSpecFragment.mSelectSpecPriceTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_selected_spec_price, "field 'mSelectSpecPriceTv'", TextView.class);
        foodSpecFragment.mCommoditySpecLayout = (CommoditySpecLayout) d.findRequiredViewAsType(view, R.id.llayout_product_spec, "field 'mCommoditySpecLayout'", CommoditySpecLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_add_spec_buy_cart, "field 'mAddBuyCartTv' and method 'addBuyCart'");
        foodSpecFragment.mAddBuyCartTv = (TextView) d.castView(viewFindRequiredView, R.id.tv_add_spec_buy_cart, "field 'mAddBuyCartTv'", TextView.class);
        this.f7876c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(foodSpecFragment));
        foodSpecFragment.mAddReduceSpecView = (SpecView) d.findRequiredViewAsType(view, R.id.spec_food_add_reduce_view, "field 'mAddReduceSpecView'", SpecView.class);
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.view_food_spec_layout, "method 'finishFragment'");
        this.f7877d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(foodSpecFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FoodSpecFragment foodSpecFragment = this.f7875b;
        if (foodSpecFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7875b = null;
        foodSpecFragment.mFoodTitleTv = null;
        foodSpecFragment.mSelectSpecValueTv = null;
        foodSpecFragment.mSelectSpecPriceTv = null;
        foodSpecFragment.mCommoditySpecLayout = null;
        foodSpecFragment.mAddBuyCartTv = null;
        foodSpecFragment.mAddReduceSpecView = null;
        this.f7876c.setOnClickListener(null);
        this.f7876c = null;
        this.f7877d.setOnClickListener(null);
        this.f7877d = null;
    }
}
