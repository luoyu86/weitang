package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class LogoutAccountFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LogoutAccountFragment f7642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7643c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LogoutAccountFragment f7644c;

        public a(LogoutAccountFragment logoutAccountFragment) {
            this.f7644c = logoutAccountFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7644c.backClick();
        }
    }

    @UiThread
    public LogoutAccountFragment_ViewBinding(LogoutAccountFragment logoutAccountFragment, View view) {
        this.f7642b = logoutAccountFragment;
        logoutAccountFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7643c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(logoutAccountFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LogoutAccountFragment logoutAccountFragment = this.f7642b;
        if (logoutAccountFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7642b = null;
        logoutAccountFragment.mTitleTv = null;
        this.f7643c.setOnClickListener(null);
        this.f7643c = null;
    }
}
