package com.chinavisionary.microtang.me.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class UpdateUserIdBo extends BaseVo {
    private String address;
    private String company;
    private String companyAddress;
    private int education;
    private String idNo;
    private int marriage;
    private String name;
    private int political;

    public String getAddress() {
        return this.address;
    }

    public String getCompany() {
        return this.company;
    }

    public String getCompanyAddress() {
        return this.companyAddress;
    }

    public int getEducation() {
        return this.education;
    }

    public String getIdNo() {
        return this.idNo;
    }

    public int getMarriage() {
        return this.marriage;
    }

    public String getName() {
        return this.name;
    }

    public int getPolitical() {
        return this.political;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setCompany(String str) {
        this.company = str;
    }

    public void setCompanyAddress(String str) {
        this.companyAddress = str;
    }

    public void setEducation(int i2) {
        this.education = i2;
    }

    public void setIdNo(String str) {
        this.idNo = str;
    }

    public void setMarriage(int i2) {
        this.marriage = i2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPolitical(int i2) {
        this.political = i2;
    }
}
