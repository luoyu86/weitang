package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class CancelAccountOneFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CancelAccountOneFragment f7587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7588c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CancelAccountOneFragment f7589c;

        public a(CancelAccountOneFragment cancelAccountOneFragment) {
            this.f7589c = cancelAccountOneFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7589c.clickBack();
        }
    }

    @UiThread
    public CancelAccountOneFragment_ViewBinding(CancelAccountOneFragment cancelAccountOneFragment, View view) {
        this.f7587b = cancelAccountOneFragment;
        cancelAccountOneFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        cancelAccountOneFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        cancelAccountOneFragment.mSubmitBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_submit, "field 'mSubmitBtn'", Button.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'clickBack'");
        this.f7588c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(cancelAccountOneFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CancelAccountOneFragment cancelAccountOneFragment = this.f7587b;
        if (cancelAccountOneFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7587b = null;
        cancelAccountOneFragment.mTitleTv = null;
        cancelAccountOneFragment.mBaseSwipeRefreshLayout = null;
        cancelAccountOneFragment.mSubmitBtn = null;
        this.f7588c.setOnClickListener(null);
        this.f7588c = null;
    }
}
