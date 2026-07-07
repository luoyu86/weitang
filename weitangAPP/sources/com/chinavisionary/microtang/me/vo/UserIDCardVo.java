package com.chinavisionary.microtang.me.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;

/* JADX INFO: loaded from: classes.dex */
public class UserIDCardVo extends BaseVo {
    private String address;
    private String cardNo;
    private String cardType;
    private String company;
    private String companyAddress;
    private String education;
    private ResourceVo idCardBackKeyResourceVo;
    private ResourceVo idCardFrontResourceVo;
    private boolean isValidate;
    private String marriage;
    private int marriageVal;
    private String nation;
    private String personName;
    private ResourceVo personResourceVo;
    private String phone;
    private String political;
    private String userKey;

    public String getAddress() {
        return this.address;
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public String getCardType() {
        return this.cardType;
    }

    public String getCompany() {
        return this.company;
    }

    public String getCompanyAddress() {
        return this.companyAddress;
    }

    public String getEducation() {
        return this.education;
    }

    public ResourceVo getIdCardBackKeyResourceVo() {
        return this.idCardBackKeyResourceVo;
    }

    public ResourceVo getIdCardFrontResourceVo() {
        return this.idCardFrontResourceVo;
    }

    public String getMarriage() {
        return this.marriage;
    }

    public int getMarriageVal() {
        return this.marriageVal;
    }

    public String getNation() {
        return this.nation;
    }

    public String getPersonName() {
        return this.personName;
    }

    public ResourceVo getPersonResourceVo() {
        return this.personResourceVo;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getPolitical() {
        return this.political;
    }

    public String getUserKey() {
        return this.userKey;
    }

    public boolean isValidate() {
        return this.isValidate;
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

    public void setCompany(String str) {
        this.company = str;
    }

    public void setCompanyAddress(String str) {
        this.companyAddress = str;
    }

    public void setEducation(String str) {
        this.education = str;
    }

    public void setIdCardBackKeyResourceVo(ResourceVo resourceVo) {
        this.idCardBackKeyResourceVo = resourceVo;
    }

    public void setIdCardFrontResourceVo(ResourceVo resourceVo) {
        this.idCardFrontResourceVo = resourceVo;
    }

    public void setMarriage(String str) {
        this.marriage = str;
    }

    public void setMarriageVal(int i2) {
        this.marriageVal = i2;
    }

    public void setNation(String str) {
        this.nation = str;
    }

    public void setPersonName(String str) {
        this.personName = str;
    }

    public void setPersonResourceVo(ResourceVo resourceVo) {
        this.personResourceVo = resourceVo;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setPolitical(String str) {
        this.political = str;
    }

    public void setUserKey(String str) {
        this.userKey = str;
    }

    public void setValidate(boolean z) {
        this.isValidate = z;
    }
}
