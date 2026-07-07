package c.e.c.y.c;

import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.microtang.buycart.vo.BuyCartProductVo;
import com.chinavisionary.microtang.buycart.vo.BuyCartVo;
import com.chinavisionary.microtang.merchant.vo.MerchantCommodityVo;
import com.chinavisionary.microtang.merchant.vo.MerchantProductVo;
import com.chinavisionary.microtang.merchant.vo.MerchantRightContentVo;
import com.chinavisionary.microtang.merchant.vo.SpecificationsVo;
import com.chinavisionary.microtang.repair.vo.RepairLeftVo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g {
    public final void a(MerchantCommodityVo merchantCommodityVo, MerchantRightContentVo.FoodVo foodVo) {
        foodVo.setRecommendTagList(merchantCommodityVo.getSpecificationTags());
    }

    public final MerchantRightContentVo.FoodVo b(MerchantCommodityVo merchantCommodityVo) {
        MerchantRightContentVo.FoodVo foodVo = new MerchantRightContentVo.FoodVo();
        foodVo.setBaseKey(merchantCommodityVo.getCommodityKey());
        foodVo.setProductKey(merchantCommodityVo.getCommodityKey());
        foodVo.setCoverRes(merchantCommodityVo.getCover());
        foodVo.setSpecifications(merchantCommodityVo.getSpecifications());
        foodVo.setMonthSaleVolume(merchantCommodityVo.getSellAmount());
        foodVo.setPrice(merchantCommodityVo.getPrice());
        foodVo.setTitle(merchantCommodityVo.getTitle());
        return foodVo;
    }

    public final MerchantRightContentVo c(MerchantProductVo merchantProductVo, int i2) {
        MerchantRightContentVo merchantRightContentVo = new MerchantRightContentVo();
        merchantRightContentVo.setTitle(merchantProductVo.getName());
        merchantRightContentVo.setTitlePosition(i2);
        merchantRightContentVo.setItemType(101);
        return merchantRightContentVo;
    }

    public final MerchantRightContentVo d(MerchantCommodityVo merchantCommodityVo) {
        MerchantRightContentVo merchantRightContentVo = new MerchantRightContentVo();
        merchantRightContentVo.setBaseKey(merchantCommodityVo.getCommodityKey());
        merchantRightContentVo.setTitle(merchantCommodityVo.getTitle());
        merchantRightContentVo.setItemType(102);
        return merchantRightContentVo;
    }

    public final void e(MerchantCommodityVo merchantCommodityVo, MerchantRightContentVo.FoodVo foodVo) {
        SpecificationsVo specificationsVo;
        List<SpecificationsVo> specifications = merchantCommodityVo.getSpecifications();
        if (o.isNotEmpty(specifications)) {
            z = specifications.size() > 1;
            if (!z && (specificationsVo = (SpecificationsVo) o.getFirstElement(specifications)) != null) {
                foodVo.setMaxLimit(specificationsVo.getStock());
            }
        }
        foodVo.setMultiSpec(z);
    }

    public final void f(MerchantProductVo merchantProductVo, List<MerchantRightContentVo> list) {
        for (MerchantCommodityVo merchantCommodityVo : merchantProductVo.getCommodities()) {
            if (merchantCommodityVo != null) {
                MerchantRightContentVo merchantRightContentVoD = d(merchantCommodityVo);
                MerchantRightContentVo.FoodVo foodVoB = b(merchantCommodityVo);
                a(merchantCommodityVo, foodVoB);
                e(merchantCommodityVo, foodVoB);
                merchantRightContentVoD.setFoodVo(foodVoB);
                list.add(merchantRightContentVoD);
            }
        }
    }

    public final void g(List<MerchantRightContentVo> list) {
        MerchantRightContentVo.FoodVo foodVo;
        if (o.isNotEmpty(list)) {
            for (MerchantRightContentVo merchantRightContentVo : list) {
                if (merchantRightContentVo != null && (foodVo = merchantRightContentVo.getFoodVo()) != null) {
                    foodVo.setBuyNumber(0);
                    i(new HashMap(), foodVo);
                }
            }
        }
    }

    public final void h(Map<String, Integer> map, Map<String, Integer> map2, List<MerchantRightContentVo> list) {
        for (MerchantRightContentVo merchantRightContentVo : list) {
            if (merchantRightContentVo != null && merchantRightContentVo.getFoodVo() != null) {
                MerchantRightContentVo.FoodVo foodVo = merchantRightContentVo.getFoodVo();
                if (map.containsKey(foodVo.getProductKey())) {
                    Integer num = map.get(foodVo.getProductKey());
                    if (num == null) {
                        num = 0;
                    }
                    foodVo.setBuyNumber(num.intValue());
                    i(map2, foodVo);
                } else {
                    foodVo.setBuyNumber(0);
                    i(new HashMap(), foodVo);
                }
            }
        }
    }

    public List<RepairLeftVo> handleMerchantProductResult(ResponseRowsVo<MerchantProductVo> responseRowsVo, BaseRecyclerAdapter<MerchantRightContentVo> baseRecyclerAdapter) {
        if (responseRowsVo == null || !responseRowsVo.getSuccess()) {
            baseRecyclerAdapter.initListData(null);
        } else {
            List<MerchantProductVo> rows = responseRowsVo.getRows();
            if (o.isNotEmpty(rows)) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int size = rows.size();
                int size2 = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    MerchantProductVo merchantProductVo = rows.get(i2);
                    RepairLeftVo repairLeftVo = new RepairLeftVo();
                    repairLeftVo.setTitle(merchantProductVo.getName());
                    repairLeftVo.setRelationPosition(size2);
                    arrayList.add(repairLeftVo);
                    size2 += merchantProductVo.getCommodities().size() + 1;
                    arrayList2.add(c(merchantProductVo, i2));
                    f(merchantProductVo, arrayList2);
                }
                baseRecyclerAdapter.initListData(arrayList2);
                return arrayList;
            }
            baseRecyclerAdapter.initListData(null);
        }
        return null;
    }

    public final void i(Map<String, Integer> map, MerchantRightContentVo.FoodVo foodVo) {
        List<SpecificationsVo> specifications = foodVo.getSpecifications();
        if (o.isNotEmpty(specifications)) {
            for (SpecificationsVo specificationsVo : specifications) {
                if (specificationsVo != null && map.containsKey(specificationsVo.getSpecificationKey())) {
                    Integer num = map.get(specificationsVo.getSpecificationKey());
                    if (num == null) {
                        num = 0;
                    }
                    specificationsVo.setBuyNumber(num.intValue());
                    foodVo.setSelectSpec(specificationsVo);
                } else if (specificationsVo != null) {
                    specificationsVo.setBuyNumber(0);
                }
            }
        }
    }

    public void matchBuyCartProductList(List<BuyCartVo> list, BaseRecyclerAdapter<MerchantRightContentVo> baseRecyclerAdapter) {
        List<MerchantRightContentVo> list2 = baseRecyclerAdapter.getList();
        if (!o.isNotEmpty(list)) {
            g(list2);
        } else if (o.isNotEmpty(list2)) {
            BuyCartVo buyCartVo = (BuyCartVo) o.getFirstElement(list);
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            if (buyCartVo != null) {
                for (BuyCartProductVo buyCartProductVo : buyCartVo.getCommodities()) {
                    if (buyCartProductVo != null && x.isNotNull(buyCartProductVo.getCommodityKey()) && x.isNotNull(buyCartProductVo.getCommoditySpecificationKey())) {
                        String commoditySpecificationKey = buyCartProductVo.getCommoditySpecificationKey();
                        String commodityKey = buyCartProductVo.getCommodityKey();
                        if (map.containsKey(commodityKey)) {
                            Integer numValueOf = map.get(commodityKey);
                            if (numValueOf != null) {
                                numValueOf = Integer.valueOf(numValueOf.intValue() + buyCartProductVo.getQuantity());
                            }
                            map.put(commodityKey, numValueOf);
                        } else {
                            map.put(commodityKey, Integer.valueOf(buyCartProductVo.getQuantity()));
                        }
                        map2.put(commoditySpecificationKey, Integer.valueOf(buyCartProductVo.getQuantity()));
                        q.d(g.class.getSimpleName(), "specKey :" + commoditySpecificationKey + ",quantity:" + buyCartProductVo.getQuantity());
                    }
                }
                h(map, map2, list2);
            } else {
                g(list2);
            }
        }
        baseRecyclerAdapter.notifyDataSetChanged();
    }
}
