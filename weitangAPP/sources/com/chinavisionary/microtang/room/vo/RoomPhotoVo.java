package com.chinavisionary.microtang.room.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;

/* JADX INFO: loaded from: classes2.dex */
public class RoomPhotoVo extends BaseVo {
    private ResourceVo mResourceVo;
    private String title;

    public ResourceVo getResourceVo() {
        return this.mResourceVo;
    }

    public String getTitle() {
        return this.title;
    }

    public void setResourceVo(ResourceVo resourceVo) {
        this.mResourceVo = resourceVo;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
