package com.chinavisionary.framework.mobile.common.vo;

import androidx.annotation.NonNull;
import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ResourceVo extends BaseVo implements Cloneable {
    private String key;
    private String sampleUrl;
    private String url;

    public String getKey() {
        return this.key;
    }

    public String getSampleUrl() {
        return this.sampleUrl;
    }

    public String getUrl() {
        return this.url;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setSampleUrl(String str) {
        this.sampleUrl = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    @NonNull
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ResourceVo m69clone() {
        ResourceVo resourceVo;
        CloneNotSupportedException e2;
        try {
            resourceVo = (ResourceVo) super.clone();
        } catch (CloneNotSupportedException e3) {
            resourceVo = null;
            e2 = e3;
        }
        try {
            resourceVo.key = this.key;
            resourceVo.url = this.url;
            resourceVo.sampleUrl = this.sampleUrl;
        } catch (CloneNotSupportedException e4) {
            e2 = e4;
            e2.printStackTrace();
        }
        return resourceVo;
    }
}
