package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ContractCostDetailsVo extends BaseVo {
    private String exitAccount;
    private String exitBank;
    private String exitPrice;
    private String exitState;
    private String key;

    public String getExitAccount() {
        return this.exitAccount;
    }

    public String getExitBank() {
        return this.exitBank;
    }

    public String getExitPrice() {
        return this.exitPrice;
    }

    public String getExitState() {
        return this.exitState;
    }

    public String getKey() {
        return this.key;
    }

    public void setExitAccount(String str) {
        this.exitAccount = str;
    }

    public void setExitBank(String str) {
        this.exitBank = str;
    }

    public void setExitPrice(String str) {
        this.exitPrice = str;
    }

    public void setExitState(String str) {
        this.exitState = str;
    }

    public void setKey(String str) {
        this.key = str;
    }
}
