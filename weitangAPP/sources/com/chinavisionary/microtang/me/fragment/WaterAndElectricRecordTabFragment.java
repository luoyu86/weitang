package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.base.TabFragmentAdapter;
import com.chinavisionary.microtang.hydropower.model.PayHydropowerModel;
import com.chinavisionary.microtang.me.vo.RecordTabVo;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WaterAndElectricRecordTabFragment extends BaseFragment {

    @BindView(R.id.tab_layout)
    public TabLayout mTabLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    @BindView(R.id.view_page_contract)
    public ViewPager mViewPager;

    public static WaterAndElectricRecordTabFragment getInstance() {
        return new WaterAndElectricRecordTabFragment();
    }

    public final void E1(List<Fragment> list, List<String> list2) {
        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter(getChildFragmentManager(), list);
        tabFragmentAdapter.setTitleList(list2);
        this.mViewPager.setAdapter(tabFragmentAdapter);
        this.mTabLayout.setupWithViewPager(this.mViewPager);
    }

    public final void H1() {
        PayHydropowerModel payHydropowerModel = (PayHydropowerModel) h(PayHydropowerModel.class);
        payHydropowerModel.getRecordTabLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.t2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2101a.I1((ResponseRowsVo) obj);
            }
        });
        payHydropowerModel.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.s2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2097a.C((RequestErrDto) obj);
            }
        });
        z0(R.string.loading_text);
        payHydropowerModel.getRecordTabList();
    }

    public final void I1(ResponseRowsVo<RecordTabVo> responseRowsVo) {
        List<RecordTabVo> rows;
        H();
        if (responseRowsVo == null || (rows = responseRowsVo.getRows()) == null || rows.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (RecordTabVo recordTabVo : rows) {
            if (recordTabVo != null && recordTabVo.getDeviceTypeName() != null) {
                String deviceTypeName = recordTabVo.getDeviceTypeName();
                String unitName = recordTabVo.getUnitName();
                if (x.isNotNull(unitName)) {
                    deviceTypeName = deviceTypeName + x.appendStringToResId(R.string.placeholder_bracket, unitName);
                }
                arrayList.add(RecordFragment.getInstance(recordTabVo.getDeviceType()));
                arrayList2.add(deviceTypeName);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        E1(arrayList, arrayList2);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(getString(R.string.title_cat_table_record));
        H1();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_water_electric_tab_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
    }
}
