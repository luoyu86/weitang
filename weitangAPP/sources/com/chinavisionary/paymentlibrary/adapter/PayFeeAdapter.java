package com.chinavisionary.paymentlibrary.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.a.d.x;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.paymentlibrary.R;
import com.chinavisionary.paymentlibrary.vo.PayCostTypeVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class PayFeeAdapter extends BaseRecyclerAdapter<PayCostTypeVo> {

    public static class PayFeeVh extends BaseRecyclerViewHolder<PayCostTypeVo> {

        @BindView(2919)
        public View mSplitLine;

        @BindView(2899)
        public TextView mTitlePayCostNameTv;

        @BindView(2900)
        public TextView mTitlePayCostPriceTv;

        @BindView(2901)
        public TextView mTitlePayCostSrcTv;

        public PayFeeVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.mTitlePayCostSrcTv.getPaint().setFlags(16);
        }

        public void g(PayCostTypeVo payCostTypeVo) {
            this.mTitlePayCostNameTv.setText(c(payCostTypeVo.getName()));
            BigDecimal value = payCostTypeVo.getValue();
            this.mTitlePayCostPriceTv.setText(x.bigDecimalToPlainStringAddUnit(value));
            boolean zIsBigDecimal = x.isBigDecimal(payCostTypeVo.getCouponValue());
            this.mSplitLine.setVisibility(getAdapterPosition() == 0 ? 0 : 8);
            this.mTitlePayCostSrcTv.setVisibility(zIsBigDecimal ? 0 : 8);
            if (!zIsBigDecimal || value == null) {
                return;
            }
            BigDecimal bigDecimalMin = payCostTypeVo.getCouponValue().min(payCostTypeVo.getValue());
            this.mTitlePayCostPriceTv.setText(x.getString(R.string.payment_lib_rmb_china_price_unit) + x.bigDecimalSubtract(value, bigDecimalMin));
            this.mTitlePayCostSrcTv.setText(x.bigDecimalToPlainStringAddUnit(value));
        }
    }

    public class PayFeeVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PayFeeVh f8736b;

        @UiThread
        public PayFeeVh_ViewBinding(PayFeeVh payFeeVh, View view) {
            this.f8736b = payFeeVh;
            payFeeVh.mTitlePayCostNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_pay_cost_name, "field 'mTitlePayCostNameTv'", TextView.class);
            payFeeVh.mTitlePayCostPriceTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_pay_cost_price, "field 'mTitlePayCostPriceTv'", TextView.class);
            payFeeVh.mTitlePayCostSrcTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_pay_cost_price_src, "field 'mTitlePayCostSrcTv'", TextView.class);
            payFeeVh.mSplitLine = d.findRequiredView(view, R.id.view_split_line, "field 'mSplitLine'");
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            PayFeeVh payFeeVh = this.f8736b;
            if (payFeeVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8736b = null;
            payFeeVh.mTitlePayCostNameTv = null;
            payFeeVh.mTitlePayCostPriceTv = null;
            payFeeVh.mTitlePayCostSrcTv = null;
            payFeeVh.mSplitLine = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ((PayFeeVh) viewHolder).g((PayCostTypeVo) this.f6460b.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return p(viewGroup);
    }

    public final PayFeeVh p(ViewGroup viewGroup) {
        return new PayFeeVh(i(viewGroup, R.layout.payment_lib_item_pay_fee));
    }
}
