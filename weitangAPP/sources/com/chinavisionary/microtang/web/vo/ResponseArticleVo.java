package com.chinavisionary.microtang.web.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseArticleVo extends BaseVo {
    private String appid;
    private String articleAbstract;
    private String articleContent;
    private int articleStatus;
    private String articleTitle;
    private int articleType;
    private Long createTime;
    private String createUser;
    private String enterpriseid;
    private int id;
    private String primaryKey;
    private String remark;
    private Long updateTime;
    private String updateUser;

    public String getAppid() {
        return this.appid;
    }

    public String getArticleAbstract() {
        return this.articleAbstract;
    }

    public String getArticleContent() {
        return this.articleContent;
    }

    public int getArticleStatus() {
        return this.articleStatus;
    }

    public String getArticleTitle() {
        return this.articleTitle;
    }

    public int getArticleType() {
        return this.articleType;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public String getEnterpriseid() {
        return this.enterpriseid;
    }

    public int getId() {
        return this.id;
    }

    public String getPrimaryKey() {
        return this.primaryKey;
    }

    public String getRemark() {
        return this.remark;
    }

    public Long getUpdateTime() {
        return this.updateTime;
    }

    public String getUpdateUser() {
        return this.updateUser;
    }

    public void setAppid(String str) {
        this.appid = str;
    }

    public void setArticleAbstract(String str) {
        this.articleAbstract = str;
    }

    public void setArticleContent(String str) {
        this.articleContent = str;
    }

    public void setArticleStatus(int i2) {
        this.articleStatus = i2;
    }

    public void setArticleTitle(String str) {
        this.articleTitle = str;
    }

    public void setArticleType(int i2) {
        this.articleType = i2;
    }

    public void setCreateTime(Long l) {
        this.createTime = l;
    }

    public void setCreateUser(String str) {
        this.createUser = str;
    }

    public void setEnterpriseid(String str) {
        this.enterpriseid = str;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setPrimaryKey(String str) {
        this.primaryKey = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setUpdateTime(Long l) {
        this.updateTime = l;
    }

    public void setUpdateUser(String str) {
        this.updateUser = str;
    }
}
