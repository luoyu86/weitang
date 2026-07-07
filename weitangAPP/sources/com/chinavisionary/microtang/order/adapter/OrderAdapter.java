package com.chinavisionary.microtang.order.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.a.d.x;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.buycart.adapter.BuyCartAdapter;
import com.chinavisionary.microtang.buycart.vo.BuyCartVo;
import com.chinavisionary.microtang.room.vo.ExpressVo;
import com.chinavisionary.microtang.view.BuyCartSpecView;

/* JADX INFO: loaded from: classes.dex */
public class OrderAdapter extends BuyCartAdapter {

    public static class BillBuyCartVh extends BaseRecyclerViewHolder<BuyCartVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f8057f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f8058g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f8059h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f8060i;

        @BindView(R.id.view_bottom_line)
        public View mBottomLine;

        @BindView(R.id.view_bottom_one_line)
        public View mBottomOneLine;

        @BindView(R.id.cb_business)
        public AppCompatCheckBox mBusinessCb;

        @BindView(R.id.img_business_cover)
        public CoreRoundedImageView mBusinessCoverImg;

        @BindView(R.id.tv_business_name)
        public TextView mBusinessNameTv;

        @BindView(R.id.buy_cart_spec_view)
        public BuyCartSpecView mBuyCartSpecView;

        @BindView(R.id.tv_order_state_name)
        public TextView mOrderStateNameTv;

        @BindView(R.id.tv_self_picked_address)
        public TextView mSelfPickedAddressTv;

        public BillBuyCartVh(View view, int i2) {
            super(view);
            this.f8058g = i2;
            ButterKnife.bind(this, view);
        }

        public void g(BuyCartVo buyCartVo) {
            this.mBuyCartSpecView.setOrderStateType(buyCartVo.getOrderState());
            ExpressVo selfAddress = buyCartVo.getSelfAddress();
            k(buyCartVo);
            l(buyCartVo);
            n(buyCartVo);
            m(selfAddress);
            j(buyCartVo.isHiedBottomLine());
            this.mOrderStateNameTv.setText(buyCartVo.getOrderStateName());
        }

        public void h(int i2) {
            this.f8059h = i2;
        }

        public void i(int i2) {
            this.f8058g = i2;
        }

        public final void j(boolean z) {
            this.mBottomLine.setVisibility(z ? 8 : 0);
            this.mBottomOneLine.setVisibility(z ? 0 : 8);
        }

        public final void k(BuyCartVo buyCartVo) {
            this.mBusinessCb.setVisibility(this.f8058g == 1 ? 0 : 8);
            this.mBusinessCb.setChecked(buyCartVo.isSelect());
            this.mBusinessNameTv.setText(x.getNotNullStr(buyCartVo.getMerchantName(), ""));
            this.mBusinessCb.setTag(Integer.valueOf(this.f6468a));
            this.mBusinessCb.setOnClickListener(null);
            this.mBusinessCb.setOnClickListener(this.f8057f);
        }

        public final void l(BuyCartVo buyCartVo) {
            this.mBusinessCoverImg.loadImageToResourceVo(buyCartVo.getMerchantLogo());
            CoreRoundedImageView coreRoundedImageView = this.mBusinessCoverImg;
            coreRoundedImageView.setTag(coreRoundedImageView.getId(), Integer.valueOf(this.f6468a));
            this.mBusinessCoverImg.setOnClickListener(null);
            this.mBusinessCoverImg.setOnClickListener(this.f8057f);
        }

        public final void m(ExpressVo expressVo) {
            String address = expressVo != null ? expressVo.getAddress() : null;
            this.mSelfPickedAddressTv.setVisibility(this.f8058g == 2 ? 0 : 8);
            this.mSelfPickedAddressTv.setText(x.getString(R.string.placeholder_self_picked_address, x.getNotNullStr(address, "")));
            this.mSelfPickedAddressTv.setTag(Integer.valueOf(this.f6468a));
            this.mSelfPickedAddressTv.setOnClickListener(null);
            this.mSelfPickedAddressTv.setOnClickListener(this.f8057f);
        }

