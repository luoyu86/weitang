package com.chinavisionary.microtang.me.vo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NewCleanProductDetailsVo extends NewBaseVo {
    private List<ResourceVo> albumPhotos;
    private String appid;
    private ResourceVo cover;
    private String coverKey;
    private String desc;
    private String descKey;
    private String enterpriseid;
    private boolean ifOrderPage;
    private String key;
    private String name;
    private BigDecimal price;
    private String primaryKey;
    private String remark;
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

    public String getEnterpriseid() {
        return this.enterpriseid;
    }

    public String getKey() {
        return this.key;
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

    public void setEnterpriseid(String str) {
        this.enterpriseid = str;
    }

    public void setIfOrderPage(boolean z) {
        this.ifOrderPage = z;
    }

    public void setKey(String str) {
        this.key = str;
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

    public void setUnderlinePrice(BigDecimal bigDecimal) {
        this.underlinePrice = bigDecimal;
    }
}
