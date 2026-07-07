package com.chinavisionary.microtang.service.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class CustomerServiceMeReasonFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CustomerServiceMeReasonFragment f8459b;

    @UiThread
    public CustomerServiceMeReasonFragment_ViewBinding(CustomerServiceMeReasonFragment customerServiceMeReasonFragment, View view) {
        this.f8459b = customerServiceMeReasonFragment;
        customerServiceMeReasonFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_repair_list, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CustomerServiceMeReasonFragment customerServiceMeReasonFragment = this.f8459b;
        if (customerServiceMeReasonFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8459b = null;
        customerServiceMeReasonFragment.mSwipeRefreshLayout = null;
    }
}
