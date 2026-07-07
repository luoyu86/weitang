package com.chinavisionary.microtang.sign.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RentUserInfoVo extends BaseVo {
    private String address;
    private String cardName;
    private List<EmergencyContactsBean> emergencyContacts;
    private String idCardNo;
    private String name;
    private String phone;

    public static class EmergencyContactsBean extends BaseVo {
        private String contactName;
        private String contactPhone;
        private String relationship;

        public String getContactName() {
            return this.contactName;
        }

        public String getContactPhone() {
            return this.contactPhone;
        }

        public String getRelationship() {
            return this.relationship;
        }

        public void setContactName(String str) {
            this.contactName = str;
        }

        public void setContactPhone(String str) {
            this.contactPhone = str;
        }

        public void setRelationship(String str) {
            this.relationship = str;
        }
    }

    public String getAddress() {
        return this.address;
    }

    public String getCardName() {
        return this.cardName;
    }

    public List<EmergencyContactsBean> getEmergencyContacts() {
        return this.emergencyContacts;
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

    public void setAddress(String str) {
        this.address = str;
    }

    public void setCardName(String str) {
        this.cardName = str;
    }

    public void setEmergencyContacts(List<EmergencyContactsBean> list) {
        this.emergencyContacts = list;
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
}
