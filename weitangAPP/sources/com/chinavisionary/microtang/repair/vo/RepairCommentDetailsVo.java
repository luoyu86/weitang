package com.chinavisionary.microtang.repair.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.comment.vo.ScoresBean;
import com.chinavisionary.microtang.repair.vo.RepairOrderCommentScoreVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RepairCommentDetailsVo extends BaseVo {
    private boolean comment;
    private boolean commentResult;
    private String content;
    private boolean isComment;
    private String orderKey;
    private List<ResourceVo> resources;
    private List<ScoresBean> scores;
    private List<RepairOrderCommentScoreVo.TagsBean> tags;

    public String getContent() {
        return this.content;
    }

    public String getOrderKey() {
        return this.orderKey;
    }

    public List<ResourceVo> getResources() {
        return this.resources;
    }

    public List<ScoresBean> getScores() {
        return this.scores;
    }

    public List<RepairOrderCommentScoreVo.TagsBean> getTags() {
        return this.tags;
    }

    public boolean isComment() {
        return this.comment;
    }

    public boolean isCommentResult() {
        return this.commentResult;
    }

    public boolean isIsComment() {
        return this.isComment;
    }

    public void setComment(boolean z) {
        this.comment = z;
    }

    public void setCommentResult(boolean z) {
        this.commentResult = z;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setIsComment(boolean z) {
        this.isComment = z;
    }

    public void setOrderKey(String str) {
        this.orderKey = str;
    }

    public void setResources(List<ResourceVo> list) {
        this.resources = list;
    }

    public void setScores(List<ScoresBean> list) {
        this.scores = list;
    }

    public void setTags(List<RepairOrderCommentScoreVo.TagsBean> list) {
        this.tags = list;
    }
}
