package com.chinavisionary.microtang.bill.fragment;

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
public class BillTabFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BillTabFragment f6872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f6873c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BillTabFragment f6874c;

        public a(BillTabFragment billTabFragment) {
            this.f6874c = billTabFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f6874c.backClick(view);
        }
    }

    @UiThread
    public BillTabFragment_ViewBinding(BillTabFragment billTabFragment, View view) {
        this.f6872b = billTabFragment;
        billTabFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        billTabFragment.mBgView = d.findRequiredView(view, R.id.view_title_bg, "field 'mBgView'");
        billTabFragment.mTabLayout = (TabLayout) d.findRequiredViewAsType(view, R.id.tab_layout, "field 'mTabLayout'", TabLayout.class);
        billTabFragment.mViewPager = (ViewPager) d.findRequiredViewAsType(view, R.id.view_page_contract, "field 'mViewPager'", ViewPager.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f6873c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(billTabFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BillTabFragment billTabFragment = this.f6872b;
        if (billTabFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f6872b = null;
        billTabFragment.mTitleTv = null;
        billTabFragment.mBgView = null;
        billTabFragment.mTabLayout = null;
        billTabFragment.mViewPager = null;
        this.f6873c.setOnClickListener(null);
        this.f6873c = null;
    }
}
