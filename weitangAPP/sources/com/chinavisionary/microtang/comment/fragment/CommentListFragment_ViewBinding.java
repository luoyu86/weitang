package com.chinavisionary.microtang.comment.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class CommentListFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CommentListFragment f7000b;

    @UiThread
    public CommentListFragment_ViewBinding(CommentListFragment commentListFragment, View view) {
        this.f7000b = commentListFragment;
        commentListFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.recycler_comment, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CommentListFragment commentListFragment = this.f7000b;
        if (commentListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7000b = null;
        commentListFragment.mBaseSwipeRefreshLayout = null;
    }
}
