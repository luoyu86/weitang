package com.chinavisionary.microtang.pre.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class ReserveListFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReserveListFragment f8169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8170c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ReserveListFragment f8171c;

        public a(ReserveListFragment reserveListFragment) {
            this.f8171c = reserveListFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8171c.backClick(view);
        }
    }

    @UiThread
    public ReserveListFragment_ViewBinding(ReserveListFragment reserveListFragment, View view) {
        this.f8169b = reserveListFragment;
        reserveListFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        reserveListFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8170c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(reserveListFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ReserveListFragment reserveListFragment = this.f8169b;
        if (reserveListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8169b = null;
        reserveListFragment.mTitleTv = null;
        reserveListFragment.mSwipeRefreshLayout = null;
        this.f8170c.setOnClickListener(null);
        this.f8170c = null;
    }
}
