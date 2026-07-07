package com.chinavisionary.microtang.me.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CleanProductDetailsVo extends BaseVo {
    private List<ResourceVo> albumPhotos;
    private String appid;
    private ResourceVo cover;
    private String coverKey;
    private String desc;
    private String descKey;
    private boolean ifOrderPage;
    private String key;
    private String message;
    private String name;
    private BigDecimal price;
    private String primaryKey;
    private String remark;
    private boolean success;
    private BigDecimal underlinePrice;

    public List<ResourceVo> getAlbumPhotos() {
        return this.albumPhotos;
    }

    public String getAppid() {
        return this.appid;
    }

    public ResourceVo getCover() {
        return this.cover;
    }

    public String getCoverKey() {
        return this.coverKey;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getDescKey() {
        return this.descKey;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getPrimaryKey() {
        return this.primaryKey;
    }

    public String getRemark() {
        return this.remark;
    }

    public BigDecimal getUnderlinePrice() {
        return this.underlinePrice;
    }

    public boolean isIfOrderPage() {
        return this.ifOrderPage;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setAlbumPhotos(List<ResourceVo> list) {
        this.albumPhotos = list;
    }

    public void setAppid(String str) {
        this.appid = str;
    }

    public void setCover(ResourceVo resourceVo) {
        this.cover = resourceVo;
    }

    public void setCoverKey(String str) {
        this.coverKey = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDescKey(String str) {
        this.descKey = str;
    }

    public void setIfOrderPage(boolean z) {
        this.ifOrderPage = z;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPrice(BigDecimal bigDecimal) {
        this.price = bigDecimal;
    }

    public void setPrimaryKey(String str) {
        this.primaryKey = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public void setUnderlinePrice(BigDecimal bigDecimal) {
        this.underlinePrice = bigDecimal;
    }
}
