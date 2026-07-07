package com.chinavisionary.microtang.repair.fragment;

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

/* JADX INFO: loaded from: classes2.dex */
public class RepairOrderCommentFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RepairOrderCommentFragment f8249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8251d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RepairOrderCommentFragment f8252c;

        public a(RepairOrderCommentFragment repairOrderCommentFragment) {
            this.f8252c = repairOrderCommentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8252c.commentClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RepairOrderCommentFragment f8254c;

        public b(RepairOrderCommentFragment repairOrderCommentFragment) {
            this.f8254c = repairOrderCommentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8254c.backClick(view);
        }
    }

    @UiThread
    public RepairOrderCommentFragment_ViewBinding(RepairOrderCommentFragment repairOrderCommentFragment, View view) {
        this.f8249b = repairOrderCommentFragment;
        repairOrderCommentFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        repairOrderCommentFragment.mCommentTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_comment_title, "field 'mCommentTitleTv'", TextView.class);
        repairOrderCommentFragment.mPicTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_add_pic_title, "field 'mPicTitleTv'", TextView.class);
        repairOrderCommentFragment.mHandleResultTitle = (TextView) d.findRequiredViewAsType(view, R.id.tv_product_satisfied, "field 'mHandleResultTitle'", TextView.class);
        repairOrderCommentFragment.mUnOverCb = (CheckBox) d.findRequiredViewAsType(view, R.id.cb_un_over, "field 'mUnOverCb'", CheckBox.class);
        repairOrderCommentFragment.mOverCb = (CheckBox) d.findRequiredViewAsType(view, R.id.cb_over, "field 'mOverCb'", CheckBox.class);
        repairOrderCommentFragment.mScoreLinearLayout = (LinearLayout) d.findRequiredViewAsType(view, R.id.llayout_score, "field 'mScoreLinearLayout'", LinearLayout.class);
        repairOrderCommentFragment.mFlowLayout = (FlowLayout) d.findRequiredViewAsType(view, R.id.flow_layout_comment_tag, "field 'mFlowLayout'", FlowLayout.class);
        repairOrderCommentFragment.mCommentContentEdt = (AppCompatEditText) d.findRequiredViewAsType(view, R.id.edt_comment_content, "field 'mCommentContentEdt'", AppCompatEditText.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_next, "field 'mSubmitBtn' and method 'commentClick'");
        repairOrderCommentFragment.mSubmitBtn = (AppCompatButton) d.castView(viewFindRequiredView, R.id.btn_next, "field 'mSubmitBtn'", AppCompatButton.class);
        this.f8250c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(repairOrderCommentFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8251d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(repairOrderCommentFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RepairOrderCommentFragment repairOrderCommentFragment = this.f8249b;
        if (repairOrderCommentFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8249b = null;
        repairOrderCommentFragment.mTitleTv = null;
        repairOrderCommentFragment.mCommentTitleTv = null;
        repairOrderCommentFragment.mPicTitleTv = null;
        repairOrderCommentFragment.mHandleResultTitle = null;
        repairOrderCommentFragment.mUnOverCb = null;
        repairOrderCommentFragment.mOverCb = null;
        repairOrderCommentFragment.mScoreLinearLayout = null;
        repairOrderCommentFragment.mFlowLayout = null;
        repairOrderCommentFragment.mCommentContentEdt = null;
        repairOrderCommentFragment.mSubmitBtn = null;
        this.f8250c.setOnClickListener(null);
        this.f8250c = null;
        this.f8251d.setOnClickListener(null);
        this.f8251d = null;
    }
}
