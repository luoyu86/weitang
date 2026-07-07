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
public class WalletFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WalletFragment f7730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7731c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WalletFragment f7732c;

        public a(WalletFragment walletFragment) {
            this.f7732c = walletFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7732c.backClick(view);
        }
    }

    @UiThread
    public WalletFragment_ViewBinding(WalletFragment walletFragment, View view) {
        this.f7730b = walletFragment;
        walletFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        walletFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7731c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(walletFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WalletFragment walletFragment = this.f7730b;
        if (walletFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7730b = null;
        walletFragment.mTitleTv = null;
        walletFragment.mSwipeRefreshLayout = null;
        this.f7731c.setOnClickListener(null);
        this.f7731c = null;
    }
}