        public final void n(BuyCartVo buyCartVo) {
            boolean z = this.f8058g == 1;
            this.mBuyCartSpecView.setCbOnClickListener(null);
            this.mBuyCartSpecView.setCbOnClickListener(this.f8057f);
            this.mBuyCartSpecView.setShowCountFeeLayout(true ^ buyCartVo.isHiedBottomLine());
            this.mBuyCartSpecView.addDataToSpec(buyCartVo, this.f6468a, z, this.f8058g, this.f8060i);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f8057f = onClickListener;
        }
    }

    public class BillBuyCartVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BillBuyCartVh f8061b;

        @UiThread
        public BillBuyCartVh_ViewBinding(BillBuyCartVh billBuyCartVh, View view) {
            this.f8061b = billBuyCartVh;
            billBuyCartVh.mBusinessCb = (AppCompatCheckBox) d.findRequiredViewAsType(view, R.id.cb_business, "field 'mBusinessCb'", AppCompatCheckBox.class);
            billBuyCartVh.mBusinessNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_business_name, "field 'mBusinessNameTv'", TextView.class);
            billBuyCartVh.mBusinessCoverImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_business_cover, "field 'mBusinessCoverImg'", CoreRoundedImageView.class);
            billBuyCartVh.mBuyCartSpecView = (BuyCartSpecView) d.findRequiredViewAsType(view, R.id.buy_cart_spec_view, "field 'mBuyCartSpecView'", BuyCartSpecView.class);
            billBuyCartVh.mBottomLine = d.findRequiredView(view, R.id.view_bottom_line, "field 'mBottomLine'");
            billBuyCartVh.mBottomOneLine = d.findRequiredView(view, R.id.view_bottom_one_line, "field 'mBottomOneLine'");
            billBuyCartVh.mSelfPickedAddressTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_self_picked_address, "field 'mSelfPickedAddressTv'", TextView.class);
            billBuyCartVh.mOrderStateNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_order_state_name, "field 'mOrderStateNameTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            BillBuyCartVh billBuyCartVh = this.f8061b;
            if (billBuyCartVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8061b = null;
            billBuyCartVh.mBusinessCb = null;
            billBuyCartVh.mBusinessNameTv = null;
            billBuyCartVh.mBusinessCoverImg = null;
            billBuyCartVh.mBuyCartSpecView = null;
            billBuyCartVh.mBottomLine = null;
            billBuyCartVh.mBottomOneLine = null;
            billBuyCartVh.mSelfPickedAddressTv = null;
            billBuyCartVh.mOrderStateNameTv = null;
        }
    }

    public OrderAdapter(int i2, int i3) {
        super(i2);
        q(i3);
    }

    @Override // com.chinavisionary.microtang.buycart.adapter.BuyCartAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder.getItemViewType() != 2234) {
            super.onBindViewHolder(viewHolder, i2);
            return;
        }
        BillBuyCartVh billBuyCartVh = (BillBuyCartVh) viewHolder;
        billBuyCartVh.setFirstLastPosition(this.f6464f, this.f6465g);
        billBuyCartVh.i(4);
        billBuyCartVh.setListPosition(i2);
        billBuyCartVh.g((BuyCartVo) this.f6460b.get(i2));
    }

    @Override // com.chinavisionary.microtang.buycart.adapter.BuyCartAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 != 2234) {
            return super.onCreateViewHolder(viewGroup, i2);
        }
        View viewI = i(viewGroup, R.layout.item_buy_cart_layout);
        BillBuyCartVh billBuyCartVh = new BillBuyCartVh(viewI, 4);
        billBuyCartVh.h(getOrderStateType());
        billBuyCartVh.setOnClickListener(this.f6461c);
        a(billBuyCartVh);
        viewI.setTag(billBuyCartVh);
        return billBuyCartVh;
    }
}
