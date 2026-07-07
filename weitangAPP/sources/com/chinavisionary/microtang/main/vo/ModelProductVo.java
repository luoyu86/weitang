package com.chinavisionary.microtang.main.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ModelProductVo extends BaseVo {
    public static final int TYPE_ARTICLE = 3;
    public static final int TYPE_CHECKIN_COMMENT = 4;
    public static final int TYPE_CLEAN_COMMENT = 6;
    public static final int TYPE_FOOD_PAY = 2;
    public static final int TYPE_MSG_LIST = 7;
    public static final int TYPE_OPEN_ACTIVITY_EVALUATE = 9;
    public static final int TYPE_OPEN_ALI_MINI_PROGRAM = 18;
    public static final int TYPE_OPEN_APP_COMMENT = 1000;
    public static final int TYPE_OPEN_DOOR_APPLY = 8;
    public static final int TYPE_OPEN_H5_COMMENT = 2000;
    public static final int TYPE_OPEN_WX_MINI_PROGRAM = 15;
    public static final int TYPE_PRODUCT = 0;
    public static final int TYPE_REPAIR_COMMENT = 5;
    public static final int TYPE_WEB = 1;
    private ParamBean param;
    private int type;
    private String typeName;

    public static class ParamBean extends BaseVo {
        private String commoditySubtitle;
        private String commodityTitle;
        private boolean isRefresh;
        private String key;
        private String minimumMonthlyRent;
        private List<ResourceVo> resourceVos;

        public String getCommoditySubtitle() {
            return this.commoditySubtitle;
        }

        public String getCommodityTitle() {
            return this.commodityTitle;
        }

        public String getKey() {
            return this.key;
        }

        public String getMinimumMonthlyRent() {
            return this.minimumMonthlyRent;
        }

        public List<ResourceVo> getResourceVos() {
            return this.resourceVos;
        }

        public boolean isRefresh() {
            return this.isRefresh;
        }

        public void setCommoditySubtitle(String str) {
            this.commoditySubtitle = str;
        }

        public void setCommodityTitle(String str) {
            this.commodityTitle = str;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setMinimumMonthlyRent(String str) {
            this.minimumMonthlyRent = str;
        }

        public void setRefresh(boolean z) {
            this.isRefresh = z;
        }

        public void setResourceVos(List<ResourceVo> list) {
            this.resourceVos = list;
        }
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
