package com.chinavisionary.microtang.open.adapter;

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
public class SwitchRootAdapter extends BaseRecyclerAdapter<e> {
    public String n;

    public static class LockVH extends BaseRecyclerViewHolder<e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7984f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7985g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f7986h;

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
            this.f7984f = this.mRoomNoTv.getResources().getColor(R.color.tab_item_select_color);
            this.f7985g = this.mRoomNoTv.getResources().getColor(R.color.colore757575);
        }

        public void g(e eVar) {
            this.mRoomNoTv.setText(eVar.getAssetInstanceName());
            if (x.isNullStr(this.f7986h)) {
                this.mRoomNoTv.setTextColor(eVar.getAssetInstanceKey().equals(c.getInstance().getRoomKey()) ? this.f7984f : this.f7985g);
            } else {
                this.mTipSupportNumberPwdTv.setVisibility(eVar.isSupportNumberPassword() ? 8 : 0);
                this.mRoomNoTv.setTextColor(eVar.getAssetInstanceKey().equals(this.f7986h) ? this.f7984f : this.f7985g);
            }
        }

        public void setSelectRoomKey(String str) {
            this.f7986h = str;
        }
    }

    public class LockVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LockVH f7987b;

        @UiThread
        public LockVH_ViewBinding(LockVH lockVH, View view) {
            this.f7987b = lockVH;
            lockVH.mRoomNoTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_no, "field 'mRoomNoTv'", TextView.class);
            lockVH.mRoomBuildTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_lock, "field 'mRoomBuildTv'", TextView.class);
            lockVH.mRoomBuildLockNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_lock_name, "field 'mRoomBuildLockNameTv'", TextView.class);
            lockVH.mTipSupportNumberPwdTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_tip_not_support_number_pwd, "field 'mTipSupportNumberPwdTv'", TextView.class);
            lockVH.mLowBatteryImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_room_low_battery, "field 'mLowBatteryImg'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            LockVH lockVH = this.f7987b;
            if (lockVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7987b = null;
            lockVH.mRoomNoTv = null;
            lockVH.mRoomBuildTv = null;
            lockVH.mRoomBuildLockNameTv = null;
            lockVH.mTipSupportNumberPwdTv = null;
            lockVH.mLowBatteryImg = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        LockVH lockVH = (LockVH) viewHolder;
        lockVH.setSelectRoomKey(this.n);
        lockVH.g((e) this.f6460b.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_switch_room_layout, viewGroup, false);
        LockVH lockVH = new LockVH(viewInflate);
        viewInflate.setTag(lockVH);
        a(lockVH);
        return lockVH;
    }

    public void setSelectRoomKey(String str) {
        this.n = str;
    }
}
