package com.chinavisionary.microtang.merchant.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.y.b.i;
import c.e.c.y.e.d;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.buycart.model.BuyCartModel;
import com.chinavisionary.microtang.buycart.vo.RequestAddBuyCartBo;
import com.chinavisionary.microtang.merchant.model.MerchantCommodityModel;
import com.chinavisionary.microtang.merchant.view.CommoditySpecLayout;
import com.chinavisionary.microtang.merchant.vo.CommodityVo;
import com.chinavisionary.microtang.merchant.vo.MerchantRightContentVo;
import com.chinavisionary.microtang.merchant.vo.SpecificationTagsVo;
import com.chinavisionary.microtang.merchant.vo.SpecificationsVo;
import com.chinavisionary.microtang.view.SpecView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class FoodSpecFragment extends BaseFragment {
    public d B;
    public int C;
    public BuyCartModel E;
    public MerchantCommodityModel F;
    public CommodityVo G;
    public SpecificationsVo H;
    public MerchantRightContentVo.FoodVo I;
    public CommodityVo J;

    @BindView(R.id.tv_add_spec_buy_cart)
    public TextView mAddBuyCartTv;

    @BindView(R.id.spec_food_add_reduce_view)
    public SpecView mAddReduceSpecView;

    @BindView(R.id.llayout_product_spec)
    public CommoditySpecLayout mCommoditySpecLayout;

    @BindView(R.id.tv_food_title)
    public TextView mFoodTitleTv;

    @BindView(R.id.tv_selected_spec_price)
    public TextView mSelectSpecPriceTv;

    @BindView(R.id.tv_selected_spec_value)
    public TextView mSelectSpecValueTv;
    public int D = -1;
    public Map<Integer, String> K = new HashMap();

    public static FoodSpecFragment getInstance(String str, int i2) {
        FoodSpecFragment foodSpecFragment = new FoodSpecFragment();
        foodSpecFragment.R1(i2);
        foodSpecFragment.setArguments(CoreBaseFragment.q(str));
        return foodSpecFragment;
    }

    public final void E1(String str) {
        q.d(getClass().getSimpleName(), "addToBuyCart getSpecificationKey:" + this.H.getSpecificationKey() + ", methodName:" + str);
        if (this.H != null) {
            RequestAddBuyCartBo requestAddBuyCartBo = new RequestAddBuyCartBo();
            requestAddBuyCartBo.setCommoditySpecificationKey(this.H.getSpecificationKey());
            requestAddBuyCartBo.setQuantity(this.H.getBuyNumber());
            this.E.addBuyCart(requestAddBuyCartBo);
        }
    }

    public final SpecificationsVo F1(List<SpecificationsVo> list, List<SpecificationTagsVo> list2) {
        SpecificationTagsVo specificationTagsVo;
        if (!o.isNotEmpty(list2) || !o.isNotEmpty(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (SpecificationTagsVo specificationTagsVo2 : list2) {
            if (specificationTagsVo2 != null && o.isNotEmpty(specificationTagsVo2.getSubSpecificationTags()) && (specificationTagsVo = (SpecificationTagsVo) o.getFirstElement(specificationTagsVo2.getSubSpecificationTags())) != null && x.isNotNull(specificationTagsVo.getSpecificationTagKey())) {
                arrayList.add(specificationTagsVo.getSpecificationTagKey());
            }
        }
        return H1(arrayList);
    }

    public final List<String> G1(CommodityVo commodityVo) {
        List<String> tagKeys = this.H.getTagKeys();
        if (!o.isNotEmpty(tagKeys)) {
            tagKeys = I1(this.H.getSpecificationKey(), commodityVo.getSpecifications());
            if (o.isNotEmpty(tagKeys)) {
                this.H.setTagKeys(tagKeys);
            }
        }
        return tagKeys;
    }

    public final SpecificationsVo H1(List<String> list) {
        List<SpecificationsVo> specifications = this.G.getSpecifications();
        if (!o.isNotEmpty(specifications)) {
            return null;
        }
        for (SpecificationsVo specificationsVo : specifications) {
            List<String> tagKeys = specificationsVo.getTagKeys();
            if (o.isNotEmpty(tagKeys)) {
                int size = tagKeys.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (list.contains(tagKeys.get(i3))) {
                        i2++;
                    }
                }
                q.d(getClass().getSimpleName(), "select :" + i2);
                if (i2 == size) {
                    return specificationsVo;
                }
            }
        }
        return null;
    }

    public final List<String> I1(String str, List<SpecificationsVo> list) {
        for (SpecificationsVo specificationsVo : list) {
            if (specificationsVo != null && str.equals(specificationsVo.getSpecificationKey())) {
                return specificationsVo.getTagKeys();
            }
        }
        return null;
    }

    public final void J1(View view, boolean z) {
        int iIntValue = ((Integer) view.getTag(R.id.tv_spec_number)).intValue();
        if (!m1()) {
            this.mAddReduceSpecView.setupSpecNumber(z ? iIntValue - 1 : iIntValue + 1);
            return;
        }
        q.d(getClass().getSimpleName(), "handleAddReduceSpec spec key: " + this.H.getSpecificationKey());
        SpecificationsVo specificationsVo = this.H;
        if (specificationsVo == null) {
            this.mAddReduceSpecView.setupSpecNumber(z ? iIntValue - 1 : iIntValue + 1);
            F0(R.string.tip_select_spec);
            return;
        }
        specificationsVo.setBuyNumber(iIntValue);
        E1("handleAddReduceSpec");
        if (iIntValue == 0) {
            U1(false);
            this.mAddReduceSpecView.setupSpecNumber(1);
        }
    }

    public final void K1(ResponseStateVo responseStateVo) {
        if (responseStateVo != null) {
            d dVar = this.B;
            if (dVar != null) {
                dVar.updateToPositionSelectedSpec(this.C, this.H);
            }
            Y1();
        }
    }

    public final void L1() {
        q.d(getClass().getSimpleName(), "handleAddSpecToBuyCard ");
        SpecificationsVo specificationsVo = this.H;
        if (specificationsVo == null) {
            q.d(getClass().getSimpleName(), "handleAddSpecToBuyCard select spec");
            F0(R.string.tip_select_spec);
        } else {
            specificationsVo.setBuyNumber(1);
            W1();
            E1("handleAddSpecToBuyCard");
        }
    }

    public final void M1(CommodityVo commodityVo) {
        H();
        this.G = commodityVo;
        this.K.clear();
        if (commodityVo != null) {
            X1(commodityVo);
            this.mFoodTitleTv.setText(commodityVo.getTitle());
            List<SpecificationTagsVo> specificationTags = commodityVo.getSpecificationTags();
            List<String> arrayList = new ArrayList<>();
            if (this.H == null) {
                this.H = F1(commodityVo.getSpecifications(), specificationTags);
            }
            if (this.H != null) {
                arrayList = G1(commodityVo);
                Z1(this.H);
            }
            this.mCommoditySpecLayout.setSpecificationTags(specificationTags, arrayList, this.y);
        }
    }

    public final void N1(View view) {
        if (m1()) {
            int iIntValue = ((Integer) view.getTag(R.id.id_spec_tag)).intValue();
            int iIntValue2 = ((Integer) view.getTag(R.id.id_spec_column_tag)).intValue();
            q.d(getClass().getSimpleName(), "tagList :" + iIntValue + ", j" + iIntValue2);
            this.mCommoditySpecLayout.updateSpecTagSelState(iIntValue, iIntValue2);
            W1();
        }
    }

    public final void R1(int i2) {
        this.C = i2;
    }

    public final void S1() {
        BuyCartModel buyCartModel = (BuyCartModel) h(BuyCartModel.class);
        this.E = buyCartModel;
        buyCartModel.getAddResult().observe(this, new Observer() { // from class: c.e.c.y.b.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2235a.K1((ResponseStateVo) obj);
            }
        });
        this.E.getErrRequestLiveData().observe(this, new i(this));
    }

    public final void T1() {
        MerchantCommodityModel merchantCommodityModel = (MerchantCommodityModel) h(MerchantCommodityModel.class);
        this.F = merchantCommodityModel;
        merchantCommodityModel.getCommodityResult().observe(this, new Observer() { // from class: c.e.c.y.b.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2234a.M1((CommodityVo) obj);
            }
        });
        this.F.getErrRequestLiveData().observe(this, new i(this));
    }

    public final void U1(boolean z) {
        this.mAddReduceSpecView.setVisibility(z ? 0 : 8);
        this.mAddBuyCartTv.setVisibility(z ? 8 : 0);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        switch (view.getId()) {
            case R.id.id_spec_tag /* 2131231172 */:
                q.d(getClass().getSimpleName(), "id_spec_tag ");
                N1(view);
                break;
            case R.id.img_add_spec /* 2131231181 */:
            case R.id.img_btn_add /* 2131231196 */:
                q.d(getClass().getSimpleName(), "img_add_spec ");
                J1(view, true);
                break;
            case R.id.img_btn_reduce /* 2131231200 */:
                q.d(getClass().getSimpleName(), "img_btn_reduce ");
                J1(view, false);
                break;
        }
    }

    public final void V1(List<SpecificationsVo> list, List<SpecificationsVo> list2) {
        for (SpecificationsVo specificationsVo : list) {
            if (specificationsVo != null && specificationsVo.getBuyNumber() > 0) {
                String specificationKey = specificationsVo.getSpecificationKey();
                if (x.isNotNull(specificationKey)) {
                    for (SpecificationsVo specificationsVo2 : list2) {
                        if (specificationsVo2 != null && specificationKey.equals(specificationsVo2.getSpecificationKey())) {
                            specificationsVo2.setBuyNumber(specificationsVo.getBuyNumber());
                        }
                    }
                }
            }
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        S1();
        T1();
        Z1(this.H);
        this.mAddReduceSpecView.setMinSelectNumber(0);
        this.mAddReduceSpecView.setOnClickListener(this.y);
        z0(R.string.loading_text);
        j0();
    }

    public final void W1() {
        q.d(getClass().getSimpleName(), "updateSelectSpec ");
        List<String> selectTagKeys = this.mCommoditySpecLayout.getSelectTagKeys();
        q.d(getClass().getSimpleName(), "tagList :" + JSON.toJSONString(selectTagKeys));
        SpecificationsVo specificationsVoH1 = H1(selectTagKeys);
        this.H = specificationsVoH1;
        Z1(specificationsVoH1);
        q.d(getClass().getSimpleName(), "updateSelectSpec spec key: " + this.H.getSpecificationKey());
    }

    public final void X1(CommodityVo commodityVo) {
        if (commodityVo != null) {
            List<SpecificationsVo> specifications = commodityVo.getSpecifications();
            MerchantRightContentVo.FoodVo foodVo = this.I;
            if (foodVo != null && foodVo.getBuyNumber() > 0) {
                V1(this.I.getSpecifications(), specifications);
            }
            CommodityVo commodityVo2 = this.J;
            if (commodityVo2 == null || commodityVo2.getBuyNumber() <= 0) {
                return;
            }
            V1(this.J.getSpecifications(), specifications);
        }
    }

    public final void Y1() {
        List<SpecificationsVo> specifications = this.G.getSpecifications();
        SpecificationsVo specificationsVo = this.H;
        if (specificationsVo == null || !x.isNotNull(specificationsVo.getSpecificationKey())) {
            return;
        }
        String specificationKey = this.H.getSpecificationKey();
        for (SpecificationsVo specificationsVo2 : specifications) {
            if (specificationsVo2 != null && specificationKey.equals(specificationsVo2.getSpecificationKey())) {
                specificationsVo2.setBuyNumber(this.H.getBuyNumber());
            }
        }
    }

    public final void Z1(SpecificationsVo specificationsVo) {
        if (specificationsVo != null) {
            this.mSelectSpecValueTv.setText(specificationsVo.getSpecificationTitle());
            this.mSelectSpecPriceTv.setText(x.bigDecimalToPlainStringAddUnit(specificationsVo.getPrice()));
            this.mAddReduceSpecView.setupIndex(this.D);
            this.mAddReduceSpecView.setupData(this.D, specificationsVo.getBuyNumber(), specificationsVo.getStock());
            U1(specificationsVo.getBuyNumber() > 0);
        }
    }

    @OnClick({R.id.tv_add_spec_buy_cart})
    public void addBuyCart() {
        if (m1()) {
            L1();
        }
    }

    @OnClick({R.id.view_food_spec_layout})
    public void finishFragment(View view) {
        g0();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_food_spec_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.F.getCommodityDetails(this.f6484b);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.J = null;
        this.I = null;
        this.H = null;
    }

    public void setCommoditySelectSpecVo(SpecificationsVo specificationsVo) {
        this.H = specificationsVo;
    }

    public void setFoodVo(MerchantRightContentVo.FoodVo foodVo) {
        this.I = foodVo;
    }

    public void setIFoodSpecUpdateCallback(d dVar) {
        this.B = dVar;
    }

    public void setSelCommodityVo(CommodityVo commodityVo) {
        this.J = commodityVo;
    }
}
