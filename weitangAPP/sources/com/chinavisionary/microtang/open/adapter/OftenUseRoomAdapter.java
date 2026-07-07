package com.chinavisionary.microtang.open.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import c.e.a.d.o;
import c.e.a.d.x;
import c.e.e.a.s.e;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class OftenUseRoomAdapter extends BaseRecyclerAdapter<e> {
    public boolean n = false;

    public static class a extends SimpleRecyclerViewHolder<e> {
        public a(@NonNull View view) {
            super(view);
        }

        @Override // com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder
        public void setupData(e eVar) {
        }
    }

    public static class b extends SimpleRecyclerViewHolder<e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f7972f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f7973g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final TextView f7974h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final TextView f7975i;
        public final ImageView j;
        public int k;
        public int l;
        public boolean m;

        public b(View view) {
            super(view);
            this.m = false;
            this.j = (ImageView) view.findViewById(R.id.img_room_low_battery);
            this.f7972f = (TextView) view.findViewById(R.id.img_door_lock_type);
            this.f7973g = (TextView) view.findViewById(R.id.tv_room_location);
            TextView textView = (TextView) view.findViewById(R.id.tv_room_simple_name);
            this.f7974h = textView;
            this.f7975i = (TextView) view.findViewById(R.id.tv_switch_model);
            this.k = textView.getResources().getColor(R.color.color4297FC);
            this.l = textView.getResources().getColor(R.color.colorF28565);
        }

        public final void g(e eVar) {
            boolean z = (eVar.getSocLevel() == null || eVar.getSocLevel().intValue() == 0) ? false : true;
            this.j.setVisibility(z ? 0 : 8);
            if (z) {
                int i2 = R.mipmap.ic_low_battery_red;
                int iIntValue = eVar.getSocLevel().intValue();
                if (iIntValue == 2) {
                    i2 = R.mipmap.ic_medium_battery;
                } else if (iIntValue == 3) {
                    i2 = R.mipmap.ic_high_battery;
                }
                this.j.setImageResource(i2);
            }
        }

        public void setHasBackground(boolean z) {
            this.m = z;
        }

        @Override // com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder
        public void setupData(e eVar) {
            this.f7975i.setVisibility(8);
            String assetInstanceName = eVar.getAssetInstanceName();
            boolean z = x.isNotNull(assetInstanceName) && assetInstanceName.contains("防火门");
            try {
                if (x.isNotNull(assetInstanceName) && assetInstanceName.contains("-")) {
                    String[] strArrSplit = assetInstanceName.split("-");
                    if (strArrSplit.length > 0) {
                        assetInstanceName = strArrSplit[strArrSplit.length - 1];
                        this.f7974h.setText(strArrSplit[0]);
                    }
                } else {
                    this.f7974h.setText(assetInstanceName);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (eVar.getLockType().intValue() == 1) {
                if (this.m) {
                    this.itemView.setBackgroundResource(R.drawable.bg_often_use_door_public_lock);
                }
                this.f7974h.setTextColor(this.l);
                this.f7972f.setBackgroundResource(R.drawable.bg_content_often_use_door_public_lock);
                if (eVar.hasSupportedOpening()) {
                    this.f7975i.setVisibility(0);
                    this.f7975i.setOnClickListener(this.f6469b);
                    this.f7975i.setTag(Integer.valueOf(getAdapterPosition()));
                    this.f7975i.setText(eVar.getOpenDoorModel() == 0 ? R.string.title_ble_open_door : R.string.title_open_door_network);
                }
            } else {
                if (this.m) {
                    this.itemView.setBackgroundResource(R.drawable.bg_often_use_door_room_lock);
                }
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
                this.f7974h.setText(assetInstanceName2);
                this.f7974h.setTextColor(this.k);
                this.f7972f.setBackgroundResource(R.drawable.bg_content_often_use_door_room_lock);
            }
            this.f7973g.setText(eVar.getAssetInstanceName());
            g(eVar);
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
            this.f7972f.setText(assetInstanceName);
            String assetInstanceName3 = eVar.getAssetInstanceName();
            try {
                String string = this.f7974h.getText().toString();
                if (x.isNotNull(string) && x.isNotNull(assetInstanceName3) && !assetInstanceName3.equals(string) && assetInstanceName3.contains(string)) {
                    assetInstanceName3 = assetInstanceName3.replace(string + "-", "");
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            this.f7973g.setText(assetInstanceName3);
        }
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return o.isNotEmpty(this.f6460b) ? ((e) this.f6460b.get(i2)).getItemType() : super.getItemViewType(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder.getItemViewType() == 8) {
            return;
        }
        ((b) viewHolder).setupData((e) this.f6460b.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 8) {
            BaseRecyclerViewHolder aVar = new a(i(viewGroup, R.layout.item_often_use_empty));
            a(aVar);
            return aVar;
        }
        b bVar = new b(i(viewGroup, R.layout.item_often_use_door_lock));
        bVar.setViewOnClickListener(this.f6461c);
        bVar.setHasBackground(this.n);
        a(bVar);
        return bVar;
    }

    public void setHasBackground(boolean z) {
        this.n = z;
    }
}
