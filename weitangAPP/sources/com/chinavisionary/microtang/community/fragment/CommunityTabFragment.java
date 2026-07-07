package com.chinavisionary.microtang.community.fragment;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.base.TabFragmentAdapter;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommunityTabFragment extends BaseFragment {
    public int B;
    public ViewPager.OnPageChangeListener C = new a();

    @BindView(R.id.tab_layout_community)
    public TabLayout mCommunityTabLayout;

    @BindView(R.id.view_page_community)
    public ViewPager mCommunityViewPager;

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
            CommunityTabFragment.this.B = i2;
        }
    }

    public static CommunityTabFragment getInstance() {
        return new CommunityTabFragment();
    }

    public final List<Fragment> F1() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 5; i2++) {
            arrayList.add(CommunityFragment.getInstance(i2));
        }
        return arrayList;
    }

    public final List<String> G1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("社区指南");
        arrayList.add("社区活动");
        arrayList.add("热议话题");
        arrayList.add("微棠随手贴");
        arrayList.add("社区二手");
        return arrayList;
    }

    public final void H1() {
        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter(getChildFragmentManager(), F1());
        tabFragmentAdapter.setTitleList(G1());
        this.mCommunityViewPager.setAdapter(tabFragmentAdapter);
        this.mCommunityViewPager.addOnPageChangeListener(this.C);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mCommunityTabLayout.setupWithViewPager(this.mCommunityViewPager);
        H1();
    }

    @OnClick({R.id.float_action_btn})
    public void createFloatActionBtnClick(View view) {
        G0("创建:" + G1().get(this.B));
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_community_tab;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }
}
