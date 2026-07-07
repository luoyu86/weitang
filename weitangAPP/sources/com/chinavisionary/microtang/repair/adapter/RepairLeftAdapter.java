package com.chinavisionary.microtang.repair.adapter;

import android.view.View;
import android.view.ViewGroup;
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
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.repair.vo.RepairLeftVo;

/* JADX INFO: loaded from: classes2.dex */
public class RepairLeftAdapter extends BaseRecyclerAdapter<RepairLeftVo> {

    public static class RepairLeftVh extends BaseRecyclerViewHolder<RepairLeftVo> {

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public RepairLeftVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(RepairLeftVo repairLeftVo) {
            this.mTitleTv.setText(x.getNotNullStr(repairLeftVo.getTitle(), ""));
            int color = this.mTitleTv.getResources().getColor(R.color.color_white);
            int color2 = this.mTitleTv.getResources().getColor(R.color.tab_item_select_color);
            TextView textView = this.mTitleTv;
            if (repairLeftVo.isSelect()) {
                color = color2;
            }
            textView.setBackgroundColor(color);
        }
    }

    public class RepairLeftVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RepairLeftVh f8222b;

        @UiThread
        public RepairLeftVh_ViewBinding(RepairLeftVh repairLeftVh, View view) {
            this.f8222b = repairLeftVh;
            repairLeftVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            RepairLeftVh repairLeftVh = this.f8222b;
            if (repairLeftVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8222b = null;
            repairLeftVh.mTitleTv = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        RepairLeftVh repairLeftVh = (RepairLeftVh) viewHolder;
        repairLeftVh.g((RepairLeftVo) this.f6460b.get(i2));
        b(repairLeftVh, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        View viewI = i(viewGroup, R.layout.item_repair_left);
        RepairLeftVh repairLeftVh = new RepairLeftVh(viewI);
        viewI.setTag(repairLeftVh);
        return repairLeftVh;
    }
}
