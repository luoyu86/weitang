package com.chinavisionary.microtang.room.adapter;

import android.annotation.SuppressLint;
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
import c.e.a.d.o;
import c.e.a.d.x;
import c.e.c.m0.l;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.room.vo.MoreRentRoomVo;

/* JADX INFO: loaded from: classes2.dex */
public class MoreRentRoomAdapter extends BaseRecyclerAdapter<MoreRentRoomVo> {

    public static class MoreRentRoomVH extends BaseRecyclerViewHolder<MoreRentRoomVo> {

        @BindView(R.id.tv_cat_room_source_details)
        public TextView mCatRoomSourceDetailsTv;

        @BindView(R.id.tv_room_comment)
        public TextView mRoomCommentTv;

        @BindView(R.id.tv_room_floor_orientation)
        public TextView mRoomFloorOrientationTv;

        @BindView(R.id.tv_room_no)
        public TextView mRoomNoTv;

        @BindView(R.id.tv_room_pre)
        public TextView mRoomPreTv;

        @BindView(R.id.tv_room_rent_price)
        public TextView mRoomRentPriceTv;

        @BindView(R.id.tv_room_sing_or_pre)
        public TextView mRoomSingOrPreTv;

        @BindView(R.id.tv_room_sing_state)
        public TextView mRoomSingStateTv;

        @BindView(R.id.tv_room_rent_src_price)
        public TextView mRoomSrcPriceTv;

        public MoreRentRoomVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
            TextView textView = this.mRoomSrcPriceTv;
            textView.setPaintFlags(textView.getPaintFlags() | 16);
        }

        public void g(MoreRentRoomVo moreRentRoomVo) {
            h(moreRentRoomVo);
            i(moreRentRoomVo);
            j(moreRentRoomVo);
            f(this.mCatRoomSourceDetailsTv, this.f6469b);
            this.mCatRoomSourceDetailsTv.setTag(Integer.valueOf(getAdapterPosition()));
        }

        @SuppressLint({"SetTextI18n"})
        public final void h(MoreRentRoomVo moreRentRoomVo) {
            this.mRoomNoTv.setText(x.getNotNullStr(moreRentRoomVo.getHouseName(), ""));
        }

        public final void i(MoreRentRoomVo moreRentRoomVo) {
            l.setupRentPrice(c(moreRentRoomVo.getMinimumMonthlyRent()), this.mRoomRentPriceTv);
            l.setupPriceUnit(c(moreRentRoomVo.getUnderlineRentFee()), this.mRoomSrcPriceTv);
        }

        public final void j(MoreRentRoomVo moreRentRoomVo) {
            int status = moreRentRoomVo.getStatus();
            boolean z = true;
            boolean z2 = status == 6;
            boolean z3 = status == 1 || status == 5 || status == 7 || z2;
            this.mRoomPreTv.setTag(moreRentRoomVo);
            this.mRoomPreTv.setVisibility(z2 ? 0 : 8);
            this.mRoomPreTv.setOnClickListener(this.f6469b);
            this.mRoomSingOrPreTv.setVisibility(z3 ? 0 : 8);
            if (status != 1 && !z2 && status != 7) {
                z = false;
            }
            this.mRoomSingOrPreTv.setBackgroundResource(z ? R.drawable.bg_item_rent_room_btn : R.drawable.bg_item_rent_room_pre_btn);
            this.mRoomSingOrPreTv.setOnClickListener(this.f6469b);
            this.mRoomSingOrPreTv.setTag(moreRentRoomVo);
            this.mRoomSingOrPreTv.setText(z ? x.getString(R.string.title_sign) : x.getString(R.string.title_pre_order));
            this.mRoomSingStateTv.setVisibility(z3 ? 8 : 0);
            this.mRoomSingStateTv.setText(x.getNotNullStr(moreRentRoomVo.getHouseStatusName(), ""));
        }
    }

    public class MoreRentRoomVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MoreRentRoomVH f8296b;

        @UiThread
        public MoreRentRoomVH_ViewBinding(MoreRentRoomVH moreRentRoomVH, View view) {
            this.f8296b = moreRentRoomVH;
            moreRentRoomVH.mRoomNoTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_no, "field 'mRoomNoTv'", TextView.class);
            moreRentRoomVH.mRoomFloorOrientationTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_floor_orientation, "field 'mRoomFloorOrientationTv'", TextView.class);
            moreRentRoomVH.mRoomCommentTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_comment, "field 'mRoomCommentTv'", TextView.class);
            moreRentRoomVH.mRoomRentPriceTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_rent_price, "field 'mRoomRentPriceTv'", TextView.class);
            moreRentRoomVH.mRoomSingOrPreTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_sing_or_pre, "field 'mRoomSingOrPreTv'", TextView.class);
            moreRentRoomVH.mRoomPreTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_pre, "field 'mRoomPreTv'", TextView.class);
            moreRentRoomVH.mRoomSingStateTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_sing_state, "field 'mRoomSingStateTv'", TextView.class);
            moreRentRoomVH.mCatRoomSourceDetailsTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_cat_room_source_details, "field 'mCatRoomSourceDetailsTv'", TextView.class);
            moreRentRoomVH.mRoomSrcPriceTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_rent_src_price, "field 'mRoomSrcPriceTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            MoreRentRoomVH moreRentRoomVH = this.f8296b;
            if (moreRentRoomVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8296b = null;
            moreRentRoomVH.mRoomNoTv = null;
            moreRentRoomVH.mRoomFloorOrientationTv = null;
            moreRentRoomVH.mRoomCommentTv = null;
            moreRentRoomVH.mRoomRentPriceTv = null;
            moreRentRoomVH.mRoomSingOrPreTv = null;
            moreRentRoomVH.mRoomPreTv = null;
            moreRentRoomVH.mRoomSingStateTv = null;
            moreRentRoomVH.mCatRoomSourceDetailsTv = null;
            moreRentRoomVH.mRoomSrcPriceTv = null;
        }
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (o.isNotEmpty(this.f6460b) && i2 == 0 && this.f6460b.size() == 1) {
            MoreRentRoomVo moreRentRoomVo = (MoreRentRoomVo) this.f6460b.get(i2);
            if (x.isNullStr(moreRentRoomVo.getAssetInstanceKey()) && x.isNullStr(moreRentRoomVo.getGoodsKey()) && x.isNullStr(moreRentRoomVo.getHouseName())) {
                return 34952;
            }
        }
        return super.getItemViewType(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 26214 || itemViewType == 34952 || itemViewType == 39321) {
            return;
        }
        MoreRentRoomVH moreRentRoomVH = (MoreRentRoomVH) viewHolder;
        moreRentRoomVH.g((MoreRentRoomVo) this.f6460b.get(i2 - h()));
        b(moreRentRoomVH, i2);
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
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rent_room_layout, viewGroup, false);
        MoreRentRoomVH moreRentRoomVH = new MoreRentRoomVH(viewInflate);
        moreRentRoomVH.setViewOnClickListener(this.f6461c);
        viewInflate.setTag(moreRentRoomVH);
        return moreRentRoomVH;
    }
}
