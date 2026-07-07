package com.chinavisionary.microtang;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.banner.NoScrollViewPager;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes.dex */
public class MainActivity_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MainActivity f6786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f6787c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MainActivity f6788c;

        public a(MainActivity mainActivity) {
            this.f6788c = mainActivity;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f6788c.unlock();
        }
    }

    @UiThread
    public MainActivity_ViewBinding(MainActivity mainActivity) {
        this(mainActivity, mainActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MainActivity mainActivity = this.f6786b;
        if (mainActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f6786b = null;
        mainActivity.mTabLayout = null;
        mainActivity.mViewPager = null;
        mainActivity.mOpenLockImg = null;
        mainActivity.mRelativeLayout = null;
        mainActivity.mFrameLayoutAd = null;
        mainActivity.mButton = null;
        this.f6787c.setOnClickListener(null);
        this.f6787c = null;
    }

    @UiThread
    public MainActivity_ViewBinding(MainActivity mainActivity, View view) {
        this.f6786b = mainActivity;
        mainActivity.mTabLayout = (TabLayout) d.findRequiredViewAsType(view, R.id.tab_layout, "field 'mTabLayout'", TabLayout.class);
        mainActivity.mViewPager = (NoScrollViewPager) d.findRequiredViewAsType(view, R.id.tab_view_page, "field 'mViewPager'", NoScrollViewPager.class);
        mainActivity.mOpenLockImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_open_lock, "field 'mOpenLockImg'", ImageView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.rlayout_open_lock, "field 'mRelativeLayout' and method 'unlock'");
        mainActivity.mRelativeLayout = (RelativeLayout) d.castView(viewFindRequiredView, R.id.rlayout_open_lock, "field 'mRelativeLayout'", RelativeLayout.class);
        this.f6787c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(mainActivity));
        mainActivity.mFrameLayoutAd = (LinearLayout) d.findRequiredViewAsType(view, R.id.frame_layout_ad, "field 'mFrameLayoutAd'", LinearLayout.class);
        mainActivity.mButton = (Button) d.findRequiredViewAsType(view, R.id.btn_open_wx, "field 'mButton'", Button.class);
    }
}
