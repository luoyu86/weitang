package com.chinavisionary.microtang.repair.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RepairDeviceVo extends BaseVo {
    private String deviceMenuKey;
    private String deviceMenuName;
    private List<DevicesBean> devices;

    public static class DevicesBean extends BaseVo {
        private String assetCategoryKey;
        private String assetCategoryKeyName;
        private ResourceVo resourceVo;

        public String getAssetCategoryKey() {
            return this.assetCategoryKey;
        }

        public String getAssetCategoryKeyName() {
            return this.assetCategoryKeyName;
        }

        public ResourceVo getResourceVo() {
            return this.resourceVo;
        }

        public void setAssetCategoryKey(String str) {
            this.assetCategoryKey = str;
        }

        public void setAssetCategoryKeyName(String str) {
            this.assetCategoryKeyName = str;
        }

        public void setResourceVo(ResourceVo resourceVo) {
            this.resourceVo = resourceVo;
        }
    }

    public String getDeviceMenuKey() {
        return this.deviceMenuKey;
    }

    public String getDeviceMenuName() {
        return this.deviceMenuName;
    }

    public List<DevicesBean> getDevices() {
        return this.devices;
    }

    public void setDeviceMenuKey(String str) {
        this.deviceMenuKey = str;
    }

    public void setDeviceMenuName(String str) {
        this.deviceMenuName = str;
    }

    public void setDevices(List<DevicesBean> list) {
        this.devices = list;
    }
}
