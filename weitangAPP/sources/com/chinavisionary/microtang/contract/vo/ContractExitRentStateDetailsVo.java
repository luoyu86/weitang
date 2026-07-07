package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ContractExitRentStateDetailsVo extends BaseVo {
    public static final int EXIT_RENT_STATE_APPLE = 1;
    public static final int EXIT_RENT_STATE_CANCEL = 3;
    public static final int EXIT_RENT_STATE_CONFIRM = 4;
    public static final int EXIT_RENT_STATE_HANDLE = 2;
    public static final int EXIT_RENT_STATE_OVER = 5;
    private String address;
    private String bankAccount;
    private String bankName;
    private String cardNo;
    private String cardType;
    private String contractKey;
    private List<ExpensesIncurredsBean> expensesIncurreds;
    private String key;
    private String message;
    private List<ReceivablesBean> receivables;
    private int refundStatus;
    private String refundStatusName;
    private BigDecimal refundTotalAmount;
    private List<RefundsBean> refunds;
    private Long rentBackApplyDate;
    private Long rentBackDate;
    private String rentBackKey;
    private int rentBackStatus;
    private String rentBackStatusName;
    private String rentbackRemind;
    private String signUserName;
    private String signUserPhone;
    private boolean success;

    public static class ExpensesIncurredsBean extends BaseVo {
        private BigDecimal expensesIncurredAmount;
        private String expensesIncurredName;

        public BigDecimal getExpensesIncurredAmount() {
            return this.expensesIncurredAmount;
        }

        public String getExpensesIncurredName() {
            return this.expensesIncurredName;
        }

        public void setExpensesIncurredAmount(BigDecimal bigDecimal) {
            this.expensesIncurredAmount = bigDecimal;
        }

        public void setExpensesIncurredName(String str) {
            this.expensesIncurredName = str;
        }
    }

    public static class ReceivablesBean extends BaseVo {
        private BigDecimal receivablesAmount;
        private String receivablesName;

        public BigDecimal getReceivablesAmount() {
            return this.receivablesAmount;
        }

        public String getReceivablesName() {
            return this.receivablesName;
        }

        public void setReceivablesAmount(BigDecimal bigDecimal) {
            this.receivablesAmount = bigDecimal;
        }

        public void setReceivablesName(String str) {
            this.receivablesName = str;
        }
    }

    public static class RefundsBean extends BaseVo {
        private BigDecimal refundAmount;
        private String refundName;

        public BigDecimal getRefundAmount() {
            return this.refundAmount;
        }

        public String getRefundName() {
            return this.refundName;
        }

        public void setRefundAmount(BigDecimal bigDecimal) {
            this.refundAmount = bigDecimal;
        }

        public void setRefundName(String str) {
            this.refundName = str;
        }
    }

    public String getAddress() {
        return this.address;
    }

    public String getBankAccount() {
        return this.bankAccount;
    }

    public String getBankName() {
        return this.bankName;
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public String getCardType() {
        return this.cardType;
    }

    public String getContractKey() {
        return this.contractKey;
    }

    public List<ExpensesIncurredsBean> getExpensesIncurreds() {
        return this.expensesIncurreds;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public List<ReceivablesBean> getReceivables() {
        return this.receivables;
    }

    public int getRefundStatus() {
        return this.refundStatus;
    }

    public String getRefundStatusName() {
        return this.refundStatusName;
    }

    public BigDecimal getRefundTotalAmount() {
        return this.refundTotalAmount;
    }

    public List<RefundsBean> getRefunds() {
        return this.refunds;
    }

    public Long getRentBackApplyDate() {
        return this.rentBackApplyDate;
    }

    public Long getRentBackDate() {
        return this.rentBackDate;
    }

    public String getRentBackKey() {
        return this.rentBackKey;
    }

    public int getRentBackStatus() {
        return this.rentBackStatus;
    }

    public String getRentBackStatusName() {
        return this.rentBackStatusName;
    }

    public String getRentbackRemind() {
        return this.rentbackRemind;
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

    public void setBankAccount(String str) {
        this.bankAccount = str;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public void setCardNo(String str) {
        this.cardNo = str;
    }

    public void setCardType(String str) {
        this.cardType = str;
    }

    public void setContractKey(String str) {
        this.contractKey = str;
    }

    public void setExpensesIncurreds(List<ExpensesIncurredsBean> list) {
        this.expensesIncurreds = list;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setReceivables(List<ReceivablesBean> list) {
        this.receivables = list;
    }

    public void setRefundStatus(int i2) {
        this.refundStatus = i2;
    }

    public void setRefundStatusName(String str) {
        this.refundStatusName = str;
    }

    public void setRefundTotalAmount(BigDecimal bigDecimal) {
        this.refundTotalAmount = bigDecimal;
    }

    public void setRefunds(List<RefundsBean> list) {
        this.refunds = list;
    }

    public void setRentBackApplyDate(Long l) {
        this.rentBackApplyDate = l;
    }

    public void setRentBackDate(Long l) {
        this.rentBackDate = l;
    }

    public void setRentBackKey(String str) {
        this.rentBackKey = str;
    }

    public void setRentBackStatus(int i2) {
        this.rentBackStatus = i2;
    }

    public void setRentBackStatusName(String str) {
        this.rentBackStatusName = str;
    }

    public void setRentbackRemind(String str) {
        this.rentbackRemind = str;
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
