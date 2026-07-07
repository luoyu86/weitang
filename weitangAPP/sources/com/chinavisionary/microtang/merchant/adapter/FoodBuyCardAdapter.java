package com.chinavisionary.microtang.merchant.adapter;

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
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.buycart.vo.BuyCartProductVo;
import com.chinavisionary.microtang.view.CustomTextView;
import com.chinavisionary.microtang.view.SpecView;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FoodBuyCardAdapter extends BaseRecyclerAdapter<BuyCartProductVo> {

    public static class FoodBuyCartVh extends BaseRecyclerViewHolder<BuyCartProductVo> {

        @BindView(R.id.img_product_cover)
        public CoreRoundedImageView mProductCoverImg;

        @BindView(R.id.tv_product_name)
        public CustomTextView mProductNameTv;

        @BindView(R.id.tv_product_price)
        public CustomTextView mProductPriceTv;

        @BindView(R.id.tv_select_spec_name)
        public CustomTextView mSelectSpecNameTv;

        @BindView(R.id.spec_view)
        public SpecView mSpecView;

        public FoodBuyCartVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.mSpecView.setVisibility(0);
        }

        public void g(BuyCartProductVo buyCartProductVo) {
            int quantity = buyCartProductVo.getQuantity();
            this.mProductCoverImg.loadImageToResourceVo(buyCartProductVo.getCommodityCover());
            this.mProductNameTv.setText(buyCartProductVo.getCommodityName());
            this.mSelectSpecNameTv.setText(buyCartProductVo.getCommoditySpecificationName());
            this.mProductPriceTv.setText(x.bigDecimalToPlainStringAddUnit(x.bigDecimalMultiplyToBigDecimal(new BigDecimal(quantity), buyCartProductVo.getCommoditySpecificationPrice())));
            this.mSpecView.setupIndex(this.f6468a);
            this.mSpecView.setOnClickListener(this.f6469b);
            this.mSpecView.setupData(this.f6468a, quantity, buyCartProductVo.getLimit());
        }
    }

    public class FoodBuyCartVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public FoodBuyCartVh f7820b;

        @UiThread
        public FoodBuyCartVh_ViewBinding(FoodBuyCartVh foodBuyCartVh, View view) {
            this.f7820b = foodBuyCartVh;
            foodBuyCartVh.mProductCoverImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_product_cover, "field 'mProductCoverImg'", CoreRoundedImageView.class);
            foodBuyCartVh.mProductNameTv = (CustomTextView) d.findRequiredViewAsType(view, R.id.tv_product_name, "field 'mProductNameTv'", CustomTextView.class);
            foodBuyCartVh.mSelectSpecNameTv = (CustomTextView) d.findRequiredViewAsType(view, R.id.tv_select_spec_name, "field 'mSelectSpecNameTv'", CustomTextView.class);
            foodBuyCartVh.mProductPriceTv = (CustomTextView) d.findRequiredViewAsType(view, R.id.tv_product_price, "field 'mProductPriceTv'", CustomTextView.class);
            foodBuyCartVh.mSpecView = (SpecView) d.findRequiredViewAsType(view, R.id.spec_view, "field 'mSpecView'", SpecView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            FoodBuyCartVh foodBuyCartVh = this.f7820b;
            if (foodBuyCartVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7820b = null;
            foodBuyCartVh.mProductCoverImg = null;
            foodBuyCartVh.mProductNameTv = null;
            foodBuyCartVh.mSelectSpecNameTv = null;
            foodBuyCartVh.mProductPriceTv = null;
            foodBuyCartVh.mSpecView = null;
        }
    }

    public FoodBuyCardAdapter() {
        setEmptyTipMsg(x.getString(R.string.tip_buy_cart_is_empty));
        setupEmptyData();
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        List<T> list = this.f6460b;
        if (list != 0 && !list.isEmpty() && this.f6460b.size() == 1 && x.isNullStr(((BuyCartProductVo) this.f6460b.get(i2)).getCommodityKey()) && x.isNullStr(((BuyCartProductVo) this.f6460b.get(i2)).getCommoditySpecificationKey())) {
            return 34952;
        }
        return super.getItemViewType(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder.getItemViewType() != 34952) {
            FoodBuyCartVh foodBuyCartVh = (FoodBuyCartVh) viewHolder;
            foodBuyCartVh.setListPosition(i2);
            foodBuyCartVh.g((BuyCartProductVo) this.f6460b.get(i2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 34952) {
            return new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup));
        }
        View viewI = i(viewGroup, R.layout.item_food_buy_cart_layout);
        FoodBuyCartVh foodBuyCartVh = new FoodBuyCartVh(viewI);
        foodBuyCartVh.setViewOnClickListener(this.f6461c);
        a(foodBuyCartVh);
        viewI.setTag(foodBuyCartVh);
        return foodBuyCartVh;
    }

    public void setupEmptyData() {
        this.f6460b.clear();
        addDataToList(new BuyCartProductVo());
    }
}
