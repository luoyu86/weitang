package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class ContractListDetailsVo extends BaseVo {
    public static final int WAIT_CONFIRM_RECOGNITION = 1;
    private String assetAddress;
    private String assetKey;
    private int assetRecognitionStatus;
    private String assetRecognitionStatusName;
    private boolean changeRentFlag;
    private Long checkinCleaningDate;
    private String contractCode;
    private String contractDownloadUrl;
    private String contractKey;
    private int contractStatus;
    private String contractStatusName;
    private String contractViewUrl;
    private Long estimatedCheckinTime;
    private boolean hasRoommate;
    private String idCardNo;
    private String idCardType;
    private String key;
    private String message;
    private String paymentMethodName;
    private String phone;
    private boolean renewalFlag;
    private boolean rentBackFlag;
    private boolean rentBackInfoFlag = false;
    private BigDecimal rentFee;
    private Long rentTermFrom;
    private Long rentTermTo;
    private String signingCode;
    private String signingUserAddress;
    private String signingUserKey;
    private String signingUserName;
    private boolean success;

    public String getAssetAddress() {
        return this.assetAddress;
    }

    public String getAssetKey() {
        return this.assetKey;
    }

    public int getAssetRecognitionStatus() {
        return this.assetRecognitionStatus;
    }

    public String getAssetRecognitionStatusName() {
        return this.assetRecognitionStatusName;
    }

    public Long getCheckinCleaningDate() {
        return this.checkinCleaningDate;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractDownloadUrl() {
        return this.contractDownloadUrl;
    }

    public String getContractKey() {
        return this.contractKey;
    }

    public int getContractStatus() {
        return this.contractStatus;
    }

    public String getContractStatusName() {
        return this.contractStatusName;
    }

    public String getContractViewUrl() {
        return this.contractViewUrl;
    }

    public Long getEstimatedCheckinTime() {
        return this.estimatedCheckinTime;
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

    public String getMessage() {
        return this.message;
    }

    public String getPaymentMethodName() {
        return this.paymentMethodName;
    }

    public String getPhone() {
        return this.phone;
    }

    public BigDecimal getRentFee() {
        return this.rentFee;
    }

    public Long getRentTermFrom() {
        return this.rentTermFrom;
    }

    public Long getRentTermTo() {
        return this.rentTermTo;
    }

    public String getSigningCode() {
        return this.signingCode;
    }

    public String getSigningUserAddress() {
        return this.signingUserAddress;
    }

    public String getSigningUserKey() {
        return this.signingUserKey;
    }

    public String getSigningUserName() {
        return this.signingUserName;
    }

    public boolean isChangeRentFlag() {
        return this.changeRentFlag;
    }

    public boolean isHasRoommate() {
        return this.hasRoommate;
    }

    public boolean isRenewalFlag() {
        return this.renewalFlag;
    }

    public boolean isRentBackFlag() {
        return this.rentBackFlag;
    }

    public boolean isRentBackInfoFlag() {
        return this.rentBackInfoFlag;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setAssetAddress(String str) {
        this.assetAddress = str;
    }

    public void setAssetKey(String str) {
        this.assetKey = str;
    }

    public void setAssetRecognitionStatus(int i2) {
        this.assetRecognitionStatus = i2;
    }

    public void setAssetRecognitionStatusName(String str) {
        this.assetRecognitionStatusName = str;
    }

    public void setChangeRentFlag(boolean z) {
        this.changeRentFlag = z;
    }

    public void setCheckinCleaningDate(Long l) {
        this.checkinCleaningDate = l;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractDownloadUrl(String str) {
        this.contractDownloadUrl = str;
    }

    public void setContractKey(String str) {
        this.contractKey = str;
    }

    public void setContractStatus(int i2) {
        this.contractStatus = i2;
    }

    public void setContractStatusName(String str) {
        this.contractStatusName = str;
    }

    public void setContractViewUrl(String str) {
        this.contractViewUrl = str;
    }

    public void setEstimatedCheckinTime(Long l) {
        this.estimatedCheckinTime = l;
    }

    public void setHasRoommate(boolean z) {
        this.hasRoommate = z;
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

    public void setMessage(String str) {
        this.message = str;
    }

    public void setPaymentMethodName(String str) {
        this.paymentMethodName = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setRenewalFlag(boolean z) {
        this.renewalFlag = z;
    }

    public void setRentBackFlag(boolean z) {
        this.rentBackFlag = z;
    }

    public void setRentBackInfoFlag(boolean z) {
        this.rentBackInfoFlag = z;
    }

    public void setRentFee(BigDecimal bigDecimal) {
        this.rentFee = bigDecimal;
    }

    public void setRentTermFrom(Long l) {
        this.rentTermFrom = l;
    }

    public void setRentTermTo(Long l) {
        this.rentTermTo = l;
    }

    public void setSigningCode(String str) {
        this.signingCode = str;
    }

    public void setSigningUserAddress(String str) {
        this.signingUserAddress = str;
    }

    public void setSigningUserKey(String str) {
        this.signingUserKey = str;
    }

    public void setSigningUserName(String str) {
        this.signingUserName = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
