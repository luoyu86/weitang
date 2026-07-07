package com.ss.android.socialbase.downloader.q;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.e;
import com.ss.android.socialbase.downloader.depend.em;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.h;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.io;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.k;
import com.ss.android.socialbase.downloader.depend.kf;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.o;
import com.ss.android.socialbase.downloader.depend.p;
import com.ss.android.socialbase.downloader.depend.q;
import com.ss.android.socialbase.downloader.depend.rh;
import com.ss.android.socialbase.downloader.depend.sg;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.depend.td;
import com.ss.android.socialbase.downloader.depend.u;
import com.ss.android.socialbase.downloader.depend.ul;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.depend.zz;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.ok;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    private static Handler ok = new Handler(Looper.getMainLooper());

    public static com.ss.android.socialbase.downloader.model.ok ok(final DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        return new ok.AbstractBinderC0169ok() { // from class: com.ss.android.socialbase.downloader.q.h.1
            @Override // com.ss.android.socialbase.downloader.model.ok
            public com.ss.android.socialbase.downloader.depend.n a() throws RemoteException {
                return h.ok(downloadTask.getChunkStrategy());
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public m bl() throws RemoteException {
                return h.ok(downloadTask.getNotificationEventListener());
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public io h() throws RemoteException {
                return h.ok(downloadTask.getForbiddenHandler());
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public int j() throws RemoteException {
                return downloadTask.getDownloadCompleteHandlers().size();
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public com.ss.android.socialbase.downloader.depend.k k() throws RemoteException {
                return h.ok(downloadTask.getMonitorDepend());
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public com.ss.android.socialbase.downloader.depend.kf kf() throws RemoteException {
                return h.ok(downloadTask.getDepend());
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public com.ss.android.socialbase.downloader.depend.p n() throws RemoteException {
                return h.ok(downloadTask.getInterceptor());
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public DownloadInfo ok() throws RemoteException {
                return downloadTask.getDownloadInfo();
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public e p() throws RemoteException {
                return h.ok(downloadTask.getRetryDelayTimeCalculator());
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public i q() throws RemoteException {
                return h.ok(downloadTask.getDiskSpaceHandler());
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public com.ss.android.socialbase.downloader.depend.h r() throws RemoteException {
                return h.ok(downloadTask.getFileUriProvider());
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public g s() throws RemoteException {
                return h.ok(downloadTask.getNotificationClickCallback());
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public com.ss.android.socialbase.downloader.depend.q a(int i2) throws RemoteException {
                return h.ok(downloadTask.getSingleDownloadListener(kf.n(i2)), i2 != com.ss.android.socialbase.downloader.constants.kf.SUB.ordinal());
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public j bl(int i2) throws RemoteException {
                return h.ok(downloadTask.getDownloadCompleteHandlerByIndex(i2));
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public int ok(int i2) throws RemoteException {
                return downloadTask.getDownloadListenerSize(kf.n(i2));
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public com.ss.android.socialbase.downloader.depend.q ok(int i2, int i3) throws RemoteException {
                return h.ok(downloadTask.getDownloadListenerByIndex(kf.n(i2), i3), i2 != com.ss.android.socialbase.downloader.constants.kf.SUB.ordinal());
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.q ok(final IDownloadListener iDownloadListener, final boolean z) {
        if (iDownloadListener == null) {
            return null;
        }
        return new q.ok() { // from class: com.ss.android.socialbase.downloader.q.h.12
            @Override // com.ss.android.socialbase.downloader.depend.q
            public void a(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.5
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onStart(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onStart(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public void bl(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.6
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onProgress(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onProgress(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public void h(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.11
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFirstStart(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onFirstStart(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public void kf(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.10
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onCanceled(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onCanceled(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public void n(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.8
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onSuccessed(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onSuccessed(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public int ok() throws RemoteException {
                return iDownloadListener.hashCode();
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public void p(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.12
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFirstSuccess(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onFirstSuccess(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public void q(final DownloadInfo downloadInfo) throws RemoteException {
                IDownloadListener iDownloadListener2 = iDownloadListener;
                if (iDownloadListener2 instanceof zz) {
                    if (z) {
                        h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.4
                            @Override // java.lang.Runnable
                            public void run() {
                                ((zz) iDownloadListener).ok(downloadInfo);
                            }
                        });
                    } else {
                        ((zz) iDownloadListener2).ok(downloadInfo);
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public void s(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.7
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onPause(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onPause(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public void ok(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onPrepare(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onPrepare(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public void a(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.2
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onRetry(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onRetry(downloadInfo, baseException);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public void bl(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.3
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onRetryDelay(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onRetryDelay(downloadInfo, baseException);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public void ok(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.9
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFailed(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onFailed(downloadInfo, baseException);
                }
            }
        };
    }

    public static m ok(final ep epVar) {
        if (epVar == null) {
            return null;
        }
        return new m.ok() { // from class: com.ss.android.socialbase.downloader.q.h.23
            @Override // com.ss.android.socialbase.downloader.depend.m
            public void ok(int i2, DownloadInfo downloadInfo, String str, String str2) throws RemoteException {
                epVar.ok(i2, downloadInfo, str, str2);
            }

            @Override // com.ss.android.socialbase.downloader.depend.m
            public boolean ok(boolean z) throws RemoteException {
                return epVar.ok(z);
            }

            @Override // com.ss.android.socialbase.downloader.depend.m
            public String ok() throws RemoteException {
                return epVar.ok();
            }
        };
    }

    public static g ok(final v vVar) {
        if (vVar == null) {
            return null;
        }
        return new g.ok() { // from class: com.ss.android.socialbase.downloader.q.h.26
            @Override // com.ss.android.socialbase.downloader.depend.g
            public boolean a(DownloadInfo downloadInfo) throws RemoteException {
                return vVar.a(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.g
            public boolean bl(DownloadInfo downloadInfo) throws RemoteException {
                return vVar.bl(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.g
            public boolean ok(DownloadInfo downloadInfo) throws RemoteException {
                return vVar.ok(downloadInfo);
            }
        };
    }

    public static e ok(final com.ss.android.socialbase.downloader.downloader.zz zzVar) {
        if (zzVar == null) {
            return null;
        }
        return new e.ok() { // from class: com.ss.android.socialbase.downloader.q.h.27
            @Override // com.ss.android.socialbase.downloader.depend.e
            public long ok(int i2, int i3) throws RemoteException {
                return zzVar.ok(i2, i3);
            }
        };
    }

    public static io ok(final o oVar) {
        if (oVar == null) {
            return null;
        }
        return new io.ok() { // from class: com.ss.android.socialbase.downloader.q.h.28
            @Override // com.ss.android.socialbase.downloader.depend.io
            public boolean ok(u uVar) throws RemoteException {
                return oVar.ok(h.ok(uVar));
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.h ok(final IDownloadFileUriProvider iDownloadFileUriProvider) {
        if (iDownloadFileUriProvider == null) {
            return null;
        }
        return new h.ok() { // from class: com.ss.android.socialbase.downloader.q.h.29
            @Override // com.ss.android.socialbase.downloader.depend.h
            public Uri ok(String str, String str2) throws RemoteException {
                return iDownloadFileUriProvider.getUriForFile(str, str2);
            }
        };
    }

    public static ul ok(final u uVar) {
        if (uVar == null) {
            return null;
        }
        return new ul() { // from class: com.ss.android.socialbase.downloader.q.h.30
            @Override // com.ss.android.socialbase.downloader.depend.ul
            public void ok(List<String> list) {
                try {
                    uVar.ok(list);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ul
            public boolean ok() {
                try {
                    return uVar.ok();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static i ok(final td tdVar) {
        if (tdVar == null) {
            return null;
        }
        return new i.ok() { // from class: com.ss.android.socialbase.downloader.q.h.31
            @Override // com.ss.android.socialbase.downloader.depend.i
            public boolean ok(long j, long j2, t tVar) throws RemoteException {
                return tdVar.ok(j, j2, h.ok(tVar));
            }
        };
    }

    public static x ok(final t tVar) {
        if (tVar == null) {
            return null;
        }
        return new x() { // from class: com.ss.android.socialbase.downloader.q.h.2
            @Override // com.ss.android.socialbase.downloader.depend.x
            public void ok() {
                try {
                    tVar.ok();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.kf ok(final rh rhVar) {
        if (rhVar == null) {
            return null;
        }
        return new kf.ok() { // from class: com.ss.android.socialbase.downloader.q.h.3
            @Override // com.ss.android.socialbase.downloader.depend.kf
            public void ok(DownloadInfo downloadInfo, BaseException baseException, int i2) throws RemoteException {
                rhVar.ok(downloadInfo, baseException, i2);
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.k ok(final y yVar) {
        if (yVar == null) {
            return null;
        }
        return new k.ok() { // from class: com.ss.android.socialbase.downloader.q.h.4
            @Override // com.ss.android.socialbase.downloader.depend.k
            public int[] a() throws RemoteException {
                y yVar2 = yVar;
                if (yVar2 instanceof com.ss.android.socialbase.downloader.depend.bl) {
                    return ((com.ss.android.socialbase.downloader.depend.bl) yVar2).ok();
                }
                return null;
            }

            @Override // com.ss.android.socialbase.downloader.depend.k
            public void ok(String str) throws RemoteException {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    yVar.ok(new JSONObject(str));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.k
            public String ok() throws RemoteException {
                return yVar.a();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.n ok(final com.ss.android.socialbase.downloader.downloader.p pVar) {
        if (pVar == null) {
            return null;
        }
        return new n.ok() { // from class: com.ss.android.socialbase.downloader.q.h.5
            @Override // com.ss.android.socialbase.downloader.depend.n
            public int ok(long j) throws RemoteException {
                return pVar.ok(j);
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.p ok(final IDownloadInterceptor iDownloadInterceptor) {
        if (iDownloadInterceptor == null) {
            return null;
        }
        return new p.ok() { // from class: com.ss.android.socialbase.downloader.q.h.6
            @Override // com.ss.android.socialbase.downloader.depend.p
            public boolean ok() throws RemoteException {
                return iDownloadInterceptor.intercepte();
            }
        };
    }

    public static DownloadTask ok(com.ss.android.socialbase.downloader.model.ok okVar) {
        if (okVar == null) {
            return null;
        }
        try {
            DownloadTask downloadTask = new DownloadTask(okVar.ok());
            downloadTask.chunkStategy(ok(okVar.a())).notificationEventListener(ok(okVar.bl())).interceptor(ok(okVar.n())).depend(ok(okVar.kf())).monitorDepend(ok(okVar.k())).forbiddenHandler(ok(okVar.h())).diskSpaceHandler(ok(okVar.q())).fileUriProvider(ok(okVar.r())).notificationClickCallback(ok(okVar.s())).retryDelayTimeCalculator(ok(okVar.p()));
            com.ss.android.socialbase.downloader.constants.kf kfVar = com.ss.android.socialbase.downloader.constants.kf.MAIN;
            com.ss.android.socialbase.downloader.depend.q qVarA = okVar.a(kfVar.ordinal());
            if (qVarA != null) {
                downloadTask.mainThreadListenerWithHashCode(qVarA.hashCode(), ok(qVarA));
            }
            com.ss.android.socialbase.downloader.constants.kf kfVar2 = com.ss.android.socialbase.downloader.constants.kf.SUB;
            com.ss.android.socialbase.downloader.depend.q qVarA2 = okVar.a(kfVar2.ordinal());
            if (qVarA2 != null) {
                downloadTask.subThreadListenerWithHashCode(qVarA2.hashCode(), ok(qVarA2));
            }
            com.ss.android.socialbase.downloader.constants.kf kfVar3 = com.ss.android.socialbase.downloader.constants.kf.NOTIFICATION;
            com.ss.android.socialbase.downloader.depend.q qVarA3 = okVar.a(kfVar3.ordinal());
            if (qVarA3 != null) {
                downloadTask.notificationListenerWithHashCode(qVarA3.hashCode(), ok(qVarA3));
            }
            ok(downloadTask, okVar, kfVar);
            ok(downloadTask, okVar, kfVar2);
            ok(downloadTask, okVar, kfVar3);
            ok(downloadTask, okVar);
            return downloadTask;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static void ok(DownloadTask downloadTask, com.ss.android.socialbase.downloader.model.ok okVar, com.ss.android.socialbase.downloader.constants.kf kfVar) throws RemoteException {
        SparseArray<IDownloadListener> sparseArray = new SparseArray<>();
        for (int i2 = 0; i2 < okVar.ok(kfVar.ordinal()); i2++) {
            com.ss.android.socialbase.downloader.depend.q qVarOk = okVar.ok(kfVar.ordinal(), i2);
            if (qVarOk != null) {
                sparseArray.put(qVarOk.ok(), ok(qVarOk));
            }
        }
        downloadTask.setDownloadListeners(sparseArray, kfVar);
    }

    private static void ok(DownloadTask downloadTask, com.ss.android.socialbase.downloader.model.ok okVar) throws RemoteException {
        for (int i2 = 0; i2 < okVar.j(); i2++) {
            j jVarBl = okVar.bl(i2);
            if (jVarBl != null) {
                downloadTask.addDownloadCompleteHandler(ok(jVarBl));
            }
        }
    }

    public static ep ok(final m mVar) {
        if (mVar == null) {
            return null;
        }
        return new ep() { // from class: com.ss.android.socialbase.downloader.q.h.7
            @Override // com.ss.android.socialbase.downloader.depend.ep
            public void ok(int i2, DownloadInfo downloadInfo, String str, String str2) {
                try {
                    mVar.ok(i2, downloadInfo, str, str2);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ep
            public boolean ok(boolean z) {
                try {
                    return mVar.ok(z);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ep
            public String ok() {
                try {
                    return mVar.ok();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        };
    }

    public static z ok(final j jVar) {
        if (jVar == null) {
            return null;
        }
        return new z() { // from class: com.ss.android.socialbase.downloader.q.h.8
            @Override // com.ss.android.socialbase.downloader.depend.z
            public boolean a(DownloadInfo downloadInfo) {
                try {
                    return jVar.a(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public void ok(DownloadInfo downloadInfo) throws BaseException {
                try {
                    jVar.ok(downloadInfo);
                } catch (RemoteException e2) {
                    throw new BaseException(PointerIconCompat.TYPE_TEXT, e2);
                }
            }
        };
    }

    public static j ok(final z zVar) {
        if (zVar == null) {
            return null;
        }
        return new j.ok() { // from class: com.ss.android.socialbase.downloader.q.h.9
            @Override // com.ss.android.socialbase.downloader.depend.j
            public boolean a(DownloadInfo downloadInfo) throws RemoteException {
                return zVar.a(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.j
            public void ok(DownloadInfo downloadInfo) throws RemoteException {
                try {
                    zVar.ok(downloadInfo);
                } catch (BaseException e2) {
                    throw new IllegalArgumentException(e2);
                }
            }
        };
    }

    public static v ok(final g gVar) {
        if (gVar == null) {
            return null;
        }
        return new v() { // from class: com.ss.android.socialbase.downloader.q.h.10
            @Override // com.ss.android.socialbase.downloader.depend.v
            public boolean a(DownloadInfo downloadInfo) {
                try {
                    return gVar.a(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.v
            public boolean bl(DownloadInfo downloadInfo) {
                try {
                    return gVar.bl(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.v
            public boolean ok(DownloadInfo downloadInfo) {
                try {
                    return gVar.ok(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.p ok(final com.ss.android.socialbase.downloader.depend.n nVar) {
        if (nVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.p() { // from class: com.ss.android.socialbase.downloader.q.h.11
            @Override // com.ss.android.socialbase.downloader.downloader.p
            public int ok(long j) {
                try {
                    return nVar.ok(j);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return 0;
                }
            }
        };
    }

    public static rh ok(final com.ss.android.socialbase.downloader.depend.kf kfVar) {
        if (kfVar == null) {
            return null;
        }
        return new rh() { // from class: com.ss.android.socialbase.downloader.q.h.13
            @Override // com.ss.android.socialbase.downloader.depend.rh
            public void ok(DownloadInfo downloadInfo, BaseException baseException, int i2) {
                if (downloadInfo == null) {
                    return;
                }
                try {
                    kfVar.ok(downloadInfo, baseException, i2);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        };
    }

    public static y ok(final com.ss.android.socialbase.downloader.depend.k kVar) {
        if (kVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.depend.bl() { // from class: com.ss.android.socialbase.downloader.q.h.14
            @Override // com.ss.android.socialbase.downloader.depend.y
            public String a() {
                try {
                    return kVar.ok();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return "";
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.y
            public void ok(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                try {
                    kVar.ok(jSONObject.toString());
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.bl
            public int[] ok() {
                try {
                    return kVar.a();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        };
    }

    public static o ok(final io ioVar) {
        if (ioVar == null) {
            return null;
        }
        return new o() { // from class: com.ss.android.socialbase.downloader.q.h.15
            @Override // com.ss.android.socialbase.downloader.depend.o
            public boolean ok(ul ulVar) {
                try {
                    return ioVar.ok(h.ok(ulVar));
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static u ok(final ul ulVar) {
        if (ulVar == null) {
            return null;
        }
        return new u.ok() { // from class: com.ss.android.socialbase.downloader.q.h.16
            @Override // com.ss.android.socialbase.downloader.depend.u
            public void ok(List<String> list) {
                ulVar.ok(list);
            }

            @Override // com.ss.android.socialbase.downloader.depend.u
            public boolean ok() {
                return ulVar.ok();
            }
        };
    }

    public static em ok(final sg sgVar) {
        if (sgVar == null) {
            return null;
        }
        return new em.ok() { // from class: com.ss.android.socialbase.downloader.q.h.17
            @Override // com.ss.android.socialbase.downloader.depend.em
            public void ok(int i2, int i3) {
                sgVar.ok(i2, i3);
            }
        };
    }

    public static sg ok(final em emVar) {
        if (emVar == null) {
            return null;
        }
        return new sg() { // from class: com.ss.android.socialbase.downloader.q.h.18
            @Override // com.ss.android.socialbase.downloader.depend.sg
            public void ok(int i2, int i3) {
                try {
                    emVar.ok(i2, i3);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        };
    }

    public static td ok(final i iVar) {
        if (iVar == null) {
            return null;
        }
        return new td() { // from class: com.ss.android.socialbase.downloader.q.h.19
            @Override // com.ss.android.socialbase.downloader.depend.td
            public boolean ok(long j, long j2, x xVar) {
                try {
                    return iVar.ok(j, j2, h.ok(xVar));
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static t ok(final x xVar) {
        if (xVar == null) {
            return null;
        }
        return new t.ok() { // from class: com.ss.android.socialbase.downloader.q.h.20
            @Override // com.ss.android.socialbase.downloader.depend.t
            public void ok() throws RemoteException {
                xVar.ok();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.zz ok(final e eVar) {
        if (eVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.zz() { // from class: com.ss.android.socialbase.downloader.q.h.21
            @Override // com.ss.android.socialbase.downloader.downloader.zz
            public long ok(int i2, int i3) {
                try {
                    return eVar.ok(i2, i3);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return 0L;
                }
            }
        };
    }

    public static IDownloadInterceptor ok(final com.ss.android.socialbase.downloader.depend.p pVar) {
        if (pVar == null) {
            return null;
        }
        return new IDownloadInterceptor() { // from class: com.ss.android.socialbase.downloader.q.h.22
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadInterceptor
            public boolean intercepte() {
                try {
                    return pVar.ok();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static IDownloadFileUriProvider ok(final com.ss.android.socialbase.downloader.depend.h hVar) {
        if (hVar == null) {
            return null;
        }
        return new IDownloadFileUriProvider() { // from class: com.ss.android.socialbase.downloader.q.h.24
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str, String str2) {
                try {
                    return hVar.ok(str, str2);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        };
    }

    public static IDownloadListener ok(final com.ss.android.socialbase.downloader.depend.q qVar) {
        if (qVar == null) {
            return null;
        }
        return new zz() { // from class: com.ss.android.socialbase.downloader.q.h.25
            @Override // com.ss.android.socialbase.downloader.depend.zz
            public void ok(DownloadInfo downloadInfo) {
                try {
                    qVar.q(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onCanceled(DownloadInfo downloadInfo) {
                try {
                    qVar.kf(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    qVar.ok(downloadInfo, baseException);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstStart(DownloadInfo downloadInfo) {
                try {
                    qVar.h(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstSuccess(DownloadInfo downloadInfo) {
                try {
                    qVar.p(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPause(DownloadInfo downloadInfo) {
                try {
                    qVar.s(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPrepare(DownloadInfo downloadInfo) {
                try {
                    qVar.ok(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onProgress(DownloadInfo downloadInfo) {
                try {
                    qVar.bl(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    qVar.a(downloadInfo, baseException);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    qVar.bl(downloadInfo, baseException);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onStart(DownloadInfo downloadInfo) {
                try {
                    qVar.a(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onSuccessed(DownloadInfo downloadInfo) {
                try {
                    qVar.n(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        };
    }
}
