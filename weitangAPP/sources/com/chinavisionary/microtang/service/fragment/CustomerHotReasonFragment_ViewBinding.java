package com.chinavisionary.microtang.service.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class CustomerHotReasonFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CustomerHotReasonFragment f8428b;

    @UiThread
    public CustomerHotReasonFragment_ViewBinding(CustomerHotReasonFragment customerHotReasonFragment, View view) {
        this.f8428b = customerHotReasonFragment;
        customerHotReasonFragment.mHotReasonRecyclerView = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_repair_list, "field 'mHotReasonRecyclerView'", BaseSwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CustomerHotReasonFragment customerHotReasonFragment = this.f8428b;
        if (customerHotReasonFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8428b = null;
        customerHotReasonFragment.mHotReasonRecyclerView = null;
    }
}
