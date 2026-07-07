package com.ss.android.downloadlib.bl;

import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class bl implements z {
    @Override // com.ss.android.socialbase.downloader.depend.z
    public boolean a(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.ss.android.download.api.bl.a.ok(com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()), downloadInfo.getMimeType());
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.depend.z
    public void ok(DownloadInfo downloadInfo) throws BaseException {
        com.ss.android.download.api.config.z zVarR = r.r();
        if (downloadInfo == null || zVarR == null) {
            return;
        }
        String packageName = downloadInfo.getPackageName();
        String targetFilePath = downloadInfo.getTargetFilePath();
        File fileOk = ok(packageName, targetFilePath);
        com.ss.android.downloadad.api.ok.a aVarOk = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo);
        zVarR.ok(packageName, targetFilePath, fileOk, aVarOk != null ? j.ok(aVarOk.h()) : null);
        downloadInfo.setMimeType("application/vnd.android.package-archive");
        downloadInfo.setName(fileOk.getName());
        downloadInfo.setMd5(null);
    }

    private File ok(String str, String str2) {
        File file = new File(str2);
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf > 0) {
            str = name.substring(0, iLastIndexOf);
        }
        return new File(file.getParent(), str + ".apk");
    }
}
