package com.chinavisionary.microtang.me.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class IDHeadImageVo extends BaseVo {
    private String backFile;
    private String faceFile;
    private String selfFile;

    public String getBackFile() {
        return this.backFile;
    }

    public String getFaceFile() {
        return this.faceFile;
    }

    public String getSelfFile() {
        return this.selfFile;
    }

    public void setBackFile(String str) {
        this.backFile = str;
    }

    public void setFaceFile(String str) {
        this.faceFile = str;
    }

    public void setSelfFile(String str) {
        this.selfFile = str;
    }
}
