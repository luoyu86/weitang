package com.chinavisionary.microtang.open.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.Unbinder;
import c.e.e.a.s.e;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.open.adapter.OftenUseRoomAdapter;

/* JADX INFO: loaded from: classes.dex */
public class LockAdapter extends BaseRecyclerAdapter<e> {

    public static class LockVH extends BaseRecyclerViewHolder<e> {

        @BindView(R.id.img_door_lock_type)
        public CoreRoundedImageView mDoorLockTypeImg;

        @BindView(R.id.img_room_low_battery)
        public ImageView mLowBatteryImg;

        @BindView(R.id.tv_lock_name)
        public TextView mRoomBuildLockNameTv;

        @BindView(R.id.tv_lock)
        public TextView mRoomBuildTv;

        @BindView(R.id.tv_room_location)
        public TextView mRoomLocationTv;

        @BindView(R.id.tv_room_no)
        public TextView mRoomNoTv;
    }

    public class LockVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LockVH f7971b;

        @UiThread
        public LockVH_ViewBinding(LockVH lockVH, View view) {
            this.f7971b = lockVH;
            lockVH.mRoomNoTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_no, "field 'mRoomNoTv'", TextView.class);
            lockVH.mRoomBuildTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_lock, "field 'mRoomBuildTv'", TextView.class);
            lockVH.mRoomBuildLockNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_lock_name, "field 'mRoomBuildLockNameTv'", TextView.class);
            lockVH.mLowBatteryImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_room_low_battery, "field 'mLowBatteryImg'", ImageView.class);
            lockVH.mDoorLockTypeImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_door_lock_type, "field 'mDoorLockTypeImg'", CoreRoundedImageView.class);
            lockVH.mRoomLocationTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_location, "field 'mRoomLocationTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            LockVH lockVH = this.f7971b;
            if (lockVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7971b = null;
            lockVH.mRoomNoTv = null;
            lockVH.mRoomBuildTv = null;
            lockVH.mRoomBuildLockNameTv = null;
            lockVH.mLowBatteryImg = null;
            lockVH.mDoorLockTypeImg = null;
            lockVH.mRoomLocationTv = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ((OftenUseRoomAdapter.b) viewHolder).setupData((e) this.f6460b.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        OftenUseRoomAdapter.b bVar = new OftenUseRoomAdapter.b(i(viewGroup, R.layout.item_lock_layout));
        bVar.setViewOnClickListener(this.f6461c);
        a(bVar);
        return bVar;
    }
}
