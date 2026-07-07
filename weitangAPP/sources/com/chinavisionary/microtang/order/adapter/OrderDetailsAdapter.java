package com.chinavisionary.microtang.order.adapter;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.a.d.x;
import c.e.a.d.z;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.view.CustomTextView;

/* JADX INFO: loaded from: classes.dex */
public class OrderDetailsAdapter extends LeftTitleToRightArrowAdapter {

    public static class OrderDetailsVh extends BaseRecyclerViewHolder<LeftTitleToRightArrowVo> {

        @BindView(R.id.tv_left_title)
        public CustomTextView mLeftTv;

        @BindView(R.id.tv_right_title)
        public CustomTextView mRightTv;

        @BindView(R.id.view_split_line)
        public View mSplitLineView;

        public OrderDetailsVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public final void g(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
            int leftFontColor = leftTitleToRightArrowVo.getLeftFontColor();
            this.mLeftTv.setVisibility(leftTitleToRightArrowVo.isShowRadio() ? 8 : 0);
            this.mLeftTv.setText(x.getNotNullStr(leftTitleToRightArrowVo.isTitle() ? leftTitleToRightArrowVo.getTitle() : leftTitleToRightArrowVo.getLeft(), ""));
            CustomTextView customTextView = this.mLeftTv;
            Resources resources = this.mRightTv.getResources();
            if (leftFontColor <= 0) {
                leftFontColor = R.color.color383838;
            }
            customTextView.setTextColor(resources.getColor(leftFontColor));
        }

        public final void h(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
            this.mRightTv.setVisibility(leftTitleToRightArrowVo.isEdit() ? 8 : 0);
            boolean zIsPrice = leftTitleToRightArrowVo.isPrice();
            String string = leftTitleToRightArrowVo.isShowRmbUnit() ? x.getString(R.string.core_lib_rmb_unit) : "";
            String string2 = zIsPrice ? x.getString(R.string.rmb_china_unit) : "";
            this.mRightTv.setText(string + x.getNotNullStr(leftTitleToRightArrowVo.getRight(), "") + string2);
            int i2 = zIsPrice ? R.color.image_color_red : R.color.color383838;
            int rightFontColor = leftTitleToRightArrowVo.getRightFontColor();
            boolean zIsTime = leftTitleToRightArrowVo.isTime();
            String right = leftTitleToRightArrowVo.getRight();
            if (zIsTime && x.isNumeric(right)) {
                this.mRightTv.setText(z.getTime(Long.valueOf(Long.parseLong(right)), leftTitleToRightArrowVo.getSimpleDateFormat()));
            }
            CustomTextView customTextView = this.mRightTv;
            Resources resources = customTextView.getResources();
            if (rightFontColor > 0) {
                i2 = rightFontColor;
            }
            customTextView.setTextColor(resources.getColor(i2));
        }

        public final void i(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
            this.mSplitLineView.setVisibility(leftTitleToRightArrowVo.isShowSplitLine() ? 0 : 8);
            this.mSplitLineView.getLayoutParams().height = leftTitleToRightArrowVo.getSplitLineHeight();
        }

        public void setData(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
            g(leftTitleToRightArrowVo);
            h(leftTitleToRightArrowVo);
            i(leftTitleToRightArrowVo);
        }
    }

    public class OrderDetailsVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public OrderDetailsVh f8062b;

        @UiThread
        public OrderDetailsVh_ViewBinding(OrderDetailsVh orderDetailsVh, View view) {
            this.f8062b = orderDetailsVh;
            orderDetailsVh.mLeftTv = (CustomTextView) d.findRequiredViewAsType(view, R.id.tv_left_title, "field 'mLeftTv'", CustomTextView.class);
            orderDetailsVh.mRightTv = (CustomTextView) d.findRequiredViewAsType(view, R.id.tv_right_title, "field 'mRightTv'", CustomTextView.class);
            orderDetailsVh.mSplitLineView = d.findRequiredView(view, R.id.view_split_line, "field 'mSplitLineView'");
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            OrderDetailsVh orderDetailsVh = this.f8062b;
            if (orderDetailsVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8062b = null;
            orderDetailsVh.mLeftTv = null;
            orderDetailsVh.mRightTv = null;
            orderDetailsVh.mSplitLineView = null;
        }
    }

    @Override // com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder.getItemViewType() == 2) {
            ((OrderDetailsVh) viewHolder).setData((LeftTitleToRightArrowVo) this.f6460b.get(i2 - h()));
        } else {
            super.onBindViewHolder(viewHolder, i2);
        }
    }

    @Override // com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return i2 == 2 ? new OrderDetailsVh(i(viewGroup, R.layout.item_order_details_layout)) : super.onCreateViewHolder(viewGroup, i2);
    }
}
