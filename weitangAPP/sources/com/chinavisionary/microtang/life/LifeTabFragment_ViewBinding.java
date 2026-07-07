package com.chinavisionary.microtang.life;

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
public class LifeTabFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LifeTabFragment f7253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7256e;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LifeTabFragment f7257c;

        public a(LifeTabFragment lifeTabFragment) {
            this.f7257c = lifeTabFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7257c.openScan(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LifeTabFragment f7259c;

        public b(LifeTabFragment lifeTabFragment) {
            this.f7259c = lifeTabFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7259c.msgClickView(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LifeTabFragment f7261c;

        public c(LifeTabFragment lifeTabFragment) {
            this.f7261c = lifeTabFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7261c.serverClick(view);
        }
    }

    @UiThread
    public LifeTabFragment_ViewBinding(LifeTabFragment lifeTabFragment, View view) {
        this.f7253b = lifeTabFragment;
        lifeTabFragment.mCityTv = (AppCompatTextView) d.findRequiredViewAsType(view, R.id.tv_city, "field 'mCityTv'", AppCompatTextView.class);
        lifeTabFragment.mLifeCoverBannerView = (EditBannerView) d.findRequiredViewAsType(view, R.id.banner_life_cover, "field 'mLifeCoverBannerView'", EditBannerView.class);
        lifeTabFragment.mTabLayout = (TabLayout) d.findRequiredViewAsType(view, R.id.tab_layout, "field 'mTabLayout'", TabLayout.class);
        lifeTabFragment.mLifeViewPager = (ViewPager) d.findRequiredViewAsType(view, R.id.view_page_life, "field 'mLifeViewPager'", ViewPager.class);
        lifeTabFragment.mBadgeValueTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_badge_value, "field 'mBadgeValueTv'", TextView.class);
        lifeTabFragment.mBadgePaintTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_badge_paint, "field 'mBadgePaintTv'", TextView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.rlayout_scan, "method 'openScan'");
        this.f7254c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(lifeTabFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.rlayout_notify, "method 'msgClickView'");
        this.f7255d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(lifeTabFragment));
        View viewFindRequiredView3 = d.findRequiredView(view, R.id.rlayout_server, "method 'serverClick'");
        this.f7256e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(lifeTabFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LifeTabFragment lifeTabFragment = this.f7253b;
        if (lifeTabFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7253b = null;
        lifeTabFragment.mCityTv = null;
        lifeTabFragment.mLifeCoverBannerView = null;
        lifeTabFragment.mTabLayout = null;
        lifeTabFragment.mLifeViewPager = null;
        lifeTabFragment.mBadgeValueTv = null;
        lifeTabFragment.mBadgePaintTv = null;
        this.f7254c.setOnClickListener(null);
        this.f7254c = null;
        this.f7255d.setOnClickListener(null);
        this.f7255d = null;
        this.f7256e.setOnClickListener(null);
        this.f7256e = null;
    }
}
