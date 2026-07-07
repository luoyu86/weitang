package com.chinavisionary.microtang.open.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class LockSortFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LockSortFragment f7989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7991d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LockSortFragment f7992c;

        public a(LockSortFragment lockSortFragment) {
            this.f7992c = lockSortFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7992c.saveSort(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LockSortFragment f7994c;

        public b(LockSortFragment lockSortFragment) {
            this.f7994c = lockSortFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7994c.backClick(view);
        }
    }

    @UiThread
    public LockSortFragment_ViewBinding(LockSortFragment lockSortFragment, View view) {
        this.f7989b = lockSortFragment;
        lockSortFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_title_right, "field 'mRightTv' and method 'saveSort'");
        lockSortFragment.mRightTv = (TextView) d.castView(viewFindRequiredView, R.id.tv_title_right, "field 'mRightTv'", TextView.class);
        this.f7990c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(lockSortFragment));
        lockSortFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7991d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(lockSortFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LockSortFragment lockSortFragment = this.f7989b;
        if (lockSortFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7989b = null;
        lockSortFragment.mTitleTv = null;
        lockSortFragment.mRightTv = null;
        lockSortFragment.mBaseSwipeRefreshLayout = null;
        this.f7990c.setOnClickListener(null);
        this.f7990c = null;
        this.f7991d.setOnClickListener(null);
        this.f7991d = null;
    }
}
