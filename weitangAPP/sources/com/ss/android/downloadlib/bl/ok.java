package com.ss.android.downloadlib.bl;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class ok implements z {
    private boolean bl(DownloadInfo downloadInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(downloadInfo.getSavePath());
        String str = File.separator;
        sb.append(str);
        sb.append(downloadInfo.getName());
        String string = sb.toString();
        File file = new File(string);
        String strOk = com.ss.android.socialbase.appdownloader.kf.ok.n.ok(r.getContext(), com.ss.android.socialbase.appdownloader.bl.ok(downloadInfo, file), string);
        boolean zRenameTo = false;
        if (!TextUtils.isEmpty(strOk)) {
            String str2 = strOk + ".apk";
            if (str2.equals(downloadInfo.getName())) {
                return true;
            }
            try {
                zRenameTo = file.renameTo(new File(downloadInfo.getSavePath() + str + str2));
                if (zRenameTo) {
                    downloadInfo.setName(str2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return zRenameTo;
    }

    @Override // com.ss.android.socialbase.downloader.depend.z
    public boolean a(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.ss.android.downloadlib.h.n.a(com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()));
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.depend.z
    public void ok(DownloadInfo downloadInfo) throws BaseException {
        if (downloadInfo == null || !bl(downloadInfo)) {
            return;
        }
        ok(r.getContext(), downloadInfo);
    }

    private void ok(Context context, final DownloadInfo downloadInfo) {
        String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
        Cursor cursorQuery = context.getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            downloadInfo.safePutToDBJsonData("file_content_uri", ContentUris.withAppendedId(MediaStore.Files.getContentUri("external"), cursorQuery.getInt(cursorQuery.getColumnIndex("_id"))).toString());
        } else {
            MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{"application/vnd.android.package-archive"}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.ss.android.downloadlib.bl.ok.1
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str2, Uri uri) {
                    if (uri != null) {
                        downloadInfo.safePutToDBJsonData("file_content_uri", uri.toString());
                        com.ss.android.socialbase.downloader.downloader.bl.m().ok(downloadInfo);
                    }
                }
            });
        }
        com.ss.android.socialbase.downloader.q.kf.ok(cursorQuery);
    }
}
