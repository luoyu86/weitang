package com.chinavisionary.microtang.service.fragment;

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

/* JADX INFO: loaded from: classes2.dex */
public class CustomerServiceMainFragment extends BaseFragment {

    @BindView(R.id.view_title_bg)
    public View mBgView;

    @BindView(R.id.tv_title_split_line)
    public TextView mLineTv;

    @BindView(R.id.tab_layout)
    public TabLayout mTabLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    @BindView(R.id.view_page_reason)
    public ViewPager mViewPager;

    public static CustomerServiceMainFragment getInstance() {
        return new CustomerServiceMainFragment();
    }

    public final List<Fragment> E1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(CustomerServiceMeReasonFragment.getInstance());
        arrayList.add(CustomerHotReasonFragment.getInstance());
        return arrayList;
    }

    public final List<String> F1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R.string.tab_title_me_reason));
        arrayList.add(getString(R.string.tab_title_hot_reason));
        return arrayList;
    }

    public final void G1() {
        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter(getFragmentManager(), E1());
        tabFragmentAdapter.setTitleList(F1());
        this.mViewPager.setAdapter(tabFragmentAdapter);
        this.mTabLayout.setupWithViewPager(this.mViewPager);
        this.mTabLayout.setTabMode(1);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_customer_service);
        this.mBgView.setVisibility(0);
        G1();
    }

    @OnClick({R.id.tv_back})
    public void backClick() {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_customer_service_main;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @OnClick({R.id.btn_submit_consult})
    public void submitConsult() {
        K0(SubmitReasonFragment.getInstance(2), R.id.flayout_content);
    }

    @OnClick({R.id.btn_submit_reason})
    public void submitReason() {
        K0(SubmitReasonFragment.getInstance(1), R.id.flayout_content);
    }

    @OnClick({R.id.btn_cat_me_reason, R.id.img_btn_me_reason, R.id.img_btn_me_proposal})
    public void viewClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cat_me_reason /* 2131230853 */:
                K0(CustomerServiceMeReasonFragment.getInstance(), R.id.flayout_content);
                break;
            case R.id.img_btn_me_proposal /* 2131231197 */:
            case R.id.img_btn_me_reason /* 2131231198 */:
                K0(CustomerServiceFragment.getInstance(), R.id.flayout_content);
                break;
        }
    }
}
