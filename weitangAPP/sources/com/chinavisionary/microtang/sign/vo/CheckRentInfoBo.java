package com.chinavisionary.microtang.sign.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class CheckRentInfoBo extends BaseVo {
    private boolean hasValid;
    private UpdateRentUserInfoBo mUpdateRentUserInfoBo;
    private String tipMsg;

    public String getTipMsg() {
        return this.tipMsg;
    }

    public UpdateRentUserInfoBo getUpdateRentUserInfoBo() {
        return this.mUpdateRentUserInfoBo;
    }

    public boolean isHasValid() {
        return this.hasValid;
    }

    public void setHasValid(boolean z) {
        this.hasValid = z;
    }

    public void setTipMsg(String str) {
        this.tipMsg = str;
    }

    public void setUpdateRentUserInfoBo(UpdateRentUserInfoBo updateRentUserInfoBo) {
        this.mUpdateRentUserInfoBo = updateRentUserInfoBo;
    }
}
