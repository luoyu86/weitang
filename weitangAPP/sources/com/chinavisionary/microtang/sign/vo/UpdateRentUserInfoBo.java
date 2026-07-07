package com.chinavisionary.microtang.sign.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateRentUserInfoBo extends BaseVo {
    private List<RentUserInfoBo> param;

    public static class RentUserInfoBo extends BaseVo {
        private String contactName;
        private String contactPhone;
        private String relationship;
        private String userAddress;

        public String getContactName() {
            return this.contactName;
        }

        public String getContactPhone() {
            return this.contactPhone;
        }

        public String getRelationship() {
            return this.relationship;
        }

        public String getUserAddress() {
            return this.userAddress;
        }

        public void setContactName(String str) {
            this.contactName = str;
        }

        public void setContactPhone(String str) {
            this.contactPhone = str;
        }

        public void setRelationship(String str) {
            this.relationship = str;
        }

        public void setUserAddress(String str) {
            this.userAddress = str;
        }
    }

    public List<RentUserInfoBo> getParam() {
        return this.param;
    }

    public void setParam(List<RentUserInfoBo> list) {
        this.param = list;
    }
}
