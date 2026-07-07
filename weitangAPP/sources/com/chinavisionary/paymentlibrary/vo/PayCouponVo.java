package com.chinavisionary.paymentlibrary.vo;

import c.e.a.d.x;
import c.e.a.d.z;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.paymentlibrary.R;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PayCouponVo extends BaseVo {
    private static final int CASH_COUPON_TYPE = 1;
    private static final int EXPIRE_TIP_BEFORE_DAY = 3;
    private static final int PRODUCT_COUPON_TYPE = 2;
    private static final int RENT_COUPON_TYPE = 1;
    private static final int SALE_COUPON_TYPE = 2;
    private Integer applicableFormats;
    private String applyTo;
    private String applyToName;
    private String cost;
    private String couponCategory;
    private String couponId;
    private String discountDesc;
    private BigDecimal discountRate;
    private boolean isCheck;
    private boolean isExpire;
    private boolean isUnavailable;
    private int itemType;
    private String key;
    private List<String> mutexCouponIds;
    private BigDecimal percentOff;
    private Integer preferentialType;
    private String preferentialTypeName;
    private BigDecimal priceOff;
    private String title;
    private String unavailableReason;
    private String useRule;
    private String useRuleDesc;
    private Long validDate;
    private Long validEndTime;
    private Long validStartTime;

    public Integer getApplicableFormats() {
        return this.applicableFormats;
    }

    public String getApplyTo() {
        return this.applyTo;
    }

    public String getApplyToName() {
        return this.applyToName;
    }

    public String getCost() {
        BigDecimal bigDecimal;
        try {
            Integer num = this.preferentialType;
            if (num != null && 2 == num.intValue() && (bigDecimal = this.percentOff) != null && bigDecimal.floatValue() == 0.0f) {
                return null;
            }
            String str = this.discountDesc;
            if (str != null) {
                return str;
            }
            BigDecimal bigDecimal2 = this.priceOff;
            if (bigDecimal2 != null) {
                return x.bigDecimalToZerosPlainString(bigDecimal2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this.cost;
    }

    public String getCouponCategory() {
        Integer num = this.preferentialType;
        if (num != null) {
            if (2 == num.intValue()) {
                return x.getString(R.string.paylib_title_sale_coupon);
            }
            if (1 == this.preferentialType.intValue()) {
                return x.getString(R.string.paylib_title_cash_coupon);
            }
        }
        return x.isNotNull(this.preferentialTypeName) ? this.preferentialTypeName : this.couponCategory;
    }

    public String getCouponId() {
        return this.couponId;
    }

    public String getDiscountDesc() {
        return this.discountDesc;
    }

    public BigDecimal getDiscountRate() {
        return this.discountRate;
    }

    public int getItemType() {
        return this.itemType;
    }

    public String getKey() {
        return this.key;
    }

    public List<String> getMutexCouponIds() {
        return this.mutexCouponIds;
    }

    public BigDecimal getPercentOff() {
        return this.percentOff;
    }

    public Integer getPreferentialType() {
        return this.preferentialType;
    }

    public String getPreferentialTypeName() {
        return this.preferentialTypeName;
    }

    public BigDecimal getPriceOff() {
        return this.priceOff;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUnavailableReason() {
        return this.unavailableReason;
    }

    public String getUseRule() {
        return x.isNotNull(this.title) ? this.title : this.useRule;
    }

    public String getUseRuleDesc() {
        return this.useRuleDesc;
    }

    public Long getValidDate() {
        Long l = this.validEndTime;
        return l != null ? l : this.validDate;
    }

    public Long getValidEndTime() {
        return this.validEndTime;
    }

    public Long getValidStartTime() {
        return this.validStartTime;
    }

    public boolean isCashType() {
        return getPreferentialType() != null && 1 == getPreferentialType().intValue();
    }

    public boolean isCheck() {
        return this.isCheck;
    }

    public boolean isExpire() {
        if (this.validEndTime != null) {
            return this.validEndTime.longValue() < Long.valueOf(z.getNextDayToAmount(3)).longValue();
        }
        return this.isExpire;
    }

    public boolean isProductCoupon() {
        return getApplicableFormats() != null && 2 == getApplicableFormats().intValue();
    }

    public boolean isRentCoupon() {
        return getApplicableFormats() != null && 1 == getApplicableFormats().intValue();
    }

    public boolean isUnavailable() {
        return this.isUnavailable;
    }

    public boolean isValid() {
        Long l = this.validEndTime;
        return l != null && l.longValue() > System.currentTimeMillis();
    }

    public void setApplicableFormats(Integer num) {
        this.applicableFormats = num;
    }

    public void setApplyTo(String str) {
        this.applyTo = str;
    }

    public void setApplyToName(String str) {
        this.applyToName = str;
    }

    public void setCheck(boolean z) {
        this.isCheck = z;
    }

    public void setCost(String str) {
        this.cost = str;
    }

    public void setCouponCategory(String str) {
        this.couponCategory = str;
    }

    public void setCouponId(String str) {
        this.couponId = str;
    }

    public void setDiscountDesc(String str) {
        this.discountDesc = str;
    }

    public void setDiscountRate(BigDecimal bigDecimal) {
        this.discountRate = bigDecimal;
    }

    public void setExpire(boolean z) {
        this.isExpire = z;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMutexCouponIds(List<String> list) {
        this.mutexCouponIds = list;
    }

    public void setPercentOff(BigDecimal bigDecimal) {
        this.percentOff = bigDecimal;
    }

    public void setPreferentialType(Integer num) {
        this.preferentialType = num;
    }

    public void setPreferentialTypeName(String str) {
        this.preferentialTypeName = str;
    }

    public void setPriceOff(BigDecimal bigDecimal) {
        this.priceOff = bigDecimal;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUnavailable(boolean z) {
        this.isUnavailable = z;
    }

    public void setUnavailableReason(String str) {
        this.unavailableReason = str;
    }

    public void setUseRule(String str) {
        this.useRule = str;
    }

    public void setUseRuleDesc(String str) {
        this.useRuleDesc = str;
    }

    public void setValidDate(Long l) {
        this.validDate = l;
    }

    public void setValidEndTime(Long l) {
        this.validEndTime = l;
    }

    public void setValidStartTime(Long l) {
        this.validStartTime = l;
    }
}
