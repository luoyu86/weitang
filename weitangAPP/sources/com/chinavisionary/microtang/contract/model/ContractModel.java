package com.chinavisionary.microtang.contract.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.x;
import c.e.c.o.a.a;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.contract.vo.ContractChangeResponse;
import com.chinavisionary.microtang.contract.vo.ContractClauseVo;
import com.chinavisionary.microtang.contract.vo.ContractCommentVo;
import com.chinavisionary.microtang.contract.vo.ContractExitRentPropertyStateVo;
import com.chinavisionary.microtang.contract.vo.ContractExitRentStateDetailsVo;
import com.chinavisionary.microtang.contract.vo.ContractExitRentVo;
import com.chinavisionary.microtang.contract.vo.ContractListDetailsVo;
import com.chinavisionary.microtang.contract.vo.ContractListVo;
import com.chinavisionary.microtang.contract.vo.ContractLiveTogetherVo;
import com.chinavisionary.microtang.contract.vo.ContractPropertyStateVo;
import com.chinavisionary.microtang.contract.vo.ContractRentFeeVo;
import com.chinavisionary.microtang.contract.vo.ContractTogetherLiveVo;
import com.chinavisionary.microtang.contract.vo.RentBackFeePreviewListVo;
import com.chinavisionary.microtang.contract.vo.RequestExitRentVo;
import com.chinavisionary.microtang.contract.vo.ResponseContractVo;
import com.chinavisionary.microtang.contract.vo.ResponseFddSignUrlVo;
import com.chinavisionary.microtang.contract.vo.ResponseSignMainInfoVo;
import com.chinavisionary.microtang.contract.vo.ResultTreatyVo;
import com.chinavisionary.microtang.contract.vo.SignMainInfoVo;
import com.chinavisionary.microtang.contract.vo.SubmitContractCommentBo;
import com.chinavisionary.microtang.contract.vo.SubmitPropertyStateVo;
import com.chinavisionary.microtang.contract.vo.UpdateTogetherLiveBo;
import com.chinavisionary.microtang.sign.vo.ContactDetailsVo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ContractModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f7175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<ContractExitRentVo> f7176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MutableLiveData<ContractChangeResponse> f7177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f7178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MutableLiveData<ContractExitRentStateDetailsVo> f7179e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MutableLiveData<ResponseRowsVo<ContractExitRentPropertyStateVo>> f7180f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f7181g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MutableLiveData<ResultTreatyVo> f7182h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MutableLiveData<ResponseContractVo> f7183i;
    public MutableLiveData<ResponseRowsVo<ContractListVo>> j;
    public MutableLiveData<ContactDetailsVo> k;
    public MutableLiveData<ContractListDetailsVo> l;
    public MutableLiveData<ContractCommentVo> m;
    public MutableLiveData<String> n;
    public MutableLiveData<ResponseSignMainInfoVo> o;
    public MutableLiveData<ResponseFddSignUrlVo> p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public MutableLiveData<ResponseRowsVo<ContractPropertyStateVo>> f7184q;
    public MutableLiveData<ResponseRowsVo<ContractRentFeeVo>> r;
    public MutableLiveData<ResponseRowsVo<ContractClauseVo>> s;
    public MutableLiveData<ContractLiveTogetherVo<ContractTogetherLiveVo>> t;
    public MutableLiveData<ResponseStateVo> u;
    public MutableLiveData<RentBackFeePreviewListVo> v;

    public ContractModel() {
        super(null);
        this.f7176b = new MutableLiveData<>();
        this.f7177c = new MutableLiveData<>();
        this.f7178d = new MutableLiveData<>();
        this.f7179e = new MutableLiveData<>();
        this.f7180f = new MutableLiveData<>();
        this.f7181g = new MutableLiveData<>();
        this.f7182h = new MutableLiveData<>();
        this.f7183i = new MutableLiveData<>();
        this.j = new MutableLiveData<>();
        this.k = new MutableLiveData<>();
        this.l = new MutableLiveData<>();
        this.m = new MutableLiveData<>();
        this.n = new MutableLiveData<>();
        this.o = new MutableLiveData<>();
        this.p = new MutableLiveData<>();
        this.f7184q = new MutableLiveData<>();
        this.r = new MutableLiveData<>();
        this.s = new MutableLiveData<>();
        this.t = new MutableLiveData<>();
        this.u = new MutableLiveData<>();
        this.v = new MutableLiveData<>();
        this.f7175a = (a) create(a.class);
    }

    public void cancelExitRent(String str) {
        if (checkParamIsInvalid(str)) {
            this.f7175a.cancelExitRent(str).enqueue(enqueueResponse(this.f7181g));
        }
    }

    public void cancelPay(String str) {
        if (checkParamIsInvalid(str)) {
            this.f7175a.cancelPay(str).enqueue(enqueueResponse(this.u));
        }
    }

    public void finishExitRent(String str) {
        if (checkParamIsInvalid(str)) {
            this.f7175a.finishExitRent(str).enqueue(enqueueResponse(this.f7181g));
        }
    }

    public MutableLiveData<ResponseStateVo> getCancelPayLiveData() {
        return this.u;
    }

    public MutableLiveData<ContractChangeResponse> getChangeRent() {
        return this.f7177c;
    }

    public MutableLiveData<ResponseRowsVo<ContractListVo>> getContactList() {
        return this.j;
    }

    public MutableLiveData<ContractListDetailsVo> getContactListDetailsLiveData() {
        return this.l;
    }

    public void getContactRentFeeList(String str) {
        if (checkParamIsInvalid(str)) {
            this.f7175a.getContactRentFeeDetails(str).enqueue(enqueueResponse(this.r));
        }
    }

    public void getContractChangeRent(String str) {
        if (checkParamIsInvalid(str)) {
            this.f7175a.getContractChangeRent(str).enqueue(enqueueResponse(this.f7177c));
        }
    }

    public MutableLiveData<ResponseRowsVo<ContractClauseVo>> getContractClauseList() {
        return this.s;
    }

    public MutableLiveData<ContractCommentVo> getContractCommentInfo() {
        return this.m;
    }

    public void getContractExitRentDetails(String str) {
        if (checkParamIsInvalid(str)) {
            this.f7175a.getContractExitRentDetails(str).enqueue(enqueueResponse(this.f7179e));
        }
    }

    public void getContractExitRentInfo(String str) {
        if (checkParamIsInvalid(str)) {
            this.f7175a.getContractExitRent(str).enqueue(enqueueResponse(this.f7176b));
        }
    }

    public void getContractExitRentPropertyList(String str) {
        if (checkParamIsInvalid(str)) {
            this.f7175a.getContractExitRentPropertyList(str).enqueue(enqueueResponse(this.f7180f));
        }
    }

    public void getContractList(PageBo pageBo, int i2) {
        Map<String, String> queryMap = getQueryMap(pageBo);
        queryMap.put("queryType", String.valueOf(i2));
        this.f7175a.getContractList(queryMap).enqueue(enqueueResponse(this.j));
    }

    public void getContractListDetails(String str) {
        if (checkParamIsInvalid(str)) {
            this.f7175a.getContractListDetails(str).enqueue(enqueueResponse(this.l));
        }
    }

    public MutableLiveData<ResponseRowsVo<ContractRentFeeVo>> getContractRentFeeList() {
        return this.r;
    }

    public MutableLiveData<ContractLiveTogetherVo<ContractTogetherLiveVo>> getContractTogetherLiveList() {
        return this.t;
    }

    public MutableLiveData<ContractExitRentVo> getExitRent() {
        return this.f7176b;
    }

    public MutableLiveData<ContractExitRentStateDetailsVo> getExitRentDetails() {
        return this.f7179e;
    }

    public MutableLiveData<ResponseRowsVo<ContractExitRentPropertyStateVo>> getExitRentPropertyList() {
        return this.f7180f;
    }

    public void getExitRentRule() {
        this.f7175a.getExitRentRule().enqueue(enqueueResponse(this.f7178d));
    }

    public MutableLiveData<ResponseStateVo> getExitRentRuleResult() {
        return this.f7178d;
    }

    public void getFddSignUrl(String str) {
        if (checkParamIsInvalid(str)) {
            this.f7175a.getFddContactUrl(str).enqueue(enqueueResponse(this.p));
        }
    }

    public MutableLiveData<ResponseRowsVo<ContractPropertyStateVo>> getPropertyList() {
        return this.f7184q;
    }

    public void getPropertyStateList(String str) {
        if (checkParamIsInvalid(str)) {
            this.f7175a.queryRecofnitionState(str).enqueue(enqueueResponse(this.f7184q));
        }
    }

    public void getRentBackFeePreview(Map<String, String> map) {
        if (checkObjectParamIsValid(map)) {
            this.f7175a.getExitRentFeePreview(map).enqueue(enqueueResponse(this.v));
        }
    }

    public MutableLiveData<RentBackFeePreviewListVo> getRentBackFeePreviewResult() {
        return this.v;
    }

    public MutableLiveData<ResponseStateVo> getRequestResult() {
        return this.f7181g;
    }

    public MutableLiveData<ResultTreatyVo> getRequestTreaty() {
        return this.f7182h;
    }

    public MutableLiveData<ResponseFddSignUrlVo> getResultFddSign() {
        return this.p;
    }

    public void getSignMain(String str, String str2) {
        HashMap map = new HashMap();
        if (x.isNotNull(str)) {
            map.put("contractKey", str);
        }
        if (x.isNotNull(str2)) {
            map.put("assetKey", str2);
        }
        this.f7175a.getSignMain(map).enqueue(enqueueResponse(this.o));
    }

    public MutableLiveData<ResponseSignMainInfoVo> getSignMainInfo() {
        return this.o;
    }

    public void postContractCommentInfo(String str, SubmitContractCommentBo submitContractCommentBo) {
        this.f7175a.postContractCommentInfo(str, submitContractCommentBo).enqueue(enqueueResponse(this.f7181g));
    }

    public void postExitRent(RequestExitRentVo requestExitRentVo) {
        this.f7175a.postExitRent(requestExitRentVo).enqueue(enqueueResponse(this.f7181g));
    }

    public void postPropertyStateList(String str, SubmitPropertyStateVo submitPropertyStateVo) {
        this.f7175a.postRecognitionInfo(str, submitPropertyStateVo).enqueue(enqueueResponse(this.f7181g));
    }

    public void queryContractClause(String str) {
        this.f7175a.queryContractClause(str).enqueue(enqueueResponse(this.f7182h));
    }

    public void queryContractClauseList(String str) {
        if (checkParamIsInvalid(str)) {
            this.f7175a.queryContractClauseList(str).enqueue(enqueueResponse(this.s));
        }
    }

    public void saveContractTogetherLiveList(String str, UpdateTogetherLiveBo updateTogetherLiveBo) {
        this.f7175a.postContractTogetherLiveList(str, updateTogetherLiveBo).enqueue(enqueueResponse(this.f7181g));
    }

    public void saveSignMain(SignMainInfoVo signMainInfoVo) {
        this.f7175a.postSaveSignMainInfo(signMainInfoVo).enqueue(enqueueResponse(this.f7181g));
    }

    public void getContractCommentInfo(String str) {
        if (checkParamIsInvalid(str)) {
            this.f7175a.getContractCommentInfo(str).enqueue(enqueueResponse(this.m));
        }
    }

    public void getContractTogetherLiveList(String str) {
        if (checkParamIsInvalid(str)) {
            this.f7175a.getContractTogetherLiveList(str).enqueue(enqueueResponse(this.t));
        }
    }
}
