package com.chinavisionary.microtang.community.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes.dex */
public class CommunityActivityRecordTabFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CommunityActivityRecordTabFragment f7053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7054c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CommunityActivityRecordTabFragment f7055c;

        public a(CommunityActivityRecordTabFragment communityActivityRecordTabFragment) {
            this.f7055c = communityActivityRecordTabFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7055c.backClick(view);
        }
    }

    @UiThread
    public CommunityActivityRecordTabFragment_ViewBinding(CommunityActivityRecordTabFragment communityActivityRecordTabFragment, View view) {
        this.f7053b = communityActivityRecordTabFragment;
        communityActivityRecordTabFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        communityActivityRecordTabFragment.mTabLayout = (TabLayout) d.findRequiredViewAsType(view, R.id.tab_layout, "field 'mTabLayout'", TabLayout.class);
        communityActivityRecordTabFragment.mLifeViewPager = (ViewPager) d.findRequiredViewAsType(view, R.id.view_page, "field 'mLifeViewPager'", ViewPager.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7054c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(communityActivityRecordTabFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CommunityActivityRecordTabFragment communityActivityRecordTabFragment = this.f7053b;
        if (communityActivityRecordTabFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7053b = null;
        communityActivityRecordTabFragment.mTitleTv = null;
        communityActivityRecordTabFragment.mTabLayout = null;
        communityActivityRecordTabFragment.mLifeViewPager = null;
        this.f7054c.setOnClickListener(null);
        this.f7054c = null;
    }
}
