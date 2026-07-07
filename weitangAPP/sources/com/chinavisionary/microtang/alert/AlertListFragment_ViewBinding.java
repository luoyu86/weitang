package com.chinavisionary.microtang.alert;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class AlertListFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AlertListFragment f6806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f6807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f6808d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AlertListFragment f6809c;

        public a(AlertListFragment alertListFragment) {
            this.f6809c = alertListFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f6809c.actionClickView(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AlertListFragment f6811c;

        public b(AlertListFragment alertListFragment) {
            this.f6811c = alertListFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f6811c.actionClickView(view);
        }
    }

    @UiThread
    public AlertListFragment_ViewBinding(AlertListFragment alertListFragment, View view) {
        this.f6806b = alertListFragment;
        alertListFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        alertListFragment.mRecyclerContent = (BaseRecyclerView) d.findRequiredViewAsType(view, R.id.recycler_content, "field 'mRecyclerContent'", BaseRecyclerView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_action_confirm, "method 'actionClickView'");
        this.f6807c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(alertListFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.btn_action_cancel, "method 'actionClickView'");
        this.f6808d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(alertListFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AlertListFragment alertListFragment = this.f6806b;
        if (alertListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f6806b = null;
        alertListFragment.mTitleTv = null;
        alertListFragment.mRecyclerContent = null;
        this.f6807c.setOnClickListener(null);
        this.f6807c = null;
        this.f6808d.setOnClickListener(null);
        this.f6808d = null;
    }
}
