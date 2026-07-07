package com.chinavisionary.microtang.open.record;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class RoomOpenLockRecordListFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RoomOpenLockRecordListFragment f8050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8052d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomOpenLockRecordListFragment f8053c;

        public a(RoomOpenLockRecordListFragment roomOpenLockRecordListFragment) {
            this.f8053c = roomOpenLockRecordListFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8053c.resetClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomOpenLockRecordListFragment f8055c;

        public b(RoomOpenLockRecordListFragment roomOpenLockRecordListFragment) {
            this.f8055c = roomOpenLockRecordListFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8055c.finishFragment(view);
        }
    }

    @UiThread
    public RoomOpenLockRecordListFragment_ViewBinding(RoomOpenLockRecordListFragment roomOpenLockRecordListFragment, View view) {
        this.f8050b = roomOpenLockRecordListFragment;
        roomOpenLockRecordListFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        roomOpenLockRecordListFragment.mTipSearchTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_tip_msg, "field 'mTipSearchTv'", TextView.class);
        roomOpenLockRecordListFragment.mSearchRoomEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_search_room, "field 'mSearchRoomEdt'", EditText.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_reset, "field 'mResetImgBtn' and method 'resetClick'");
        roomOpenLockRecordListFragment.mResetImgBtn = (ImageButton) d.castView(viewFindRequiredView, R.id.btn_reset, "field 'mResetImgBtn'", ImageButton.class);
        this.f8051c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(roomOpenLockRecordListFragment));
        roomOpenLockRecordListFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_more_rent, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'finishFragment'");
        this.f8052d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(roomOpenLockRecordListFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RoomOpenLockRecordListFragment roomOpenLockRecordListFragment = this.f8050b;
        if (roomOpenLockRecordListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8050b = null;
        roomOpenLockRecordListFragment.mTitleTv = null;
        roomOpenLockRecordListFragment.mTipSearchTv = null;
        roomOpenLockRecordListFragment.mSearchRoomEdt = null;
        roomOpenLockRecordListFragment.mResetImgBtn = null;
        roomOpenLockRecordListFragment.mBaseSwipeRefreshLayout = null;
        this.f8051c.setOnClickListener(null);
        this.f8051c = null;
        this.f8052d.setOnClickListener(null);
        this.f8052d = null;
    }
}
