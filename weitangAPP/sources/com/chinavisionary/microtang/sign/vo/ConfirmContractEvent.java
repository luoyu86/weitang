package com.chinavisionary.microtang.sign.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class ConfirmContractEvent extends BaseVo {
    private boolean isConfirm;
    private int position;

    public int getPosition() {
        return this.position;
    }

    public boolean isConfirm() {
        return this.isConfirm;
    }

    public void setConfirm(boolean z) {
        this.isConfirm = z;
    }

    public void setPosition(int i2) {
        this.position = i2;
    }
}
