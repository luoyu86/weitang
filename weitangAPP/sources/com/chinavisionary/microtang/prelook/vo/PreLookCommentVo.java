package com.chinavisionary.microtang.prelook.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PreLookCommentVo extends BaseVo {
    private String commentContent;
    private List<String> commentResources;
    private String createPrimaryKey;
    private String repairOrderKey;
    private List<?> scores;

    public String getCommentContent() {
        return this.commentContent;
    }

    public List<String> getCommentResources() {
        return this.commentResources;
    }

    public String getCreatePrimaryKey() {
        return this.createPrimaryKey;
    }

    public String getRepairOrderKey() {
        return this.repairOrderKey;
    }

    public List<?> getScores() {
        return this.scores;
    }

    public void setCommentContent(String str) {
        this.commentContent = str;
    }

    public void setCommentResources(List<String> list) {
        this.commentResources = list;
    }

    public void setCreatePrimaryKey(String str) {
        this.createPrimaryKey = str;
    }

    public void setRepairOrderKey(String str) {
        this.repairOrderKey = str;
    }

    public void setScores(List<?> list) {
        this.scores = list;
    }
}
