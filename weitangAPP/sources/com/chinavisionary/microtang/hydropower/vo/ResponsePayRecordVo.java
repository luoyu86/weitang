package com.chinavisionary.microtang.hydropower.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ResponsePayRecordVo extends BaseVo {
    private List<PayRecordVo> rows;
    private int totalSize;

    public List<PayRecordVo> getRows() {
        return this.rows;
    }

    public int getTotalSize() {
        return this.totalSize;
    }

    public void setRows(List<PayRecordVo> list) {
        this.rows = list;
    }

    public void setTotalSize(int i2) {
        this.totalSize = i2;
    }
}
