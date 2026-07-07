package com.chinavisionary.microtang.service.adapter;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
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
import com.chinavisionary.microtang.service.vo.CustomerHotReasonVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CustomerHotReasonAdapter extends BaseRecyclerAdapter<CustomerHotReasonVo> {

    public static class CustomerHotReasonVH extends BaseRecyclerViewHolder<CustomerHotReasonVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Drawable f8397f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Drawable f8398g;

        @BindView(R.id.tv_details)
        public TextView mDetailsTv;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public CustomerHotReasonVH(View view) {
            super(view);
            int dimensionPixelSize = view.getContext().getResources().getDimensionPixelSize(R.dimen.dp_14);
            Rect rect = new Rect(0, 0, dimensionPixelSize, dimensionPixelSize);
            ButterKnife.bind(this, view);
            Drawable drawable = view.getResources().getDrawable(R.mipmap.ic_up_arrow_text_color);
            this.f8398g = drawable;
            drawable.setBounds(rect);
            Drawable drawable2 = view.getResources().getDrawable(R.mipmap.ic_down_arrow_text_color);
            this.f8397f = drawable2;
            drawable2.setBounds(rect);
        }

        public void g(CustomerHotReasonVo customerHotReasonVo) {
            boolean zIsOpen = customerHotReasonVo.isOpen();
            this.mTitleTv.setCompoundDrawables(null, null, zIsOpen ? this.f8398g : this.f8397f, null);
            this.mTitleTv.setText(x.getNotNullStr(customerHotReasonVo.getTitle(), ""));
            this.mDetailsTv.setText(x.getNotNullStr(customerHotReasonVo.getContent(), ""));
            this.mDetailsTv.setVisibility(zIsOpen ? 0 : 8);
        }
    }

    public class CustomerHotReasonVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CustomerHotReasonVH f8399b;

        @UiThread
        public CustomerHotReasonVH_ViewBinding(CustomerHotReasonVH customerHotReasonVH, View view) {
            this.f8399b = customerHotReasonVH;
            customerHotReasonVH.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
            customerHotReasonVH.mDetailsTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_details, "field 'mDetailsTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            CustomerHotReasonVH customerHotReasonVH = this.f8399b;
            if (customerHotReasonVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8399b = null;
            customerHotReasonVH.mTitleTv = null;
            customerHotReasonVH.mDetailsTv = null;
        }
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        List<T> list = this.f6460b;
        return (list == 0 || list.size() != 1) ? super.getItemViewType(i2) : ((CustomerHotReasonVo) this.f6460b.get(i2)).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 34952 || itemViewType == 39321) {
            return;
        }
        CustomerHotReasonVH customerHotReasonVH = (CustomerHotReasonVH) viewHolder;
        customerHotReasonVH.g((CustomerHotReasonVo) this.f6460b.get(i2));
        b(customerHotReasonVH, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 34952) {
            return new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup));
        }
        if (i2 == 39321) {
            return new BaseRecyclerAdapter.FooterViewHolder(f(viewGroup));
        }
        View viewI = i(viewGroup, R.layout.item_hot_reason_layout);
        CustomerHotReasonVH customerHotReasonVH = new CustomerHotReasonVH(viewI);
        viewI.setTag(customerHotReasonVH);
        return customerHotReasonVH;
    }
}
