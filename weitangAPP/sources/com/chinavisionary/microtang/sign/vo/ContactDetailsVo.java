package com.chinavisionary.microtang.sign.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ContactDetailsVo extends BaseVo {
    private String address;
    private String contractEnclosureHtmlCode;
    private String contractStatus;
    private String paymentMethod;
    private String propertyManegementStatus;
    private long rentEnd;
    private BigDecimal rentFee;
    private long rentStart;
    private List<RoommatesBean> roommates;
    private Integer tenantCount;

    public static class RoommatesBean extends BaseVo {
        private String address;
        private String backName;
        private String cardType;
        private int cardTypeValue;
        private String contractKey;
        private String faceName;
        private String idCardBack;
        private String idCardBackKey;
        private String idCardFront;
        private String idCardFrontKey;
        private String idCardNo;
        private String name;
        private String phone;

        public String getAddress() {
            return this.address;
        }

        public String getBackName() {
            return this.backName;
        }

        public String getCardType() {
            return this.cardType;
        }

        public int getCardTypeValue() {
            return this.cardTypeValue;
        }

        public String getContractKey() {
            return this.contractKey;
        }

        public String getFaceName() {
            return this.faceName;
        }

        public String getIdCardBack() {
            return this.idCardBack;
        }

        public String getIdCardBackKey() {
            return this.idCardBackKey;
        }

        public String getIdCardFront() {
            return this.idCardFront;
        }

        public String getIdCardFrontKey() {
            return this.idCardFrontKey;
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

        public void setBackName(String str) {
            this.backName = str;
        }

        public void setCardType(String str) {
            this.cardType = str;
        }

        public void setCardTypeValue(int i2) {
            this.cardTypeValue = i2;
        }

        public void setContractKey(String str) {
            this.contractKey = str;
        }

        public void setFaceName(String str) {
            this.faceName = str;
        }

        public void setIdCardBack(String str) {
            this.idCardBack = str;
        }

        public void setIdCardBackKey(String str) {
            this.idCardBackKey = str;
        }

        public void setIdCardFront(String str) {
            this.idCardFront = str;
        }

        public void setIdCardFrontKey(String str) {
            this.idCardFrontKey = str;
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

    public String getAddress() {
        return this.address;
    }

    public String getContractEnclosureHtmlCode() {
        return this.contractEnclosureHtmlCode;
    }

    public String getContractStatus() {
        return this.contractStatus;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public String getPropertyManegementStatus() {
        return this.propertyManegementStatus;
    }

    public long getRentEnd() {
        return this.rentEnd;
    }

    public BigDecimal getRentFee() {
        return this.rentFee;
    }

    public long getRentStart() {
        return this.rentStart;
    }

    public List<RoommatesBean> getRoommates() {
        return this.roommates;
    }

    public Integer getTenantCount() {
        return this.tenantCount;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setContractEnclosureHtmlCode(String str) {
        this.contractEnclosureHtmlCode = str;
    }

    public void setContractStatus(String str) {
        this.contractStatus = str;
    }

    public void setPaymentMethod(String str) {
        this.paymentMethod = str;
    }

    public void setPropertyManegementStatus(String str) {
        this.propertyManegementStatus = str;
    }

    public void setRentEnd(long j) {
        this.rentEnd = j;
    }

    public void setRentFee(BigDecimal bigDecimal) {
        this.rentFee = bigDecimal;
    }

    public void setRentStart(long j) {
        this.rentStart = j;
    }

    public void setRoommates(List<RoommatesBean> list) {
        this.roommates = list;
    }

    public void setTenantCount(Integer num) {
        this.tenantCount = num;
    }
}
