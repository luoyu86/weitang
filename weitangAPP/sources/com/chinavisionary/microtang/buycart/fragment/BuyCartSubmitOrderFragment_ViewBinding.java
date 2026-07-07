package com.chinavisionary.microtang.buycart.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatCheckBox;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.view.ExpressAddressView;
import com.chinavisionary.microtang.view.SelfAddressView;

/* JADX INFO: loaded from: classes.dex */
public class BuyCartSubmitOrderFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BuyCartSubmitOrderFragment f6895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f6896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f6897d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f6898e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f6899f;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BuyCartSubmitOrderFragment f6900c;

        public a(BuyCartSubmitOrderFragment buyCartSubmitOrderFragment) {
            this.f6900c = buyCartSubmitOrderFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f6900c.cbClickView(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BuyCartSubmitOrderFragment f6902c;

        public b(BuyCartSubmitOrderFragment buyCartSubmitOrderFragment) {
            this.f6902c = buyCartSubmitOrderFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f6902c.cbClickView(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BuyCartSubmitOrderFragment f6904c;

        public c(BuyCartSubmitOrderFragment buyCartSubmitOrderFragment) {
            this.f6904c = buyCartSubmitOrderFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f6904c.submitOrderClick(view);
        }
    }

    public class d extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BuyCartSubmitOrderFragment f6906c;

        public d(BuyCartSubmitOrderFragment buyCartSubmitOrderFragment) {
            this.f6906c = buyCartSubmitOrderFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f6906c.finishFragment(view);
        }
    }

    @UiThread
    public BuyCartSubmitOrderFragment_ViewBinding(BuyCartSubmitOrderFragment buyCartSubmitOrderFragment, View view) {
        this.f6895b = buyCartSubmitOrderFragment;
        buyCartSubmitOrderFragment.mTitleTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        buyCartSubmitOrderFragment.mCountPriceTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_buy_cart_count_price, "field 'mCountPriceTv'", TextView.class);
        buyCartSubmitOrderFragment.mSalePriceTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_sale_price, "field 'mSalePriceTv'", TextView.class);
        buyCartSubmitOrderFragment.mTipExpressFeeTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_tip_msg, "field 'mTipExpressFeeTv'", TextView.class);
        buyCartSubmitOrderFragment.mExpressFeeValueTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_express_fee_value, "field 'mExpressFeeValueTv'", TextView.class);
        buyCartSubmitOrderFragment.mExpressAddressView = (ExpressAddressView) b.c.d.findRequiredViewAsType(view, R.id.express_address_view, "field 'mExpressAddressView'", ExpressAddressView.class);
        buyCartSubmitOrderFragment.mExpressAddressLineView = b.c.d.findRequiredView(view, R.id.view_express_order_address_bottom_line, "field 'mExpressAddressLineView'");
        buyCartSubmitOrderFragment.mSelfAddressView = (SelfAddressView) b.c.d.findRequiredViewAsType(view, R.id.self_address_view, "field 'mSelfAddressView'", SelfAddressView.class);
        View viewFindRequiredView = b.c.d.findRequiredView(view, R.id.cb_express, "field 'mExpressCb' and method 'cbClickView'");
        buyCartSubmitOrderFragment.mExpressCb = (AppCompatCheckBox) b.c.d.castView(viewFindRequiredView, R.id.cb_express, "field 'mExpressCb'", AppCompatCheckBox.class);
        this.f6896c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(buyCartSubmitOrderFragment));
        View viewFindRequiredView2 = b.c.d.findRequiredView(view, R.id.cb_self_picked, "field 'mSelfPickedCb' and method 'cbClickView'");
        buyCartSubmitOrderFragment.mSelfPickedCb = (AppCompatCheckBox) b.c.d.castView(viewFindRequiredView2, R.id.cb_self_picked, "field 'mSelfPickedCb'", AppCompatCheckBox.class);
        this.f6897d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(buyCartSubmitOrderFragment));
        buyCartSubmitOrderFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) b.c.d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView3 = b.c.d.findRequiredView(view, R.id.btn_submit_order, "method 'submitOrderClick'");
        this.f6898e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(buyCartSubmitOrderFragment));
        View viewFindRequiredView4 = b.c.d.findRequiredView(view, R.id.tv_back, "method 'finishFragment'");
        this.f6899f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(buyCartSubmitOrderFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BuyCartSubmitOrderFragment buyCartSubmitOrderFragment = this.f6895b;
        if (buyCartSubmitOrderFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f6895b = null;
        buyCartSubmitOrderFragment.mTitleTv = null;
        buyCartSubmitOrderFragment.mCountPriceTv = null;
        buyCartSubmitOrderFragment.mSalePriceTv = null;
        buyCartSubmitOrderFragment.mTipExpressFeeTv = null;
        buyCartSubmitOrderFragment.mExpressFeeValueTv = null;
        buyCartSubmitOrderFragment.mExpressAddressView = null;
        buyCartSubmitOrderFragment.mExpressAddressLineView = null;
        buyCartSubmitOrderFragment.mSelfAddressView = null;
        buyCartSubmitOrderFragment.mExpressCb = null;
        buyCartSubmitOrderFragment.mSelfPickedCb = null;
        buyCartSubmitOrderFragment.mSwipeRefreshLayout = null;
        this.f6896c.setOnClickListener(null);
        this.f6896c = null;
        this.f6897d.setOnClickListener(null);
        this.f6897d = null;
        this.f6898e.setOnClickListener(null);
        this.f6898e = null;
        this.f6899f.setOnClickListener(null);
        this.f6899f = null;
    }
}
