package com.chinavisionary.microtang.comment.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class CommentFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CommentFragment f6993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f6994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f6995d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CommentFragment f6996c;

        public a(CommentFragment commentFragment) {
            this.f6996c = commentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f6996c.backClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CommentFragment f6998c;

        public b(CommentFragment commentFragment) {
            this.f6998c = commentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f6998c.catRentChangeInfo(view);
        }
    }

    @UiThread
    public CommentFragment_ViewBinding(CommentFragment commentFragment, View view) {
        this.f6993b = commentFragment;
        commentFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        commentFragment.mCommentRecycler = (BaseRecyclerView) d.findRequiredViewAsType(view, R.id.recycler_comment, "field 'mCommentRecycler'", BaseRecyclerView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f6994c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(commentFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_rent_change_info, "method 'catRentChangeInfo'");
        this.f6995d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(commentFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CommentFragment commentFragment = this.f6993b;
        if (commentFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f6993b = null;
        commentFragment.mTitleTv = null;
        commentFragment.mCommentRecycler = null;
        this.f6994c.setOnClickListener(null);
        this.f6994c = null;
        this.f6995d.setOnClickListener(null);
        this.f6995d = null;
    }
}
