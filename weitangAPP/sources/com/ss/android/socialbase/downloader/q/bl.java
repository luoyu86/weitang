package com.ss.android.socialbase.downloader.q;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.zz;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public class bl {
    public static void ok(int i2, SparseArray<IDownloadListener> sparseArray, boolean z, DownloadInfo downloadInfo, BaseException baseException) {
        SparseArray<IDownloadListener> sparseArrayClone;
        if (!z || sparseArray == null) {
            return;
        }
        try {
            if (sparseArray.size() <= 0) {
                return;
            }
            synchronized (sparseArray) {
                sparseArrayClone = sparseArray.clone();
            }
            for (int i3 = 0; i3 < sparseArrayClone.size(); i3++) {
                IDownloadListener iDownloadListener = sparseArrayClone.get(sparseArrayClone.keyAt(i3));
                if (iDownloadListener != null) {
                    if (i2 == 1) {
                        iDownloadListener.onPrepare(downloadInfo);
                    } else if (i2 == 2) {
                        iDownloadListener.onStart(downloadInfo);
                    } else if (i2 == 4) {
                        iDownloadListener.onProgress(downloadInfo);
                    } else if (i2 == 5) {
                        iDownloadListener.onRetry(downloadInfo, baseException);
                    } else if (i2 == 6) {
                        iDownloadListener.onFirstStart(downloadInfo);
                    } else if (i2 == 7) {
                        iDownloadListener.onRetryDelay(downloadInfo, baseException);
                    } else if (i2 != 11) {
                        switch (i2) {
                            case -7:
                                if (iDownloadListener instanceof AbsDownloadListener) {
                                    ((AbsDownloadListener) iDownloadListener).onIntercept(downloadInfo);
                                }
                                break;
                            case -6:
                                iDownloadListener.onFirstSuccess(downloadInfo);
                                break;
                            case -5:
                            case -2:
                                iDownloadListener.onPause(downloadInfo);
                                break;
                            case -4:
                                iDownloadListener.onCanceled(downloadInfo);
                                break;
                            case -3:
                                iDownloadListener.onSuccessed(downloadInfo);
                                break;
                            case -1:
                                iDownloadListener.onFailed(downloadInfo, baseException);
                                break;
                        }
                    } else if (iDownloadListener instanceof zz) {
                        ((zz) iDownloadListener).ok(downloadInfo);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
