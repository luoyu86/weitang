package com.chinavisionary.microtang.service.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class RequestCreateQuestionsFromVo extends BaseVo {
    public static final int COMPLAINT = 1;
    public static final int CONSULT = 2;
    private String formKey;
    private Integer type;

    public String getFormKey() {
        return this.formKey;
    }

    public Integer getType() {
        return this.type;
    }

    public void setFormKey(String str) {
        this.formKey = str;
    }

    public void setType(Integer num) {
        this.type = num;
    }
}
