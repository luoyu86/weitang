package com.chinavisionary.microtang.community.fragment;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.g;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.v;
import c.e.a.d.w;
import c.e.a.d.x;
import c.e.c.m0.e;
import c.e.c.v.f.h0;
import c.e.c.v.f.k0;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alipay.sdk.m.x.d;
import com.chinavisionary.core.app.ad.manager.ADManager;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.scan.view.ScanCodeActivity;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.base.TabFragmentAdapter;
import com.chinavisionary.microtang.community.fragment.CommunityActivityTabFragment;
import com.chinavisionary.microtang.community.vo.ActivityConstantVo;
import com.chinavisionary.microtang.community.vo.LatLngVo;
import com.chinavisionary.microtang.db.vo.CacheVo;
import com.chinavisionary.microtang.main.bo.RequestBannerParamBo;
import com.chinavisionary.microtang.main.event.EventBadgeMsgVo;
import com.chinavisionary.microtang.main.event.EventUpdateProject;
import com.chinavisionary.microtang.main.fragments.ProjectListFragment;
import com.chinavisionary.microtang.main.vo.RoomModelVo;
import com.chinavisionary.microtang.me.vo.FundNewsVo;
import com.chinavisionary.microtang.msg.MsgActivity;
import com.chinavisionary.microtang.room.SearchRoomActivity;
import com.chinavisionary.microtang.service.CustomerServiceActivity;
import com.chinavisionary.microtang.vo.InitAuthSuccessVo;
import com.google.android.material.tabs.TabLayout;
import g.b.a.m;
import g.b.a.r;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommunityActivityTabFragment extends BaseFragment<RoomModelVo.ModulesBean> {
    public static final Long B = 8000L;
    public String C;
    public h0 D;
    public k0 E;
    public List<Fragment> K;
    public LatLngVo L;

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

    @BindView(R.id.tv_permission_info)
    public TextView mPermissionInfoTv;

    @BindView(R.id.tab_layout)
    public TabLayout mTabLayout;
    public volatile boolean F = false;
    public volatile boolean G = false;
    public boolean H = false;
    public boolean I = false;
    public boolean J = false;
    public boolean M = false;
    public final ViewPager.OnPageChangeListener N = new a();
    public final c.e.c.n.b.b O = new b();

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
            CommunityActivityTabFragment.this.E.updateSelectActivityTabToPosition(i2, true);
        }
    }

    public class b implements c.e.c.n.b.b {
        public b() {
        }

        @Override // c.e.c.n.b.b
        public void onRefresh() {
            CommunityActivityTabFragment.this.P0();
            CommunityActivityTabFragment.this.I1();
            if (CommunityActivityTabFragment.this.H || !CommunityActivityTabFragment.this.F) {
                return;
            }
            CommunityActivityTabFragment.this.P1(d.p);
        }
    }

    public static /* synthetic */ void N1(RoomModelVo.ModulesBean modulesBean) {
        try {
            c.e.c.p.b.getInstance().insertCacheVo(CacheVo.ACTIVITY_BANNER_CACHE_KEY, JSON.toJSONString(modulesBean, SerializerFeature.DisableCircularReferenceDetect));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static CommunityActivityTabFragment getInstance() {
        return new CommunityActivityTabFragment();
    }

    public final void J1() {
        T1();
        P0();
    }

    public final List<Fragment> K1(List<String> list) {
        ArrayList arrayList = new ArrayList();
        this.K = arrayList;
        arrayList.add(CommunityActivityFragment.getInstance(this.O, null));
        if (o.isNotEmpty(list)) {
            for (String str : list) {
                if (str != null) {
                    this.K.add(CommunityActivityFragment.getInstance(this.O, str));
                }
            }
        }
        return this.K;
    }

    public final void L1(View view) {
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

    public final void M1() {
        this.D = new h0();
        this.C = R0();
        R1(S0());
        this.mCityTv.setOnClickListener(this.y);
        this.mLifeCoverBannerView.setImageCornerRadius(0);
        this.mLifeCoverBannerView.setFragment(null);
        this.mLifeCoverBannerView.setIsShowIndicator(false);
        this.mLifeCoverBannerView.setItemClickListener(this.y);
    }

    public final void O1() {
        try {
            CacheVo cacheVo = c.e.c.p.b.getInstance().getCacheVo(CacheVo.ACTIVITY_BANNER_CACHE_KEY);
            List<EditBannerView.BannerDto> arrayList = new ArrayList<>();
            if (cacheVo != null) {
                String cacheValue = cacheVo.getCacheValue();
                if (x.isNotNull(cacheValue)) {
                    q.d(this.f6485c, "cacheValue = " + cacheValue);
                    RoomModelVo.ModulesBean modulesBean = (RoomModelVo.ModulesBean) JSON.parseObject(cacheValue, RoomModelVo.ModulesBean.class);
                    if (this.mLifeCoverBannerView.getVisibility() == 8) {
                        this.mLifeCoverBannerView.setVisibility(0);
                    }
                    List<EditBannerView.BannerDto> bannerDtoList = modulesBean.getBannerDtoList();
                    S1(bannerDtoList);
                    arrayList = bannerDtoList;
                }
            } else {
                S1(arrayList);
            }
            this.mLifeCoverBannerView.setAdapterListData(arrayList);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void P1(String str) {
        if (!w.getInstance().getBoolean("isFirstLoginAppKey", true)) {
            q.d(this.f6485c, "openGpsLocation method = " + str);
            if (v.getInstance().isRepeatedlyAction("openGpsLocation", 1000)) {
                return;
            }
            q.d(this.f6485c, "openGpsLocation isRepeatedlyAction method = " + str);
        }
    }

    public final void Q1() {
        String strU = u();
        if (x.isNotNull(strU)) {
            try {
                this.L = (LatLngVo) JSON.parseObject(strU, LatLngVo.class);
                c.e.c.n.c.a.getInstance().setLatLngVo(this.L);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void R1(String str) {
        this.D.updateCityTv(this.mCityTv, str);
    }

    public final void S1(List<EditBannerView.BannerDto> list) {
        if (list == null || list.size() != 0) {
            return;
        }
        EditBannerView.BannerDto bannerDto = new EditBannerView.BannerDto();
        ResourceVo resourceVo = new ResourceVo();
        String communityDefaultBannerUrl = c.e.c.x.c.a.getInstance().getCommunityDefaultBannerUrl();
        if (x.isNullStr(communityDefaultBannerUrl)) {
            communityDefaultBannerUrl = String.valueOf(R.mipmap.ic_default_activity_banner);
        }
        resourceVo.setUrl(communityDefaultBannerUrl);
        resourceVo.setSampleUrl(communityDefaultBannerUrl);
        bannerDto.setCover(resourceVo);
        bannerDto.setPicFitXy(false);
        bannerDto.setBaseKey("setupDefaultBanner");
        bannerDto.setKey("setupDefaultBanner");
        list.add(bannerDto);
    }

    public final void T1() {
        List<String> activityLabKeyList = c.e.c.n.c.a.getInstance().getActivityLabKeyList();
        List<String> activityLabValueList = c.e.c.n.c.a.getInstance().getActivityLabValueList();
        this.mLifeViewPager.setAdapter(new TabFragmentAdapter(getChildFragmentManager(), K1(activityLabKeyList)));
        this.mLifeViewPager.setOffscreenPageLimit(activityLabKeyList.size() + 1);
        this.mTabLayout.setupWithViewPager(this.mLifeViewPager);
        this.E.setupCommunityActivityTab(this.mTabLayout, activityLabValueList);
    }

    @Override // com.chinavisionary.microtang.base.BaseFragment
    public void U0(final RoomModelVo.ModulesBean modulesBean) {
        new Thread(new Runnable() { // from class: c.e.c.n.d.n
            @Override // java.lang.Runnable
            public final void run() {
                CommunityActivityTabFragment.N1(modulesBean);
            }
        }).start();
        if (this.mLifeCoverBannerView.getVisibility() == 8) {
            this.mLifeCoverBannerView.setVisibility(0);
        }
        List<EditBannerView.BannerDto> bannerDtoList = modulesBean.getBannerDtoList();
        S1(bannerDtoList);
        this.mLifeCoverBannerView.setAdapterListData(bannerDtoList);
        if (g.getInstance().isHasEnableActivityBannerAd()) {
            FrameLayout frameLayoutCreateBannerFrameLayout = ADManager.getInstance().createBannerFrameLayout(this.mLifeCoverBannerView.getContext(), true);
            this.mLifeCoverBannerView.addViewToAdapter(frameLayoutCreateBannerFrameLayout);
            ADManager.getInstance().loadActivityBannerAd(this, frameLayoutCreateBannerFrameLayout);
        }
    }

    public final void U1() {
        w.getInstance().getBoolean("isFirstLoginAppKey", true);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.edt_input_search) {
            d0(SearchRoomActivity.class);
            return;
        }
        if (id == R.id.img_banner_pic) {
            L1(view);
        } else if (id == R.id.tv_city) {
            V1();
        } else if (id == R.id.tv_alert_confirm) {
            P1("onClickView");
        }
    }

    public final void V1() {
        d(ProjectListFragment.getInstance(this.C), R.id.constraint_main_content);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        h0(this);
        M1();
        this.f6488f = new CoreBaseFragment.c(this);
        this.E = new k0();
        this.mLifeViewPager.addOnPageChangeListener(this.N);
        z1();
        J1();
        Q1();
    }

    @Override // com.chinavisionary.microtang.base.BaseFragment
    public void a1(ActivityConstantVo activityConstantVo) {
        super.a1(activityConstantVo);
        if (activityConstantVo == null || !c.e.c.n.c.a.getInstance().setActivityLabList(activityConstantVo.getActivityLabType())) {
            return;
        }
        T1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_tab_activity;
    }

    @m
    public void initAuthSuccessEvent(InitAuthSuccessVo initAuthSuccessVo) {
        this.J = true;
        q.d(this.f6485c, "initAuthSuccessEvent");
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
        v1(RequestBannerParamBo.GET_COMMUNITY_BANNER_TYPE);
    }

    @OnClick({R.id.rlayout_notify})
    public void msgClickView(View view) {
        if (N()) {
            d0(MsgActivity.class);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.I = true;
        q.d(this.f6485c, "onPause");
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 1) {
            this.G = true;
            this.mPermissionInfoTv.setVisibility(8);
            P1("onRequestPermissionsResult");
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        q.d(this.f6485c, "onResume");
        if (this.I && this.J && getUserVisibleHint()) {
            this.I = false;
            this.J = false;
            U1();
        }
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
        this.C = eventUpdateProject.getKey();
        R1(eventUpdateProject.getTitle());
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
        if (z && !this.F) {
            this.F = true;
            O1();
            I1();
            try {
                U1();
                ((CommunityActivityFragment) ((TabFragmentAdapter) this.mLifeViewPager.getAdapter()).getFragments().get(0)).setUserVisibleHint(true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        q.d(this.f6485c, "setUserVisibleHint isVisibleToUser - " + z);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        super.z(message);
        if (message.what != 2 || this.M) {
            return;
        }
        this.M = true;
    }
}
