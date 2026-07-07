package c.e.c.j0.a;

import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.main.vo.ResponseRentConfigFeeVo;
import com.chinavisionary.microtang.repair.vo.ResponseVo;
import com.chinavisionary.microtang.sign.vo.ContactDetailsVo;
import com.chinavisionary.microtang.sign.vo.ContactResponseVo;
import com.chinavisionary.microtang.sign.vo.CreateContractVo;
import com.chinavisionary.microtang.sign.vo.GetFddContactBo;
import com.chinavisionary.microtang.sign.vo.PayPriceVo;
import com.chinavisionary.microtang.sign.vo.RentMethodVo;
import com.chinavisionary.microtang.sign.vo.RentUserInfoVo;
import com.chinavisionary.microtang.sign.vo.ResponseConfirmContactVo;
import com.chinavisionary.microtang.sign.vo.ResponseFddVo;
import com.chinavisionary.microtang.sign.vo.ResponseRentFeeVo;
import com.chinavisionary.microtang.sign.vo.UpdateRentUserInfoBo;
import h.b;
import h.q.f;
import h.q.o;
import h.q.s;
import h.q.u;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    @o("contract/confirm")
    b<ResponseContent<ResponseConfirmContactVo>> confirmContact(@h.q.a CreateContractVo createContractVo);

    @o("contract/trysign")
    b<ResponseContent<ResponseFddVo>> getFddContact(@h.q.a GetFddContactBo getFddContactBo);

    @o("contract/fees")
    b<ResponseContent<ResponseRentFeeVo>> getPaySignDataToKey(@h.q.a PayPriceVo payPriceVo);

    @f("contract/payment/methods")
    b<ResponseContent<ResponseVo<RentMethodVo>>> getPayType();

    @f("contract/rent/periods")
    b<ResponseContent<ResponseVo<RentMethodVo>>> getRentDateList();

    @f("emergency/contact/getTenantInfo")
    b<ResponseContent<RentUserInfoVo>> getRentUserInfo();

    @f("houses/fee/config")
    b<ResponseContent<ResponseRentConfigFeeVo>> getRoomConfigFee(@u Map<String, String> map);

    @o("contract/terms")
    b<ResponseContent<ContactResponseVo>> getSignContract(@h.q.a CreateContractVo createContractVo);

    @f("contract/detail/{key}")
    b<ResponseContent<ContactDetailsVo>> getSignContractDetails(@s("key") String str);

    @o("emergency/contact/save")
    b<ResponseContent<String>> postRentUserInfo(@h.q.a List<UpdateRentUserInfoBo.RentUserInfoBo> list);
}
