package com.chinavisionary.microtang.main.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.room.vo.ProductDetailsVo;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BannerDataVo extends BaseVo {
    private Map<String, List<ResourceVo>> tagResourceMap;
    private List<ProductDetailsVo.BannersBean> tags;

    public Map<String, List<ResourceVo>> getTagResourceMap() {
        return this.tagResourceMap;
    }

    public List<ProductDetailsVo.BannersBean> getTags() {
        return this.tags;
    }

    public void setTagResourceMap(Map<String, List<ResourceVo>> map) {
        this.tagResourceMap = map;
    }

    public void setTags(List<ProductDetailsVo.BannersBean> list) {
        this.tags = list;
    }
}
