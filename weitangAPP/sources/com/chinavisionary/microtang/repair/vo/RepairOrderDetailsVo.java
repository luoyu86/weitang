package com.chinavisionary.microtang.repair.vo;

import c.k.b.a;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RepairOrderDetailsVo extends BaseVo {
    private List<a> imageInfo;
    private String key;
    private String title;

    public List<a> getImageInfo() {
        return this.imageInfo;
    }

    public String getKey() {
        return this.key;
    }

    public String getTitle() {
        return this.title;
    }

    public void setImageInfo(List<a> list) {
        this.imageInfo = list;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
