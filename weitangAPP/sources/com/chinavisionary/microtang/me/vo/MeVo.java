package com.chinavisionary.microtang.me.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MeVo extends BaseVo {
    private List<CoverVo> coverList;
    private String key;
    private String title;
    private int type;

    public static class CoverVo extends BaseVo {
        private ResourceVo resourceVo;
        private String url;

        public ResourceVo getResourceVo() {
            return this.resourceVo;
        }

        public String getUrl() {
            return this.url;
        }

        public void setResourceVo(ResourceVo resourceVo) {
            this.resourceVo = resourceVo;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public List<CoverVo> getCoverList() {
        return this.coverList;
    }

    public String getKey() {
        return this.key;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public void setCoverList(List<CoverVo> list) {
        this.coverList = list;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
