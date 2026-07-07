package com.chinavisionary.microtang.settlement.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class SettlementFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SettlementFragment f8489b;

    @UiThread
    public SettlementFragment_ViewBinding(SettlementFragment settlementFragment, View view) {
        this.f8489b = settlementFragment;
        settlementFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        settlementFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SettlementFragment settlementFragment = this.f8489b;
        if (settlementFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8489b = null;
        settlementFragment.mTitleTv = null;
        settlementFragment.mBaseSwipeRefreshLayout = null;
    }
}
