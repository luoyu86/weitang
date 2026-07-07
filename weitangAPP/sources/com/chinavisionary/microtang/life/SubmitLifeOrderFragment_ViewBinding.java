package com.chinavisionary.microtang.life;

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
public class SubmitLifeOrderFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SubmitLifeOrderFragment f7264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7265c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SubmitLifeOrderFragment f7266c;

        public a(SubmitLifeOrderFragment submitLifeOrderFragment) {
            this.f7266c = submitLifeOrderFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7266c.backClick();
        }
    }

    @UiThread
    public SubmitLifeOrderFragment_ViewBinding(SubmitLifeOrderFragment submitLifeOrderFragment, View view) {
        this.f7264b = submitLifeOrderFragment;
        submitLifeOrderFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        submitLifeOrderFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        submitLifeOrderFragment.mSubmitBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_submit, "field 'mSubmitBtn'", Button.class);
        submitLifeOrderFragment.mBgView = d.findRequiredView(view, R.id.view_bottom_bg, "field 'mBgView'");
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7265c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(submitLifeOrderFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SubmitLifeOrderFragment submitLifeOrderFragment = this.f7264b;
        if (submitLifeOrderFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7264b = null;
        submitLifeOrderFragment.mSwipeRefreshLayout = null;
        submitLifeOrderFragment.mTitleTv = null;
        submitLifeOrderFragment.mSubmitBtn = null;
        submitLifeOrderFragment.mBgView = null;
        this.f7265c.setOnClickListener(null);
        this.f7265c = null;
    }
}
