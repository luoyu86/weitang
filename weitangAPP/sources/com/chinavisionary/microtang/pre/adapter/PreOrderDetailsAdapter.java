package com.chinavisionary.microtang.pre.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.a.d.x;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.pre.vo.PreOrderDetailsVo;

/* JADX INFO: loaded from: classes.dex */
public class PreOrderDetailsAdapter extends LeftTitleToRightArrowAdapter {

    public static class PreOrderDetailsVh extends BaseRecyclerViewHolder<LeftTitleToRightArrowVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f8141f;

        @BindView(R.id.tv_room_month_rent)
        public TextView mMonthRentTv;

        @BindView(R.id.tv_room_no_value)
        public TextView mRoomNoTv;

        @BindView(R.id.tv_room_state_value)
        public TextView mRoomStateTv;

        @BindView(R.id.btn_sign_state)
        public AppCompatButton mSignStateBtn;

        public PreOrderDetailsVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void setData(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
            PreOrderDetailsVo preOrderDetailsVo = (PreOrderDetailsVo) leftTitleToRightArrowVo.getExtObj();
            this.mMonthRentTv.setText(x.getNotNullStr(preOrderDetailsVo.getMonthRent(), ""));
            this.mRoomNoTv.setText(x.getNotNullStr(preOrderDetailsVo.getRoomNo(), ""));
            this.mRoomStateTv.setText(x.getNotNullStr(preOrderDetailsVo.getStateName(), ""));
            this.mSignStateBtn.setVisibility(preOrderDetailsVo.getPayState() == 5 ? 0 : 8);
            boolean z = preOrderDetailsVo.getRoomState() == 6;
            this.mSignStateBtn.setText(z ? R.string.title_sign_room : R.string.title_unsign);
            this.mSignStateBtn.setBackgroundResource(z ? R.drawable.bg_btn_store_6_radius : R.drawable.bg_btn_fill_grad_6_radius);
            AppCompatButton appCompatButton = this.mSignStateBtn;
            appCompatButton.setTextColor(z ? appCompatButton.getResources().getColor(R.color.tab_item_select_color) : appCompatButton.getResources().getColor(R.color.colore757575));
            this.mSignStateBtn.setOnClickListener(null);
            this.mSignStateBtn.setOnClickListener(this.f8141f);
            this.mSignStateBtn.setTag(leftTitleToRightArrowVo);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f8141f = onClickListener;
        }
    }

    public class PreOrderDetailsVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PreOrderDetailsVh f8142b;

        @UiThread
        public PreOrderDetailsVh_ViewBinding(PreOrderDetailsVh preOrderDetailsVh, View view) {
            this.f8142b = preOrderDetailsVh;
            preOrderDetailsVh.mRoomStateTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_state_value, "field 'mRoomStateTv'", TextView.class);
            preOrderDetailsVh.mMonthRentTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_month_rent, "field 'mMonthRentTv'", TextView.class);
            preOrderDetailsVh.mRoomNoTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_no_value, "field 'mRoomNoTv'", TextView.class);
            preOrderDetailsVh.mSignStateBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_sign_state, "field 'mSignStateBtn'", AppCompatButton.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            PreOrderDetailsVh preOrderDetailsVh = this.f8142b;
            if (preOrderDetailsVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8142b = null;
            preOrderDetailsVh.mRoomStateTv = null;
            preOrderDetailsVh.mMonthRentTv = null;
            preOrderDetailsVh.mRoomNoTv = null;
            preOrderDetailsVh.mSignStateBtn = null;
        }
    }

    @Override // com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter
    public void q(RecyclerView.ViewHolder viewHolder, int i2) {
        ((PreOrderDetailsVh) viewHolder).setData((LeftTitleToRightArrowVo) this.f6460b.get(i2));
    }

    @Override // com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter
    public RecyclerView.ViewHolder r(ViewGroup viewGroup, int i2) {
        PreOrderDetailsVh preOrderDetailsVh = new PreOrderDetailsVh(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pre_order_details, viewGroup, false));
        preOrderDetailsVh.setOnClickListener(this.f6461c);
        return preOrderDetailsVh;
    }
}
