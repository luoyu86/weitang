package com.chinavisionary.microtang.db.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class CacheVo extends BaseVo {
    public static final String ACTIVITY_BANNER_CACHE_KEY = "activity_banner_cache";
    public static final String CITY_CACHE_KEY = "city_list_cache";
    public static final String LIFE_BANNER_CACHE_KEY = "life_banner_cache";
    public static final String ME_BANNER_CACHE_KEY = "me_banner_cache";
    public static final String PROJECT_CACHE_KEY = "project_list_cache";
    public static final String ROOM_BANNER_CACHE_KEY = "room_banner_cache";
    public static final String ROOM_CACHE_KEY = "room_source_cache";
    public static final String WT_ACTIVITY_CACHE_KEY = "wt_activity_list_cache";
    public static final String WT_CLEAN_CACHE_KEY = "wt_clean_list_cache";
    public static final String WT_FOOD_CACHE_KEY = "wt_food_list_cache";
    public static final String WT_LIEF_CACHE_KEY = "wt_life_list_cache";
    private String cacheKey;
    private String cacheValue;

    public String getCacheKey() {
        return this.cacheKey;
    }

    public String getCacheValue() {
        return this.cacheValue;
    }

    public void setCacheKey(String str) {
        this.cacheKey = str;
    }

    public void setCacheValue(String str) {
        this.cacheValue = str;
    }
}
