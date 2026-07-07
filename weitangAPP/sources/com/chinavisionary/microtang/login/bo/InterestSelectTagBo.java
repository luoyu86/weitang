package com.chinavisionary.microtang.login.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class InterestSelectTagBo extends BaseVo {
    private List<String> tagKeys = new ArrayList();

    public List<String> getTagKeys() {
        return this.tagKeys;
    }

    public void setTagKeys(List<String> list) {
        this.tagKeys = list;
    }
}
