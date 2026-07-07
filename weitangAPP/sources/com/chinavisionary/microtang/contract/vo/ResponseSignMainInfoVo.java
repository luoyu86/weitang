package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ResponseSignMainInfoVo extends BaseVo {
    private String contactAddress;
    private String contactKey;
    private String contactName;
    private String contactPhone;
    private String idCardNo;
    private String idCardType;
    private String key;
    private int maxRoommateNumber;
    private String message;
    private String nation;
    private String phone;
    private String relationship;
    private List<RoommatesBean> roommates;
    private boolean success;
    private String userKey;
    private String userName;
    private String workspace;

    public static class RoommatesBean extends BaseVo {
        private String cardType;
        private String idCardBack;
        private String idCardFront;
        private String idCardNo;
        private String name;
        private String phone;
        private String primaryKey;

        public String getCardType() {
            return this.cardType;
        }

        public String getIdCardBack() {
            return this.idCardBack;
        }

        public String getIdCardFront() {
            return this.idCardFront;
        }

        public String getIdCardNo() {
            return this.idCardNo;
        }

        public String getName() {
            return this.name;
        }

        public String getPhone() {
            return this.phone;
        }

        public String getPrimaryKey() {
            return this.primaryKey;
        }

        public void setCardType(String str) {
            this.cardType = str;
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

        public void setName(String str) {
            this.name = str;
        }

        public void setPhone(String str) {
            this.phone = str;
        }

        public void setPrimaryKey(String str) {
            this.primaryKey = str;
        }
    }

    public String getContactAddress() {
        return this.contactAddress;
    }

    public String getContactKey() {
        return this.contactKey;
    }

    public String getContactName() {
        return this.contactName;
    }

    public String getContactPhone() {
        return this.contactPhone;
    }

    public String getIdCardNo() {
        return this.idCardNo;
    }

    public String getIdCardType() {
        return this.idCardType;
    }

    public String getKey() {
        return this.key;
    }

    public int getMaxRoommateNumber() {
        return this.maxRoommateNumber;
    }

    public String getMessage() {
        return this.message;
    }

    public String getNation() {
        return this.nation;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getRelationship() {
        return this.relationship;
    }

    public List<RoommatesBean> getRoommates() {
        return this.roommates;
    }

    public String getUserKey() {
        return this.userKey;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getWorkspace() {
        return this.workspace;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setContactAddress(String str) {
        this.contactAddress = str;
    }

    public void setContactKey(String str) {
        this.contactKey = str;
    }

    public void setContactName(String str) {
        this.contactName = str;
    }

    public void setContactPhone(String str) {
        this.contactPhone = str;
    }

    public void setIdCardNo(String str) {
        this.idCardNo = str;
    }

    public void setIdCardType(String str) {
        this.idCardType = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMaxRoommateNumber(int i2) {
        this.maxRoommateNumber = i2;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setNation(String str) {
        this.nation = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setRelationship(String str) {
        this.relationship = str;
    }

    public void setRoommates(List<RoommatesBean> list) {
        this.roommates = list;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public void setUserKey(String str) {
        this.userKey = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setWorkspace(String str) {
        this.workspace = str;
    }
}
