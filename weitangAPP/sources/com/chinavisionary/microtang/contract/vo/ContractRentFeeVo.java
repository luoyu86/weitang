package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ContractRentFeeVo extends BaseVo {
    private String body;
    private List<FeesBean> fees;

    public static class FeesBean extends BaseVo {
        private String amount;
        private int feeType;
        private String feeTypeName;

        public String getAmount() {
            return this.amount;
        }

        public int getFeeType() {
            return this.feeType;
        }

        public String getFeeTypeName() {
            return this.feeTypeName;
        }

        public void setAmount(String str) {
            this.amount = str;
        }

        public void setFeeType(int i2) {
            this.feeType = i2;
        }

        public void setFeeTypeName(String str) {
            this.feeTypeName = str;
        }
    }

    public String getBody() {
        return this.body;
    }

    public List<FeesBean> getFees() {
        return this.fees;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setFees(List<FeesBean> list) {
        this.fees = list;
    }
}
