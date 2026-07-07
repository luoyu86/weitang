package com.intelligoo.sdk.exception;

import com.intelligoo.sdk.c.a;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class BleException implements Serializable {
    private a code;
    private String description;

    public BleException(a aVar, String str) {
        this.code = aVar;
        this.description = str;
    }

    public a getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public BleException setCode(a aVar) {
        this.code = aVar;
        return this;
    }

    public BleException setDescription(String str) {
        this.description = str;
        return this;
    }

    public String toString() {
        return "BleException{code=" + this.code + ", description='" + this.description + "'}";
    }
}
