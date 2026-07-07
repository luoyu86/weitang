package com.chinavisionary.microtang.me.vo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import com.chinavisionary.microtang.bill.vo.BillDetailsVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WalletRecordDetailsVo extends NewBaseVo {
    private BigDecimal amount;
    private String body;
    private List<BillDetailsVo.DetailsVo> detailList;
    private String key;

    public BigDecimal getAmount() {
        return this.amount;
    }

    public String getBody() {
        return this.body;
    }

    public List<BillDetailsVo.DetailsVo> getDetailList() {
        return this.detailList;
    }

    public String getKey() {
        return this.key;
    }

    public void setAmount(BigDecimal bigDecimal) {
        this.amount = bigDecimal;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setDetailList(List<BillDetailsVo.DetailsVo> list) {
        this.detailList = list;
    }

    public void setKey(String str) {
        this.key = str;
    }
}
