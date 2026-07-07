package com.chinavisionary.microtang.me.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.weight.banner.EditBannerView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FundNewsVo extends BaseVo {
    public static final String TYPE_ALIPAY = "alipay";
    public static final int TYPE_HEAD = 2;
    public static final int TYPE_NEWS = 1;
    public static final int TYPE_TITLE = 3;
    private static final String TYPE_WECHAT = "wechat";
    private String btnType;
    private String content;
    private Long createTime;
    private int forwardType;
    private String h5Url;
    private String iconUrl;
    private int itemType = 1;
    private String jumpType;
    private List<EditBannerView.BannerDto> listData;
    private int loginFlag;
    private int messageType;
    private String miniAppId;
    private String miniPagePath;
    private String miniType;
    private String name;
    private String picUrl;
    private String title;

    public String getBtnType() {
        return this.btnType;
    }

    public String getContent() {
        return this.content;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public int getForwardType() {
        return this.forwardType;
    }

    public String getH5Url() {
        return this.h5Url;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public int getItemType() {
        return this.itemType;
    }

    public String getJumpType() {
        return this.jumpType;
    }

    public List<EditBannerView.BannerDto> getListData() {
        return this.listData;
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

    public String getName() {
        return this.name;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean hasAliPayMini() {
        return TYPE_ALIPAY.equals(this.miniType);
    }

    public void setBtnType(String str) {
        this.btnType = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCreateTime(Long l) {
        this.createTime = l;
    }

    public void setForwardType(int i2) {
        this.forwardType = i2;
    }

    public void setH5Url(String str) {
        this.h5Url = str;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setJumpType(String str) {
        this.jumpType = str;
    }

    public void setListData(List<EditBannerView.BannerDto> list) {
        this.listData = list;
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

    public void setName(String str) {
        this.name = str;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
