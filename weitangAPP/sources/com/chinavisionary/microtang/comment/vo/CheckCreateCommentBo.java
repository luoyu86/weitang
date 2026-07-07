package com.chinavisionary.microtang.comment.vo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;

/* JADX INFO: loaded from: classes.dex */
public class CheckCreateCommentBo extends NewBaseVo {
    public Object appid;
    public Object enterpriseid;
    public Object key;
    public String messageKey;
    public boolean needComment;
    public String rentCommentKey;

    public Object getAppid() {
        return this.appid;
    }

    public Object getEnterpriseid() {
        return this.enterpriseid;
    }

    public Object getKey() {
        return this.key;
    }

    public String getMessageKey() {
        return this.messageKey;
    }

    public String getRentCommentKey() {
        return this.rentCommentKey;
    }

    public boolean isNeedComment() {
        return this.needComment;
    }

    public void setAppid(Object obj) {
        this.appid = obj;
    }

    public void setEnterpriseid(Object obj) {
        this.enterpriseid = obj;
    }

    public void setKey(Object obj) {
        this.key = obj;
    }

    public void setMessageKey(String str) {
        this.messageKey = str;
    }

    public void setNeedComment(boolean z) {
        this.needComment = z;
    }

    public void setRentCommentKey(String str) {
        this.rentCommentKey = str;
    }
}
