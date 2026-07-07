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
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.a.d.x;
import c.e.e.a.s.e;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class HorLockAdapter extends BaseRecyclerAdapter<e> {

    public static class HorLockVH extends BaseRecyclerViewHolder<e> {

        @BindView(R.id.img_room_low_battery)
        public ImageView mLowBatteryImg;

        @BindView(R.id.tv_room_title)
        public TextView mRoomNameTv;

        @BindView(R.id.tv_room_no_value)
        public TextView mRoomNoTv;

        @BindView(R.id.view_open_room)
        public View mRootView;

        public HorLockVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(e eVar) {
            i();
            String assetInstanceName = eVar.getAssetInstanceName();
            boolean z = x.isNotNull(assetInstanceName) && assetInstanceName.contains("防火门");
            if (x.isNotNull(assetInstanceName) && assetInstanceName.contains("-")) {
                String[] strArrSplit = assetInstanceName.split("-");
                if (strArrSplit.length > 0) {
                    assetInstanceName = strArrSplit[strArrSplit.length - 1];
                }
            }
            if (x.isNotNull(assetInstanceName) && assetInstanceName.contains("层")) {
                String[] strArrSplit2 = assetInstanceName.split("层");
                if (strArrSplit2.length > 0) {
                    assetInstanceName = strArrSplit2[strArrSplit2.length - 1];
                }
            } else if (x.isNotNull(assetInstanceName) && assetInstanceName.contains("单元")) {
                String[] strArrSplit3 = assetInstanceName.split("单元");
                if (strArrSplit3.length > 0) {
                    assetInstanceName = strArrSplit3[strArrSplit3.length - 1];
                }
            }
            if (eVar.getLockType() == null || eVar.getLockType().intValue() != 1) {
                this.mRoomNoTv.setBackgroundResource(R.drawable.bg_room_fill_radius);
            } else {
                this.mRoomNoTv.setBackgroundResource(R.drawable.bg_public_room_fill_radius);
            }
            if (z) {
                assetInstanceName = "防火门" + assetInstanceName;
            }
            this.mRoomNoTv.setText(assetInstanceName);
            this.mRoomNameTv.setText(eVar.getAssetInstanceName());
            h(eVar);
        }

        public final void h(e eVar) {
            boolean z = (eVar.getSocLevel() == null || eVar.getSocLevel().intValue() == 0) ? false : true;
            this.mLowBatteryImg.setVisibility(z ? 0 : 8);
            if (z) {
                int i2 = R.mipmap.ic_low_battery_red;
                int iIntValue = eVar.getSocLevel().intValue();
                if (iIntValue == 2) {
                    i2 = R.mipmap.ic_medium_battery;
                } else if (iIntValue == 3) {
                    i2 = R.mipmap.ic_high_battery;
                }
                this.mLowBatteryImg.setImageResource(i2);
            }
        }

        public final void i() {
            int dimensionPixelSize = this.mRoomNameTv.getResources().getDimensionPixelSize(R.dimen.dp_12);
            if (getLayoutPosition() > 0) {
                dimensionPixelSize = 0;
            }
            ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) this.mRootView.getLayoutParams())).leftMargin = dimensionPixelSize;
        }
    }

    public class HorLockVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public HorLockVH f7963b;

        @UiThread
        public HorLockVH_ViewBinding(HorLockVH horLockVH, View view) {
            this.f7963b = horLockVH;
            horLockVH.mRoomNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_title, "field 'mRoomNameTv'", TextView.class);
            horLockVH.mRoomNoTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_no_value, "field 'mRoomNoTv'", TextView.class);
            horLockVH.mLowBatteryImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_room_low_battery, "field 'mLowBatteryImg'", ImageView.class);
            horLockVH.mRootView = d.findRequiredView(view, R.id.view_open_room, "field 'mRootView'");
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            HorLockVH horLockVH = this.f7963b;
            if (horLockVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7963b = null;
            horLockVH.mRoomNameTv = null;
            horLockVH.mRoomNoTv = null;
            horLockVH.mLowBatteryImg = null;
            horLockVH.mRootView = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        HorLockVH horLockVH = (HorLockVH) viewHolder;
        horLockVH.g((e) this.f6460b.get(i2));
        b(horLockVH, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        View viewI = i(viewGroup, R.layout.item_open_room);
        HorLockVH horLockVH = new HorLockVH(viewI);
        viewI.setTag(horLockVH);
        return horLockVH;
    }
}
