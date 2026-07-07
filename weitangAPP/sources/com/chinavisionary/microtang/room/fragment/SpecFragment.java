package com.chinavisionary.microtang.room.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.c0.d;
import c.e.a.d.q;
import c.e.a.d.x;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.buycart.vo.BuyCartProductVo;
import com.chinavisionary.microtang.room.vo.ProductSpecVo;
import com.chinavisionary.microtang.view.SpecView;
import com.nex3z.flowlayout.FlowLayout;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SpecFragment extends BaseFragment {
    public int B = -1;
    public int C;
    public int D;
    public LinearLayout.LayoutParams E;
    public List<BuyCartProductVo> F;
    public ProductSpecVo G;

    @BindView(R.id.view_bg)
    public View mBgView;

    @BindView(R.id.tv_buy_number_limit_title)
    public TextView mLimitNumberTv;

    @BindView(R.id.btn_next)
    public AppCompatButton mNextBtn;

    @BindView(R.id.tv_select_spec_name)
    public TextView mSelectSpecNameTv;

    @BindView(R.id.img_product_cover)
    public CoreRoundedImageView mSpecCoverImg;

    @BindView(R.id.flow_layout_spec)
    public FlowLayout mSpecLayout;

    @BindView(R.id.tv_price)
    public TextView mSpecPriceTv;

    @BindView(R.id.spec_add_reduce_layout)
    public SpecView mSpecView;

    @BindView(R.id.tv_surplus_number)
    public TextView mSurplusNumberTv;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: J1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K1() {
        int rowsCount = this.mSpecLayout.getRowsCount();
        q.d(getClass().getSimpleName(), "rows count :" + rowsCount);
        if (rowsCount > 2) {
            this.mBgView.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.dp_320) + (getResources().getDimensionPixelSize(R.dimen.dp_36) * (rowsCount - 2));
            View view = this.mBgView;
            view.setLayoutParams(view.getLayoutParams());
        }
    }

    public static SpecFragment getInstance(String str) {
        SpecFragment specFragment = new SpecFragment();
        specFragment.setArguments(CoreBaseFragment.q(str));
        return specFragment;
    }

    public final void E1() {
        this.F = new ArrayList();
        for (int i2 = 0; i2 < 3; i2++) {
            BuyCartProductVo buyCartProductVo = new BuyCartProductVo();
            buyCartProductVo.setCommodityKey(OperatorName.SET_FLATNESS + i2);
            buyCartProductVo.setCommoditySpecificationName("灰色规格" + i2);
            buyCartProductVo.setLimit(i2 + 5);
            buyCartProductVo.setSurplusNumber(i2 + 30);
            buyCartProductVo.setCommoditySpecificationPrice(new BigDecimal(i2 + 12));
            this.mSpecLayout.addView(F1(buyCartProductVo, i2));
            this.F.add(buyCartProductVo);
        }
        this.mSpecLayout.postDelayed(new Runnable() { // from class: c.e.c.h0.f.a0
            @Override // java.lang.Runnable
            public final void run() {
                this.f1495a.K1();
            }
        }, 200L);
    }

    public final TextView F1(BuyCartProductVo buyCartProductVo, int i2) {
        getResources().getDimensionPixelSize(R.dimen.dp_16);
        TextView textView = new TextView(this.f6487e);
        textView.setLayoutParams(this.E);
        textView.setTextColor(this.C);
        textView.setGravity(17);
        textView.setTextSize(12.0f);
        textView.setText(x.getNotNullStr(buyCartProductVo.getCommoditySpecificationName(), ""));
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this.y);
        textView.setId(R.id.id_spec_tag);
        textView.setBackgroundResource(R.drawable.bg_product_tag);
        return textView;
    }

    public final void G1(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        BuyCartProductVo buyCartProductVo = this.F.get(iIntValue);
        boolean zIsSelect = buyCartProductVo.isSelect();
        int i2 = this.B;
        if (i2 == iIntValue) {
            H1((TextView) this.mSpecLayout.getChildAt(iIntValue), true);
            L1(buyCartProductVo, iIntValue, true);
        } else {
            if (i2 != -1) {
                TextView textView = (TextView) this.mSpecLayout.getChildAt(i2);
                this.F.get(this.B).setSelect(false);
                H1(textView, true);
            }
            H1((TextView) this.mSpecLayout.getChildAt(iIntValue), false);
            L1(buyCartProductVo, iIntValue, false);
            this.B = iIntValue;
        }
        buyCartProductVo.setSelect(!zIsSelect);
    }

    public final void H1(TextView textView, boolean z) {
        textView.setTextColor(z ? this.C : this.D);
        textView.setBackgroundResource(z ? R.drawable.bg_product_tag : R.drawable.bg_select_product_tag);
    }

    public final void I1() {
        this.mSpecView.setupData(-1, 1, 0);
        this.mSelectSpecNameTv.setText(R.string.title_select_spec);
        this.mLimitNumberTv.setVisibility(8);
        this.mSurplusNumberTv.setText("");
        this.mSpecCoverImg.loadAliImageToUrl(d.getInstance().getUrlToResourceVo(this.G.getUrl()));
        this.mSpecPriceTv.setText(x.getString(R.string.rmb_placeholder, this.G.getPriceSection()));
    }

    public final void L1(BuyCartProductVo buyCartProductVo, int i2, boolean z) {
        this.mSpecPriceTv.setText(x.getString(R.string.rmb_placeholder, x.bigDecimalToPlainString(buyCartProductVo.getCommoditySpecificationPrice())));
        boolean z2 = buyCartProductVo.getLimit() > 0;
        this.mSpecView.setupData(i2, 1, z2 ? Math.min(buyCartProductVo.getLimit(), buyCartProductVo.getSurplusNumber()) : buyCartProductVo.getSurplusNumber());
        this.mSelectSpecNameTv.setText(x.getNotNullStr(buyCartProductVo.getCommoditySpecificationName(), ""));
        this.mSurplusNumberTv.setText(x.getString(R.string.placeholder_surplus_number, String.valueOf(buyCartProductVo.getSurplusNumber())));
        this.mLimitNumberTv.setVisibility(z2 ? 0 : 8);
        this.mLimitNumberTv.setText(x.getString(R.string.placeholder_buy_limit, String.valueOf(buyCartProductVo.getLimit())));
        if (z) {
            I1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.btn_next) {
            n();
        } else {
            if (id != R.id.id_spec_tag) {
                return;
            }
            G1(view);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        ProductSpecVo productSpecVo = new ProductSpecVo();
        this.G = productSpecVo;
        productSpecVo.setName("冬季男装");
        this.G.setPriceSection("120-490");
        ResourceVo resourceVo = new ResourceVo();
        resourceVo.setUrl("https://img.alicdn.com/imgextra/i2/671012022/O1CN01OiDsXO1Qo7PfnMJph_!!671012022.jpg");
        this.G.setUrl(resourceVo);
        this.C = getResources().getColor(R.color.color000000);
        this.D = getResources().getColor(R.color.color_white);
        this.E = new LinearLayout.LayoutParams(-2, getResources().getDimensionPixelSize(R.dimen.dp_30));
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp_6);
        LinearLayout.LayoutParams layoutParams = this.E;
        layoutParams.bottomMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        this.mNextBtn.setOnClickListener(this.y);
        this.mSpecView.setOnClickListener(this.y);
        I1();
        E1();
    }

    @OnClick({R.id.img_close, R.id.view_transparent_bg})
    public void closeFragment(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_spec_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }
}
