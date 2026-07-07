package com.chinavisionary.microtang.contract.fragment;

import android.view.View;
import android.widget.TextView;
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
public class ContractTabFragment extends BaseFragment {

    @BindView(R.id.view_title_bg)
    public View mBgView;

    @BindView(R.id.tab_layout)
    public TabLayout mTabLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    @BindView(R.id.view_page_contract)
    public ViewPager mViewPager;

    public static ContractTabFragment getInstance() {
        return new ContractTabFragment();
    }

    public final List<Fragment> E1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ContractListFragment.getInstance(1));
        arrayList.add(ContractListFragment.getInstance(2));
        return arrayList;
    }

    public final List<String> F1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R.string.title_valid_contract));
        arrayList.add(getString(R.string.title_invalid_contract));
        return arrayList;
    }

    public final void G1() {
        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter(getFragmentManager(), E1());
        tabFragmentAdapter.setTitleList(F1());
        this.mViewPager.setAdapter(tabFragmentAdapter);
        this.mTabLayout.setupWithViewPager(this.mViewPager);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mBgView.setVisibility(0);
        this.mTitleTv.setText(R.string.title_contact);
        G1();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_contract_tab_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }
}
