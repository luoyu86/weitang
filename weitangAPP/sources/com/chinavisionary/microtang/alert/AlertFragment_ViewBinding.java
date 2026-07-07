package com.chinavisionary.microtang.alert;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class AlertFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AlertFragment f6802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f6803c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AlertFragment f6804c;

        public a(AlertFragment alertFragment) {
            this.f6804c = alertFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f6804c.actionClick(view);
        }
    }

    @UiThread
    public AlertFragment_ViewBinding(AlertFragment alertFragment, View view) {
        this.f6802b = alertFragment;
        alertFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        alertFragment.mContentTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_content, "field 'mContentTv'", TextView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_action, "method 'actionClick'");
        this.f6803c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(alertFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AlertFragment alertFragment = this.f6802b;
        if (alertFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f6802b = null;
        alertFragment.mTitleTv = null;
        alertFragment.mContentTv = null;
        this.f6803c.setOnClickListener(null);
        this.f6803c = null;
    }
}
