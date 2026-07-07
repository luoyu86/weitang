package com.chinavisionary.microtang.contract.fragment;

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
public class ContractTabFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ContractTabFragment f7171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7172c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ContractTabFragment f7173c;

        public a(ContractTabFragment contractTabFragment) {
            this.f7173c = contractTabFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7173c.backClick(view);
        }
    }

    @UiThread
    public ContractTabFragment_ViewBinding(ContractTabFragment contractTabFragment, View view) {
        this.f7171b = contractTabFragment;
        contractTabFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        contractTabFragment.mBgView = d.findRequiredView(view, R.id.view_title_bg, "field 'mBgView'");
        contractTabFragment.mTabLayout = (TabLayout) d.findRequiredViewAsType(view, R.id.tab_layout, "field 'mTabLayout'", TabLayout.class);
        contractTabFragment.mViewPager = (ViewPager) d.findRequiredViewAsType(view, R.id.view_page_contract, "field 'mViewPager'", ViewPager.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7172c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(contractTabFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ContractTabFragment contractTabFragment = this.f7171b;
        if (contractTabFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7171b = null;
        contractTabFragment.mTitleTv = null;
        contractTabFragment.mBgView = null;
        contractTabFragment.mTabLayout = null;
        contractTabFragment.mViewPager = null;
        this.f7172c.setOnClickListener(null);
        this.f7172c = null;
    }
}
