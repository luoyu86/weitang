package com.chinavisionary.microtang.room.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class MoreRentRoomVo extends BaseVo {
    public static final int CHANGE_RENT_STATE = 7;
    public static final int RENTED_STATE = 2;
    public static final int RENT_STATE = 3;
    public static final int RESERVE_SIGN_STATE = 6;
    public static final int RESERVE_STATE = 5;
    public static final int SIGNABLE_STATE = 1;
    public static final int SIGN_STATE = 4;
    private String assetInstanceKey;
    private String buildName;
    private int commentNumber;
    private String floorName;
    private String goodsKey;
    private String goodsSubtitle;
    private String goodsTitle;
    private String houseName;
    private String houseStatusName;
    private String minimumMonthlyRent;
    private String orientation;
    private int status;
    private String statusName;
    private String underlineRentFee;

    public String getAssetInstanceKey() {
        return this.assetInstanceKey;
    }

    public String getBuildName() {
        return this.buildName;
    }

    public int getCommentNumber() {
        return this.commentNumber;
    }

    public String getFloorName() {
        return this.floorName;
    }

    public String getGoodsKey() {
        return this.goodsKey;
    }

    public String getGoodsSubtitle() {
        return this.goodsSubtitle;
    }

    public String getGoodsTitle() {
        return this.goodsTitle;
    }

    public String getHouseName() {
        return this.houseName;
    }

    public String getHouseStatusName() {
        return this.houseStatusName;
    }

    public String getMinimumMonthlyRent() {
        return this.minimumMonthlyRent;
    }

    public String getOrientation() {
        return this.orientation;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStatusName() {
        return this.statusName;
    }

    public String getUnderlineRentFee() {
        return this.underlineRentFee;
    }

    public void setAssetInstanceKey(String str) {
        this.assetInstanceKey = str;
    }

    public void setBuildName(String str) {
        this.buildName = str;
    }

    public void setCommentNumber(int i2) {
        this.commentNumber = i2;
    }

    public void setFloorName(String str) {
        this.floorName = str;
    }

    public void setGoodsKey(String str) {
        this.goodsKey = str;
    }

    public void setGoodsSubtitle(String str) {
        this.goodsSubtitle = str;
    }

    public void setGoodsTitle(String str) {
        this.goodsTitle = str;
    }

    public void setHouseName(String str) {
        this.houseName = str;
    }

    public void setHouseStatusName(String str) {
        this.houseStatusName = str;
    }

    public void setMinimumMonthlyRent(String str) {
        this.minimumMonthlyRent = str;
    }

    public void setOrientation(String str) {
        this.orientation = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setStatusName(String str) {
        this.statusName = str;
    }

    public void setUnderlineRentFee(String str) {
        this.underlineRentFee = str;
    }
}
