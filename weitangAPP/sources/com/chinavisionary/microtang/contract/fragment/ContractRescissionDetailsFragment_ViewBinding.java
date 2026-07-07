package com.chinavisionary.microtang.contract.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class ContractRescissionDetailsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ContractRescissionDetailsFragment f7164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7166d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ContractRescissionDetailsFragment f7167c;

        public a(ContractRescissionDetailsFragment contractRescissionDetailsFragment) {
            this.f7167c = contractRescissionDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7167c.finishExitRent(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ContractRescissionDetailsFragment f7169c;

        public b(ContractRescissionDetailsFragment contractRescissionDetailsFragment) {
            this.f7169c = contractRescissionDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7169c.backClick(view);
        }
    }

    @UiThread
    public ContractRescissionDetailsFragment_ViewBinding(ContractRescissionDetailsFragment contractRescissionDetailsFragment, View view) {
        this.f7164b = contractRescissionDetailsFragment;
        contractRescissionDetailsFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        contractRescissionDetailsFragment.mConfirmCb = (CheckBox) d.findRequiredViewAsType(view, R.id.cb_confirm, "field 'mConfirmCb'", CheckBox.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_finish_exit_rent, "field 'mConfirmFinishBtn' and method 'finishExitRent'");
        contractRescissionDetailsFragment.mConfirmFinishBtn = (AppCompatButton) d.castView(viewFindRequiredView, R.id.btn_finish_exit_rent, "field 'mConfirmFinishBtn'", AppCompatButton.class);
        this.f7165c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(contractRescissionDetailsFragment));
        contractRescissionDetailsFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_rescission, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7166d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(contractRescissionDetailsFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ContractRescissionDetailsFragment contractRescissionDetailsFragment = this.f7164b;
        if (contractRescissionDetailsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7164b = null;
        contractRescissionDetailsFragment.mTitleTv = null;
        contractRescissionDetailsFragment.mConfirmCb = null;
        contractRescissionDetailsFragment.mConfirmFinishBtn = null;
        contractRescissionDetailsFragment.mSwipeRefreshLayout = null;
        this.f7165c.setOnClickListener(null);
        this.f7165c = null;
        this.f7166d.setOnClickListener(null);
        this.f7166d = null;
    }
}
