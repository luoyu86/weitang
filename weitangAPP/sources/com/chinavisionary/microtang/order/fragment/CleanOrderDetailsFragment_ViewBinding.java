package com.chinavisionary.microtang.order.fragment;

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

/* JADX INFO: loaded from: classes.dex */
public class CleanOrderDetailsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CleanOrderDetailsFragment f8077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8078c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CleanOrderDetailsFragment f8079c;

        public a(CleanOrderDetailsFragment cleanOrderDetailsFragment) {
            this.f8079c = cleanOrderDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8079c.backClick(view);
        }
    }

    @UiThread
    public CleanOrderDetailsFragment_ViewBinding(CleanOrderDetailsFragment cleanOrderDetailsFragment, View view) {
        this.f8077b = cleanOrderDetailsFragment;
        cleanOrderDetailsFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        cleanOrderDetailsFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        cleanOrderDetailsFragment.mUpdateAuthDoorBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_update_auth_door, "field 'mUpdateAuthDoorBtn'", AppCompatButton.class);
        cleanOrderDetailsFragment.mCommentBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_next, "field 'mCommentBtn'", AppCompatButton.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8078c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(cleanOrderDetailsFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CleanOrderDetailsFragment cleanOrderDetailsFragment = this.f8077b;
        if (cleanOrderDetailsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8077b = null;
        cleanOrderDetailsFragment.mTitleTv = null;
        cleanOrderDetailsFragment.mSwipeRefreshLayout = null;
        cleanOrderDetailsFragment.mUpdateAuthDoorBtn = null;
        cleanOrderDetailsFragment.mCommentBtn = null;
        this.f8078c.setOnClickListener(null);
        this.f8078c = null;
    }
}
