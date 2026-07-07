package com.chinavisionary.microtang.community.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RequestActivityCommentBo extends BaseVo {
    private String activityPrimaryKey;
    private String content;
    private List<String> pictureUrl;
    private int score;

    public String getActivityPrimaryKey() {
        return this.activityPrimaryKey;
    }

    public String getContent() {
        return this.content;
    }

    public List<String> getPictureUrl() {
        return this.pictureUrl;
    }

    public int getScore() {
        return this.score;
    }

    public void setActivityPrimaryKey(String str) {
        this.activityPrimaryKey = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setPictureUrl(List<String> list) {
        this.pictureUrl = list;
    }

    public void setScore(int i2) {
        this.score = i2;
    }
}
