package com.chinavisionary.microtang.room.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class RoomSourceDetailsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RoomSourceDetailsFragment f8362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8364d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomSourceDetailsFragment f8365c;

        public a(RoomSourceDetailsFragment roomSourceDetailsFragment) {
            this.f8365c = roomSourceDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8365c.preLookRoom(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomSourceDetailsFragment f8367c;

        public b(RoomSourceDetailsFragment roomSourceDetailsFragment) {
            this.f8367c = roomSourceDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8367c.backClick(view);
        }
    }

    @UiThread
    public RoomSourceDetailsFragment_ViewBinding(RoomSourceDetailsFragment roomSourceDetailsFragment, View view) {
        this.f8362b = roomSourceDetailsFragment;
        roomSourceDetailsFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        roomSourceDetailsFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        roomSourceDetailsFragment.mBottomLineView = d.findRequiredView(view, R.id.view_bottom_line, "field 'mBottomLineView'");
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_pre_look, "field 'mPreLookTv' and method 'preLookRoom'");
        roomSourceDetailsFragment.mPreLookTv = (TextView) d.castView(viewFindRequiredView, R.id.tv_pre_look, "field 'mPreLookTv'", TextView.class);
        this.f8363c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(roomSourceDetailsFragment));
        roomSourceDetailsFragment.mSignRoomTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_sign_room, "field 'mSignRoomTv'", TextView.class);
        roomSourceDetailsFragment.mPreRoomTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_pre_room, "field 'mPreRoomTv'", TextView.class);
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8364d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(roomSourceDetailsFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RoomSourceDetailsFragment roomSourceDetailsFragment = this.f8362b;
        if (roomSourceDetailsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8362b = null;
        roomSourceDetailsFragment.mTitleTv = null;
        roomSourceDetailsFragment.mSwipeRefreshLayout = null;
        roomSourceDetailsFragment.mBottomLineView = null;
        roomSourceDetailsFragment.mPreLookTv = null;
        roomSourceDetailsFragment.mSignRoomTv = null;
        roomSourceDetailsFragment.mPreRoomTv = null;
        this.f8363c.setOnClickListener(null);
        this.f8363c = null;
        this.f8364d.setOnClickListener(null);
        this.f8364d = null;
    }
}
