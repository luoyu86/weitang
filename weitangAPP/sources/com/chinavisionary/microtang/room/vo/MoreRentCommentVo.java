package com.chinavisionary.microtang.room.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MoreRentCommentVo extends BaseVo {
    private String assetInstanceKey;
    private String commentContent;
    private Long commentDate;
    private String commentUserName;
    private String houseName;
    private String housingCommentKey;
    private List<ResourceVo> pictures;
    private ResourceVo userIconResourceVo;

    public String getAssetInstanceKey() {
        return this.assetInstanceKey;
    }

    public String getCommentContent() {
        return this.commentContent;
    }

    public Long getCommentDate() {
        return this.commentDate;
    }

    public String getCommentUserName() {
        return this.commentUserName;
    }

    public String getHouseName() {
        return this.houseName;
    }

    public String getHousingCommentKey() {
        return this.housingCommentKey;
    }

    public List<ResourceVo> getPictures() {
        return this.pictures;
    }

    public ResourceVo getUserIconResourceVo() {
        return this.userIconResourceVo;
    }

    public void setAssetInstanceKey(String str) {
        this.assetInstanceKey = str;
    }

    public void setCommentContent(String str) {
        this.commentContent = str;
    }

    public void setCommentDate(Long l) {
        this.commentDate = l;
    }

    public void setCommentUserName(String str) {
        this.commentUserName = str;
    }

    public void setHouseName(String str) {
        this.houseName = str;
    }

    public void setHousingCommentKey(String str) {
        this.housingCommentKey = str;
    }

    public void setPictures(List<ResourceVo> list) {
        this.pictures = list;
    }

    public void setUserIconResourceVo(ResourceVo resourceVo) {
        this.userIconResourceVo = resourceVo;
    }
}
