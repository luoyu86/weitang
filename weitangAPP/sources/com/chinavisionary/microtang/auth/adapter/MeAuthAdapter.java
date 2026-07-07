package com.chinavisionary.microtang.auth.adapter;

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
import com.chinavisionary.microtang.auth.vo.MeAuthVo;

/* JADX INFO: loaded from: classes.dex */
public class MeAuthAdapter extends BaseRecyclerAdapter<MeAuthVo> {

    public static class MeAuthVh extends BaseRecyclerViewHolder<MeAuthVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f6820f;

        @BindView(R.id.btn_agree)
        public Button mAgreeBtn;

        @BindView(R.id.tv_apply_open_address_value)
        public TextView mApplyOpenAddressTv;

        @BindView(R.id.tv_apply_open_time_value)
        public TextView mApplyOpenTimeTv;

        @BindView(R.id.tv_apply_reason_value)
        public TextView mApplyReasonTv;

        @BindView(R.id.tv_apply_user_value)
        public TextView mApplyUserTv;

        @BindView(R.id.btn_reject)
        public Button mRejectBtn;

        @BindView(R.id.tv_state_name)
        public TextView mStateTv;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public MeAuthVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(MeAuthVo meAuthVo) {
            int adapterPosition = getAdapterPosition();
            f(this.mAgreeBtn, this.f6820f);
            f(this.mRejectBtn, this.f6820f);
            this.mAgreeBtn.setTag(Integer.valueOf(adapterPosition));
            this.mRejectBtn.setTag(Integer.valueOf(adapterPosition));
            h(meAuthVo.getAuthDoorApprovalStatus());
            this.mApplyUserTv.setText(x.getNotNullStr(meAuthVo.getApplyUserName(), ""));
            this.mStateTv.setText(x.getNotNullStr(meAuthVo.getAuthDoorApprovalStatusName(), ""));
            this.mTitleTv.setText(x.getNotNullStr(meAuthVo.getOrderTitle(), ""));
            this.mApplyReasonTv.setText(x.getNotNullStr(meAuthVo.getApplyReason(), ""));
            this.mApplyOpenAddressTv.setText(x.getNotNullStr(meAuthVo.getAddress(), ""));
            this.mApplyOpenTimeTv.setText(z.getTime(Long.valueOf(meAuthVo.getApplyOpenDoorStart())) + "-" + z.getTime(Long.valueOf(meAuthVo.getApplyOpenDoorEnd())));
        }

        public final void h(int i2) {
            int i3 = i2 == 1 ? 0 : 8;
            this.mAgreeBtn.setVisibility(i3);
            this.mRejectBtn.setVisibility(i3);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f6820f = onClickListener;
        }
    }

    public class MeAuthVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MeAuthVh f6821b;

        @UiThread
        public MeAuthVh_ViewBinding(MeAuthVh meAuthVh, View view) {
            this.f6821b = meAuthVh;
            meAuthVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
            meAuthVh.mStateTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_state_name, "field 'mStateTv'", TextView.class);
            meAuthVh.mAgreeBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_agree, "field 'mAgreeBtn'", Button.class);
            meAuthVh.mRejectBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_reject, "field 'mRejectBtn'", Button.class);
            meAuthVh.mApplyOpenTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_apply_open_time_value, "field 'mApplyOpenTimeTv'", TextView.class);
            meAuthVh.mApplyOpenAddressTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_apply_open_address_value, "field 'mApplyOpenAddressTv'", TextView.class);
            meAuthVh.mApplyReasonTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_apply_reason_value, "field 'mApplyReasonTv'", TextView.class);
            meAuthVh.mApplyUserTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_apply_user_value, "field 'mApplyUserTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            MeAuthVh meAuthVh = this.f6821b;
            if (meAuthVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f6821b = null;
            meAuthVh.mTitleTv = null;
            meAuthVh.mStateTv = null;
            meAuthVh.mAgreeBtn = null;
            meAuthVh.mRejectBtn = null;
            meAuthVh.mApplyOpenTimeTv = null;
            meAuthVh.mApplyOpenAddressTv = null;
            meAuthVh.mApplyReasonTv = null;
            meAuthVh.mApplyUserTv = null;
        }
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (i2 == 0 && 1 == this.f6460b.size() && x.isNullStr(((MeAuthVo) this.f6460b.get(i2)).getAuthDoorKey()) && x.isNullStr(((MeAuthVo) this.f6460b.get(i2)).getOrderKey())) {
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
        MeAuthVh meAuthVh = (MeAuthVh) viewHolder;
        meAuthVh.setListPosition(i2);
        meAuthVh.setOnClickListener(this.f6461c);
        meAuthVh.g((MeAuthVo) this.f6460b.get(i2));
        b(meAuthVh, i2);
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
        View viewI = i(viewGroup, R.layout.item_me_auth_layout);
        MeAuthVh meAuthVh = new MeAuthVh(viewI);
        viewI.setTag(meAuthVh);
        return meAuthVh;
    }
}
