package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SubmitPropertyStateVo extends BaseVo {
    private List<AssetRecognitionItemsBean> assetRecognitionItems;

    public static class AssetRecognitionItemsBean extends BaseVo {
        private String assetKey;
        private String assetRecognitionKey;
        private int recognitionStatus;

        public String getAssetKey() {
            return this.assetKey;
        }

        public String getAssetRecognitionKey() {
            return this.assetRecognitionKey;
        }

        public int getRecognitionStatus() {
            return this.recognitionStatus;
        }

        public void setAssetKey(String str) {
            this.assetKey = str;
        }

        public void setAssetRecognitionKey(String str) {
            this.assetRecognitionKey = str;
        }

        public void setRecognitionStatus(int i2) {
            this.recognitionStatus = i2;
        }
    }

    public List<AssetRecognitionItemsBean> getAssetRecognitionItems() {
        return this.assetRecognitionItems;
    }

    public void setAssetRecognitionItems(List<AssetRecognitionItemsBean> list) {
        this.assetRecognitionItems = list;
    }
}
