package com.chinavisionary.microtang.main.fragments;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class PaySuccessTipFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PaySuccessTipFragment f7434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7435c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PaySuccessTipFragment f7436c;

        public a(PaySuccessTipFragment paySuccessTipFragment) {
            this.f7436c = paySuccessTipFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7436c.clickBack();
        }
    }

    @UiThread
    public PaySuccessTipFragment_ViewBinding(PaySuccessTipFragment paySuccessTipFragment, View view) {
        this.f7434b = paySuccessTipFragment;
        paySuccessTipFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        paySuccessTipFragment.mOpenDetailsTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_open_details, "field 'mOpenDetailsTv'", TextView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'clickBack'");
        this.f7435c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(paySuccessTipFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PaySuccessTipFragment paySuccessTipFragment = this.f7434b;
        if (paySuccessTipFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7434b = null;
        paySuccessTipFragment.mTitleTv = null;
        paySuccessTipFragment.mOpenDetailsTv = null;
        this.f7435c.setOnClickListener(null);
        this.f7435c = null;
    }
}
