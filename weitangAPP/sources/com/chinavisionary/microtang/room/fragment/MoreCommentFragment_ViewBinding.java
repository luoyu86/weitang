package com.chinavisionary.microtang.room.fragment;

import android.view.View;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.view.FlowLayout;
import com.hedgehog.ratingbar.RatingBar;

/* JADX INFO: loaded from: classes2.dex */
public class MoreCommentFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MoreCommentFragment f8317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8319d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MoreCommentFragment f8320c;

        public a(MoreCommentFragment moreCommentFragment) {
            this.f8320c = moreCommentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8320c.searchClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MoreCommentFragment f8322c;

        public b(MoreCommentFragment moreCommentFragment) {
            this.f8322c = moreCommentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8322c.resetClick(view);
        }
    }

    @UiThread
    public MoreCommentFragment_ViewBinding(MoreCommentFragment moreCommentFragment, View view) {
        this.f8317b = moreCommentFragment;
        moreCommentFragment.mSearchRoomEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_search_room, "field 'mSearchRoomEdt'", EditText.class);
        moreCommentFragment.mCommentTagLayout = (FlowLayout) d.findRequiredViewAsType(view, R.id.flow_layout_comment_tag, "field 'mCommentTagLayout'", FlowLayout.class);
        moreCommentFragment.mSatisfiedRatingBar = (RatingBar) d.findRequiredViewAsType(view, R.id.rating_bar_satisfied, "field 'mSatisfiedRatingBar'", RatingBar.class);
        moreCommentFragment.mServiceSatisfiedRatingBar = (RatingBar) d.findRequiredViewAsType(view, R.id.rating_bar_service_satisfied, "field 'mServiceSatisfiedRatingBar'", RatingBar.class);
        moreCommentFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_more_comment, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_search, "method 'searchClick'");
        this.f8318c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(moreCommentFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.btn_reset, "method 'resetClick'");
        this.f8319d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(moreCommentFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MoreCommentFragment moreCommentFragment = this.f8317b;
        if (moreCommentFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8317b = null;
        moreCommentFragment.mSearchRoomEdt = null;
        moreCommentFragment.mCommentTagLayout = null;
        moreCommentFragment.mSatisfiedRatingBar = null;
        moreCommentFragment.mServiceSatisfiedRatingBar = null;
        moreCommentFragment.mSwipeRefreshLayout = null;
        this.f8318c.setOnClickListener(null);
        this.f8318c = null;
        this.f8319d.setOnClickListener(null);
        this.f8319d = null;
    }
}
