package com.chinavisionary.microtang.community.vo;

import c.e.a.d.o;
import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ResponseActivityCommentVo extends NewBaseVo {
    private String activityPrimaryKey;
    private String content;
    private int isScore;
    private List<String> pictureUrl;
    private List<ResourceVo> pictureUrlList;
    private int score;

    public String getActivityPrimaryKey() {
        return this.activityPrimaryKey;
    }

    public String getContent() {
        return this.content;
    }

    public boolean getIsEvaluate() {
        return this.isScore == 1;
    }

    public int getIsScore() {
        return this.isScore;
    }

    public List<String> getPictureUrl() {
        return this.pictureUrl;
    }

    public List<ResourceVo> getPictureUrlList() {
        List<String> list = this.pictureUrl;
        if (list != null && this.pictureUrlList == null && o.isNotEmpty(list)) {
            this.pictureUrlList = new ArrayList();
            for (String str : this.pictureUrl) {
                ResourceVo resourceVo = new ResourceVo();
                resourceVo.setUrl(str);
                resourceVo.setSampleUrl(str);
                this.pictureUrlList.add(resourceVo);
            }
        }
        return this.pictureUrlList;
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

    public void setIsScore(int i2) {
        this.isScore = i2;
    }

    public void setPictureUrl(List<String> list) {
        this.pictureUrl = list;
    }

    public void setScore(int i2) {
        this.score = i2;
    }
}
