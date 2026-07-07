package com.chinavisionary.microtang.room.fragment;

import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import anet.channel.util.ErrorConstant;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.a.d.y;
import c.e.b.c.d.h;
import c.e.c.m0.c;
import c.e.c.m0.l;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.core.weight.banner.AutoScrollViewPager;
import com.chinavisionary.core.weight.banner.EditBannerViewPagerAdapter;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.base.TabFragmentAdapter;
import com.chinavisionary.microtang.main.event.EventOssUpdateSuccess;
import com.chinavisionary.microtang.main.event.EventUpdateAliYunOss;
import com.chinavisionary.microtang.main.model.NewRoomModel;
import com.chinavisionary.microtang.main.vo.ResponseGroupItemDetailsVo;
import com.chinavisionary.microtang.map.MapDialogFragment;
import com.chinavisionary.microtang.room.vo.ProductDetailsVo;
import com.chinavisionary.microtang.web.WebFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.nex3z.flowlayout.FlowLayout;
import g.b.a.m;
import g.b.a.r;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RoomDetailsFragment extends BaseFragment<String> {
    public WebFragment D;
    public EditBannerViewPagerAdapter E;
    public NewRoomModel F;
    public String G;
    public c.e.c.h0.g.a H;
    public String I;
    public String J;
    public List<ProductDetailsVo.BannersBean> K;

    @BindView(R.id.app_bar_layout)
    public AppBarLayout mAppBarLayout;

    @BindView(R.id.tv_cat_map)
    public TextView mCatMapTv;

    @BindView(R.id.banner_room_pic)
    public AutoScrollViewPager mEditBannerView;

    @BindView(R.id.btn_pre_look_room)
    public Button mPreLookBtn;

    @BindView(R.id.view_bottom_bg)
    public View mPreLookView;

    @BindView(R.id.tv_room_price)
    public TextView mPriceTv;

    @BindView(R.id.tv_room_rent_price_end)
    public TextView mPriceUnitTv;

    @BindView(R.id.flayout_product_tags)
    public FlowLayout mProductTagLayout;

    @BindView(R.id.tv_product_title)
    public TextView mProductTitleTv;

    @BindView(R.id.llayout_room_indicator)
    public LinearLayout mRoomIndicatorLayout;

    @BindView(R.id.img_room_source_location)
    public ImageView mRoomLocationIconImg;

    @BindView(R.id.img_room_location)
    public CoreRoundedImageView mRoomLocationImg;

    @BindView(R.id.tv_room_details_location)
    public TextView mRoomLocationTv;

    @BindView(R.id.tab_layout)
    public TabLayout mTabLayout;

    @BindView(R.id.img_back)
    public ImageView mTitleBackImg;

    @BindView(R.id.view_title_bg)
    public View mTitleBgView;

    @BindView(R.id.tv_title_split_line)
    public TextView mTitleLineTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    @BindView(R.id.view_page_room)
    public ViewPager mViewPager;
    public long B = 0;
    public int C = ErrorConstant.ERROR_NO_NETWORK;
    public ViewPager.OnPageChangeListener L = new a();

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
            RoomDetailsFragment.this.g2(i2);
        }
    }

    public class b implements c.e.c.h0.e.a {
        public b() {
        }

        @Override // c.e.c.h0.e.a
        public void onExpandedHied() {
            RoomDetailsFragment.this.G1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N1(AppBarLayout appBarLayout, int i2) {
        int i3 = i2 < this.C ? 0 : 8;
        if (this.mTitleBgView.getVisibility() != i3) {
            this.mTitleBgView.setVisibility(i3);
            this.mTitleTv.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: O1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P1(String str) {
        boolean z;
        if (this.K == null) {
            List<ProductDetailsVo.BannersBean> listLoadBannerPic = this.H.loadBannerPic(str);
            if (o.isNotEmpty(listLoadBannerPic)) {
                this.K = listLoadBannerPic;
                q.d(getClass().getSimpleName(), "roomBannerVos size =" + this.K.size());
                this.f6488f.obtainMessage(1).sendToTarget();
                z = false;
            } else {
                z = true;
            }
        } else {
            z = false;
        }
        String roomMapPathToGroupName = c.e.a.a.i.b.getRoomMapPathToGroupName(str);
        String roomBigMapPathToGroupName = c.e.a.a.i.b.getRoomBigMapPathToGroupName(str);
        List<ResourceVo> resourceListToPath = c.e.a.a.i.b.getInstance().getResourceListToPath(roomMapPathToGroupName);
        List<ResourceVo> resourceListToPath2 = c.e.a.a.i.b.getInstance().getResourceListToPath(roomBigMapPathToGroupName);
        if (o.isNotEmpty(resourceListToPath2)) {
            this.J = resourceListToPath2.get(0).getUrl();
        } else {
            z = true;
        }
        if (o.isNotEmpty(resourceListToPath)) {
            this.I = resourceListToPath.get(0).getUrl();
            this.f6488f.obtainMessage(2).sendToTarget();
        } else {
            z = true;
        }
        boolean z2 = System.currentTimeMillis() - this.B > 10000;
        if (z && z2) {
            this.B = System.currentTimeMillis();
            U1();
        }
    }

    public static RoomDetailsFragment getInstance(String str) {
        RoomDetailsFragment roomDetailsFragment = new RoomDetailsFragment();
        roomDetailsFragment.setArguments(CoreBaseFragment.q(str));
        return roomDetailsFragment;
    }

    public final void G1() {
        this.mAppBarLayout.setExpanded(false);
    }

    public final List<Fragment> H1() {
        ArrayList arrayList = new ArrayList();
        WebFragment webFragment = WebFragment.getInstance(null);
        this.D = webFragment;
        webFragment.setShowTitle(false);
        arrayList.add(MoreRentRoomFragment.getInstance(this.f6484b, new b()));
        return arrayList;
    }

    public final List<String> I1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R.string.tab_title_rent_room_list));
        return arrayList;
    }

    public final void J1(RequestErrDto requestErrDto) {
        boolean zOpenTipActivity;
        if (requestErrDto != null) {
            int code = requestErrDto.getCode();
            zOpenTipActivity = c.getInstance().openTipActivity(this.f6487e, code);
            q.d(this.f6485c, "handleResponseErr errCode = " + code);
            if (zOpenTipActivity) {
                n();
            }
        } else {
            zOpenTipActivity = false;
        }
        if (zOpenTipActivity) {
            return;
        }
        C(requestErrDto);
    }

    public final void K1() {
        h0(this);
        this.f6488f = new CoreBaseFragment.c(this);
        this.mTitleTv.setText(R.string.title_product_details);
        this.mTitleTv.setVisibility(4);
        this.mTitleBackImg.setVisibility(4);
        this.mTitleLineTv.setVisibility(8);
        this.mRoomLocationImg.setOnClickListener(this.y);
        this.mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: c.e.c.h0.f.p
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
                this.f1511a.N1(appBarLayout, i2);
            }
        });
        EditBannerViewPagerAdapter editBannerViewPagerAdapter = new EditBannerViewPagerAdapter();
        this.E = editBannerViewPagerAdapter;
        this.mEditBannerView.setAdapter(editBannerViewPagerAdapter);
        this.mEditBannerView.addOnPageChangeListener(this.L);
    }

    public final void R1(final String str) {
        y.get().addRunnable(new Runnable() { // from class: c.e.c.h0.f.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f1512a.P1(str);
            }
        });
    }

    public final boolean S1(ResponseGroupItemDetailsVo responseGroupItemDetailsVo) {
        boolean zIsNullStr = true;
        if (responseGroupItemDetailsVo != null) {
            if (o.isNotEmpty(responseGroupItemDetailsVo.getBannerImagesList())) {
                this.K = this.H.loadNewBannerPic(responseGroupItemDetailsVo.getBannerImagesList());
                this.f6488f.obtainMessage(1).sendToTarget();
                zIsNullStr = false;
            }
            if (!zIsNullStr) {
                zIsNullStr = x.isNullStr(responseGroupItemDetailsVo.getLongitude());
            }
            Z1(responseGroupItemDetailsVo.getLongitude(), responseGroupItemDetailsVo.getLatitude());
        }
        return zIsNullStr;
    }

    public final void T1(h hVar) {
        h hVar2 = new h();
        hVar2.setLongitude(hVar.getLongitude());
        hVar2.setLatitude(hVar.getLatitude());
        hVar2.setLocationName(this.mRoomLocationTv.getText().toString());
        d(MapDialogFragment.getInstance(hVar2), R.id.flayout_content);
    }

    public final void U1() {
        EventUpdateAliYunOss eventUpdateAliYunOss = new EventUpdateAliYunOss();
        eventUpdateAliYunOss.setMethodName(getClass().getSimpleName() + "-sendRefreshAliYunOss");
        k(eventUpdateAliYunOss);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        switch (view.getId()) {
            case R.id.id_room_banner_img /* 2131231166 */:
                this.H.openRoomDetailsPhoto();
                break;
            case R.id.id_room_details_banner_indicator_tv /* 2131231167 */:
                f2(view);
                break;
            case R.id.img_room_location /* 2131231276 */:
                if (view.getTag() != null) {
                    T1((h) view.getTag());
                }
                break;
        }
    }

    public final void V1(List<ProductDetailsVo.BannersBean> list) {
        this.mRoomIndicatorLayout.removeAllViews();
        this.E.setViews(this.H.getBannerList(list, this.mRoomIndicatorLayout, this.y));
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        K1();
        d2();
        e2();
        I1();
    }

    public final void W1(ResponseGroupItemDetailsVo responseGroupItemDetailsVo) {
        H();
        this.G = responseGroupItemDetailsVo.getUrl();
        this.mRoomLocationTv.setText(x.getNotNullStr(responseGroupItemDetailsVo.getAddress(), ""));
        c2(responseGroupItemDetailsVo.getGroupName());
        if (S1(responseGroupItemDetailsVo)) {
            R1(responseGroupItemDetailsVo.getGroupName());
        }
        a2(responseGroupItemDetailsVo.getRentPrice());
        X1(responseGroupItemDetailsVo.getGroupDesc());
        b2(responseGroupItemDetailsVo.getTagCloudDtos());
    }

    public final void X1(String str) {
        this.D.setHtmlContent(str);
        this.D.refreshLoad();
    }

    public final void Y1() {
        x.isNotNull(this.I);
    }

    public final void Z1(String str, String str2) {
        q.d(getClass().getSimpleName(), "longitude = " + str + ",latitude = " + str2);
        if (str == null || str2 == null) {
            return;
        }
        try {
            double d2 = Double.parseDouble(str);
            double d3 = Double.parseDouble(str2);
            h hVar = new h();
            hVar.setLongitude(Double.valueOf(d2));
            hVar.setLatitude(Double.valueOf(d3));
            this.mRoomLocationIconImg.setVisibility(0);
            this.mCatMapTv.setVisibility(0);
            this.mRoomLocationImg.setTag(hVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a2(String str) {
        x.appendStringToResId(R.string.title_placeholder_rent_price, str);
        l.setupRentPrice(str, this.mPriceTv);
        if (x.isNullStr(str)) {
            this.mPriceTv.setText("-");
        }
    }

    public final void b2(List<ProductDetailsVo.TagsBean> list) {
        this.H.addProductTag(list, this.mProductTagLayout);
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    public final void c2(String str) {
        this.mProductTitleTv.setText(x.getNotNullStr(str, ""));
        this.mTitleTv.setText(x.getNotNullStr(str, ""));
    }

    @OnClick({R.id.tv_cat_community_details})
    public void clickCatCommunityDetails() {
        String string;
        if (x.isNotNull(this.G)) {
            if ("18688948873".equals(s())) {
                string = x.getString(R.string.title_community_details);
                this.G = "https://chinavisionary-vtown-uat2.oss-cn-beijing.aliyuncs.com/android/details/%E5%BE%AE%E6%A3%A0%E7%A4%BE%E5%8C%BA.jpg";
            } else {
                string = "";
            }
            c1(1, this.G, string);
        }
    }

    public final void d2() {
        NewRoomModel newRoomModel = (NewRoomModel) h(NewRoomModel.class);
        this.F = newRoomModel;
        newRoomModel.getGroupDetailsResult().observe(this, new Observer() { // from class: c.e.c.h0.f.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1515a.W1((ResponseGroupItemDetailsVo) obj);
            }
        });
        this.F.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.h0.f.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1514a.J1((RequestErrDto) obj);
            }
        });
        this.H = new c.e.c.h0.g.a(getActivity());
    }

    public final void e2() {
        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter(getFragmentManager(), H1());
        tabFragmentAdapter.setTitleList(I1());
        this.mViewPager.setAdapter(tabFragmentAdapter);
        this.mTabLayout.setupWithViewPager(this.mViewPager);
    }

    public final void f2(View view) {
        Integer indexToViewTag = this.H.getIndexToViewTag(view);
        if (indexToViewTag != null) {
            this.mEditBannerView.setCurrentItem(indexToViewTag.intValue());
        }
    }

    @OnClick({R.id.img_finish})
    public void finishClick(View view) {
        n();
    }

    public final void g2(int i2) {
        this.H.updatePageIndicator(i2);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_room_details_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
        this.F.getGroupItemDetails(this.f6484b);
        q.d(this.f6485c, "requestData");
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
        this.mViewPager.clearOnPageChangeListeners();
        this.mEditBannerView.clearOnPageChangeListeners();
        this.mEditBannerView.recyclerReference();
        this.mTabLayout.removeAllTabs();
        this.mViewPager.removeAllViews();
        this.E.recyclerReference();
        this.mEditBannerView.removeAllViews();
        this.H.recyclerReference();
        this.mRoomIndicatorLayout.removeAllViews();
        this.mProductTagLayout.removeAllViews();
        this.D.onDestroy();
        this.D = null;
        this.mTabLayout = null;
        this.mViewPager = null;
        this.mEditBannerView = null;
        this.mRoomIndicatorLayout = null;
        this.H = null;
        this.L = null;
        this.f6487e = null;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mPreLookBtn.setVisibility(Q() ? 8 : 0);
        this.mPreLookView.setVisibility(Q() ? 8 : 0);
    }

    @OnClick({R.id.btn_pre_look_room})
    public void preLookRoom(View view) {
        if (N()) {
            d(PreLookRoomFragment.getInstance(this.f6484b), R.id.flayout_content);
        }
    }

    @m(threadMode = r.BACKGROUND)
    public void registerEventOssUpdateSuccess(EventOssUpdateSuccess eventOssUpdateSuccess) {
        if (System.currentTimeMillis() - this.B > 10000) {
            this.f6483a = 1;
            this.B = System.currentTimeMillis();
            I1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            V1(this.K);
        } else {
            if (i2 != 2) {
                return;
            }
            Y1();
        }
    }
}
