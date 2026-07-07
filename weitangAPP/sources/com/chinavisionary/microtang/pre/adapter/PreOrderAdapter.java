package com.chinavisionary.microtang.pre.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
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
import com.chinavisionary.microtang.pre.vo.ReserveItemVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PreOrderAdapter extends BaseRecyclerAdapter<ReserveItemVo> {

    public static class PreOrderVh extends BaseRecyclerViewHolder<ReserveItemVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f8139f;

        @BindView(R.id.btn_cancel_pay)
        public AppCompatButton mCancelPayBtn;

        @BindView(R.id.tv_month_rent_value)
        public TextView mMonthRentValueTv;

        @BindView(R.id.btn_pay_sign)
        public AppCompatButton mPaySignBtn;

        @BindView(R.id.tv_reserve_no_value)
        public TextView mReserveNoValueTv;

        @BindView(R.id.tv_reserve_price_value)
        public TextView mReservePriceValueTv;

        @BindView(R.id.tv_reserve_sign_date_value)
        public TextView mReserveSignDateValueTv;

        @BindView(R.id.tv_room_name)
        public TextView mRoomNameTv;

        @BindView(R.id.tv_state)
        public TextView mStateTv;

        @BindView(R.id.tv_surplus_time_title)
        public TextView mSurplusTimeTitleTv;

        @BindView(R.id.tv_surplus_time_value)
        public TextView mSurplusTimeTv;

        public PreOrderVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(ReserveItemVo reserveItemVo) {
            int status = reserveItemVo.getStatus();
            boolean z = true;
            boolean z2 = status == 1;
            i(status);
            h(z2);
            this.mStateTv.setText(x.getNotNullStr(reserveItemVo.getStatusName(), ""));
            if (!z2 && status != 5) {
                z = false;
            }
            this.mSurplusTimeTv.setVisibility(z ? 0 : 8);
            this.mSurplusTimeTv.setText(x.getNotNullStr(reserveItemVo.getSurplusTime(), ""));
            this.mRoomNameTv.setText(x.getNotNullStr(reserveItemVo.getAddress(), ""));
            this.mReserveNoValueTv.setText(x.getNotNullStr(reserveItemVo.getReserveCode(), ""));
            this.mMonthRentValueTv.setText(x.appendStringToResId(R.string.placeholder_rmb_china_unit, x.bigDecimalToString(reserveItemVo.getRentFee())));
            this.mReservePriceValueTv.setText(x.appendStringToResId(R.string.placeholder_rmb_china_unit, x.bigDecimalToString(reserveItemVo.getReserveDeposit())));
            this.mReserveSignDateValueTv.setText(z.getTimeYYMMDD(reserveItemVo.getReserveSignDate()));
        }

        public final void h(boolean z) {
            this.mCancelPayBtn.setVisibility(z ? 0 : 8);
            this.mCancelPayBtn.setOnClickListener(null);
            this.mCancelPayBtn.setTag(Integer.valueOf(this.f6468a));
            this.mCancelPayBtn.setOnClickListener(this.f8139f);
        }

        public final void i(int i2) {
            int i3;
            boolean z = true;
            if (i2 == 1) {
                i3 = R.string.title_confirm_pay;
            } else if (i2 == 2) {
                i3 = R.string.title_sign_reserve_contract;
            } else if (i2 == 5 || i2 == 8) {
                i3 = R.string.title_sign_room;
            } else {
                i3 = -1;
                z = false;
            }
            if (i3 != -1) {
                this.mPaySignBtn.setText(i3);
            }
            this.mPaySignBtn.setVisibility(z ? 0 : 8);
            this.mPaySignBtn.setOnClickListener(null);
            this.mPaySignBtn.setTag(Integer.valueOf(this.f6468a));
            this.mPaySignBtn.setOnClickListener(this.f8139f);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f8139f = onClickListener;
        }
    }

    public class PreOrderVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PreOrderVh f8140b;

        @UiThread
        public PreOrderVh_ViewBinding(PreOrderVh preOrderVh, View view) {
            this.f8140b = preOrderVh;
            preOrderVh.mPaySignBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_pay_sign, "field 'mPaySignBtn'", AppCompatButton.class);
            preOrderVh.mCancelPayBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_cancel_pay, "field 'mCancelPayBtn'", AppCompatButton.class);
            preOrderVh.mRoomNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_name, "field 'mRoomNameTv'", TextView.class);
            preOrderVh.mReserveNoValueTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_reserve_no_value, "field 'mReserveNoValueTv'", TextView.class);
            preOrderVh.mMonthRentValueTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_month_rent_value, "field 'mMonthRentValueTv'", TextView.class);
            preOrderVh.mReservePriceValueTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_reserve_price_value, "field 'mReservePriceValueTv'", TextView.class);
            preOrderVh.mReserveSignDateValueTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_reserve_sign_date_value, "field 'mReserveSignDateValueTv'", TextView.class);
            preOrderVh.mStateTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_state, "field 'mStateTv'", TextView.class);
            preOrderVh.mSurplusTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_surplus_time_value, "field 'mSurplusTimeTv'", TextView.class);
            preOrderVh.mSurplusTimeTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_surplus_time_title, "field 'mSurplusTimeTitleTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            PreOrderVh preOrderVh = this.f8140b;
            if (preOrderVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8140b = null;
            preOrderVh.mPaySignBtn = null;
            preOrderVh.mCancelPayBtn = null;
            preOrderVh.mRoomNameTv = null;
            preOrderVh.mReserveNoValueTv = null;
            preOrderVh.mMonthRentValueTv = null;
            preOrderVh.mReservePriceValueTv = null;
            preOrderVh.mReserveSignDateValueTv = null;
            preOrderVh.mStateTv = null;
            preOrderVh.mSurplusTimeTv = null;
            preOrderVh.mSurplusTimeTitleTv = null;
        }
    }

    public PreOrderAdapter() {
        ReserveItemVo reserveItemVo = new ReserveItemVo();
        reserveItemVo.setType(34952);
        addDataToList(reserveItemVo);
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        List<T> list;
        if (i2 == 0 && (list = this.f6460b) != 0 && !list.isEmpty() && this.f6460b.size() == 1 && ((ReserveItemVo) this.f6460b.get(i2)).getType() == 34952) {
            return 34952;
        }
        return super.getItemViewType(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 26214 || itemViewType == 34952 || itemViewType == 39321) {
            return;
        }
        PreOrderVh preOrderVh = (PreOrderVh) viewHolder;
        preOrderVh.setListPosition(i2 - h());
        preOrderVh.g((ReserveItemVo) this.f6460b.get(i2 - h()));
        b(preOrderVh, i2);
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
        View viewI = i(viewGroup, R.layout.item_pre_order_layout);
        PreOrderVh preOrderVh = new PreOrderVh(viewI);
        preOrderVh.setOnClickListener(this.f6461c);
        viewI.setTag(preOrderVh);
        return preOrderVh;
    }
}
