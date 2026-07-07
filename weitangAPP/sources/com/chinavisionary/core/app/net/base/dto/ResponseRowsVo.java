package com.chinavisionary.core.app.net.base.dto;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ResponseRowsVo<T> extends BaseVo {
    private String key;
    private String message;
    private List<T> rows;
    private boolean success = false;
    private int total;

    public String getKey() {
        return this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public List<T> getRows() {
        return this.rows;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public int getTotal() {
        return this.total;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setRows(List<T> list) {
        this.rows = list;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public void setTotal(int i2) {
        this.total = i2;
    }
}
