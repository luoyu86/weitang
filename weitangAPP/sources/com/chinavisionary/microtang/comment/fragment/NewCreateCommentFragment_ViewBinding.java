package com.chinavisionary.microtang.comment.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class NewCreateCommentFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NewCreateCommentFragment f7015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7017d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ NewCreateCommentFragment f7018c;

        public a(NewCreateCommentFragment newCreateCommentFragment) {
            this.f7018c = newCreateCommentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7018c.commentClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ NewCreateCommentFragment f7020c;

        public b(NewCreateCommentFragment newCreateCommentFragment) {
            this.f7020c = newCreateCommentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7020c.backClick(view);
        }
    }

    @UiThread
    public NewCreateCommentFragment_ViewBinding(NewCreateCommentFragment newCreateCommentFragment, View view) {
        this.f7015b = newCreateCommentFragment;
        newCreateCommentFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_next, "field 'mNextBtn' and method 'commentClick'");
        newCreateCommentFragment.mNextBtn = (AppCompatButton) d.castView(viewFindRequiredView, R.id.btn_next, "field 'mNextBtn'", AppCompatButton.class);
        this.f7016c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(newCreateCommentFragment));
        newCreateCommentFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7017d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(newCreateCommentFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        NewCreateCommentFragment newCreateCommentFragment = this.f7015b;
        if (newCreateCommentFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7015b = null;
        newCreateCommentFragment.mTitleTv = null;
        newCreateCommentFragment.mNextBtn = null;
        newCreateCommentFragment.mBaseSwipeRefreshLayout = null;
        this.f7016c.setOnClickListener(null);
        this.f7016c = null;
        this.f7017d.setOnClickListener(null);
        this.f7017d = null;
    }
}
