package com.chinavisionary.microtang.service.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class SubmitReasonFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SubmitReasonFragment f8465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8467d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SubmitReasonFragment f8468c;

        public a(SubmitReasonFragment submitReasonFragment) {
            this.f8468c = submitReasonFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8468c.submitReason(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SubmitReasonFragment f8470c;

        public b(SubmitReasonFragment submitReasonFragment) {
            this.f8470c = submitReasonFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8470c.backClick(view);
        }
    }

    @UiThread
    public SubmitReasonFragment_ViewBinding(SubmitReasonFragment submitReasonFragment, View view) {
        this.f8465b = submitReasonFragment;
        submitReasonFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        submitReasonFragment.mAlertContentTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_alert_content, "field 'mAlertContentTv'", TextView.class);
        submitReasonFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_submit, "method 'submitReason'");
        this.f8466c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(submitReasonFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8467d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(submitReasonFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SubmitReasonFragment submitReasonFragment = this.f8465b;
        if (submitReasonFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8465b = null;
        submitReasonFragment.mTitleTv = null;
        submitReasonFragment.mAlertContentTv = null;
        submitReasonFragment.mSwipeRefreshLayout = null;
        this.f8466c.setOnClickListener(null);
        this.f8466c = null;
        this.f8467d.setOnClickListener(null);
        this.f8467d = null;
    }
}
