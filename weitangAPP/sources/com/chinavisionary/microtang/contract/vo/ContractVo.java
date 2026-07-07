package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ContractVo extends BaseVo {
    public static final int CANCEL_PAY_CONTACT = 12;
    public static final int EFFECTUATED = 2;
    public static final int END_RENT = 15;
    public static final int OVER = 1;
    public static final int WAIT_PAY_CONTACT = 11;
    public static final int WAIT_SIGN_CONTRACT_RENT = 16;
    private String contractCode;
    private Long rentEnd;
    private String rentKey;
    private Long rentStart;
    private Integer rentStatus;
    private String rentStatusName;
    private Integer roommateNum;
    private Integer status;
    private String statusName;

    public String getContractCode() {
        return this.contractCode;
    }

    public Long getRentEnd() {
        return this.rentEnd;
    }

    public String getRentKey() {
        return this.rentKey;
    }

    public Long getRentStart() {
        return this.rentStart;
    }

    public Integer getRentStatus() {
        return this.rentStatus;
    }

    public String getRentStatusName() {
        return this.rentStatusName;
    }

    public Integer getRoommateNum() {
        return this.roommateNum;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getStatusName() {
        return this.statusName;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setRentEnd(Long l) {
        this.rentEnd = l;
    }

    public void setRentKey(String str) {
        this.rentKey = str;
    }

    public void setRentStart(Long l) {
        this.rentStart = l;
    }

    public void setRentStatus(Integer num) {
        this.rentStatus = num;
    }

    public void setRentStatusName(String str) {
        this.rentStatusName = str;
    }

    public void setRoommateNum(Integer num) {
        this.roommateNum = num;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public void setStatusName(String str) {
        this.statusName = str;
    }
}
