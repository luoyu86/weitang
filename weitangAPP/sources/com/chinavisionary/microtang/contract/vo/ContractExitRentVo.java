package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.microtang.contract.vo.ExitRentVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ContractExitRentVo extends BaseVo {
    private String address;
    private String cardNo;
    private String cardType;
    private String key;
    private String message;
    private Long rentBackApplyDate;
    private Long rentBackDate;
    private List<ExitRentVo.ExitRentTag> rentBackTags;
    private Long rentEndDate;
    private String signUserName;
    private String signUserPhone;
    private boolean success;

    public String getAddress() {
        return this.address;
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public String getCardType() {
        return this.cardType;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public Long getRentBackApplyDate() {
        return this.rentBackApplyDate;
    }

    public Long getRentBackDate() {
        return this.rentBackDate;
    }

    public List<ExitRentVo.ExitRentTag> getRentBackTags() {
        return this.rentBackTags;
    }

    public Long getRentEndDate() {
        return this.rentEndDate;
    }

    public String getSignUserName() {
        return this.signUserName;
    }

    public String getSignUserPhone() {
        return this.signUserPhone;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setCardNo(String str) {
        this.cardNo = str;
    }

    public void setCardType(String str) {
        this.cardType = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setRentBackApplyDate(Long l) {
        this.rentBackApplyDate = l;
    }

    public void setRentBackDate(Long l) {
        this.rentBackDate = l;
    }

    public void setRentBackTags(List<ExitRentVo.ExitRentTag> list) {
        this.rentBackTags = list;
    }

    public void setRentEndDate(Long l) {
        this.rentEndDate = l;
    }

    public void setSignUserName(String str) {
        this.signUserName = str;
    }

    public void setSignUserPhone(String str) {
        this.signUserPhone = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
