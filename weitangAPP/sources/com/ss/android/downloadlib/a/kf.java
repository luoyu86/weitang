package com.ss.android.downloadlib.a;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.downloader.ok.ok;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class kf {
    private static Handler ok = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(@NonNull final com.ss.android.downloadad.api.ok.a aVar, final int i2) {
        if (i2 <= 0) {
            return;
        }
        com.ss.android.downloadlib.s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.a.kf.2
            @Override // java.lang.Runnable
            public void run() {
                int i3 = 1;
                if (!j.bl(aVar.n())) {
                    kf.a(aVar, i2 - 1);
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!aVar.ew()) {
                        i3 = 2;
                    }
                    jSONObject.putOpt("deeplink_source", Integer.valueOf(i3));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.ss.android.downloadlib.s.ok.ok().ok("deeplink_success_2", jSONObject, aVar);
            }
        }, q(aVar) * 1000);
    }

    public static boolean bl(com.ss.android.downloadad.api.ok.a aVar) {
        return com.ss.android.downloadlib.h.n.ok(aVar).a("app_link_opt_invoke_switch") == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(com.ss.android.downloadad.api.ok.a aVar) {
        return com.ss.android.downloadlib.h.n.ok(aVar).ok("app_link_check_count", 10);
    }

    public static long n(com.ss.android.downloadad.api.ok.a aVar) {
        if (aVar == null) {
            return 3000L;
        }
        return com.ss.android.downloadlib.h.n.ok(aVar).ok("app_link_opt_back_time_limit", 3) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long p(com.ss.android.downloadad.api.ok.a aVar) {
        return com.ss.android.downloadlib.h.n.ok(aVar).ok("app_link_check_timeout", 300000L);
    }

    private static int q(com.ss.android.downloadad.api.ok.a aVar) {
        return com.ss.android.downloadlib.h.n.ok(aVar).ok("app_link_check_delay", 1);
    }

    public static boolean s(com.ss.android.downloadad.api.ok.a aVar) {
        return com.ss.android.downloadlib.h.n.ok(aVar).a("app_link_opt_dialog_switch") == 1;
    }

    public static void ok(final com.ss.android.downloadad.api.ok.a aVar, @NonNull final p pVar) {
        boolean zA = com.ss.android.socialbase.downloader.ok.ok.ok().a();
        if (!zA && Build.VERSION.SDK_INT >= 29) {
            j.bl();
        }
        boolean zA2 = com.ss.android.socialbase.downloader.ok.ok.ok().a();
        boolean z = !zA && zA2;
        if (aVar != null) {
            aVar.j(z);
        }
        pVar.ok(z);
        if (aVar == null) {
            return;
        }
        a(aVar, k(aVar));
        if (zA2) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.ss.android.socialbase.downloader.ok.ok.ok().ok(new ok.InterfaceC0174ok() { // from class: com.ss.android.downloadlib.a.kf.1
            @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC0174ok
            public void a() {
                com.ss.android.socialbase.downloader.ok.ok.ok().a(this);
                com.ss.android.downloadlib.s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.a.kf.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean zBl = j.bl(aVar.n());
                        long jN = kf.n(aVar);
                        if (!zBl || jN >= System.currentTimeMillis() - jCurrentTimeMillis) {
                            long jP = kf.p(aVar);
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (jCurrentTimeMillis2 - jCurrentTimeMillis > jP) {
                                com.ss.android.downloadlib.s.ok.ok().ok("deeplink_delay_timeout", aVar);
                                return;
                            }
                            aVar.j(true);
                            com.ss.android.downloadlib.s.ok.ok().ok("deeplink_delay_invoke", aVar);
                            pVar.ok(true);
                            com.ss.android.downloadad.api.ok.a aVar2 = aVar;
                            kf.a(aVar2, kf.k(aVar2));
                        }
                    }
                });
            }

            @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC0174ok
            public void bl() {
            }
        });
    }

    public static boolean a(com.ss.android.downloadad.api.ok.a aVar) {
        return com.ss.android.downloadlib.h.n.ok(aVar).a("app_link_opt_install_switch") == 1;
    }

    public static boolean ok(com.ss.android.downloadad.api.ok.a aVar) {
        return com.ss.android.downloadlib.h.n.ok(aVar).a("app_link_opt_switch") == 1;
    }
}
