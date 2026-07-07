package com.chinavisionary.paymentlibrary.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.j;
import c.e.a.d.x;
import c.e.d.z.a;
import c.e.d.z.b;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.core.app.net.base.model.SingleLiveEvent;
import com.chinavisionary.paymentlibrary.R;
import com.chinavisionary.paymentlibrary.vo.CreateCleanOrderVo;
import com.chinavisionary.paymentlibrary.vo.CreateFoodOrderVo;
import com.chinavisionary.paymentlibrary.vo.CreateIncrementOrderParamBo;
import com.chinavisionary.paymentlibrary.vo.H5CreatePayBillBo;
import com.chinavisionary.paymentlibrary.vo.PayBillResultVo;
import com.chinavisionary.paymentlibrary.vo.PayBillVo;
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
import com.chinavisionary.paymentlibrary.vo.ResponseDiscountResultVo;
import com.chinavisionary.paymentlibrary.vo.ResponseDiscountVo;
import com.chinavisionary.paymentlibrary.vo.ResponseFddSignUrlVo;
import com.chinavisionary.paymentlibrary.vo.ResponseFoodVo;
import com.chinavisionary.paymentlibrary.vo.ResponseH5BillDetailsVo;
import com.chinavisionary.paymentlibrary.vo.ResponseOrderTicketBo;
import com.chinavisionary.paymentlibrary.vo.ResponsePayModeBo;
import com.chinavisionary.paymentlibrary.vo.ResponseUseCouponResultBo;
import com.chinavisionary.paymentlibrary.vo.ResponseWalletVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NewBillModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<PayBillResultVo> f8755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<PayBillResultVo> f8756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<ResponseOrderTicketBo> f8757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<ResponseH5BillDetailsVo> f8758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<NewResponseStateVo> f8759e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<PayStateVo> f8760f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<ResponseFoodVo> f8761g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData<ResponseDiscountVo> f8762h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData<ResponseDiscountResultVo> f8763i;
    public final SingleLiveEvent<ResponseFddSignUrlVo> j;
    public final SingleLiveEvent<ReserveFddContractVo> k;
    public final MutableLiveData<ResponseWalletVo> l;
    public final MutableLiveData<ResponseCouponVo> m;
    public final MutableLiveData<ResponseUseCouponResultBo> n;
    public final MutableLiveData<ResponseH5BillDetailsVo> o;
    public final MutableLiveData<ResponsePayModeBo> p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final a f8764q;
    public final b r;

    public NewBillModel() {
        super(j.getInstance().getH5ApiBaseUrl());
        this.f8755a = new MutableLiveData<>();
        this.f8756b = new MutableLiveData<>();
        this.f8757c = new MutableLiveData<>();
        this.f8758d = new MutableLiveData<>();
        this.f8759e = new MutableLiveData<>();
        this.f8760f = new MutableLiveData<>();
        this.f8761g = new MutableLiveData<>();
        this.f8762h = new MutableLiveData<>();
        this.f8763i = new MutableLiveData<>();
        this.j = new SingleLiveEvent<>();
        this.k = new SingleLiveEvent<>();
        this.l = new MutableLiveData<>();
        this.m = new MutableLiveData<>();
        this.n = new MutableLiveData<>();
        this.o = new MutableLiveData<>();
        this.p = new MutableLiveData<>();
        this.f8764q = (a) create(a.class);
        this.r = (b) create(b.class);
    }

    public void countFoodDiscountPrice(CreateFoodOrderVo createFoodOrderVo) {
        if (checkObjectParamIsValid(createFoodOrderVo)) {
            this.f8764q.getFoodDiscountPrice(createFoodOrderVo).enqueue(enqueueBaseVoResponse(this.f8763i));
        }
    }

    public void createCleanOrder(CreateCleanOrderVo createCleanOrderVo) {
        if (checkObjectParamIsValid(createCleanOrderVo)) {
            this.f8764q.createCleanOrder(createCleanOrderVo).enqueue(enqueueResponse(this.f8755a));
        }
    }

    public void createFoodPayBill(CreateFoodOrderVo createFoodOrderVo) {
        if (checkObjectParamIsValid(createFoodOrderVo)) {
            this.f8764q.createFoodOrder(createFoodOrderVo).enqueue(enqueueBaseVoResponse(this.f8759e));
        }
    }

    public void createNewCleanOrder(CreateIncrementOrderParamBo createIncrementOrderParamBo) {
        if (checkObjectParamIsValid(createIncrementOrderParamBo)) {
            this.f8764q.createNewCleanOrder(createIncrementOrderParamBo).enqueue(enqueueBaseVoResponse(this.f8756b));
        }
    }

    public void getBillDetails(String str) {
        RequestBillDetailsParamBo requestBillDetailsParamBo = new RequestBillDetailsParamBo();
        requestBillDetailsParamBo.setPrimaryKey(str);
        this.r.getBillDetails(requestBillDetailsParamBo).enqueue(enqueueBaseVoResponse(this.o));
    }

    public MutableLiveData<ResponseH5BillDetailsVo> getBillDetailsResult() {
        return this.o;
    }

    public SingleLiveEvent<ResponseFddSignUrlVo> getContractFddResult() {
        return this.j;
    }

    public void getCouponList(List<String> list, String str) {
        RequestCouponParamBo requestCouponParamBo = new RequestCouponParamBo();
        requestCouponParamBo.setApplyTos(list);
        requestCouponParamBo.setOrderId(str);
        this.r.getCouponList(requestCouponParamBo).enqueue(enqueueBaseVoResponse(this.m));
    }

    public MutableLiveData<ResponseCouponVo> getCouponResult() {
        return this.m;
    }

    public MutableLiveData<ResponseDiscountVo> getDiscountListResult() {
        return this.f8762h;
    }

    public void getDiscountListToOrderKey(String str) {
        if (checkParamIsInvalid(str)) {
            this.f8764q.getFoodDiscountList(str).enqueue(enqueueBaseVoResponse(this.f8762h));
        }
    }

    public void getFddContactUrl(String str) {
        if (checkParamIsInvalid(str)) {
            RequestFddContractParamBo requestFddContractParamBo = new RequestFddContractParamBo();
            requestFddContractParamBo.setContractKey(str);
            this.r.getFddSignUrl(requestFddContractParamBo).enqueue(enqueueBaseVoResponse(this.j));
        }
    }

    public MutableLiveData<ResponseDiscountResultVo> getFoodDiscountResult() {
        return this.f8763i;
    }

    public MutableLiveData<NewResponseStateVo> getFoodOrderResult() {
        return this.f8759e;
    }

    public void getFoodPayData(String str) {
        if (checkParamIsInvalid(str)) {
            this.f8764q.getFoodPayData(str).enqueue(enqueueBaseVoResponse(this.f8761g));
        }
    }

    public MutableLiveData<ResponseFoodVo> getFoodResult() {
        return this.f8761g;
    }

    public MutableLiveData<PayBillResultVo> getIncrementPayBillResultLiveData() {
        return this.f8756b;
    }

    public MutableLiveData<ResponseOrderTicketBo> getOrderTicketResult() {
        return this.f8757c;
    }

    public MutableLiveData<PayBillResultVo> getPayBillResultLiveData() {
        return this.f8755a;
    }

    public void getPayMode(String str) {
        if (checkParamIsInvalid(str)) {
            RequestPayModelBo requestPayModelBo = new RequestPayModelBo();
            requestPayModelBo.setOrderId(str);
            this.r.getPayMode(requestPayModelBo).enqueue(enqueueBaseVoResponse(this.p));
        }
    }

    public MutableLiveData<ResponsePayModeBo> getPayModeResult() {
        return this.p;
    }

    public MutableLiveData<ResponseH5BillDetailsVo> getPayOrderCreateResult() {
        return this.f8758d;
    }

    public void getPayState(String str) {
        if (checkParamIsInvalid(str) && c.e.a.a.a.getInstance().isH5Model()) {
            RequestPayStateParamBo requestPayStateParamBo = new RequestPayStateParamBo();
            requestPayStateParamBo.setPayId(str);
            requestPayStateParamBo.setPaymentId(str);
            this.r.getPayState(requestPayStateParamBo).enqueue(enqueueBaseVoResponse(this.f8760f));
        }
    }

    public MutableLiveData<PayStateVo> getPayStateResult() {
        return this.f8760f;
    }

    public MutableLiveData<ResponseUseCouponResultBo> getPreviewUseCouponResult() {
        return this.n;
    }

    public void getReserveFdd(String str) {
        if (checkParamIsInvalid(str)) {
            RequestFddReserveContractParamBo requestFddReserveContractParamBo = new RequestFddReserveContractParamBo();
            requestFddReserveContractParamBo.setReserveKey(str);
            this.r.getFddReserveUrl(requestFddReserveContractParamBo).enqueue(enqueueBaseVoResponse(this.k));
        }
    }

    public SingleLiveEvent<ReserveFddContractVo> getReserveFddResult() {
        return this.k;
    }

    public void getWalletBalance() {
        this.f8764q.postWalletBalance(new BaseVo()).enqueue(enqueueBaseVoResponse(this.l));
    }

    public MutableLiveData<ResponseWalletVo> getWalletResult() {
        return this.l;
    }

    public void postPayBill(PayBillVo payBillVo) {
        if (checkObjectParamIsValid(payBillVo)) {
            int payChannel = payBillVo.getPayChannel();
            switch (payChannel) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    H5CreatePayBillBo createPayBillBo = payBillVo.getCreatePayBillBo();
                    createPayBillBo.setPayType(Integer.valueOf(payChannel));
                    createPayBillBo.setPayMode(ResponsePayModeBo.getPayTypeToMode(payChannel));
                    this.r.createPaySignNew(createPayBillBo).enqueue(enqueueBaseVoResponse(this.f8755a));
                    break;
                default:
                    handlerResponseErr(null, x.getString(R.string.core_lib_tip_pay_channel_is_empty) + "postPayBill");
                    break;
            }
        }
    }

    public void postPayWaterEle(RechargeWaterEleVo rechargeWaterEleVo) {
        if (checkObjectParamIsValid(rechargeWaterEleVo)) {
            rechargeWaterEleVo.getPayChannel();
            this.r.postRechargeWaterEle(rechargeWaterEleVo).enqueue(enqueueBaseVoResponse(this.f8756b));
        }
    }

    public void postPreViewUseCoupon(RequestUseCouponParamBo requestUseCouponParamBo) {
        this.r.postUseCouponPreview(requestUseCouponParamBo).enqueue(enqueueBaseVoResponse(this.n));
    }

    public void postQueryOrderIsTicket(RequestOrderTicketBo requestOrderTicketBo) {
        if (checkObjectParamIsValid(requestOrderTicketBo)) {
            this.f8764q.postQueryOrderIsTicket(requestOrderTicketBo).enqueue(enqueueBaseVoResponse(this.f8757c));
        }
    }
}
