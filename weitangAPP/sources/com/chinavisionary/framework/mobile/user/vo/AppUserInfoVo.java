package com.chinavisionary.framework.mobile.user.vo;

import com.chinavisionary.framework.mobile.common.vo.ResourceVo;

/* JADX INFO: loaded from: classes.dex */
public class AppUserInfoVo {
    private ResourceVo avatar;
    private String houseKey;
    private String houseType;
    private Boolean isActualCheckin;
    private Boolean isAuthentication;
    private Boolean isCheckin;
    private String key;
    private String nickname;

    public AppUserInfoVo() {
        Boolean bool = Boolean.FALSE;
        this.isAuthentication = bool;
        this.isCheckin = bool;
        this.isActualCheckin = Boolean.TRUE;
    }

    public ResourceVo getAvatar() {
        return this.avatar;
    }

    public String getHouseKey() {
        return this.houseKey;
    }

    public String getHouseType() {
        return this.houseType;
    }

    public Boolean getIsActualCheckin() {
        return this.isActualCheckin;
    }

    public Boolean getIsAuthentication() {
        return this.isAuthentication;
    }

    public Boolean getIsCheckin() {
        return this.isCheckin;
    }

    public String getKey() {
        return this.key;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setAvatar(ResourceVo resourceVo) {
        this.avatar = resourceVo;
    }

    public void setHouseKey(String str) {
        this.houseKey = str;
    }

    public void setHouseType(String str) {
        this.houseType = str;
    }

    public void setIsActualCheckin(Boolean bool) {
        this.isActualCheckin = bool;
    }

    public void setIsAuthentication(Boolean bool) {
        this.isAuthentication = bool;
    }

    public void setIsCheckin(Boolean bool) {
        this.isCheckin = bool;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }
}
