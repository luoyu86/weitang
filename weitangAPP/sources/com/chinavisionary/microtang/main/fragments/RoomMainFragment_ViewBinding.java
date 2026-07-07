package com.chinavisionary.microtang.main.fragments;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class RoomMainFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RoomMainFragment f7448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7451e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f7452f;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomMainFragment f7453c;

        public a(RoomMainFragment roomMainFragment) {
            this.f7453c = roomMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7453c.openScan(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomMainFragment f7455c;

        public b(RoomMainFragment roomMainFragment) {
            this.f7455c = roomMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7455c.msgClickView(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomMainFragment f7457c;

        public c(RoomMainFragment roomMainFragment) {
            this.f7457c = roomMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7457c.serverClick(view);
        }
    }

    public class d extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomMainFragment f7459c;

        public d(RoomMainFragment roomMainFragment) {
            this.f7459c = roomMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7459c.openSearchRoomClick(view);
        }
    }

    @UiThread
    public RoomMainFragment_ViewBinding(RoomMainFragment roomMainFragment, View view) {
        this.f7448b = roomMainFragment;
        roomMainFragment.mProjectNameTv = (AppCompatTextView) b.c.d.findRequiredViewAsType(view, R.id.tv_city, "field 'mProjectNameTv'", AppCompatTextView.class);
        roomMainFragment.mCityValueTv = (AppCompatTextView) b.c.d.findRequiredViewAsType(view, R.id.tv_city_value, "field 'mCityValueTv'", AppCompatTextView.class);
        roomMainFragment.mTitleRelativeLayout = (RelativeLayout) b.c.d.findRequiredViewAsType(view, R.id.rlayout_title, "field 'mTitleRelativeLayout'", RelativeLayout.class);
        roomMainFragment.mBadgeValueTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_badge_value, "field 'mBadgeValueTv'", TextView.class);
        roomMainFragment.mBadgePaintTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_badge_paint, "field 'mBadgePaintTv'", TextView.class);
        roomMainFragment.mBgView = b.c.d.findRequiredView(view, R.id.view_bg, "field 'mBgView'");
        roomMainFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) b.c.d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_main, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = b.c.d.findRequiredView(view, R.id.rlayout_scan, "method 'openScan'");
        this.f7449c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(roomMainFragment));
        View viewFindRequiredView2 = b.c.d.findRequiredView(view, R.id.rlayout_notify, "method 'msgClickView'");
        this.f7450d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(roomMainFragment));
        View viewFindRequiredView3 = b.c.d.findRequiredView(view, R.id.rlayout_server, "method 'serverClick'");
        this.f7451e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(roomMainFragment));
        View viewFindRequiredView4 = b.c.d.findRequiredView(view, R.id.edt_input_search, "method 'openSearchRoomClick'");
        this.f7452f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(roomMainFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RoomMainFragment roomMainFragment = this.f7448b;
        if (roomMainFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7448b = null;
        roomMainFragment.mProjectNameTv = null;
        roomMainFragment.mCityValueTv = null;
        roomMainFragment.mTitleRelativeLayout = null;
        roomMainFragment.mBadgeValueTv = null;
        roomMainFragment.mBadgePaintTv = null;
        roomMainFragment.mBgView = null;
        roomMainFragment.mBaseSwipeRefreshLayout = null;
        this.f7449c.setOnClickListener(null);
        this.f7449c = null;
        this.f7450d.setOnClickListener(null);
        this.f7450d = null;
        this.f7451e.setOnClickListener(null);
        this.f7451e = null;
        this.f7452f.setOnClickListener(null);
        this.f7452f = null;
    }
}
