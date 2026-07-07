package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.depend.er;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private String globalDefaultSavePath;
    private String globalDefaultSaveTempPath;

    public static DownloadTask with(Context context) {
        Downloader.getInstance(context);
        return new DownloadTask();
    }

    public void addMainThreadListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        s.ok().a(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.kf.MAIN, false);
    }

    public void addNotificationListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        s.ok().a(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.kf.NOTIFICATION, false);
    }

    public void addSubThreadListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        s.ok().a(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.kf.SUB, false);
    }

    public boolean canResume(int i2) {
        return s.ok().n(i2);
    }

    public void cancel(int i2) {
        cancel(i2, true);
    }

    public void clearDownloadData(int i2) {
        s.ok().s(i2, true);
    }

    public void destoryDownloader() {
        bl.ok();
    }

    public void forceDownloadIngoreRecommendSize(int i2) {
        s.ok().rh(i2);
    }

    public List<DownloadInfo> getAllDownloadInfo() {
        return s.ok().n();
    }

    public long getCurBytes(int i2) {
        return s.ok().p(i2);
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int i2) {
        return s.ok().td(i2);
    }

    public int getDownloadId(String str, String str2) {
        return s.ok().ok(str, str2);
    }

    public DownloadInfo getDownloadInfo(int i2) {
        return s.ok().r(i2);
    }

    public List<DownloadInfo> getDownloadInfoList(String str) {
        return s.ok().ok(str);
    }

    public ep getDownloadNotificationEventListener(int i2) {
        return s.ok().j(i2);
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        return s.ok().n(str);
    }

    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        return s.ok().a(str);
    }

    public File getGlobalSaveDir() {
        return getGlobalSaveDir(this.globalDefaultSavePath, true);
    }

    public File getGlobalSaveTempDir() {
        return getGlobalSaveDir(this.globalDefaultSaveTempPath, false);
    }

    public td getReserveWifiStatusListener() {
        return bl.yt();
    }

    public int getStatus(int i2) {
        return s.ok().q(i2);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        return s.ok().bl(str);
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        return s.ok().s(str);
    }

    public boolean isDownloadCacheSyncSuccess() {
        return s.ok().kf();
    }

    public boolean isDownloadServiceForeground(int i2) {
        return s.ok().bl(i2).a();
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return s.ok().ok(downloadInfo);
    }

    public boolean isDownloading(int i2) {
        boolean zK;
        if (!com.ss.android.socialbase.downloader.q.ok.ok(4194304)) {
            return s.ok().k(i2);
        }
        synchronized (this) {
            zK = s.ok().k(i2);
        }
        return zK;
    }

    public boolean isHttpServiceInit() {
        return s.ok().s();
    }

    public void pause(int i2) {
        s.ok().s(i2);
    }

    public void pauseAll() {
        s.ok().bl();
    }

    public void registerDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.r rVar) {
        s.ok().ok(rVar);
    }

    public void registerDownloaderProcessConnectedListener(er erVar) {
        s.ok().ok(erVar);
    }

    public void removeMainThreadListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        s.ok().ok(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.kf.MAIN, false);
    }

    public void removeNotificationListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        s.ok().ok(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.kf.NOTIFICATION, false);
    }

    public void removeSubThreadListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        s.ok().ok(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.kf.SUB, false);
    }

    @Deprecated
    public void removeTaskMainListener(int i2) {
        s.ok().ok(i2, null, com.ss.android.socialbase.downloader.constants.kf.MAIN, true);
    }

    @Deprecated
    public void removeTaskNotificationListener(int i2) {
        s.ok().ok(i2, null, com.ss.android.socialbase.downloader.constants.kf.NOTIFICATION, true);
    }

    @Deprecated
    public void removeTaskSubListener(int i2) {
        s.ok().ok(i2, null, com.ss.android.socialbase.downloader.constants.kf.SUB, true);
    }

    public void restart(int i2) {
        s.ok().h(i2);
    }

    public void restartAllFailedDownloadTasks(List<String> list) {
        s.ok().ok(list);
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        s.ok().a(list);
    }

    public void resume(int i2) {
        s.ok().kf(i2);
    }

    public void setDefaultSavePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSavePath = str;
    }

    public void setDefaultSaveTempPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSaveTempPath = str;
    }

    public void setDownloadInMultiProcess() {
        if (!com.ss.android.socialbase.downloader.q.ok.ok(4194304)) {
            bl.a();
        } else {
            synchronized (this) {
                bl.a();
            }
        }
    }

    public void setDownloadNotificationEventListener(int i2, ep epVar) {
        s.ok().ok(i2, epVar);
    }

    public void setLogLevel(int i2) {
        s.ok().i(i2);
    }

    @Deprecated
    public void setMainThreadListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        s.ok().a(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.kf.MAIN, true);
    }

    @Deprecated
    public void setNotificationListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        s.ok().a(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.kf.NOTIFICATION, true);
    }

    public void setReserveWifiStatusListener(td tdVar) {
        bl.ok(tdVar);
    }

    @Deprecated
    public void setSubThreadListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        s.ok().a(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.kf.SUB, true);
    }

    public void setThrottleNetSpeed(int i2, long j) {
        s.ok().ok(i2, j);
    }

    public void unRegisterDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.r rVar) {
        s.ok().a(rVar);
    }

    public void unRegisterDownloaderProcessConnectedListener(er erVar) {
        s.ok().a(erVar);
    }

    private File getGlobalSaveDir(String str, boolean z) {
        File file;
        File file2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            file = new File(str);
        } catch (Throwable unused) {
        }
        try {
            if (!file.exists()) {
                file.mkdirs();
            } else if (!file.isDirectory()) {
                if (!z) {
                    return null;
                }
                file.delete();
                file.mkdirs();
            }
            return file;
        } catch (Throwable unused2) {
            file2 = file;
            return file2;
        }
    }

    public void cancel(int i2, boolean z) {
        s.ok().bl(i2, z);
    }

    public void clearDownloadData(int i2, boolean z) {
        s.ok().s(i2, z);
    }

    public DownloadInfo getDownloadInfo(String str, String str2) {
        return s.ok().a(str, str2);
    }

    @Deprecated
    public void setMainThreadListener(int i2, IDownloadListener iDownloadListener, boolean z) {
        if (iDownloadListener == null) {
            return;
        }
        s.ok().ok(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.kf.MAIN, true, z);
    }
}
