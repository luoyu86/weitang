package com.chinavisionary.microtang.contract.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class ContractListFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ContractListFragment f7155b;

    @UiThread
    public ContractListFragment_ViewBinding(ContractListFragment contractListFragment, View view) {
        this.f7155b = contractListFragment;
        contractListFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ContractListFragment contractListFragment = this.f7155b;
        if (contractListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7155b = null;
        contractListFragment.mSwipeRefreshLayout = null;
    }
}
