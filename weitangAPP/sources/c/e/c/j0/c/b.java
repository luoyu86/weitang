package c.e.c.j0.c;

import c.e.a.d.x;
import c.e.a.d.z;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.main.vo.ResponseRentConfigFeeVo;
import com.chinavisionary.microtang.sign.vo.RentMethodVo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public final void a(List<LeftTitleToRightArrowVo> list, List<RentMethodVo> list2) {
        RentMethodVo rentMethodVo;
        if (list2 == null || list2.isEmpty() || (rentMethodVo = list2.get(0)) == null || rentMethodVo.getConfigItems() == null || rentMethodVo.getConfigItems().isEmpty()) {
            return;
        }
        list.addAll(rentMethodVo.getConfigItems());
    }

    public List<LeftTitleToRightArrowVo> getAdapterData(ResponseRentConfigFeeVo responseRentConfigFeeVo, int i2, Long l, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo.setTitle(true);
        leftTitleToRightArrowVo.setTitle(x.getString(R.string.title_details_info));
        arrayList.add(leftTitleToRightArrowVo);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo2.setLeft(x.getString(R.string.title_address));
        leftTitleToRightArrowVo2.setRight(responseRentConfigFeeVo.getAddress());
        arrayList.add(leftTitleToRightArrowVo2);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo3 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo3.setLeft(x.getString(R.string.title_rent_period));
        leftTitleToRightArrowVo3.setRight(responseRentConfigFeeVo.getRentDurationTypeName());
        if (responseRentConfigFeeVo.isShortRentSupport()) {
            leftTitleToRightArrowVo3.setShowArrow(true);
            leftTitleToRightArrowVo3.setOnlyKey(1);
        }
        arrayList.add(leftTitleToRightArrowVo3);
        List<RentMethodVo> rentMethodVoList = getRentMethodVoList(responseRentConfigFeeVo);
        String name = (rentMethodVoList == null || rentMethodVoList.isEmpty()) ? "" : rentMethodVoList.get(0).getName();
        LeftTitleToRightArrowVo leftTitleToRightArrowVo4 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo4.setLeft(x.getString(R.string.title_pay_method));
        leftTitleToRightArrowVo4.setRight(name);
        leftTitleToRightArrowVo4.setOnlyKey(i2);
        leftTitleToRightArrowVo4.setShowArrow(true);
        arrayList.add(leftTitleToRightArrowVo4);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo5 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo5.setLeft(x.getString(R.string.title_effect_time));
        StringBuilder sb = new StringBuilder();
        Long rentTermFrom = responseRentConfigFeeVo.getRentTermFrom();
        SimpleDateFormat simpleDateFormat = z.f1246g;
        sb.append(z.getTime(rentTermFrom, simpleDateFormat));
        sb.append("至");
        sb.append(z.getTime(responseRentConfigFeeVo.getRentTermTo(), simpleDateFormat));
        leftTitleToRightArrowVo5.setRight(sb.toString());
        arrayList.add(leftTitleToRightArrowVo5);
        if (z2) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo6 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo6.setLeft(x.getString(R.string.title_estimated_rent_time));
            if (l == null || l.longValue() <= 0) {
                leftTitleToRightArrowVo6.setRight(x.getString(R.string.hint_estimated_rent_time));
            } else {
                leftTitleToRightArrowVo6.setRight(z.getTimeYYMMDD(l));
            }
            leftTitleToRightArrowVo6.setOnlyKey(9);
            leftTitleToRightArrowVo6.setShowArrow(true);
            leftTitleToRightArrowVo6.setRequired(true);
            arrayList.add(leftTitleToRightArrowVo6);
        }
        LeftTitleToRightArrowVo leftTitleToRightArrowVo7 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo7.setTitle(x.getString(R.string.title_fee_item));
        leftTitleToRightArrowVo7.setTitle(true);
        arrayList.add(leftTitleToRightArrowVo7);
        if (x.isNotNull(responseRentConfigFeeVo.getRentDurationTypeDesc())) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo8 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo8.setLeft(x.getString(R.string.title_rent_up_fee));
            leftTitleToRightArrowVo8.setRight(responseRentConfigFeeVo.getRentDurationTypeDesc());
            arrayList.add(leftTitleToRightArrowVo8);
        }
        a(arrayList, rentMethodVoList);
        return arrayList;
    }

    public int getOnlyKeyToPosition(List<LeftTitleToRightArrowVo> list, int i2) {
        return LeftTitleToRightArrowVo.getOnlyKeyToPosition(list, i2);
    }

    public List<RentMethodVo> getRentMethodVoList(ResponseRentConfigFeeVo responseRentConfigFeeVo) {
        ArrayList arrayList = new ArrayList();
        List<ResponseRentConfigFeeVo.PaymentMethodsBean> paymentMethods = responseRentConfigFeeVo.getPaymentMethods();
        if (paymentMethods != null && !paymentMethods.isEmpty()) {
            int size = paymentMethods.size();
            int i2 = 0;
            while (i2 < size) {
                ResponseRentConfigFeeVo.PaymentMethodsBean paymentMethodsBean = paymentMethods.get(i2);
                if (paymentMethodsBean != null) {
                    RentMethodVo rentMethodVo = new RentMethodVo();
                    rentMethodVo.setDefaultFlag(i2 == 0);
                    rentMethodVo.setValue(paymentMethodsBean.getRentFeePaymentMethodType());
                    rentMethodVo.setName(paymentMethodsBean.getRentFeePaymentMethodTypeName());
                    List<ResponseRentConfigFeeVo.PaymentMethodsBean.ConfigItemsBean> configItems = paymentMethodsBean.getConfigItems();
                    if (configItems != null && !configItems.isEmpty()) {
                        ArrayList arrayList2 = new ArrayList();
                        for (ResponseRentConfigFeeVo.PaymentMethodsBean.ConfigItemsBean configItemsBean : configItems) {
                            LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
                            leftTitleToRightArrowVo.setLeft(configItemsBean.getRentFeeTypeName());
                            leftTitleToRightArrowVo.setRight(configItemsBean.getRentFee());
                            arrayList2.add(leftTitleToRightArrowVo);
                        }
                        rentMethodVo.setConfigItems(arrayList2);
                    }
                    arrayList.add(rentMethodVo);
                }
                i2++;
            }
        }
        return arrayList;
    }
}
