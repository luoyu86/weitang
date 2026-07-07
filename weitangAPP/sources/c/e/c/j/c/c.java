package c.e.c.j.c;

import c.e.a.d.x;
import c.e.a.d.z;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.bill.vo.BillVo;
import com.chinavisionary.microtang.bill.vo.PayBillVo;
import com.chinavisionary.paymentlibrary.PayTypeFragment;
import com.chinavisionary.paymentlibrary.vo.PayTypeVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public PayTypeFragment createPayTypeFragment(BillVo billVo, int i2) {
        boolean z = false;
        boolean z2 = i2 == 1;
        int i3 = z2 ? R.string.title_rent_bill : i2 == 3 ? R.string.title_other_bill : R.string.title_life_bill;
        String strBigDecimalAdd = x.bigDecimalAdd(billVo.getAmount(), billVo.getLateFee());
        String paymentKey = billVo.getPaymentKey();
        Integer paidPeriodNumber = billVo.getPaidPeriodNumber();
        if (paidPeriodNumber != null && paidPeriodNumber.intValue() == 1) {
            z = true;
        }
        int i4 = z2 ? z ? 10 : 12 : 4;
        PayBillVo payBillVo = new PayBillVo();
        payBillVo.setPaymentKey(paymentKey);
        PayTypeVo payTypeVo = new PayTypeVo();
        payTypeVo.setResStrId(i3);
        payTypeVo.setPrice(strBigDecimalAdd);
        payTypeVo.setBill(true);
        payTypeVo.setType(i4);
        if (i2 == 1) {
            payTypeVo.setLateFee(billVo.getLateFee());
            payTypeVo.setLateDay(billVo.getLateFeeDays());
        }
        if (i2 == 3) {
            payTypeVo.setTitle(billVo.getBody());
        } else {
            payTypeVo.setTitle(x.getString(i3));
        }
        payTypeVo.setExtJson(JSON.toJSONString(payBillVo));
        payTypeVo.setBaseKey(billVo.getContractKey());
        return PayTypeFragment.getInstance(payTypeVo);
    }

    public boolean isUpdateTimer(List<BillVo> list) {
        Long expiryDate;
        int size = list.size();
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            BillVo billVo = list.get(i2);
            if (billVo.getBillStatus() == 0 && (expiryDate = billVo.getExpiryDate()) != null) {
                long jLongValue = expiryDate.longValue() - lValueOf.longValue();
                if (jLongValue > 0) {
                    billVo.setSurplusTime(z.secondToMinute(Long.valueOf(jLongValue / 1000)));
                } else {
                    billVo.setBillStatus(14);
                    billVo.setBillStatusName(x.getString(R.string.title_pay_time_out));
                }
                z = true;
            }
        }
        return z;
    }
}
