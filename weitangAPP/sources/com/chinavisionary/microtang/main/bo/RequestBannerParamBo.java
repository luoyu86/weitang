package com.chinavisionary.microtang.main.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class RequestBannerParamBo extends BaseVo {
    public static final String GET_COMMUNITY_BANNER_TYPE = "community";
    public static final String GET_FUND_BANNER_TYPE = "fund";
    public static final String GET_LIFE_BANNER_TYPE = "life";
    public static final String GET_MAIN_BANNER_TYPE = "house";
    public static final String GET_ME_BANNER_TYPE = "me";
    public static final String GET_OPEN_DOOR_TYPE = "open";
    public static final String GET_SPLASH_TYPE = "start";
    private String location;
    private String pageCode;
    private String projectId;

    public String getLocation() {
        return this.location;
    }

    public String getPageCode() {
        return this.pageCode;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setPageCode(String str) {
        this.pageCode = str;
    }

    public void setProjectId(String str) {
        this.projectId = str;
    }
}
