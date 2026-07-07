package com.chinavisionary.microtang.hydropower.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.j;
import c.e.c.s.j.a;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.hydropower.vo.CreateOrderBo;
import com.chinavisionary.microtang.hydropower.vo.CreatePayOrderBo;
import com.chinavisionary.microtang.hydropower.vo.CreateWaterElectriBo;
import com.chinavisionary.microtang.hydropower.vo.ElectricBalanceVo;
import com.chinavisionary.microtang.hydropower.vo.ElectricVo;
import com.chinavisionary.microtang.hydropower.vo.PayRecordVo;
import com.chinavisionary.microtang.hydropower.vo.RentFeeVo;
import com.chinavisionary.microtang.hydropower.vo.RoomOtherFeeUnitVo;
import com.chinavisionary.microtang.hydropower.vo.WaterBalanceVo;
import com.chinavisionary.microtang.hydropower.vo.WaterElectriVo;
import com.chinavisionary.microtang.me.vo.RecordTabVo;
import com.chinavisionary.microtang.me.vo.RecordVo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class PayHydropowerModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MutableLiveData<ResponseRowsVo<PayRecordVo>> f7234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<NewResponseRowsVo<ElectricVo>> f7235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MutableLiveData<ResponseRowsVo<ElectricVo>> f7236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MutableLiveData<ResponseRowsVo<RecordTabVo>> f7237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MutableLiveData<WaterBalanceVo> f7238e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MutableLiveData<ResponseRowsVo<RentFeeVo>> f7239f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MutableLiveData<ElectricBalanceVo> f7240g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f7241h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f7242i;
    public MutableLiveData<ResponseStateVo> j;
    public MutableLiveData<WaterElectriVo> k;
    public MutableLiveData<WaterElectriVo> l;
    public MutableLiveData<RoomOtherFeeUnitVo> m;
    public MutableLiveData<ResponseRowsVo<RecordVo>> n;
    public a o;

    public PayHydropowerModel() {
        super(j.getInstance().getH5ApiBaseUrl());
        this.f7234a = new MutableLiveData<>();
        this.f7235b = new MutableLiveData<>();
        this.f7236c = new MutableLiveData<>();
        this.f7237d = new MutableLiveData<>();
        this.f7238e = new MutableLiveData<>();
        this.f7239f = new MutableLiveData<>();
        this.f7240g = new MutableLiveData<>();
        this.f7241h = new MutableLiveData<>();
        this.f7242i = new MutableLiveData<>();
        this.j = new MutableLiveData<>();
        this.k = new MutableLiveData<>();
        this.l = new MutableLiveData<>();
        this.m = new MutableLiveData<>();
        this.n = new MutableLiveData<>();
        this.o = (a) create(a.class);
    }

    public void createElePay(CreatePayOrderBo createPayOrderBo) {
        this.o.createPayOrder(createPayOrderBo.getOrderKey(), createPayOrderBo).enqueue(enqueueResponse(this.j));
    }

    public void createElectriPayCode(CreateWaterElectriBo createWaterElectriBo) {
        this.o.createElectriPay(createWaterElectriBo).enqueue(enqueueResponse(this.k));
    }

    public void createElectric(CreateOrderBo createOrderBo) {
        this.o.createElectricOrder(createOrderBo).enqueue(enqueueResponse(this.f7241h));
    }

    public void createPay(CreatePayOrderBo createPayOrderBo) {
        this.o.createPayOrder(createPayOrderBo.getOrderKey(), createPayOrderBo).enqueue(enqueueResponse(this.j));
    }

    public void createWater(CreateOrderBo createOrderBo) {
        this.o.createWaterOrder(createOrderBo).enqueue(enqueueResponse(this.f7242i));
    }

    public void createWaterPayCode(CreateWaterElectriBo createWaterElectriBo) {
        this.o.createWaterPay(createWaterElectriBo).enqueue(enqueueResponse(this.l));
    }

    public MutableLiveData<WaterElectriVo> getElectriVoLiveData() {
        return this.k;
    }

    public void getElectricBalance() {
        this.o.getElectricBalance().enqueue(enqueueResponse(this.f7240g));
    }

    public MutableLiveData<ElectricBalanceVo> getElectricBalanceVoLiveData() {
        return this.f7240g;
    }

    public void getElectricList(int i2) {
        this.o.getElectricList(String.valueOf(i2)).enqueue(enqueueResponse(this.f7236c));
    }

    public MutableLiveData<ResponseRowsVo<ElectricVo>> getElectricLiveData() {
        return this.f7236c;
    }

    public MutableLiveData<ResponseStateVo> getElectricOrderResultLiveData() {
        return this.f7241h;
    }

    public MutableLiveData<ResponseStateVo> getPayOrderLiveData() {
        return this.j;
    }

    public void getPayRecordList(PageBo pageBo) {
        this.o.getPayRecordList(getQueryMap(pageBo)).enqueue(enqueueResponse(this.f7234a));
    }

    public MutableLiveData<ResponseRowsVo<PayRecordVo>> getPayRecordLiveData() {
        return this.f7234a;
    }

    public void getRechargeWalletList() {
        this.o.getRechargeWalletList(new HashMap()).enqueue(enqueueBaseVoResponse(this.f7235b));
    }

    public MutableLiveData<ResponseRowsVo<RecordVo>> getRecordList() {
        return this.n;
    }

    public void getRecordTabList() {
        this.o.getRecordTabList().enqueue(enqueueResponse(this.f7237d));
    }

    public MutableLiveData<ResponseRowsVo<RecordTabVo>> getRecordTabLiveData() {
        return this.f7237d;
    }

    public void getRentFee() {
        this.o.getRentFee().enqueue(enqueueResponse(this.f7239f));
    }

    public MutableLiveData<ResponseRowsVo<RentFeeVo>> getRentFeeVoLiveData() {
        return this.f7239f;
    }

    public MutableLiveData<RoomOtherFeeUnitVo> getRoomFeeLiveData() {
        return this.m;
    }

    public void getRoomOtherFee() {
        this.o.getRoomOtherFee().enqueue(enqueueResponse(this.m));
    }

    public void getWaterBalance() {
        this.o.getWaterBalance().enqueue(enqueueResponse(this.f7238e));
    }

    public MutableLiveData<WaterBalanceVo> getWaterBalanceVoLiveData() {
        return this.f7238e;
    }

    public void getWaterList(int i2) {
    }

    public MutableLiveData<NewResponseRowsVo<ElectricVo>> getWaterLiveData() {
        return this.f7235b;
    }

    public MutableLiveData<ResponseStateVo> getWaterOrderResultLiveData() {
        return this.f7242i;
    }

    public MutableLiveData<WaterElectriVo> getWaterVoLiveData() {
        return this.l;
    }

    public void getRecordList(PageBo pageBo, int i2) {
        Map<String, String> queryMap = getQueryMap(pageBo);
        queryMap.put("deviceType", String.valueOf(i2));
        this.o.getWaterRecordList(queryMap).enqueue(enqueueResponse(this.n));
    }
}
