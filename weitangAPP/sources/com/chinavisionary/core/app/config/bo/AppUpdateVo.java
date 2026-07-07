package com.chinavisionary.core.app.config.bo;

import c.e.a.a.b;
import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class AppUpdateVo extends BaseVo {
    private String downloadUrl;
    private boolean forceUpdate;
    private int minVersion;
    private String minVersionCode;
    private String remark;
    private Long updateTime;
    private int version;
    private String versionCode;
    private String versionName;

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public int getMinVersion() {
        return this.minVersionCode != null ? b.getInstance().getVersionCode(this.minVersionCode) : this.minVersion;
    }

    public String getMinVersionCode() {
        return this.minVersionCode;
    }

    public String getRemark() {
        return this.remark;
    }

    public Long getUpdateTime() {
        return this.updateTime;
    }

    public int getVersion() {
        return this.versionCode != null ? b.getInstance().getVersionCode(this.versionCode) : this.version;
    }

    public String getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public boolean isForceUpdate() {
        return this.forceUpdate;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setForceUpdate(boolean z) {
        this.forceUpdate = z;
    }

    public void setMinVersion(int i2) {
        this.minVersion = i2;
    }

    public void setMinVersionCode(String str) {
        this.minVersionCode = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setUpdateTime(Long l) {
        this.updateTime = l;
    }

    public void setVersion(int i2) {
        this.version = i2;
    }

    public void setVersionCode(String str) {
        this.versionCode = str;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }
}
