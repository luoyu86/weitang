package com.chinavisionary.microtang.service.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.service.vo.CustomerRecordVo;

/* JADX INFO: loaded from: classes2.dex */
public class CustomerServerAdapter extends BaseRecyclerAdapter<CustomerRecordVo> {

    public static class CustomerServerVH extends BaseRecyclerViewHolder<CustomerRecordVo> {
        public CustomerServerVH(View view) {
            super(view);
        }

        public void g(CustomerRecordVo customerRecordVo) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 26214 || itemViewType == 39321) {
            return;
        }
        ((CustomerServerVH) viewHolder).g((CustomerRecordVo) this.f6460b.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 26214) {
            return new BaseRecyclerAdapter.RecyclerHeadViewHodler(this.f6466h);
        }
        if (i2 == 39321) {
            return new BaseRecyclerAdapter.FooterViewHolder(f(viewGroup));
        }
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_server_head, viewGroup, false);
        CustomerServerVH customerServerVH = new CustomerServerVH(viewInflate);
        viewInflate.setTag(customerServerVH);
        return customerServerVH;
    }
}
