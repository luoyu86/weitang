package com.chinavisionary.microtang.base;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.login.TipLoginFragment;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseTabFragment extends BaseFragment {
    public TipLoginFragment B;

    @BindView(R.id.img_back)
    public ImageView mBackImg;

    @BindView(R.id.tv_back)
    public TextView mBackTv;

    @BindView(R.id.include_search_layout)
    public View mIncludeSearchLayoutView;

    @BindView(R.id.rlayout_notify)
    public View mNotifyView;

    @BindView(R.id.rlayout_scan)
    public View mScanView;

    @BindView(R.id.rlayout_server)
    public View mServerView;

    @BindView(R.id.tab_layout)
    public TabLayout mTabLayout;

    @BindView(R.id.flayout_tip_login)
    public FrameLayout mTipLoginFrameLayout;

    @BindView(R.id.tv_city)
    public TextView mTitleTv;

    @BindView(R.id.view_title)
    public View mTitleView;

    @BindView(R.id.view_pager)
    public ViewPager mViewPager;

    public TabLayout E1() {
        return this.mTabLayout;
    }

    public ViewPager F1() {
        return this.mViewPager;
    }

    public void G1(boolean z) {
        this.mBackImg.setVisibility(z ? 8 : 0);
        this.mBackTv.setVisibility(z ? 8 : 0);
    }

    public void H1(boolean z) {
        this.mNotifyView.setVisibility(z ? 8 : 0);
        this.mScanView.setVisibility(z ? 8 : 0);
        this.mServerView.setVisibility(z ? 8 : 0);
    }

    public void I1(boolean z) {
        if (z) {
            i0(this.B);
        } else {
            e(this.B, R.id.flayout_tip_login, false);
        }
    }

    public void J1(@StringRes int i2) {
        this.mTitleTv.setText(i2);
    }

    public void K1(PagerAdapter pagerAdapter) {
        this.mViewPager.setAdapter(pagerAdapter);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTabLayout.setupWithViewPager(this.mViewPager);
        this.B = TipLoginFragment.getInstance();
        this.mTipLoginFrameLayout.setVisibility(0);
        this.mIncludeSearchLayoutView.setVisibility(4);
        I1(O());
    }

    @OnClick({R.id.tv_back})
    public void backClick() {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_tab_layout;
    }
}
