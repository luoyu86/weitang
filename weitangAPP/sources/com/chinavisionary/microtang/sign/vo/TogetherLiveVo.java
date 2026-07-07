package com.chinavisionary.microtang.sign.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class TogetherLiveVo extends BaseVo {
    private String idCardBackPath;
    private String idCardFacePath;
    private String idCardNo;
    private boolean isEdit = true;
    private String name;
    private String phone;

    public String getIdCardBackPath() {
        return this.idCardBackPath;
    }

    public String getIdCardFacePath() {
        return this.idCardFacePath;
    }

    public String getIdCardNo() {
        return this.idCardNo;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public boolean isEdit() {
        return this.isEdit;
    }

    public void setEdit(boolean z) {
        this.isEdit = z;
    }

    public void setIdCardBackPath(String str) {
        this.idCardBackPath = str;
    }

    public void setIdCardFacePath(String str) {
        this.idCardFacePath = str;
    }

    public void setIdCardNo(String str) {
        this.idCardNo = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }
}
