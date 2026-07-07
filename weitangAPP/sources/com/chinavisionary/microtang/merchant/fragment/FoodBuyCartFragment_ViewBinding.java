package com.chinavisionary.microtang.merchant.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class FoodBuyCartFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FoodBuyCartFragment f7835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7837d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FoodBuyCartFragment f7838c;

        public a(FoodBuyCartFragment foodBuyCartFragment) {
            this.f7838c = foodBuyCartFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7838c.clearBuyCart(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FoodBuyCartFragment f7840c;

        public b(FoodBuyCartFragment foodBuyCartFragment) {
            this.f7840c = foodBuyCartFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7840c.finishFragment(view);
        }
    }

    @UiThread
    public FoodBuyCartFragment_ViewBinding(FoodBuyCartFragment foodBuyCartFragment, View view) {
        this.f7835b = foodBuyCartFragment;
        foodBuyCartFragment.mFoodBuyCartRecyclerView = (BaseRecyclerView) d.findRequiredViewAsType(view, R.id.recycler_food_buy_cart, "field 'mFoodBuyCartRecyclerView'", BaseRecyclerView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_clear_buy_cart, "field 'mClearBuyCartTv' and method 'clearBuyCart'");
        foodBuyCartFragment.mClearBuyCartTv = (TextView) d.castView(viewFindRequiredView, R.id.tv_clear_buy_cart, "field 'mClearBuyCartTv'", TextView.class);
        this.f7836c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(foodBuyCartFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.view_bg, "method 'finishFragment'");
        this.f7837d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(foodBuyCartFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FoodBuyCartFragment foodBuyCartFragment = this.f7835b;
        if (foodBuyCartFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7835b = null;
        foodBuyCartFragment.mFoodBuyCartRecyclerView = null;
        foodBuyCartFragment.mClearBuyCartTv = null;
        this.f7836c.setOnClickListener(null);
        this.f7836c = null;
        this.f7837d.setOnClickListener(null);
        this.f7837d = null;
    }
}
