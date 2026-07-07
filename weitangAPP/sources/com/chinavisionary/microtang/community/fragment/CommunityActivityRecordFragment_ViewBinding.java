package com.chinavisionary.microtang.community.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class CommunityActivityRecordFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CommunityActivityRecordFragment f7051b;

    @UiThread
    public CommunityActivityRecordFragment_ViewBinding(CommunityActivityRecordFragment communityActivityRecordFragment, View view) {
        this.f7051b = communityActivityRecordFragment;
        communityActivityRecordFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_activity, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CommunityActivityRecordFragment communityActivityRecordFragment = this.f7051b;
        if (communityActivityRecordFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7051b = null;
        communityActivityRecordFragment.mBaseSwipeRefreshLayout = null;
    }
}
