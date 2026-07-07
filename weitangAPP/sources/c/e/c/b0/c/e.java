package c.e.c.b0.c;

import c.e.a.d.o;
import c.e.a.d.x;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.microtang.buycart.vo.BuyCartProductVo;
import com.chinavisionary.microtang.buycart.vo.BuyCartVo;
import com.chinavisionary.microtang.order.vo.KeyValueVo;
import com.chinavisionary.microtang.order.vo.OderSpecificationsVo;
import com.chinavisionary.microtang.order.vo.OrderMerchantCommodityVo;
import com.chinavisionary.microtang.order.vo.OrderVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static BuyCartVo a(OrderVo orderVo, OrderMerchantCommodityVo orderMerchantCommodityVo) {
        if (orderMerchantCommodityVo == null) {
            return null;
        }
        BuyCartVo buyCartVo = new BuyCartVo();
        if (orderVo.getType() == 1) {
            buyCartVo.setOrderState(b(orderVo.getOrderStatus()));
        }
        buyCartVo.setOrderStateName(orderVo.getOrderStatusName());
        buyCartVo.setMerchantKey(orderMerchantCommodityVo.getMerchantKey());
        buyCartVo.setMerchantName(orderMerchantCommodityVo.getMerchantName());
        buyCartVo.setMerchantLogo(orderMerchantCommodityVo.getMerchantCover());
        buyCartVo.setCommodities(commoditySpecsToBuyCartProduct(orderMerchantCommodityVo.getSpecifications()));
        buyCartVo.setItemType(2234);
        buyCartVo.setSpecCount(orderVo.getCommodityNumber());
        buyCartVo.setTotalAmount(orderVo.getTotalAmount());
        buyCartVo.setBaseKey(orderVo.getKey());
        return buyCartVo;
    }

    public static void addBuyCartVo(OrderVo orderVo, List<BuyCartVo> list) {
        List<OrderMerchantCommodityVo> details = orderVo.getDetails();
        if (o.isNotEmpty(details)) {
            boolean z = orderVo.getType() == 2;
            int size = details.size();
            for (int i2 = 0; i2 < size; i2++) {
                BuyCartVo buyCartVoA = a(orderVo, details.get(i2));
                buyCartVoA.setBill(z);
                if (z && i2 < size - 1) {
                    buyCartVoA.setHiedBottomLine(true);
                }
                list.add(buyCartVoA);
            }
        }
    }

    public static int b(int i2) {
        return i2 != 4002 ? 4 : 5;
    }

    public static String c(List<String> list) {
        if (!o.isNotEmpty(list)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(list.size() * 2);
        for (String str : list) {
            if (x.isNotNull(str)) {
                sb.append(str);
                sb.append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static List<BuyCartProductVo> commoditySpecsToBuyCartProduct(List<OderSpecificationsVo> list) {
        if (!o.isNotEmpty(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (OderSpecificationsVo oderSpecificationsVo : list) {
            if (oderSpecificationsVo != null) {
                BuyCartProductVo buyCartProductVo = new BuyCartProductVo();
                buyCartProductVo.setCommodityKey(oderSpecificationsVo.getCommodityKey());
                buyCartProductVo.setQuantity(oderSpecificationsVo.getSpecificationsNumber());
                buyCartProductVo.setCommoditySpecificationName(c(oderSpecificationsVo.getSpecificationsTagName()));
                buyCartProductVo.setCommodityCover(oderSpecificationsVo.getSpecificationsCover());
                buyCartProductVo.setCommoditySpecificationKey(oderSpecificationsVo.getSpecificationsKey());
                buyCartProductVo.setCommoditySpecificationPrice(oderSpecificationsVo.getPrice());
                buyCartProductVo.setCommodityName(oderSpecificationsVo.getCommodityName());
                arrayList.add(buyCartProductVo);
            }
        }
        return arrayList;
    }

    public static List<LeftTitleToRightArrowVo> keyValueToLeftTitleToRightArrowVo(List<KeyValueVo> list) {
        if (!o.isNotEmpty(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (KeyValueVo keyValueVo : list) {
            if (keyValueVo != null && x.isNotNull(keyValueVo.getKey()) && x.isNotNull(keyValueVo.getValue())) {
                LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
                leftTitleToRightArrowVo.setLeft(keyValueVo.getKey());
                leftTitleToRightArrowVo.setRight(keyValueVo.getValue());
                arrayList.add(leftTitleToRightArrowVo);
            }
        }
        return arrayList;
    }
}
