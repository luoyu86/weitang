package com.chinavisionary.microtang.repair.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CreateRepairOrderCommentVo extends BaseVo {
    private String cleaningOrderKey;
    private String commentContent;
    private List<String> commentResources;
    private int commentResult;
    private String createPrimaryKey;
    private String repairOrderKey;
    private List<ScoresBean> scores;
    private List<String> tags;

    public static class ScoresBean extends BaseVo {
        private float score;
        private String scoreType;

        public float getScore() {
            return this.score;
        }

        public String getScoreType() {
            return this.scoreType;
        }

        public void setScore(float f2) {
            this.score = f2;
        }

        public void setScoreType(String str) {
            this.scoreType = str;
        }
    }

    public String getCleaningOrderKey() {
        return this.cleaningOrderKey;
    }

    public String getCommentContent() {
        return this.commentContent;
    }

    public List<String> getCommentResources() {
        return this.commentResources;
    }

    public int getCommentResult() {
        return this.commentResult;
    }

    public String getCreatePrimaryKey() {
        return this.createPrimaryKey;
    }

    public String getRepairOrderKey() {
        return this.repairOrderKey;
    }

    public List<ScoresBean> getScores() {
        return this.scores;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setCleaningOrderKey(String str) {
        this.cleaningOrderKey = str;
    }

    public void setCommentContent(String str) {
        this.commentContent = str;
    }

    public void setCommentResources(List<String> list) {
        this.commentResources = list;
    }

    public void setCommentResult(int i2) {
        this.commentResult = i2;
    }

    public void setCreatePrimaryKey(String str) {
        this.createPrimaryKey = str;
    }

    public void setRepairOrderKey(String str) {
        this.repairOrderKey = str;
    }

    public void setScores(List<ScoresBean> list) {
        this.scores = list;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }
}
