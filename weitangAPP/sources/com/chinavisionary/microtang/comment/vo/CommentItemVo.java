package com.chinavisionary.microtang.comment.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class CommentItemVo extends BaseVo {
    private Long commentDate;
    private int commentType;
    private String commentTypeName;
    private String content;
    private String createTimeStr;
    private int itemType;
    private String jumpUrl;
    private String key;
    private String rentCommentKey;
    private String title;

    public Long getCommentDate() {
        return this.commentDate;
    }

    public int getCommentType() {
        return this.commentType;
    }

    public String getCommentTypeName() {
        return this.commentTypeName;
    }

    public String getContent() {
        return this.content;
    }

    public String getCreateTimeStr() {
        return this.createTimeStr;
    }

    public int getItemType() {
        return this.itemType;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getKey() {
        return this.rentCommentKey;
    }

    public String getRentCommentKey() {
        return this.rentCommentKey;
    }

    public String getTitle() {
        return this.commentTypeName;
    }

    public void setCommentDate(Long l) {
        this.commentDate = l;
    }

    public void setCommentType(int i2) {
        this.commentType = i2;
    }

    public void setCommentTypeName(String str) {
        this.commentTypeName = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCreateTimeStr(String str) {
        this.createTimeStr = str;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setRentCommentKey(String str) {
        this.rentCommentKey = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
