package com.chinavisionary.microtang.room.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ProductDetailsVo extends BaseVo {
    private List<BannersBean> banners;
    private String goodsKey;
    private String housingDesc;
    private String key;
    private String message;
    private BigDecimal minimumMonthlyRent;
    private String subTitleName;
    private boolean success;
    private List<TagsBean> tags;
    private String titleName;

    public static class BannersBean extends BaseVo {
        private ResourceVo resource;
        private String tagKey;
        private String tagName;

        public ResourceVo getResource() {
            return this.resource;
        }

        public String getTagKey() {
            return this.tagKey;
        }

        public String getTagName() {
            return this.tagName;
        }

        public void setResource(ResourceVo resourceVo) {
            this.resource = resourceVo;
        }

        public void setTagKey(String str) {
            this.tagKey = str;
        }

        public void setTagName(String str) {
            this.tagName = str;
        }
    }

    public static class TagsBean extends BaseVo {
        private int chooseNumber;
        private String[] imagesList;
        private String tagKey;
        private String tagName;

        public int getChooseNumber() {
            return this.chooseNumber;
        }

        public String[] getImagesList() {
            return this.imagesList;
        }

        public String getTagKey() {
            return this.tagKey;
        }

        public String getTagName() {
            return this.tagName;
        }

        public void setChooseNumber(int i2) {
            this.chooseNumber = i2;
        }

        public void setImagesList(String[] strArr) {
            this.imagesList = strArr;
        }

        public void setTagKey(String str) {
            this.tagKey = str;
        }

        public void setTagName(String str) {
            this.tagName = str;
        }
    }

    public List<BannersBean> getBanners() {
        return this.banners;
    }

    public String getGoodsKey() {
        return this.goodsKey;
    }

    public String getHousingDesc() {
        return this.housingDesc;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public BigDecimal getMinimumMonthlyRent() {
        return this.minimumMonthlyRent;
    }

    public String getSubTitleName() {
        return this.subTitleName;
    }

    public List<TagsBean> getTags() {
        return this.tags;
    }

    public String getTitleName() {
        return this.titleName;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setBanners(List<BannersBean> list) {
        this.banners = list;
    }

    public void setGoodsKey(String str) {
        this.goodsKey = str;
    }

    public void setHousingDesc(String str) {
        this.housingDesc = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setMinimumMonthlyRent(BigDecimal bigDecimal) {
        this.minimumMonthlyRent = bigDecimal;
    }

    public void setSubTitleName(String str) {
        this.subTitleName = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public void setTags(List<TagsBean> list) {
        this.tags = list;
    }

    public void setTitleName(String str) {
        this.titleName = str;
    }
}
