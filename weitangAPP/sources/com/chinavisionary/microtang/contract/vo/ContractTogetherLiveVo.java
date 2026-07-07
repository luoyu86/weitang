package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;

/* JADX INFO: loaded from: classes.dex */
public class ContractTogetherLiveVo extends BaseVo {
    private String cardType;
    private String idCardBack;
    private ResourceVo idCardBackResourceVo;
    private String idCardFront;
    private ResourceVo idCardFrontResourceVo;
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

    public ResourceVo getIdCardBackResourceVo() {
        return this.idCardBackResourceVo;
    }

    public String getIdCardFront() {
        return this.idCardFront;
    }

    public ResourceVo getIdCardFrontResourceVo() {
        return this.idCardFrontResourceVo;
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

    public void setIdCardBackResourceVo(ResourceVo resourceVo) {
        this.idCardBackResourceVo = resourceVo;
    }

    public void setIdCardFront(String str) {
        this.idCardFront = str;
    }

    public void setIdCardFrontResourceVo(ResourceVo resourceVo) {
        this.idCardFrontResourceVo = resourceVo;
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
