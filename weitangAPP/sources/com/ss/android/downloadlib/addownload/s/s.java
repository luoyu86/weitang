package com.ss.android.downloadlib.addownload.s;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class s {
    private static s ok;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<h> f9849a;

    private s() {
        ArrayList arrayList = new ArrayList();
        this.f9849a = arrayList;
        arrayList.add(new n());
        this.f9849a.add(new a());
        this.f9849a.add(new bl());
    }

    public static s ok() {
        if (ok == null) {
            synchronized (r.class) {
                if (ok == null) {
                    ok = new s();
                }
            }
        }
        return ok;
    }

    public void ok(com.ss.android.downloadad.api.ok.a aVar, int i2, p pVar, com.ss.android.downloadlib.addownload.ok.bl blVar) {
        DownloadInfo downloadInfoA;
        List<h> list = this.f9849a;
        if (list == null || list.size() == 0 || aVar == null) {
            pVar.ok(aVar);
        }
        if (!TextUtils.isEmpty(aVar.ld())) {
            downloadInfoA = com.ss.android.downloadlib.p.ok(com.ss.android.downloadlib.addownload.r.getContext()).ok(aVar.ld(), null, true);
        } else {
            downloadInfoA = com.ss.android.downloadlib.p.ok(com.ss.android.downloadlib.addownload.r.getContext()).a(aVar.ok());
        }
        if (downloadInfoA == null) {
            downloadInfoA = Downloader.getInstance(com.ss.android.downloadlib.addownload.r.getContext()).getDownloadInfo(aVar.zz());
        }
        if (downloadInfoA != null && "application/vnd.android.package-archive".equals(downloadInfoA.getMimeType())) {
            if (new k().ok(aVar, i2, pVar)) {
                return;
            }
            Iterator<h> it = this.f9849a.iterator();
            while (it.hasNext()) {
                if (it.next().ok(aVar, i2, pVar, blVar)) {
                    return;
                }
            }
            pVar.ok(aVar);
            return;
        }
        pVar.ok(aVar);
    }
}
