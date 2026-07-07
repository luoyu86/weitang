package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ResponseContractVo extends BaseVo {
    private List<ContractVo> rows;
    private int totalSize;

    public List<ContractVo> getRows() {
        return this.rows;
    }

    public int getTotalSize() {
        return this.totalSize;
    }

    public void setRows(List<ContractVo> list) {
        this.rows = list;
    }

    public void setTotalSize(int i2) {
        this.totalSize = i2;
    }
}
