package com.chinavisionary.framework.mobile.comment.vo;

import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommentListItemVo {
    private String anonymousStatus;
    private ResourceVo avatar;
    private Long beginDate;
    private Long commentCreateTime;
    private String content;
    private Integer floor;
    private String key;
    private String name;
    private List<ResourceVo> photoAttachmentList;
    private List<CommentListItemVo> replyCommentList;
    private Double score;
    private String targetKey;
    private Integer targetType;

    public String getAnonymousStatus() {
        return this.anonymousStatus;
    }

    public ResourceVo getAvatar() {
        return this.avatar;
    }

    public Long getBeginDate() {
        return this.beginDate;
    }

    public Long getCommentCreateTime() {
        return this.commentCreateTime;
    }

    public String getContent() {
        return this.content;
    }

    public Integer getFloor() {
        return this.floor;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public List<ResourceVo> getPhotoAttachmentList() {
        return this.photoAttachmentList;
    }

    public List<CommentListItemVo> getReplyCommentList() {
        return this.replyCommentList;
    }

    public Double getScore() {
        return this.score;
    }

    public String getTargetKey() {
        return this.targetKey;
    }

    public Integer getTargetType() {
        return this.targetType;
    }

    public void setAnonymousStatus(String str) {
        this.anonymousStatus = str;
    }

    public void setAvatar(ResourceVo resourceVo) {
        this.avatar = resourceVo;
    }

    public void setBeginDate(Long l) {
        this.beginDate = l;
    }

    public void setCommentCreateTime(Long l) {
        this.commentCreateTime = l;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setFloor(Integer num) {
        this.floor = num;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPhotoAttachmentList(List<ResourceVo> list) {
        this.photoAttachmentList = list;
    }

    public void setReplyCommentList(List<CommentListItemVo> list) {
        this.replyCommentList = list;
    }

    public void setScore(Double d2) {
        this.score = d2;
    }

    public void setTargetKey(String str) {
        this.targetKey = str;
    }

    public void setTargetType(Integer num) {
        this.targetType = num;
    }
}
