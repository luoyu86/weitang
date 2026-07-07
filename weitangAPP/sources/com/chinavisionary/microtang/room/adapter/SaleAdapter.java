package com.chinavisionary.microtang.room.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
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
import c.e.a.d.z;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.room.vo.SaleReceiverVo;

/* JADX INFO: loaded from: classes2.dex */
public class SaleAdapter extends BaseRecyclerAdapter<SaleReceiverVo> {
    public boolean n;

    public static class SaleVh extends BaseRecyclerViewHolder<SaleReceiverVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f8305f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public View.OnClickListener f8306g;

        @BindView(R.id.tv_sale_category)
        public TextView mSaleCategoryTv;

        @BindView(R.id.tv_sale_cost)
        public TextView mSaleCostTv;

        @BindView(R.id.tv_expire_tip)
        public TextView mSaleExpireTipTv;

        @BindView(R.id.tv_sale_use_rule)
        public TextView mSaleUseRuleTv;

        @BindView(R.id.tv_sale_valid_date)
        public TextView mSaleValidDateTv;

        @BindView(R.id.cb_select_sale)
        public CheckBox mSelectSaleCb;

        @BindView(R.id.tv_unavailable_reason)
        public TextView mUnavailableReasonTv;

        public SaleVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(SaleReceiverVo saleReceiverVo) {
            this.mUnavailableReasonTv.setText(x.appendStringToResId(R.string.placeholder_unavailable_reason, saleReceiverVo.getUnavailableReason()));
            this.mSaleCostTv.setText(saleReceiverVo.getCost());
            this.mSaleValidDateTv.setText(x.appendStringToResId(R.string.placeholder_sale_valid_date, z.getTimeYYMMDD(saleReceiverVo.getValidDate())));
            this.mSaleUseRuleTv.setText(c(saleReceiverVo.getUseRule()));
            this.mSaleCategoryTv.setText(c(saleReceiverVo.getCouponCategory()));
            this.mSaleExpireTipTv.setVisibility(saleReceiverVo.isExpire() ? 0 : 8);
            this.mUnavailableReasonTv.setVisibility(saleReceiverVo.isUnavailable() ? 0 : 8);
            this.mSelectSaleCb.setVisibility(this.f8305f ? 0 : 8);
            this.mSelectSaleCb.setChecked(saleReceiverVo.isCheck());
            this.mSelectSaleCb.setTag(Integer.valueOf(getAdapterPosition()));
            this.mSelectSaleCb.setOnClickListener(null);
            this.mSelectSaleCb.setOnClickListener(this.f8306g);
        }

        public void h(boolean z) {
            this.f8305f = z;
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f8306g = onClickListener;
        }
    }

    public class SaleVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SaleVh f8307b;

        @UiThread
        public SaleVh_ViewBinding(SaleVh saleVh, View view) {
            this.f8307b = saleVh;
            saleVh.mSaleCostTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_sale_cost, "field 'mSaleCostTv'", TextView.class);
            saleVh.mSaleUseRuleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_sale_use_rule, "field 'mSaleUseRuleTv'", TextView.class);
            saleVh.mSaleCategoryTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_sale_category, "field 'mSaleCategoryTv'", TextView.class);
            saleVh.mSaleExpireTipTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_expire_tip, "field 'mSaleExpireTipTv'", TextView.class);
            saleVh.mSaleValidDateTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_sale_valid_date, "field 'mSaleValidDateTv'", TextView.class);
            saleVh.mUnavailableReasonTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_unavailable_reason, "field 'mUnavailableReasonTv'", TextView.class);
            saleVh.mSelectSaleCb = (CheckBox) d.findRequiredViewAsType(view, R.id.cb_select_sale, "field 'mSelectSaleCb'", CheckBox.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            SaleVh saleVh = this.f8307b;
            if (saleVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8307b = null;
            saleVh.mSaleCostTv = null;
            saleVh.mSaleUseRuleTv = null;
            saleVh.mSaleCategoryTv = null;
            saleVh.mSaleExpireTipTv = null;
            saleVh.mSaleValidDateTv = null;
            saleVh.mUnavailableReasonTv = null;
            saleVh.mSelectSaleCb = null;
        }
    }

    public SaleAdapter(boolean z) {
        this.n = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        SaleVh saleVh = (SaleVh) viewHolder;
        saleVh.setListPosition(i2);
        saleVh.g((SaleReceiverVo) this.f6460b.get(i2));
        b(saleVh, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_receiver_sale_layout, viewGroup, false);
        SaleVh saleVh = new SaleVh(viewInflate);
        saleVh.h(this.n);
        saleVh.setOnClickListener(this.f6461c);
        viewInflate.setTag(saleVh);
        return saleVh;
    }
}
