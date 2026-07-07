package com.chinavisionary.microtang.auth.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class RequestIDCardBo extends BaseVo {
    private String idCardBackSideResourceKey;
    private String idCardFrontSideResourceKey;
    private String personPhotoResourceKey;
    private int type;

    public String getIdCardBackSideResourceKey() {
        return this.idCardBackSideResourceKey;
    }

    public String getIdCardFrontSideResourceKey() {
        return this.idCardFrontSideResourceKey;
    }

    public String getPersonPhotoResourceKey() {
        return this.personPhotoResourceKey;
    }

    public int getType() {
        return this.type;
    }

    public void setIdCardBackSideResourceKey(String str) {
        this.idCardBackSideResourceKey = str;
    }

    public void setIdCardFrontSideResourceKey(String str) {
        this.idCardFrontSideResourceKey = str;
    }

    public void setPersonPhotoResourceKey(String str) {
        this.personPhotoResourceKey = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
