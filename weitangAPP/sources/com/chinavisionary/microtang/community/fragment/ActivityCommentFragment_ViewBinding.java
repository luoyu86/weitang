package com.chinavisionary.microtang.community.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class ActivityCommentFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ActivityCommentFragment f7046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7047c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ActivityCommentFragment f7048c;

        public a(ActivityCommentFragment activityCommentFragment) {
            this.f7048c = activityCommentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7048c.backClick(view);
        }
    }

    @UiThread
    public ActivityCommentFragment_ViewBinding(ActivityCommentFragment activityCommentFragment, View view) {
        this.f7046b = activityCommentFragment;
        activityCommentFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        activityCommentFragment.mAddPicTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_add_pic_title, "field 'mAddPicTitleTv'", TextView.class);
        activityCommentFragment.mActivityTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_activity_title, "field 'mActivityTitleTv'", TextView.class);
        activityCommentFragment.mLinearLayoutScore = (LinearLayout) d.findRequiredViewAsType(view, R.id.llayout_score, "field 'mLinearLayoutScore'", LinearLayout.class);
        activityCommentFragment.mCommentContentEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_comment_content, "field 'mCommentContentEdt'", EditText.class);
        activityCommentFragment.mNextBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_next, "field 'mNextBtn'", AppCompatButton.class);
        activityCommentFragment.mInputMaxLengthTipTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_input_max_length_tip, "field 'mInputMaxLengthTipTv'", TextView.class);
        activityCommentFragment.mGridViewLayout = (FrameLayout) d.findRequiredViewAsType(view, R.id.flayout_nine_grid_view, "field 'mGridViewLayout'", FrameLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7047c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(activityCommentFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ActivityCommentFragment activityCommentFragment = this.f7046b;
        if (activityCommentFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7046b = null;
        activityCommentFragment.mTitleTv = null;
        activityCommentFragment.mAddPicTitleTv = null;
        activityCommentFragment.mActivityTitleTv = null;
        activityCommentFragment.mLinearLayoutScore = null;
        activityCommentFragment.mCommentContentEdt = null;
        activityCommentFragment.mNextBtn = null;
        activityCommentFragment.mInputMaxLengthTipTv = null;
        activityCommentFragment.mGridViewLayout = null;
        this.f7047c.setOnClickListener(null);
        this.f7047c = null;
    }
}
