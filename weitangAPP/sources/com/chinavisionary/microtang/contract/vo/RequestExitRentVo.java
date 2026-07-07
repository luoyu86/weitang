package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RequestExitRentVo extends BaseVo {
    private String bankAccount;
    private String bankName;
    private String contractKey;
    private String otherReason;
    private long rentBackDate;
    private List<String> rentBackTagKeys;

    public String getBankAccount() {
        return this.bankAccount;
    }

    public String getBankName() {
        return this.bankName;
    }

    public String getContractKey() {
        return this.contractKey;
    }

    public String getOtherReason() {
        return this.otherReason;
    }

    public long getRentBackDate() {
        return this.rentBackDate;
    }

    public List<String> getRentBackTagKeys() {
        return this.rentBackTagKeys;
    }

    public void setBankAccount(String str) {
        this.bankAccount = str;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public void setContractKey(String str) {
        this.contractKey = str;
    }

    public void setOtherReason(String str) {
        this.otherReason = str;
    }

    public void setRentBackDate(long j) {
        this.rentBackDate = j;
    }

    public void setRentBackTagKeys(List<String> list) {
        this.rentBackTagKeys = list;
    }
}
