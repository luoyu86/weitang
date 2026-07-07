package com.chinavisionary.microtang.main.fragments;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.microtang.R;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes.dex */
public class TabRoomMainFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TabRoomMainFragment f7463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7466e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f7467f;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TabRoomMainFragment f7468c;

        public a(TabRoomMainFragment tabRoomMainFragment) {
            this.f7468c = tabRoomMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7468c.openScan(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TabRoomMainFragment f7470c;

        public b(TabRoomMainFragment tabRoomMainFragment) {
            this.f7470c = tabRoomMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7470c.msgClickView(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TabRoomMainFragment f7472c;

        public c(TabRoomMainFragment tabRoomMainFragment) {
            this.f7472c = tabRoomMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7472c.serverClick(view);
        }
    }

    public class d extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TabRoomMainFragment f7474c;

        public d(TabRoomMainFragment tabRoomMainFragment) {
            this.f7474c = tabRoomMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7474c.openSearchRoomClick(view);
        }
    }

    @UiThread
    public TabRoomMainFragment_ViewBinding(TabRoomMainFragment tabRoomMainFragment, View view) {
        this.f7463b = tabRoomMainFragment;
        tabRoomMainFragment.mCityTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_city, "field 'mCityTv'", TextView.class);
        tabRoomMainFragment.mMainBannerView = (EditBannerView) b.c.d.findRequiredViewAsType(view, R.id.banner_view, "field 'mMainBannerView'", EditBannerView.class);
        tabRoomMainFragment.mMainTabLayout = (TabLayout) b.c.d.findRequiredViewAsType(view, R.id.tab_layout, "field 'mMainTabLayout'", TabLayout.class);
        tabRoomMainFragment.mPageRoomViewPager = (ViewPager) b.c.d.findRequiredViewAsType(view, R.id.view_page_room, "field 'mPageRoomViewPager'", ViewPager.class);
        View viewFindRequiredView = b.c.d.findRequiredView(view, R.id.rlayout_scan, "method 'openScan'");
        this.f7464c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(tabRoomMainFragment));
        View viewFindRequiredView2 = b.c.d.findRequiredView(view, R.id.rlayout_notify, "method 'msgClickView'");
        this.f7465d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(tabRoomMainFragment));
        View viewFindRequiredView3 = b.c.d.findRequiredView(view, R.id.rlayout_server, "method 'serverClick'");
        this.f7466e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(tabRoomMainFragment));
        View viewFindRequiredView4 = b.c.d.findRequiredView(view, R.id.edt_input_search, "method 'openSearchRoomClick'");
        this.f7467f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(tabRoomMainFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        TabRoomMainFragment tabRoomMainFragment = this.f7463b;
        if (tabRoomMainFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7463b = null;
        tabRoomMainFragment.mCityTv = null;
        tabRoomMainFragment.mMainBannerView = null;
        tabRoomMainFragment.mMainTabLayout = null;
        tabRoomMainFragment.mPageRoomViewPager = null;
        this.f7464c.setOnClickListener(null);
        this.f7464c = null;
        this.f7465d.setOnClickListener(null);
        this.f7465d = null;
        this.f7466e.setOnClickListener(null);
        this.f7466e = null;
        this.f7467f.setOnClickListener(null);
        this.f7467f = null;
    }
}
