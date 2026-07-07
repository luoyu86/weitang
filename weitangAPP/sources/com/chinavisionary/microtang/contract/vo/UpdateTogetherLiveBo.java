package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class UpdateTogetherLiveBo extends BaseVo {
    private String contractKey;
    private List<RoommatesBean> roommates;

    public static class RoommatesBean extends BaseVo {
        private String idCardBack;
        private String idCardFront;
        private String idCardNo;
        private String idCardType;
        private String name;
        private String phone;

        public String getIdCardBack() {
            return this.idCardBack;
        }

        public String getIdCardFront() {
            return this.idCardFront;
        }

        public String getIdCardNo() {
            return this.idCardNo;
        }

        public String getIdCardType() {
            return this.idCardType;
        }

        public String getName() {
            return this.name;
        }

        public String getPhone() {
            return this.phone;
        }

        public void setIdCardBack(String str) {
            this.idCardBack = str;
        }

        public void setIdCardFront(String str) {
            this.idCardFront = str;
        }

        public void setIdCardNo(String str) {
            this.idCardNo = str;
        }

        public void setIdCardType(String str) {
            this.idCardType = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPhone(String str) {
            this.phone = str;
        }
    }

    public String getContractKey() {
        return this.contractKey;
    }

    public List<RoommatesBean> getRoommates() {
        return this.roommates;
    }

    public void setContractKey(String str) {
        this.contractKey = str;
    }

    public void setRoommates(List<RoommatesBean> list) {
        this.roommates = list;
    }
}
