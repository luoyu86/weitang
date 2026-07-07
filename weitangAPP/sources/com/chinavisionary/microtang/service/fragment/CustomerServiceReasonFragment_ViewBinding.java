package com.chinavisionary.microtang.service.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class CustomerServiceReasonFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CustomerServiceReasonFragment f8460b;

    @UiThread
    public CustomerServiceReasonFragment_ViewBinding(CustomerServiceReasonFragment customerServiceReasonFragment, View view) {
        this.f8460b = customerServiceReasonFragment;
        customerServiceReasonFragment.mRecyclerView = (BaseRecyclerView) d.findRequiredViewAsType(view, R.id.recycler, "field 'mRecyclerView'", BaseRecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CustomerServiceReasonFragment customerServiceReasonFragment = this.f8460b;
        if (customerServiceReasonFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8460b = null;
        customerServiceReasonFragment.mRecyclerView = null;
    }
}
