package com.chinavisionary.microtang.main.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.microtang.sign.vo.RentClearTimeVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ResponseRentConfigFeeVo extends BaseVo {
    private String address;
    private String assetKey;
    private boolean checkinCleaningDateFlag;
    private int contractPaymentMethod;
    private String contractPaymentMethodName;
    private int depositType;
    private String depositTypeName;
    private Long estimatedCheckinTimeFrom;
    private Long estimatedCheckinTimeTo;
    private boolean isShortRentSupport;
    private String key;
    private String message;
    private List<RentClearTimeVo> optionalCleaningDates;
    private List<PaymentMethodsBean> paymentMethods;
    private int rentDurationType;
    private String rentDurationTypeDesc;
    private String rentDurationTypeName;
    private String rentTerm;
    private Long rentTermEarliestTo;
    private Long rentTermFrom;
    private Long rentTermLatestTo;
    private Long rentTermTo;
    private boolean success;

    public static class PaymentMethodsBean extends BaseVo {
        private List<ConfigItemsBean> configItems;
        private int rentFeePaymentMethodType;
        private String rentFeePaymentMethodTypeName;

        public static class ConfigItemsBean extends BaseVo {
            private String rentFee;
            private int rentFeeType;
            private String rentFeeTypeName;

            public String getRentFee() {
                return this.rentFee;
            }

            public int getRentFeeType() {
                return this.rentFeeType;
            }

            public String getRentFeeTypeName() {
                return this.rentFeeTypeName;
            }

            public void setRentFee(String str) {
                this.rentFee = str;
            }

            public void setRentFeeType(int i2) {
                this.rentFeeType = i2;
            }

            public void setRentFeeTypeName(String str) {
                this.rentFeeTypeName = str;
            }
        }

        public List<ConfigItemsBean> getConfigItems() {
            return this.configItems;
        }

        public int getRentFeePaymentMethodType() {
            return this.rentFeePaymentMethodType;
        }

        public String getRentFeePaymentMethodTypeName() {
            return this.rentFeePaymentMethodTypeName;
        }

        public void setConfigItems(List<ConfigItemsBean> list) {
            this.configItems = list;
        }

        public void setRentFeePaymentMethodType(int i2) {
            this.rentFeePaymentMethodType = i2;
        }

        public void setRentFeePaymentMethodTypeName(String str) {
            this.rentFeePaymentMethodTypeName = str;
        }
    }

    public String getAddress() {
        return this.address;
    }

    public String getAssetKey() {
        return this.assetKey;
    }

    public int getContractPaymentMethod() {
        return this.contractPaymentMethod;
    }

    public String getContractPaymentMethodName() {
        return this.contractPaymentMethodName;
    }

    public int getDepositType() {
        return this.depositType;
    }

    public String getDepositTypeName() {
        return this.depositTypeName;
    }

    public Long getEstimatedCheckinTimeFrom() {
        return this.estimatedCheckinTimeFrom;
    }

    public Long getEstimatedCheckinTimeTo() {
        return this.estimatedCheckinTimeTo;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public List<RentClearTimeVo> getOptionalCleaningDates() {
        return this.optionalCleaningDates;
    }

    public List<PaymentMethodsBean> getPaymentMethods() {
        return this.paymentMethods;
    }

    public int getRentDurationType() {
        return this.rentDurationType;
    }

    public String getRentDurationTypeDesc() {
        return this.rentDurationTypeDesc;
    }

    public String getRentDurationTypeName() {
        return this.rentDurationTypeName;
    }

    public String getRentTerm() {
        return this.rentTerm;
    }

    public Long getRentTermEarliestTo() {
        return this.rentTermEarliestTo;
    }

    public Long getRentTermFrom() {
        return this.rentTermFrom;
    }

    public Long getRentTermLatestTo() {
        return this.rentTermLatestTo;
    }

    public Long getRentTermTo() {
        return this.rentTermTo;
    }

    public boolean isCheckinCleaningDateFlag() {
        return this.checkinCleaningDateFlag;
    }

    public boolean isShortRentSupport() {
        return this.isShortRentSupport;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAssetKey(String str) {
        this.assetKey = str;
    }

    public void setCheckinCleaningDateFlag(boolean z) {
        this.checkinCleaningDateFlag = z;
    }

    public void setContractPaymentMethod(int i2) {
        this.contractPaymentMethod = i2;
    }

    public void setContractPaymentMethodName(String str) {
        this.contractPaymentMethodName = str;
    }

    public void setDepositType(int i2) {
        this.depositType = i2;
    }

    public void setDepositTypeName(String str) {
        this.depositTypeName = str;
    }

    public void setEstimatedCheckinTimeFrom(Long l) {
        this.estimatedCheckinTimeFrom = l;
    }

    public void setEstimatedCheckinTimeTo(Long l) {
        this.estimatedCheckinTimeTo = l;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setOptionalCleaningDates(List<RentClearTimeVo> list) {
        this.optionalCleaningDates = list;
    }

    public void setPaymentMethods(List<PaymentMethodsBean> list) {
        this.paymentMethods = list;
    }

    public void setRentDurationType(int i2) {
        this.rentDurationType = i2;
    }

    public void setRentDurationTypeDesc(String str) {
        this.rentDurationTypeDesc = str;
    }

    public void setRentDurationTypeName(String str) {
        this.rentDurationTypeName = str;
    }

    public void setRentTerm(String str) {
        this.rentTerm = str;
    }

    public void setRentTermEarliestTo(Long l) {
        this.rentTermEarliestTo = l;
    }

    public void setRentTermFrom(Long l) {
        this.rentTermFrom = l;
    }

    public void setRentTermLatestTo(Long l) {
        this.rentTermLatestTo = l;
    }

    public void setRentTermTo(Long l) {
        this.rentTermTo = l;
    }

    public void setShortRentSupport(boolean z) {
        this.isShortRentSupport = z;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
