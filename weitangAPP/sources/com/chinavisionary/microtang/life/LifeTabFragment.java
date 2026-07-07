package com.chinavisionary.microtang.life;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.g;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.m0.e;
import c.e.c.n.b.b;
import c.e.c.v.f.h0;
import c.e.c.v.f.k0;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.chinavisionary.core.app.ad.manager.ADManager;
import com.chinavisionary.core.scan.view.ScanCodeActivity;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.base.TabFragmentAdapter;
import com.chinavisionary.microtang.db.vo.CacheVo;
import com.chinavisionary.microtang.life.LifeTabFragment;
import com.chinavisionary.microtang.main.bo.RequestBannerParamBo;
import com.chinavisionary.microtang.main.event.EventBadgeMsgVo;
import com.chinavisionary.microtang.main.event.EventUpdateProject;
import com.chinavisionary.microtang.main.fragments.ProjectListFragment;
import com.chinavisionary.microtang.main.vo.RoomModelVo;
import com.chinavisionary.microtang.me.vo.FundNewsVo;
import com.chinavisionary.microtang.msg.MsgActivity;
import com.chinavisionary.microtang.room.SearchRoomActivity;
import com.chinavisionary.microtang.service.CustomerServiceActivity;
import com.google.android.material.tabs.TabLayout;
import g.b.a.m;
import g.b.a.r;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LifeTabFragment extends BaseFragment<RoomModelVo.ModulesBean> {
    public String B;
    public h0 C;
    public k0 D;
    public volatile boolean E = false;
    public final ViewPager.OnPageChangeListener F = new a();
    public final b G = new b() { // from class: c.e.c.t.o
        @Override // c.e.c.n.b.b
        public final void onRefresh() {
            this.f1850a.I1();
        }
    };

    @BindView(R.id.tv_badge_paint)
    public TextView mBadgePaintTv;

    @BindView(R.id.tv_badge_value)
    public TextView mBadgeValueTv;

    @BindView(R.id.tv_city)
    public AppCompatTextView mCityTv;

    @BindView(R.id.banner_life_cover)
    public EditBannerView mLifeCoverBannerView;

    @BindView(R.id.view_page_life)
    public ViewPager mLifeViewPager;

    @BindView(R.id.tab_layout)
    public TabLayout mTabLayout;

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
            LifeTabFragment.this.D.updateSelectTabToPosition(i2);
        }
    }

    public static /* synthetic */ void I1(RoomModelVo.ModulesBean modulesBean) {
        try {
            c.e.c.p.b.getInstance().insertCacheVo(CacheVo.LIFE_BANNER_CACHE_KEY, JSON.toJSONString(modulesBean, SerializerFeature.DisableCircularReferenceDetect));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static LifeTabFragment getInstance() {
        return new LifeTabFragment();
    }

    public final List<Fragment> F1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(LifeFragment.getInstance(6, this.G));
        arrayList.add(LifeFragment.getInstance(2, this.G));
        arrayList.add(LifeFragment.getInstance(4, this.G));
        return arrayList;
    }

    public final void G1(View view) {
        EditBannerView.BannerDto bannerDto = (EditBannerView.BannerDto) view.getTag(R.id.edt_banner_view_img_path_id);
        if (x.isNotNull(bannerDto.getTitle())) {
            String title = bannerDto.getTitle();
            String dataKey = bannerDto.getDataKey();
            if (x.isNotNull(bannerDto.getTargetAppid())) {
                int i2 = 15;
                if (x.isNotNull(bannerDto.getTargetMiniType()) && FundNewsVo.TYPE_ALIPAY.equals(bannerDto.getTargetMiniType())) {
                    i2 = 18;
                }
                super.c1(Integer.valueOf(i2), bannerDto.getTargetAppid(), bannerDto.getTargetPath());
            } else {
                super.c1(Integer.valueOf(bannerDto.getDataType()), dataKey, title);
            }
            super.V0(title);
            u1(bannerDto.getBaseKey());
        }
    }

    public final void H1() {
        this.C = new h0();
        this.B = R0();
        K1(S0());
        this.mCityTv.setOnClickListener(this.y);
    }

    public final void J1() {
        try {
            CacheVo cacheVo = c.e.c.p.b.getInstance().getCacheVo(CacheVo.LIFE_BANNER_CACHE_KEY);
            List<EditBannerView.BannerDto> arrayList = new ArrayList<>();
            if (cacheVo != null) {
                String cacheValue = cacheVo.getCacheValue();
                if (x.isNotNull(cacheValue)) {
                    q.d(this.f6485c, "cacheValue = " + cacheValue);
                    RoomModelVo.ModulesBean modulesBean = (RoomModelVo.ModulesBean) JSON.parseObject(cacheValue, RoomModelVo.ModulesBean.class);
                    if (this.mLifeCoverBannerView.getVisibility() == 8) {
                        this.mLifeCoverBannerView.setVisibility(0);
                    }
                    arrayList = modulesBean.getBannerDtoList();
                }
            }
            L1(arrayList);
            this.mLifeCoverBannerView.setAdapterListData(arrayList);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void K1(String str) {
        this.C.updateCityTv(this.mCityTv, str);
    }

    public final void L1(List<EditBannerView.BannerDto> list) {
        if (list == null || list.size() != 0) {
            return;
        }
        EditBannerView.BannerDto bannerDto = new EditBannerView.BannerDto();
        ResourceVo resourceVo = new ResourceVo();
        String lifeDefaultBannerUrl = c.e.c.x.c.a.getInstance().getLifeDefaultBannerUrl();
        if (x.isNullStr(lifeDefaultBannerUrl)) {
            lifeDefaultBannerUrl = String.valueOf(R.mipmap.ic_default_life_banner);
        }
        resourceVo.setUrl(lifeDefaultBannerUrl);
        resourceVo.setSampleUrl(lifeDefaultBannerUrl);
        bannerDto.setCover(resourceVo);
        bannerDto.setPicFitXy(false);
        bannerDto.setBaseKey("setupDefaultBanner");
        bannerDto.setKey("setupDefaultBanner");
        list.add(bannerDto);
    }

    public final void M1() {
        this.D = new k0();
        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter(getChildFragmentManager(), F1());
        this.mLifeViewPager.addOnPageChangeListener(this.F);
        this.mLifeViewPager.setAdapter(tabFragmentAdapter);
        this.mTabLayout.setupWithViewPager(this.mLifeViewPager);
        this.mLifeViewPager.setOffscreenPageLimit(3);
        this.D.setupTab(this.mTabLayout);
        this.mLifeCoverBannerView.setFragment(null);
        this.mLifeCoverBannerView.setImageCornerRadius(0);
        this.mLifeCoverBannerView.setIsShowIndicator(false);
        this.mLifeCoverBannerView.setItemClickListener(this.y);
    }

    public final void N1() {
        d(ProjectListFragment.getInstance(this.B), R.id.constraint_main_content);
    }

    @Override // com.chinavisionary.microtang.base.BaseFragment
    public void U0(final RoomModelVo.ModulesBean modulesBean) {
        q.d(getClass().getSimpleName(), "handleBanner");
        new Thread(new Runnable() { // from class: c.e.c.t.i
            @Override // java.lang.Runnable
            public final void run() {
                LifeTabFragment.I1(modulesBean);
            }
        }).start();
        if (this.mLifeCoverBannerView.getVisibility() == 8) {
            this.mLifeCoverBannerView.setVisibility(0);
        }
        List<EditBannerView.BannerDto> bannerDtoList = modulesBean.getBannerDtoList();
        L1(bannerDtoList);
        this.mLifeCoverBannerView.setAdapterListData(bannerDtoList);
        if (g.getInstance().isHasEnableLifeBannerAd()) {
            FrameLayout frameLayoutCreateBannerFrameLayout = ADManager.getInstance().createBannerFrameLayout(this.mLifeCoverBannerView.getContext(), true);
            this.mLifeCoverBannerView.addViewToAdapter(frameLayoutCreateBannerFrameLayout);
            ADManager.getInstance().loadLifeBannerAd(this, frameLayoutCreateBannerFrameLayout);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.edt_input_search) {
            d0(SearchRoomActivity.class);
        } else if (id == R.id.img_banner_pic) {
            G1(view);
        } else if (id == R.id.tv_city) {
            N1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        h0(this);
        H1();
        M1();
        z1();
        J1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_tab_life;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
        v1(RequestBannerParamBo.GET_LIFE_BANNER_TYPE);
    }

    @OnClick({R.id.rlayout_notify})
    public void msgClickView(View view) {
        if (N()) {
            d0(MsgActivity.class);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    @OnClick({R.id.rlayout_scan})
    public void openScan(View view) {
        d0(ScanCodeActivity.class);
    }

    @m(sticky = true, threadMode = r.MAIN)
    public void registerEventBadgeMsg(EventBadgeMsgVo eventBadgeMsgVo) {
        e.setupBadge(eventBadgeMsgVo, this.mBadgeValueTv, this.mBadgePaintTv);
    }

    @m(sticky = true, threadMode = r.MAIN)
    public void registerEventUpdateProject(EventUpdateProject eventUpdateProject) {
        this.B = eventUpdateProject.getKey();
        K1(eventUpdateProject.getTitle());
        q.d(getClass().getSimpleName(), "registerEventUpdateProject project name = " + eventUpdateProject.getTitle());
        this.f6483a = 1;
        I1();
    }

    @OnClick({R.id.rlayout_server})
    public void serverClick(View view) {
        if (c.e.a.a.a.getInstance().isIMModel()) {
            d0(CustomerServiceActivity.class);
        } else if (N()) {
            d0(CustomerServiceActivity.class);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && !this.E) {
            this.E = true;
            try {
                ((LifeFragment) ((TabFragmentAdapter) this.mLifeViewPager.getAdapter()).getFragments().get(0)).setUserVisibleHint(true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            I1();
        }
        q.d(this.f6485c, "onResume-setUserVisibleHint isVisibleToUser - " + z);
    }
}
