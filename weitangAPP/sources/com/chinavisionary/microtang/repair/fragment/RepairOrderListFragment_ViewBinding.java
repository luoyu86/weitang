package com.chinavisionary.microtang.repair.fragment;

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
public class RepairOrderListFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RepairOrderListFragment f8261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8262c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RepairOrderListFragment f8263c;

        public a(RepairOrderListFragment repairOrderListFragment) {
            this.f8263c = repairOrderListFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8263c.backClick(view);
        }
    }

    @UiThread
    public RepairOrderListFragment_ViewBinding(RepairOrderListFragment repairOrderListFragment, View view) {
        this.f8261b = repairOrderListFragment;
        repairOrderListFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        repairOrderListFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8262c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(repairOrderListFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RepairOrderListFragment repairOrderListFragment = this.f8261b;
        if (repairOrderListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8261b = null;
        repairOrderListFragment.mTitleTv = null;
        repairOrderListFragment.mSwipeRefreshLayout = null;
        this.f8262c.setOnClickListener(null);
        this.f8262c = null;
    }
}
