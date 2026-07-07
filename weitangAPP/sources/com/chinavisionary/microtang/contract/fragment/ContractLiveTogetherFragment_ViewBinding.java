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
public class ContractLiveTogetherFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ContractLiveTogetherFragment f7156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7157c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ContractLiveTogetherFragment f7158c;

        public a(ContractLiveTogetherFragment contractLiveTogetherFragment) {
            this.f7158c = contractLiveTogetherFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7158c.backClick();
        }
    }

    @UiThread
    public ContractLiveTogetherFragment_ViewBinding(ContractLiveTogetherFragment contractLiveTogetherFragment, View view) {
        this.f7156b = contractLiveTogetherFragment;
        contractLiveTogetherFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        contractLiveTogetherFragment.mRightTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_right, "field 'mRightTv'", TextView.class);
        contractLiveTogetherFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7157c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(contractLiveTogetherFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ContractLiveTogetherFragment contractLiveTogetherFragment = this.f7156b;
        if (contractLiveTogetherFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7156b = null;
        contractLiveTogetherFragment.mTitleTv = null;
        contractLiveTogetherFragment.mRightTv = null;
        contractLiveTogetherFragment.mSwipeRefreshLayout = null;
        this.f7157c.setOnClickListener(null);
        this.f7157c = null;
    }
}
