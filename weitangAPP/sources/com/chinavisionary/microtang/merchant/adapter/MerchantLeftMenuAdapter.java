package com.chinavisionary.microtang.merchant.adapter;

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

/* JADX INFO: loaded from: classes.dex */
public class MerchantLeftMenuAdapter extends BaseRecyclerAdapter<RepairLeftVo> {

    public static class FoodMenuVh extends BaseRecyclerViewHolder<RepairLeftVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7821f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7822g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f7823h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f7824i;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public FoodMenuVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.f7821f = this.mTitleTv.getResources().getColor(R.color.colorf4f4f4);
            this.f7822g = this.mTitleTv.getResources().getColor(R.color.color_white);
            this.f7823h = this.mTitleTv.getResources().getColor(R.color.colore757575);
            this.f7824i = this.mTitleTv.getResources().getColor(R.color.color000000);
        }

        public void g(RepairLeftVo repairLeftVo) {
            this.mTitleTv.setText(x.getNotNullStr(repairLeftVo.getTitle(), ""));
            this.mTitleTv.setBackgroundColor(repairLeftVo.isSelect() ? this.f7822g : this.f7821f);
            this.mTitleTv.setTextColor(repairLeftVo.isSelect() ? this.f7824i : this.f7823h);
        }
    }

    public class FoodMenuVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public FoodMenuVh f7825b;

        @UiThread
        public FoodMenuVh_ViewBinding(FoodMenuVh foodMenuVh, View view) {
            this.f7825b = foodMenuVh;
            foodMenuVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            FoodMenuVh foodMenuVh = this.f7825b;
            if (foodMenuVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7825b = null;
            foodMenuVh.mTitleTv = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ((FoodMenuVh) viewHolder).g((RepairLeftVo) this.f6460b.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        View viewI = i(viewGroup, R.layout.item_merchant_left_menu);
        FoodMenuVh foodMenuVh = new FoodMenuVh(viewI);
        a(foodMenuVh);
        viewI.setTag(foodMenuVh);
        return foodMenuVh;
    }
}
