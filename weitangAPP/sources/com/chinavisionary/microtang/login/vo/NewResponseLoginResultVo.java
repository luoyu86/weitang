package com.chinavisionary.microtang.login.vo;

import c.e.a.d.x;
import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;

/* JADX INFO: loaded from: classes.dex */
public class NewResponseLoginResultVo extends NewBaseVo {
    private ResourceVo avatarRes;
    private String avatarUrl;
    private String key;
    private String nickname;
    private String phone;

    public ResourceVo getAvatarRes() {
        if (this.avatarRes == null && x.isNotNull(this.avatarUrl)) {
            ResourceVo resourceVo = new ResourceVo();
            this.avatarRes = resourceVo;
            resourceVo.setUrl(this.avatarUrl);
            this.avatarRes.setSampleUrl(this.avatarUrl);
        }
        return this.avatarRes;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getKey() {
        return this.key;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setAvatarRes(ResourceVo resourceVo) {
        this.avatarRes = resourceVo;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }
}
