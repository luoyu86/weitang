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
public class ContractExitRentPropertyStateFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ContractExitRentPropertyStateFragment f7134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7135c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ContractExitRentPropertyStateFragment f7136c;

        public a(ContractExitRentPropertyStateFragment contractExitRentPropertyStateFragment) {
            this.f7136c = contractExitRentPropertyStateFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7136c.backClick(view);
        }
    }

    @UiThread
    public ContractExitRentPropertyStateFragment_ViewBinding(ContractExitRentPropertyStateFragment contractExitRentPropertyStateFragment, View view) {
        this.f7134b = contractExitRentPropertyStateFragment;
        contractExitRentPropertyStateFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        contractExitRentPropertyStateFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7135c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(contractExitRentPropertyStateFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ContractExitRentPropertyStateFragment contractExitRentPropertyStateFragment = this.f7134b;
        if (contractExitRentPropertyStateFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7134b = null;
        contractExitRentPropertyStateFragment.mTitleTv = null;
        contractExitRentPropertyStateFragment.mSwipeRefreshLayout = null;
        this.f7135c.setOnClickListener(null);
        this.f7135c = null;
    }
}
