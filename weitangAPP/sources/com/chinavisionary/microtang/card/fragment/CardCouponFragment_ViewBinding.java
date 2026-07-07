package com.chinavisionary.microtang.card.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class CardCouponFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CardCouponFragment f6920b;

    @UiThread
    public CardCouponFragment_ViewBinding(CardCouponFragment cardCouponFragment, View view) {
        this.f6920b = cardCouponFragment;
        cardCouponFragment.mReceiveSaleRecyclerView = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mReceiveSaleRecyclerView'", BaseSwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CardCouponFragment cardCouponFragment = this.f6920b;
        if (cardCouponFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f6920b = null;
        cardCouponFragment.mReceiveSaleRecyclerView = null;
    }
}
