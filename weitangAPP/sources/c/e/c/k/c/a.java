package c.e.c.k.c;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import c.e.a.d.o;
import c.e.a.d.x;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.buycart.model.BuyCartModel;
import com.chinavisionary.microtang.buycart.vo.BuyCartProductVo;
import com.chinavisionary.microtang.buycart.vo.BuyCartSelectResultVo;
import com.chinavisionary.microtang.buycart.vo.BuyCartVo;
import com.chinavisionary.microtang.buycart.vo.RequestDelBuyCartBo;
import com.chinavisionary.microtang.buycart.vo.RequestUpdateBuyCartBo;
import com.chinavisionary.microtang.order.vo.KeyValueVo;
import com.chinavisionary.microtang.room.vo.SaleVo;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppCompatCheckBox f1640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f1641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BuyCartModel f1642c;

    public a(AppCompatCheckBox appCompatCheckBox, TextView textView) {
        this.f1640a = appCompatCheckBox;
        this.f1641b = textView;
    }

    public static List<BuyCartVo> test() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 5; i2++) {
            BuyCartVo buyCartVo = new BuyCartVo();
            if (i2 == 0) {
                buyCartVo.setItemType(2234);
                buyCartVo.setHiedBottomLine(true);
            }
            if (i2 == 1) {
                buyCartVo.setItemType(2234);
                buyCartVo.setHiedBottomLine(false);
            }
            buyCartVo.setMerchantName("微棠格" + i2);
            ResourceVo resourceVo = new ResourceVo();
            resourceVo.setUrl("https://chinavisionary-test.oss-cn-beijing.aliyuncs.com/null[-]1578994099699[-]20190930107768.jpeg");
            buyCartVo.setCover(resourceVo);
            buyCartVo.setKey("23key" + i2);
            ResourceVo resourceVo2 = new ResourceVo();
            resourceVo2.setUrl("https://chinavisionary-test.oss-cn-beijing.aliyuncs.com/null[-]1579070578306[-]timg.jpeg");
            buyCartVo.setMerchantLogo(resourceVo2);
            ArrayList arrayList2 = new ArrayList();
            KeyValueVo keyValueVo = new KeyValueVo();
            keyValueVo.setValue("8.00");
            keyValueVo.setKey("快递费");
            arrayList2.add(keyValueVo);
            KeyValueVo keyValueVo2 = new KeyValueVo();
            keyValueVo2.setValue("5.00");
            keyValueVo2.setKey("包装费");
            arrayList2.add(keyValueVo2);
            KeyValueVo keyValueVo3 = new KeyValueVo();
            keyValueVo3.setValue("128.30");
            keyValueVo3.setKey("合计");
            arrayList2.add(keyValueVo3);
            buyCartVo.setFeesBeans(arrayList2);
            ArrayList arrayList3 = new ArrayList();
            for (int i3 = 0; i3 < 2; i3++) {
                BuyCartProductVo buyCartProductVo = new BuyCartProductVo();
                buyCartProductVo.setCommodityName("奶茶不耐喝 " + i3);
                buyCartProductVo.setCommoditySpecificationPrice(new BigDecimal(i3 + 123 + i2));
                buyCartProductVo.setSurplusNumber(i2 + 10);
                buyCartProductVo.setCommoditySpecificationName("一小时服务 :" + i3 + i2);
                buyCartProductVo.setCommodityKey("222" + i3 + i2);
                buyCartProductVo.setQuantity(1);
                SaleVo saleVo = new SaleVo();
                saleVo.setName("优惠金额10" + i3);
                saleVo.setKey(OperatorName.SET_FLATNESS + i3);
                buyCartProductVo.setCommodityCover(resourceVo2);
                arrayList3.add(buyCartProductVo);
            }
            buyCartVo.setCommodities(arrayList3);
            arrayList.add(buyCartVo);
        }
        return arrayList;
    }

    public final void a(List<BuyCartVo> list) {
        if (o.isNotEmpty(list)) {
            BigDecimal bigDecimal = new BigDecimal("0.0");
            Iterator<BuyCartVo> it = list.iterator();
            while (it.hasNext()) {
                List<BuyCartProductVo> commodities = it.next().getCommodities();
                if (o.isNotEmpty(commodities)) {
                    for (BuyCartProductVo buyCartProductVo : commodities) {
                        if (buyCartProductVo != null && buyCartProductVo.isSelect()) {
                            bigDecimal = x.bigDecimalAddToBigDecimal(bigDecimal, x.bigDecimalMultiplyToBigDecimal(buyCartProductVo.getCommoditySpecificationPrice(), new BigDecimal(buyCartProductVo.getQuantity())));
                        }
                    }
                }
            }
            e(bigDecimal);
        }
    }

    public final void b(String str) {
        RequestDelBuyCartBo requestDelBuyCartBo = new RequestDelBuyCartBo();
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        requestDelBuyCartBo.setCartKeys(arrayList);
        this.f1642c.delBuyCart(requestDelBuyCartBo);
    }

    public final BuyCartSelectResultVo c(List<BuyCartVo> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        BuyCartSelectResultVo buyCartSelectResultVo = new BuyCartSelectResultVo();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (BuyCartVo buyCartVo : list) {
            if (buyCartVo != null) {
                List<BuyCartProductVo> commodities = buyCartVo.getCommodities();
                ArrayList arrayList3 = new ArrayList();
                if (commodities != null && !commodities.isEmpty()) {
                    for (BuyCartProductVo buyCartProductVo : commodities) {
                        if (buyCartProductVo != null && buyCartProductVo.isSelect()) {
                            arrayList3.add(buyCartProductVo);
                            String cartKey = buyCartProductVo.getCartKey();
                            if (x.isNotNull(cartKey)) {
                                arrayList2.add(cartKey);
                            }
                        }
                    }
                }
                if (!arrayList3.isEmpty()) {
                    BuyCartVo buyCartVoM70clone = buyCartVo.m70clone();
                    buyCartVoM70clone.setCommodities(arrayList3);
                    arrayList.add(buyCartVoM70clone);
                }
            }
        }
        buyCartSelectResultVo.setBuyCartVoList(arrayList);
        buyCartSelectResultVo.setSpecKeyList(arrayList2);
        return buyCartSelectResultVo;
    }

    public final void d(boolean z, boolean z2, List<BuyCartVo> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            BuyCartVo buyCartVo = list.get(i3);
            boolean zIsSelect = buyCartVo.isSelect();
            if (!z2) {
                buyCartVo.setSelect(z);
                f(z, buyCartVo.getCommodities());
            } else if (zIsSelect) {
                i2++;
            }
        }
        if (z2) {
            this.f1640a.setChecked(i2 == size);
        }
        a(list);
    }

    public final void e(BigDecimal bigDecimal) {
        this.f1641b.setText(x.getString(R.string.placeholder_rmb_china_unit, x.bigDecimalToPlainString(bigDecimal)));
    }

    public final void f(boolean z, List<BuyCartProductVo> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<BuyCartProductVo> it = list.iterator();
        while (it.hasNext()) {
            it.next().setSelect(z);
        }
    }

    public final void g(BuyCartProductVo buyCartProductVo) {
        RequestUpdateBuyCartBo requestUpdateBuyCartBo = new RequestUpdateBuyCartBo();
        requestUpdateBuyCartBo.setCartKey(buyCartProductVo.getCartKey());
        requestUpdateBuyCartBo.setQuantity(buyCartProductVo.getQuantity());
        this.f1642c.updateBuyCart(requestUpdateBuyCartBo);
    }

    public List<BuyCartVo> getSelectProductList(List<BuyCartVo> list) {
        BuyCartSelectResultVo buyCartSelectResultVoC = c(list);
        if (buyCartSelectResultVoC != null) {
            return buyCartSelectResultVoC.getBuyCartVoList();
        }
        return null;
    }

    public List<String> getSelectSpecKey(List<BuyCartVo> list) {
        BuyCartSelectResultVo buyCartSelectResultVoC = c(list);
        if (buyCartSelectResultVoC != null) {
            return buyCartSelectResultVoC.getSpecKeyList();
        }
        return null;
    }

    public void handleAddOrReduceSpecNumber(View view, boolean z, BaseRecyclerAdapter<BuyCartVo> baseRecyclerAdapter) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        int iIntValue2 = ((Integer) view.getTag(view.getId())).intValue();
        BuyCartProductVo buyCartProductVo = baseRecyclerAdapter.getList().get(iIntValue).getCommodities().get(iIntValue2);
        int iMin = buyCartProductVo.getLimit() > 0 ? Math.min(buyCartProductVo.getLimit(), buyCartProductVo.getSurplusNumber()) : buyCartProductVo.getSurplusNumber();
        int quantity = buyCartProductVo.getQuantity();
        if (z) {
            int i2 = quantity + 1;
            if (i2 <= iMin) {
                iMin = i2;
            }
        } else {
            iMin = quantity - 1;
        }
        if (iMin < 1) {
            b(buyCartProductVo.getCartKey());
            baseRecyclerAdapter.getList().remove(iIntValue);
            baseRecyclerAdapter.notifyItemRemoved(iIntValue);
        } else {
            buyCartProductVo.setQuantity(iMin);
            baseRecyclerAdapter.getList().get(iIntValue).getCommodities().get(iIntValue2).setQuantity(iMin);
            g(buyCartProductVo);
        }
        a(baseRecyclerAdapter.getList());
    }

    public void handleAllSelect(boolean z, BaseRecyclerAdapter<BuyCartVo> baseRecyclerAdapter) {
        d(z, false, baseRecyclerAdapter.getList());
        baseRecyclerAdapter.notifyDataSetChanged();
    }

    public void handleCbProductBusiness(View view, BaseRecyclerAdapter<BuyCartVo> baseRecyclerAdapter) {
        boolean zIsChecked = ((AppCompatCheckBox) view).isChecked();
        int iIntValue = ((Integer) view.getTag()).intValue();
        int iIntValue2 = ((Integer) view.getTag(view.getId())).intValue();
        List<BuyCartProductVo> commodities = baseRecyclerAdapter.getList().get(iIntValue).getCommodities();
        if (commodities != null && !commodities.isEmpty()) {
            int size = commodities.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                BuyCartProductVo buyCartProductVo = commodities.get(i3);
                if (i3 == iIntValue2) {
                    buyCartProductVo.setSelect(zIsChecked);
                }
                if (buyCartProductVo.isSelect()) {
                    i2++;
                }
            }
            baseRecyclerAdapter.getList().get(iIntValue).setSelect(i2 == size);
            d(false, true, baseRecyclerAdapter.getList());
            a(baseRecyclerAdapter.getList());
        }
        baseRecyclerAdapter.notifyItemChanged(iIntValue);
    }

    public void handleSelectCartKey(List<BuyCartVo> list, List<BuyCartVo> list2) {
        List<String> selectSpecKey = getSelectSpecKey(list);
        if (!o.isNotEmpty(selectSpecKey) || !o.isNotEmpty(list2)) {
            if (o.isNotEmpty(list2)) {
                return;
            }
            resetSelect();
            return;
        }
        for (BuyCartVo buyCartVo : list2) {
            if (buyCartVo != null) {
                List<BuyCartProductVo> commodities = buyCartVo.getCommodities();
                if (o.isNotEmpty(commodities)) {
                    int i2 = 0;
                    int size = commodities.size();
                    for (BuyCartProductVo buyCartProductVo : commodities) {
                        if (buyCartProductVo != null && selectSpecKey.contains(buyCartProductVo.getCartKey())) {
                            i2++;
                            buyCartProductVo.setSelect(true);
                        }
                    }
                    if (i2 == size) {
                        buyCartVo.setSelect(true);
                    }
                }
            }
        }
        a(list2);
    }

    public void resetSelect() {
        this.f1640a.setChecked(false);
        e(new BigDecimal("0.0"));
    }

    public void selectAllBusinessProduct(View view, BaseRecyclerAdapter<BuyCartVo> baseRecyclerAdapter) {
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) view;
        int iIntValue = ((Integer) appCompatCheckBox.getTag()).intValue();
        boolean zIsChecked = appCompatCheckBox.isChecked();
        baseRecyclerAdapter.getList().get(iIntValue).setSelect(zIsChecked);
        f(zIsChecked, baseRecyclerAdapter.getList().get(iIntValue).getCommodities());
        d(false, true, baseRecyclerAdapter.getList());
        a(baseRecyclerAdapter.getList());
        baseRecyclerAdapter.notifyItemChanged(iIntValue);
    }

    public void setBuyCartModel(BuyCartModel buyCartModel) {
        this.f1642c = buyCartModel;
    }
}
