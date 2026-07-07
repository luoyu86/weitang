package c.e.d.c0;

import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import com.chinavisionary.paymentlibrary.R;
import com.chinavisionary.paymentlibrary.vo.CouponListBean;
import com.chinavisionary.paymentlibrary.vo.PayCostTypeVo;
import com.chinavisionary.paymentlibrary.vo.PayCouponParamBo;
import com.chinavisionary.paymentlibrary.vo.PayCouponVo;
import com.chinavisionary.paymentlibrary.vo.ResponseCouponVo;
import com.chinavisionary.paymentlibrary.vo.ResponseUserCouponResultItemVo;
import com.chinavisionary.paymentlibrary.vo.SelectCouponResultVo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<PayCouponVo> f2294a = new ArrayList();

    public static String calculationPayPrice(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        if (bigDecimal == null) {
            return "";
        }
        if (bigDecimal2 == null) {
            return bigDecimal.setScale(2, 4).toPlainString();
        }
        BigDecimal bigDecimalSubtract = bigDecimal.subtract(bigDecimal2);
        if (bigDecimalSubtract.floatValue() < 0.0f) {
            bigDecimalSubtract = new BigDecimal(0);
        }
        return bigDecimalSubtract.setScale(2, 4).toPlainString();
    }

    public static Map<String, BigDecimal> d(List<PayCostTypeVo> list) {
        HashMap map = new HashMap();
        if (o.isNotEmpty(list)) {
            for (PayCostTypeVo payCostTypeVo : list) {
                if (payCostTypeVo != null && payCostTypeVo.getType() != null && payCostTypeVo.getValue() != null) {
                    map.put(payCostTypeVo.getType(), payCostTypeVo.getValue());
                }
            }
        }
        return map;
    }

    public static BigDecimal getCurrentSelectCouponsDeductionTotal(List<PayCouponVo> list, List<PayCostTypeVo> list2) {
        Map<String, BigDecimal> mapD = d(list2);
        BigDecimal bigDecimal = null;
        if (o.isNotEmpty(list)) {
            HashMap map = new HashMap();
            for (PayCouponVo payCouponVo : list) {
                if (payCouponVo != null && payCouponVo.getPriceOff() != null && payCouponVo.getApplyTo() != null) {
                    String applyTo = payCouponVo.getApplyTo();
                    BigDecimal bigDecimal2 = mapD.containsKey(applyTo) ? mapD.get(applyTo) : null;
                    BigDecimal priceOff = payCouponVo.getPriceOff();
                    if (bigDecimal2 != null) {
                        BigDecimal bigDecimalMin = bigDecimal2.min(priceOff);
                        if (map.containsKey(applyTo)) {
                            map.put(applyTo, x.bigDecimalAddToBigDecimal((BigDecimal) map.get(applyTo), bigDecimalMin).min(bigDecimal2));
                        } else {
                            map.put(applyTo, bigDecimalMin);
                        }
                    }
                }
            }
            if (!map.isEmpty()) {
                Iterator it = map.entrySet().iterator();
                while (it.hasNext()) {
                    BigDecimal bigDecimalBigDecimalAddToBigDecimal = (BigDecimal) ((Map.Entry) it.next()).getValue();
                    if (bigDecimal != null) {
                        bigDecimalBigDecimalAddToBigDecimal = x.bigDecimalAddToBigDecimal(bigDecimal, bigDecimalBigDecimalAddToBigDecimal);
                    }
                    bigDecimal = bigDecimalBigDecimalAddToBigDecimal;
                }
            }
        }
        return bigDecimal;
    }

    public static List<String> getPayCostTypeVosToTypes(List<PayCostTypeVo> list) {
        ArrayList arrayList = new ArrayList();
        if (o.isNotEmpty(list)) {
            for (PayCostTypeVo payCostTypeVo : list) {
                if (payCostTypeVo != null && payCostTypeVo.getType() != null) {
                    arrayList.add(payCostTypeVo.getType());
                }
            }
        }
        return arrayList;
    }

    public static List<PayCouponVo> getPayCouponList(ResponseCouponVo responseCouponVo) {
        ArrayList arrayList = new ArrayList();
        if (o.isNotEmpty(responseCouponVo.getOptionalList())) {
            arrayList.addAll(responseCouponVo.getOptionalList());
        }
        if (o.isNotEmpty(responseCouponVo.getUnOptionalList())) {
            List<PayCouponVo> unOptionalList = responseCouponVo.getUnOptionalList();
            for (PayCouponVo payCouponVo : unOptionalList) {
                payCouponVo.setUnavailable(true);
                payCouponVo.setUnavailableReason(x.getNotNullStr(payCouponVo.getUnavailableReason(), x.getString(R.string.payment_lib_tip_err_coupon_unavailable)));
            }
            arrayList.addAll(unOptionalList);
        }
        return arrayList;
    }

    public static SelectCouponResultVo getSelectCouponResult(List<PayCouponVo> list, List<PayCostTypeVo> list2) {
        SelectCouponResultVo selectCouponResultVo = new SelectCouponResultVo();
        if (o.isNotEmpty(list)) {
            selectCouponResultVo.setCouponTotal(list.size());
            ArrayList arrayList = new ArrayList();
            BigDecimal bigDecimal = new BigDecimal(0);
            for (PayCouponVo payCouponVo : list) {
                if (payCouponVo != null && x.isNotNull(payCouponVo.getCouponId())) {
                    PayCouponParamBo payCouponParamBo = new PayCouponParamBo();
                    payCouponParamBo.setCouponId(payCouponVo.getCouponId());
                    payCouponParamBo.setType(payCouponVo.getApplyTo());
                    arrayList.add(payCouponParamBo);
                    BigDecimal priceOff = payCouponVo.getPriceOff();
                    if (priceOff != null) {
                        bigDecimal = x.bigDecimalAddToBigDecimal(bigDecimal, priceOff);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                selectCouponResultVo.setCouponList(arrayList);
            }
            selectCouponResultVo.setCouponValueTotal(getCurrentSelectCouponsDeductionTotal(list, list2));
        }
        return selectCouponResultVo;
    }

    public static SelectCouponResultVo getSelectCouponResultVo(List<ResponseUserCouponResultItemVo> list) {
        SelectCouponResultVo selectCouponResultVo = new SelectCouponResultVo();
        if (o.isNotEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = 0;
            BigDecimal bigDecimal = new BigDecimal(0);
            for (ResponseUserCouponResultItemVo responseUserCouponResultItemVo : list) {
                if (responseUserCouponResultItemVo != null && o.isNotEmpty(responseUserCouponResultItemVo.getCouponList())) {
                    for (CouponListBean couponListBean : responseUserCouponResultItemVo.getCouponList()) {
                        PayCouponParamBo payCouponParamBo = new PayCouponParamBo();
                        payCouponParamBo.setCouponId(couponListBean.getCouponId());
                        payCouponParamBo.setType(responseUserCouponResultItemVo.getType());
                        arrayList.add(payCouponParamBo);
                        PayCouponVo payCouponVo = new PayCouponVo();
                        payCouponVo.setCouponId(couponListBean.getCouponId());
                        arrayList2.add(payCouponVo);
                    }
                    BigDecimal saleAmount = responseUserCouponResultItemVo.getSaleAmount();
                    if (saleAmount != null) {
                        bigDecimal = x.bigDecimalAddToBigDecimal(bigDecimal, saleAmount);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                size = arrayList.size();
                selectCouponResultVo.setUserCouponList(arrayList2);
                selectCouponResultVo.setCouponList(arrayList);
            }
            selectCouponResultVo.setCouponTotal(size);
            selectCouponResultVo.setCouponValueTotal(bigDecimal);
        }
        return selectCouponResultVo;
    }

    public static void removeCouponVosToIds(List<PayCouponVo> list, String str) {
        if (o.isNotEmpty(list) && x.isNotNull(str)) {
            int size = list.size();
            int i2 = -1;
            for (int i3 = 0; i3 < size; i3++) {
                if (str.equals(list.get(i3).getCouponId())) {
                    i2 = i3;
                }
            }
            if (i2 != -1) {
                list.remove(i2);
            }
        }
    }

    public static void updateSelectCoupon(List<ResponseUserCouponResultItemVo> list, List<PayCostTypeVo> list2) {
        if (!o.isNotEmpty(list)) {
            if (o.isNotEmpty(list2)) {
                Iterator<PayCostTypeVo> it = list2.iterator();
                while (it.hasNext()) {
                    it.next().setCouponValue(null);
                }
                return;
            }
            return;
        }
        if (o.isNotEmpty(list2)) {
            for (PayCostTypeVo payCostTypeVo : list2) {
                if (payCostTypeVo != null && payCostTypeVo.getType() != null) {
                    q.d("PaymentCouponHandle", "updateSelectCoupon type " + payCostTypeVo.getType());
                    BigDecimal bigDecimalBigDecimalAddToBigDecimal = null;
                    for (ResponseUserCouponResultItemVo responseUserCouponResultItemVo : list) {
                        q.d("PaymentCouponHandle", "updateSelectCoupon type = " + payCostTypeVo.getType() + ",payCouponVo type = " + responseUserCouponResultItemVo.getType());
                        if (payCostTypeVo.getType().equals(responseUserCouponResultItemVo.getType())) {
                            bigDecimalBigDecimalAddToBigDecimal = bigDecimalBigDecimalAddToBigDecimal != null ? x.bigDecimalAddToBigDecimal(bigDecimalBigDecimalAddToBigDecimal, responseUserCouponResultItemVo.getSaleAmount()) : responseUserCouponResultItemVo.getSaleAmount();
                        }
                    }
                    payCostTypeVo.setCouponValue(bigDecimalBigDecimalAddToBigDecimal);
                }
            }
        }
    }

    public final boolean a(List<String> list, String str) {
        return x.isNotNull(str) && o.isNotEmpty(list) && list.contains(str);
    }

    public void addSelectCoupon(PayCouponVo payCouponVo) {
        this.f2294a.add(payCouponVo);
    }

    public final boolean b(String str, String str2) {
        if (str != null) {
            return str.equals(str2);
        }
        return false;
    }

    public final BigDecimal c(List<PayCouponVo> list, String str, boolean z) {
        BigDecimal bigDecimalBigDecimalAddToBigDecimal = null;
        if (o.isNotEmpty(list)) {
            for (PayCouponVo payCouponVo : list) {
                if (payCouponVo != null && payCouponVo.getPriceOff() != null) {
                    boolean z2 = true;
                    if (z && !b(payCouponVo.getApplyTo(), str)) {
                        z2 = false;
                    }
                    if (z2) {
                        BigDecimal priceOff = payCouponVo.getPriceOff();
                        bigDecimalBigDecimalAddToBigDecimal = bigDecimalBigDecimalAddToBigDecimal == null ? priceOff : x.bigDecimalAddToBigDecimal(bigDecimalBigDecimalAddToBigDecimal, priceOff);
                    }
                }
            }
        }
        return bigDecimalBigDecimalAddToBigDecimal;
    }

    public void clearSelectCoupons() {
        this.f2294a.clear();
    }

    public void delSelectCoupon(PayCouponVo payCouponVo) {
        this.f2294a.remove(payCouponVo);
    }

    public final PayCostTypeVo e(List<PayCostTypeVo> list, String str) {
        if (!o.isNotEmpty(list) || str == null) {
            return null;
        }
        for (PayCostTypeVo payCostTypeVo : list) {
            if (payCostTypeVo != null && str.equals(payCostTypeVo.getType())) {
                return payCostTypeVo;
            }
        }
        return null;
    }

    public final PayCouponVo f(List<PayCouponVo> list, String str) {
        for (PayCouponVo payCouponVo : list) {
            if (payCouponVo != null) {
                List<String> mutexCouponIds = payCouponVo.getMutexCouponIds();
                if (o.isNotEmpty(mutexCouponIds) && mutexCouponIds.contains(str)) {
                    return payCouponVo;
                }
            }
        }
        return null;
    }

    public List<PayCouponVo> filterAvailableCoupons(List<PayCouponVo> list, List<PayCostTypeVo> list2, List<PayCouponVo> list3) {
        ArrayList arrayList = new ArrayList();
        List<String> payCouponVosToIds = getPayCouponVosToIds(list3);
        getPayCostTypeVosToTypes(list2);
        if (o.isNotEmpty(list)) {
            for (PayCouponVo payCouponVo : list) {
                if (payCouponVo != null) {
                    String applyTo = payCouponVo.getApplyTo();
                    payCouponVo.setCheck(a(payCouponVosToIds, payCouponVo.getCouponId()));
                    if (applyTo == null) {
                        payCouponVo.setUnavailable(true);
                        payCouponVo.setUnavailableReason(x.getString(R.string.payment_lib_tip_err_coupon_type_empty));
                    } else if (!payCouponVo.isValid() || payCouponVo.isUnavailable()) {
                        payCouponVo.setUnavailable(true);
                        String applyToName = payCouponVo.getApplyToName();
                        String string = x.getString(R.string.payment_lib_tip_err_coupon_unavailable);
                        if (!payCouponVo.isValid()) {
                            string = x.getString(R.string.payment_lib_tip_err_coupon_expire);
                        }
                        if (x.isNotNull(applyToName)) {
                            string = x.appendStringToResId(R.string.payment_lib_tip_err_coupon_fit_scope, applyToName);
                        }
                        payCouponVo.setUnavailableReason(string);
                    } else {
                        payCouponVo.setUnavailable(false);
                        arrayList.add(payCouponVo);
                    }
                }
            }
            if (arrayList.size() > 0) {
                list.removeAll(arrayList);
                arrayList.addAll(list);
            }
        }
        return arrayList;
    }

    public int findSelectCouponPosition(List<PayCouponVo> list, List<PayCouponVo> list2) {
        if (!o.isNotEmpty(list2) || !o.isNotEmpty(list)) {
            return -1;
        }
        try {
            PayCouponVo payCouponVo = list2.get(0);
            if (payCouponVo == null) {
                return -1;
            }
            String couponId = payCouponVo.getCouponId();
            if (!x.isNotNull(couponId)) {
                return -1;
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PayCouponVo payCouponVo2 = list.get(i2);
                if (payCouponVo2 != null && couponId.equals(payCouponVo2.getCouponId())) {
                    return i2;
                }
            }
            return -1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public List<String> getPayCouponParamBoToIds(List<PayCouponParamBo> list) {
        ArrayList arrayList = new ArrayList();
        if (o.isNotEmpty(list)) {
            for (PayCouponParamBo payCouponParamBo : list) {
                if (payCouponParamBo != null) {
                    arrayList.add(payCouponParamBo.getCouponId());
                }
            }
        }
        return arrayList;
    }

    public List<String> getPayCouponVosToIds(List<PayCouponVo> list) {
        ArrayList arrayList = new ArrayList();
        if (o.isNotEmpty(list)) {
            for (PayCouponVo payCouponVo : list) {
                if (payCouponVo != null) {
                    arrayList.add(payCouponVo.getCouponId());
                }
            }
        }
        return arrayList;
    }

    public List<String> getSelectCouponIds() {
        return getPayCouponVosToIds(this.f2294a);
    }

    public List<PayCouponVo> getSelectCouponList() {
        return this.f2294a;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.chinavisionary.paymentlibrary.vo.MinusResultVo isCanKeepMinusPayCost(java.util.List<com.chinavisionary.paymentlibrary.vo.PayCostTypeVo> r12, java.util.List<com.chinavisionary.paymentlibrary.vo.PayCouponVo> r13, java.math.BigDecimal r14, com.chinavisionary.paymentlibrary.vo.PayCouponVo r15) {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.d.c0.h.isCanKeepMinusPayCost(java.util.List, java.util.List, java.math.BigDecimal, com.chinavisionary.paymentlibrary.vo.PayCouponVo):com.chinavisionary.paymentlibrary.vo.MinusResultVo");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.chinavisionary.paymentlibrary.vo.CouponMutexVo isMutex(java.util.List<com.chinavisionary.paymentlibrary.vo.PayCouponVo> r5, com.chinavisionary.paymentlibrary.vo.PayCouponVo r6) {
        /*
            r4 = this;
            com.chinavisionary.paymentlibrary.vo.CouponMutexVo r0 = new com.chinavisionary.paymentlibrary.vo.CouponMutexVo
            r0.<init>()
            boolean r1 = c.e.a.d.o.isNotEmpty(r5)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L23
            if (r6 == 0) goto L22
            java.lang.String r6 = r6.getCouponId()
            boolean r1 = c.e.a.d.x.isNotNull(r6)
            if (r1 == 0) goto L22
            com.chinavisionary.paymentlibrary.vo.PayCouponVo r5 = r4.f(r5, r6)
            if (r5 == 0) goto L23
            r0.setSelectCouponVo(r5)
        L22:
            r2 = 1
        L23:
            r0.setMutex(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.d.c0.h.isMutex(java.util.List, com.chinavisionary.paymentlibrary.vo.PayCouponVo):com.chinavisionary.paymentlibrary.vo.CouponMutexVo");
    }

    public void updateSelectCouponList(List<String> list, List<PayCouponVo> list2) {
        if (o.listIsEmpty(list)) {
            list = new ArrayList<>();
        }
        for (PayCouponVo payCouponVo : list2) {
            if (x.isNotNull(payCouponVo.getCouponId())) {
                payCouponVo.setCheck(list.contains(payCouponVo.getCouponId()));
            } else {
                payCouponVo.setCheck(false);
            }
        }
    }

    public List<String> getSelectCouponList(List<PayCouponVo> list) {
        ArrayList arrayList = new ArrayList();
        if (o.isNotEmpty(list)) {
            for (PayCouponVo payCouponVo : list) {
                if (payCouponVo != null && payCouponVo.isCheck()) {
                    arrayList.add(payCouponVo.getCouponId());
                }
            }
        }
        return arrayList;
    }
}
