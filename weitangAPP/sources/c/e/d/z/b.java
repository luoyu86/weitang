package c.e.d.z;

import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.paymentlibrary.vo.H5CreatePayBillBo;
import com.chinavisionary.paymentlibrary.vo.PayBillResultVo;
import com.chinavisionary.paymentlibrary.vo.PayStateVo;
import com.chinavisionary.paymentlibrary.vo.RechargeWaterEleVo;
import com.chinavisionary.paymentlibrary.vo.RequestBillDetailsParamBo;
import com.chinavisionary.paymentlibrary.vo.RequestCouponParamBo;
import com.chinavisionary.paymentlibrary.vo.RequestFddContractParamBo;
import com.chinavisionary.paymentlibrary.vo.RequestFddReserveContractParamBo;
import com.chinavisionary.paymentlibrary.vo.RequestOrderTicketBo;
import com.chinavisionary.paymentlibrary.vo.RequestPayModelBo;
import com.chinavisionary.paymentlibrary.vo.RequestPayStateParamBo;
import com.chinavisionary.paymentlibrary.vo.RequestUseCouponParamBo;
import com.chinavisionary.paymentlibrary.vo.ReserveFddContractVo;
import com.chinavisionary.paymentlibrary.vo.ResponseCouponVo;
import com.chinavisionary.paymentlibrary.vo.ResponseFddSignUrlVo;
import com.chinavisionary.paymentlibrary.vo.ResponseH5BillDetailsVo;
import com.chinavisionary.paymentlibrary.vo.ResponseOrderTicketBo;
import com.chinavisionary.paymentlibrary.vo.ResponsePayModeBo;
import com.chinavisionary.paymentlibrary.vo.ResponseUseCouponResultBo;
import h.q.o;

/* JADX INFO: loaded from: classes2.dex */
public interface b {
    @o("business/pay/payment/create")
    h.b<PayBillResultVo> createPayOrder(@h.q.a H5CreatePayBillBo h5CreatePayBillBo);

    @o("business/query/order/paysign")
    h.b<PayBillResultVo> createPaySign(@h.q.a H5CreatePayBillBo h5CreatePayBillBo);

    @o("business/company/pay/order/pay/sign")
    h.b<PayBillResultVo> createPaySignNew(@h.q.a H5CreatePayBillBo h5CreatePayBillBo);

    @o("user/bill/detail")
    h.b<ResponseH5BillDetailsVo> getBillDetails(@h.q.a RequestBillDetailsParamBo requestBillDetailsParamBo);

    @o("my/select/coupon/list")
    h.b<ResponseCouponVo> getCouponList(@h.q.a RequestCouponParamBo requestCouponParamBo);

    @o("contract/reserve/get/sign/url")
    h.b<ReserveFddContractVo> getFddReserveUrl(@h.q.a RequestFddReserveContractParamBo requestFddReserveContractParamBo);

    @o("contract/rent/signing/url")
    h.b<ResponseFddSignUrlVo> getFddSignUrl(@h.q.a RequestFddContractParamBo requestFddContractParamBo);

    @o("business/company/pay/detail")
    h.b<PayStateVo> getPayDetails(@h.q.a RequestPayStateParamBo requestPayStateParamBo);

    @o("business/company/pay/find/paymode")
    h.b<ResponsePayModeBo> getPayMode(@h.q.a RequestPayModelBo requestPayModelBo);

    @o("business/company/pay/status")
    h.b<PayStateVo> getPayState(@h.q.a RequestPayStateParamBo requestPayStateParamBo);

    @o(RequestErrDto.GET_ORDER_IS_TICKET_URL)
    h.b<ResponseOrderTicketBo> postQueryOrderIsTicket(@h.q.a RequestOrderTicketBo requestOrderTicketBo);

    @o("account/recharge")
    h.b<PayBillResultVo> postRechargeWaterEle(@h.q.a RechargeWaterEleVo rechargeWaterEleVo);

    @o("business/order/addcoupon/preview")
    h.b<ResponseUseCouponResultBo> postUseCouponPreview(@h.q.a RequestUseCouponParamBo requestUseCouponParamBo);
}
