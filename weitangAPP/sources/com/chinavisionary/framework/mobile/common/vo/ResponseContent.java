package com.chinavisionary.framework.mobile.common.vo;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ResponseContent<T> {
    private Map<String, Object> bundle;
    private String code;
    private T data;
    private String message;
    private boolean success;

    public Map<String, Object> getBundle() {
        return this.bundle;
    }

    public String getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setBundle(Map<String, Object> map) {
        this.bundle = map;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public String toString() {
        return "ResponseContent{success=" + this.success + ", code='" + this.code + "', message='" + this.message + "', data=" + this.data + ", bundle=" + this.bundle + '}';
    }
}
