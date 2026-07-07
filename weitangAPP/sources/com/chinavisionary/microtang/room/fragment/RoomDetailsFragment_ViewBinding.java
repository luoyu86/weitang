package com.chinavisionary.microtang.room.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.core.weight.banner.AutoScrollViewPager;
import com.chinavisionary.microtang.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.nex3z.flowlayout.FlowLayout;

/* JADX INFO: loaded from: classes2.dex */
public class RoomDetailsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RoomDetailsFragment f8348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f8351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f8352f;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomDetailsFragment f8353c;

        public a(RoomDetailsFragment roomDetailsFragment) {
            this.f8353c = roomDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8353c.preLookRoom(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomDetailsFragment f8355c;

        public b(RoomDetailsFragment roomDetailsFragment) {
            this.f8355c = roomDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8355c.clickCatCommunityDetails();
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomDetailsFragment f8357c;

        public c(RoomDetailsFragment roomDetailsFragment) {
            this.f8357c = roomDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8357c.backClick(view);
        }
    }

    public class d extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomDetailsFragment f8359c;

        public d(RoomDetailsFragment roomDetailsFragment) {
            this.f8359c = roomDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8359c.finishClick(view);
        }
    }

    @UiThread
    public RoomDetailsFragment_ViewBinding(RoomDetailsFragment roomDetailsFragment, View view) {
        this.f8348b = roomDetailsFragment;
        roomDetailsFragment.mTitleTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        roomDetailsFragment.mTitleBackImg = (ImageView) b.c.d.findRequiredViewAsType(view, R.id.img_back, "field 'mTitleBackImg'", ImageView.class);
        roomDetailsFragment.mTitleLineTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_title_split_line, "field 'mTitleLineTv'", TextView.class);
        roomDetailsFragment.mTitleBgView = b.c.d.findRequiredView(view, R.id.view_title_bg, "field 'mTitleBgView'");
        roomDetailsFragment.mAppBarLayout = (AppBarLayout) b.c.d.findRequiredViewAsType(view, R.id.app_bar_layout, "field 'mAppBarLayout'", AppBarLayout.class);
        roomDetailsFragment.mEditBannerView = (AutoScrollViewPager) b.c.d.findRequiredViewAsType(view, R.id.banner_room_pic, "field 'mEditBannerView'", AutoScrollViewPager.class);
        roomDetailsFragment.mRoomIndicatorLayout = (LinearLayout) b.c.d.findRequiredViewAsType(view, R.id.llayout_room_indicator, "field 'mRoomIndicatorLayout'", LinearLayout.class);
        roomDetailsFragment.mProductTitleTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_product_title, "field 'mProductTitleTv'", TextView.class);
        roomDetailsFragment.mPriceTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_room_price, "field 'mPriceTv'", TextView.class);
        roomDetailsFragment.mPriceUnitTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_room_rent_price_end, "field 'mPriceUnitTv'", TextView.class);
        roomDetailsFragment.mRoomLocationTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_room_details_location, "field 'mRoomLocationTv'", TextView.class);
        roomDetailsFragment.mCatMapTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_cat_map, "field 'mCatMapTv'", TextView.class);
        roomDetailsFragment.mRoomLocationIconImg = (ImageView) b.c.d.findRequiredViewAsType(view, R.id.img_room_source_location, "field 'mRoomLocationIconImg'", ImageView.class);
        roomDetailsFragment.mProductTagLayout = (FlowLayout) b.c.d.findRequiredViewAsType(view, R.id.flayout_product_tags, "field 'mProductTagLayout'", FlowLayout.class);
        roomDetailsFragment.mTabLayout = (TabLayout) b.c.d.findRequiredViewAsType(view, R.id.tab_layout, "field 'mTabLayout'", TabLayout.class);
        roomDetailsFragment.mViewPager = (ViewPager) b.c.d.findRequiredViewAsType(view, R.id.view_page_room, "field 'mViewPager'", ViewPager.class);
        View viewFindRequiredView = b.c.d.findRequiredView(view, R.id.btn_pre_look_room, "field 'mPreLookBtn' and method 'preLookRoom'");
        roomDetailsFragment.mPreLookBtn = (Button) b.c.d.castView(viewFindRequiredView, R.id.btn_pre_look_room, "field 'mPreLookBtn'", Button.class);
        this.f8349c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(roomDetailsFragment));
        roomDetailsFragment.mPreLookView = b.c.d.findRequiredView(view, R.id.view_bottom_bg, "field 'mPreLookView'");
        roomDetailsFragment.mRoomLocationImg = (CoreRoundedImageView) b.c.d.findRequiredViewAsType(view, R.id.img_room_location, "field 'mRoomLocationImg'", CoreRoundedImageView.class);
        View viewFindRequiredView2 = b.c.d.findRequiredView(view, R.id.tv_cat_community_details, "method 'clickCatCommunityDetails'");
        this.f8350d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(roomDetailsFragment));
        View viewFindRequiredView3 = b.c.d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8351e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(roomDetailsFragment));
        View viewFindRequiredView4 = b.c.d.findRequiredView(view, R.id.img_finish, "method 'finishClick'");
        this.f8352f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(roomDetailsFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RoomDetailsFragment roomDetailsFragment = this.f8348b;
        if (roomDetailsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8348b = null;
        roomDetailsFragment.mTitleTv = null;
        roomDetailsFragment.mTitleBackImg = null;
        roomDetailsFragment.mTitleLineTv = null;
        roomDetailsFragment.mTitleBgView = null;
        roomDetailsFragment.mAppBarLayout = null;
        roomDetailsFragment.mEditBannerView = null;
        roomDetailsFragment.mRoomIndicatorLayout = null;
        roomDetailsFragment.mProductTitleTv = null;
        roomDetailsFragment.mPriceTv = null;
        roomDetailsFragment.mPriceUnitTv = null;
        roomDetailsFragment.mRoomLocationTv = null;
        roomDetailsFragment.mCatMapTv = null;
        roomDetailsFragment.mRoomLocationIconImg = null;
        roomDetailsFragment.mProductTagLayout = null;
        roomDetailsFragment.mTabLayout = null;
        roomDetailsFragment.mViewPager = null;
        roomDetailsFragment.mPreLookBtn = null;
        roomDetailsFragment.mPreLookView = null;
        roomDetailsFragment.mRoomLocationImg = null;
        this.f8349c.setOnClickListener(null);
        this.f8349c = null;
        this.f8350d.setOnClickListener(null);
        this.f8350d = null;
        this.f8351e.setOnClickListener(null);
        this.f8351e = null;
        this.f8352f.setOnClickListener(null);
        this.f8352f = null;
    }
}
