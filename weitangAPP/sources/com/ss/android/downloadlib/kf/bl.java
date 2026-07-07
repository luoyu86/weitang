package com.ss.android.downloadlib.kf;

import com.ss.android.socialbase.appdownloader.bl.k;
import com.ss.android.socialbase.appdownloader.bl.q;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class bl implements k {
    private static volatile bl ok;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<k> f9878a;

    private bl() {
        ArrayList arrayList = new ArrayList();
        this.f9878a = arrayList;
        arrayList.add(new a());
        this.f9878a.add(new ok());
    }

    public static bl ok() {
        if (ok == null) {
            synchronized (bl.class) {
                if (ok == null) {
                    ok = new bl();
                }
            }
        }
        return ok;
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.k
    public void ok(DownloadInfo downloadInfo, q qVar) {
        if (downloadInfo != null && this.f9878a.size() != 0) {
            ok(downloadInfo, 0, qVar);
        } else if (qVar != null) {
            qVar.ok();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(final DownloadInfo downloadInfo, final int i2, final q qVar) {
        if (i2 != this.f9878a.size() && i2 >= 0) {
            this.f9878a.get(i2).ok(downloadInfo, new q() { // from class: com.ss.android.downloadlib.kf.bl.1
                @Override // com.ss.android.socialbase.appdownloader.bl.q
                public void ok() {
                    bl.this.ok(downloadInfo, i2 + 1, qVar);
                }
            });
        } else {
            qVar.ok();
        }
    }
}
