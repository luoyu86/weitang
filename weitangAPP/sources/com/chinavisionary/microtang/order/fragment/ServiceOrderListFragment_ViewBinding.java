package com.chinavisionary.microtang.order.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class ServiceOrderListFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ServiceOrderListFragment f8112b;

    @UiThread
    public ServiceOrderListFragment_ViewBinding(ServiceOrderListFragment serviceOrderListFragment, View view) {
        this.f8112b = serviceOrderListFragment;
        serviceOrderListFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ServiceOrderListFragment serviceOrderListFragment = this.f8112b;
        if (serviceOrderListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8112b = null;
        serviceOrderListFragment.mSwipeRefreshLayout = null;
    }
}
