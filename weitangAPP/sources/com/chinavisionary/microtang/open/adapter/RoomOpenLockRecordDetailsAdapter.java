package com.chinavisionary.microtang.open.adapter;

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
import com.chinavisionary.microtang.open.bo.RoomOpenLockRecordDetailsVo;

/* JADX INFO: loaded from: classes.dex */
public class RoomOpenLockRecordDetailsAdapter extends BaseRecyclerAdapter<RoomOpenLockRecordDetailsVo> {

    public static class OpenLockRecordDetailsVH extends BaseRecyclerViewHolder<RoomOpenLockRecordDetailsVo> {

        @BindView(R.id.tv_app_name)
        public TextView mAppNameTv;

        @BindView(R.id.tv_app_version)
        public TextView mAppVersionTv;

        @BindView(R.id.tv_name)
        public TextView mNameTv;

        @BindView(R.id.tv_open_door_consume_time)
        public TextView mOpenDoorConsumeTimeTv;

        @BindView(R.id.tv_open_door_state)
        public TextView mOpenDoorStateTv;

        @BindView(R.id.tv_open_door_time)
        public TextView mOpenDoorTimeTv;

        @BindView(R.id.tv_phone_name)
        public TextView mPhoneNameTv;

        @BindView(R.id.tv_phone)
        public TextView mPhoneTv;

        @BindView(R.id.tv_phone_version)
        public TextView mPhoneVersionTv;

        public OpenLockRecordDetailsVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(RoomOpenLockRecordDetailsVo roomOpenLockRecordDetailsVo) {
            this.mNameTv.setText(x.getNotNullStr(roomOpenLockRecordDetailsVo.getName(), ""));
            this.mPhoneTv.setText(x.getNotNullStr(roomOpenLockRecordDetailsVo.getPhone(), ""));
            this.mPhoneNameTv.setText(x.getNotNullStr(roomOpenLockRecordDetailsVo.getPhoneType(), ""));
            this.mPhoneVersionTv.setText(x.getNotNullStr(roomOpenLockRecordDetailsVo.getPhoneSystemVersion(), ""));
            this.mAppNameTv.setText(x.getNotNullStr(roomOpenLockRecordDetailsVo.getAppName(), ""));
            this.mAppVersionTv.setText(x.getNotNullStr(roomOpenLockRecordDetailsVo.getAppVersion(), ""));
            this.mOpenDoorStateTv.setText(x.getNotNullStr(roomOpenLockRecordDetailsVo.getOpenDoorResult(), ""));
            TextView textView = this.mOpenDoorConsumeTimeTv;
            textView.setText((roomOpenLockRecordDetailsVo.getUseTime() / 1000.0f) + "秒");
            this.mOpenDoorTimeTv.setText(z.getTime(Long.valueOf(roomOpenLockRecordDetailsVo.getOpenDoorTime())));
        }
    }

    public class OpenLockRecordDetailsVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public OpenLockRecordDetailsVH f7977b;

        @UiThread
        public OpenLockRecordDetailsVH_ViewBinding(OpenLockRecordDetailsVH openLockRecordDetailsVH, View view) {
            this.f7977b = openLockRecordDetailsVH;
            openLockRecordDetailsVH.mNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_name, "field 'mNameTv'", TextView.class);
            openLockRecordDetailsVH.mPhoneTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_phone, "field 'mPhoneTv'", TextView.class);
            openLockRecordDetailsVH.mPhoneNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_phone_name, "field 'mPhoneNameTv'", TextView.class);
            openLockRecordDetailsVH.mPhoneVersionTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_phone_version, "field 'mPhoneVersionTv'", TextView.class);
            openLockRecordDetailsVH.mAppNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_app_name, "field 'mAppNameTv'", TextView.class);
            openLockRecordDetailsVH.mAppVersionTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_app_version, "field 'mAppVersionTv'", TextView.class);
            openLockRecordDetailsVH.mOpenDoorTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_open_door_time, "field 'mOpenDoorTimeTv'", TextView.class);
            openLockRecordDetailsVH.mOpenDoorConsumeTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_open_door_consume_time, "field 'mOpenDoorConsumeTimeTv'", TextView.class);
            openLockRecordDetailsVH.mOpenDoorStateTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_open_door_state, "field 'mOpenDoorStateTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            OpenLockRecordDetailsVH openLockRecordDetailsVH = this.f7977b;
            if (openLockRecordDetailsVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7977b = null;
            openLockRecordDetailsVH.mNameTv = null;
            openLockRecordDetailsVH.mPhoneTv = null;
            openLockRecordDetailsVH.mPhoneNameTv = null;
            openLockRecordDetailsVH.mPhoneVersionTv = null;
            openLockRecordDetailsVH.mAppNameTv = null;
            openLockRecordDetailsVH.mAppVersionTv = null;
            openLockRecordDetailsVH.mOpenDoorTimeTv = null;
            openLockRecordDetailsVH.mOpenDoorConsumeTimeTv = null;
            openLockRecordDetailsVH.mOpenDoorStateTv = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder.getItemViewType() != 39321) {
            ((OpenLockRecordDetailsVH) viewHolder).g((RoomOpenLockRecordDetailsVo) this.f6460b.get(i2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return i2 != 39321 ? new OpenLockRecordDetailsVH(i(viewGroup, R.layout.item_lock_record_details)) : new BaseRecyclerAdapter.FooterViewHolder(f(viewGroup));
    }
}
