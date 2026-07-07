package com.chinavisionary.microtang.me.vo;

import c.e.a.d.x;
import c.f.b.a;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WorkAddressVo extends BaseVo implements a {
    private List<WorkAddressVo> children;
    private boolean leaf;
    private String tagKey;
    private String tagName;

    public List<WorkAddressVo> getChildren() {
        return this.children;
    }

    @Override // c.f.b.a
    public String getPickerViewText() {
        return x.isNotNull(this.tagName) ? this.tagName : "";
    }

    public String getTagKey() {
        return this.tagKey;
    }

    public String getTagName() {
        return this.tagName;
    }

    public boolean isLeaf() {
        return this.leaf;
    }

    public void setChildren(List<WorkAddressVo> list) {
        this.children = list;
    }

    public void setLeaf(boolean z) {
        this.leaf = z;
    }

    public void setTagKey(String str) {
        this.tagKey = str;
    }

    public void setTagName(String str) {
        this.tagName = str;
    }
}
