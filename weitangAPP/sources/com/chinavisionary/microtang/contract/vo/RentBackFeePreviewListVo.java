package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RentBackFeePreviewListVo extends BaseVo {
    private List<RentBackExpensesVo> expensesIncurreds;
    private List<ReceivableFeeVo> receivables;
    private BigDecimal refundTotalAmount;
    private List<RefundVo> refunds;

    public static class ReceivableFeeVo extends BaseVo {
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

    public static class RefundVo extends BaseVo {
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

    public static class RentBackExpensesVo extends BaseVo {
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

    public List<RentBackExpensesVo> getExpensesIncurreds() {
        return this.expensesIncurreds;
    }

    public List<ReceivableFeeVo> getReceivables() {
        return this.receivables;
    }

    public BigDecimal getRefundTotalAmount() {
        return this.refundTotalAmount;
    }

    public List<RefundVo> getRefunds() {
        return this.refunds;
    }

    public void setExpensesIncurreds(List<RentBackExpensesVo> list) {
        this.expensesIncurreds = list;
    }

    public void setReceivables(List<ReceivableFeeVo> list) {
        this.receivables = list;
    }

    public void setRefundTotalAmount(BigDecimal bigDecimal) {
        this.refundTotalAmount = bigDecimal;
    }

    public void setRefunds(List<RefundVo> list) {
        this.refunds = list;
    }
}
