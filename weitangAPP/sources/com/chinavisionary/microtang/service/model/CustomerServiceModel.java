package com.chinavisionary.microtang.service.model;

import androidx.lifecycle.MutableLiveData;
import c.e.c.i0.a.a;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.repair.vo.ResponseVo;
import com.chinavisionary.microtang.service.bo.CreateServiceCommentBo;
import com.chinavisionary.microtang.service.vo.CustomerHotReasonVo;
import com.chinavisionary.microtang.service.vo.CustomerServerRecordVo;
import com.chinavisionary.microtang.service.vo.MeReasonVo;
import com.chinavisionary.microtang.service.vo.QuestionsCategoriesVo;
import com.chinavisionary.microtang.service.vo.QuestionsTemplateVo;
import com.chinavisionary.microtang.service.vo.RequestCreateQuestionsFromVo;
import com.chinavisionary.microtang.service.vo.RequestCustomerVo;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CustomerServiceModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f8472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f8473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f8474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MutableLiveData<ResponseVo<QuestionsCategoriesVo>> f8475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MutableLiveData<ResponseVo<QuestionsCategoriesVo>> f8476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MutableLiveData<ResponseVo<CustomerServerRecordVo>> f8477f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MutableLiveData<QuestionsTemplateVo> f8478g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MutableLiveData<ResponseVo<CustomerHotReasonVo>> f8479h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MutableLiveData<ResponseVo<MeReasonVo>> f8480i;
    public a j;

    public CustomerServiceModel() {
        super(null);
        this.f8472a = new MutableLiveData<>();
        this.f8473b = new MutableLiveData<>();
        this.f8474c = new MutableLiveData<>();
        this.f8475d = new MutableLiveData<>();
        this.f8476e = new MutableLiveData<>();
        this.f8477f = new MutableLiveData<>();
        this.f8478g = new MutableLiveData<>();
        this.f8479h = new MutableLiveData<>();
        this.f8480i = new MutableLiveData<>();
        this.j = (a) create(a.class);
    }

    public void createQuestion(RequestCreateQuestionsFromVo requestCreateQuestionsFromVo) {
        this.j.createQuestion(requestCreateQuestionsFromVo).enqueue(enqueueResponse(this.f8474c));
    }

    public MutableLiveData<ResponseVo<QuestionsCategoriesVo>> getCategoresLiveData() {
        return this.f8475d;
    }

    public MutableLiveData<ResponseStateVo> getCreateCommentResultLive() {
        return this.f8473b;
    }

    public MutableLiveData<ResponseStateVo> getCreateResult() {
        return this.f8474c;
    }

    public void getHotQuestionsList() {
        this.j.getHotQuestionsList().enqueue(enqueueResponse(this.f8479h));
    }

    public MutableLiveData<ResponseVo<CustomerHotReasonVo>> getHotReasonResult() {
        return this.f8479h;
    }

    public void getMeQuestionsList() {
        this.j.getMeQuestionsList().enqueue(enqueueResponse(this.f8480i));
    }

    public MutableLiveData<ResponseVo<MeReasonVo>> getMeReasonResult() {
        return this.f8480i;
    }

    public void getQuestions(String str) {
        this.j.getQuestions(str).enqueue(enqueueResponse(this.f8476e));
    }

    public void getQuestionsCategories() {
        this.j.getQuestionsCategories().enqueue(enqueueResponse(this.f8475d));
    }

    public MutableLiveData<ResponseVo<QuestionsCategoriesVo>> getQuestionsLiveData() {
        return this.f8476e;
    }

    public void getRecordList(PageBo pageBo) {
        this.j.getRecordList(getQueryMap(pageBo)).enqueue(enqueueResponse(this.f8477f));
    }

    public MutableLiveData<ResponseVo<CustomerServerRecordVo>> getRecordListLiveData() {
        return this.f8477f;
    }

    public MutableLiveData<ResponseStateVo> getResultLiveData() {
        return this.f8472a;
    }

    public void getTemplateKey() {
        this.j.getTemplateKey().enqueue(enqueueResponse(this.f8478g));
    }

    public MutableLiveData<QuestionsTemplateVo> getTemplateResult() {
        return this.f8478g;
    }

    public void postCustomerServiceComment(CreateServiceCommentBo createServiceCommentBo) {
        if (checkObjectParamIsValid(createServiceCommentBo)) {
            this.j.postCustomerServiceComment(createServiceCommentBo).enqueue(enqueueResponse(this.f8473b));
        }
    }

    public void submitCustomerService(RequestCustomerVo requestCustomerVo) {
        this.j.postCustomerService(requestCustomerVo).enqueue(enqueueResponse(this.f8472a));
    }

    public void uploadPicList(List<File> list) {
        uploadFileList(list, false);
    }
}
