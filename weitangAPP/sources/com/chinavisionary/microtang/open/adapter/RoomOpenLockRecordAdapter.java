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
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.open.bo.RoomOpenLockRecordVo;

/* JADX INFO: loaded from: classes.dex */
public class RoomOpenLockRecordAdapter extends BaseRecyclerAdapter<RoomOpenLockRecordVo> {

    public static class RoomOpenLockRecordVH extends BaseRecyclerViewHolder<RoomOpenLockRecordVo> {

        @BindView(R.id.tv_address)
        public TextView mAddressTv;

        @BindView(R.id.tv_device_id)
        public TextView mDeviceIdTv;

        @BindView(R.id.tv_device_supplier_name)
        public TextView mDeviceSupplierNameTv;

        public RoomOpenLockRecordVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(RoomOpenLockRecordVo roomOpenLockRecordVo) {
            this.mAddressTv.setText(x.appendStringToResId(R.string.placeholder_room_address, roomOpenLockRecordVo.getLocation()));
            this.mDeviceSupplierNameTv.setText(x.appendStringToResId(R.string.placeholder_device_supplier, roomOpenLockRecordVo.getSupplierName()));
            this.mDeviceIdTv.setText(x.appendStringToResId(R.string.placeholder_device_id, roomOpenLockRecordVo.getDeviceid()));
        }
    }

    public class RoomOpenLockRecordVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RoomOpenLockRecordVH f7976b;

        @UiThread
        public RoomOpenLockRecordVH_ViewBinding(RoomOpenLockRecordVH roomOpenLockRecordVH, View view) {
            this.f7976b = roomOpenLockRecordVH;
            roomOpenLockRecordVH.mAddressTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_address, "field 'mAddressTv'", TextView.class);
            roomOpenLockRecordVH.mDeviceSupplierNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_device_supplier_name, "field 'mDeviceSupplierNameTv'", TextView.class);
            roomOpenLockRecordVH.mDeviceIdTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_device_id, "field 'mDeviceIdTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            RoomOpenLockRecordVH roomOpenLockRecordVH = this.f7976b;
            if (roomOpenLockRecordVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7976b = null;
            roomOpenLockRecordVH.mAddressTv = null;
            roomOpenLockRecordVH.mDeviceSupplierNameTv = null;
            roomOpenLockRecordVH.mDeviceIdTv = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder.getItemViewType() != 39321) {
            RoomOpenLockRecordVH roomOpenLockRecordVH = (RoomOpenLockRecordVH) viewHolder;
            roomOpenLockRecordVH.g((RoomOpenLockRecordVo) this.f6460b.get(i2));
            b(roomOpenLockRecordVH, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return i2 != 39321 ? new RoomOpenLockRecordVH(i(viewGroup, R.layout.item_room_open_lock_record)) : new BaseRecyclerAdapter.FooterViewHolder(f(viewGroup));
    }
}
