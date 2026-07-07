package com.chinavisionary.microtang.me.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class BadgeVo extends BaseVo {
    private Integer cleanOrderCount;
    private Integer contractNewCount;
    private Integer maintainOrderCount;
    private Integer notifyNewCount;
    private Integer reserveCount;

    public Integer getCleanOrderCount() {
        return this.cleanOrderCount;
    }

    public Integer getContractNewCount() {
        return this.contractNewCount;
    }

    public Integer getMaintainOrderCount() {
        return this.maintainOrderCount;
    }

    public Integer getNotifyNewCount() {
        return this.notifyNewCount;
    }

    public Integer getReserveCount() {
        return this.reserveCount;
    }

    public void setCleanOrderCount(Integer num) {
        this.cleanOrderCount = num;
    }

    public void setContractNewCount(Integer num) {
        this.contractNewCount = num;
    }

    public void setMaintainOrderCount(Integer num) {
        this.maintainOrderCount = num;
    }

    public void setNotifyNewCount(Integer num) {
        this.notifyNewCount = num;
    }

    public void setReserveCount(Integer num) {
        this.reserveCount = num;
    }
}
