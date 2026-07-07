package com.chinavisionary.microtang.comment.bo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ResponseCommentBadgeBo extends NewBaseVo {
    private boolean commentFlage;
    private Integer total;

    public Integer getTotal() {
        return this.total;
    }

    public boolean isCommentFlage() {
        return this.commentFlage;
    }

    public void setCommentFlage(boolean z) {
        this.commentFlage = z;
    }

    public void setTotal(Integer num) {
        this.total = num;
    }
}
