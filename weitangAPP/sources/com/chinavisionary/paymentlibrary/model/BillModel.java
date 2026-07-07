package com.chinavisionary.paymentlibrary.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.x;
import c.e.d.z.a;
import c.e.d.z.b;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.paymentlibrary.R;
import com.chinavisionary.paymentlibrary.vo.CreateCleanOrderVo;
import com.chinavisionary.paymentlibrary.vo.CreateFoodOrderVo;
import com.chinavisionary.paymentlibrary.vo.PayBillResultVo;
import com.chinavisionary.paymentlibrary.vo.PayBillVo;
import com.chinavisionary.paymentlibrary.vo.PayStateVo;
import com.chinavisionary.paymentlibrary.vo.RechargeWaterEleVo;
import com.chinavisionary.paymentlibrary.vo.ReserveFddContractVo;
import com.chinavisionary.paymentlibrary.vo.ResponseCouponVo;
import com.chinavisionary.paymentlibrary.vo.ResponseDiscountResultVo;
import com.chinavisionary.paymentlibrary.vo.ResponseDiscountVo;
import com.chinavisionary.paymentlibrary.vo.ResponseFddSignUrlVo;
import com.chinavisionary.paymentlibrary.vo.ResponseFoodVo;
import com.chinavisionary.paymentlibrary.vo.ResponseH5BillDetailsVo;
import com.chinavisionary.paymentlibrary.vo.ResponseWalletVo;

/* JADX INFO: loaded from: classes2.dex */
public class BillModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<PayBillResultVo> f8744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<String> f8745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<PayStateVo> f8746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<ResponseFoodVo> f8747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<ResponseDiscountVo> f8748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<ResponseDiscountResultVo> f8749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<ResponseFddSignUrlVo> f8750g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData<ReserveFddContractVo> f8751h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData<ResponseWalletVo> f8752i;
    public final MutableLiveData<ResponseCouponVo> j;
    public final MutableLiveData<ResponseH5BillDetailsVo> k;
    public final a l;
    public final b m;

    public BillModel() {
        super(null);
        this.f8744a = new MutableLiveData<>();
        this.f8745b = new MutableLiveData<>();
        this.f8746c = new MutableLiveData<>();
        this.f8747d = new MutableLiveData<>();
        this.f8748e = new MutableLiveData<>();
        this.f8749f = new MutableLiveData<>();
        this.f8750g = new MutableLiveData<>();
        this.f8751h = new MutableLiveData<>();
        this.f8752i = new MutableLiveData<>();
        this.j = new MutableLiveData<>();
        this.k = new MutableLiveData<>();
        this.l = (a) create(a.class);
        this.m = (b) create(b.class);
    }

    public void countFoodDiscountPrice(CreateFoodOrderVo createFoodOrderVo) {
        checkObjectParamIsValid(createFoodOrderVo);
    }

    public void createCleanOrder(CreateCleanOrderVo createCleanOrderVo) {
        if (checkObjectParamIsValid(createCleanOrderVo)) {
            this.l.createCleanOrder(createCleanOrderVo).enqueue(enqueueResponse(this.f8744a));
        }
    }

    public void createFoodPayBill(CreateFoodOrderVo createFoodOrderVo) {
        checkObjectParamIsValid(createFoodOrderVo);
    }

    public MutableLiveData<ResponseH5BillDetailsVo> getBillDetailsResult() {
        return this.k;
    }

    public MutableLiveData<ResponseFddSignUrlVo> getContractFddResult() {
        return this.f8750g;
    }

    public MutableLiveData<ResponseCouponVo> getCouponResult() {
        return this.j;
    }

    public MutableLiveData<ResponseDiscountVo> getDiscountListResult() {
        return this.f8748e;
    }

    public void getDiscountListToOrderKey(String str) {
        checkParamIsInvalid(str);
    }

    public void getFddContactUrl(String str) {
        if (checkParamIsInvalid(str)) {
            this.l.getFddContactUrl(str).enqueue(enqueueResponse(this.f8750g));
        }
    }

    public MutableLiveData<ResponseDiscountResultVo> getFoodDiscountResult() {
        return this.f8749f;
    }

    public MutableLiveData<String> getFoodOrderResult() {
        return this.f8745b;
    }

    public void getFoodPayData(String str) {
        checkParamIsInvalid(str);
    }

    public MutableLiveData<ResponseFoodVo> getFoodResult() {
        return this.f8747d;
    }

    public MutableLiveData<PayBillResultVo> getPayBillResultLiveData() {
        return this.f8744a;
    }

    public void getPayState(String str) {
        if (checkParamIsInvalid(str)) {
            this.l.getPayState(str).enqueue(enqueueResponse(this.f8746c));
        }
    }

    public MutableLiveData<PayStateVo> getPayStateResult() {
        return this.f8746c;
    }

    public void getReserveFdd(String str) {
        if (checkParamIsInvalid(str)) {
            this.l.getReserveFdd(str).enqueue(enqueueResponse(this.f8751h));
        }
    }

    public MutableLiveData<ReserveFddContractVo> getReserveFddResult() {
        return this.f8751h;
    }

    public void getWalletBalance() {
        this.l.getWalletBalance().enqueue(enqueueResponse(this.f8752i));
    }

    public MutableLiveData<ResponseWalletVo> getWalletResult() {
        return this.f8752i;
    }

    public void postPayBill(PayBillVo payBillVo) {
        if (checkObjectParamIsValid(payBillVo)) {
            switch (payBillVo.getPayChannel()) {
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
                    this.l.postPayBill(payBillVo).enqueue(enqueueResponse(this.f8744a));
                    break;
                default:
                    handlerResponseErr(null, x.getString(R.string.core_lib_tip_pay_channel_is_empty));
                    break;
            }
        }
    }

    public void postPayWaterEle(RechargeWaterEleVo rechargeWaterEleVo) {
        if (checkObjectParamIsValid(rechargeWaterEleVo)) {
            this.l.postRechargeWaterEle(rechargeWaterEleVo).enqueue(enqueueBaseVoResponse(this.f8744a));
        }
    }
}
