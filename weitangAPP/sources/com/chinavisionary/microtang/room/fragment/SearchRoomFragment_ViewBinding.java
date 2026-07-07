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
public class SearchRoomFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SearchRoomFragment f8371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8372c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SearchRoomFragment f8373c;

        public a(SearchRoomFragment searchRoomFragment) {
            this.f8373c = searchRoomFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8373c.resetClick(view);
        }
    }

    @UiThread
    public SearchRoomFragment_ViewBinding(SearchRoomFragment searchRoomFragment, View view) {
        this.f8371b = searchRoomFragment;
        searchRoomFragment.mCancelTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_finish, "field 'mCancelTv'", TextView.class);
        searchRoomFragment.mTipSearchTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_tip_msg, "field 'mTipSearchTv'", TextView.class);
        searchRoomFragment.mSearchRoomEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_search_room, "field 'mSearchRoomEdt'", EditText.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_reset, "field 'mResetImgBtn' and method 'resetClick'");
        searchRoomFragment.mResetImgBtn = (ImageButton) d.castView(viewFindRequiredView, R.id.btn_reset, "field 'mResetImgBtn'", ImageButton.class);
        this.f8372c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(searchRoomFragment));
        searchRoomFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_more_rent, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchRoomFragment searchRoomFragment = this.f8371b;
        if (searchRoomFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8371b = null;
        searchRoomFragment.mCancelTv = null;
        searchRoomFragment.mTipSearchTv = null;
        searchRoomFragment.mSearchRoomEdt = null;
        searchRoomFragment.mResetImgBtn = null;
        searchRoomFragment.mSwipeRefreshLayout = null;
        this.f8372c.setOnClickListener(null);
        this.f8372c = null;
    }
}
