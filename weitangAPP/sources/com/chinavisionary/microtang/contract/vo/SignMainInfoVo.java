package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SignMainInfoVo extends BaseVo {
    private String assetKey;
    private Boolean changeRentFlag;
    private String contractKey;
    private String emergencyName;
    private String emergencyPhone;
    private String emergencyRelationship;
    private Long estimateRentbackTime;
    private Long estimatedCheckinTime;
    private int paymentMethod;
    private String preContractKey;
    private boolean renewalFlag;
    private Long rentTermTo;
    private List<RoommatesBean> roommates;
    private Long selectedCheckinCleaningDate;
    private String signingCode;

    public static class RoommatesBean extends BaseVo {
        private String idCardBack;
        private String idCardFront;
        private String idCardNo;
        private String idCardType;
        private String name;
        private String phone;

        public String getIdCardBack() {
            return this.idCardBack;
        }

        public String getIdCardFront() {
            return this.idCardFront;
        }

        public String getIdCardNo() {
            return this.idCardNo;
        }

        public String getIdCardType() {
            return this.idCardType;
        }

        public String getName() {
            return this.name;
        }

        public String getPhone() {
            return this.phone;
        }

        public void setIdCardBack(String str) {
            this.idCardBack = str;
        }

        public void setIdCardFront(String str) {
            this.idCardFront = str;
        }

        public void setIdCardNo(String str) {
            this.idCardNo = str;
        }

        public void setIdCardType(String str) {
            this.idCardType = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPhone(String str) {
            this.phone = str;
        }
    }

    public String getAssetKey() {
        return this.assetKey;
    }

    public Boolean getChangeRentFlag() {
        return this.changeRentFlag;
    }

    public String getContractKey() {
        return this.contractKey;
    }

    public String getEmergencyName() {
        return this.emergencyName;
    }

    public String getEmergencyPhone() {
        return this.emergencyPhone;
    }

    public String getEmergencyRelationship() {
        return this.emergencyRelationship;
    }

    public Long getEstimateRentbackTime() {
        return this.estimateRentbackTime;
    }

    public Long getEstimatedCheckinTime() {
        return this.estimatedCheckinTime;
    }

    public int getPaymentMethod() {
        return this.paymentMethod;
    }

    public String getPreContractKey() {
        return this.preContractKey;
    }

    public boolean getRenewalFlag() {
        return this.renewalFlag;
    }

    public Long getRentTermTo() {
        return this.rentTermTo;
    }

    public List<RoommatesBean> getRoommates() {
        return this.roommates;
    }

    public Long getSelectedCheckinCleaningDate() {
        return this.selectedCheckinCleaningDate;
    }

    public String getSigningCode() {
        return this.signingCode;
    }

    public void setAssetKey(String str) {
        this.assetKey = str;
    }

    public void setChangeRentFlag(Boolean bool) {
        this.changeRentFlag = bool;
    }

    public void setContractKey(String str) {
        this.contractKey = str;
    }

    public void setEmergencyName(String str) {
        this.emergencyName = str;
    }

    public void setEmergencyPhone(String str) {
        this.emergencyPhone = str;
    }

    public void setEmergencyRelationship(String str) {
        this.emergencyRelationship = str;
    }

    public void setEstimateRentbackTime(Long l) {
        this.estimateRentbackTime = l;
    }

    public void setEstimatedCheckinTime(Long l) {
        this.estimatedCheckinTime = l;
    }

    public void setPaymentMethod(int i2) {
        this.paymentMethod = i2;
    }

    public void setPreContractKey(String str) {
        this.preContractKey = str;
    }

    public void setRenewalFlag(boolean z) {
        this.renewalFlag = z;
    }

    public void setRentTermTo(Long l) {
        this.rentTermTo = l;
    }

    public void setRoommates(List<RoommatesBean> list) {
        this.roommates = list;
    }

    public void setSelectedCheckinCleaningDate(Long l) {
        this.selectedCheckinCleaningDate = l;
    }

    public void setSigningCode(String str) {
        this.signingCode = str;
    }
}
