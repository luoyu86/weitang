package com.ss.android.downloadlib.a;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.downloader.ok.ok;

/* JADX INFO: loaded from: classes2.dex */
public class bl {
    public static void ok(final com.ss.android.downloadad.api.ok.a aVar, @NonNull final com.ss.android.downloadlib.guide.install.ok okVar) {
        boolean zA = com.ss.android.socialbase.downloader.ok.ok.ok().a();
        if (!zA && Build.VERSION.SDK_INT >= 29) {
            j.bl();
        }
        boolean zA2 = com.ss.android.socialbase.downloader.ok.ok.ok().a();
        if (!zA && zA2 && aVar != null) {
            aVar.j(true);
        }
        okVar.ok();
        com.ss.android.socialbase.downloader.bl.ok.a("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::" + zA2);
        if (zA2) {
            return;
        }
        com.ss.android.socialbase.downloader.ok.ok.ok().ok(new ok.InterfaceC0174ok() { // from class: com.ss.android.downloadlib.a.bl.1
            @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC0174ok
            public void a() {
                com.ss.android.socialbase.downloader.bl.ok.a("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                com.ss.android.socialbase.downloader.ok.ok.ok().a(this);
                if (j.a(aVar)) {
                    return;
                }
                aVar.z(true);
                com.ss.android.downloadlib.s.ok.ok().ok("install_delay_invoke", aVar);
                okVar.ok();
            }

            @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC0174ok
            public void bl() {
            }
        });
    }
}
