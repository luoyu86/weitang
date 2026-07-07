package com.chinavisionary.microtang.main.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.app.net.base.dto.PageBo;

/* JADX INFO: loaded from: classes.dex */
public class RequestGroupItemDetailsRoomListBo extends BaseVo {
    private String groupKey;
    private String houseName;
    private String projectKey;
    private int currentPage = 1;
    private int pageSize = 20;

    public int getCurrentPage() {
        return this.currentPage;
    }

    public String getGroupKey() {
        return this.groupKey;
    }

    public String getHouseName() {
        return this.houseName;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public String getProjectKey() {
        return this.projectKey;
    }

    public void setCurrentPage(int i2) {
        this.currentPage = i2;
    }

    public void setGroupKey(String str) {
        this.groupKey = str;
    }

    public void setHouseName(String str) {
        this.houseName = str;
    }

    public void setPageBo(PageBo pageBo) {
        if (pageBo != null) {
            setCurrentPage(pageBo.getPage());
            setPageSize(pageBo.getPageNumber());
        }
    }

    public void setPageSize(int i2) {
        this.pageSize = i2;
    }

    public void setProjectKey(String str) {
        this.projectKey = str;
    }
}
