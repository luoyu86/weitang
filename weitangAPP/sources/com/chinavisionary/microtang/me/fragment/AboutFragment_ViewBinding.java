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
public class AboutFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AboutFragment f7564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7565c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AboutFragment f7566c;

        public a(AboutFragment aboutFragment) {
            this.f7566c = aboutFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7566c.backClick(view);
        }
    }

    @UiThread
    public AboutFragment_ViewBinding(AboutFragment aboutFragment, View view) {
        this.f7564b = aboutFragment;
        aboutFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        aboutFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_about, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7565c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(aboutFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AboutFragment aboutFragment = this.f7564b;
        if (aboutFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7564b = null;
        aboutFragment.mTitleTv = null;
        aboutFragment.mBaseSwipeRefreshLayout = null;
        this.f7565c.setOnClickListener(null);
        this.f7565c = null;
    }
}
