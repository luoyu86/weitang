package com.chinavisionary.microtang.comment.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.j;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.m.b.a;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.comment.bo.ResponseCommentBadgeBo;
import com.chinavisionary.microtang.comment.bo.ResponseCommentListBo;
import com.chinavisionary.microtang.comment.vo.CheckCreateCommentBo;
import com.chinavisionary.microtang.comment.vo.CommentDetailsVo;
import com.chinavisionary.microtang.comment.vo.CreateCommentBo;
import com.chinavisionary.microtang.comment.vo.CreateCommentResponseVo;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class CommentModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7022a = "CommentModel";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f7023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<ResponseStateVo> f7024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<CreateCommentResponseVo> f7025d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<CommentDetailsVo> f7026e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<CheckCreateCommentBo> f7027f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<CheckCreateCommentBo> f7028g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData<ResponseCommentListBo> f7029h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData<ResponseCommentBadgeBo> f7030i;

    public CommentModel() {
        super(j.getInstance().getH5ApiBaseUrl());
        this.f7024c = new MutableLiveData<>();
        this.f7025d = new MutableLiveData<>();
        this.f7026e = new MutableLiveData<>();
        this.f7027f = new MutableLiveData<>();
        this.f7028g = new MutableLiveData<>();
        this.f7029h = new MutableLiveData<>();
        this.f7030i = new MutableLiveData<>();
        this.f7023b = (a) create(a.class);
    }

    public void createComment(CreateCommentBo createCommentBo) {
        if (checkObjectParamIsValid(createCommentBo)) {
            this.f7023b.createComment(getToken(), createCommentBo).enqueue(enqueueBaseVoResponse(this.f7024c));
        }
    }

    public void getCheckCreateComment(String str) {
    }

    public MutableLiveData<CheckCreateCommentBo> getCheckCreateCommentLive() {
        return this.f7027f;
    }

    public void getCheckSignComment() {
        this.f7023b.getCheckSignComment(getToken(), new HashMap<>()).enqueue(enqueueBaseVoResponse(this.f7028g));
    }

    public MutableLiveData<CheckCreateCommentBo> getCheckSignCommentLive() {
        return this.f7028g;
    }

    public MutableLiveData<ResponseCommentBadgeBo> getCommentBadgeResult() {
        return this.f7030i;
    }

    public void getCommentDetails(String str) {
        if (checkParamIsInvalid(str)) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("rentCommentKey", str);
            this.f7023b.getCommentDetails(getToken(), map).enqueue(enqueueBaseVoResponse(this.f7026e));
        }
    }

    public MutableLiveData<CommentDetailsVo> getCommentDetailsLive() {
        return this.f7026e;
    }

    public void getCommentList(c.e.c.m.c.a aVar) {
        if (aVar != null) {
            this.f7023b.getCommentList(getToken(), aVar).enqueue(enqueueBaseVoResponse(this.f7029h));
        } else {
            handlerResponseErr(null, x.getString(R.string.core_lib_tip_request_param_is_empty), 900);
        }
    }

    public MutableLiveData<ResponseCommentListBo> getCommentListResult() {
        return this.f7029h;
    }

    public void getCreateNewCommentInfo(String str) {
        if (checkParamIsInvalid(str)) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("rentCommentKey", str);
            this.f7023b.getCreateNewCommentInfo(getToken(), map).enqueue(enqueueBaseVoResponse(this.f7025d));
        }
    }

    public MutableLiveData<ResponseStateVo> getCreateResultLive() {
        return this.f7024c;
    }

    public void getIsShowCommentBadge(String str) {
        q.d(f7022a, "getIsShowCommentBadge method = " + str);
        this.f7023b.getIsShowCommentBadge(getToken(), new BaseVo()).enqueue(enqueueBaseVoResponse(this.f7030i));
    }

    public MutableLiveData<CreateCommentResponseVo> getNewCreateCommentLive() {
        return this.f7025d;
    }
}
