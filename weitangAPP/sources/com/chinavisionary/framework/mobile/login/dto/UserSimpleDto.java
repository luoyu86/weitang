package com.chinavisionary.framework.mobile.login.dto;

import com.chinavisionary.framework.mobile.common.vo.ResourceVo;

/* JADX INFO: loaded from: classes.dex */
public class UserSimpleDto {
    private ResourceVo avatar;
    private String nickname;
    private String phone;

    public ResourceVo getAvatar() {
        return this.avatar;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setAvatar(ResourceVo resourceVo) {
        this.avatar = resourceVo;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }
}
