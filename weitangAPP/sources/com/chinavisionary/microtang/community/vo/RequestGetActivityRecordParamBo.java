package com.chinavisionary.microtang.community.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class RequestGetActivityRecordParamBo extends BaseVo {
    private int currentPage;
    private int pageSize;
    private String queryType;

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public String getQueryType() {
        return this.queryType;
    }

    public void setCurrentPage(int i2) {
        this.currentPage = i2;
    }

    public void setPageSize(int i2) {
        this.pageSize = i2;
    }

    public void setQueryType(String str) {
        this.queryType = str;
    }
}
