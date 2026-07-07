package com.chinavisionary.microtang.merchant.model;

import androidx.lifecycle.MutableLiveData;
import c.e.c.y.a.a;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.merchant.vo.MerchantCommentVo;

/* JADX INFO: loaded from: classes.dex */
public class CommentModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f7923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<ResponseRowsVo<MerchantCommentVo>> f7924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MutableLiveData<ResponseRowsVo<MerchantCommentVo>> f7925c;

    public CommentModel() {
        super(null);
        this.f7924b = new MutableLiveData<>();
        this.f7925c = new MutableLiveData<>();
        this.f7923a = (a) create(a.class);
    }

    public MutableLiveData<ResponseRowsVo<MerchantCommentVo>> getCommentListResult() {
        return this.f7924b;
    }

    public void getCommodityComment(String str, PageBo pageBo) {
        if (checkParamIsInvalid(str) && checkObjectParamIsValid(pageBo)) {
            this.f7923a.getCommodityComment(str, getQueryMap(pageBo)).enqueue(enqueueResponse(this.f7924b));
        }
    }

    public void getMerchantComment(String str, PageBo pageBo) {
        if (checkParamIsInvalid(str) && checkObjectParamIsValid(pageBo)) {
            this.f7923a.getMerchantCommentList(str, getQueryMap(pageBo)).enqueue(enqueueResponse(this.f7925c));
        }
    }

    public MutableLiveData<ResponseRowsVo<MerchantCommentVo>> getMerchantCommentResult() {
        return this.f7925c;
    }
}
