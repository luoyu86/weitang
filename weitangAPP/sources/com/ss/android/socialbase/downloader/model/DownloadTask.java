package com.ss.android.socialbase.downloader.model;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.kf;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.depend.o;
import com.ss.android.socialbase.downloader.depend.rh;
import com.ss.android.socialbase.downloader.depend.td;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.h;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.downloader.p;
import com.ss.android.socialbase.downloader.downloader.zz;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadTask {
    private boolean autoSetHashCodeForSameTask;
    private h chunkAdjustCalculator;
    private p chunkStrategy;
    private rh depend;
    private td diskSpaceHandler;
    private final List<z> downloadCompleteHandlers;
    private DownloadInfo downloadInfo;
    private DownloadInfo.ok downloadInfoBuilder;
    private IDownloadFileUriProvider fileUriProvider;
    private o forbiddenHandler;
    private int hashCodeForSameTask;
    private IDownloadInterceptor interceptor;
    private final SparseArray<IDownloadListener> mainThreadListeners;
    private y monitorDepend;
    private boolean needDelayForCacheSync;
    private v notificationClickCallback;
    private ep notificationEventListener;
    private final SparseArray<IDownloadListener> notificationListeners;
    private zz retryDelayTimeCalculator;
    private final SparseArray<kf> singleListenerHashCodeMap;
    private final Map<kf, IDownloadListener> singleListenerMap;
    private final SparseArray<IDownloadListener> subThreadListeners;

    public DownloadTask() {
        this.singleListenerMap = new ConcurrentHashMap();
        this.singleListenerHashCodeMap = new SparseArray<>();
        this.needDelayForCacheSync = false;
        this.downloadCompleteHandlers = new ArrayList();
        this.autoSetHashCodeForSameTask = true;
        this.downloadInfoBuilder = new DownloadInfo.ok();
        this.mainThreadListeners = new SparseArray<>();
        this.subThreadListeners = new SparseArray<>();
        this.notificationListeners = new SparseArray<>();
    }

    private void addAll(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iKeyAt = sparseArray.keyAt(i2);
            sparseArray2.put(iKeyAt, sparseArray.get(iKeyAt));
        }
    }

    private void copyListeners(SparseArray<IDownloadListener> sparseArray, SparseArray<IDownloadListener> sparseArray2) {
        sparseArray.clear();
        for (int i2 = 0; i2 < sparseArray2.size(); i2++) {
            int iKeyAt = sparseArray2.keyAt(i2);
            IDownloadListener iDownloadListener = sparseArray2.get(iKeyAt);
            if (iDownloadListener != null) {
                sparseArray.put(iKeyAt, iDownloadListener);
            }
        }
    }

    private void removeAll(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseArray.remove(sparseArray2.keyAt(i2));
        }
    }

    private void setChunkCalculator() {
        if (this.downloadInfo.getThrottleNetSpeed() > 0) {
            chunkStategy(new p() { // from class: com.ss.android.socialbase.downloader.model.DownloadTask.2
                @Override // com.ss.android.socialbase.downloader.downloader.p
                public int ok(long j) {
                    return 1;
                }
            });
        }
    }

    public DownloadTask addDownloadCompleteHandler(z zVar) {
        synchronized (this.downloadCompleteHandlers) {
            if (zVar != null) {
                if (!this.downloadCompleteHandlers.contains(zVar)) {
                    this.downloadCompleteHandlers.add(zVar);
                    return this;
                }
            }
            return this;
        }
    }

    public void addDownloadListener(int i2, IDownloadListener iDownloadListener, kf kfVar, boolean z) {
        Map<kf, IDownloadListener> map;
        if (iDownloadListener == null) {
            return;
        }
        if (z && (map = this.singleListenerMap) != null) {
            map.put(kfVar, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i2, kfVar);
            }
        }
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(kfVar);
        if (downloadListeners == null) {
            return;
        }
        synchronized (downloadListeners) {
            downloadListeners.put(i2, iDownloadListener);
        }
    }

    public void addListenerToDownloadingSameTask() {
        com.ss.android.socialbase.downloader.bl.ok.a("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null && !downloadInfo.isAddListenerToSameTask()) {
            this.downloadInfo.setAddListenerToSameTask(true);
        }
        addListenerToDownloadingSameTask(kf.MAIN);
        addListenerToDownloadingSameTask(kf.SUB);
        com.ss.android.socialbase.downloader.s.ok.ok(this.monitorDepend, this.downloadInfo, new BaseException(1003, "has another same task, add Listener to old task"), 0);
    }

    public DownloadTask addListenerToSameTask(boolean z) {
        this.downloadInfoBuilder.i(z);
        return this;
    }

    public void asyncDownload(final i iVar) {
        com.ss.android.socialbase.downloader.p.s.ok(new Runnable() { // from class: com.ss.android.socialbase.downloader.model.DownloadTask.1
            @Override // java.lang.Runnable
            public void run() {
                int iDownload = DownloadTask.this.download();
                i iVar2 = iVar;
                if (iVar2 != null) {
                    iVar2.ok(iDownload);
                }
            }
        });
    }

    public synchronized int autoCalAndGetHashCodeForSameTask() {
        IDownloadListener singleDownloadListener = getSingleDownloadListener(kf.MAIN);
        if (singleDownloadListener == null) {
            singleDownloadListener = getSingleDownloadListener(kf.SUB);
        }
        if (singleDownloadListener != null) {
            this.hashCodeForSameTask = singleDownloadListener.hashCode();
        }
        return this.hashCodeForSameTask;
    }

    public DownloadTask autoResumed(boolean z) {
        this.downloadInfoBuilder.kf(z);
        return this;
    }

    public DownloadTask autoSetHashCodeForSameTask(boolean z) {
        this.autoSetHashCodeForSameTask = z;
        return this;
    }

    public DownloadTask backUpUrlRetryCount(int i2) {
        this.downloadInfoBuilder.bl(i2);
        return this;
    }

    public DownloadTask backUpUrls(List<String> list) {
        this.downloadInfoBuilder.a(list);
        return this;
    }

    public boolean canShowNotification() {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null) {
            return downloadInfo.canShowNotification();
        }
        return false;
    }

    public DownloadTask chunkAdjustCalculator(h hVar) {
        this.chunkAdjustCalculator = hVar;
        return this;
    }

    public DownloadTask chunkStategy(p pVar) {
        this.chunkStrategy = pVar;
        return this;
    }

    public void copyInterfaceFromNewTask(DownloadTask downloadTask) {
        this.chunkAdjustCalculator = downloadTask.chunkAdjustCalculator;
        this.chunkStrategy = downloadTask.chunkStrategy;
        this.singleListenerMap.clear();
        this.singleListenerMap.putAll(downloadTask.singleListenerMap);
        synchronized (this.mainThreadListeners) {
            this.mainThreadListeners.clear();
            addAll(downloadTask.mainThreadListeners, this.mainThreadListeners);
        }
        synchronized (this.subThreadListeners) {
            this.subThreadListeners.clear();
            addAll(downloadTask.subThreadListeners, this.subThreadListeners);
        }
        synchronized (this.notificationListeners) {
            this.notificationListeners.clear();
            addAll(downloadTask.notificationListeners, this.notificationListeners);
        }
        this.notificationEventListener = downloadTask.notificationEventListener;
        this.interceptor = downloadTask.interceptor;
        this.depend = downloadTask.depend;
        this.monitorDepend = downloadTask.monitorDepend;
        this.forbiddenHandler = downloadTask.forbiddenHandler;
        this.diskSpaceHandler = downloadTask.diskSpaceHandler;
        this.retryDelayTimeCalculator = downloadTask.retryDelayTimeCalculator;
        this.notificationClickCallback = downloadTask.notificationClickCallback;
        this.fileUriProvider = downloadTask.fileUriProvider;
        synchronized (this.downloadCompleteHandlers) {
            this.downloadCompleteHandlers.clear();
            this.downloadCompleteHandlers.addAll(downloadTask.downloadCompleteHandlers);
        }
    }

    public void copyListenerFromPendingTask(DownloadTask downloadTask) {
        for (Map.Entry<kf, IDownloadListener> entry : downloadTask.singleListenerMap.entrySet()) {
            if (entry != null && !this.singleListenerMap.containsKey(entry.getKey())) {
                this.singleListenerMap.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            if (downloadTask.mainThreadListeners.size() != 0) {
                synchronized (this.mainThreadListeners) {
                    removeAll(this.mainThreadListeners, downloadTask.mainThreadListeners);
                    addAll(downloadTask.mainThreadListeners, this.mainThreadListeners);
                }
            }
            if (downloadTask.subThreadListeners.size() != 0) {
                synchronized (this.subThreadListeners) {
                    removeAll(this.subThreadListeners, downloadTask.subThreadListeners);
                    addAll(downloadTask.subThreadListeners, this.subThreadListeners);
                }
            }
            if (downloadTask.notificationListeners.size() != 0) {
                synchronized (this.notificationListeners) {
                    removeAll(this.notificationListeners, downloadTask.notificationListeners);
                    addAll(downloadTask.notificationListeners, this.notificationListeners);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public DownloadTask deleteCacheIfCheckFailed(boolean z) {
        this.downloadInfoBuilder.u(z);
        return this;
    }

    public DownloadTask depend(rh rhVar) {
        this.depend = rhVar;
        return this;
    }

    public DownloadTask diskSpaceHandler(td tdVar) {
        this.diskSpaceHandler = tdVar;
        return this;
    }

    public DownloadTask distinctDirectory(boolean z) {
        this.downloadInfoBuilder.io(z);
        return this;
    }

    public int download() {
        this.downloadInfo = this.downloadInfoBuilder.ok();
        DownloadInfo downloadInfoA = com.ss.android.socialbase.downloader.downloader.bl.m().a(this.downloadInfo.getId());
        if (downloadInfoA == null) {
            this.downloadInfo.generateTaskId();
            com.ss.android.socialbase.downloader.s.ok.ok(this, (BaseException) null, 0);
        } else {
            this.downloadInfo.copyTaskIdFromCacheData(downloadInfoA);
        }
        setChunkCalculator();
        com.ss.android.socialbase.downloader.downloader.s.ok().ok(this);
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo == null) {
            return 0;
        }
        return downloadInfo.getId();
    }

    public DownloadTask downloadSetting(JSONObject jSONObject) {
        this.downloadInfoBuilder.ok(jSONObject);
        return this;
    }

    public DownloadTask enqueueType(EnqueueType enqueueType) {
        this.downloadInfoBuilder.ok(enqueueType);
        return this;
    }

    public DownloadTask executorGroup(int i2) {
        this.downloadInfoBuilder.kf(i2);
        return this;
    }

    public DownloadTask expectFileLength(long j) {
        this.downloadInfoBuilder.ok(j);
        return this;
    }

    public DownloadTask expiredRedownload(boolean z) {
        this.downloadInfoBuilder.zz(z);
        return this;
    }

    public DownloadTask extra(String str) {
        this.downloadInfoBuilder.h(str);
        return this;
    }

    public DownloadTask extraHeaders(List<bl> list) {
        this.downloadInfoBuilder.ok(list);
        return this;
    }

    public DownloadTask extraMonitorStatus(int[] iArr) {
        this.downloadInfoBuilder.a(iArr);
        return this;
    }

    public DownloadTask fileUriProvider(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.fileUriProvider = iDownloadFileUriProvider;
        return this;
    }

    public DownloadTask forbiddenHandler(o oVar) {
        this.forbiddenHandler = oVar;
        return this;
    }

    public DownloadTask force(boolean z) {
        this.downloadInfoBuilder.a(z);
        return this;
    }

    public h getChunkAdjustCalculator() {
        return this.chunkAdjustCalculator;
    }

    public p getChunkStrategy() {
        return this.chunkStrategy;
    }

    public rh getDepend() {
        return this.depend;
    }

    public td getDiskSpaceHandler() {
        return this.diskSpaceHandler;
    }

    public z getDownloadCompleteHandlerByIndex(int i2) {
        synchronized (this.downloadCompleteHandlers) {
            if (i2 >= this.downloadCompleteHandlers.size()) {
                return null;
            }
            return this.downloadCompleteHandlers.get(i2);
        }
    }

    @NonNull
    public List<z> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public int getDownloadId() {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo == null) {
            return 0;
        }
        return downloadInfo.getId();
    }

    public DownloadInfo getDownloadInfo() {
        return this.downloadInfo;
    }

    public IDownloadListener getDownloadListenerByIndex(kf kfVar, int i2) {
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(kfVar);
        if (downloadListeners == null || i2 < 0) {
            return null;
        }
        synchronized (downloadListeners) {
            if (i2 >= downloadListeners.size()) {
                return null;
            }
            return downloadListeners.get(downloadListeners.keyAt(i2));
        }
    }

    public int getDownloadListenerSize(kf kfVar) {
        int size;
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(kfVar);
        if (downloadListeners == null) {
            return 0;
        }
        synchronized (downloadListeners) {
            size = downloadListeners.size();
        }
        return size;
    }

    public SparseArray<IDownloadListener> getDownloadListeners(kf kfVar) {
        if (kfVar == kf.MAIN) {
            return this.mainThreadListeners;
        }
        if (kfVar == kf.SUB) {
            return this.subThreadListeners;
        }
        if (kfVar == kf.NOTIFICATION) {
            return this.notificationListeners;
        }
        return null;
    }

    public IDownloadFileUriProvider getFileUriProvider() {
        return this.fileUriProvider;
    }

    public o getForbiddenHandler() {
        return this.forbiddenHandler;
    }

    public int getHashCodeForSameTask() {
        return this.hashCodeForSameTask;
    }

    public IDownloadInterceptor getInterceptor() {
        return this.interceptor;
    }

    public y getMonitorDepend() {
        return this.monitorDepend;
    }

    public v getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public ep getNotificationEventListener() {
        return this.notificationEventListener;
    }

    public zz getRetryDelayTimeCalculator() {
        return this.retryDelayTimeCalculator;
    }

    public IDownloadListener getSingleDownloadListener(kf kfVar) {
        return this.singleListenerMap.get(kfVar);
    }

    public DownloadTask hashCodeForSameTask(int i2) {
        this.hashCodeForSameTask = i2;
        return this;
    }

    public DownloadTask headConnectionAvailable(boolean z) {
        this.downloadInfoBuilder.z(z);
        return this;
    }

    public DownloadTask iconUrl(String str) {
        this.downloadInfoBuilder.z(str);
        return this;
    }

    public DownloadTask ignoreDataVerify(boolean z) {
        this.downloadInfoBuilder.rh(z);
        return this;
    }

    public DownloadTask interceptor(IDownloadInterceptor iDownloadInterceptor) {
        this.interceptor = iDownloadInterceptor;
        return this;
    }

    public boolean isAutoSetHashCodeForSameTask() {
        return this.autoSetHashCodeForSameTask;
    }

    public boolean isNeedDelayForCacheSync() {
        return this.needDelayForCacheSync;
    }

    public DownloadTask isOpenLimitSpeed(boolean z) {
        this.downloadInfoBuilder.td(z);
        return this;
    }

    public DownloadTask mainThreadListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : mainThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask mainThreadListenerWithHashCode(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.mainThreadListeners) {
                this.mainThreadListeners.put(i2, iDownloadListener);
            }
            Map<kf, IDownloadListener> map = this.singleListenerMap;
            kf kfVar = kf.MAIN;
            map.put(kfVar, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i2, kfVar);
            }
        }
        return this;
    }

    public DownloadTask maxBytes(int i2) {
        this.downloadInfoBuilder.ok(i2);
        return this;
    }

    public DownloadTask maxProgressCount(int i2) {
        this.downloadInfoBuilder.s(i2);
        return this;
    }

    public DownloadTask md5(String str) {
        this.downloadInfoBuilder.k(str);
        return this;
    }

    public DownloadTask mimeType(String str) {
        this.downloadInfoBuilder.p(str);
        return this;
    }

    public DownloadTask minProgressTimeMsInterval(int i2) {
        this.downloadInfoBuilder.n(i2);
        return this;
    }

    public DownloadTask monitorDepend(y yVar) {
        this.monitorDepend = yVar;
        return this;
    }

    public DownloadTask monitorScene(String str) {
        this.downloadInfoBuilder.j(str);
        return this;
    }

    public DownloadTask name(String str) {
        this.downloadInfoBuilder.ok(str);
        return this;
    }

    public DownloadTask needChunkDowngradeRetry(boolean z) {
        this.downloadInfoBuilder.t(z);
        return this;
    }

    public DownloadTask needDefaultHttpServiceBackUp(boolean z) {
        this.downloadInfoBuilder.p(z);
        return this;
    }

    public DownloadTask needHttpsToHttpRetry(boolean z) {
        this.downloadInfoBuilder.s(z);
        return this;
    }

    public DownloadTask needIndependentProcess(boolean z) {
        this.downloadInfoBuilder.j(z);
        return this;
    }

    public DownloadTask needPostProgress(boolean z) {
        this.downloadInfoBuilder.bl(z);
        return this;
    }

    public DownloadTask needRetryDelay(boolean z) {
        this.downloadInfoBuilder.k(z);
        return this;
    }

    public DownloadTask needReuseChunkRunnable(boolean z) {
        this.downloadInfoBuilder.q(z);
        return this;
    }

    public DownloadTask needReuseFirstConnection(boolean z) {
        this.downloadInfoBuilder.r(z);
        return this;
    }

    public DownloadTask needSDKMonitor(boolean z) {
        this.downloadInfoBuilder.x(z);
        return this;
    }

    @Deprecated
    public DownloadTask newSaveTempFileEnable(boolean z) {
        return this;
    }

    public DownloadTask notificationClickCallback(v vVar) {
        this.notificationClickCallback = vVar;
        return this;
    }

    public DownloadTask notificationEventListener(ep epVar) {
        this.notificationEventListener = epVar;
        return this;
    }

    public DownloadTask notificationListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : notificationListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask notificationListenerWithHashCode(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.notificationListeners) {
                this.notificationListeners.put(i2, iDownloadListener);
            }
            Map<kf, IDownloadListener> map = this.singleListenerMap;
            kf kfVar = kf.NOTIFICATION;
            map.put(kfVar, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i2, kfVar);
            }
        }
        return this;
    }

    public DownloadTask onlyWifi(boolean z) {
        this.downloadInfoBuilder.ok(z);
        return this;
    }

    public DownloadTask outIp(String[] strArr) {
        this.downloadInfoBuilder.ok(strArr);
        return this;
    }

    public DownloadTask outSize(int[] iArr) {
        this.downloadInfoBuilder.ok(iArr);
        return this;
    }

    public DownloadTask packageName(String str) {
        this.downloadInfoBuilder.q(str);
        return this;
    }

    public void removeDownloadListener(int i2, IDownloadListener iDownloadListener, kf kfVar, boolean z) {
        int iIndexOfValue;
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(kfVar);
        if (downloadListeners == null) {
            if (z && this.singleListenerMap.containsKey(kfVar)) {
                this.singleListenerMap.remove(kfVar);
                return;
            }
            return;
        }
        synchronized (downloadListeners) {
            if (z) {
                if (this.singleListenerMap.containsKey(kfVar)) {
                    iDownloadListener = this.singleListenerMap.get(kfVar);
                    this.singleListenerMap.remove(kfVar);
                }
                if (iDownloadListener != null && (iIndexOfValue = downloadListeners.indexOfValue(iDownloadListener)) >= 0 && iIndexOfValue < downloadListeners.size()) {
                    downloadListeners.removeAt(iIndexOfValue);
                }
            } else {
                downloadListeners.remove(i2);
                synchronized (this.singleListenerHashCodeMap) {
                    kf kfVar2 = this.singleListenerHashCodeMap.get(i2);
                    if (kfVar2 != null && this.singleListenerMap.containsKey(kfVar2)) {
                        this.singleListenerMap.remove(kfVar2);
                        this.singleListenerHashCodeMap.remove(i2);
                    }
                }
            }
        }
    }

    public DownloadTask retryCount(int i2) {
        this.downloadInfoBuilder.a(i2);
        return this;
    }

    public DownloadTask retryDelayTimeArray(String str) {
        this.downloadInfoBuilder.r(str);
        return this;
    }

    public DownloadTask retryDelayTimeCalculator(zz zzVar) {
        this.retryDelayTimeCalculator = zzVar;
        return this;
    }

    public DownloadTask savePath(String str) {
        this.downloadInfoBuilder.n(str);
        return this;
    }

    public DownloadTask setAutoInstall(boolean z) {
        this.downloadInfoBuilder.ul(z);
        return this;
    }

    public DownloadTask setDownloadCompleteHandlers(List<z> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<z> it = list.iterator();
            while (it.hasNext()) {
                addDownloadCompleteHandler(it.next());
            }
        }
        return this;
    }

    public void setDownloadListeners(SparseArray<IDownloadListener> sparseArray, kf kfVar) {
        if (sparseArray == null) {
            return;
        }
        try {
            if (kfVar == kf.MAIN) {
                synchronized (this.mainThreadListeners) {
                    copyListeners(this.mainThreadListeners, sparseArray);
                }
                return;
            } else if (kfVar == kf.SUB) {
                synchronized (this.subThreadListeners) {
                    copyListeners(this.subThreadListeners, sparseArray);
                }
                return;
            } else {
                if (kfVar == kf.NOTIFICATION) {
                    synchronized (this.notificationListeners) {
                        copyListeners(this.notificationListeners, sparseArray);
                    }
                    return;
                }
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        th.printStackTrace();
    }

    public void setNeedDelayForCacheSync(boolean z) {
        this.needDelayForCacheSync = z;
    }

    public void setNotificationEventListener(ep epVar) {
        this.notificationEventListener = epVar;
    }

    public DownloadTask showNotification(boolean z) {
        this.downloadInfoBuilder.n(z);
        return this;
    }

    public DownloadTask showNotificationForAutoResumed(boolean z) {
        this.downloadInfoBuilder.h(z);
        return this;
    }

    public DownloadTask subThreadListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : subThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask subThreadListenerWithHashCode(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.subThreadListeners) {
                this.subThreadListeners.put(i2, iDownloadListener);
            }
            Map<kf, IDownloadListener> map = this.singleListenerMap;
            kf kfVar = kf.SUB;
            map.put(kfVar, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i2, kfVar);
            }
        }
        return this;
    }

    public DownloadTask taskKey(String str) {
        this.downloadInfoBuilder.s(str);
        return this;
    }

    public DownloadTask tempPath(String str) {
        this.downloadInfoBuilder.kf(str);
        return this;
    }

    public DownloadTask throttleNetSpeed(long j) {
        this.downloadInfoBuilder.a(j);
        return this;
    }

    public DownloadTask title(String str) {
        this.downloadInfoBuilder.a(str);
        return this;
    }

    public DownloadTask ttnetProtectTimeout(long j) {
        this.downloadInfoBuilder.bl(j);
        return this;
    }

    public DownloadTask url(String str) {
        this.downloadInfoBuilder.bl(str);
        return this;
    }

    private void addListenerToDownloadingSameTask(kf kfVar) {
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(kfVar);
        synchronized (downloadListeners) {
            for (int i2 = 0; i2 < downloadListeners.size(); i2++) {
                IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i2));
                if (iDownloadListener != null) {
                    com.ss.android.socialbase.downloader.downloader.s.ok().a(getDownloadId(), iDownloadListener, kfVar, false);
                }
            }
        }
    }

    public DownloadTask(DownloadInfo downloadInfo) {
        this();
        this.downloadInfo = downloadInfo;
    }
}
