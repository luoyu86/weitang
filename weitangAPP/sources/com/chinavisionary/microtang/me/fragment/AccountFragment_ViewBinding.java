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
public class AccountFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AccountFragment f7568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7569c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AccountFragment f7570c;

        public a(AccountFragment accountFragment) {
            this.f7570c = accountFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7570c.backClick(view);
        }
    }

    @UiThread
    public AccountFragment_ViewBinding(AccountFragment accountFragment, View view) {
        this.f7568b = accountFragment;
        accountFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        accountFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7569c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(accountFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AccountFragment accountFragment = this.f7568b;
        if (accountFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7568b = null;
        accountFragment.mTitleTv = null;
        accountFragment.mSwipeRefreshLayout = null;
        this.f7569c.setOnClickListener(null);
        this.f7569c = null;
    }
}
