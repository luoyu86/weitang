package com.bytedance.sdk.openadsdk.api.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.model.DownloadShortInfo;

/* JADX INFO: loaded from: classes.dex */
public class s implements Bridge {
    private DownloadShortInfo ok;

    public s(DownloadShortInfo downloadShortInfo) {
        this.ok = downloadShortInfo;
    }

    public int a() {
        DownloadShortInfo downloadShortInfo = this.ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.status;
        }
        return -1;
    }

    public long bl() {
        DownloadShortInfo downloadShortInfo = this.ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.totalBytes;
        }
        return -1L;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        switch (i2) {
            case ValueSetConstants.VALUE_DOWNLOAD_SHORT_EQUALS /* 223700 */:
                return (T) Boolean.valueOf(equals(valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_EQUALS_PARAMETER, Object.class)));
            case ValueSetConstants.VALUE_DOWNLOAD_SHORT_HASH_CODE /* 223701 */:
                hashCode();
                return null;
            default:
                return null;
        }
    }

    public boolean equals(Object obj) {
        DownloadShortInfo downloadShortInfo = this.ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.equals(obj);
        }
        return false;
    }

    public boolean h() {
        DownloadShortInfo downloadShortInfo = this.ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.onlyWifi;
        }
        return false;
    }

    public int hashCode() {
        DownloadShortInfo downloadShortInfo = this.ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.hashCode();
        }
        return 0;
    }

    public int kf() {
        DownloadShortInfo downloadShortInfo = this.ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.failStatus;
        }
        return 0;
    }

    public String n() {
        DownloadShortInfo downloadShortInfo = this.ok;
        return downloadShortInfo != null ? downloadShortInfo.fileName : "";
    }

    public long ok() {
        DownloadShortInfo downloadShortInfo = this.ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.id;
        }
        return -1L;
    }

    public long s() {
        DownloadShortInfo downloadShortInfo = this.ok;
        if (downloadShortInfo != null) {
            return downloadShortInfo.currentBytes;
        }
        return -1L;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return c.d.a.a.a.a.a.ok().ok(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_ID, ok()).ok(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_STATUS, a()).ok(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES, bl()).ok(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_CURRENT_BYTES, s()).ok(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME, n()).ok(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FAIL_STATUS, kf()).ok(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_ONLY_WIFI, h()).a();
    }
}
