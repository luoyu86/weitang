package com.chinavisionary.microtang.service.fragment;

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
public class CustomerServerRecordFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CustomerServerRecordFragment f8429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8430c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CustomerServerRecordFragment f8431c;

        public a(CustomerServerRecordFragment customerServerRecordFragment) {
            this.f8431c = customerServerRecordFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8431c.backClick(view);
        }
    }

    @UiThread
    public CustomerServerRecordFragment_ViewBinding(CustomerServerRecordFragment customerServerRecordFragment, View view) {
        this.f8429b = customerServerRecordFragment;
        customerServerRecordFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        customerServerRecordFragment.mSplitLineTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_split_line, "field 'mSplitLineTv'", TextView.class);
        customerServerRecordFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_record, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8430c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(customerServerRecordFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CustomerServerRecordFragment customerServerRecordFragment = this.f8429b;
        if (customerServerRecordFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8429b = null;
        customerServerRecordFragment.mTitleTv = null;
        customerServerRecordFragment.mSplitLineTv = null;
        customerServerRecordFragment.mBaseSwipeRefreshLayout = null;
        this.f8430c.setOnClickListener(null);
        this.f8430c = null;
    }
}
