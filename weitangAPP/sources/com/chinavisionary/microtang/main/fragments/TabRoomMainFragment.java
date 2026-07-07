package com.chinavisionary.microtang.main.fragments;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.v.f.k0;
import com.chinavisionary.core.scan.view.ScanCodeActivity;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.base.TabFragmentAdapter;
import com.chinavisionary.microtang.main.vo.RoomModelVo;
import com.chinavisionary.microtang.msg.MsgActivity;
import com.chinavisionary.microtang.room.SearchRoomActivity;
import com.chinavisionary.microtang.service.CustomerServiceActivity;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TabRoomMainFragment extends BaseFragment {
    public k0 B;
    public c.e.c.v.c.a C = new a();
    public ViewPager.OnPageChangeListener D = new b();

    @BindView(R.id.tv_city)
    public TextView mCityTv;

    @BindView(R.id.banner_view)
    public EditBannerView mMainBannerView;

    @BindView(R.id.tab_layout)
    public TabLayout mMainTabLayout;

    @BindView(R.id.view_page_room)
    public ViewPager mPageRoomViewPager;

    public class a implements c.e.c.v.c.a {
        public a() {
        }

        @Override // c.e.c.v.c.a
        public void setupMainBanner(RoomModelVo.ModulesBean modulesBean) {
            TabRoomMainFragment.this.mMainBannerView.setAdapterListData(modulesBean.getBannerDtoList());
        }
    }

    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            TabRoomMainFragment.this.B.updateSelectTabToPosition(i2);
        }
    }

    public static TabRoomMainFragment getInstance() {
        return new TabRoomMainFragment();
    }

    public final List<Fragment> F1() {
        ArrayList arrayList = new ArrayList();
        NewRoomMainFragment newRoomMainFragment = NewRoomMainFragment.getInstance(4);
        newRoomMainFragment.setIMainBannerCallback(this.C);
        arrayList.add(newRoomMainFragment);
        arrayList.add(NewRoomMainFragment.getInstance(3));
        return arrayList;
    }

    public final void G1(View view) {
        EditBannerView.BannerDto bannerDto = (EditBannerView.BannerDto) view.getTag(R.id.edt_banner_view_img_path_id);
        if (x.isNotNull(bannerDto.getDataKey())) {
            String title = bannerDto.getTitle();
            c1(Integer.valueOf(bannerDto.getDataType()), bannerDto.getDataKey(), title);
            V0(title);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.img_banner_pic) {
            G1(view);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.B = new k0();
        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter(getChildFragmentManager(), F1());
        this.mPageRoomViewPager.addOnPageChangeListener(this.D);
        this.mPageRoomViewPager.setAdapter(tabFragmentAdapter);
        this.mMainTabLayout.setupWithViewPager(this.mPageRoomViewPager);
        this.B.setupTab(this.mMainTabLayout);
        this.mMainBannerView.setFragment(null);
        this.mMainBannerView.setItemClickListener(this.y);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_tab_main_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
    }

    @OnClick({R.id.rlayout_notify})
    public void msgClickView(View view) {
        if (N()) {
            d0(MsgActivity.class);
        }
    }

    @OnClick({R.id.rlayout_scan})
    public void openScan(View view) {
        q.d(getClass().getCanonicalName(), "open scan");
        d0(ScanCodeActivity.class);
    }

    @OnClick({R.id.edt_input_search})
    public void openSearchRoomClick(View view) {
        d0(SearchRoomActivity.class);
    }

    @OnClick({R.id.rlayout_server})
    public void serverClick(View view) {
        if (c.e.a.a.a.getInstance().isIMModel()) {
            d0(CustomerServiceActivity.class);
        } else if (N()) {
            d0(CustomerServiceActivity.class);
        }
    }
}
