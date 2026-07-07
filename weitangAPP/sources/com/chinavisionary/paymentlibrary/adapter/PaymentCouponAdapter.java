package com.chinavisionary.paymentlibrary.adapter;

import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.a.d.x;
import c.e.a.d.z;
import com.alibaba.android.arouter.utils.Consts;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.weight.NewCouponView;
import com.chinavisionary.paymentlibrary.R;
import com.chinavisionary.paymentlibrary.vo.PayCouponVo;

/* JADX INFO: loaded from: classes2.dex */
public class PaymentCouponAdapter extends BaseRecyclerAdapter<PayCouponVo> {
    public boolean n;

    public static class CouponVh extends BaseRecyclerViewHolder<PayCouponVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f8737f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f8738g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f8739h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f8740i;
        public int j;
        public int k;
        public AbsoluteSizeSpan l;
        public AbsoluteSizeSpan m;

        @BindView(2396)
        public ImageView mCouponsBgImg;

        @BindView(2395)
        public ImageView mCouponsIconImg;

        @BindView(2892)
        public TextView mCouponsInfoMsgTv;

        @BindView(2891)
        public TextView mCouponsInfoTitleTv;

        @BindView(2317)
        public ConstraintLayout mNewCouponLayout;

        @BindView(2327)
        public NewCouponView mNewCouponView;

        @BindView(2889)
        public TextView mSaleCategoryTv;

        @BindView(2890)
        public TextView mSaleCostTv;

        @BindView(2860)
        public TextView mSaleExpireTipTv;

        @BindView(2893)
        public TextView mSaleUseRuleTv;

        @BindView(2894)
        public TextView mSaleValidDateTv;

        @BindView(2305)
        public CheckBox mSelectSaleCb;

        @BindView(2905)
        public TextView mUnavailableReasonTv;
        public AbsoluteSizeSpan n;
        public View.OnClickListener o;
        public Drawable p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Drawable f8741q;

