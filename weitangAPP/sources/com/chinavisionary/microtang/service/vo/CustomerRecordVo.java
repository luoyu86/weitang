package com.chinavisionary.microtang.service.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CustomerRecordVo extends BaseVo {
    private String category;
    private String content;
    private String key;
    private List<ResourceVo> photoList;
    private String question;

    public String getCategory() {
        return this.category;
    }

    public String getContent() {
        return this.content;
    }

    public String getKey() {
        return this.key;
    }

    public List<ResourceVo> getPhotoList() {
        return this.photoList;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setPhotoList(List<ResourceVo> list) {
        this.photoList = list;
    }

    public void setQuestion(String str) {
        this.question = str;
    }
}
