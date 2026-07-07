package com.chinavisionary.microtang.doorpwd.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class DoorPasswordFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DoorPasswordFragment f7190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7191c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DoorPasswordFragment f7192c;

        public a(DoorPasswordFragment doorPasswordFragment) {
            this.f7192c = doorPasswordFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7192c.pageClick(view);
        }
    }

    @UiThread
    public DoorPasswordFragment_ViewBinding(DoorPasswordFragment doorPasswordFragment, View view) {
        this.f7190b = doorPasswordFragment;
        doorPasswordFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        doorPasswordFragment.mTitleLineTv = d.findRequiredView(view, R.id.tv_title_split_line, "field 'mTitleLineTv'");
        doorPasswordFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'pageClick'");
        this.f7191c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(doorPasswordFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DoorPasswordFragment doorPasswordFragment = this.f7190b;
        if (doorPasswordFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7190b = null;
        doorPasswordFragment.mTitleTv = null;
        doorPasswordFragment.mTitleLineTv = null;
        doorPasswordFragment.mBaseSwipeRefreshLayout = null;
        this.f7191c.setOnClickListener(null);
        this.f7191c = null;
    }
}
