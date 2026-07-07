package cn.admobiletop.adsuyi.exception;

import cn.admobiletop.adsuyi.ad.error.ADSuyiError;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiException extends RuntimeException {
    public ADSuyiException(ADSuyiError aDSuyiError) {
        super(aDSuyiError.toString());
    }
}
