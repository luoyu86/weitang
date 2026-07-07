package com.chinavisionary.microtang.map.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.map.vo.MapItemVo;

/* JADX INFO: loaded from: classes.dex */
public class MapAdapter extends BaseRecyclerAdapter<MapItemVo> {

    public static class a extends BaseRecyclerViewHolder<MapItemVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public TextView f7511f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public View f7512g;

        public a(View view) {
            super(view);
            this.f7511f = (TextView) view.findViewById(R.id.tv_map_name);
            this.f7512g = view.findViewById(R.id.view_split_line);
        }

        public void g(MapItemVo mapItemVo) {
            this.f7511f.setText(c(mapItemVo.getName()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ((a) viewHolder).g((MapItemVo) this.f6460b.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        a aVar = new a(i(viewGroup, R.layout.item_map_layout));
        a(aVar);
        return aVar;
    }
}
