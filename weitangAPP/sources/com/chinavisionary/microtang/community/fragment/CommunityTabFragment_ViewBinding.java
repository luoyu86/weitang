package com.chinavisionary.microtang.community.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes.dex */
public class CommunityTabFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CommunityTabFragment f7071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7072c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CommunityTabFragment f7073c;

        public a(CommunityTabFragment communityTabFragment) {
            this.f7073c = communityTabFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7073c.createFloatActionBtnClick(view);
        }
    }

    @UiThread
    public CommunityTabFragment_ViewBinding(CommunityTabFragment communityTabFragment, View view) {
        this.f7071b = communityTabFragment;
        communityTabFragment.mCommunityTabLayout = (TabLayout) d.findRequiredViewAsType(view, R.id.tab_layout_community, "field 'mCommunityTabLayout'", TabLayout.class);
        communityTabFragment.mCommunityViewPager = (ViewPager) d.findRequiredViewAsType(view, R.id.view_page_community, "field 'mCommunityViewPager'", ViewPager.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.float_action_btn, "method 'createFloatActionBtnClick'");
        this.f7072c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(communityTabFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CommunityTabFragment communityTabFragment = this.f7071b;
        if (communityTabFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7071b = null;
        communityTabFragment.mCommunityTabLayout = null;
        communityTabFragment.mCommunityViewPager = null;
        this.f7072c.setOnClickListener(null);
        this.f7072c = null;
    }
}
