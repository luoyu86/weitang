package com.chinavisionary.microtang.main.vo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import com.chinavisionary.microtang.room.vo.ProductDetailsVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ResponseGroupItemDetailsVo extends NewBaseVo {
    private String address;
    private List<ProductDetailsVo.TagsBean> bannerImagesList;
    private String groupDesc;
    private String groupKey;
    private String groupName;
    private String latitude;
    private String longitude;
    private String rentPrice;
    private List<ProductDetailsVo.TagsBean> tagCloudDtos;
    private String url;

    public String getAddress() {
        return this.address;
    }

    public List<ProductDetailsVo.TagsBean> getBannerImagesList() {
        return this.bannerImagesList;
    }

    public String getGroupDesc() {
        return this.groupDesc;
    }

    public String getGroupKey() {
        return this.groupKey;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getRentPrice() {
        return this.rentPrice;
    }

    public List<ProductDetailsVo.TagsBean> getTagCloudDtos() {
        return this.tagCloudDtos;
    }

    public String getUrl() {
        return this.url;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setBannerImagesList(List<ProductDetailsVo.TagsBean> list) {
        this.bannerImagesList = list;
    }

    public void setGroupDesc(String str) {
        this.groupDesc = str;
    }

    public void setGroupKey(String str) {
        this.groupKey = str;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setRentPrice(String str) {
        this.rentPrice = str;
    }

    public void setTagCloudDtos(List<ProductDetailsVo.TagsBean> list) {
        this.tagCloudDtos = list;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
