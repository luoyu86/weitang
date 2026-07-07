package com.chinavisionary.core.app.net.base.dto;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ResponseUploadImgListVo extends BaseVo {
    private List<ResponseUploadImgVo> rows;
    private int total;

    public List<ResponseUploadImgVo> getRows() {
        return this.rows;
    }

    public int getTotal() {
        return this.total;
    }

    public void setRows(List<ResponseUploadImgVo> list) {
        this.rows = list;
    }

    public void setTotal(int i2) {
        this.total = i2;
    }
}
