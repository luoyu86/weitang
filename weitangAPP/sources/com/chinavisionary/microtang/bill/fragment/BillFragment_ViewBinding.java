package com.chinavisionary.microtang.bill.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class BillFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BillFragment f6871b;

    @UiThread
    public BillFragment_ViewBinding(BillFragment billFragment, View view) {
        this.f6871b = billFragment;
        billFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BillFragment billFragment = this.f6871b;
        if (billFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f6871b = null;
        billFragment.mSwipeRefreshLayout = null;
    }
}
