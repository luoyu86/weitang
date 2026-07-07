package com.chinavisionary.microtang.service.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CustomerServiceReasonVo extends BaseVo {
    private String key;
    private ResourceVo mUserIcon;
    private String name;
    private String phone;
    private String reason;
    private List<ResourceVo> reasonList;
    private String reply;
    private List<ResourceVo> replyList;
    private Long time;

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getReason() {
        return this.reason;
    }

    public List<ResourceVo> getReasonList() {
        return this.reasonList;
    }

    public String getReply() {
        return this.reply;
    }

    public List<ResourceVo> getReplyList() {
        return this.replyList;
    }

    public Long getTime() {
        return this.time;
    }

    public ResourceVo getUserIcon() {
        return this.mUserIcon;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setReasonList(List<ResourceVo> list) {
        this.reasonList = list;
    }

    public void setReply(String str) {
        this.reply = str;
    }

    public void setReplyList(List<ResourceVo> list) {
        this.replyList = list;
    }

    public void setTime(Long l) {
        this.time = l;
    }

    public void setUserIcon(ResourceVo resourceVo) {
        this.mUserIcon = resourceVo;
    }
}
