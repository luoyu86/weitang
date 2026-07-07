package c.e.d.z;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.paymentlibrary.vo.CreateCleanOrderVo;
import com.chinavisionary.paymentlibrary.vo.CreateFoodOrderVo;
import com.chinavisionary.paymentlibrary.vo.CreateIncrementOrderParamBo;
import com.chinavisionary.paymentlibrary.vo.PayBillResultVo;
import com.chinavisionary.paymentlibrary.vo.PayBillVo;
import com.chinavisionary.paymentlibrary.vo.PayStateVo;
import com.chinavisionary.paymentlibrary.vo.RechargeWaterEleVo;
import com.chinavisionary.paymentlibrary.vo.RequestOrderTicketBo;
import com.chinavisionary.paymentlibrary.vo.ReserveFddContractVo;
import com.chinavisionary.paymentlibrary.vo.ResponseDiscountResultVo;
import com.chinavisionary.paymentlibrary.vo.ResponseDiscountVo;
import com.chinavisionary.paymentlibrary.vo.ResponseFddSignUrlVo;
import com.chinavisionary.paymentlibrary.vo.ResponseFoodVo;
import com.chinavisionary.paymentlibrary.vo.ResponseOrderTicketBo;
import com.chinavisionary.paymentlibrary.vo.ResponseWalletVo;
import h.q.f;
import h.q.o;
import h.q.s;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    @o("valueadded/purchase")
    h.b<ResponseContent<PayBillResultVo>> createCleanOrder(@h.q.a CreateCleanOrderVo createCleanOrderVo);

    @o("carts/payments/bills")
    h.b<NewResponseStateVo> createFoodOrder(@h.q.a CreateFoodOrderVo createFoodOrderVo);

    @o("commodity/place/order")
    h.b<PayBillResultVo> createNewCleanOrder(@h.q.a CreateIncrementOrderParamBo createIncrementOrderParamBo);

    @f("contracts/{contractkey}/sign/url")
    h.b<ResponseContent<ResponseFddSignUrlVo>> getFddContactUrl(@s("contractkey") String str);

    @f("carts/payments/discounts/{toBePurchasedCommoditiesKey}")
    h.b<ResponseDiscountVo> getFoodDiscountList(@s("toBePurchasedCommoditiesKey") String str);

    @o("carts/payments/bills/amounts")
    h.b<ResponseDiscountResultVo> getFoodDiscountPrice(@h.q.a CreateFoodOrderVo createFoodOrderVo);

    @f("carts/payments/commodities/{toBePurchasedCommoditiesKey}")
    h.b<ResponseFoodVo> getFoodPayData(@s("toBePurchasedCommoditiesKey") String str);

    @f("bills/{key}/payment/detail")
    h.b<ResponseContent<PayStateVo>> getPayState(@s("key") String str);

    @f("rent/reserve/{reserveKey}/sign")
    h.b<ResponseContent<ReserveFddContractVo>> getReserveFdd(@s("reserveKey") String str);

    @f("account/balance")
    h.b<ResponseContent<ResponseWalletVo>> getWalletBalance();

    @o("bills/pay")
    h.b<ResponseContent<PayBillResultVo>> postPayBill(@h.q.a PayBillVo payBillVo);

    @o(RequestErrDto.GET_ORDER_IS_TICKET_URL)
    h.b<ResponseOrderTicketBo> postQueryOrderIsTicket(@h.q.a RequestOrderTicketBo requestOrderTicketBo);

    @o("account/recharge")
    h.b<PayBillResultVo> postRechargeWaterEle(@h.q.a RechargeWaterEleVo rechargeWaterEleVo);

    @o("user/balance")
    h.b<ResponseWalletVo> postWalletBalance(@h.q.a BaseVo baseVo);
}
