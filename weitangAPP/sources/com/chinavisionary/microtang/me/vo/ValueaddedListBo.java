package com.chinavisionary.microtang.me.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ValueaddedListBo extends BaseVo {
    private String goodsCategoryStr;
    private String key;
    private List<CleanProductVo> list;

    public String getGoodsCategoryStr() {
        return this.goodsCategoryStr;
    }

    public String getKey() {
        return this.key;
    }

    public List<CleanProductVo> getList() {
        return this.list;
    }

    public void setGoodsCategoryStr(String str) {
        this.goodsCategoryStr = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setList(List<CleanProductVo> list) {
        this.list = list;
    }
}
