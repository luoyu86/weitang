package com.chinavisionary.microtang.service.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.j;
import c.e.c.i0.a.b;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.service.bo.CreateFormBo;
import com.chinavisionary.microtang.service.bo.DataSourceVo;
import com.chinavisionary.microtang.service.bo.ResponseFormBo;
import com.chinavisionary.microtang.service.bo.ResponseFormTemplateDetailsVo;

/* JADX INFO: loaded from: classes2.dex */
public class TemplateModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f8481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<ResponseFormBo> f8482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MutableLiveData<ResponseFormBo> f8483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MutableLiveData<String> f8484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MutableLiveData<ResponseFormTemplateDetailsVo> f8485e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MutableLiveData<ResponseRowsVo<DataSourceVo>> f8486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MutableLiveData<DataSourceVo> f8487g;

    public TemplateModel() {
        super(j.getInstance().getPublicBaseUrl());
        this.f8482b = new MutableLiveData<>();
        this.f8483c = new MutableLiveData<>();
        this.f8484d = new MutableLiveData<>();
        this.f8485e = new MutableLiveData<>();
        this.f8486f = new MutableLiveData<>();
        this.f8487g = new MutableLiveData<>();
        this.f8481a = (b) create(b.class);
    }

    public void createTemplate(CreateFormBo createFormBo) {
        this.f8481a.createForm(createFormBo).enqueue(enqueueResponse(this.f8484d));
    }

    public MutableLiveData<ResponseFormBo> getBoMutableLiveData() {
        return this.f8482b;
    }

    public MutableLiveData<DataSourceVo> getDataSourceResult() {
        return this.f8487g;
    }

    public MutableLiveData<ResponseRowsVo<DataSourceVo>> getDataSourceResultList() {
        return this.f8486f;
    }

    public void getFormDataSource(String str) {
        this.f8481a.getFormDataSource(str).enqueue(enqueueResponse(this.f8487g));
    }

    public MutableLiveData<ResponseFormBo> getFormResult() {
        return this.f8483c;
    }

    public void getFormTemplateDataSource(String str) {
        if (checkParamIsInvalid(str)) {
            this.f8481a.getFormTemplateDataSource(str).enqueue(enqueueResponse(this.f8486f));
        }
    }

    public void getFormTemplateDetails(String str) {
        if (checkParamIsInvalid(str)) {
            this.f8481a.getFormTemplateDetails(str).enqueue(enqueueResponse(this.f8485e));
        }
    }

    public void getFormValueTemplate(String str) {
        if (checkParamIsInvalid(str)) {
            this.f8481a.getFormData(str).enqueue(enqueueResponse(this.f8483c));
        }
    }

    public MutableLiveData<String> getResult() {
        return this.f8484d;
    }

    public void getTemplate(String str) {
        if (checkParamIsInvalid(str)) {
            this.f8481a.getFormData(str).enqueue(enqueueResponse(this.f8482b));
        }
    }

    public MutableLiveData<ResponseFormTemplateDetailsVo> getTemplateDetailsResult() {
        return this.f8485e;
    }
}
