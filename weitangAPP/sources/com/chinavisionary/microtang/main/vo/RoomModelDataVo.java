package com.chinavisionary.microtang.main.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RoomModelDataVo extends BaseVo {
    private List<DatasBean> datas;
    private String key;
    private String message;
    private boolean success;

    public static class DatasBean extends BaseVo {
        private String dataKey;
        private String dataParam;
        private String dataTitle;
        private int dataType;
        private String dataTypeName;
        private String moduleKey;
        private int showIndex;

        public String getDataKey() {
            return this.dataKey;
        }

        public String getDataParam() {
            return this.dataParam;
        }

        public String getDataTitle() {
            return this.dataTitle;
        }

        public int getDataType() {
            return this.dataType;
        }

        public String getDataTypeName() {
            return this.dataTypeName;
        }

        public String getModuleKey() {
            return this.moduleKey;
        }

        public int getShowIndex() {
            return this.showIndex;
        }

        public void setDataKey(String str) {
            this.dataKey = str;
        }

        public void setDataParam(String str) {
            this.dataParam = str;
        }

        public void setDataTitle(String str) {
            this.dataTitle = str;
        }

        public void setDataType(int i2) {
            this.dataType = i2;
        }

        public void setDataTypeName(String str) {
            this.dataTypeName = str;
        }

        public void setModuleKey(String str) {
            this.moduleKey = str;
        }

        public void setShowIndex(int i2) {
            this.showIndex = i2;
        }
    }

    public List<DatasBean> getDatas() {
        return this.datas;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setDatas(List<DatasBean> list) {
        this.datas = list;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
