package com.chinavisionary.microtang.service.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CustomerServerRecordVo extends BaseVo {
    private Long createTime;
    private String key;
    private List<ResourceVo> picture;
    private String remark;
    private String reply;
    private List<ScopeVo> scope;
    private List<ScopeVo> scopeDescribe;
    private Integer state;
    private String stateName;

    public Long getCreateTime() {
        return this.createTime;
    }

    public String getKey() {
        return this.key;
    }

    public List<ResourceVo> getPicture() {
        return this.picture;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getReply() {
        return this.reply;
    }

    public List<ScopeVo> getScope() {
        return this.scope;
    }

    public List<ScopeVo> getScopeDescribe() {
        return this.scopeDescribe;
    }

    public Integer getState() {
        return this.state;
    }

    public String getStateName() {
        return this.stateName;
    }

    public void setCreateTime(Long l) {
        this.createTime = l;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setPicture(List<ResourceVo> list) {
        this.picture = list;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setReply(String str) {
        this.reply = str;
    }

    public void setScope(List<ScopeVo> list) {
        this.scope = list;
    }

    public void setScopeDescribe(List<ScopeVo> list) {
        this.scopeDescribe = list;
    }

    public void setState(Integer num) {
        this.state = num;
    }

    public void setStateName(String str) {
        this.stateName = str;
    }
}
