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
public class ReserveDetailsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReserveDetailsFragment f8164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8165c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ReserveDetailsFragment f8166c;

        public a(ReserveDetailsFragment reserveDetailsFragment) {
            this.f8166c = reserveDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8166c.backClick(view);
        }
    }

    @UiThread
    public ReserveDetailsFragment_ViewBinding(ReserveDetailsFragment reserveDetailsFragment, View view) {
        this.f8164b = reserveDetailsFragment;
        reserveDetailsFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        reserveDetailsFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_details, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8165c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(reserveDetailsFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ReserveDetailsFragment reserveDetailsFragment = this.f8164b;
        if (reserveDetailsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8164b = null;
        reserveDetailsFragment.mTitleTv = null;
        reserveDetailsFragment.mBaseSwipeRefreshLayout = null;
        this.f8165c.setOnClickListener(null);
        this.f8165c = null;
    }
}
