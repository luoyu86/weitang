package com.chinavisionary.microtang.repair.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RepairOrderItemDetailsVo extends BaseVo {
    private BaseInfoBean baseInfo;
    private CommentInfoBean commentInfo;
    private WorkerInfoBean workerInfo;

    public static class BaseInfoBean extends BaseVo {
        private String actualAssetDesc;
        private List<ResourceVo> actualBreakdownResource;
        private String actualReason;
        private String address;
        private String assetDesc;
        private String billKey;
        private List<ResourceVo> breakdownResource;
        private String customerName;
        private Long fromTime;
        private boolean isAuthOpen;
        private Long openFromTime;
        private Long openToTime;
        private String phone;
        private String place;
        private String reason;
        private String remark;
        private BigDecimal repairAmount;
        private String repairAmountTypeName;
        private String repairOrderKey;
        private String repairOrderNo;
        private int status;
        private Long toTime;
        private String workOrderKey;

        public String getActualAssetDesc() {
            return this.actualAssetDesc;
        }

        public List<ResourceVo> getActualBreakdownResource() {
            return this.actualBreakdownResource;
        }

        public String getActualReason() {
            return this.actualReason;
        }

        public String getAddress() {
            return this.address;
        }

        public String getAssetDesc() {
            return this.assetDesc;
        }

        public boolean getAuthOpen() {
            return this.isAuthOpen;
        }

        public String getBillKey() {
            return this.billKey;
        }

        public List<ResourceVo> getBreakdownResource() {
            return this.breakdownResource;
        }

        public String getCustomerName() {
            return this.customerName;
        }

        public Long getFromTime() {
            return this.fromTime;
        }

        public Long getOpenFromTime() {
            return this.openFromTime;
        }

        public Long getOpenToTime() {
            return this.openToTime;
        }

        public String getPhone() {
            return this.phone;
        }

        public String getPlace() {
            return this.place;
        }

        public String getReason() {
            return this.reason;
        }

        public String getRemark() {
            return this.remark;
        }

        public BigDecimal getRepairAmount() {
            return this.repairAmount;
        }

        public String getRepairAmountTypeName() {
            return this.repairAmountTypeName;
        }

        public String getRepairOrderKey() {
            return this.repairOrderKey;
        }

        public String getRepairOrderNo() {
            return this.repairOrderNo;
        }

        public int getStatus() {
            return this.status;
        }

        public Long getToTime() {
            return this.toTime;
        }

        public String getWorkOrderKey() {
            return this.workOrderKey;
        }

        public void setActualAssetDesc(String str) {
            this.actualAssetDesc = str;
        }

        public void setActualBreakdownResource(List<ResourceVo> list) {
            this.actualBreakdownResource = list;
        }

        public void setActualReason(String str) {
            this.actualReason = str;
        }

        public void setAddress(String str) {
            this.address = str;
        }

        public void setAssetDesc(String str) {
            this.assetDesc = str;
        }

        public void setAuthOpen(boolean z) {
            this.isAuthOpen = z;
        }

        public void setBillKey(String str) {
            this.billKey = str;
        }

        public void setBreakdownResource(List<ResourceVo> list) {
            this.breakdownResource = list;
        }

        public void setCustomerName(String str) {
            this.customerName = str;
        }

        public void setFromTime(Long l) {
            this.fromTime = l;
        }

        public void setOpenFromTime(Long l) {
            this.openFromTime = l;
        }

        public void setOpenToTime(Long l) {
            this.openToTime = l;
        }

        public void setPhone(String str) {
            this.phone = str;
        }

        public void setPlace(String str) {
            this.place = str;
        }

        public void setReason(String str) {
            this.reason = str;
        }

        public void setRemark(String str) {
            this.remark = str;
        }

        public void setRepairAmount(BigDecimal bigDecimal) {
            this.repairAmount = bigDecimal;
        }

        public void setRepairAmountTypeName(String str) {
            this.repairAmountTypeName = str;
        }

        public void setRepairOrderKey(String str) {
            this.repairOrderKey = str;
        }

        public void setRepairOrderNo(String str) {
            this.repairOrderNo = str;
        }

        public void setStatus(int i2) {
            this.status = i2;
        }

        public void setToTime(Long l) {
            this.toTime = l;
        }

        public void setWorkOrderKey(String str) {
            this.workOrderKey = str;
        }
    }

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
        private String repairName;
        private String repairPhone;
        private String repairUserKey;
        private int score;
        private int workorderNums;

        public String getRepairName() {
            return this.repairName;
        }

        public String getRepairPhone() {
            return this.repairPhone;
        }

        public String getRepairUserKey() {
            return this.repairUserKey;
        }

        public int getScore() {
            return this.score;
        }

        public int getWorkorderNums() {
            return this.workorderNums;
        }

        public void setRepairName(String str) {
            this.repairName = str;
        }

        public void setRepairPhone(String str) {
            this.repairPhone = str;
        }

        public void setRepairUserKey(String str) {
            this.repairUserKey = str;
        }

        public void setScore(int i2) {
            this.score = i2;
        }

        public void setWorkorderNums(int i2) {
            this.workorderNums = i2;
        }
    }

    public BaseInfoBean getBaseInfo() {
        return this.baseInfo;
    }

    public CommentInfoBean getCommentInfo() {
        return this.commentInfo;
    }

    public WorkerInfoBean getWorkerInfo() {
        return this.workerInfo;
    }

    public void setBaseInfo(BaseInfoBean baseInfoBean) {
        this.baseInfo = baseInfoBean;
    }

    public void setCommentInfo(CommentInfoBean commentInfoBean) {
        this.commentInfo = commentInfoBean;
    }

    public void setWorkerInfo(WorkerInfoBean workerInfoBean) {
        this.workerInfo = workerInfoBean;
    }
}
