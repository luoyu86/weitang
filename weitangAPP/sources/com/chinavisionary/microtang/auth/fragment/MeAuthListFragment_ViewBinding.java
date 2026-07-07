package com.chinavisionary.microtang.auth.fragment;

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
public class MeAuthListFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MeAuthListFragment f6833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f6834c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MeAuthListFragment f6835c;

        public a(MeAuthListFragment meAuthListFragment) {
            this.f6835c = meAuthListFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f6835c.clickBack();
        }
    }

    @UiThread
    public MeAuthListFragment_ViewBinding(MeAuthListFragment meAuthListFragment, View view) {
        this.f6833b = meAuthListFragment;
        meAuthListFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        meAuthListFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'clickBack'");
        this.f6834c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(meAuthListFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MeAuthListFragment meAuthListFragment = this.f6833b;
        if (meAuthListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f6833b = null;
        meAuthListFragment.mTitleTv = null;
        meAuthListFragment.mBaseSwipeRefreshLayout = null;
        this.f6834c.setOnClickListener(null);
        this.f6834c = null;
    }
}
