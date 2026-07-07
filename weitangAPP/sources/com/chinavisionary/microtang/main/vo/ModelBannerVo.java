package com.chinavisionary.microtang.main.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;

/* JADX INFO: loaded from: classes.dex */
public class ModelBannerVo extends BaseVo {
    private String dataKey;
    private ParamBean param;
    private int type;
    private String typeName;

    public static class ParamBean extends BaseVo {
        private String href;
        private ResourceVo resourceVo;
        private String targetAppid;
        private String targetMiniType;
        private String targetPath;
        private String title;

        public String getHref() {
            return this.href;
        }

        public ResourceVo getResourceVo() {
            return this.resourceVo;
        }

        public String getTargetAppid() {
            return this.targetAppid;
        }

        public String getTargetMiniType() {
            return this.targetMiniType;
        }

        public String getTargetPath() {
            return this.targetPath;
        }

        public String getTitle() {
            return this.title;
        }

        public void setHref(String str) {
            this.href = str;
        }

        public void setResourceVo(ResourceVo resourceVo) {
            this.resourceVo = resourceVo;
        }

        public void setTargetAppid(String str) {
            this.targetAppid = str;
        }

        public void setTargetMiniType(String str) {
            this.targetMiniType = str;
        }

        public void setTargetPath(String str) {
            this.targetPath = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }
    }

    public String getDataKey() {
        return this.dataKey;
    }

    public ParamBean getParam() {
        return this.param;
    }

    public int getType() {
        return this.type;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setDataKey(String str) {
        this.dataKey = str;
    }

    public void setParam(ParamBean paramBean) {
        this.param = paramBean;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setTypeName(String str) {
        this.typeName = str;
    }
}
