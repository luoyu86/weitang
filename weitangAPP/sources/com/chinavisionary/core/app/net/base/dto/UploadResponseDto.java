package com.chinavisionary.core.app.net.base.dto;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class UploadResponseDto extends BaseVo {
    private List<String> uploadFailedList;
    private List<ResponseUploadImgVo> uploadSuccessList;

    public List<String> getUploadFailedList() {
        List<String> list = this.uploadFailedList;
        return list == null ? new ArrayList() : list;
    }

    public List<ResponseUploadImgVo> getUploadSuccessList() {
        List<ResponseUploadImgVo> list = this.uploadSuccessList;
        return list == null ? new ArrayList() : list;
    }

    public void setUploadFailedList(List<String> list) {
        this.uploadFailedList = list;
    }

    public void setUploadSuccessList(List<ResponseUploadImgVo> list) {
        this.uploadSuccessList = list;
    }
}
