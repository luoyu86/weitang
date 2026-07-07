package com.chinavisionary.microtang.me.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class CreateRollOutBo extends BaseVo {
    private String accountName;
    private String verificationCode;
    private String withdrawalAccount;

    public String getAccountName() {
        return this.accountName;
    }

    public String getVerificationCode() {
        return this.verificationCode;
    }

    public String getWithdrawalAccount() {
        return this.withdrawalAccount;
    }

    public void setAccountName(String str) {
        this.accountName = str;
    }

    public void setVerificationCode(String str) {
        this.verificationCode = str;
    }

    public void setWithdrawalAccount(String str) {
        this.withdrawalAccount = str;
    }
}
