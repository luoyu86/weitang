package com.ss.android.downloadlib.addownload.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class kf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Long, DownloadModel> f9774a;
    private final ConcurrentHashMap<Long, DownloadEventConfig> bl;
    private final ConcurrentHashMap<Long, com.ss.android.downloadad.api.ok.a> n;
    private volatile boolean ok;
    private final ConcurrentHashMap<Long, DownloadController> s;

    public static class ok {
        private static kf ok = new kf();
    }

    public DownloadController bl(long j) {
        return this.s.get(Long.valueOf(j));
    }

    public void kf(long j) {
        this.f9774a.remove(Long.valueOf(j));
        this.bl.remove(Long.valueOf(j));
        this.s.remove(Long.valueOf(j));
    }

    @NonNull
    public n n(long j) {
        n nVar = new n();
        nVar.ok = j;
        nVar.f9775a = ok(j);
        DownloadEventConfig downloadEventConfigA = a(j);
        nVar.bl = downloadEventConfigA;
        if (downloadEventConfigA == null) {
            nVar.bl = new com.ss.android.download.api.download.bl();
        }
        DownloadController downloadControllerBl = bl(j);
        nVar.s = downloadControllerBl;
        if (downloadControllerBl == null) {
            nVar.s = new com.ss.android.download.api.download.a();
        }
        return nVar;
    }

    public com.ss.android.downloadad.api.ok.a s(long j) {
        return this.n.get(Long.valueOf(j));
    }

    private kf() {
        this.ok = false;
        this.f9774a = new ConcurrentHashMap<>();
        this.bl = new ConcurrentHashMap<>();
        this.s = new ConcurrentHashMap<>();
        this.n = new ConcurrentHashMap<>();
    }

    public void a() {
        com.ss.android.downloadlib.s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.addownload.a.kf.1
            @Override // java.lang.Runnable
            public void run() {
                if (kf.this.ok) {
                    return;
                }
                synchronized (kf.class) {
                    if (!kf.this.ok) {
                        kf.this.n.putAll(q.ok().a());
                        kf.this.ok = true;
                    }
                }
            }
        }, true);
    }

    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.ok.a> bl() {
        return this.n;
    }

    public static kf ok() {
        return ok.ok;
    }

    public DownloadEventConfig a(long j) {
        return this.bl.get(Long.valueOf(j));
    }

    public com.ss.android.downloadad.api.ok.a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.ok.a aVar : this.n.values()) {
            if (aVar != null && str.equals(aVar.ok())) {
                return aVar;
            }
        }
        return null;
    }

    public void ok(DownloadModel downloadModel) {
        if (downloadModel != null) {
            this.f9774a.put(Long.valueOf(downloadModel.getId()), downloadModel);
            if (downloadModel.getDeepLink() != null) {
                downloadModel.getDeepLink().setId(downloadModel.getId());
                downloadModel.getDeepLink().setPackageName(downloadModel.getPackageName());
            }
        }
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        for (DownloadModel downloadModel : this.f9774a.values()) {
            if ((downloadModel instanceof AdDownloadModel) && TextUtils.equals(downloadModel.getDownloadUrl(), str)) {
                ((AdDownloadModel) downloadModel).setPackageName(str2);
            }
        }
    }

    public void ok(long j, DownloadEventConfig downloadEventConfig) {
        if (downloadEventConfig != null) {
            this.bl.put(Long.valueOf(j), downloadEventConfig);
        }
    }

    public void ok(long j, DownloadController downloadController) {
        if (downloadController != null) {
            this.s.put(Long.valueOf(j), downloadController);
        }
    }

    public synchronized void ok(com.ss.android.downloadad.api.ok.a aVar) {
        if (aVar == null) {
            return;
        }
        this.n.put(Long.valueOf(aVar.a()), aVar);
        q.ok().ok(aVar);
    }

    public DownloadModel ok(long j) {
        return this.f9774a.get(Long.valueOf(j));
    }

    public com.ss.android.downloadad.api.ok.a ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.ok.a aVar : this.n.values()) {
            if (aVar != null && str.equals(aVar.n())) {
                return aVar;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.ok.a ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        for (com.ss.android.downloadad.api.ok.a aVar : this.n.values()) {
            if (aVar != null && aVar.zz() == downloadInfo.getId()) {
                return aVar;
            }
        }
        if (!TextUtils.isEmpty(downloadInfo.getExtra())) {
            try {
                long jOk = j.ok(new JSONObject(downloadInfo.getExtra()), "extra");
                if (jOk != 0) {
                    for (com.ss.android.downloadad.api.ok.a aVar2 : this.n.values()) {
                        if (aVar2 != null && aVar2.a() == jOk) {
                            return aVar2;
                        }
                    }
                    com.ss.android.downloadlib.n.bl.ok().ok("getNativeModelByInfo");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        for (com.ss.android.downloadad.api.ok.a aVar3 : this.n.values()) {
            if (aVar3 != null && TextUtils.equals(aVar3.ok(), downloadInfo.getUrl())) {
                return aVar3;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.ok.a ok(int i2) {
        for (com.ss.android.downloadad.api.ok.a aVar : this.n.values()) {
            if (aVar != null && aVar.zz() == i2) {
                return aVar;
            }
        }
        return null;
    }

    @NonNull
    public Map<Long, com.ss.android.downloadad.api.ok.a> ok(String str, String str2) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (com.ss.android.downloadad.api.ok.a aVar : this.n.values()) {
                if (aVar != null && TextUtils.equals(aVar.ok(), str)) {
                    aVar.a(str2);
                    map.put(Long.valueOf(aVar.a()), aVar);
                }
            }
        }
        return map;
    }

    public synchronized void ok(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            arrayList.add(String.valueOf(jLongValue));
            this.n.remove(Long.valueOf(jLongValue));
        }
        q.ok().ok((List<String>) arrayList);
    }
}
