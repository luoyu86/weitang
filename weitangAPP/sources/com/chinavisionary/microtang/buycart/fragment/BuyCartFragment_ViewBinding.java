package com.chinavisionary.microtang.buycart.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatCheckBox;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class BuyCartFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BuyCartFragment f6888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f6889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f6890d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BuyCartFragment f6891c;

        public a(BuyCartFragment buyCartFragment) {
            this.f6891c = buyCartFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f6891c.submitOrder(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BuyCartFragment f6893c;

        public b(BuyCartFragment buyCartFragment) {
            this.f6893c = buyCartFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f6893c.finishFragment(view);
        }
    }

    @UiThread
    public BuyCartFragment_ViewBinding(BuyCartFragment buyCartFragment, View view) {
        this.f6888b = buyCartFragment;
        buyCartFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        buyCartFragment.mRightTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_right, "field 'mRightTv'", TextView.class);
        buyCartFragment.mAllSelectCb = (AppCompatCheckBox) d.findRequiredViewAsType(view, R.id.cb_all_select, "field 'mAllSelectCb'", AppCompatCheckBox.class);
        buyCartFragment.mCountPriceTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_buy_cart_count_price, "field 'mCountPriceTv'", TextView.class);
        buyCartFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_submit_order, "method 'submitOrder'");
        this.f6889c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(buyCartFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'finishFragment'");
        this.f6890d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(buyCartFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BuyCartFragment buyCartFragment = this.f6888b;
        if (buyCartFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f6888b = null;
        buyCartFragment.mTitleTv = null;
        buyCartFragment.mRightTv = null;
        buyCartFragment.mAllSelectCb = null;
        buyCartFragment.mCountPriceTv = null;
        buyCartFragment.mSwipeRefreshLayout = null;
        this.f6889c.setOnClickListener(null);
        this.f6889c = null;
        this.f6890d.setOnClickListener(null);
        this.f6890d = null;
    }
}
