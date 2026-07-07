package com.chinavisionary.microtang.merchant.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MerchantCommentVo extends BaseVo {
    private ResourceVo avatar;
    private String commentKey;
    private Long commentTime;
    private String content;
    private String nickname;
    private List<ResourceVo> pics;

    public ResourceVo getAvatar() {
        return this.avatar;
    }

    public String getCommentKey() {
        return this.commentKey;
    }

    public Long getCommentTime() {
        return this.commentTime;
    }

    public String getContent() {
        return this.content;
    }

    public String getNickname() {
        return this.nickname;
    }

    public List<ResourceVo> getPics() {
        return this.pics;
    }

    public void setAvatar(ResourceVo resourceVo) {
        this.avatar = resourceVo;
    }

    public void setCommentKey(String str) {
        this.commentKey = str;
    }

    public void setCommentTime(Long l) {
        this.commentTime = l;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setPics(List<ResourceVo> list) {
        this.pics = list;
    }
}
