package com.chinavisionary.microtang.contract.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class ContractPropertyStateFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ContractPropertyStateFragment f7160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7161c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ContractPropertyStateFragment f7162c;

        public a(ContractPropertyStateFragment contractPropertyStateFragment) {
            this.f7162c = contractPropertyStateFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7162c.backClick(view);
        }
    }

    @UiThread
    public ContractPropertyStateFragment_ViewBinding(ContractPropertyStateFragment contractPropertyStateFragment, View view) {
        this.f7160b = contractPropertyStateFragment;
        contractPropertyStateFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        contractPropertyStateFragment.mRightTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_right, "field 'mRightTv'", TextView.class);
        contractPropertyStateFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        contractPropertyStateFragment.mButton = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_next, "field 'mButton'", AppCompatButton.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7161c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(contractPropertyStateFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ContractPropertyStateFragment contractPropertyStateFragment = this.f7160b;
        if (contractPropertyStateFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7160b = null;
        contractPropertyStateFragment.mTitleTv = null;
        contractPropertyStateFragment.mRightTv = null;
        contractPropertyStateFragment.mSwipeRefreshLayout = null;
        contractPropertyStateFragment.mButton = null;
        this.f7161c.setOnClickListener(null);
        this.f7161c = null;
    }
}
