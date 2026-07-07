package com.chinavisionary.microtang.sign.fragments;

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
public class SelectRentDateFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SelectRentDateFragment f8550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8551c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SelectRentDateFragment f8552c;

        public a(SelectRentDateFragment selectRentDateFragment) {
            this.f8552c = selectRentDateFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8552c.finishFragment(view);
        }
    }

    @UiThread
    public SelectRentDateFragment_ViewBinding(SelectRentDateFragment selectRentDateFragment, View view) {
        this.f8550b = selectRentDateFragment;
        selectRentDateFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        selectRentDateFragment.mSaveTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_right, "field 'mSaveTv'", TextView.class);
        selectRentDateFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'finishFragment'");
        this.f8551c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(selectRentDateFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SelectRentDateFragment selectRentDateFragment = this.f8550b;
        if (selectRentDateFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8550b = null;
        selectRentDateFragment.mTitleTv = null;
        selectRentDateFragment.mSaveTv = null;
        selectRentDateFragment.mSwipeRefreshLayout = null;
        this.f8551c.setOnClickListener(null);
        this.f8551c = null;
    }
}
