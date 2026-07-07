package com.chinavisionary.microtang.community.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewpager.widget.ViewPager;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.microtang.R;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes.dex */
public class CommunityActivityTabFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CommunityActivityTabFragment f7059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7062e;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CommunityActivityTabFragment f7063c;

        public a(CommunityActivityTabFragment communityActivityTabFragment) {
            this.f7063c = communityActivityTabFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7063c.openScan(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CommunityActivityTabFragment f7065c;

        public b(CommunityActivityTabFragment communityActivityTabFragment) {
            this.f7065c = communityActivityTabFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7065c.msgClickView(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CommunityActivityTabFragment f7067c;

        public c(CommunityActivityTabFragment communityActivityTabFragment) {
            this.f7067c = communityActivityTabFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7067c.serverClick(view);
        }
    }

    @UiThread
    public CommunityActivityTabFragment_ViewBinding(CommunityActivityTabFragment communityActivityTabFragment, View view) {
        this.f7059b = communityActivityTabFragment;
        communityActivityTabFragment.mCityTv = (AppCompatTextView) d.findRequiredViewAsType(view, R.id.tv_city, "field 'mCityTv'", AppCompatTextView.class);
        communityActivityTabFragment.mLifeCoverBannerView = (EditBannerView) d.findRequiredViewAsType(view, R.id.banner_life_cover, "field 'mLifeCoverBannerView'", EditBannerView.class);
        communityActivityTabFragment.mTabLayout = (TabLayout) d.findRequiredViewAsType(view, R.id.tab_layout, "field 'mTabLayout'", TabLayout.class);
        communityActivityTabFragment.mLifeViewPager = (ViewPager) d.findRequiredViewAsType(view, R.id.view_page_life, "field 'mLifeViewPager'", ViewPager.class);
        communityActivityTabFragment.mBadgeValueTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_badge_value, "field 'mBadgeValueTv'", TextView.class);
        communityActivityTabFragment.mBadgePaintTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_badge_paint, "field 'mBadgePaintTv'", TextView.class);
        communityActivityTabFragment.mPermissionInfoTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_permission_info, "field 'mPermissionInfoTv'", TextView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.rlayout_scan, "method 'openScan'");
        this.f7060c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(communityActivityTabFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.rlayout_notify, "method 'msgClickView'");
        this.f7061d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(communityActivityTabFragment));
        View viewFindRequiredView3 = d.findRequiredView(view, R.id.rlayout_server, "method 'serverClick'");
        this.f7062e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(communityActivityTabFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CommunityActivityTabFragment communityActivityTabFragment = this.f7059b;
        if (communityActivityTabFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7059b = null;
        communityActivityTabFragment.mCityTv = null;
        communityActivityTabFragment.mLifeCoverBannerView = null;
        communityActivityTabFragment.mTabLayout = null;
        communityActivityTabFragment.mLifeViewPager = null;
        communityActivityTabFragment.mBadgeValueTv = null;
        communityActivityTabFragment.mBadgePaintTv = null;
        communityActivityTabFragment.mPermissionInfoTv = null;
        this.f7060c.setOnClickListener(null);
        this.f7060c = null;
        this.f7061d.setOnClickListener(null);
        this.f7061d = null;
        this.f7062e.setOnClickListener(null);
        this.f7062e = null;
    }
}
