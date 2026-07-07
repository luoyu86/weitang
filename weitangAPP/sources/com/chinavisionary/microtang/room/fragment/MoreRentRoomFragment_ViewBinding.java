package com.chinavisionary.microtang.room.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class MoreRentRoomFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MoreRentRoomFragment f8326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8327c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MoreRentRoomFragment f8328c;

        public a(MoreRentRoomFragment moreRentRoomFragment) {
            this.f8328c = moreRentRoomFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8328c.resetClick();
        }
    }

    @UiThread
    public MoreRentRoomFragment_ViewBinding(MoreRentRoomFragment moreRentRoomFragment, View view) {
        this.f8326b = moreRentRoomFragment;
        moreRentRoomFragment.mSearchRoomEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_search_room, "field 'mSearchRoomEdt'", EditText.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_reset, "field 'mResetImgBtn' and method 'resetClick'");
        moreRentRoomFragment.mResetImgBtn = (ImageButton) d.castView(viewFindRequiredView, R.id.btn_reset, "field 'mResetImgBtn'", ImageButton.class);
        this.f8327c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(moreRentRoomFragment));
        moreRentRoomFragment.mTipSearchTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_tip_search, "field 'mTipSearchTv'", TextView.class);
        moreRentRoomFragment.mRoomSourceTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_source_list, "field 'mRoomSourceTv'", TextView.class);
        moreRentRoomFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_more_rent, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MoreRentRoomFragment moreRentRoomFragment = this.f8326b;
        if (moreRentRoomFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8326b = null;
        moreRentRoomFragment.mSearchRoomEdt = null;
        moreRentRoomFragment.mResetImgBtn = null;
        moreRentRoomFragment.mTipSearchTv = null;
        moreRentRoomFragment.mRoomSourceTv = null;
        moreRentRoomFragment.mSwipeRefreshLayout = null;
        this.f8327c.setOnClickListener(null);
        this.f8327c = null;
    }
}
