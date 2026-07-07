package com.chinavisionary.microtang.address.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.chinavisionary.microtang.room.vo.ExpressVo;

/* JADX INFO: loaded from: classes.dex */
public class AddressAdapter extends BaseRecyclerAdapter<ExpressVo> {

    public static class AddressVH extends BaseRecyclerViewHolder<ExpressVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f6797f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f6798g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f6799h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f6800i;

        @BindView(R.id.tv_express_address)
        public TextView mAddressTv;

        @BindView(R.id.tv_express_name)
        public TextView mNameTv;

        @BindView(R.id.tv_express_phone)
        public TextView mPhoneTv;

        @BindView(R.id.img_right_icon)
        public ImageView mRightImgView;

        public AddressVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.mRightImgView.setVisibility(8);
            this.f6797f = this.mRightImgView.getResources().getColor(R.color.tab_item_select_color);
            this.f6800i = this.mRightImgView.getResources().getColor(R.color.color_white);
            this.f6799h = this.mRightImgView.getResources().getColor(R.color.color000000);
            this.f6798g = this.mRightImgView.getResources().getColor(R.color.color_white);
        }

        public void g(ExpressVo expressVo) {
            boolean zIsSelect = expressVo.isSelect();
            this.itemView.setBackgroundColor(zIsSelect ? this.f6797f : this.f6800i);
            this.mNameTv.setTextColor(zIsSelect ? this.f6798g : this.f6799h);
            this.mPhoneTv.setTextColor(zIsSelect ? this.f6798g : this.f6799h);
            this.mAddressTv.setTextColor(zIsSelect ? this.f6798g : this.f6799h);
            this.mNameTv.setText(x.getNotNullStr(expressVo.getPersonName(), ""));
            this.mPhoneTv.setText(x.getNotNullStr(expressVo.getPhone(), ""));
            this.mAddressTv.setText(x.getNotNullStr(expressVo.getAddress(), ""));
        }
    }

    public class AddressVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AddressVH f6801b;

        @UiThread
        public AddressVH_ViewBinding(AddressVH addressVH, View view) {
            this.f6801b = addressVH;
            addressVH.mNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_express_name, "field 'mNameTv'", TextView.class);
            addressVH.mPhoneTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_express_phone, "field 'mPhoneTv'", TextView.class);
            addressVH.mAddressTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_express_address, "field 'mAddressTv'", TextView.class);
            addressVH.mRightImgView = (ImageView) d.findRequiredViewAsType(view, R.id.img_right_icon, "field 'mRightImgView'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            AddressVH addressVH = this.f6801b;
            if (addressVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f6801b = null;
            addressVH.mNameTv = null;
            addressVH.mPhoneTv = null;
            addressVH.mAddressTv = null;
            addressVH.mRightImgView = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ((AddressVH) viewHolder).g((ExpressVo) this.f6460b.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        AddressVH addressVH = new AddressVH(i(viewGroup, R.layout.item_express_address_layout));
        a(addressVH);
        return addressVH;
    }
}
