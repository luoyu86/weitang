package com.chinavisionary.core.app.net.base.dto;

/* JADX INFO: loaded from: classes.dex */
public class PageBo {
    private String dataKey;
    private String key;
    private String moduleKey;
    private int page;
    private int pageNumber;

    public String getDataKey() {
        return this.dataKey;
    }

    public String getKey() {
        return this.key;
    }

    public String getModuleKey() {
        return this.moduleKey;
    }

    public int getPage() {
        return this.page;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public void setDataKey(String str) {
        this.dataKey = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setModuleKey(String str) {
        this.moduleKey = str;
    }

    public void setPage(int i2) {
        this.page = i2;
    }

    public void setPageNumber(int i2) {
        this.pageNumber = i2;
    }
}
