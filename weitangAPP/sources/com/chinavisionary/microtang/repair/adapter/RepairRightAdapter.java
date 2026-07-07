package com.chinavisionary.microtang.repair.adapter;

import android.view.LayoutInflater;
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
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.repair.vo.RepairRightVo;
import com.chinavisionary.microtang.view.FlowLayout;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RepairRightAdapter extends BaseRecyclerAdapter<RepairRightVo> {

    public static class RepairRightVh extends BaseRecyclerViewHolder<RepairRightVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f8227f;

        @BindView(R.id.flow_layout_product)
        public FlowLayout mFlowLayout;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public RepairRightVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(RepairRightVo repairRightVo) {
            this.mTitleTv.setText(x.getNotNullStr(repairRightVo.getTitle(), ""));
            h(repairRightVo.getProductList());
        }

        public final void h(List<RepairRightVo.RepairProduct> list) {
            this.mFlowLayout.removeAllViews();
            if (list == null || list.isEmpty()) {
                return;
            }
            for (RepairRightVo.RepairProduct repairProduct : list) {
                View viewInflate = LayoutInflater.from(this.mFlowLayout.getContext()).inflate(R.layout.item_repair_product, (ViewGroup) this.mFlowLayout, false);
                viewInflate.setTag(repairProduct);
                viewInflate.setOnClickListener(this.f8227f);
                TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_device_name);
                ResourceVo resourceVo = repairProduct.getResourceVo();
                CoreRoundedImageView coreRoundedImageView = (CoreRoundedImageView) viewInflate.findViewById(R.id.img_product_cover);
                if (resourceVo != null) {
                    coreRoundedImageView.loadImageToUrl(resourceVo.getUrl());
                }
                textView2.setVisibility(0);
                textView.setVisibility(8);
                coreRoundedImageView.setVisibility(8);
                textView2.setText(x.getNotNullStr(repairProduct.getTitle(), ""));
                textView.setText(x.getNotNullStr(repairProduct.getTitle(), ""));
                this.mFlowLayout.addView(viewInflate);
            }
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f8227f = onClickListener;
        }
    }

    public class RepairRightVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RepairRightVh f8228b;

        @UiThread
        public RepairRightVh_ViewBinding(RepairRightVh repairRightVh, View view) {
            this.f8228b = repairRightVh;
            repairRightVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
            repairRightVh.mFlowLayout = (FlowLayout) d.findRequiredViewAsType(view, R.id.flow_layout_product, "field 'mFlowLayout'", FlowLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            RepairRightVh repairRightVh = this.f8228b;
            if (repairRightVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8228b = null;
            repairRightVh.mTitleTv = null;
            repairRightVh.mFlowLayout = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        RepairRightVh repairRightVh = (RepairRightVh) viewHolder;
        repairRightVh.g((RepairRightVo) this.f6460b.get(i2));
        b(repairRightVh, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        View viewI = i(viewGroup, R.layout.item_repair_right_layout);
        RepairRightVh repairRightVh = new RepairRightVh(viewI);
        repairRightVh.setOnClickListener(this.f6461c);
        viewI.setTag(repairRightVh);
        return repairRightVh;
    }
}
