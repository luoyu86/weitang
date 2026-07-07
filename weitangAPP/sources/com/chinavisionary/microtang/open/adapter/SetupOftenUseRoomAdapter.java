package com.chinavisionary.microtang.open.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.Unbinder;
import c.e.a.d.x;
import c.e.c.h0.e.b;
import c.e.e.a.s.e;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class SetupOftenUseRoomAdapter extends BaseRecyclerAdapter<e> {
    public b n;

    public class LockVH extends BaseRecyclerViewHolder<e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public b f7978f;

        @BindView(R.id.cb_often)
        public CheckBox mCheckBox;

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

        public void setICheckBoxCallback(b bVar) {
            this.f7978f = bVar;
        }
    }

    public class LockVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LockVH f7979b;

        @UiThread
        public LockVH_ViewBinding(LockVH lockVH, View view) {
            this.f7979b = lockVH;
            lockVH.mRoomNoTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_no, "field 'mRoomNoTv'", TextView.class);
            lockVH.mRoomBuildTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_lock, "field 'mRoomBuildTv'", TextView.class);
            lockVH.mRoomBuildLockNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_lock_name, "field 'mRoomBuildLockNameTv'", TextView.class);
            lockVH.mLowBatteryImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_room_low_battery, "field 'mLowBatteryImg'", ImageView.class);
            lockVH.mDoorLockTypeImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_door_lock_type, "field 'mDoorLockTypeImg'", CoreRoundedImageView.class);
            lockVH.mRoomLocationTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_location, "field 'mRoomLocationTv'", TextView.class);
            lockVH.mCheckBox = (CheckBox) d.findRequiredViewAsType(view, R.id.cb_often, "field 'mCheckBox'", CheckBox.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            LockVH lockVH = this.f7979b;
            if (lockVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7979b = null;
            lockVH.mRoomNoTv = null;
            lockVH.mRoomBuildTv = null;
            lockVH.mRoomBuildLockNameTv = null;
            lockVH.mLowBatteryImg = null;
            lockVH.mDoorLockTypeImg = null;
            lockVH.mRoomLocationTv = null;
            lockVH.mCheckBox = null;
        }
    }

    public class a extends SimpleRecyclerViewHolder<e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f7980f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f7981g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final TextView f7982h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final ImageView f7983i;
        public int j;
        public int k;
        public final CheckBox l;
        public b m;

        public a(View view) {
            super(view);
            this.f7983i = (ImageView) view.findViewById(R.id.img_room_low_battery);
            this.f7980f = (TextView) view.findViewById(R.id.img_door_lock_type);
            this.f7981g = (TextView) view.findViewById(R.id.tv_room_location);
            TextView textView = (TextView) view.findViewById(R.id.tv_room_simple_name);
            this.f7982h = textView;
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.cb_often);
            this.l = checkBox;
            this.j = textView.getResources().getColor(R.color.color4297FC);
            this.k = textView.getResources().getColor(R.color.colorF28565);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: c.e.c.a0.d.a
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    this.f1322a.h(compoundButton, z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void h(CompoundButton compoundButton, boolean z) {
            int adapterPosition = getAdapterPosition();
            if (this.m == null || adapterPosition < 0 || ((e) SetupOftenUseRoomAdapter.this.f6460b.get(adapterPosition)).isSelect() == z) {
                return;
            }
            this.m.onCheckBoxClick(adapterPosition, z);
        }

        public void setICheckBoxCallback(b bVar) {
            this.m = bVar;
        }

        @Override // com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder
        public void setupData(e eVar) {
            this.l.setChecked(eVar.isSelect());
            String assetInstanceName = eVar.getAssetInstanceName();
            boolean z = x.isNotNull(assetInstanceName) && assetInstanceName.contains("防火门");
            try {
                if (x.isNotNull(assetInstanceName) && assetInstanceName.contains("-")) {
                    String[] strArrSplit = assetInstanceName.split("-");
                    if (strArrSplit.length > 0) {
                        assetInstanceName = strArrSplit[strArrSplit.length - 1];
                        this.f7982h.setText(strArrSplit[0]);
                    }
                } else {
                    this.f7982h.setText(assetInstanceName);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (eVar.getLockType().intValue() == 1) {
                this.f7982h.setTextColor(this.k);
                this.f7980f.setBackgroundResource(R.drawable.bg_content_often_use_door_public_lock);
            } else {
                String assetInstanceName2 = eVar.getAssetInstanceName();
                try {
                    if (x.isNotNull(assetInstanceName2)) {
                        if (assetInstanceName2.contains("楼")) {
                            String[] strArrSplit2 = assetInstanceName2.split("楼");
                            if (strArrSplit2.length > 0) {
                                assetInstanceName2 = strArrSplit2[0] + "楼";
                            }
                        } else if (assetInstanceName2.contains("栋")) {
                            String[] strArrSplit3 = assetInstanceName2.split("栋");
                            if (strArrSplit3.length > 0) {
                                assetInstanceName2 = strArrSplit3[0] + "栋";
                            }
                            if (x.isNotNull(assetInstanceName2) && assetInstanceName2.contains("-")) {
                                String[] strArrSplit4 = assetInstanceName2.split("-");
                                if (strArrSplit4.length > 0) {
                                    assetInstanceName2 = strArrSplit4[strArrSplit4.length - 1];
                                }
                            }
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                this.f7982h.setText(assetInstanceName2);
                this.f7982h.setTextColor(this.j);
                this.f7980f.setBackgroundResource(R.drawable.bg_content_often_use_door_room_lock);
            }
            this.f7981g.setText(eVar.getAssetInstanceName());
            try {
                if (x.isNotNull(assetInstanceName) && assetInstanceName.contains("层")) {
                    String[] strArrSplit5 = assetInstanceName.split("层");
                    if (strArrSplit5.length > 0) {
                        assetInstanceName = strArrSplit5[strArrSplit5.length - 1];
                    }
                } else if (x.isNotNull(assetInstanceName) && assetInstanceName.contains("单元")) {
                    String[] strArrSplit6 = assetInstanceName.split("单元");
                    if (strArrSplit6.length > 0) {
                        assetInstanceName = strArrSplit6[strArrSplit6.length - 1];
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (z) {
                assetInstanceName = "防火门" + assetInstanceName;
            }
            this.f7980f.setText(assetInstanceName);
            String assetInstanceName3 = eVar.getAssetInstanceName();
            try {
                String string = this.f7982h.getText().toString();
                if (x.isNotNull(string) && x.isNotNull(assetInstanceName3) && !assetInstanceName3.equals(string) && assetInstanceName3.contains(string)) {
                    assetInstanceName3 = assetInstanceName3.replace(string + "-", "");
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            this.f7981g.setText(assetInstanceName3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ((a) viewHolder).setupData((e) this.f6460b.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_often_use_device, viewGroup, false);
        a aVar = new a(viewInflate);
        aVar.setICheckBoxCallback(this.n);
        viewInflate.setTag(aVar);
        a(aVar);
        return aVar;
    }

    public void setICheckBoxCallback(b bVar) {
        this.n = bVar;
    }
}
