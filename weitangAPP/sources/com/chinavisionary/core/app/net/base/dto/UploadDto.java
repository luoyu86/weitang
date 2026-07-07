package com.chinavisionary.core.app.net.base.dto;

import c.e.a.a.h.e.b;
import c.e.a.a.h.e.c;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class UploadDto extends BaseVo {
    private b iProgressListener;
    private c mIUploadCallback;
    private String requestUrl;
    private List<File> uploadFileList;

    public c getIUploadCallback() {
        return this.mIUploadCallback;
    }

    public String getRequestUrl() {
        String str = this.requestUrl;
        return str == null ? "" : str;
    }

    public List<File> getUploadFile() {
        return this.uploadFileList;
    }

    public b getiProgressListener() {
        return this.iProgressListener;
    }

    public void setIUploadCallback(c cVar) {
        this.mIUploadCallback = cVar;
    }

    public void setRequestUrl(String str) {
        if (str == null) {
            str = "";
        }
        this.requestUrl = str;
    }

    public void setUploadFile(List<File> list) {
        this.uploadFileList = list;
    }

    public void setiProgressListener(b bVar) {
        this.iProgressListener = bVar;
    }
}
