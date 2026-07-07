package com.chinavisionary.microtang.doorpwd.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import c.e.a.d.x;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class DoorPasswordAdapter extends BaseRecyclerAdapter<c.e.c.q.d.a> {

    public static class a extends SimpleRecyclerViewHolder<c.e.c.q.d.a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f7185f;

        public a(View view) {
            super(view);
            this.f7185f = (TextView) view.findViewById(R.id.tv_pwd_door_info);
        }

        @Override // com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder
        public void setupData(c.e.c.q.d.a aVar) {
            this.f7185f.setVisibility(x.isNotNull(aVar.getTitle()) ? 0 : 8);
            this.f7185f.setText(aVar.getTitle());
        }
    }

    public static class b extends SimpleRecyclerViewHolder<c.e.c.q.d.a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public TextView f7186f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public TextView f7187g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public TextView f7188h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public TextView f7189i;
        public TextView j;

        public b(View view) {
            super(view);
            this.f7186f = (TextView) view.findViewById(R.id.tv_room_name);
            this.f7187g = (TextView) view.findViewById(R.id.tv_tip_msg);
            this.f7188h = (TextView) view.findViewById(R.id.tv_setup_pwd);
            this.f7189i = (TextView) view.findViewById(R.id.tv_tip_pwd_msg);
            this.j = (TextView) view.findViewById(R.id.tv_tip_not_support_number_pwd);
        }

        @Override // com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder
        public void setupData(c.e.c.q.d.a aVar) {
            this.f7186f.setOnClickListener(this.f6469b);
            this.f7188h.setOnClickListener(this.f6469b);
            this.f7188h.setTag(Integer.valueOf(getAdapterPosition()));
            c.e.c.q.d.b itemVo = aVar.getItemVo();
            if (itemVo != null) {
                this.f7188h.setBackgroundResource(itemVo.isEnableSetupPwd() ? R.drawable.bg_btn_radius_6 : R.drawable.bg_alert_grad_6);
                this.j.setVisibility(itemVo.isEnableSetupPwd() ? 8 : 0);
                this.f7186f.setText(itemVo.getRoomName());
                this.f7187g.setText(itemVo.getTipMsg());
                this.f7189i.setText(itemVo.getPwdSetupTipMsg());
            }
        }
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return ((c.e.c.q.d.a) this.f6460b.get(i2)).getItemType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder.getItemViewType() == 1) {
            ((a) viewHolder).setupData((c.e.c.q.d.a) this.f6460b.get(i2));
        } else {
            ((b) viewHolder).setupData((c.e.c.q.d.a) this.f6460b.get(i2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return i2 == 1 ? q(viewGroup) : p(viewGroup);
    }

    public final b p(ViewGroup viewGroup) {
        b bVar = new b(i(viewGroup, R.layout.item_door_password_operation_layout));
        bVar.setViewOnClickListener(this.f6461c);
        return bVar;
    }

    public final a q(ViewGroup viewGroup) {
        return new a(i(viewGroup, R.layout.item_door_password_info_layout));
    }
}
