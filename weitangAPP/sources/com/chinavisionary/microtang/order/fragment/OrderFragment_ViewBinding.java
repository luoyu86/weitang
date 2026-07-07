package com.chinavisionary.microtang.order.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class OrderFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OrderFragment f8100b;

    @UiThread
    public OrderFragment_ViewBinding(OrderFragment orderFragment, View view) {
        this.f8100b = orderFragment;
        orderFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        OrderFragment orderFragment = this.f8100b;
        if (orderFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8100b = null;
        orderFragment.mBaseSwipeRefreshLayout = null;
    }
}
