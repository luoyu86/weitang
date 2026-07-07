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
public class ContractExitRentFeePreFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ContractExitRentFeePreFragment f7121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7122c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ContractExitRentFeePreFragment f7123c;

        public a(ContractExitRentFeePreFragment contractExitRentFeePreFragment) {
            this.f7123c = contractExitRentFeePreFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7123c.backClick(view);
        }
    }

    @UiThread
    public ContractExitRentFeePreFragment_ViewBinding(ContractExitRentFeePreFragment contractExitRentFeePreFragment, View view) {
        this.f7121b = contractExitRentFeePreFragment;
        contractExitRentFeePreFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        contractExitRentFeePreFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7122c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(contractExitRentFeePreFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ContractExitRentFeePreFragment contractExitRentFeePreFragment = this.f7121b;
        if (contractExitRentFeePreFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7121b = null;
        contractExitRentFeePreFragment.mTitleTv = null;
        contractExitRentFeePreFragment.mSwipeRefreshLayout = null;
        this.f7122c.setOnClickListener(null);
        this.f7122c = null;
    }
}
