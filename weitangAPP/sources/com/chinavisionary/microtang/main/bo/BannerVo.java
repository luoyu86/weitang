package com.chinavisionary.microtang.main.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class BannerVo extends BaseVo {
    private CoverBean cover;
    private String dataKey;
    private String dataParam;
    private int dataType;
    private String key;

    public static class CoverBean extends BaseVo {
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
    }

    public CoverBean getCover() {
        return this.cover;
    }

    public String getDataKey() {
        return this.dataKey;
    }

    public String getDataParam() {
        return this.dataParam;
    }

    public int getDataType() {
        return this.dataType;
    }

    public String getKey() {
        return this.key;
    }

    public void setCover(CoverBean coverBean) {
        this.cover = coverBean;
    }

    public void setDataKey(String str) {
        this.dataKey = str;
    }

    public void setDataParam(String str) {
        this.dataParam = str;
    }

    public void setDataType(int i2) {
        this.dataType = i2;
    }

    public void setKey(String str) {
        this.key = str;
    }
}
