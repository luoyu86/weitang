package com.chinavisionary.microtang.order.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;
import com.nex3z.flowlayout.FlowLayout;

/* JADX INFO: loaded from: classes.dex */
public class CleanOrderCommentFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CleanOrderCommentFragment f8069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8071d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CleanOrderCommentFragment f8072c;

        public a(CleanOrderCommentFragment cleanOrderCommentFragment) {
            this.f8072c = cleanOrderCommentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8072c.commentClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CleanOrderCommentFragment f8074c;

        public b(CleanOrderCommentFragment cleanOrderCommentFragment) {
            this.f8074c = cleanOrderCommentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8074c.backClick(view);
        }
    }

    @UiThread
    public CleanOrderCommentFragment_ViewBinding(CleanOrderCommentFragment cleanOrderCommentFragment, View view) {
        this.f8069b = cleanOrderCommentFragment;
        cleanOrderCommentFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        cleanOrderCommentFragment.mCommentTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_comment_title, "field 'mCommentTitleTv'", TextView.class);
        cleanOrderCommentFragment.mPicTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_add_pic_title, "field 'mPicTitleTv'", TextView.class);
        cleanOrderCommentFragment.mHandleResultTitle = (TextView) d.findRequiredViewAsType(view, R.id.tv_product_satisfied, "field 'mHandleResultTitle'", TextView.class);
        cleanOrderCommentFragment.mUnOverCb = (CheckBox) d.findRequiredViewAsType(view, R.id.cb_un_over, "field 'mUnOverCb'", CheckBox.class);
        cleanOrderCommentFragment.mOverCb = (CheckBox) d.findRequiredViewAsType(view, R.id.cb_over, "field 'mOverCb'", CheckBox.class);
        cleanOrderCommentFragment.mScoreLinearLayout = (LinearLayout) d.findRequiredViewAsType(view, R.id.llayout_score, "field 'mScoreLinearLayout'", LinearLayout.class);
        cleanOrderCommentFragment.mFlowLayout = (FlowLayout) d.findRequiredViewAsType(view, R.id.flow_layout_comment_tag, "field 'mFlowLayout'", FlowLayout.class);
        cleanOrderCommentFragment.mCommentContentEdt = (AppCompatEditText) d.findRequiredViewAsType(view, R.id.edt_comment_content, "field 'mCommentContentEdt'", AppCompatEditText.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_next, "field 'mSubmitBtn' and method 'commentClick'");
        cleanOrderCommentFragment.mSubmitBtn = (AppCompatButton) d.castView(viewFindRequiredView, R.id.btn_next, "field 'mSubmitBtn'", AppCompatButton.class);
        this.f8070c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(cleanOrderCommentFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8071d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(cleanOrderCommentFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CleanOrderCommentFragment cleanOrderCommentFragment = this.f8069b;
        if (cleanOrderCommentFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8069b = null;
        cleanOrderCommentFragment.mTitleTv = null;
        cleanOrderCommentFragment.mCommentTitleTv = null;
        cleanOrderCommentFragment.mPicTitleTv = null;
        cleanOrderCommentFragment.mHandleResultTitle = null;
        cleanOrderCommentFragment.mUnOverCb = null;
        cleanOrderCommentFragment.mOverCb = null;
        cleanOrderCommentFragment.mScoreLinearLayout = null;
        cleanOrderCommentFragment.mFlowLayout = null;
        cleanOrderCommentFragment.mCommentContentEdt = null;
        cleanOrderCommentFragment.mSubmitBtn = null;
        this.f8070c.setOnClickListener(null);
        this.f8070c = null;
        this.f8071d.setOnClickListener(null);
        this.f8071d = null;
    }
}
