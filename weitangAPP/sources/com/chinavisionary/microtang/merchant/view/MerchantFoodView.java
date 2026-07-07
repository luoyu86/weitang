package com.chinavisionary.microtang.merchant.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import c.e.a.d.x;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.merchant.vo.MerchantRightContentVo;
import com.chinavisionary.microtang.merchant.vo.SpecificationTagsVo;
import com.chinavisionary.microtang.view.CustomTextView;
import com.chinavisionary.microtang.view.SpecView;
import com.nex3z.flowlayout.FlowLayout;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MerchantFoodView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View.OnClickListener f7942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LayoutInflater f7943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearLayout.LayoutParams f7945d;

    public MerchantFoodView(Context context) {
        super(context);
        this.f7944c = getResources().getColor(R.color.colore757575);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.f7945d = layoutParams;
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.dp_6);
        this.f7943b = LayoutInflater.from(getContext());
        setOrientation(1);
    }

    public final void a(MerchantRightContentVo.FoodVo foodVo, int i2, int i3) {
        View viewInflate = this.f7943b.inflate(R.layout.item_merchant_food_layout, (ViewGroup) null);
        CoreRoundedImageView coreRoundedImageView = (CoreRoundedImageView) viewInflate.findViewById(R.id.img_product_cover);
        CustomTextView customTextView = (CustomTextView) viewInflate.findViewById(R.id.tv_product_name);
        CustomTextView customTextView2 = (CustomTextView) viewInflate.findViewById(R.id.tv_month_sale_volume_value);
        CustomTextView customTextView3 = (CustomTextView) viewInflate.findViewById(R.id.tv_product_price);
        FlowLayout flowLayout = (FlowLayout) viewInflate.findViewById(R.id.flow_layout_product_tag);
        SpecView specView = (SpecView) viewInflate.findViewById(R.id.spec_view);
        coreRoundedImageView.loadImageToResourceVo(foodVo.getCoverRes());
        customTextView.setText(foodVo.getTitle());
        customTextView2.setText(x.appendStringToResId(R.string.placeholder_title_month_volume, String.valueOf(foodVo.getMonthSaleVolume())));
        customTextView3.setText(x.bigDecimalToPlainStringAddUnit(foodVo.getPrice()));
        b(flowLayout, foodVo.getRecommendTagList());
        specView.setupData(i2, foodVo.getBuyNumber(), foodVo.getMaxLimit());
        specView.setupIndex(i3);
        specView.setOnClickListener(this.f7942a);
        addView(viewInflate);
    }

    public final void b(FlowLayout flowLayout, List<SpecificationTagsVo> list) {
        flowLayout.removeAllViews();
        for (SpecificationTagsVo specificationTagsVo : list) {
            CustomTextView customTextView = new CustomTextView(getContext());
            customTextView.setLayoutParams(this.f7945d);
            customTextView.setBackgroundResource(R.drawable.bg_product_spec_tag);
            customTextView.setTextColor(this.f7944c);
            customTextView.setText(specificationTagsVo.getSpecificationTagName());
            customTextView.setTextSize(9.0f);
            flowLayout.addView(customTextView);
        }
    }

    public void setData(MerchantRightContentVo merchantRightContentVo, int i2) {
        removeAllViews();
        MerchantRightContentVo.FoodVo foodVo = merchantRightContentVo.getFoodVo();
        if (foodVo != null) {
            a(foodVo, i2, i2);
        }
    }

    public void setViewOnClickListener(View.OnClickListener onClickListener) {
        this.f7942a = onClickListener;
    }

    public MerchantFoodView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7944c = getResources().getColor(R.color.colore757575);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.f7945d = layoutParams;
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.dp_6);
        this.f7943b = LayoutInflater.from(getContext());
        setOrientation(1);
    }

    public MerchantFoodView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f7944c = getResources().getColor(R.color.colore757575);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.f7945d = layoutParams;
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.dp_6);
        this.f7943b = LayoutInflater.from(getContext());
        setOrientation(1);
    }
}
