package com.chinavisionary.microtang.comment.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class CreateCommentScoresBo extends BaseVo {
    private Float score;
    private String scoreType;
    private String type;

    public Float getScore() {
        return this.score;
    }

    public String getScoreType() {
        return this.scoreType;
    }

    public String getType() {
        return this.type;
    }

    public void setScore(Float f2) {
        this.score = f2;
    }

    public void setScoreType(String str) {
        this.scoreType = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
