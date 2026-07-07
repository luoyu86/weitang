package com.chinavisionary.microtang.merchant.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;

/* JADX INFO: loaded from: classes.dex */
public class MerchantDetailsVo extends BaseVo {
    private String address;
    private ResourceVo cover;
    private String description;
    private ResourceVo logo;
    private String merchantKey;
    private String merchantName;
    private Integer merchantOpeningStatus;
    private String merchantOpeningStatusName;
    private String notice;
    private String phone;
    private QualificationsBean qualifications;

    public static class QualificationsBean extends BaseVo {
        private ResourceVo foodLicence;
        private ResourceVo licence;
        private String name;
        private String phone;

        public ResourceVo getFoodLicence() {
            return this.foodLicence;
        }

        public ResourceVo getLicence() {
            return this.licence;
        }

        public String getName() {
            return this.name;
        }

        public String getPhone() {
            return this.phone;
        }

        public void setFoodLicence(ResourceVo resourceVo) {
            this.foodLicence = resourceVo;
        }

        public void setLicence(ResourceVo resourceVo) {
            this.licence = resourceVo;
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

    public ResourceVo getCover() {
        return this.cover;
    }

    public String getDescription() {
        return this.description;
    }

    public ResourceVo getLogo() {
        return this.logo;
    }

    public String getMerchantKey() {
        return this.merchantKey;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public Integer getMerchantOpeningStatus() {
        return this.merchantOpeningStatus;
    }

    public String getMerchantOpeningStatusName() {
        return this.merchantOpeningStatusName;
    }

    public String getNotice() {
        return this.notice;
    }

    public String getPhone() {
        return this.phone;
    }

    public QualificationsBean getQualifications() {
        return this.qualifications;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setCover(ResourceVo resourceVo) {
        this.cover = resourceVo;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setLogo(ResourceVo resourceVo) {
        this.logo = resourceVo;
    }

    public void setMerchantKey(String str) {
        this.merchantKey = str;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public void setMerchantOpeningStatus(Integer num) {
        this.merchantOpeningStatus = num;
    }

    public void setMerchantOpeningStatusName(String str) {
        this.merchantOpeningStatusName = str;
    }

    public void setNotice(String str) {
        this.notice = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setQualifications(QualificationsBean qualificationsBean) {
        this.qualifications = qualificationsBean;
    }
}
