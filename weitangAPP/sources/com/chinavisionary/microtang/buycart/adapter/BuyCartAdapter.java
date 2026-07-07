package com.chinavisionary.microtang.buycart.adapter;

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
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.buycart.vo.BuyCartVo;
import com.chinavisionary.microtang.room.vo.ExpressVo;
import com.chinavisionary.microtang.room.vo.SaleVo;
import com.chinavisionary.microtang.view.BuyCartSpecView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BuyCartAdapter extends BaseRecyclerAdapter<BuyCartVo> {
    public int n;
    public int o;
    public int p;

    public static class BuyCartVh extends BaseRecyclerViewHolder<BuyCartVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f6881f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f6882g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f6883h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f6884i;

        @BindView(R.id.cb_business)
        public AppCompatCheckBox mBusinessCb;

        @BindView(R.id.img_business_cover)
        public CoreRoundedImageView mBusinessCoverImg;

        @BindView(R.id.tv_business_name)
        public TextView mBusinessNameTv;

        @BindView(R.id.buy_cart_spec_view)
        public BuyCartSpecView mBuyCartSpecView;

        @BindView(R.id.tv_self_picked_address)
        public TextView mSelfPickedAddressTv;

        public BuyCartVh(View view, int i2) {
            super(view);
            this.f6882g = i2;
            ButterKnife.bind(this, view);
        }

        public void g(BuyCartVo buyCartVo) {
            ExpressVo selfAddress = buyCartVo.getSelfAddress();
            k(buyCartVo);
            l(buyCartVo);
            n(buyCartVo);
            m(selfAddress);
        }

        public void h(int i2) {
            this.f6884i = i2;
        }

        public void i(int i2) {
            this.f6883h = i2;
            this.mBuyCartSpecView.setOrderStateType(i2);
        }

        public void j(int i2) {
            this.f6882g = i2;
        }

        public final void k(BuyCartVo buyCartVo) {
            this.mBusinessCb.setVisibility(this.f6882g == 1 ? 0 : 8);
            this.mBusinessCb.setChecked(buyCartVo.isSelect());
            this.mBusinessNameTv.setText(x.getNotNullStr(buyCartVo.getMerchantName(), ""));
            this.mBusinessCb.setTag(Integer.valueOf(this.f6468a));
            this.mBusinessCb.setOnClickListener(null);
            this.mBusinessCb.setOnClickListener(this.f6881f);
        }

        public final void l(BuyCartVo buyCartVo) {
            this.mBusinessCoverImg.loadImageToResourceVo(buyCartVo.getMerchantLogo());
            CoreRoundedImageView coreRoundedImageView = this.mBusinessCoverImg;
            coreRoundedImageView.setTag(coreRoundedImageView.getId(), Integer.valueOf(this.f6468a));
            this.mBusinessCoverImg.setOnClickListener(null);
            this.mBusinessCoverImg.setOnClickListener(this.f6881f);
        }

        public final void m(ExpressVo expressVo) {
            String address = expressVo != null ? expressVo.getAddress() : null;
            this.mSelfPickedAddressTv.setVisibility(this.f6882g == 2 ? 0 : 8);
            this.mSelfPickedAddressTv.setText(x.getString(R.string.placeholder_self_picked_address, x.getNotNullStr(address, "")));
            this.mSelfPickedAddressTv.setTag(Integer.valueOf(this.f6468a));
            this.mSelfPickedAddressTv.setOnClickListener(null);
            this.mSelfPickedAddressTv.setOnClickListener(this.f6881f);
        }

        public final void n(BuyCartVo buyCartVo) {
            boolean z = this.f6882g == 1;
            this.mBuyCartSpecView.setCbOnClickListener(null);
            this.mBuyCartSpecView.setCbOnClickListener(this.f6881f);
            this.mBuyCartSpecView.addDataToSpec(buyCartVo, this.f6468a, z, this.f6882g, this.f6884i);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f6881f = onClickListener;
        }
    }

    public class BuyCartVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BuyCartVh f6885b;

        @UiThread
        public BuyCartVh_ViewBinding(BuyCartVh buyCartVh, View view) {
            this.f6885b = buyCartVh;
            buyCartVh.mBusinessCb = (AppCompatCheckBox) d.findRequiredViewAsType(view, R.id.cb_business, "field 'mBusinessCb'", AppCompatCheckBox.class);
            buyCartVh.mBusinessNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_business_name, "field 'mBusinessNameTv'", TextView.class);
            buyCartVh.mBusinessCoverImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_business_cover, "field 'mBusinessCoverImg'", CoreRoundedImageView.class);
            buyCartVh.mBuyCartSpecView = (BuyCartSpecView) d.findRequiredViewAsType(view, R.id.buy_cart_spec_view, "field 'mBuyCartSpecView'", BuyCartSpecView.class);
            buyCartVh.mSelfPickedAddressTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_self_picked_address, "field 'mSelfPickedAddressTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            BuyCartVh buyCartVh = this.f6885b;
            if (buyCartVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f6885b = null;
            buyCartVh.mBusinessCb = null;
            buyCartVh.mBusinessNameTv = null;
            buyCartVh.mBusinessCoverImg = null;
            buyCartVh.mBuyCartSpecView = null;
            buyCartVh.mSelfPickedAddressTv = null;
        }
    }

    public static class OrderSaleVh extends BaseRecyclerViewHolder<BuyCartVo> {

        @BindView(R.id.tv_right_value)
        public TextView mSaleValueTv;

        public OrderSaleVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(BuyCartVo buyCartVo) {
            SaleVo sale = buyCartVo.getSale();
            this.mSaleValueTv.setText(x.getNotNullStr(sale != null ? sale.getName() : null, x.getString(R.string.title_select_sale)));
        }
    }

    public class OrderSaleVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public OrderSaleVh f6886b;

        @UiThread
        public OrderSaleVh_ViewBinding(OrderSaleVh orderSaleVh, View view) {
            this.f6886b = orderSaleVh;
            orderSaleVh.mSaleValueTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_right_value, "field 'mSaleValueTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            OrderSaleVh orderSaleVh = this.f6886b;
            if (orderSaleVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f6886b = null;
            orderSaleVh.mSaleValueTv = null;
        }
    }

    public BuyCartAdapter(int i2) {
        this.n = 1;
        this.n = i2;
        setEmptyTipMsg(x.getString(R.string.tip_buy_cart_is_empty));
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        List<T> list = this.f6460b;
        return (list == 0 || list.isEmpty() || this.f6460b.size() <= i2) ? super.getItemViewType(i2) : ((BuyCartVo) this.f6460b.get(i2)).getItemType();
    }

    public int getOrderStateType() {
        return this.p;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType != 34952) {
            if (itemViewType == 98394) {
                ((OrderSaleVh) viewHolder).g(p(i2));
                return;
            }
            BuyCartVh buyCartVh = (BuyCartVh) viewHolder;
            buyCartVh.setFirstLastPosition(this.f6464f, this.f6465g);
            buyCartVh.h(this.o);
            buyCartVh.j(this.n);
            buyCartVh.setListPosition(i2);
            buyCartVh.g(p(i2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 34952) {
            return new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup));
        }
        if (i2 == 98394) {
            View viewI = i(viewGroup, R.layout.item_order_sale_layout);
            BaseRecyclerViewHolder orderSaleVh = new OrderSaleVh(viewI);
            viewI.setTag(orderSaleVh);
            a(orderSaleVh);
            return orderSaleVh;
        }
        View viewI2 = i(viewGroup, R.layout.item_buy_cart_layout);
        BuyCartVh buyCartVh = new BuyCartVh(viewI2, this.n);
        buyCartVh.i(this.p);
        buyCartVh.setOnClickListener(this.f6461c);
        a(buyCartVh);
        viewI2.setTag(buyCartVh);
        return buyCartVh;
    }

    public final BuyCartVo p(int i2) {
        return this.f6460b.size() > i2 ? (BuyCartVo) this.f6460b.get(i2) : new BuyCartVo();
    }

    public void q(int i2) {
        this.p = i2;
    }

    public void setDeliveryType(int i2) {
        this.o = i2;
        notifyDataSetChanged();
    }
}
