package com.chinavisionary.microtang.hydropower.adapter;

import android.view.LayoutInflater;
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
import c.e.a.d.z;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.hydropower.vo.PayRecordVo;

/* JADX INFO: loaded from: classes.dex */
public class PayHydropowerAdapter extends BaseRecyclerAdapter<PayRecordVo> {

    public static class PayRecordVH extends BaseRecyclerViewHolder<PayRecordVo> {

        @BindView(R.id.tv_create_time_value)
        public TextView mCreateTimeTv;

        @BindView(R.id.tv_order_value)
        public TextView mOrderNoTv;

        @BindView(R.id.tv_recharge_price)
        public TextView mRechargePriceTv;

        @BindView(R.id.tv_state_name)
        public TextView mStateNameTv;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public PayRecordVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(PayRecordVo payRecordVo) {
            this.mTitleTv.setText(x.getNotNullStr(payRecordVo.getTypeName(), ""));
            this.mRechargePriceTv.setText(x.appendStringToResId(R.string.rmb_placeholder, x.bigDecimalToString(payRecordVo.getAmount())));
            this.mOrderNoTv.setText(x.getNotNullStr(payRecordVo.getTradeNo(), ""));
            this.mCreateTimeTv.setText(z.getTime(Long.valueOf(payRecordVo.getCreateTime())));
        }
    }

    public class PayRecordVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PayRecordVH f7233b;

        @UiThread
        public PayRecordVH_ViewBinding(PayRecordVH payRecordVH, View view) {
            this.f7233b = payRecordVH;
            payRecordVH.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
            payRecordVH.mStateNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_state_name, "field 'mStateNameTv'", TextView.class);
            payRecordVH.mCreateTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_create_time_value, "field 'mCreateTimeTv'", TextView.class);
            payRecordVH.mRechargePriceTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_recharge_price, "field 'mRechargePriceTv'", TextView.class);
            payRecordVH.mOrderNoTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_order_value, "field 'mOrderNoTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            PayRecordVH payRecordVH = this.f7233b;
            if (payRecordVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7233b = null;
            payRecordVH.mTitleTv = null;
            payRecordVH.mStateNameTv = null;
            payRecordVH.mCreateTimeTv = null;
            payRecordVH.mRechargePriceTv = null;
            payRecordVH.mOrderNoTv = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 26214 || itemViewType == 34952 || itemViewType == 39321) {
            return;
        }
        PayRecordVH payRecordVH = (PayRecordVH) viewHolder;
        payRecordVH.g((PayRecordVo) this.f6460b.get(i2 - h()));
        b(payRecordVH, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 26214) {
            return new BaseRecyclerAdapter.RecyclerHeadViewHodler(this.f6466h);
        }
        if (i2 == 34952) {
            return new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup));
        }
        if (i2 == 39321) {
            return new BaseRecyclerAdapter.FooterViewHolder(f(viewGroup));
        }
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pay_record_layout, viewGroup, false);
        PayRecordVH payRecordVH = new PayRecordVH(viewInflate);
        viewInflate.setTag(payRecordVH);
        return payRecordVH;
    }
}