        public CouponVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.n = new AbsoluteSizeSpan(17, true);
            this.l = new AbsoluteSizeSpan(17, true);
            this.m = new AbsoluteSizeSpan(17, true);
            Drawable drawable = view.getResources().getDrawable(R.mipmap.payment_lib_ic_coupons_up);
            this.p = drawable;
            drawable.setBounds(0, 0, 26, 17);
            Drawable drawable2 = view.getResources().getDrawable(R.mipmap.payment_lib_ic_coupons_down);
            this.f8741q = drawable2;
            drawable2.setBounds(0, 0, 26, 17);
            this.k = view.getResources().getColor(R.color.color_coupons_value);
            this.f8740i = view.getResources().getColor(R.color.color_coupons_discount_tv_color);
            this.j = view.getResources().getColor(com.chinavisionary.core.R.color.color_white);
            this.f8739h = view.getResources().getColor(R.color.color_coupons_unable_tv_color);
            this.f8738g = view.getResources().getColor(R.color.color_coupons_tv_color);
            this.mCouponsInfoTitleTv.setOnClickListener(new View.OnClickListener() { // from class: c.e.d.y.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f2333a.h(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void h(View view) {
            int i2;
            if (this.mCouponsInfoMsgTv.getVisibility() == 0) {
                i2 = 8;
                this.mCouponsInfoTitleTv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f8741q, (Drawable) null);
            } else {
                this.mCouponsInfoTitleTv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.p, (Drawable) null);
                i2 = 0;
            }
            this.mCouponsInfoMsgTv.setVisibility(i2);
        }

        public void i(PayCouponVo payCouponVo) {
            o(payCouponVo);
            k(payCouponVo);
            m(payCouponVo);
            this.mSaleUseRuleTv.setText(c(payCouponVo.getUseRule()));
            l(payCouponVo);
            p(payCouponVo);
            q(payCouponVo);
            n(payCouponVo);
        }

        public void j(boolean z) {
            this.f8737f = z;
        }

        public final void k(PayCouponVo payCouponVo) {
            int i2 = R.drawable.payment_lib_bg_coupons_rent;
            if (payCouponVo.isProductCoupon()) {
                i2 = R.drawable.payment_lib_bg_coupons_product;
            }
            if (payCouponVo.isUnavailable()) {
                i2 = R.drawable.payment_lib_bg_coupons_unable;
            }
            this.mNewCouponLayout.setBackgroundResource(i2);
        }

        public final void l(PayCouponVo payCouponVo) {
            if (x.isNotNull(payCouponVo.getUseRuleDesc())) {
                this.mCouponsInfoMsgTv.setText(Html.fromHtml(payCouponVo.getUseRuleDesc()));
            } else {
                this.mCouponsInfoMsgTv.setText(x.getString(R.string.payment_lib_empty));
            }
        }

        public final void m(PayCouponVo payCouponVo) {
            int i2 = payCouponVo.isUnavailable() ? this.f8739h : this.k;
            String cost = payCouponVo.getCost();
            if (payCouponVo.isCashType()) {
                if (x.isNotNull(cost)) {
                    String str = x.getString(R.string.core_lib_rmb_unit) + cost;
                    SpannableString spannableString = new SpannableString(str);
                    int iLastIndexOf = str.lastIndexOf(Consts.DOT);
                    spannableString.setSpan(this.n, 0, 1, 17);
                    if (iLastIndexOf != -1) {
                        spannableString.setSpan(this.l, iLastIndexOf, str.length(), 17);
                    }
                    this.mSaleCostTv.setText(spannableString);
                } else {
                    this.mSaleCostTv.setText(x.getNotNullStr(cost, ""));
                }
            } else if (x.isNotNull(cost)) {
                SpannableString spannableString2 = new SpannableString(cost);
                int iLastIndexOf2 = cost.lastIndexOf(Consts.DOT);
                if (iLastIndexOf2 != -1) {
                    spannableString2.setSpan(this.l, iLastIndexOf2, cost.length(), 17);
                } else {
                    spannableString2.setSpan(this.n, cost.length() - 1, cost.length(), 17);
                }
                this.mSaleCostTv.setText(spannableString2);
            } else {
                this.mSaleCostTv.setText(x.getNotNullStr(cost, ""));
            }
            this.mSaleCostTv.setTextColor(i2);
        }

        public final void n(PayCouponVo payCouponVo) {
            this.mSelectSaleCb.setVisibility(payCouponVo.isUnavailable() ? 8 : 0);
            this.mSelectSaleCb.setTag(Integer.valueOf(getAdapterPosition()));
            this.mSelectSaleCb.setChecked(payCouponVo.isCheck());
        }

        public final void o(PayCouponVo payCouponVo) {
            int i2 = this.f8740i;
            int i3 = R.mipmap.payment_lib_ic_coupons_discount_bg;
            if (payCouponVo.isCashType()) {
                i2 = this.j;
                i3 = R.mipmap.payment_lib_ic_coupons_cash_bg;
            }
            if (payCouponVo.isUnavailable()) {
                i2 = this.f8739h;
                i3 = R.mipmap.payment_lib_ic_coupons_unable_bg;
            }
            int i4 = payCouponVo.isUnavailable() ? R.mipmap.payment_lib_ic_coupons_unable_discount_icon : R.mipmap.payment_lib_ic_coupons_discount_icon;
            if (payCouponVo.isCashType()) {
                i4 = payCouponVo.isUnavailable() ? R.mipmap.payment_lib_ic_coupons_unable_cash_icon : R.mipmap.payment_lib_ic_coupons_cash_icon;
            }
            this.mCouponsBgImg.setBackgroundResource(i3);
            this.mCouponsIconImg.setImageResource(i4);
            this.mSaleCategoryTv.setTextColor(i2);
            this.mSaleCategoryTv.setText(c(payCouponVo.getCouponCategory()));
        }

        public final void p(PayCouponVo payCouponVo) {
            this.mSaleValidDateTv.setText(x.getString(R.string.payment_lib_placeholder_sale_valid_date, z.getTimeYYMMDD(payCouponVo.getValidStartTime()), z.getTimeYYMMDD(payCouponVo.getValidDate())));
            this.mSaleExpireTipTv.setVisibility(payCouponVo.isExpire() ? 0 : 8);
            int i2 = this.f8738g;
            if (payCouponVo.isUnavailable()) {
                i2 = this.f8739h;
            }
            this.mSaleValidDateTv.setTextColor(i2);
        }

        public final void q(PayCouponVo payCouponVo) {
            this.mUnavailableReasonTv.setText(x.appendStringToResId(R.string.payment_lib_placeholder_unavailable_reason, payCouponVo.getUnavailableReason()));
            int i2 = payCouponVo.isUnavailable() ? 0 : 8;
            int i3 = payCouponVo.isUnavailable() ? 8 : 0;
            this.mUnavailableReasonTv.setVisibility(i2);
            this.mCouponsInfoTitleTv.setVisibility(i3);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.o = onClickListener;
        }
    }

    public class CouponVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CouponVh f8742b;

        @UiThread
        public CouponVh_ViewBinding(CouponVh couponVh, View view) {
            this.f8742b = couponVh;
            couponVh.mNewCouponLayout = (ConstraintLayout) d.findRequiredViewAsType(view, R.id.constraint_layout_coupon, "field 'mNewCouponLayout'", ConstraintLayout.class);
            couponVh.mNewCouponView = (NewCouponView) d.findRequiredViewAsType(view, R.id.coupon_view, "field 'mNewCouponView'", NewCouponView.class);
            couponVh.mSaleCostTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_sale_cost, "field 'mSaleCostTv'", TextView.class);
            couponVh.mSaleUseRuleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_sale_use_rule, "field 'mSaleUseRuleTv'", TextView.class);
            couponVh.mSaleCategoryTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_sale_category, "field 'mSaleCategoryTv'", TextView.class);
            couponVh.mSaleExpireTipTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_expire_tip, "field 'mSaleExpireTipTv'", TextView.class);
            couponVh.mSaleValidDateTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_sale_valid_date, "field 'mSaleValidDateTv'", TextView.class);
            couponVh.mUnavailableReasonTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_unavailable_reason, "field 'mUnavailableReasonTv'", TextView.class);
            couponVh.mSelectSaleCb = (CheckBox) d.findRequiredViewAsType(view, R.id.cb_select_sale, "field 'mSelectSaleCb'", CheckBox.class);
            couponVh.mCouponsBgImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_coupons_left_icon_bg, "field 'mCouponsBgImg'", ImageView.class);
            couponVh.mCouponsIconImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_coupons_left_icon, "field 'mCouponsIconImg'", ImageView.class);
            couponVh.mCouponsInfoTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_sale_info, "field 'mCouponsInfoTitleTv'", TextView.class);
            couponVh.mCouponsInfoMsgTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_sale_info_msg, "field 'mCouponsInfoMsgTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            CouponVh couponVh = this.f8742b;
            if (couponVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8742b = null;
            couponVh.mNewCouponLayout = null;
            couponVh.mNewCouponView = null;
            couponVh.mSaleCostTv = null;
            couponVh.mSaleUseRuleTv = null;
            couponVh.mSaleCategoryTv = null;
            couponVh.mSaleExpireTipTv = null;
            couponVh.mSaleValidDateTv = null;
            couponVh.mUnavailableReasonTv = null;
            couponVh.mSelectSaleCb = null;
            couponVh.mCouponsBgImg = null;
            couponVh.mCouponsIconImg = null;
            couponVh.mCouponsInfoTitleTv = null;
            couponVh.mCouponsInfoMsgTv = null;
        }
    }

    public PaymentCouponAdapter(boolean z) {
        this.n = z;
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return !this.f6460b.isEmpty() ? ((PayCouponVo) this.f6460b.get(i2)).getItemType() : super.getItemViewType(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder.getItemViewType() != 34952) {
            CouponVh couponVh = (CouponVh) viewHolder;
            couponVh.setListPosition(i2);
            couponVh.i((PayCouponVo) this.f6460b.get(i2));
            b(couponVh, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return i2 == 34952 ? q(viewGroup) : p(viewGroup);
    }

    public final CouponVh p(ViewGroup viewGroup) {
        View viewI = i(viewGroup, R.layout.payment_lib_item_receiver_sale_layout_new);
        CouponVh couponVh = new CouponVh(viewI);
        couponVh.j(this.n);
        couponVh.setOnClickListener(this.f6461c);
        a(couponVh);
        viewI.setTag(couponVh);
        return couponVh;
    }

    public final BaseRecyclerAdapter.EmptyViewHolder q(ViewGroup viewGroup) {
        setEmptyIconResId(R.mipmap.payment_lib_empty_sale);
        return new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup));
    }
}
