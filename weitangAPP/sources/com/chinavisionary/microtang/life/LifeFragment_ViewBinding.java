package com.chinavisionary.microtang.life;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class LifeFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LifeFragment f7246b;

    @UiThread
    public LifeFragment_ViewBinding(LifeFragment lifeFragment, View view) {
        this.f7246b = lifeFragment;
        lifeFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_life, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LifeFragment lifeFragment = this.f7246b;
        if (lifeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7246b = null;
        lifeFragment.mSwipeRefreshLayout = null;
    }
}
