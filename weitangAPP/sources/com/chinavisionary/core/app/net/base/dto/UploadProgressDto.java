package com.chinavisionary.core.app.net.base.dto;

import c.e.a.a.h.e.a;
import c.e.a.a.h.e.b;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class UploadProgressDto extends BaseVo {
    private long mCurrentLength;
    private b mIProgressListener;
    private long mTotalLength;
    private List<String> mSuccessList = new ArrayList();
    private List<String> mFailedList = new ArrayList();
    private a mIDownloadProgressCallback = new a() { // from class: com.chinavisionary.core.app.net.base.dto.UploadProgressDto.1
        @Override // c.e.a.a.h.e.a
        public void onFailed(String str) {
            UploadProgressDto.this.mFailedList.add(str);
        }

        @Override // c.e.a.a.h.e.a
        public void onProgress(long j, String str, boolean z) {
            if (z) {
                UploadProgressDto.this.mSuccessList.add(str);
            }
            UploadProgressDto.access$114(UploadProgressDto.this, j);
            if (UploadProgressDto.this.mIProgressListener != null) {
                UploadProgressDto.this.mIProgressListener.onProgress(UploadProgressDto.this.mTotalLength, UploadProgressDto.this.mCurrentLength, UploadProgressDto.this.mTotalLength == UploadProgressDto.this.mCurrentLength);
            }
        }
    };

    public static /* synthetic */ long access$114(UploadProgressDto uploadProgressDto, long j) {
        long j2 = uploadProgressDto.mCurrentLength + j;
        uploadProgressDto.mCurrentLength = j2;
        return j2;
    }

    public List<String> getFailedList() {
        return this.mFailedList;
    }

    public a getIDownloadProgressCallback() {
        return this.mIDownloadProgressCallback;
    }

    public List<String> getSuccessList() {
        return this.mSuccessList;
    }

    public void setIProgressListener(b bVar) {
        this.mIProgressListener = bVar;
    }

    public void setTotalLength(long j) {
        this.mTotalLength = j;
    }
}
