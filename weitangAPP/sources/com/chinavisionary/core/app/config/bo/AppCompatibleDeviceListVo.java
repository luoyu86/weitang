package com.chinavisionary.core.app.config.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatibleDeviceListVo extends BaseVo {
    private List<String> deviceList;

    public List<String> getDeviceList() {
        return this.deviceList;
    }

    public void setDeviceList(List<String> list) {
        this.deviceList = list;
    }
}
