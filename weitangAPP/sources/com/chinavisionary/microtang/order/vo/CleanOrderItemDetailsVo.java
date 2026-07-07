package com.chinavisionary.microtang.order.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CleanOrderItemDetailsVo extends BaseVo {
    private CleanOrderDetailsVo baseInfo;
    private CommentInfoBean commentInfo;
    private WorkerInfoBean workerInfo;

    public static class CommentInfoBean extends BaseVo {
        private String commentContent;
        private List<ScoresBean> scores;

        public static class ScoresBean extends BaseVo {
            private String commentType;
            private String score;

            public String getCommentType() {
                return this.commentType;
            }

            public String getScore() {
                return this.score;
            }

            public void setCommentType(String str) {
                this.commentType = str;
            }

            public void setScore(String str) {
                this.score = str;
            }
        }

        public String getCommentContent() {
            return this.commentContent;
        }

        public List<ScoresBean> getScores() {
            return this.scores;
        }

        public void setCommentContent(String str) {
            this.commentContent = str;
        }

        public void setScores(List<ScoresBean> list) {
            this.scores = list;
        }
    }

    public static class WorkerInfoBean extends BaseVo {
        private String handlerKey;
        private String handlerName;
        private String handlerPhone;

        public String getHandlerKey() {
            return this.handlerKey;
        }

        public String getHandlerName() {
            return this.handlerName;
        }

        public String getHandlerPhone() {
            return this.handlerPhone;
        }

        public void setHandlerKey(String str) {
            this.handlerKey = str;
        }

        public void setHandlerName(String str) {
            this.handlerName = str;
        }

        public void setHandlerPhone(String str) {
            this.handlerPhone = str;
        }
    }

    public CleanOrderDetailsVo getBaseInfo() {
        return this.baseInfo;
    }

    public CommentInfoBean getCommentInfo() {
        return this.commentInfo;
    }

    public WorkerInfoBean getWorkerInfo() {
        return this.workerInfo;
    }

    public void setBaseInfo(CleanOrderDetailsVo cleanOrderDetailsVo) {
        this.baseInfo = cleanOrderDetailsVo;
    }

    public void setCommentInfo(CommentInfoBean commentInfoBean) {
        this.commentInfo = commentInfoBean;
    }

    public void setWorkerInfo(WorkerInfoBean workerInfoBean) {
        this.workerInfo = workerInfoBean;
    }
}
