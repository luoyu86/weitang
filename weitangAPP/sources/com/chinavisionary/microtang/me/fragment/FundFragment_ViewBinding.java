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
public class FundFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FundFragment f7612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7613c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FundFragment f7614c;

        public a(FundFragment fundFragment) {
            this.f7614c = fundFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7614c.clickBack();
        }
    }

    @UiThread
    public FundFragment_ViewBinding(FundFragment fundFragment, View view) {
        this.f7612b = fundFragment;
        fundFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        fundFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'clickBack'");
        this.f7613c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(fundFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FundFragment fundFragment = this.f7612b;
        if (fundFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7612b = null;
        fundFragment.mTitleTv = null;
        fundFragment.mSwipeRefreshLayout = null;
        this.f7613c.setOnClickListener(null);
        this.f7613c = null;
    }
}
