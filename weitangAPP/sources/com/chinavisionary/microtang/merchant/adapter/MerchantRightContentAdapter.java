package com.chinavisionary.microtang.merchant.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.merchant.vo.MerchantRightContentVo;
import com.chinavisionary.microtang.merchant.vo.SpecificationTagsVo;
import com.chinavisionary.microtang.view.CustomTextView;
import com.chinavisionary.microtang.view.SpecView;
import com.nex3z.flowlayout.FlowLayout;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MerchantRightContentAdapter extends BaseRecyclerAdapter<MerchantRightContentVo> {

    public static class ProductVh extends BaseRecyclerViewHolder<MerchantRightContentVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7831f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public LinearLayout.LayoutParams f7832g;

        @BindView(R.id.tv_buy_count)
        public TextView mBuyCountTv;

        @BindView(R.id.tv_month_sale_volume_value)
        public CustomTextView mMonthSaleVolumeTv;

        @BindView(R.id.img_product_cover)
        public CoreRoundedImageView mProductCoverImg;

        @BindView(R.id.tv_product_name)
        public CustomTextView mProductNameTv;

        @BindView(R.id.tv_product_price)
        public CustomTextView mProductPriceTv;

        @BindView(R.id.flow_layout_product_tag)
        public FlowLayout mProductTagLayout;

        @BindView(R.id.tv_select_spec)
        public TextView mSelectSpecTv;

        @BindView(R.id.spec_view)
        public SpecView mSpecView;

        public ProductVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.mSpecView.setIsGoneAddSpecImgView(false);
            this.mSpecView.setMinSelectNumber(0);
            this.f7831f = this.mSpecView.getResources().getColor(R.color.colore757575);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.f7832g = layoutParams;
            layoutParams.rightMargin = this.mSpecView.getResources().getDimensionPixelSize(R.dimen.dp_6);
        }

        public void g(MerchantRightContentVo merchantRightContentVo) {
            MerchantRightContentVo.FoodVo foodVo = merchantRightContentVo.getFoodVo();
            boolean zIsMultiSpec = foodVo.isMultiSpec();
            int buyNumber = foodVo.getBuyNumber();
            this.mSpecView.setVisibility(zIsMultiSpec ? 8 : 0);
            this.mBuyCountTv.setVisibility((!zIsMultiSpec || buyNumber <= 0) ? 8 : 0);
            this.mSelectSpecTv.setVisibility(zIsMultiSpec ? 0 : 8);
            this.mBuyCountTv.setText(String.valueOf(foodVo.getBuyNumber()));
            this.mSelectSpecTv.setTag(Integer.valueOf(this.f6468a));
            this.mSelectSpecTv.setOnClickListener(null);
            this.mSelectSpecTv.setOnClickListener(this.f6469b);
            this.mProductCoverImg.loadImageToResourceVo(foodVo.getCoverRes());
            this.mProductNameTv.setText(foodVo.getTitle());
            this.mMonthSaleVolumeTv.setText(x.appendStringToResId(R.string.placeholder_title_month_volume, String.valueOf(foodVo.getMonthSaleVolume())));
            this.mProductPriceTv.setText(x.bigDecimalToPlainStringAddUnit(foodVo.getPrice()));
            h(this.mProductTagLayout, foodVo.getRecommendTagList());
            this.mSpecView.setupData(this.f6468a, foodVo.getBuyNumber(), foodVo.getMaxLimit());
            this.mSpecView.setupIndex(this.f6468a);
            this.mSpecView.setOnClickListener(this.f6469b);
        }

        public final void h(FlowLayout flowLayout, List<SpecificationTagsVo> list) {
            flowLayout.removeAllViews();
            for (SpecificationTagsVo specificationTagsVo : list) {
                CustomTextView customTextView = new CustomTextView(flowLayout.getContext());
                customTextView.setLayoutParams(this.f7832g);
                customTextView.setBackgroundResource(R.drawable.bg_product_spec_tag);
                customTextView.setTextColor(this.f7831f);
                customTextView.setText(specificationTagsVo.getSpecificationTagName());
                customTextView.setTextSize(9.0f);
                flowLayout.addView(customTextView);
            }
        }
    }

    public class ProductVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ProductVh f7833b;

        @UiThread
        public ProductVh_ViewBinding(ProductVh productVh, View view) {
            this.f7833b = productVh;
            productVh.mProductCoverImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_product_cover, "field 'mProductCoverImg'", CoreRoundedImageView.class);
            productVh.mProductNameTv = (CustomTextView) d.findRequiredViewAsType(view, R.id.tv_product_name, "field 'mProductNameTv'", CustomTextView.class);
            productVh.mMonthSaleVolumeTv = (CustomTextView) d.findRequiredViewAsType(view, R.id.tv_month_sale_volume_value, "field 'mMonthSaleVolumeTv'", CustomTextView.class);
            productVh.mProductPriceTv = (CustomTextView) d.findRequiredViewAsType(view, R.id.tv_product_price, "field 'mProductPriceTv'", CustomTextView.class);
            productVh.mProductTagLayout = (FlowLayout) d.findRequiredViewAsType(view, R.id.flow_layout_product_tag, "field 'mProductTagLayout'", FlowLayout.class);
            productVh.mSpecView = (SpecView) d.findRequiredViewAsType(view, R.id.spec_view, "field 'mSpecView'", SpecView.class);
            productVh.mSelectSpecTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_select_spec, "field 'mSelectSpecTv'", TextView.class);
            productVh.mBuyCountTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_buy_count, "field 'mBuyCountTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ProductVh productVh = this.f7833b;
            if (productVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7833b = null;
            productVh.mProductCoverImg = null;
            productVh.mProductNameTv = null;
            productVh.mMonthSaleVolumeTv = null;
            productVh.mProductPriceTv = null;
            productVh.mProductTagLayout = null;
            productVh.mSpecView = null;
            productVh.mSelectSpecTv = null;
            productVh.mBuyCountTv = null;
        }
    }

    public static class TitleVh extends BaseRecyclerViewHolder<MerchantRightContentVo> {

        @BindView(R.id.tv_content_title)
        public CustomTextView mContentTitleTv;

        public TitleVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(MerchantRightContentVo merchantRightContentVo) {
            this.mContentTitleTv.setText(merchantRightContentVo.getTitle());
        }
    }

    public class TitleVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TitleVh f7834b;

        @UiThread
        public TitleVh_ViewBinding(TitleVh titleVh, View view) {
            this.f7834b = titleVh;
            titleVh.mContentTitleTv = (CustomTextView) d.findRequiredViewAsType(view, R.id.tv_content_title, "field 'mContentTitleTv'", CustomTextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            TitleVh titleVh = this.f7834b;
            if (titleVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7834b = null;
            titleVh.mContentTitleTv = null;
        }
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        List<T> list = this.f6460b;
        return (list == 0 || list.isEmpty()) ? super.getItemViewType(i2) : ((MerchantRightContentVo) this.f6460b.get(i2)).getItemType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 101) {
            ((TitleVh) viewHolder).g((MerchantRightContentVo) this.f6460b.get(i2));
        } else {
            if (itemViewType != 102) {
                return;
            }
            ProductVh productVh = (ProductVh) viewHolder;
            productVh.setListPosition(i2);
            productVh.g((MerchantRightContentVo) this.f6460b.get(i2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        BaseRecyclerViewHolder titleVh;
        if (i2 == 101) {
            titleVh = new TitleVh(i(viewGroup, R.layout.item_merchant_right_content_title_layout));
        } else {
            if (i2 != 102) {
                return null;
            }
            View viewI = i(viewGroup, R.layout.item_merchant_food_layout);
            titleVh = new ProductVh(viewI);
            viewI.setTag(titleVh);
            titleVh.setViewOnClickListener(this.f6461c);
            a(titleVh);
        }
        return titleVh;
    }
}
