package com.chinavisionary.microtang.auth.fragment;

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
public class EduAuthFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EduAuthFragment f6824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f6825c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ EduAuthFragment f6826c;

        public a(EduAuthFragment eduAuthFragment) {
            this.f6826c = eduAuthFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f6826c.onBackClick();
        }
    }

    @UiThread
    public EduAuthFragment_ViewBinding(EduAuthFragment eduAuthFragment, View view) {
        this.f6824b = eduAuthFragment;
        eduAuthFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        eduAuthFragment.mSubmitBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_submit, "field 'mSubmitBtn'", Button.class);
        eduAuthFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'onBackClick'");
        this.f6825c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(eduAuthFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        EduAuthFragment eduAuthFragment = this.f6824b;
        if (eduAuthFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f6824b = null;
        eduAuthFragment.mTitleTv = null;
        eduAuthFragment.mSubmitBtn = null;
        eduAuthFragment.mBaseSwipeRefreshLayout = null;
        this.f6825c.setOnClickListener(null);
        this.f6825c = null;
    }
}
