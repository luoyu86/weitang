package com.chinavisionary.microtang.service.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionsCategoriesVo extends BaseVo {
    private boolean defaultFlag;
    private String key;
    private String name;
    private String value;

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isDefaultFlag() {
        return this.defaultFlag;
    }

    public void setDefaultFlag(boolean z) {
        this.defaultFlag = z;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
