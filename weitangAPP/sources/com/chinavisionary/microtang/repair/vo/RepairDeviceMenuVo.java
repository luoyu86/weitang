package com.chinavisionary.microtang.repair.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;

/* JADX INFO: loaded from: classes2.dex */
public class RepairDeviceMenuVo extends BaseVo {
    private String deviceMenuKey;
    private String deviceMenuName;
    private String reousrceUrl;
    private ResourceVo resource;

    public String getDeviceMenuKey() {
        return this.deviceMenuKey;
    }

    public String getDeviceMenuName() {
        return this.deviceMenuName;
    }

    public String getReousrceUrl() {
        return this.reousrceUrl;
    }

    public ResourceVo getResource() {
        return this.resource;
    }

    public void setDeviceMenuKey(String str) {
        this.deviceMenuKey = str;
    }

    public void setDeviceMenuName(String str) {
        this.deviceMenuName = str;
    }

    public void setReousrceUrl(String str) {
        this.reousrceUrl = str;
    }

    public void setResource(ResourceVo resourceVo) {
        this.resource = resourceVo;
    }
}
