package com.chinavisionary.core.app.oss.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AliYunOssToResourceBo extends BaseVo {
    public static final String BIG_MAP_KEY = "大地图";
    public static final String COVER_KEY = "封面";
    public static final String MAP_KEY = "地图";
    public static final String TAG_KEY = "标签";
    private String filePath;
    private String folderName;
    private List<ResourceVo> resourceVo;

    public String getFilePath() {
        return this.filePath;
    }

    public String getFolderName() {
        return this.folderName;
    }

    public List<ResourceVo> getResourceVo() {
        return this.resourceVo;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setFolderName(String str) {
        this.folderName = str;
    }

    public void setResourceVo(List<ResourceVo> list) {
        this.resourceVo = list;
    }
}
