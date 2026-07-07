package com.chinavisionary.microtang.repair.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RepairOrderReasonVo extends BaseVo {
    private String address;
    private List<PlaceListBean> assetInstanceList;
    private List<Long> dates;
    private List<ReasonListBean> reasonList;

    public static class PlaceListBean extends BaseVo {
        private String assetInstanceKey;
        private String assetInstanceName;

        public String getAssetInstanceKey() {
            return this.assetInstanceKey;
        }

        public String getAssetInstanceName() {
            return this.assetInstanceName;
        }

        public void setAssetInstanceKey(String str) {
            this.assetInstanceKey = str;
        }

        public void setAssetInstanceName(String str) {
            this.assetInstanceName = str;
        }
    }

    public static class ReasonListBean extends BaseVo {
        private String reasonCode;
        private String reasonDesc;

        public String getReasonCode() {
            return this.reasonCode;
        }

        public String getReasonDesc() {
            return this.reasonDesc;
        }

        public void setReasonCode(String str) {
            this.reasonCode = str;
        }

        public void setReasonDesc(String str) {
            this.reasonDesc = str;
        }
    }

    public String getAddress() {
        return this.address;
    }

    public List<PlaceListBean> getAssetInstanceList() {
        return this.assetInstanceList;
    }

    public List<Long> getDates() {
        return this.dates;
    }

    public List<ReasonListBean> getReasonList() {
        return this.reasonList;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAssetInstanceList(List<PlaceListBean> list) {
        this.assetInstanceList = list;
    }

    public void setDates(List<Long> list) {
        this.dates = list;
    }

    public void setReasonList(List<ReasonListBean> list) {
        this.reasonList = list;
    }
}
