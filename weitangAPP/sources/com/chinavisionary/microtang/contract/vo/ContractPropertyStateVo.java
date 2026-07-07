package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ContractPropertyStateVo extends BaseVo {
    public static final int ASSET_TYPE_ELECTRIC = 2;
    public static final int ASSET_TYPE_GAS_METER = 4;
    public static final int ASSET_TYPE_HOT_WATER_METER = 5;
    public static final int ASSET_TYPE_WATER = 1;
    public static final int NEED_DEFECT_STATE = 5;
    public static final int PERFECT_STATE = 6;
    public static final int REPAIR_STATE = 3;
    private String assetKey;
    private String assetName;
    private String assetRecognitionKey;
    private int assetType;
    private boolean isClick = true;
    private int recognitionStatus;
    private String recognitionStatusName;
    private Double value;

    public String getAssetKey() {
        return this.assetKey;
    }

    public String getAssetName() {
        return this.assetName;
    }

    public String getAssetRecognitionKey() {
        return this.assetRecognitionKey;
    }

    public int getAssetType() {
        return this.assetType;
    }

    public int getRecognitionStatus() {
        return this.recognitionStatus;
    }

    public String getRecognitionStatusName() {
        return this.recognitionStatusName;
    }

    public Double getValue() {
        return this.value;
    }

    public boolean isClick() {
        return this.isClick;
    }

    public void setAssetKey(String str) {
        this.assetKey = str;
    }

    public void setAssetName(String str) {
        this.assetName = str;
    }

    public void setAssetRecognitionKey(String str) {
        this.assetRecognitionKey = str;
    }

    public void setAssetType(int i2) {
        this.assetType = i2;
    }

    public void setClick(boolean z) {
        this.isClick = z;
    }

    public void setRecognitionStatus(int i2) {
        this.recognitionStatus = i2;
    }

    public void setRecognitionStatusName(String str) {
        this.recognitionStatusName = str;
    }

    public void setValue(Double d2) {
        this.value = d2;
    }
}
