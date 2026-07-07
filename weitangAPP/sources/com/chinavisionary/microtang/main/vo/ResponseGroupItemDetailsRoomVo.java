package com.chinavisionary.microtang.main.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ResponseGroupItemDetailsRoomVo extends BaseVo {
    public static final int AVAILABLE = 0;
    public static final int UNAVAILABLE = 1;
    private String houseKey;
    private String houseName;
    private Integer houseStatus;
    private String houseStatusName;
    private String rentPrice;
    private Integer reserveStatus;
    private String reserveStatusName;
    private Integer signStatus;
    private String signStatusName;
    private String spaceId;
    private String spaceName;
    private String underlineRentFee;

    public String getHouseKey() {
        return this.spaceId;
    }

    public String getHouseName() {
        return this.spaceName;
    }

    public Integer getHouseStatus() {
        return this.houseStatus;
    }

    public String getHouseStatusName() {
        return this.houseStatusName;
    }

    public String getRentPrice() {
        return this.rentPrice;
    }

    public Integer getReserveStatus() {
        return this.reserveStatus;
    }

    public String getReserveStatusName() {
        return this.reserveStatusName;
    }

    public Integer getSignStatus() {
        return this.signStatus;
    }

    public String getSignStatusName() {
        return this.signStatusName;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public String getSpaceName() {
        return this.spaceName;
    }

    public String getUnderlineRentFee() {
        return this.underlineRentFee;
    }

    public void setHouseKey(String str) {
        this.houseKey = str;
    }

    public void setHouseName(String str) {
        this.houseName = str;
    }

    public void setHouseStatus(Integer num) {
        this.houseStatus = num;
    }

    public void setHouseStatusName(String str) {
        this.houseStatusName = str;
    }

    public void setRentPrice(String str) {
        this.rentPrice = str;
    }

    public void setReserveStatus(Integer num) {
        this.reserveStatus = num;
    }

    public void setReserveStatusName(String str) {
        this.reserveStatusName = str;
    }

    public void setSignStatus(Integer num) {
        this.signStatus = num;
    }

    public void setSignStatusName(String str) {
        this.signStatusName = str;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }

    public void setSpaceName(String str) {
        this.spaceName = str;
    }

    public void setUnderlineRentFee(String str) {
        this.underlineRentFee = str;
    }
}
