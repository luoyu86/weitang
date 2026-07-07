package com.chinavisionary.microtang.bill.model;

import androidx.lifecycle.MutableLiveData;
import c.e.c.j.a.a;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.bill.vo.BillDetailsVo;
import com.chinavisionary.microtang.bill.vo.BillVo;
import com.chinavisionary.microtang.sign.vo.ResponseFirstFeeVo;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BillModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MutableLiveData<ResponseRowsVo<BillVo>> f6876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<BillDetailsVo> f6877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MutableLiveData<ResponseFirstFeeVo> f6878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f6879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f6880e;

    public BillModel() {
        super(null);
        this.f6876a = new MutableLiveData<>();
        this.f6877b = new MutableLiveData<>();
        this.f6878c = new MutableLiveData<>();
        this.f6879d = new MutableLiveData<>();
        this.f6880e = (a) create(a.class);
    }

    public void confirmBillFirstFee(String str) {
        if (checkParamIsInvalid(str)) {
            this.f6880e.confirmBillFirstFee(str).enqueue(enqueueResponse(this.f6879d));
        }
    }

    public MutableLiveData<ResponseStateVo> getBillConfirmResult() {
        return this.f6879d;
    }

    public void getBillDetails(String str) {
        if (checkParamIsInvalid(str)) {
            this.f6880e.getBillDetails(str).enqueue(enqueueResponse(this.f6877b));
        }
    }

    public MutableLiveData<BillDetailsVo> getBillDetailsLiveData() {
        return this.f6877b;
    }

    public void getBillFirstFee(String str) {
        if (checkParamIsInvalid(str)) {
            this.f6880e.getBillFirstFee(str).enqueue(enqueueResponse(this.f6878c));
        }
    }

    public MutableLiveData<ResponseFirstFeeVo> getBillFirstFeeLiveData() {
        return this.f6878c;
    }

    public void getBillList(PageBo pageBo, int i2) {
        Map<String, String> queryMap = getQueryMap(pageBo);
        queryMap.put("queryType", String.valueOf(i2));
        this.f6880e.getBillList(queryMap).enqueue(enqueueResponse(this.f6876a));
    }

    public MutableLiveData<ResponseRowsVo<BillVo>> getBillListLiveData() {
        return this.f6876a;
    }
}
