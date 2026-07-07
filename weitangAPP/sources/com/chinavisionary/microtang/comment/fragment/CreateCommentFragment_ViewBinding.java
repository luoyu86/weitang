package com.chinavisionary.microtang.comment.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;
import com.hedgehog.ratingbar.RatingBar;

/* JADX INFO: loaded from: classes.dex */
public class CreateCommentFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CreateCommentFragment f7008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7010d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CreateCommentFragment f7011c;

        public a(CreateCommentFragment createCommentFragment) {
            this.f7011c = createCommentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7011c.commentClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CreateCommentFragment f7013c;

        public b(CreateCommentFragment createCommentFragment) {
            this.f7013c = createCommentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7013c.backClick(view);
        }
    }

    @UiThread
    public CreateCommentFragment_ViewBinding(CreateCommentFragment createCommentFragment, View view) {
        this.f7008b = createCommentFragment;
        createCommentFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        createCommentFragment.mAddPicTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_add_pic_title, "field 'mAddPicTitleTv'", TextView.class);
        createCommentFragment.mLinearLayoutInfo = (LinearLayout) d.findRequiredViewAsType(view, R.id.llayout_info, "field 'mLinearLayoutInfo'", LinearLayout.class);
        createCommentFragment.mLinearLayoutScore = (LinearLayout) d.findRequiredViewAsType(view, R.id.llayout_score, "field 'mLinearLayoutScore'", LinearLayout.class);
        createCommentFragment.mCommentContentEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_comment_content, "field 'mCommentContentEdt'", EditText.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_next, "field 'mNextBtn' and method 'commentClick'");
        createCommentFragment.mNextBtn = (AppCompatButton) d.castView(viewFindRequiredView, R.id.btn_next, "field 'mNextBtn'", AppCompatButton.class);
        this.f7009c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(createCommentFragment));
        createCommentFragment.mRatingBarPraise = (RatingBar) d.findRequiredViewAsType(view, R.id.rating_bar_praise, "field 'mRatingBarPraise'", RatingBar.class);
        createCommentFragment.mPraiseLevelTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_tip_praise_level, "field 'mPraiseLevelTv'", TextView.class);
        createCommentFragment.mPraiseLevelTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_one_key_praise_title, "field 'mPraiseLevelTitleTv'", TextView.class);
        createCommentFragment.mPraiseLevelLineView = d.findRequiredView(view, R.id.view_praise_split_line, "field 'mPraiseLevelLineView'");
        createCommentFragment.mPraiseTipTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_tip_praise_tip, "field 'mPraiseTipTv'", TextView.class);
        createCommentFragment.mInputMaxLengthTipTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_input_max_length_tip, "field 'mInputMaxLengthTipTv'", TextView.class);
        createCommentFragment.mCommentTopContentTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_comment_top_content, "field 'mCommentTopContentTv'", TextView.class);
        createCommentFragment.mTopLayout = (ConstraintLayout) d.findRequiredViewAsType(view, R.id.constraint_top_layout, "field 'mTopLayout'", ConstraintLayout.class);
        createCommentFragment.mRecommendLayout = (ConstraintLayout) d.findRequiredViewAsType(view, R.id.constraint_layout_recommend, "field 'mRecommendLayout'", ConstraintLayout.class);
        createCommentFragment.mRecommendRatingBarPraise = (RatingBar) d.findRequiredViewAsType(view, R.id.rating_bar_recommend, "field 'mRecommendRatingBarPraise'", RatingBar.class);
        createCommentFragment.mRecommendResultTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_recommend_raging_result, "field 'mRecommendResultTv'", TextView.class);
        createCommentFragment.mRecommendTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_tip_recommend_msg, "field 'mRecommendTitleTv'", TextView.class);
        createCommentFragment.mRecommendSubTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_tip_recommend_subtitle, "field 'mRecommendSubTitleTv'", TextView.class);
        createCommentFragment.mGridViewLayout = (FrameLayout) d.findRequiredViewAsType(view, R.id.flayout_nine_grid_view, "field 'mGridViewLayout'", FrameLayout.class);
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7010d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(createCommentFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CreateCommentFragment createCommentFragment = this.f7008b;
        if (createCommentFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7008b = null;
        createCommentFragment.mTitleTv = null;
        createCommentFragment.mAddPicTitleTv = null;
        createCommentFragment.mLinearLayoutInfo = null;
        createCommentFragment.mLinearLayoutScore = null;
        createCommentFragment.mCommentContentEdt = null;
        createCommentFragment.mNextBtn = null;
        createCommentFragment.mRatingBarPraise = null;
        createCommentFragment.mPraiseLevelTv = null;
        createCommentFragment.mPraiseLevelTitleTv = null;
        createCommentFragment.mPraiseLevelLineView = null;
        createCommentFragment.mPraiseTipTv = null;
        createCommentFragment.mInputMaxLengthTipTv = null;
        createCommentFragment.mCommentTopContentTv = null;
        createCommentFragment.mTopLayout = null;
        createCommentFragment.mRecommendLayout = null;
        createCommentFragment.mRecommendRatingBarPraise = null;
        createCommentFragment.mRecommendResultTv = null;
        createCommentFragment.mRecommendTitleTv = null;
        createCommentFragment.mRecommendSubTitleTv = null;
        createCommentFragment.mGridViewLayout = null;
        this.f7009c.setOnClickListener(null);
        this.f7009c = null;
        this.f7010d.setOnClickListener(null);
        this.f7010d = null;
    }
}
