package com.chinavisionary.microtang.repair.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class RepairLeftMenuFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RepairLeftMenuFragment f8242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8243c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RepairLeftMenuFragment f8244c;

        public a(RepairLeftMenuFragment repairLeftMenuFragment) {
            this.f8244c = repairLeftMenuFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8244c.backClick(view);
        }
    }

    @UiThread
    public RepairLeftMenuFragment_ViewBinding(RepairLeftMenuFragment repairLeftMenuFragment, View view) {
        this.f8242b = repairLeftMenuFragment;
        repairLeftMenuFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        repairLeftMenuFragment.mRightTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_right, "field 'mRightTv'", TextView.class);
        repairLeftMenuFragment.mSwipeRefreshLayout = (SwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", SwipeRefreshLayout.class);
        repairLeftMenuFragment.mLeftMenuRecyclerView = (BaseRecyclerView) d.findRequiredViewAsType(view, R.id.recycler_left_menu, "field 'mLeftMenuRecyclerView'", BaseRecyclerView.class);
        repairLeftMenuFragment.mRightMenuRecyclerView = (BaseRecyclerView) d.findRequiredViewAsType(view, R.id.recycler_right_menu, "field 'mRightMenuRecyclerView'", BaseRecyclerView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8243c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(repairLeftMenuFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RepairLeftMenuFragment repairLeftMenuFragment = this.f8242b;
        if (repairLeftMenuFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8242b = null;
        repairLeftMenuFragment.mTitleTv = null;
        repairLeftMenuFragment.mRightTv = null;
        repairLeftMenuFragment.mSwipeRefreshLayout = null;
        repairLeftMenuFragment.mLeftMenuRecyclerView = null;
        repairLeftMenuFragment.mRightMenuRecyclerView = null;
        this.f8243c.setOnClickListener(null);
        this.f8243c = null;
    }
}
