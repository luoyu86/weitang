package com.ss.android.downloadlib.addownload.s;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class r {
    private static r ok;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<q> f9848a;

    private r() {
        ArrayList arrayList = new ArrayList();
        this.f9848a = arrayList;
        arrayList.add(new k());
        this.f9848a.add(new j());
        this.f9848a.add(new kf());
        this.f9848a.add(new ok());
    }

    public static r ok() {
        if (ok == null) {
            synchronized (r.class) {
                if (ok == null) {
                    ok = new r();
                }
            }
        }
        return ok;
    }

    public void ok(com.ss.android.downloadad.api.ok.a aVar, int i2, p pVar) {
        DownloadInfo downloadInfoA;
        List<q> list = this.f9848a;
        if (list != null && list.size() != 0 && aVar != null) {
            if (!TextUtils.isEmpty(aVar.ld())) {
                downloadInfoA = com.ss.android.downloadlib.p.ok((Context) null).ok(aVar.ld(), null, true);
            } else {
                downloadInfoA = com.ss.android.downloadlib.p.ok((Context) null).a(aVar.ok());
            }
            if (downloadInfoA != null && "application/vnd.android.package-archive".equals(downloadInfoA.getMimeType())) {
                boolean z = com.ss.android.socialbase.downloader.h.ok.ok(aVar.zz()).ok("pause_optimise_switch", 0) == 1;
                for (q qVar : this.f9848a) {
                    if (z || (qVar instanceof j)) {
                        if (qVar.ok(aVar, i2, pVar)) {
                            return;
                        }
                    }
                }
                pVar.ok(aVar);
                return;
            }
            pVar.ok(aVar);
            return;
        }
        pVar.ok(aVar);
    }
}
