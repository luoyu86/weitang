package com.chinavisionary.microtang.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatEditText;
import c.e.a.d.o;
import c.e.a.d.x;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.buycart.vo.BuyCartProductVo;
import com.chinavisionary.microtang.buycart.vo.BuyCartVo;
import com.chinavisionary.microtang.order.vo.KeyValueVo;
import com.chinavisionary.microtang.room.vo.SaleVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BuyCartSpecView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnClickListener f8629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutInflater f8630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8631d;

    public class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BuyCartVo f8632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppCompatEditText f8633b;

        public a(BuyCartVo buyCartVo, AppCompatEditText appCompatEditText) {
            this.f8632a = buyCartVo;
            this.f8633b = appCompatEditText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            this.f8632a.setOrderRemark(this.f8633b.getText().toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public BuyCartSpecView(Context context) {
        super(context);
        this.f8631d = true;
        setOrientation(1);
        this.f8630c = LayoutInflater.from(getContext());
    }

    public final View a(List<KeyValueVo> list, BuyCartVo buyCartVo, int i2) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (o.isNotEmpty(list)) {
            boolean z = buyCartVo.getTotalAmount() != null;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                KeyValueVo keyValueVo = list.get(i3);
                if (keyValueVo != null && x.isNotNull(keyValueVo.getKey()) && x.isNotNull(keyValueVo.getValue())) {
                    View viewInflate = this.f8630c.inflate(R.layout.item_order_details_layout, (ViewGroup) this, false);
                    CustomTextView customTextView = (CustomTextView) viewInflate.findViewById(R.id.tv_left_title);
                    CustomTextView customTextView2 = (CustomTextView) viewInflate.findViewById(R.id.tv_right_title);
                    View viewFindViewById = viewInflate.findViewById(R.id.view_split_line);
                    customTextView.setText(keyValueVo.getKey());
                    if (d(keyValueVo.getKey())) {
                        customTextView2.setText(x.getNotNullStr(keyValueVo.getValue(), ""));
                    } else {
                        customTextView2.setText(x.getString(R.string.rmb_placeholder, keyValueVo.getValue()));
                    }
                    if (z && i3 == size - 1) {
                        customTextView2.setTextColor(customTextView2.getResources().getColor(R.color.item_room_tv_price_color));
                        viewFindViewById.setVisibility(8);
                    }
                    linearLayout.addView(viewInflate);
                }
            }
        }
        if (i2 != 6) {
            View viewInflate2 = this.f8630c.inflate(R.layout.item_order_remark_layout, (ViewGroup) this, false);
            AppCompatEditText appCompatEditText = (AppCompatEditText) viewInflate2.findViewById(R.id.edt_input_remark);
            appCompatEditText.addTextChangedListener(new a(buyCartVo, appCompatEditText));
            linearLayout.addView(viewInflate2);
        }
        return linearLayout;
    }

    public void addDataToSpec(BuyCartVo buyCartVo, int i2, boolean z) {
        addDataToSpec(buyCartVo, i2, z, -1, 3);
    }

    public final View b(int i2, int i3, int i4, BigDecimal bigDecimal) {
        View viewInflate = this.f8630c.inflate(R.layout.item_order_operation, (ViewGroup) this, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_product_count);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_price_count);
        AppCompatButton appCompatButton = (AppCompatButton) viewInflate.findViewById(R.id.btn_confirm);
        AppCompatButton appCompatButton2 = (AppCompatButton) viewInflate.findViewById(R.id.btn_cancel);
        textView.setText(x.appendStringToResId(R.string.placeholder_product_count, String.valueOf(i4)));
        textView2.setText(x.bigDecimalToPlainString(bigDecimal));
        appCompatButton.setTag(Integer.valueOf(i3));
        appCompatButton2.setTag(Integer.valueOf(i3));
        if (i2 == 4) {
            appCompatButton2.setVisibility(8);
            appCompatButton.setVisibility(8);
        } else if (i2 == 5) {
            appCompatButton2.setVisibility(8);
            appCompatButton.setText(R.string.title_confirm_receiver_product);
        } else if (i2 == 6) {
            appCompatButton2.setVisibility(8);
            appCompatButton.setText(R.string.title_comment);
        }
        appCompatButton.setOnClickListener(this.f8629b);
        appCompatButton2.setOnClickListener(this.f8629b);
        return viewInflate;
    }

    public final View c(BuyCartProductVo buyCartProductVo, int i2, int i3, int i4, int i5, boolean z) {
        View viewInflate = this.f8630c.inflate(R.layout.item_buy_cart_spec_layout, (ViewGroup) this, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_sale_name);
        textView.setVisibility(z ? 8 : 0);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_spec_number_value);
        textView2.setVisibility(z ? 8 : 0);
        textView2.setText(x.getString(R.string.placeholder_spec_number, String.valueOf(buyCartProductVo.getQuantity())));
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) viewInflate.findViewById(R.id.cb_product);
        appCompatCheckBox.setVisibility(z ? 0 : 8);
        appCompatCheckBox.setChecked(buyCartProductVo.isSelect());
        viewInflate.findViewById(R.id.view_bottom_line).setVisibility(i3 == i5 + (-1) ? 8 : 0);
        CoreRoundedImageView coreRoundedImageView = (CoreRoundedImageView) viewInflate.findViewById(R.id.img_product_cover);
        coreRoundedImageView.loadImageToResourceVo(buyCartProductVo.getCommodityCover());
        ((TextView) viewInflate.findViewById(R.id.tv_product_name)).setText(x.getNotNullStr(buyCartProductVo.getCommodityName(), ""));
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_spec_name);
        textView3.setText(x.getNotNullStr(buyCartProductVo.getCommoditySpecificationName(), ""));
        SaleVo sale = buyCartProductVo.getSale();
        if (sale == null || z) {
            textView.setVisibility(8);
        } else {
            textView3.setBackground(null);
            textView3.setCompoundDrawables(null, null, null, null);
            textView.setText(x.getNotNullStr(sale.getName(), x.getString(R.string.tip_not_sale_receiver)));
        }
        if (i2 == 5 || i2 == 4 || i2 == 1 || i2 == 3) {
            textView3.setBackground(null);
            textView3.setCompoundDrawables(null, null, null, null);
        }
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_spec_price);
        textView4.setTag(buyCartProductVo.getCommoditySpecificationPrice());
        int iMin = buyCartProductVo.getLimit() > 0 ? Math.min(buyCartProductVo.getLimit(), buyCartProductVo.getSurplusNumber()) : buyCartProductVo.getSurplusNumber();
        SpecView specView = (SpecView) viewInflate.findViewById(R.id.spec_view);
        specView.setSpecCountPriceTv(textView4);
        specView.setupIndex(i3);
        specView.setupData(i4, buyCartProductVo.getQuantity(), iMin);
        specView.setVisibility(z ? 0 : 4);
        textView4.setText(x.getString(R.string.rmb_placeholder, x.bigDecimalToPlainString(buyCartProductVo.getCommoditySpecificationPrice())));
        coreRoundedImageView.setTag(coreRoundedImageView.getId(), Integer.valueOf(i4));
        textView.setTag(Integer.valueOf(i4));
        textView.setTag(textView.getId(), Integer.valueOf(i3));
        textView3.setTag(Integer.valueOf(i4));
        textView3.setTag(textView3.getId(), Integer.valueOf(i3));
        appCompatCheckBox.setTag(Integer.valueOf(i4));
        appCompatCheckBox.setTag(appCompatCheckBox.getId(), Integer.valueOf(i3));
        appCompatCheckBox.setOnClickListener(null);
        specView.setOnClickListener(null);
        textView3.setOnClickListener(null);
        textView.setOnClickListener(null);
        textView.setOnClickListener(this.f8629b);
        textView3.setOnClickListener(this.f8629b);
        appCompatCheckBox.setOnClickListener(this.f8629b);
        specView.setOnClickListener(this.f8629b);
        return viewInflate;
    }

    public final boolean d(String str) {
        if (x.isNotNull(str)) {
            return str.contains("备注");
        }
        return false;
    }

    public void setCbOnClickListener(View.OnClickListener onClickListener) {
        this.f8629b = onClickListener;
    }

    public void setOrderStateType(int i2) {
        this.f8628a = i2;
    }

    public void setShowCountFeeLayout(boolean z) {
        this.f8631d = z;
    }

    public void addDataToSpec(BuyCartVo buyCartVo, int i2, boolean z, int i3, int i4) {
        removeAllViews();
        List<BuyCartProductVo> commodities = buyCartVo.getCommodities();
        if (commodities == null || commodities.isEmpty()) {
            return;
        }
        int size = commodities.size();
        for (int i5 = 0; i5 < size; i5++) {
            BuyCartProductVo buyCartProductVo = commodities.get(i5);
            if (buyCartProductVo != null) {
                addView(c(buyCartProductVo, i3, i5, i2, size, z));
            }
        }
        if (i3 == 4 && this.f8631d) {
            addView(b(this.f8628a, i2, buyCartVo.getSpecCount(), buyCartVo.getTotalAmount()));
        }
        if (i4 > 0) {
            addView(a(buyCartVo.getFeesBeans(), buyCartVo, i4));
        }
    }

    public BuyCartSpecView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8631d = true;
        setOrientation(1);
        this.f8630c = LayoutInflater.from(getContext());
    }

    public BuyCartSpecView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8631d = true;
        setOrientation(1);
        this.f8630c = LayoutInflater.from(getContext());
    }
}
