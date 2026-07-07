package com.chinavisionary.microtang.repair.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseVo<T> extends BaseVo {
    private String key;
    private String message;
    private List<T> rows;
    private boolean success;
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

    public int getTotal() {
        return this.total;
    }

    public boolean isSuccess() {
        return this.success;
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
