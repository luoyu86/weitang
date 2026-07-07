package com.chinavisionary.microtang.sign.fragments;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class ContractDetailsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ContractDetailsFragment f8506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8507c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ContractDetailsFragment f8508c;

        public a(ContractDetailsFragment contractDetailsFragment) {
            this.f8508c = contractDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8508c.backClick(view);
        }
    }

    @UiThread
    public ContractDetailsFragment_ViewBinding(ContractDetailsFragment contractDetailsFragment, View view) {
        this.f8506b = contractDetailsFragment;
        contractDetailsFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        contractDetailsFragment.mTitleSplitLineTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_split_line, "field 'mTitleSplitLineTv'", TextView.class);
        contractDetailsFragment.mTipPaySuccessAlert = (TextView) d.findRequiredViewAsType(view, R.id.tv_pay_tip_msg, "field 'mTipPaySuccessAlert'", TextView.class);
        contractDetailsFragment.mBaseRecyclerView = (BaseRecyclerView) d.findRequiredViewAsType(view, R.id.recycler_contract_list, "field 'mBaseRecyclerView'", BaseRecyclerView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8507c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(contractDetailsFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ContractDetailsFragment contractDetailsFragment = this.f8506b;
        if (contractDetailsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8506b = null;
        contractDetailsFragment.mTitleTv = null;
        contractDetailsFragment.mTitleSplitLineTv = null;
        contractDetailsFragment.mTipPaySuccessAlert = null;
        contractDetailsFragment.mBaseRecyclerView = null;
        this.f8507c.setOnClickListener(null);
        this.f8507c = null;
    }
}
