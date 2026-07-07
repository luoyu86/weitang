package com.chinavisionary.microtang.comment.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CreateCommentBo extends BaseVo {
    private String content;
    private List<String> imageUrls;
    private String rentCommentKey;
    private List<String> resourceKeys;
    private List<CreateCommentScoresBo> scores;
    private String tipMsg;

    public String getContent() {
        return this.content;
    }

    public List<String> getImageUrls() {
        return this.imageUrls;
    }

    public String getRentCommentKey() {
        return this.rentCommentKey;
    }

    public List<String> getResourceKeys() {
        return this.resourceKeys;
    }

    public List<CreateCommentScoresBo> getScores() {
        return this.scores;
    }

    public String getTipMsg() {
        return this.tipMsg;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setImageUrls(List<String> list) {
        this.imageUrls = list;
    }

    public void setRentCommentKey(String str) {
        this.rentCommentKey = str;
    }

    public void setResourceKeys(List<String> list) {
        this.resourceKeys = list;
    }

    public void setScores(List<CreateCommentScoresBo> list) {
        this.scores = list;
    }

    public void setTipMsg(String str) {
        this.tipMsg = str;
    }
}
