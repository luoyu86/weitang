package com.chinavisionary.microtang.me.adapter;

import android.view.LayoutInflater;
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
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.a.d.x;
import c.e.c.m0.c;
import c.e.e.a.s.e;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class RoomAuthAdapter extends BaseRecyclerAdapter<e> {

    public static class LockVH extends BaseRecyclerViewHolder<e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7539f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7540g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f7541h;

        @BindView(R.id.img_room_low_battery)
        public ImageView mLowBatteryImg;

        @BindView(R.id.tv_lock_name)
        public TextView mRoomBuildLockNameTv;

        @BindView(R.id.tv_lock)
        public TextView mRoomBuildTv;

        @BindView(R.id.tv_room_no)
        public TextView mRoomNoTv;

        @BindView(R.id.tv_tip_not_support_number_pwd)
        public TextView mTipSupportNumberPwdTv;

        public LockVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.f7539f = this.mRoomNoTv.getResources().getColor(R.color.tab_item_select_color);
            this.f7540g = this.mRoomNoTv.getResources().getColor(R.color.colore757575);
        }

        public void g(e eVar) {
            this.mRoomNoTv.setText(eVar.getAssetInstanceName());
            if (x.isNullStr(this.f7541h)) {
                this.mRoomNoTv.setTextColor(eVar.getAssetInstanceKey().equals(c.getInstance().getRoomKey()) ? this.f7539f : this.f7540g);
            } else {
                this.mTipSupportNumberPwdTv.setVisibility(eVar.isSupportNumberPassword() ? 8 : 0);
                this.mRoomNoTv.setTextColor(eVar.getAssetInstanceKey().equals(this.f7541h) ? this.f7539f : this.f7540g);
            }
        }
    }

    public class LockVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LockVH f7542b;

        @UiThread
        public LockVH_ViewBinding(LockVH lockVH, View view) {
            this.f7542b = lockVH;
            lockVH.mRoomNoTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_no, "field 'mRoomNoTv'", TextView.class);
            lockVH.mRoomBuildTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_lock, "field 'mRoomBuildTv'", TextView.class);
            lockVH.mRoomBuildLockNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_lock_name, "field 'mRoomBuildLockNameTv'", TextView.class);
            lockVH.mTipSupportNumberPwdTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_tip_not_support_number_pwd, "field 'mTipSupportNumberPwdTv'", TextView.class);
            lockVH.mLowBatteryImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_room_low_battery, "field 'mLowBatteryImg'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            LockVH lockVH = this.f7542b;
            if (lockVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7542b = null;
            lockVH.mRoomNoTv = null;
            lockVH.mRoomBuildTv = null;
            lockVH.mRoomBuildLockNameTv = null;
            lockVH.mTipSupportNumberPwdTv = null;
            lockVH.mLowBatteryImg = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ((LockVH) viewHolder).g((e) this.f6460b.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_room_auth_layout, viewGroup, false);
        LockVH lockVH = new LockVH(viewInflate);
        viewInflate.setTag(lockVH);
        a(lockVH);
        return lockVH;
    }
}
