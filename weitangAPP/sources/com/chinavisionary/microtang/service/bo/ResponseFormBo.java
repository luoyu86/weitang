package com.chinavisionary.microtang.service.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseFormBo extends BaseVo {
    private String formKey;
    private String formTemplateKey;
    private List<ItemsBean> items;

    public static class ItemsBean extends BaseVo {
        private String formItemKey;
        private String formTemplateItemKey;
        private String name;
        private int showIndex;
        private int type;
        private String value;

        public String getFormItemKey() {
            return this.formItemKey;
        }

        public String getFormTemplateItemKey() {
            return this.formTemplateItemKey;
        }

        public String getName() {
            return this.name;
        }

        public int getShowIndex() {
            return this.showIndex;
        }

        public int getType() {
            return this.type;
        }

        public String getValue() {
            return this.value;
        }

        public void setFormItemKey(String str) {
            this.formItemKey = str;
        }

        public void setFormTemplateItemKey(String str) {
            this.formTemplateItemKey = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setShowIndex(int i2) {
            this.showIndex = i2;
        }

        public void setType(int i2) {
            this.type = i2;
        }

        public void setValue(String str) {
            this.value = str;
        }
    }

    public String getFormKey() {
        return this.formKey;
    }

    public String getFormTemplateKey() {
        return this.formTemplateKey;
    }

    public List<ItemsBean> getItems() {
        return this.items;
    }

    public void setFormKey(String str) {
        this.formKey = str;
    }

    public void setFormTemplateKey(String str) {
        this.formTemplateKey = str;
    }

    public void setItems(List<ItemsBean> list) {
        this.items = list;
    }
}
