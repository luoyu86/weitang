package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class RoomAuthListFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RoomAuthListFragment f7693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7694c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomAuthListFragment f7695c;

        public a(RoomAuthListFragment roomAuthListFragment) {
            this.f7695c = roomAuthListFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7695c.backClick(view);
        }
    }

    @UiThread
    public RoomAuthListFragment_ViewBinding(RoomAuthListFragment roomAuthListFragment, View view) {
        this.f7693b = roomAuthListFragment;
        roomAuthListFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        roomAuthListFragment.mSplitLineTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_split_line, "field 'mSplitLineTv'", TextView.class);
        roomAuthListFragment.mRoomRecyclerList = (BaseRecyclerView) d.findRequiredViewAsType(view, R.id.recycler_room_list, "field 'mRoomRecyclerList'", BaseRecyclerView.class);
        roomAuthListFragment.mAppCompatButton = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_retry_load_page, "field 'mAppCompatButton'", AppCompatButton.class);
        roomAuthListFragment.mTipMsgTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_tip_msg, "field 'mTipMsgTv'", TextView.class);
        roomAuthListFragment.mTipRoomTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_tip_room_list_title, "field 'mTipRoomTitleTv'", TextView.class);
        roomAuthListFragment.mCustomSortTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_custom_sort, "field 'mCustomSortTv'", TextView.class);
        roomAuthListFragment.mSearchRoomEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_search_room, "field 'mSearchRoomEdt'", EditText.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7694c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(roomAuthListFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RoomAuthListFragment roomAuthListFragment = this.f7693b;
        if (roomAuthListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7693b = null;
        roomAuthListFragment.mTitleTv = null;
        roomAuthListFragment.mSplitLineTv = null;
        roomAuthListFragment.mRoomRecyclerList = null;
        roomAuthListFragment.mAppCompatButton = null;
        roomAuthListFragment.mTipMsgTv = null;
        roomAuthListFragment.mTipRoomTitleTv = null;
        roomAuthListFragment.mCustomSortTv = null;
        roomAuthListFragment.mSearchRoomEdt = null;
        this.f7694c.setOnClickListener(null);
        this.f7694c = null;
    }
}
