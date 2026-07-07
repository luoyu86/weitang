package c.e.c.y.c;

import android.view.View;
import android.widget.TextView;
import c.e.a.d.k;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.merchant.vo.CommodityVo;
import com.chinavisionary.microtang.view.CustomTextView;
import com.chinavisionary.microtang.view.SpecView;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CustomTextView f2256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CustomTextView f2257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CustomTextView f2258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CustomTextView f2259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f2260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EditBannerView f2261f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SpecView f2262g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f2263h;

    public e(View view, View.OnClickListener onClickListener) {
        this.f2256a = (CustomTextView) view.findViewById(R.id.tv_food_title);
        this.f2257b = (CustomTextView) view.findViewById(R.id.tv_food_price);
        this.f2259d = (CustomTextView) view.findViewById(R.id.tv_other_fee);
        this.f2261f = (EditBannerView) view.findViewById(R.id.banner_food_cover);
        this.f2262g = (SpecView) view.findViewById(R.id.spec_view);
        this.f2263h = (TextView) view.findViewById(R.id.tv_add_buy_cart);
        this.f2260e = (TextView) view.findViewById(R.id.tv_spec_buy_cart_count);
        this.f2258c = (CustomTextView) view.findViewById(R.id.tv_month_sale_volume_value);
        this.f2262g.setupIndex(0);
        this.f2262g.setMinSelectNumber(0);
        this.f2262g.setIsGoneAddSpecImgView(false);
        this.f2263h.setOnClickListener(onClickListener);
        this.f2262g.setOnClickListener(onClickListener);
        this.f2261f.setImageCornerRadius(0);
        this.f2261f.setItemClickListener(onClickListener);
        this.f2261f.setFragment(null);
        int productBannerHeight = k.getProductBannerHeight(this.f2261f.getContext());
        q.d(e.class.getSimpleName(), "banner height:" + productBannerHeight);
        this.f2261f.getLayoutParams().height = productBannerHeight;
    }

    public SpecView getSpecView() {
        return this.f2262g;
    }

    public void updateFoodDetails(CommodityVo commodityVo) {
        if (commodityVo != null) {
            boolean z = o.isNotEmpty(commodityVo.getSpecifications()) && commodityVo.getSpecifications().size() > 1;
            this.f2262g.setVisibility(z ? 8 : 0);
            this.f2260e.setVisibility((!z || commodityVo.getBuyNumber() <= 0) ? 8 : 0);
            this.f2263h.setVisibility(z ? 0 : 8);
            this.f2260e.setText(String.valueOf(commodityVo.getBuyNumber()));
            this.f2262g.setupData(0, commodityVo.getBuyNumber(), commodityVo.getMaxLimit());
            this.f2256a.setText(commodityVo.getTitle());
            this.f2259d.setText(x.appendStringToResId(R.string.placeholder_package_fee, x.bigDecimalToPlainString(commodityVo.getPackPrice())));
            this.f2261f.setAdapterListData(commodityVo.getBannerDtos());
            this.f2258c.setText(x.appendStringToResId(R.string.placeholder_title_month_volume, String.valueOf(commodityVo.getSellAmount())));
            this.f2257b.setText(x.bigDecimalToPlainStringAddUnit(commodityVo.getPrice()));
        }
    }
}
