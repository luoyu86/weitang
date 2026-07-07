package com.chinavisionary.microtang.recommend.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.weight.banner.EditBannerView;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RecommendVo extends BaseVo {
    public static final int BANNER_ITEM_TYPE = 1;
    public static final int CONTENT_ITEM_TYPE = 3;
    public static final int TITLE_ITEM_TYPE = 2;
    private List<EditBannerView.BannerDto> bannerList;
    private Long currentTime;
    private int itemType = 3;
    private String recommendedPersonName;
    private String recommendedPersonPhone;
    private String title;

    public List<EditBannerView.BannerDto> getBannerList() {
        return this.bannerList;
    }

    public Long getCurrentTime() {
        return this.currentTime;
    }

    public int getItemType() {
        return this.itemType;
    }

    public String getRecommendedPersonName() {
        return this.recommendedPersonName;
    }

    public String getRecommendedPersonPhone() {
        return this.recommendedPersonPhone;
    }

    public String getTitle() {
        return this.title;
    }

    public void setBannerList(List<EditBannerView.BannerDto> list) {
        this.bannerList = list;
    }

    public void setCurrentTime(Long l) {
        this.currentTime = l;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setRecommendedPersonName(String str) {
        this.recommendedPersonName = str;
    }

    public void setRecommendedPersonPhone(String str) {
        this.recommendedPersonPhone = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
