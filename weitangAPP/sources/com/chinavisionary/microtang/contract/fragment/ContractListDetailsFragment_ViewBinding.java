package com.chinavisionary.microtang.contract.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class ContractListDetailsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ContractListDetailsFragment f7142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f7146f;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ContractListDetailsFragment f7147c;

        public a(ContractListDetailsFragment contractListDetailsFragment) {
            this.f7147c = contractListDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7147c.openContractChangeFragment(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ContractListDetailsFragment f7149c;

        public b(ContractListDetailsFragment contractListDetailsFragment) {
            this.f7149c = contractListDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7149c.handlerAction(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ContractListDetailsFragment f7151c;

        public c(ContractListDetailsFragment contractListDetailsFragment) {
            this.f7151c = contractListDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7151c.openChangeRent(view);
        }
    }

    public class d extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ContractListDetailsFragment f7153c;

        public d(ContractListDetailsFragment contractListDetailsFragment) {
            this.f7153c = contractListDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7153c.backClick(view);
        }
    }

    @UiThread
    public ContractListDetailsFragment_ViewBinding(ContractListDetailsFragment contractListDetailsFragment, View view) {
        this.f7142b = contractListDetailsFragment;
        contractListDetailsFragment.mTitleTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        contractListDetailsFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) b.c.d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = b.c.d.findRequiredView(view, R.id.btn_rent_change, "field 'mRentChangeBtn' and method 'openContractChangeFragment'");
        contractListDetailsFragment.mRentChangeBtn = (AppCompatButton) b.c.d.castView(viewFindRequiredView, R.id.btn_rent_change, "field 'mRentChangeBtn'", AppCompatButton.class);
        this.f7143c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(contractListDetailsFragment));
        View viewFindRequiredView2 = b.c.d.findRequiredView(view, R.id.btn_action, "field 'mActionBtn' and method 'handlerAction'");
        contractListDetailsFragment.mActionBtn = (AppCompatButton) b.c.d.castView(viewFindRequiredView2, R.id.btn_action, "field 'mActionBtn'", AppCompatButton.class);
        this.f7144d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(contractListDetailsFragment));
        contractListDetailsFragment.mKeepRentBtn = (AppCompatButton) b.c.d.findRequiredViewAsType(view, R.id.btn_keep_rent, "field 'mKeepRentBtn'", AppCompatButton.class);
        View viewFindRequiredView3 = b.c.d.findRequiredView(view, R.id.btn_change_rent, "field 'mChangeRentBtn' and method 'openChangeRent'");
        contractListDetailsFragment.mChangeRentBtn = (AppCompatButton) b.c.d.castView(viewFindRequiredView3, R.id.btn_change_rent, "field 'mChangeRentBtn'", AppCompatButton.class);
        this.f7145e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(contractListDetailsFragment));
        View viewFindRequiredView4 = b.c.d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7146f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(contractListDetailsFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ContractListDetailsFragment contractListDetailsFragment = this.f7142b;
        if (contractListDetailsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7142b = null;
        contractListDetailsFragment.mTitleTv = null;
        contractListDetailsFragment.mSwipeRefreshLayout = null;
        contractListDetailsFragment.mRentChangeBtn = null;
        contractListDetailsFragment.mActionBtn = null;
        contractListDetailsFragment.mKeepRentBtn = null;
        contractListDetailsFragment.mChangeRentBtn = null;
        this.f7143c.setOnClickListener(null);
        this.f7143c = null;
        this.f7144d.setOnClickListener(null);
        this.f7144d = null;
        this.f7145e.setOnClickListener(null);
        this.f7145e = null;
        this.f7146f.setOnClickListener(null);
        this.f7146f = null;
    }
}
