package com.chinavisionary.paymentlibrary;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.paymentlibrary.view.PayChannelView;

/* JADX INFO: loaded from: classes2.dex */
public class PayTypeFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PayTypeFragment f8732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8733c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PayTypeFragment f8734c;

        public a(PayTypeFragment payTypeFragment) {
            this.f8734c = payTypeFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8734c.backClick();
        }
    }

    @UiThread
    public PayTypeFragment_ViewBinding(PayTypeFragment payTypeFragment, View view) {
        this.f8732b = payTypeFragment;
        payTypeFragment.mTitleBgView = d.findRequiredView(view, R.id.view_title_bg, "field 'mTitleBgView'");
        payTypeFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        payTypeFragment.mPayPriceTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_pay_price, "field 'mPayPriceTv'", TextView.class);
        payTypeFragment.mPayTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_pay_title, "field 'mPayTitleTv'", TextView.class);
        payTypeFragment.mPayCountdownTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_pay_countdown, "field 'mPayCountdownTv'", TextView.class);
        payTypeFragment.mPayLateFeeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_pay_late_fee_price, "field 'mPayLateFeeTv'", TextView.class);
        payTypeFragment.mPayCouponTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_pay_coupon_title, "field 'mPayCouponTitleTv'", TextView.class);
        payTypeFragment.mPaySrcPriceTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_pay_src_price, "field 'mPaySrcPriceTv'", TextView.class);
        payTypeFragment.mCouponValueTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_coupon_value, "field 'mCouponValueTv'", TextView.class);
        payTypeFragment.mCouponTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_discount_title, "field 'mCouponTitleTv'", TextView.class);
        payTypeFragment.mPayCostListRecyclerView = (BaseRecyclerView) d.findRequiredViewAsType(view, R.id.recycler_pay_cost_list, "field 'mPayCostListRecyclerView'", BaseRecyclerView.class);
        payTypeFragment.mPayCouponListRecyclerView = (BaseRecyclerView) d.findRequiredViewAsType(view, R.id.recycler_pay_coupon_list, "field 'mPayCouponListRecyclerView'", BaseRecyclerView.class);
        payTypeFragment.mPayChannelView = (PayChannelView) d.findRequiredViewAsType(view, R.id.pay_channel_view, "field 'mPayChannelView'", PayChannelView.class);
        payTypeFragment.mPayChannelTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_pay_channel_title, "field 'mPayChannelTitleTv'", TextView.class);
        payTypeFragment.mConfirmPayBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_confirm_pay, "field 'mConfirmPayBtn'", AppCompatButton.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8733c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(payTypeFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PayTypeFragment payTypeFragment = this.f8732b;
        if (payTypeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8732b = null;
        payTypeFragment.mTitleBgView = null;
        payTypeFragment.mTitleTv = null;
        payTypeFragment.mPayPriceTv = null;
        payTypeFragment.mPayTitleTv = null;
        payTypeFragment.mPayCountdownTv = null;
        payTypeFragment.mPayLateFeeTv = null;
        payTypeFragment.mPayCouponTitleTv = null;
        payTypeFragment.mPaySrcPriceTv = null;
        payTypeFragment.mCouponValueTv = null;
        payTypeFragment.mCouponTitleTv = null;
        payTypeFragment.mPayCostListRecyclerView = null;
        payTypeFragment.mPayCouponListRecyclerView = null;
        payTypeFragment.mPayChannelView = null;
        payTypeFragment.mPayChannelTitleTv = null;
        payTypeFragment.mConfirmPayBtn = null;
        this.f8733c.setOnClickListener(null);
        this.f8733c = null;
    }
}
