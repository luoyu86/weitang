package com.chinavisionary.microtang.room.vo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RoomSourceDetailsVo extends NewBaseVo {
    private static final int TRUE = 0;
    private String accessToken;
    private List<ActivityListBean> activityList;
    private String appid;
    private String buildingCode;
    private String buildingId;
    private String buildingName;
    private String communityUrl;
    private String detailUrl;
    private List<RoomDeviceListItemVo> deviceList;
    private String enterpriseid;
    private String groupId;
    private String groupName;
    private String houseCode;
    private String houseFloor;
    private String houseId;
    private String houseName;
    private String houseNumber;
    private String houseStyle;
    private String houseStyleId;
    private String houseType;
    private String houseTypeId;
    private String key;
    private String latitude;
    private String longitude;
    private String mapUrl;
    private String primaryKey;
    private String projectId;
    private String rentFee;
    private Integer reserveFlag;
    private Integer signFlag;
    private String spaceFullName;
    private String spaceId;
    private String underlineRentFee;

    public String getAccessToken() {
        return this.accessToken;
    }

    public List<ActivityListBean> getActivityList() {
        return this.activityList;
    }

    public String getAppid() {
        return this.appid;
    }

    public String getBuildingCode() {
        return this.buildingCode;
    }

    public String getBuildingId() {
        return this.buildingId;
    }

    public String getBuildingName() {
        return this.buildingName;
    }

    public String getCommunityUrl() {
        return this.communityUrl;
    }

    public String getDetailUrl() {
        return this.detailUrl;
    }

    public List<RoomDeviceListItemVo> getDeviceList() {
        return this.deviceList;
    }

    public String getEnterpriseid() {
        return this.enterpriseid;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getHouseCode() {
        return this.houseCode;
    }

    public String getHouseFloor() {
        return this.houseFloor;
    }

    public String getHouseId() {
        return this.houseId;
    }

    public String getHouseName() {
        return this.houseName;
    }

    public String getHouseNumber() {
        return this.houseNumber;
    }

    public String getHouseStyle() {
        return this.houseStyle;
    }

    public String getHouseStyleId() {
        return this.houseStyleId;
    }

    public String getHouseType() {
        return this.houseType;
    }

    public String getHouseTypeId() {
        return this.houseTypeId;
    }

    public String getKey() {
        return this.key;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getMapUrl() {
        return this.mapUrl;
    }

    public String getPrimaryKey() {
        return this.primaryKey;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getRentFee() {
        return this.rentFee;
    }

    public int getReserveFlag() {
        return this.reserveFlag.intValue();
    }

    public int getSignFlag() {
        return this.signFlag.intValue();
    }

    public String getSpaceFullName() {
        return this.spaceFullName;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public String getUnderlineRentFee() {
        return this.underlineRentFee;
    }

    public boolean isReserveFlag() {
        Integer num = this.reserveFlag;
        return num != null && num.intValue() == 0;
    }

    public boolean isSignFlag() {
        Integer num = this.signFlag;
        return num != null && num.intValue() == 0;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setActivityList(List<ActivityListBean> list) {
        this.activityList = list;
    }

    public void setAppid(String str) {
        this.appid = str;
    }

    public void setBuildingCode(String str) {
        this.buildingCode = str;
    }

    public void setBuildingId(String str) {
        this.buildingId = str;
    }

    public void setBuildingName(String str) {
        this.buildingName = str;
    }

    public void setCommunityUrl(String str) {
        this.communityUrl = str;
    }

    public void setDetailUrl(String str) {
        this.detailUrl = str;
    }

    public void setDeviceList(List<RoomDeviceListItemVo> list) {
        this.deviceList = list;
    }

    public void setEnterpriseid(String str) {
        this.enterpriseid = str;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setHouseCode(String str) {
        this.houseCode = str;
    }

    public void setHouseFloor(String str) {
        this.houseFloor = str;
    }

    public void setHouseId(String str) {
        this.houseId = str;
    }

    public void setHouseName(String str) {
        this.houseName = str;
    }

    public void setHouseNumber(String str) {
        this.houseNumber = str;
    }

    public void setHouseStyle(String str) {
        this.houseStyle = str;
    }

    public void setHouseStyleId(String str) {
        this.houseStyleId = str;
    }

    public void setHouseType(String str) {
        this.houseType = str;
    }

    public void setHouseTypeId(String str) {
        this.houseTypeId = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setMapUrl(String str) {
        this.mapUrl = str;
    }

    public void setPrimaryKey(String str) {
        this.primaryKey = str;
    }

    public void setProjectId(String str) {
        this.projectId = str;
    }

    public void setRentFee(String str) {
        this.rentFee = str;
    }

    public void setReserveFlag(int i2) {
        this.reserveFlag = Integer.valueOf(i2);
    }

    public void setSignFlag(int i2) {
        this.signFlag = Integer.valueOf(i2);
    }

    public void setSpaceFullName(String str) {
        this.spaceFullName = str;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }

    public void setUnderlineRentFee(String str) {
        this.underlineRentFee = str;
    }
}
