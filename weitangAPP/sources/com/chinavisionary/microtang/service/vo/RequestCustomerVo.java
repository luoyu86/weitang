package com.chinavisionary.microtang.service.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RequestCustomerVo extends BaseVo {
    private String categoryItemKey;
    private String describe;
    private List<String> evidences;
    private String questionItemKey;

    public String getCategoryItemKey() {
        return this.categoryItemKey;
    }

    public String getDescribe() {
        return this.describe;
    }

    public List<String> getEvidences() {
        return this.evidences;
    }

    public String getQuestionItemKey() {
        return this.questionItemKey;
    }

    public void setCategoryItemKey(String str) {
        this.categoryItemKey = str;
    }

    public void setDescribe(String str) {
        this.describe = str;
    }

    public void setEvidences(List<String> list) {
        this.evidences = list;
    }

    public void setQuestionItemKey(String str) {
        this.questionItemKey = str;
    }
}
