package c.e.c.j.c;

import c.e.a.d.x;
import c.e.a.d.z;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.bill.vo.BillDetailsVo;
import com.chinavisionary.microtang.bill.vo.PayBillVo;
import com.chinavisionary.paymentlibrary.vo.PayTypeVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public List<LeftTitleToRightArrowVo> getAdapterData(int i2, BillDetailsVo billDetailsVo) {
        ArrayList arrayList = new ArrayList();
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo.setLeft(x.getString(R.string.title_bill_no));
        leftTitleToRightArrowVo.setRight(x.getNotNullStr(billDetailsVo.getPaymentKey(), ""));
        arrayList.add(leftTitleToRightArrowVo);
        if (i2 == 1) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo2.setLeft(x.getString(R.string.title_contract_no));
            leftTitleToRightArrowVo2.setRight(x.getNotNullStr(billDetailsVo.getContractCode(), ""));
            arrayList.add(leftTitleToRightArrowVo2);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo3 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo3.setLeft(x.getString(R.string.title_rent_week_number));
            leftTitleToRightArrowVo3.setRight(x.getIntegerToString(billDetailsVo.getPeriodNumber()));
            arrayList.add(leftTitleToRightArrowVo3);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo4 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo4.setLeft(x.getString(R.string.title_bill_pay_price));
            leftTitleToRightArrowVo4.setRight(x.bigDecimalToPlainString(billDetailsVo.getAmount()));
            leftTitleToRightArrowVo4.setPrice(true);
            arrayList.add(leftTitleToRightArrowVo4);
            if (billDetailsVo.getLateFee() != null) {
                LeftTitleToRightArrowVo leftTitleToRightArrowVo5 = new LeftTitleToRightArrowVo();
                leftTitleToRightArrowVo5.setLeft(x.getString(R.string.title_bill_pay_late_fee));
                leftTitleToRightArrowVo5.setRight(x.getString(R.string.placeholder_day_last_fee_details, String.valueOf(billDetailsVo.getLateFeeDays()), x.bigDecimalToPlainString(billDetailsVo.getLateFee())));
                leftTitleToRightArrowVo5.setPrice(true);
                arrayList.add(leftTitleToRightArrowVo5);
            }
            LeftTitleToRightArrowVo leftTitleToRightArrowVo6 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo6.setLeft(x.getString(R.string.title_bill_pay_number));
            leftTitleToRightArrowVo6.setRight(x.getIntegerToString(billDetailsVo.getPaidPeriodNumber()));
            arrayList.add(leftTitleToRightArrowVo6);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo7 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo7.setLeft(x.getString(R.string.title_room_address));
            leftTitleToRightArrowVo7.setRight(x.getNotNullStr(billDetailsVo.getAddress(), ""));
            arrayList.add(leftTitleToRightArrowVo7);
        } else if (i2 == 2) {
            if (x.isNotNull(billDetailsVo.getUnitPrice())) {
                LeftTitleToRightArrowVo leftTitleToRightArrowVo8 = new LeftTitleToRightArrowVo();
                leftTitleToRightArrowVo8.setLeft(x.getString(R.string.title_bill_unit));
                leftTitleToRightArrowVo8.setRight(x.getNotNullStr(billDetailsVo.getUnitPrice(), ""));
                arrayList.add(leftTitleToRightArrowVo8);
            }
            LeftTitleToRightArrowVo leftTitleToRightArrowVo9 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo9.setLeft(x.getString(R.string.title_recharge_price));
            leftTitleToRightArrowVo9.setRight(x.bigDecimalToPlainString(billDetailsVo.getAmount()));
            leftTitleToRightArrowVo9.setPrice(true);
            arrayList.add(leftTitleToRightArrowVo9);
            String address = billDetailsVo.getAddress();
            if (x.isNotNull(address)) {
                LeftTitleToRightArrowVo leftTitleToRightArrowVo10 = new LeftTitleToRightArrowVo();
                leftTitleToRightArrowVo10.setLeft(x.getString(R.string.title_room_address));
                leftTitleToRightArrowVo10.setRight(address);
                arrayList.add(leftTitleToRightArrowVo10);
            }
        } else if (i2 == 3) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo11 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo11.setLeft(x.getString(R.string.title_other_fee_cost));
            leftTitleToRightArrowVo11.setRight(x.bigDecimalToPlainString(billDetailsVo.getAmount()));
            leftTitleToRightArrowVo11.setPrice(true);
            arrayList.add(leftTitleToRightArrowVo11);
        }
        Integer billStatus = billDetailsVo.getBillStatus();
        if (billStatus != null && billStatus.intValue() == 1) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo12 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo12.setLeft(x.getString(R.string.title_pay_type));
            leftTitleToRightArrowVo12.setRight(billDetailsVo.getPayChannel());
            arrayList.add(leftTitleToRightArrowVo12);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo13 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo13.setLeft(x.getString(R.string.title_pay_time));
            leftTitleToRightArrowVo13.setRight(z.getTime(billDetailsVo.getPayDate(), z.f1243d));
            arrayList.add(leftTitleToRightArrowVo13);
        }
        List<BillDetailsVo.DetailsVo> billDetails = billDetailsVo.getBillDetails();
        if (billDetails != null && !billDetails.isEmpty()) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo14 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo14.setTitle(x.getString(R.string.title_details));
            leftTitleToRightArrowVo14.setTitle(true);
            arrayList.add(leftTitleToRightArrowVo14);
            for (BillDetailsVo.DetailsVo detailsVo : billDetails) {
                if (detailsVo != null) {
                    LeftTitleToRightArrowVo leftTitleToRightArrowVo15 = new LeftTitleToRightArrowVo();
                    leftTitleToRightArrowVo15.setLeft(detailsVo.getName());
                    leftTitleToRightArrowVo15.setRight(detailsVo.getValue());
                    arrayList.add(leftTitleToRightArrowVo15);
                }
            }
        }
        return arrayList;
    }

    public PayTypeVo getPayTypeVo(BillDetailsVo billDetailsVo, int i2) {
        String strBigDecimalAdd = x.bigDecimalAdd(billDetailsVo.getAmount(), billDetailsVo.getLateFee());
        String paymentKey = billDetailsVo.getPaymentKey();
        boolean z = false;
        boolean z2 = i2 == 1;
        Integer paidPeriodNumber = billDetailsVo.getPaidPeriodNumber();
        if (paidPeriodNumber != null && paidPeriodNumber.intValue() == 1) {
            z = true;
        }
        int i3 = z2 ? z ? 10 : 12 : 4;
        PayBillVo payBillVo = new PayBillVo();
        payBillVo.setPaymentKey(paymentKey);
        PayTypeVo payTypeVo = new PayTypeVo();
        int i4 = R.string.title_bill;
        if (i2 == 1) {
            i4 = R.string.title_rent_bill;
            payTypeVo.setLateDay(billDetailsVo.getLateFeeDays());
            payTypeVo.setLateFee(billDetailsVo.getLateFee());
        } else if (i2 == 2) {
            i4 = R.string.title_water_electric_bill;
        } else if (i2 == 3) {
            i4 = R.string.title_other_bill;
        }
        payTypeVo.setResStrId(i4);
        if (i2 == 3) {
            payTypeVo.setTitle(billDetailsVo.getBody());
        } else {
            payTypeVo.setTitle(x.getString(i4));
        }
        payTypeVo.setPrice(strBigDecimalAdd);
        payTypeVo.setBill(true);
        payTypeVo.setType(i3);
        payTypeVo.setExtJson(JSON.toJSONString(payBillVo));
        payTypeVo.setBaseKey(billDetailsVo.getContractKey());
        return payTypeVo;
    }

    public List<LeftTitleToRightArrowVo> getWalletDetailsAdapterData(List<BillDetailsVo.DetailsVo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (BillDetailsVo.DetailsVo detailsVo : list) {
                if (detailsVo != null) {
                    LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
                    leftTitleToRightArrowVo.setLeft(detailsVo.getName());
                    leftTitleToRightArrowVo.setRight(detailsVo.getValue());
                    arrayList.add(leftTitleToRightArrowVo);
                }
            }
        }
        return arrayList;
    }
}
