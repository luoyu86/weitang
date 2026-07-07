package com.chinavisionary.core.app.config.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;

/* JADX INFO: loaded from: classes.dex */
public class UserInfoVo extends BaseVo {
    private static final int PROXY_OPERATED = 2;
    private static final int SELF_OPERATED = 1;
    public static final int TOGETHER_LIVE_USER = 3;
    public static final int USER = 1;
    private ResourceVo avatar;
    private boolean checkIn;
    private boolean isValidateFaDaDa;
    private String nickname;
    private Integer operatingModel = 1;
    private String personName;
    private boolean showInterest;
    private String userKey;
    private Integer userType;
    private boolean validate;

    public ResourceVo getAvatar() {
        return this.avatar;
    }

    public String getNickname() {
        return this.nickname;
    }

    public Integer getOperatingModel() {
        return this.operatingModel;
    }

    public String getPersonName() {
        return this.personName;
    }

    public String getUserKey() {
        return this.userKey;
    }

    public Integer getUserType() {
        return this.userType;
    }

    public boolean isCheckIn() {
        return this.checkIn;
    }

    public boolean isShowInterest() {
        return this.showInterest;
    }

    public boolean isValidate() {
        return this.validate;
    }

    public boolean isValidateFaDaDa() {
        return this.isValidateFaDaDa;
    }

    public boolean roomIsSelfOperated() {
        Integer num = this.operatingModel;
        return num == null || num.intValue() == 1;
    }

    public void setAvatar(ResourceVo resourceVo) {
        this.avatar = resourceVo;
    }

    public void setCheckIn(boolean z) {
        this.checkIn = z;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setOperatingModel(Integer num) {
        this.operatingModel = num;
    }

    public void setPersonName(String str) {
        this.personName = str;
    }

    public void setShowInterest(boolean z) {
        this.showInterest = z;
    }

    public void setUserKey(String str) {
        this.userKey = str;
    }

    public void setUserType(Integer num) {
        this.userType = num;
    }

    public void setValidate(boolean z) {
        this.validate = z;
    }

    public void setValidateFaDaDa(boolean z) {
        this.isValidateFaDaDa = z;
    }
}
