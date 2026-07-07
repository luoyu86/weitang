package com.chinavisionary.microtang.service.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DataSourceVo extends BaseVo {
    private List<DatasourceItemsBean> datasourceItems;
    private String datasourceKey;
    private String datasourceName;
    private String datasourceTag;
    private int datasourceType;

    public static class DatasourceItemsBean extends BaseVo {
        private String datasourceItemKey;
        private String datasourceItemName;
        private String datasourceItemValue;
        private boolean isSelect;

        public String getDatasourceItemKey() {
            return this.datasourceItemKey;
        }

        public String getDatasourceItemName() {
            return this.datasourceItemName;
        }

        public String getDatasourceItemValue() {
            return this.datasourceItemValue;
        }

        public boolean isSelect() {
            return this.isSelect;
        }

        public void setDatasourceItemKey(String str) {
            this.datasourceItemKey = str;
        }

        public void setDatasourceItemName(String str) {
            this.datasourceItemName = str;
        }

        public void setDatasourceItemValue(String str) {
            this.datasourceItemValue = str;
        }

        public void setSelect(boolean z) {
            this.isSelect = z;
        }
    }

    public List<DatasourceItemsBean> getDatasourceItems() {
        return this.datasourceItems;
    }

    public String getDatasourceKey() {
        return this.datasourceKey;
    }

    public String getDatasourceName() {
        return this.datasourceName;
    }

    public String getDatasourceTag() {
        return this.datasourceTag;
    }

    public int getDatasourceType() {
        return this.datasourceType;
    }

    public void setDatasourceItems(List<DatasourceItemsBean> list) {
        this.datasourceItems = list;
    }

    public void setDatasourceKey(String str) {
        this.datasourceKey = str;
    }

    public void setDatasourceName(String str) {
        this.datasourceName = str;
    }

    public void setDatasourceTag(String str) {
        this.datasourceTag = str;
    }

    public void setDatasourceType(int i2) {
        this.datasourceType = i2;
    }
}
