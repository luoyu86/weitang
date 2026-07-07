package c.e.c.c0.c;

import c.e.a.d.x;
import c.e.a.d.z;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.bill.vo.PayBillVo;
import com.chinavisionary.microtang.pre.vo.ReserveDetailsVo;
import com.chinavisionary.microtang.pre.vo.ReserveFddContractVo;
import com.chinavisionary.microtang.pre.vo.ReserveItemVo;
import com.chinavisionary.microtang.sign.vo.ResponseFddVo;
import com.chinavisionary.microtang.web.WebFragment;
import com.chinavisionary.paymentlibrary.PayTypeFragment;
import com.chinavisionary.paymentlibrary.vo.PayTypeVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public List<LeftTitleToRightArrowVo> a(ReserveDetailsVo reserveDetailsVo, String str, int i2) {
        ArrayList arrayList = new ArrayList();
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo.setTitle(x.getString(R.string.title_room_about_info_msg));
        leftTitleToRightArrowVo.setTitle(true);
        arrayList.add(leftTitleToRightArrowVo);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo2.setLeft(x.getString(R.string.title_address));
        leftTitleToRightArrowVo2.setRight(x.getNotNullStr(reserveDetailsVo.getAddress(), ""));
        arrayList.add(leftTitleToRightArrowVo2);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo3 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo3.setLeft(x.getString(R.string.title_reserve_price));
        leftTitleToRightArrowVo3.setRight(x.bigDecimalToPlainString(reserveDetailsVo.getReserveDeposit()));
        leftTitleToRightArrowVo3.setPrice(true);
        arrayList.add(leftTitleToRightArrowVo3);
        List<ReserveDetailsVo.FeesBean> fees = reserveDetailsVo.getFees();
        if (fees != null && !fees.isEmpty()) {
            for (ReserveDetailsVo.FeesBean feesBean : fees) {
                if (feesBean != null) {
                    LeftTitleToRightArrowVo leftTitleToRightArrowVo4 = new LeftTitleToRightArrowVo();
                    leftTitleToRightArrowVo4.setLeft(feesBean.getFeeTypeName());
                    leftTitleToRightArrowVo4.setRight(x.bigDecimalToPlainString(feesBean.getAmount()));
                    leftTitleToRightArrowVo4.setPrice(true);
                    arrayList.add(leftTitleToRightArrowVo4);
                }
            }
        }
        if (reserveDetailsVo.getStatus() == 3) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo5 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo5.setLeft(x.getString(R.string.title_reserve_protocol));
            leftTitleToRightArrowVo5.setRight(x.getString(R.string.title_cat));
            leftTitleToRightArrowVo5.setExtObj(reserveDetailsVo.getReserveViewUrl());
            leftTitleToRightArrowVo5.setOnlyKey(i2);
            arrayList.add(leftTitleToRightArrowVo5);
        }
        LeftTitleToRightArrowVo leftTitleToRightArrowVo6 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo6.setLeft(x.getString(R.string.title_reserve_sign_date));
        leftTitleToRightArrowVo6.setRight(String.valueOf(reserveDetailsVo.getReserveSignDate()));
        leftTitleToRightArrowVo6.setSimpleDateFormat(z.f1246g);
        leftTitleToRightArrowVo6.setTime(true);
        arrayList.add(leftTitleToRightArrowVo6);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo7 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo7.setTitle(x.getString(R.string.title_reserve_person));
        leftTitleToRightArrowVo7.setTitle(true);
        arrayList.add(leftTitleToRightArrowVo7);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo8 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo8.setLeft(x.getString(R.string.title_reserve_person_name));
        leftTitleToRightArrowVo8.setRight(reserveDetailsVo.getName());
        arrayList.add(leftTitleToRightArrowVo8);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo9 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo9.setLeft(x.getString(R.string.title_phone_no));
        leftTitleToRightArrowVo9.setRight(str);
        arrayList.add(leftTitleToRightArrowVo9);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo10 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo10.setLeft(x.getString(R.string.title_card_type));
        leftTitleToRightArrowVo10.setRight(reserveDetailsVo.getCardTypeName());
        arrayList.add(leftTitleToRightArrowVo10);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo11 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo11.setRight(reserveDetailsVo.getCardNo());
        leftTitleToRightArrowVo11.setLeft(x.getString(R.string.title_id_card_no));
        arrayList.add(leftTitleToRightArrowVo11);
        return arrayList;
    }

    public PayTypeFragment b(ReserveItemVo reserveItemVo) {
        PayBillVo payBillVo = new PayBillVo();
        payBillVo.setPaymentKey(reserveItemVo.getPaymentKey());
        PayTypeVo payTypeVo = new PayTypeVo();
        payTypeVo.setBill(true);
        payTypeVo.setResStrId(R.string.title_pay_reserve_fee);
        payTypeVo.setPrice(x.bigDecimalToPlainString(reserveItemVo.getReserveDeposit()));
        payTypeVo.setType(16);
        payTypeVo.setExtJson(JSON.toJSONString(payBillVo));
        payTypeVo.setBaseKey(reserveItemVo.getPrimaryKey());
        return PayTypeFragment.getInstance(payTypeVo);
    }

    public WebFragment c(ReserveFddContractVo reserveFddContractVo) {
        ResponseFddVo responseFddVo = new ResponseFddVo();
        responseFddVo.setSignUrl(reserveFddContractVo.getReserveSignUrl());
        responseFddVo.setReturnUrl(reserveFddContractVo.getNotifyUrl());
        WebFragment webFragment = WebFragment.getInstance(responseFddVo.getSignUrl());
        webFragment.setPayFeeType(16);
        webFragment.setResponseFddVo(responseFddVo);
        webFragment.setTitle(x.getString(R.string.title_electron_contract));
        return webFragment;
    }

    public final String d(Long l) {
        if (l.longValue() <= 0) {
            return x.getString(R.string.title_pay_time_out);
        }
        return x.getString(R.string.title_pay_surplus_second) + z.getSurplusDateToTime(l);
    }

    public boolean e(List<ReserveItemVo> list) {
        int size = list.size();
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            ReserveItemVo reserveItemVo = list.get(i2);
            int status = reserveItemVo.getStatus();
            if (status == 1 || status == 5) {
                Long expireTime = status == 1 ? reserveItemVo.getExpireTime() : reserveItemVo.getReserveExpireTime();
                if (expireTime != null) {
                    long jLongValue = expireTime.longValue() - lValueOf.longValue();
                    if (jLongValue >= 0) {
                        reserveItemVo.setSurplusTime(d(Long.valueOf(jLongValue / 1000)));
                        z = true;
                    }
                }
            }
        }
        return z;
    }
}
