package com.chinavisionary.microtang.repair.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.a.d.x;
import c.k.b.d.a;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.repair.vo.RepairOrderDetailsVo;
import com.lzy.ninegrid.NineGridView;

/* JADX INFO: loaded from: classes2.dex */
public class RepairOrderDetailsAdapter extends LeftTitleToRightArrowAdapter {

    public static class RepairOrderDetailsVh extends BaseRecyclerViewHolder<LeftTitleToRightArrowVo> {

        @BindView(R.id.nine_grid_view)
        public NineGridView mNineGridView;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public RepairOrderDetailsVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void setData(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
            RepairOrderDetailsVo repairOrderDetailsVo = (RepairOrderDetailsVo) leftTitleToRightArrowVo.getExtObj();
            this.mTitleTv.setText(x.getNotNullStr(repairOrderDetailsVo.getTitle(), ""));
            this.mNineGridView.setAdapter(new a(this.mNineGridView.getContext(), repairOrderDetailsVo.getImageInfo()));
        }
    }

    public class RepairOrderDetailsVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RepairOrderDetailsVh f8226b;

        @UiThread
        public RepairOrderDetailsVh_ViewBinding(RepairOrderDetailsVh repairOrderDetailsVh, View view) {
            this.f8226b = repairOrderDetailsVh;
            repairOrderDetailsVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
            repairOrderDetailsVh.mNineGridView = (NineGridView) d.findRequiredViewAsType(view, R.id.nine_grid_view, "field 'mNineGridView'", NineGridView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            RepairOrderDetailsVh repairOrderDetailsVh = this.f8226b;
            if (repairOrderDetailsVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8226b = null;
            repairOrderDetailsVh.mTitleTv = null;
            repairOrderDetailsVh.mNineGridView = null;
        }
    }

    @Override // com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter
    public void q(RecyclerView.ViewHolder viewHolder, int i2) {
        ((RepairOrderDetailsVh) viewHolder).setData((LeftTitleToRightArrowVo) this.f6460b.get(i2));
    }

    @Override // com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter
    public RecyclerView.ViewHolder r(ViewGroup viewGroup, int i2) {
        return new RepairOrderDetailsVh(i(viewGroup, R.layout.item_repair_details_layout));
    }
}
