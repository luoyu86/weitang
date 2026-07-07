package com.chinavisionary.microtang.me.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.contract.vo.ContractListVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class CleanProductVo extends BaseVo {
    private ResourceVo cover;
    private ContractListVo mContractListVo;
    private String name;
    private BigDecimal price;
    private String remark;
    private int type;
    private BigDecimal underlinePrice;
    private String valueaddedKey;

    public ContractListVo getContractListVo() {
        return this.mContractListVo;
    }

    public ResourceVo getCover() {
        return this.cover;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getRemark() {
        return this.remark;
    }

    public int getType() {
        return this.type;
    }

    public BigDecimal getUnderlinePrice() {
        return this.underlinePrice;
    }

    public String getValueaddedKey() {
        return this.valueaddedKey;
    }

    public void setContractListVo(ContractListVo contractListVo) {
        this.mContractListVo = contractListVo;
    }

    public void setCover(ResourceVo resourceVo) {
        this.cover = resourceVo;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPrice(BigDecimal bigDecimal) {
        this.price = bigDecimal;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setUnderlinePrice(BigDecimal bigDecimal) {
        this.underlinePrice = bigDecimal;
    }

    public void setValueaddedKey(String str) {
        this.valueaddedKey = str;
    }
}
