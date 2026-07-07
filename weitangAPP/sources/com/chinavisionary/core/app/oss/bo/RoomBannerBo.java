package com.chinavisionary.core.app.oss.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RoomBannerBo extends BaseVo {
    private String folderName;
    private List<ResourceVo> resourceVos;

    public String getFolderName() {
        return this.folderName;
    }

    public List<ResourceVo> getResourceVos() {
        return this.resourceVos;
    }

    public void setFolderName(String str) {
        this.folderName = str;
    }

    public void setResourceVos(List<ResourceVo> list) {
        this.resourceVos = list;
    }
}
