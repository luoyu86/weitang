package com.chinavisionary.microtang.community.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class CommunityActivityFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CommunityActivityFragment f7050b;

    @UiThread
    public CommunityActivityFragment_ViewBinding(CommunityActivityFragment communityActivityFragment, View view) {
        this.f7050b = communityActivityFragment;
        communityActivityFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_activity, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CommunityActivityFragment communityActivityFragment = this.f7050b;
        if (communityActivityFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7050b = null;
        communityActivityFragment.mBaseSwipeRefreshLayout = null;
    }
}
