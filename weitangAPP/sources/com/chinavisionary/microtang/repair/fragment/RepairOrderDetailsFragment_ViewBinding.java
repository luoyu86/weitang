package com.chinavisionary.microtang.repair.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class RepairOrderDetailsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RepairOrderDetailsFragment f8257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8258c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RepairOrderDetailsFragment f8259c;

        public a(RepairOrderDetailsFragment repairOrderDetailsFragment) {
            this.f8259c = repairOrderDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8259c.backClick(view);
        }
    }

    @UiThread
    public RepairOrderDetailsFragment_ViewBinding(RepairOrderDetailsFragment repairOrderDetailsFragment, View view) {
        this.f8257b = repairOrderDetailsFragment;
        repairOrderDetailsFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        repairOrderDetailsFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        repairOrderDetailsFragment.mUpdateAuthDoorBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_update_auth_door, "field 'mUpdateAuthDoorBtn'", AppCompatButton.class);
        repairOrderDetailsFragment.mCommentBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_next, "field 'mCommentBtn'", AppCompatButton.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8258c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(repairOrderDetailsFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RepairOrderDetailsFragment repairOrderDetailsFragment = this.f8257b;
        if (repairOrderDetailsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8257b = null;
        repairOrderDetailsFragment.mTitleTv = null;
        repairOrderDetailsFragment.mSwipeRefreshLayout = null;
        repairOrderDetailsFragment.mUpdateAuthDoorBtn = null;
        repairOrderDetailsFragment.mCommentBtn = null;
        this.f8258c.setOnClickListener(null);
        this.f8258c = null;
    }
}
