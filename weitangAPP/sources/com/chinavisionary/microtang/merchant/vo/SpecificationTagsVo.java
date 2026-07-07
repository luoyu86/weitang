package com.chinavisionary.microtang.merchant.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SpecificationTagsVo extends BaseVo {
    private String specificationTagKey;
    private String specificationTagName;
    private List<SpecificationTagsVo> subSpecificationTags;

    public String getSpecificationTagKey() {
        return this.specificationTagKey;
    }

    public String getSpecificationTagName() {
        return this.specificationTagName;
    }

    public List<SpecificationTagsVo> getSubSpecificationTags() {
        return this.subSpecificationTags;
    }

    public void setSpecificationTagKey(String str) {
        this.specificationTagKey = str;
    }

    public void setSpecificationTagName(String str) {
        this.specificationTagName = str;
    }

    public void setSubSpecificationTags(List<SpecificationTagsVo> list) {
        this.subSpecificationTags = list;
    }
}
