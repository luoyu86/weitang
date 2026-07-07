package com.chinavisionary.microtang.merchant.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.view.CustomTextView;

/* JADX INFO: loaded from: classes.dex */
public class MerchantMainBuyProductFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MerchantMainBuyProductFragment f7899b;

    @UiThread
    public MerchantMainBuyProductFragment_ViewBinding(MerchantMainBuyProductFragment merchantMainBuyProductFragment, View view) {
        this.f7899b = merchantMainBuyProductFragment;
        merchantMainBuyProductFragment.mBannerLayoutView = d.findRequiredView(view, R.id.include_banner_layout, "field 'mBannerLayoutView'");
        merchantMainBuyProductFragment.mMerchantActivityBanner = (EditBannerView) d.findRequiredViewAsType(view, R.id.banner_view, "field 'mMerchantActivityBanner'", EditBannerView.class);
        merchantMainBuyProductFragment.mLeftRecyclerView = (BaseRecyclerView) d.findRequiredViewAsType(view, R.id.recycler_layout_left_menu, "field 'mLeftRecyclerView'", BaseRecyclerView.class);
        merchantMainBuyProductFragment.mRightSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_right, "field 'mRightSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        merchantMainBuyProductFragment.mFloatTitleTv = (CustomTextView) d.findRequiredViewAsType(view, R.id.tv_float_title, "field 'mFloatTitleTv'", CustomTextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MerchantMainBuyProductFragment merchantMainBuyProductFragment = this.f7899b;
        if (merchantMainBuyProductFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7899b = null;
        merchantMainBuyProductFragment.mBannerLayoutView = null;
        merchantMainBuyProductFragment.mMerchantActivityBanner = null;
        merchantMainBuyProductFragment.mLeftRecyclerView = null;
        merchantMainBuyProductFragment.mRightSwipeRefreshLayout = null;
        merchantMainBuyProductFragment.mFloatTitleTv = null;
    }
}
