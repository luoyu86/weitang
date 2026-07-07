package com.chinavisionary.microtang.room.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.microtang.contract.vo.SignMainInfoVo;

/* JADX INFO: loaded from: classes2.dex */
public class CheckTogetherVo extends BaseVo {
    private boolean isAddTogether;
    private SignMainInfoVo mSignMainInfoVo;
    private String tipMsg;

    public SignMainInfoVo getSignMainInfoVo() {
        return this.mSignMainInfoVo;
    }

    public String getTipMsg() {
        return this.tipMsg;
    }

    public boolean isAddTogether() {
        return this.isAddTogether;
    }

    public void setAddTogether(boolean z) {
        this.isAddTogether = z;
    }

    public void setSignMainInfoVo(SignMainInfoVo signMainInfoVo) {
        this.mSignMainInfoVo = signMainInfoVo;
    }

    public void setTipMsg(String str) {
        this.tipMsg = str;
    }
}
