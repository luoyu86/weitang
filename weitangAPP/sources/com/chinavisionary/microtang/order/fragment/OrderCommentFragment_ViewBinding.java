package com.chinavisionary.microtang.order.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatEditText;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class OrderCommentFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OrderCommentFragment f8084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8086d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OrderCommentFragment f8087c;

        public a(OrderCommentFragment orderCommentFragment) {
            this.f8087c = orderCommentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8087c.commentClick();
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OrderCommentFragment f8089c;

        public b(OrderCommentFragment orderCommentFragment) {
            this.f8089c = orderCommentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8089c.backClick();
        }
    }

    @UiThread
    public OrderCommentFragment_ViewBinding(OrderCommentFragment orderCommentFragment, View view) {
        this.f8084b = orderCommentFragment;
        orderCommentFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        orderCommentFragment.mCommentScoreLLayout = (LinearLayout) d.findRequiredViewAsType(view, R.id.llayout_comment_score, "field 'mCommentScoreLLayout'", LinearLayout.class);
        orderCommentFragment.mCommentContentEdt = (AppCompatEditText) d.findRequiredViewAsType(view, R.id.edt_comment_content, "field 'mCommentContentEdt'", AppCompatEditText.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_next, "method 'commentClick'");
        this.f8085c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(orderCommentFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8086d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(orderCommentFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        OrderCommentFragment orderCommentFragment = this.f8084b;
        if (orderCommentFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8084b = null;
        orderCommentFragment.mTitleTv = null;
        orderCommentFragment.mCommentScoreLLayout = null;
        orderCommentFragment.mCommentContentEdt = null;
        this.f8085c.setOnClickListener(null);
        this.f8085c = null;
        this.f8086d.setOnClickListener(null);
        this.f8086d = null;
    }
}
