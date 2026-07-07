package com.chinavisionary.microtang.me.fragment;

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
public class WaterAndElectricRecordTabFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WaterAndElectricRecordTabFragment f7734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7735c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WaterAndElectricRecordTabFragment f7736c;

        public a(WaterAndElectricRecordTabFragment waterAndElectricRecordTabFragment) {
            this.f7736c = waterAndElectricRecordTabFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7736c.backClick(view);
        }
    }

    @UiThread
    public WaterAndElectricRecordTabFragment_ViewBinding(WaterAndElectricRecordTabFragment waterAndElectricRecordTabFragment, View view) {
        this.f7734b = waterAndElectricRecordTabFragment;
        waterAndElectricRecordTabFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        waterAndElectricRecordTabFragment.mTabLayout = (TabLayout) d.findRequiredViewAsType(view, R.id.tab_layout, "field 'mTabLayout'", TabLayout.class);
        waterAndElectricRecordTabFragment.mViewPager = (ViewPager) d.findRequiredViewAsType(view, R.id.view_page_contract, "field 'mViewPager'", ViewPager.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7735c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(waterAndElectricRecordTabFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WaterAndElectricRecordTabFragment waterAndElectricRecordTabFragment = this.f7734b;
        if (waterAndElectricRecordTabFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7734b = null;
        waterAndElectricRecordTabFragment.mTitleTv = null;
        waterAndElectricRecordTabFragment.mTabLayout = null;
        waterAndElectricRecordTabFragment.mViewPager = null;
        this.f7735c.setOnClickListener(null);
        this.f7735c = null;
    }
}
