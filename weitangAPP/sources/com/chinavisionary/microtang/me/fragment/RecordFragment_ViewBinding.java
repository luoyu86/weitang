package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class RecordFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecordFragment f7670b;

    @UiThread
    public RecordFragment_ViewBinding(RecordFragment recordFragment, View view) {
        this.f7670b = recordFragment;
        recordFragment.mValueTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_value, "field 'mValueTv'", TextView.class);
        recordFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RecordFragment recordFragment = this.f7670b;
        if (recordFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7670b = null;
        recordFragment.mValueTv = null;
        recordFragment.mSwipeRefreshLayout = null;
    }
}
