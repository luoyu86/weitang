package com.chinavisionary.microtang.me.bo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ResponseManagerQrCodeBo extends NewBaseVo {
    private String buildingKey;
    private String communityHousekeeperType;
    private String communityKey;
    private String housekeeperAvatar;
    private String housekeeperName;
    private String housekeeperPhone;
    private String housekeeperQrCode;

    public String getBuildingKey() {
        return this.buildingKey;
    }

    public String getCommunityHousekeeperType() {
        return this.communityHousekeeperType;
    }

    public String getCommunityKey() {
        return this.communityKey;
    }

    public String getHousekeeperAvatar() {
        return this.housekeeperAvatar;
    }

    public String getHousekeeperName() {
        return this.housekeeperName;
    }

    public String getHousekeeperPhone() {
        return this.housekeeperPhone;
    }

    public String getHousekeeperQrCode() {
        return this.housekeeperQrCode;
    }

    public void setBuildingKey(String str) {
        this.buildingKey = str;
    }

    public void setCommunityHousekeeperType(String str) {
        this.communityHousekeeperType = str;
    }

    public void setCommunityKey(String str) {
        this.communityKey = str;
    }

    public void setHousekeeperAvatar(String str) {
        this.housekeeperAvatar = str;
    }

    public void setHousekeeperName(String str) {
        this.housekeeperName = str;
    }

    public void setHousekeeperPhone(String str) {
        this.housekeeperPhone = str;
    }

    public void setHousekeeperQrCode(String str) {
        this.housekeeperQrCode = str;
    }
}
