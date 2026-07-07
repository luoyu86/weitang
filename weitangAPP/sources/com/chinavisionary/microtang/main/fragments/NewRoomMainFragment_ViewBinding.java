package com.chinavisionary.microtang.main.fragments;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class NewRoomMainFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NewRoomMainFragment f7421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7424e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f7425f;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ NewRoomMainFragment f7426c;

        public a(NewRoomMainFragment newRoomMainFragment) {
            this.f7426c = newRoomMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7426c.openScan(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ NewRoomMainFragment f7428c;

        public b(NewRoomMainFragment newRoomMainFragment) {
            this.f7428c = newRoomMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7428c.msgClickView(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ NewRoomMainFragment f7430c;

        public c(NewRoomMainFragment newRoomMainFragment) {
            this.f7430c = newRoomMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7430c.serverClick(view);
        }
    }

    public class d extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ NewRoomMainFragment f7432c;

        public d(NewRoomMainFragment newRoomMainFragment) {
            this.f7432c = newRoomMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7432c.openSearchRoomClick(view);
        }
    }

    @UiThread
    public NewRoomMainFragment_ViewBinding(NewRoomMainFragment newRoomMainFragment, View view) {
        this.f7421b = newRoomMainFragment;
        newRoomMainFragment.mCityTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_city, "field 'mCityTv'", TextView.class);
        newRoomMainFragment.mTitleRelativeLayout = (RelativeLayout) b.c.d.findRequiredViewAsType(view, R.id.rlayout_title, "field 'mTitleRelativeLayout'", RelativeLayout.class);
        newRoomMainFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) b.c.d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_main, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = b.c.d.findRequiredView(view, R.id.rlayout_scan, "method 'openScan'");
        this.f7422c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(newRoomMainFragment));
        View viewFindRequiredView2 = b.c.d.findRequiredView(view, R.id.rlayout_notify, "method 'msgClickView'");
        this.f7423d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(newRoomMainFragment));
        View viewFindRequiredView3 = b.c.d.findRequiredView(view, R.id.rlayout_server, "method 'serverClick'");
        this.f7424e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(newRoomMainFragment));
        View viewFindRequiredView4 = b.c.d.findRequiredView(view, R.id.edt_input_search, "method 'openSearchRoomClick'");
        this.f7425f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(newRoomMainFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        NewRoomMainFragment newRoomMainFragment = this.f7421b;
        if (newRoomMainFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7421b = null;
        newRoomMainFragment.mCityTv = null;
        newRoomMainFragment.mTitleRelativeLayout = null;
        newRoomMainFragment.mBaseSwipeRefreshLayout = null;
        this.f7422c.setOnClickListener(null);
        this.f7422c = null;
        this.f7423d.setOnClickListener(null);
        this.f7423d = null;
        this.f7424e.setOnClickListener(null);
        this.f7424e = null;
        this.f7425f.setOnClickListener(null);
        this.f7425f = null;
    }
}
