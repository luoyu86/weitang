package com.chinavisionary.microtang.contract.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class ContractExitRentStateFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ContractExitRentStateFragment f7138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7139c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ContractExitRentStateFragment f7140c;

        public a(ContractExitRentStateFragment contractExitRentStateFragment) {
            this.f7140c = contractExitRentStateFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7140c.backClick(view);
        }
    }

    @UiThread
    public ContractExitRentStateFragment_ViewBinding(ContractExitRentStateFragment contractExitRentStateFragment, View view) {
        this.f7138b = contractExitRentStateFragment;
        contractExitRentStateFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        contractExitRentStateFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7139c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(contractExitRentStateFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ContractExitRentStateFragment contractExitRentStateFragment = this.f7138b;
        if (contractExitRentStateFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7138b = null;
        contractExitRentStateFragment.mTitleTv = null;
        contractExitRentStateFragment.mSwipeRefreshLayout = null;
        this.f7139c.setOnClickListener(null);
        this.f7139c = null;
    }
}
