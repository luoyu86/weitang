package com.chinavisionary.microtang.merchant.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MerchantRightContentVo extends BaseVo {
    private FoodVo foodVo;
    private int itemType;
    private String title;
    private int titlePosition;

    public static class FoodVo extends BaseVo {
        private int buyNumber;
        private ResourceVo coverRes;
        private boolean isMultiSpec;
        private SpecificationsVo mSelectSpec;
        private int maxLimit;
        private int monthSaleVolume;
        private BigDecimal price;
        private String productKey;
        private List<SpecificationTagsVo> recommendTagList;
        private List<SpecificationsVo> specifications;
        private String title;

        public int getBuyNumber() {
            return this.buyNumber;
        }

        public ResourceVo getCoverRes() {
            return this.coverRes;
        }

        public int getMaxLimit() {
            return this.maxLimit;
        }

        public int getMonthSaleVolume() {
            return this.monthSaleVolume;
        }

        public BigDecimal getPrice() {
            return this.price;
        }

        public String getProductKey() {
            return this.productKey;
        }

        public List<SpecificationTagsVo> getRecommendTagList() {
            return this.recommendTagList;
        }

        public SpecificationsVo getSelectSpec() {
            return this.mSelectSpec;
        }

        public List<SpecificationsVo> getSpecifications() {
            return this.specifications;
        }

        public String getTitle() {
            return this.title;
        }

        public boolean isMultiSpec() {
            return this.isMultiSpec;
        }

        public void setBuyNumber(int i2) {
            this.buyNumber = i2;
        }

        public void setCoverRes(ResourceVo resourceVo) {
            this.coverRes = resourceVo;
        }

        public void setMaxLimit(int i2) {
            this.maxLimit = i2;
        }

        public void setMonthSaleVolume(int i2) {
            this.monthSaleVolume = i2;
        }

        public void setMultiSpec(boolean z) {
            this.isMultiSpec = z;
        }

        public void setPrice(BigDecimal bigDecimal) {
            this.price = bigDecimal;
        }

        public void setProductKey(String str) {
            this.productKey = str;
        }

        public void setRecommendTagList(List<SpecificationTagsVo> list) {
            this.recommendTagList = list;
        }

        public void setSelectSpec(SpecificationsVo specificationsVo) {
            this.mSelectSpec = specificationsVo;
        }

        public void setSpecifications(List<SpecificationsVo> list) {
            this.specifications = list;
        }

        public void setTitle(String str) {
            this.title = str;
        }
    }

    public FoodVo getFoodVo() {
        return this.foodVo;
    }

    public int getItemType() {
        return this.itemType;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTitlePosition() {
        return this.titlePosition;
    }

    public void setFoodVo(FoodVo foodVo) {
        this.foodVo = foodVo;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTitlePosition(int i2) {
        this.titlePosition = i2;
    }
}
