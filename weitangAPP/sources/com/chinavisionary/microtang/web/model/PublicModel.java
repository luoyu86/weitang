package com.chinavisionary.microtang.web.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.j;
import c.e.c.o0.g.a;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.web.vo.ResponseArticleVo;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PublicModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MutableLiveData<ResponseArticleVo> f8720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f8721b;

    public PublicModel() {
        super(j.getInstance().getPublicBaseUrl());
        this.f8720a = new MutableLiveData<>();
        this.f8721b = (a) create(a.class);
    }

    public MutableLiveData<ResponseArticleVo> getArticleResult() {
        return this.f8720a;
    }

    public void getArticleToArticleKey(String str) {
        if (checkParamIsInvalid(str)) {
            this.f8721b.getArticleToKey(str).enqueue(enqueueResponse(this.f8720a));
        }
    }

    public void uploadFile(List<File> list) {
        newUploadFileList(list, false);
    }
}
