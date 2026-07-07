package com.chinavisionary.microtang.sign.fragments;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class ContractConfirmFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ContractConfirmFragment f8502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8503c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ContractConfirmFragment f8504c;

        public a(ContractConfirmFragment contractConfirmFragment) {
            this.f8504c = contractConfirmFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8504c.confirmClick(view);
        }
    }

    @UiThread
    public ContractConfirmFragment_ViewBinding(ContractConfirmFragment contractConfirmFragment, View view) {
        this.f8502b = contractConfirmFragment;
        contractConfirmFragment.mContractTipTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_contract_tip, "field 'mContractTipTv'", TextView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_confirm, "method 'confirmClick'");
        this.f8503c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(contractConfirmFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ContractConfirmFragment contractConfirmFragment = this.f8502b;
        if (contractConfirmFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8502b = null;
        contractConfirmFragment.mContractTipTv = null;
        this.f8503c.setOnClickListener(null);
        this.f8503c = null;
    }
}
