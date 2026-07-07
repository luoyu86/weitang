package com.chinavisionary.microtang.service.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseFormTemplateDetailsVo extends BaseVo {
    private Long createTime;
    private String createUserKey;
    private int createUserType;
    private String formTemplateKey;
    private List<ItemsBean> items;
    private String name;
    private String remark;
    private int state;
    private String stateName;

    public static class ItemsBean extends BaseVo {
        public static final int CHECKBOX_TYPE = 1;
        public static final int DATE_PICKER_TYPE = 4;
        public static final int DATE_TIME_PICKER_TYPE = 5;
        public static final int INPUT_AREA_TYPE = 6;
        public static final int INPUT_TYPE = 0;
        public static final int NONE_TYPE = -1;
        public static final int RADIO_TYPE = 2;
        public static final int SELECT_TYPE = 10;
        public static final int TIME_PICKER_TYPE = 3;
        public static final int UPLOAD_AVATAR_TYPE = 9;
        public static final int UPLOAD_FILE_TYPE = 8;
        public static final int UPLOAD_IMAGE_TYPE = 7;
        private String alias;
        private String dataSourceKey;
        private DataSourceVo dataSourceVo;
        private String formTemplateItemKey;
        private String name;
        private String relatedFormTemplateItemKey;
        private int showIndex;
        private int type;

        public String getAlias() {
            return this.alias;
        }

        public String getDataSourceKey() {
            return this.dataSourceKey;
        }

        public DataSourceVo getDataSourceVo() {
            return this.dataSourceVo;
        }

        public String getFormTemplateItemKey() {
            return this.formTemplateItemKey;
        }

        public String getName() {
            return this.name;
        }

        public String getRelatedFormTemplateItemKey() {
            return this.relatedFormTemplateItemKey;
        }

        public int getShowIndex() {
            return this.showIndex;
        }

        public int getType() {
            return this.type;
        }

        public void setAlias(String str) {
            this.alias = str;
        }

        public void setDataSourceKey(String str) {
            this.dataSourceKey = str;
        }

        public void setDataSourceVo(DataSourceVo dataSourceVo) {
            this.dataSourceVo = dataSourceVo;
        }

        public void setFormTemplateItemKey(String str) {
            this.formTemplateItemKey = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setRelatedFormTemplateItemKey(String str) {
            this.relatedFormTemplateItemKey = str;
        }

        public void setShowIndex(int i2) {
            this.showIndex = i2;
        }

        public void setType(int i2) {
            this.type = i2;
        }
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public String getCreateUserKey() {
        return this.createUserKey;
    }

    public int getCreateUserType() {
        return this.createUserType;
    }

    public String getFormTemplateKey() {
        return this.formTemplateKey;
    }

    public List<ItemsBean> getItems() {
        return this.items;
    }

    public String getName() {
        return this.name;
    }

    public String getRemark() {
        return this.remark;
    }

    public int getState() {
        return this.state;
    }

    public String getStateName() {
        return this.stateName;
    }

    public void setCreateTime(Long l) {
        this.createTime = l;
    }

    public void setCreateUserKey(String str) {
        this.createUserKey = str;
    }

    public void setCreateUserType(int i2) {
        this.createUserType = i2;
    }

    public void setFormTemplateKey(String str) {
        this.formTemplateKey = str;
    }

    public void setItems(List<ItemsBean> list) {
        this.items = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setState(int i2) {
        this.state = i2;
    }

    public void setStateName(String str) {
        this.stateName = str;
    }
}
