package com.chinavisionary.paymentlibrary.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.paymentlibrary.R;

/* JADX INFO: loaded from: classes2.dex */
public class CardCouponFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CardCouponFragment f8743b;

    @UiThread
    public CardCouponFragment_ViewBinding(CardCouponFragment cardCouponFragment, View view) {
        this.f8743b = cardCouponFragment;
        cardCouponFragment.mReceiveSaleRecyclerView = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mReceiveSaleRecyclerView'", BaseSwipeRefreshLayout.class);
        cardCouponFragment.mBackTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_back, "field 'mBackTv'", TextView.class);
        cardCouponFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        cardCouponFragment.mConfirmBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_confirm, "field 'mConfirmBtn'", Button.class);
        cardCouponFragment.mConfirmBgView = d.findRequiredView(view, R.id.view_bottom_bg, "field 'mConfirmBgView'");
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CardCouponFragment cardCouponFragment = this.f8743b;
        if (cardCouponFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8743b = null;
        cardCouponFragment.mReceiveSaleRecyclerView = null;
        cardCouponFragment.mBackTv = null;
        cardCouponFragment.mTitleTv = null;
        cardCouponFragment.mConfirmBtn = null;
        cardCouponFragment.mConfirmBgView = null;
    }
}
