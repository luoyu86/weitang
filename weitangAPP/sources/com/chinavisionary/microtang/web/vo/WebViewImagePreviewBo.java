package com.chinavisionary.microtang.web.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class WebViewImagePreviewBo extends BaseVo {
    private List<String> picList;
    private int position;

    public List<String> getPicList() {
        return this.picList;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPicList(List<String> list) {
        this.picList = list;
    }

    public void setPosition(int i2) {
        this.position = i2;
    }
}
