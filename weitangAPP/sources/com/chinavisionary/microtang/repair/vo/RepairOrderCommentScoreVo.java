package com.chinavisionary.microtang.repair.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.microtang.comment.vo.ScoresBean;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RepairOrderCommentScoreVo extends BaseVo {
    private List<ScoresBean> scores;
    private List<TagsBean> tags;

    public static class TagsBean extends BaseVo {
        private String tagCode;
        private String tagDesc;

        public String getTagCode() {
            return this.tagCode;
        }

        public String getTagDesc() {
            return this.tagDesc;
        }

        public void setTagCode(String str) {
            this.tagCode = str;
        }

        public void setTagDesc(String str) {
            this.tagDesc = str;
        }
    }

    public List<ScoresBean> getScores() {
        return this.scores;
    }

    public List<TagsBean> getTags() {
        return this.tags;
    }

    public void setScores(List<ScoresBean> list) {
        this.scores = list;
    }

    public void setTags(List<TagsBean> list) {
        this.tags = list;
    }
}
