package com.chinavisionary.microtang.service.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CreateFormBo extends BaseVo {
    private String formTemplateKey;
    private List<ItemsBean> items;
    private String userKey;
    private int userType;

    public static class ItemsBean extends BaseVo {
        private List<DatasourceItemsBean> datasourceItems;
        private String formTemplateItemKey;
        private String value;

        public static class DatasourceItemsBean extends BaseVo {
            private String key;
            private String name;
            private String value;

            public String getKey() {
                return this.key;
            }

            public String getName() {
                return this.name;
            }

            public String getValue() {
                return this.value;
            }

            public void setKey(String str) {
                this.key = str;
            }

            public void setName(String str) {
                this.name = str;
            }

            public void setValue(String str) {
                this.value = str;
            }
        }

        public List<DatasourceItemsBean> getDatasourceItems() {
            return this.datasourceItems;
        }

        public String getFormTemplateItemKey() {
            return this.formTemplateItemKey;
        }

        public String getValue() {
            return this.value;
        }

        public void setDatasourceItems(List<DatasourceItemsBean> list) {
            this.datasourceItems = list;
        }

        public void setFormTemplateItemKey(String str) {
            this.formTemplateItemKey = str;
        }

        public void setValue(String str) {
            this.value = str;
        }
    }

    public String getFormTemplateKey() {
        return this.formTemplateKey;
    }

    public List<ItemsBean> getItems() {
        return this.items;
    }

    public String getUserKey() {
        return this.userKey;
    }

    public int getUserType() {
        return this.userType;
    }

    public void setFormTemplateKey(String str) {
        this.formTemplateKey = str;
    }

    public void setItems(List<ItemsBean> list) {
        this.items = list;
    }

    public void setUserKey(String str) {
        this.userKey = str;
    }

    public void setUserType(int i2) {
        this.userType = i2;
    }
}
