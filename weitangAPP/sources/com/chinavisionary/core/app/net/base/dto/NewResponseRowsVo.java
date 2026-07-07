package com.chinavisionary.core.app.net.base.dto;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NewResponseRowsVo<T> extends NewBaseVo {
    private String key;
    private List<T> rows;
    private int total;

    public String getKey() {
        return this.key;
    }

    public List<T> getRows() {
        return this.rows;
    }

    public boolean getSuccess() {
        return isSuccess();
    }

    public int getTotal() {
        return this.total;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setRows(List<T> list) {
        this.rows = list;
    }

    public void setTotal(int i2) {
        this.total = i2;
    }
}
