package c.e.c.o.d;

import c.e.a.d.x;
import c.e.a.d.z;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.bill.vo.PayBillVo;
import com.chinavisionary.microtang.contract.vo.ContractListDetailsVo;
import com.chinavisionary.microtang.contract.vo.ContractListVo;
import com.chinavisionary.microtang.sign.vo.ResponseFirstFeeVo;
import com.chinavisionary.paymentlibrary.PayTypeFragment;
import com.chinavisionary.paymentlibrary.vo.PayTypeVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public final String a(Long l) {
        if (l.longValue() <= 0) {
            return x.getString(R.string.title_pay_time_out);
        }
        return x.getString(R.string.title_pay_surplus_second) + z.getSurplusDateToTime(l);
    }

    public List<LeftTitleToRightArrowVo> getAdapterData(ContractListDetailsVo contractListDetailsVo) {
        ArrayList arrayList = new ArrayList();
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo.setLeft(x.getString(R.string.title_contract_no));
        leftTitleToRightArrowVo.setRight(contractListDetailsVo.getContractCode());
        leftTitleToRightArrowVo.setKey(contractListDetailsVo.getContractKey());
        arrayList.add(leftTitleToRightArrowVo);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo2.setLeft(x.getString(R.string.title_room_no));
        leftTitleToRightArrowVo2.setRight(contractListDetailsVo.getAssetAddress());
        arrayList.add(leftTitleToRightArrowVo2);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo3 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo3.setLeft(x.getString(R.string.title_month_rent));
        leftTitleToRightArrowVo3.setRight(x.appendStringToResId(R.string.placeholder_rmb_china_unit, x.bigDecimalToString(contractListDetailsVo.getRentFee())));
        arrayList.add(leftTitleToRightArrowVo3);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo4 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo4.setLeft(x.getString(R.string.title_rent_period_date));
        leftTitleToRightArrowVo4.setRight(z.getTimeYYMMDD(contractListDetailsVo.getRentTermFrom()) + x.getString(R.string.title_time_middle_unit) + z.getTimeYYMMDD(contractListDetailsVo.getRentTermTo()));
        arrayList.add(leftTitleToRightArrowVo4);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo5 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo5.setLeft(x.getString(R.string.title_pay_method));
        leftTitleToRightArrowVo5.setRight(contractListDetailsVo.getPaymentMethodName());
        arrayList.add(leftTitleToRightArrowVo5);
        if (contractListDetailsVo.getCheckinCleaningDate() != null) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo6 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo6.setLeft(x.getString(R.string.tip_estimate_time));
            leftTitleToRightArrowVo6.setRight(z.getTimeYYMMDD(contractListDetailsVo.getCheckinCleaningDate()));
            arrayList.add(leftTitleToRightArrowVo6);
        }
        LeftTitleToRightArrowVo leftTitleToRightArrowVo7 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo7.setKey(contractListDetailsVo.getContractKey());
        leftTitleToRightArrowVo7.setLeft(x.getString(R.string.title_property_recognition_status));
        leftTitleToRightArrowVo7.setRight(contractListDetailsVo.getAssetRecognitionStatusName());
        leftTitleToRightArrowVo7.setExtObj(contractListDetailsVo);
        leftTitleToRightArrowVo7.setShowArrow(true);
        leftTitleToRightArrowVo7.setOnlyKey(1);
        arrayList.add(leftTitleToRightArrowVo7);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo8 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo8.setLeft(x.getString(R.string.title_electron_contract));
        leftTitleToRightArrowVo8.setRight(x.getString(R.string.title_cat));
        leftTitleToRightArrowVo8.setShowArrow(true);
        leftTitleToRightArrowVo8.setOnlyKey(2);
        leftTitleToRightArrowVo8.setExtObj(contractListDetailsVo.getContractDownloadUrl());
        arrayList.add(leftTitleToRightArrowVo8);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo9 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo9.setLeft(x.getString(R.string.title_all_bill));
        leftTitleToRightArrowVo9.setRight(x.getString(R.string.title_cat));
        leftTitleToRightArrowVo9.setShowArrow(true);
        leftTitleToRightArrowVo9.setOnlyKey(3);
        arrayList.add(leftTitleToRightArrowVo9);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo10 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo10.setKey(contractListDetailsVo.getContractKey());
        leftTitleToRightArrowVo10.setLeft(x.getString(R.string.title_together_live));
        leftTitleToRightArrowVo10.setRight(x.getString(R.string.title_cat));
        leftTitleToRightArrowVo10.setShowArrow(true);
        leftTitleToRightArrowVo10.setOnlyKey(4);
        arrayList.add(leftTitleToRightArrowVo10);
        if (x.isNotNull(contractListDetailsVo.getSigningCode())) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo11 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo11.setKey(contractListDetailsVo.getContractKey());
            leftTitleToRightArrowVo11.setLeft(x.getString(R.string.title_tip_sign_code));
            leftTitleToRightArrowVo11.setShowArrow(true);
            leftTitleToRightArrowVo11.setOnlyKey(5);
            leftTitleToRightArrowVo11.setRight(x.getNotNullStr(contractListDetailsVo.getSigningCode(), ""));
            arrayList.add(leftTitleToRightArrowVo11);
        }
        LeftTitleToRightArrowVo leftTitleToRightArrowVo12 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo12.setTitle(x.getString(R.string.title_sign_main_info));
        leftTitleToRightArrowVo12.setTitle(true);
        arrayList.add(leftTitleToRightArrowVo12);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo13 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo13.setLeft(x.getString(R.string.title_user_name));
        leftTitleToRightArrowVo13.setRight(x.getNameMask(contractListDetailsVo.getSigningUserName()));
        arrayList.add(leftTitleToRightArrowVo13);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo14 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo14.setLeft(x.getString(R.string.title_card_type));
        leftTitleToRightArrowVo14.setRight(contractListDetailsVo.getIdCardType());
        arrayList.add(leftTitleToRightArrowVo14);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo15 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo15.setLeft(x.getString(R.string.title_id_card_no));
        leftTitleToRightArrowVo15.setRight(x.getIDNoMask(contractListDetailsVo.getIdCardNo()));
        arrayList.add(leftTitleToRightArrowVo15);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo16 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo16.setLeft(x.getString(R.string.title_phone_no));
        leftTitleToRightArrowVo16.setRight(x.getPhoneMask(contractListDetailsVo.getPhone()));
        arrayList.add(leftTitleToRightArrowVo16);
        return arrayList;
    }

    public PayTypeFragment getPayTypeFragmentToResponseFirstFeeVo(ResponseFirstFeeVo responseFirstFeeVo, String str) {
        PayBillVo payBillVo = new PayBillVo();
        payBillVo.setPaymentKey(responseFirstFeeVo.getPaymentKey());
        PayTypeVo payTypeVo = new PayTypeVo();
        payTypeVo.setResStrId(R.string.title_pay_first);
        payTypeVo.setTitle(x.getString(R.string.title_pay_first));
        payTypeVo.setPrice(x.bigDecimalToPlainString(responseFirstFeeVo.getAmount()));
        payTypeVo.setBill(true);
        payTypeVo.setType(10);
        payTypeVo.setExtJson(JSON.toJSONString(payBillVo));
        payTypeVo.setBaseKey(str);
        PayTypeFragment payTypeFragment = PayTypeFragment.getInstance(payTypeVo);
        payTypeFragment.setExpireDate(responseFirstFeeVo.getExpireTime());
        return payTypeFragment;
    }

    public boolean isUpdateDownToListData(List<ContractListVo> list) {
        Long expireDate;
        if (list == null) {
            return false;
        }
        int size = list.size();
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            ContractListVo contractListVo = list.get(i2);
            if (contractListVo.getContractStatus() == 11 && (expireDate = contractListVo.getExpireDate()) != null) {
                long jLongValue = expireDate.longValue() - jCurrentTimeMillis;
                if (jLongValue > 0) {
                    contractListVo.setSurplusTime(a(Long.valueOf(jLongValue / 1000)));
                } else {
                    contractListVo.setContractStatus(14);
                    contractListVo.setContractStatusName(x.getString(R.string.title_pay_time_out));
                }
                z = true;
            }
        }
        return z;
    }
}
