package com.chinavisionary.microtang.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class AppTempCacheVo<T> extends BaseVo {
    private Long cacheCreateTime;
    private T cacheDataObj;
    private String cacheKey;

    public Long getCacheCreateTime() {
        return this.cacheCreateTime;
    }

    public T getCacheDataObj() {
        return this.cacheDataObj;
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    public void setCacheCreateTime(Long l) {
        this.cacheCreateTime = l;
    }

    public void setCacheDataObj(T t) {
        this.cacheDataObj = t;
    }

    public void setCacheKey(String str) {
        this.cacheKey = str;
    }
}
