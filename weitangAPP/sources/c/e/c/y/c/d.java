package c.e.c.y.c;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import c.e.a.d.o;
import c.e.a.d.x;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.microtang.buycart.model.BuyCartModel;
import com.chinavisionary.microtang.buycart.vo.BuyCartProductVo;
import com.chinavisionary.microtang.buycart.vo.BuyCartVo;
import com.chinavisionary.microtang.buycart.vo.RequestAddBuyCartBo;
import com.chinavisionary.microtang.merchant.vo.BuyCartCountVo;
import com.chinavisionary.microtang.merchant.vo.CommodityVo;
import com.chinavisionary.microtang.merchant.vo.MerchantRightContentVo;
import com.chinavisionary.microtang.merchant.vo.SpecificationsVo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c.e.c.y.e.b f2253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BuyCartModel f2254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2255c;

    public d(c.e.c.y.e.b bVar, String str) {
        this.f2253a = bVar;
        this.f2255c = str;
        Fragment currentFragment = bVar.getCurrentFragment();
        BuyCartModel buyCartModel = (BuyCartModel) ViewModelProviders.of(currentFragment).get(BuyCartModel.class);
        this.f2254b = buyCartModel;
        buyCartModel.getAddResult().observe(currentFragment, new Observer() { // from class: c.e.c.y.c.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2250a.e((ResponseStateVo) obj);
            }
        });
        this.f2254b.getMerchantBuyCartResult().observe(currentFragment, new Observer() { // from class: c.e.c.y.c.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2251a.g((ResponseRowsVo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(ResponseStateVo responseStateVo) {
        getBuyCartToMerchantKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(ResponseRowsVo responseRowsVo) {
        if (responseRowsVo != null) {
            a(responseRowsVo.getRows());
        }
    }

    public final void a(List<BuyCartVo> list) {
        BigDecimal bigDecimal = new BigDecimal("0.0");
        int i2 = 0;
        if (!o.isNotEmpty(list)) {
            BuyCartCountVo buyCartCountVo = new BuyCartCountVo();
            buyCartCountVo.setBuyCountPrice(bigDecimal);
            buyCartCountVo.setBuyCount(0);
            h(null, buyCartCountVo);
            return;
        }
        BuyCartVo buyCartVo = (BuyCartVo) o.getFirstElement(list);
        if (buyCartVo != null) {
            for (BuyCartProductVo buyCartProductVo : buyCartVo.getCommodities()) {
                int quantity = buyCartProductVo.getQuantity();
                i2 += quantity;
                bigDecimal = x.bigDecimalAddToBigDecimal(bigDecimal, x.bigDecimalMultiplyToBigDecimal(buyCartProductVo.getCommoditySpecificationPrice(), new BigDecimal(quantity)));
            }
            BuyCartCountVo buyCartCountVo2 = new BuyCartCountVo();
            buyCartCountVo2.setBuyCountPrice(bigDecimal);
            buyCartCountVo2.setBuyCount(i2);
            h(list, buyCartCountVo2);
        }
    }

    public void addToBuyCart(SpecificationsVo specificationsVo) {
        RequestAddBuyCartBo requestAddBuyCartBo = new RequestAddBuyCartBo();
        requestAddBuyCartBo.setCommoditySpecificationKey(specificationsVo.getSpecificationKey());
        requestAddBuyCartBo.setQuantity(specificationsVo.getBuyNumber());
        this.f2254b.addBuyCart(requestAddBuyCartBo);
    }

    public final List<String> b(CommodityVo commodityVo) {
        ArrayList arrayList = new ArrayList();
        if (commodityVo != null) {
            List<SpecificationsVo> specifications = commodityVo.getSpecifications();
            if (o.isNotEmpty(specifications)) {
                for (SpecificationsVo specificationsVo : specifications) {
                    if (specificationsVo != null) {
                        String specificationKey = specificationsVo.getSpecificationKey();
                        if (x.isNotNull(specificationKey)) {
                            arrayList.add(specificationKey);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final void c(CommodityVo commodityVo) {
        if (commodityVo != null) {
            commodityVo.setBuyNumber(0);
            List<SpecificationsVo> specifications = commodityVo.getSpecifications();
            if (o.isNotEmpty(specifications)) {
                for (SpecificationsVo specificationsVo : specifications) {
                    if (specificationsVo != null) {
                        specificationsVo.setBuyNumber(0);
                    }
                }
            }
        }
    }

    public SpecificationsVo getBuyCartToCommodity(List<BuyCartVo> list, CommodityVo commodityVo) {
        SpecificationsVo specificationsVo = null;
        if (!o.isNotEmpty(list) || commodityVo == null) {
            c(commodityVo);
        } else {
            List<String> listB = b(commodityVo);
            int i2 = 0;
            for (BuyCartVo buyCartVo : list) {
                if (buyCartVo != null) {
                    List<BuyCartProductVo> commodities = buyCartVo.getCommodities();
                    if (o.isNotEmpty(commodities)) {
                        for (BuyCartProductVo buyCartProductVo : commodities) {
                            if (buyCartProductVo != null) {
                                String commoditySpecificationKey = buyCartProductVo.getCommoditySpecificationKey();
                                if (x.isNotNull(commoditySpecificationKey) && listB.contains(commoditySpecificationKey)) {
                                    specificationsVo = commodityVo.getSpecifications().get(listB.indexOf(commoditySpecificationKey));
                                    int quantity = buyCartProductVo.getQuantity();
                                    i2 += quantity;
                                    specificationsVo.setBuyNumber(quantity);
                                }
                            }
                        }
                    }
                }
            }
            commodityVo.setBuyNumber(i2);
        }
        return specificationsVo;
    }

    public void getBuyCartToMerchantKey() {
        this.f2254b.getMerchantBuyCartList(null, this.f2255c);
    }

    public BuyCartCountVo getProductPrice(List<MerchantRightContentVo> list) {
        MerchantRightContentVo.FoodVo foodVo;
        BuyCartCountVo buyCartCountVo = new BuyCartCountVo();
        if (!list.isEmpty()) {
            int i2 = 0;
            BigDecimal bigDecimal = new BigDecimal(0);
            for (MerchantRightContentVo merchantRightContentVo : list) {
                if (merchantRightContentVo.getItemType() == 102 && (foodVo = merchantRightContentVo.getFoodVo()) != null) {
                    int buyNumber = foodVo.getBuyNumber();
                    i2 += buyNumber;
                    bigDecimal = x.bigDecimalAddToBigDecimal(bigDecimal, x.bigDecimalMultiplyToBigDecimal(foodVo.getPrice(), new BigDecimal(buyNumber)));
                }
            }
            buyCartCountVo.setBuyCountPrice(bigDecimal);
            buyCartCountVo.setBuyCount(i2);
        }
        return buyCartCountVo;
    }

    public final void h(List<BuyCartVo> list, BuyCartCountVo buyCartCountVo) {
        c.e.c.y.e.b bVar = this.f2253a;
        if (bVar != null) {
            bVar.buyCartList(list);
            this.f2253a.setupBuyCartCountVo(buyCartCountVo);
        }
    }

    public int updateSpecToFoodVo(List<MerchantRightContentVo> list, BuyCartProductVo buyCartProductVo) {
        if (list != null && !list.isEmpty() && buyCartProductVo != null && x.isNotNull(buyCartProductVo.getCommodityKey())) {
            String commodityKey = buyCartProductVo.getCommodityKey();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                MerchantRightContentVo merchantRightContentVo = list.get(i2);
                if (merchantRightContentVo != null && commodityKey.equals(merchantRightContentVo.getBaseKey())) {
                    merchantRightContentVo.getFoodVo().setBuyNumber(buyCartProductVo.getQuantity());
                    return i2;
                }
            }
        }
        return -1;
    }
}
