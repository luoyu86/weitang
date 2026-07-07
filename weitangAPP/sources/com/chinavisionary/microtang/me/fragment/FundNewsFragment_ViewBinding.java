package com.chinavisionary.microtang.me.fragment;

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
public class FundNewsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FundNewsFragment f7617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7618c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FundNewsFragment f7619c;

        public a(FundNewsFragment fundNewsFragment) {
            this.f7619c = fundNewsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7619c.clickBack();
        }
    }

    @UiThread
    public FundNewsFragment_ViewBinding(FundNewsFragment fundNewsFragment, View view) {
        this.f7617b = fundNewsFragment;
        fundNewsFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        fundNewsFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'clickBack'");
        this.f7618c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(fundNewsFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FundNewsFragment fundNewsFragment = this.f7617b;
        if (fundNewsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7617b = null;
        fundNewsFragment.mTitleTv = null;
        fundNewsFragment.mSwipeRefreshLayout = null;
        this.f7618c.setOnClickListener(null);
        this.f7618c = null;
    }
}
