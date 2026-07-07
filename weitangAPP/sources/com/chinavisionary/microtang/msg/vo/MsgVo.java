package com.chinavisionary.microtang.msg.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MsgVo extends BaseVo {
    private String content;
    private Long createTime;
    private Map<String, String> ext;
    private Integer forwardType;
    private boolean hasRead = true;
    private String href;
    private String messageKey;
    private ResourceVo resourceVo;
    private String subTitle;
    private String title;

    public String getContent() {
        return this.content;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public Map<String, String> getExt() {
        return this.ext;
    }

    public Integer getForwardType() {
        return this.forwardType;
    }

    public String getHref() {
        return this.href;
    }

    public String getMessageKey() {
        return this.messageKey;
    }

    public ResourceVo getResourceVo() {
        return this.resourceVo;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isHasRead() {
        return this.hasRead;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCreateTime(Long l) {
        this.createTime = l;
    }

    public void setExt(Map<String, String> map) {
        this.ext = map;
    }

    public void setForwardType(Integer num) {
        this.forwardType = num;
    }

    public void setHasRead(boolean z) {
        this.hasRead = z;
    }

    public void setHref(String str) {
        this.href = str;
    }

    public void setMessageKey(String str) {
        this.messageKey = str;
    }

    public void setResourceVo(ResourceVo resourceVo) {
        this.resourceVo = resourceVo;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
