package com.chinavisionary.twlib.open.bo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class TwLibCheckCreateCommentBo extends NewBaseVo {
    public Object appid;
    private String assetConfirmDate;
    private String contractKey;
    public Object enterpriseid;
    private boolean isOpenAssetConfirm;
    public Object key;
    public String messageKey;
    public boolean needComment;
    public String rentCommentKey;

    public Object getAppid() {
        return this.appid;
    }

    public String getAssetConfirmDate() {
        return this.assetConfirmDate;
    }

    public String getContractKey() {
        return this.contractKey;
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

    public boolean isOpenAssetConfirm() {
        return this.isOpenAssetConfirm;
    }

    public void setAppid(Object obj) {
        this.appid = obj;
    }

    public void setAssetConfirmDate(String str) {
        this.assetConfirmDate = str;
    }

    public void setContractKey(String str) {
        this.contractKey = str;
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

    public void setOpenAssetConfirm(boolean z) {
        this.isOpenAssetConfirm = z;
    }

    public void setRentCommentKey(String str) {
        this.rentCommentKey = str;
    }
}
