package com.chinavisionary.microtang.clean.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class RequestIncrementServiceParamBo extends BaseVo {
    public static final int WT_CLEAR_INCREMENT = 2;
    public static final int WT_FOOD_INCREMENT = 6;
    public static final int WT_STYLE_INCREMENT = 4;
    private int commodityType = 2;
    private String projectId;
    private String spaceId;

    public int getCommodityType() {
        return this.commodityType;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public void setCommodityType(int i2) {
        this.commodityType = i2;
    }

    public void setProjectId(String str) {
        this.projectId = str;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }
}
