package com.chinavisionary.microtang.base;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
public class BaseTabFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BaseTabFragment f6850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f6851c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BaseTabFragment f6852c;

        public a(BaseTabFragment baseTabFragment) {
            this.f6852c = baseTabFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f6852c.backClick();
        }
    }

    @UiThread
    public BaseTabFragment_ViewBinding(BaseTabFragment baseTabFragment, View view) {
        this.f6850b = baseTabFragment;
        baseTabFragment.mViewPager = (ViewPager) d.findRequiredViewAsType(view, R.id.view_pager, "field 'mViewPager'", ViewPager.class);
        baseTabFragment.mTabLayout = (TabLayout) d.findRequiredViewAsType(view, R.id.tab_layout, "field 'mTabLayout'", TabLayout.class);
        baseTabFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_city, "field 'mTitleTv'", TextView.class);
        baseTabFragment.mIncludeSearchLayoutView = d.findRequiredView(view, R.id.include_search_layout, "field 'mIncludeSearchLayoutView'");
        baseTabFragment.mTitleView = d.findRequiredView(view, R.id.view_title, "field 'mTitleView'");
        baseTabFragment.mTipLoginFrameLayout = (FrameLayout) d.findRequiredViewAsType(view, R.id.flayout_tip_login, "field 'mTipLoginFrameLayout'", FrameLayout.class);
        baseTabFragment.mNotifyView = d.findRequiredView(view, R.id.rlayout_notify, "field 'mNotifyView'");
        baseTabFragment.mScanView = d.findRequiredView(view, R.id.rlayout_scan, "field 'mScanView'");
        baseTabFragment.mServerView = d.findRequiredView(view, R.id.rlayout_server, "field 'mServerView'");
        baseTabFragment.mBackImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_back, "field 'mBackImg'", ImageView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "field 'mBackTv' and method 'backClick'");
        baseTabFragment.mBackTv = (TextView) d.castView(viewFindRequiredView, R.id.tv_back, "field 'mBackTv'", TextView.class);
        this.f6851c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(baseTabFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BaseTabFragment baseTabFragment = this.f6850b;
        if (baseTabFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f6850b = null;
        baseTabFragment.mViewPager = null;
        baseTabFragment.mTabLayout = null;
        baseTabFragment.mTitleTv = null;
        baseTabFragment.mIncludeSearchLayoutView = null;
        baseTabFragment.mTitleView = null;
        baseTabFragment.mTipLoginFrameLayout = null;
        baseTabFragment.mNotifyView = null;
        baseTabFragment.mScanView = null;
        baseTabFragment.mServerView = null;
        baseTabFragment.mBackImg = null;
        baseTabFragment.mBackTv = null;
        this.f6851c.setOnClickListener(null);
        this.f6851c = null;
    }
}
