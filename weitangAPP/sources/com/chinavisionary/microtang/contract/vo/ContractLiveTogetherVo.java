package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ContractLiveTogetherVo<T> extends BaseVo {
    private String key;
    private int maxRoommateNumber;
    private String message;
    private List<T> roommates;
    private Boolean success = Boolean.FALSE;

    public String getKey() {
        return this.key;
    }

    public int getMaxRoommateNumber() {
        return this.maxRoommateNumber;
    }

    public String getMessage() {
        return this.message;
    }

    public List<T> getRoommates() {
        return this.roommates;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMaxRoommateNumber(int i2) {
        this.maxRoommateNumber = i2;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setRoommates(List<T> list) {
        this.roommates = list;
    }

    public void setSuccess(Boolean bool) {
        this.success = bool;
    }
}
