package com.ss.android.downloadlib.addownload.bl;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class s {
    private static volatile s ok;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9785a = 0;
    private ConcurrentHashMap<String, n> bl = new ConcurrentHashMap<>();
    private HashMap<String, Integer> s = new HashMap<>();
    private List<String> n = new CopyOnWriteArrayList();

    public static s ok() {
        if (ok == null) {
            synchronized (s.class) {
                if (ok == null) {
                    ok = new s();
                }
            }
        }
        return ok;
    }

    public long a() {
        return this.f9785a;
    }

    public void bl() {
        this.f9785a = System.currentTimeMillis();
    }

    public int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.s == null) {
            this.s = new HashMap<>();
        }
        if (this.s.containsKey(str)) {
            return this.s.get(str).intValue();
        }
        return 0;
    }

    public void ok(String str, n nVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.bl.put(str, nVar);
    }

    public void ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.bl.remove(str);
    }

    @WorkerThread
    public static void ok(com.ss.android.downloadad.api.ok.a aVar) {
        DownloadInfo downloadInfo;
        if (aVar == null || aVar.a() <= 0 || (downloadInfo = Downloader.getInstance(r.getContext()).getDownloadInfo(aVar.zz())) == null) {
            return;
        }
        ok(downloadInfo);
    }

    @WorkerThread
    public static void ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null || com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("delete_file_after_install", 0) == 0) {
            return;
        }
        try {
            String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
