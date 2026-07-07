package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class UpdateTogetherVo extends BaseVo {
    private List<ContractRoommateParamsBean> contractRoommateParams;
    private String rentKey;

    public static class ContractRoommateParamsBean extends BaseVo {
        private String cardType;
        private String idCardBackKey;
        private String idCardFrontKey;
        private String idCardNo;
        private String name;
        private String phone;

        public String getCardType() {
            return this.cardType;
        }

        public String getIdCardBackKey() {
            return this.idCardBackKey;
        }

        public String getIdCardFrontKey() {
            return this.idCardFrontKey;
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

        public void setCardType(String str) {
            this.cardType = str;
        }

        public void setIdCardBackKey(String str) {
            this.idCardBackKey = str;
        }

        public void setIdCardFrontKey(String str) {
            this.idCardFrontKey = str;
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
    }

    public List<ContractRoommateParamsBean> getContractRoommateParams() {
        return this.contractRoommateParams;
    }

    public String getRentKey() {
        return this.rentKey;
    }

    public void setContractRoommateParams(List<ContractRoommateParamsBean> list) {
        this.contractRoommateParams = list;
    }

    public void setRentKey(String str) {
        this.rentKey = str;
    }
}
