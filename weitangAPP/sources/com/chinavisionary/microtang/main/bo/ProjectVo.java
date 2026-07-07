package com.chinavisionary.microtang.main.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ProjectVo extends BaseVo {
    private String name;
    private String primaryKey;
    private String projectDescUrl;
    private String projectKey;
    private String projectName;
    private String url;

    public String getName() {
        return this.name;
    }

    public String getPrimaryKey() {
        return this.primaryKey;
    }

    public String getProjectDescUrl() {
        return this.projectDescUrl;
    }

    public String getProjectKey() {
        return this.primaryKey;
    }

    public String getProjectName() {
        return this.name;
    }

    public String getUrl() {
        return this.projectDescUrl;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPrimaryKey(String str) {
        this.primaryKey = str;
    }

    public void setProjectDescUrl(String str) {
        this.projectDescUrl = str;
    }

    public void setProjectKey(String str) {
        this.projectKey = str;
    }

    public void setProjectName(String str) {
        this.projectName = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
