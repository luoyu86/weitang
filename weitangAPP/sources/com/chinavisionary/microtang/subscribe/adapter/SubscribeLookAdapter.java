package com.chinavisionary.microtang.subscribe.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.chinavisionary.microtang.subscribe.vo.SubscribeLookVo;

/* JADX INFO: loaded from: classes2.dex */
public class SubscribeLookAdapter extends BaseRecyclerAdapter<SubscribeLookVo> {

    public static class SubscribeLookVH extends BaseRecyclerViewHolder<SubscribeLookVo> {

        @BindView(R.id.tv_address)
        public TextView mAddressTv;

        @BindView(R.id.btn_cancel)
        public Button mCancelBtn;

        @BindView(R.id.tv_order_value)
        public TextView mOrderNoTv;

        @BindView(R.id.tv_state_name)
        public TextView mStateNameTv;

        @BindView(R.id.tv_subscribe_time)
        public TextView mTimeTv;

        public SubscribeLookVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(SubscribeLookVo subscribeLookVo) {
            this.mCancelBtn.setTag(subscribeLookVo.getKey());
            this.mCancelBtn.setVisibility(subscribeLookVo.getState() == 1 ? 0 : 8);
            this.mStateNameTv.setText(x.getNotNullStr(subscribeLookVo.getStateName(), ""));
            this.mOrderNoTv.setText(x.getNotNullStr(subscribeLookVo.getOrderNo(), ""));
            this.mAddressTv.setText(x.getNotNullStr(subscribeLookVo.getAddress(), ""));
            this.mTimeTv.setText(z.getTime(subscribeLookVo.getReserveTime()));
        }
    }

    public class SubscribeLookVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SubscribeLookVH f8621b;

        @UiThread
        public SubscribeLookVH_ViewBinding(SubscribeLookVH subscribeLookVH, View view) {
            this.f8621b = subscribeLookVH;
            subscribeLookVH.mStateNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_state_name, "field 'mStateNameTv'", TextView.class);
            subscribeLookVH.mOrderNoTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_order_value, "field 'mOrderNoTv'", TextView.class);
            subscribeLookVH.mAddressTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_address, "field 'mAddressTv'", TextView.class);
            subscribeLookVH.mTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_subscribe_time, "field 'mTimeTv'", TextView.class);
            subscribeLookVH.mCancelBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_cancel, "field 'mCancelBtn'", Button.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            SubscribeLookVH subscribeLookVH = this.f8621b;
            if (subscribeLookVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8621b = null;
            subscribeLookVH.mStateNameTv = null;
            subscribeLookVH.mOrderNoTv = null;
            subscribeLookVH.mAddressTv = null;
            subscribeLookVH.mTimeTv = null;
            subscribeLookVH.mCancelBtn = null;
        }
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f6460b.size() + e();
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (1 == this.f6460b.size() && i2 == 0 && ((SubscribeLookVo) this.f6460b.get(i2)).getAddress() == null && x.isNullStr(((SubscribeLookVo) this.f6460b.get(i2)).getKey()) && ((SubscribeLookVo) this.f6460b.get(i2)).getReserveTime() == null) {
            return 34952;
        }
        return super.getItemViewType(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 34952 || itemViewType == 39321) {
            return;
        }
        SubscribeLookVH subscribeLookVH = (SubscribeLookVH) viewHolder;
        subscribeLookVH.g((SubscribeLookVo) this.f6460b.get(i2));
        b(subscribeLookVH, i2);
        subscribeLookVH.mCancelBtn.setOnClickListener(null);
        View.OnClickListener onClickListener = this.f6461c;
        if (onClickListener != null) {
            subscribeLookVH.mCancelBtn.setOnClickListener(onClickListener);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 34952) {
            return new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup));
        }
        if (i2 == 39321) {
            return new BaseRecyclerAdapter.FooterViewHolder(f(viewGroup));
        }
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_subscribe_look, viewGroup, false);
        SubscribeLookVH subscribeLookVH = new SubscribeLookVH(viewInflate);
        viewInflate.setTag(subscribeLookVH);
        return subscribeLookVH;
    }
}
