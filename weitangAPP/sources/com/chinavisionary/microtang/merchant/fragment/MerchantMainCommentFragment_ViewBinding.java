package com.chinavisionary.microtang.merchant.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class MerchantMainCommentFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MerchantMainCommentFragment f7900b;

    @UiThread
    public MerchantMainCommentFragment_ViewBinding(MerchantMainCommentFragment merchantMainCommentFragment, View view) {
        this.f7900b = merchantMainCommentFragment;
        merchantMainCommentFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_comment, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MerchantMainCommentFragment merchantMainCommentFragment = this.f7900b;
        if (merchantMainCommentFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7900b = null;
        merchantMainCommentFragment.mBaseSwipeRefreshLayout = null;
    }
}
