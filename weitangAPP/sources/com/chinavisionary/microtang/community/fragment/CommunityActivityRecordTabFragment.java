package com.chinavisionary.microtang.community.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.c.v.f.k0;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.base.TabFragmentAdapter;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommunityActivityRecordTabFragment extends BaseFragment<String> {
    public k0 B;
    public c.e.c.n.b.a C;
    public final ViewPager.OnPageChangeListener D = new a();

    @BindView(R.id.view_page)
    public ViewPager mLifeViewPager;

    @BindView(R.id.tab_layout)
    public TabLayout mTabLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            CommunityActivityRecordTabFragment.this.B.updateSelectActivityRecordTabToPosition(i2, true);
        }
    }

    public static CommunityActivityRecordTabFragment getInstance(c.e.c.n.b.a aVar) {
        CommunityActivityRecordTabFragment communityActivityRecordTabFragment = new CommunityActivityRecordTabFragment();
        communityActivityRecordTabFragment.C = aVar;
        return communityActivityRecordTabFragment;
    }

    public final List<Fragment> F1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(CommunityActivityRecordFragment.getInstance(1, this.C));
        arrayList.add(CommunityActivityRecordFragment.getInstance(2, this.C));
        arrayList.add(CommunityActivityRecordFragment.getInstance(3, this.C));
        return arrayList;
    }

    public final void G1() {
        this.B = new k0();
        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter(getChildFragmentManager(), F1());
        this.mLifeViewPager.addOnPageChangeListener(this.D);
        this.mLifeViewPager.setAdapter(tabFragmentAdapter);
        this.mTabLayout.setupWithViewPager(this.mLifeViewPager);
        this.B.setupCommunityActivityListTab(this.mTabLayout);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_me_community_activity);
        G1();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_tab_community_activity;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }
}
