package com.chinavisionary.microtang.community.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class CommunityFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CommunityFragment f7069b;

    @UiThread
    public CommunityFragment_ViewBinding(CommunityFragment communityFragment, View view) {
        this.f7069b = communityFragment;
        communityFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_main, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CommunityFragment communityFragment = this.f7069b;
        if (communityFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7069b = null;
        communityFragment.mBaseSwipeRefreshLayout = null;
    }
}
