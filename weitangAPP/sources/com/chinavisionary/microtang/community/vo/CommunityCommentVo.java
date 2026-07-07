package com.chinavisionary.microtang.community.vo;

import androidx.annotation.NonNull;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class CommunityCommentVo extends BaseVo implements Cloneable {
    private int commentCount;
    private String content;
    private int likeCount;
    private ArrayList<ResourceVo> publishPicList;
    private Long publishTime;
    private ResourceVo userIconResource;
    private String userName;

    public int getCommentCount() {
        return this.commentCount;
    }

    public String getContent() {
        return this.content;
    }

    public int getLikeCount() {
        return this.likeCount;
    }

    public ArrayList<ResourceVo> getPublishPicList() {
        return this.publishPicList;
    }

    public Long getPublishTime() {
        return this.publishTime;
    }

    public ResourceVo getUserIconResource() {
        return this.userIconResource;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setCommentCount(int i2) {
        this.commentCount = i2;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setLikeCount(int i2) {
        this.likeCount = i2;
    }

    public void setPublishPicList(ArrayList<ResourceVo> arrayList) {
        this.publishPicList = arrayList;
    }

    public void setPublishTime(Long l) {
        this.publishTime = l;
    }

    public void setUserIconResource(ResourceVo resourceVo) {
        this.userIconResource = resourceVo;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    @NonNull
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CommunityCommentVo m72clone() {
        try {
            return (CommunityCommentVo) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
