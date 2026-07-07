package com.chinavisionary.microtang.room.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.microtang.room.vo.ProductDetailsVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseMoreRentCommentVo extends BaseVo {
    private float averageScore;
    private List<MoreRentCommentVo> comments;
    private String key;
    private String message;
    private boolean success;
    private List<ProductDetailsVo.TagsBean> tags;

    public float getAverageScore() {
        return this.averageScore;
    }

    public List<MoreRentCommentVo> getComments() {
        return this.comments;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public List<ProductDetailsVo.TagsBean> getTags() {
        return this.tags;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setAverageScore(float f2) {
        this.averageScore = f2;
    }

    public void setComments(List<MoreRentCommentVo> list) {
        this.comments = list;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public void setTags(List<ProductDetailsVo.TagsBean> list) {
        this.tags = list;
    }
}
