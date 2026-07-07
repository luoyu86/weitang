package com.chinavisionary.microtang.room.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import c.e.c.h0.e.b;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.room.vo.PreLookRoomItemVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PreLookRoomTimeAdapter extends BaseRecyclerAdapter<PreLookRoomItemVo> {
    public b n;

    public class a extends SimpleRecyclerViewHolder<PreLookRoomItemVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CheckBox f8297f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public CheckBox f8298g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List<PreLookRoomItemVo> f8299h;

        public a(View view) {
            super(view);
            this.f8297f = (CheckBox) view.findViewById(R.id.cb_week_value);
            this.f8298g = (CheckBox) view.findViewById(R.id.cb_date);
            this.f8297f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: c.e.c.h0.c.a
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    this.f1493a.h(compoundButton, z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void h(CompoundButton compoundButton, boolean z) {
            int adapterPosition = getAdapterPosition();
            if (adapterPosition < 0 || PreLookRoomTimeAdapter.this.n == null || this.f8299h.get(adapterPosition).isHasSelect() == z) {
                return;
            }
            PreLookRoomTimeAdapter.this.n.onCheckBoxClick(adapterPosition, z);
        }

        public void setList(List<PreLookRoomItemVo> list) {
            this.f8299h = list;
        }

        @Override // com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder
        public void setupData(PreLookRoomItemVo preLookRoomItemVo) {
            this.f8297f.setText(preLookRoomItemVo.getWeek());
            this.f8298g.setText(preLookRoomItemVo.getDate());
            this.f8297f.setChecked(preLookRoomItemVo.isHasSelect());
            this.f8298g.setChecked(preLookRoomItemVo.isHasSelect());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        if (this.f6460b.size() > i2) {
            ((a) viewHolder).setupData((PreLookRoomItemVo) this.f6460b.get(i2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        a aVar = new a(i(viewGroup, R.layout.item_pre_look_room_time));
        aVar.setList(this.f6460b);
        return aVar;
    }

    public void setCallback(b bVar) {
        this.n = bVar;
    }
}
