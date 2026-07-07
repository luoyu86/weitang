package com.chinavisionary.microtang.me.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.microtang.base.BaseActivity;

/* JADX INFO: loaded from: classes.dex */
public class OrderVo extends BaseVo {
    public static final int FORWARD_TYPE_ALIPAY = 8;
    public static final int FORWARD_TYPE_CONTENT = 1;
    public static final int FORWARD_TYPE_FUND = 9;
    public static final int FORWARD_TYPE_NOT_JUMP = 3;
    public static final int FORWARD_TYPE_WEB = 2;
    public static final int FORWARD_TYPE_WX = 7;
    public static final String JUMP_TYPE_DOOR_PASSWORD = "doorPassword";
    private static final String JUMP_TYPE_LINK = "link";
    private static final String JUMP_TYPE_MINI = "mini";
    public static final String JUMP_TYPE_MINI_CALL_MANAGER = "callManager";
    private static final String JUMP_TYPE_NATIVE = "native";
    private static final int LOGIN_FLAG_NEED = 1;
    private static final int LOGIN_FLAG_NONE = 0;
    private Class<? extends BaseActivity> activityClass;
    private String content;
    private int forwardType;
    private String h5Url;
    private int iconId;
    private String iconUrl;
    private boolean isHide;
    private String jumpType;
    private int loginFlag;
    private int messageType;
    private String miniAppId;
    private String miniPagePath;
    private String miniType;
    private String param;
    private String title;
    private int titleId;
    private int type;

    public Class<? extends BaseActivity> getActivityClass() {
        return this.activityClass;
    }

    public String getContent() {
        return this.content;
    }

    public int getForwardType() {
        return this.forwardType;
    }

    public String getH5Url() {
        return this.h5Url;
    }

    public int getIconId() {
        return this.iconId;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getJumpType() {
        return this.jumpType;
    }

    public int getLoginFlag() {
        return this.loginFlag;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public String getMiniAppId() {
        return this.miniAppId;
    }

    public String getMiniPagePath() {
        return this.miniPagePath;
    }

    public String getMiniType() {
        return this.miniType;
    }

    public String getParam() {
        return this.param;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTitleId() {
        return this.titleId;
    }

    public int getType() {
        return this.type;
    }

    public boolean hasNeedLogin() {
        return 1 == this.loginFlag;
    }

    public boolean isHide() {
        return this.isHide;
    }

    public void setActivityClass(Class<? extends BaseActivity> cls) {
        this.activityClass = cls;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setForwardType(int i2) {
        this.forwardType = i2;
    }

    public void setH5Url(String str) {
        this.h5Url = str;
    }

    public void setHide(boolean z) {
        this.isHide = z;
    }

    public void setIconId(int i2) {
        this.iconId = i2;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setJumpType(String str) {
        this.jumpType = str;
    }

    public void setLoginFlag(int i2) {
        this.loginFlag = i2;
    }

    public void setMessageType(int i2) {
        this.messageType = i2;
    }

    public void setMiniAppId(String str) {
        this.miniAppId = str;
    }

    public void setMiniPagePath(String str) {
        this.miniPagePath = str;
    }

    public void setMiniType(String str) {
        this.miniType = str;
    }

    public void setParam(String str) {
        this.param = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTitleId(int i2) {
        this.titleId = i2;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
