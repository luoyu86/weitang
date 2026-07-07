package com.chinavisionary.microtang.main.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ResponseGroupResultVo extends BaseVo {
    private List<GroupItemVo> groupItemCloudDtos;
    private String projectDesc;
    private String projectKey;
    private String projectName;

    public List<GroupItemVo> getGroupItemCloudDtos() {
        return this.groupItemCloudDtos;
    }

    public String getProjectDesc() {
        return this.projectDesc;
    }

    public String getProjectKey() {
        return this.projectKey;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setGroupItemCloudDtos(List<GroupItemVo> list) {
        this.groupItemCloudDtos = list;
    }

    public void setProjectDesc(String str) {
        this.projectDesc = str;
    }

    public void setProjectKey(String str) {
        this.projectKey = str;
    }

    public void setProjectName(String str) {
        this.projectName = str;
    }
}
