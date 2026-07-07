package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ContractCommentVo extends BaseVo {
    private List<CommentItemsBean> commentItems;
    private List<CommentTagsBean> commentTags;
    private String key;
    private String message;
    private boolean success;

    public static class CommentItemsBean extends BaseVo {
        private int score;
        private String scoreCode;
        private String scoreName;

        public int getScore() {
            return this.score;
        }

        public String getScoreCode() {
            return this.scoreCode;
        }

        public String getScoreName() {
            return this.scoreName;
        }

        public void setScore(int i2) {
            this.score = i2;
        }

        public void setScoreCode(String str) {
            this.scoreCode = str;
        }

        public void setScoreName(String str) {
            this.scoreName = str;
        }
    }

    public static class CommentTagsBean extends BaseVo {
        private String tagKey;
        private String tagName;

        public String getTagKey() {
            return this.tagKey;
        }

        public String getTagName() {
            return this.tagName;
        }

        public void setTagKey(String str) {
            this.tagKey = str;
        }

        public void setTagName(String str) {
            this.tagName = str;
        }
    }

    public List<CommentItemsBean> getCommentItems() {
        return this.commentItems;
    }

    public List<CommentTagsBean> getCommentTags() {
        return this.commentTags;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setCommentItems(List<CommentItemsBean> list) {
        this.commentItems = list;
    }

    public void setCommentTags(List<CommentTagsBean> list) {
        this.commentTags = list;
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
}
