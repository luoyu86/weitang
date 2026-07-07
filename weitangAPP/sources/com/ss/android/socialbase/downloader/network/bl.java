package com.ss.android.socialbase.downloader.network;

import android.net.Uri;
import android.os.Handler;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class bl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f10126a;
    private final Handler bl;
    private final com.ss.android.socialbase.downloader.q.p<String, a> ok;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f10129a;
        public List<InetAddress> ok;

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.network.bl$bl, reason: collision with other inner class name */
    public static class C0171bl {
        private static final bl ok = new bl();
    }

    public interface ok {
        void ok(String str, List<InetAddress> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final ok okVar, long j) {
        final a aVar;
        kf kfVarUl;
        try {
            String host = Uri.parse(str).getHost();
            synchronized (this.ok) {
                aVar = this.ok.get(host);
            }
            if (aVar != null) {
                if (System.currentTimeMillis() - aVar.f10129a < com.ss.android.socialbase.downloader.h.ok.bl().ok("dns_expire_min", 10) * 60 * 1000) {
                    if (okVar != null) {
                        okVar.ok(str, aVar.ok);
                        return;
                    }
                    return;
                }
            }
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.network.bl.2
                @Override // java.lang.Runnable
                public void run() {
                    ok okVar2 = okVar;
                    if (okVar2 != null) {
                        String str2 = str;
                        a aVar2 = aVar;
                        okVar2.ok(str2, aVar2 == null ? null : aVar2.ok);
                    }
                }
            };
            this.bl.postDelayed(runnable, j);
            List<InetAddress> listOk = null;
            if (com.ss.android.socialbase.downloader.h.ok.bl().ok("use_host_dns", 1) == 1 && (kfVarUl = com.ss.android.socialbase.downloader.downloader.bl.ul()) != null) {
                try {
                    listOk = kfVarUl.ok(host);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (listOk == null || listOk.isEmpty()) {
                try {
                    listOk = com.ss.android.socialbase.downloader.downloader.bl.o().ok(host);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (listOk != null && !listOk.isEmpty()) {
                ok(host, listOk);
            } else if (aVar != null) {
                listOk = aVar.ok;
            }
            this.bl.removeCallbacks(runnable);
            if (okVar != null) {
                okVar.ok(str, listOk);
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    private bl() {
        this.ok = new com.ss.android.socialbase.downloader.q.p<>(4, 16, false);
        this.f10126a = new Handler(com.ss.android.socialbase.downloader.network.ok.a.ok());
        this.bl = new Handler(com.ss.android.socialbase.downloader.p.n.ok());
    }

    public static bl ok() {
        return C0171bl.ok;
    }

    public void ok(final String str, final ok okVar, final long j) {
        this.f10126a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.bl.1
            @Override // java.lang.Runnable
            public void run() {
                bl.this.a(str, okVar, j);
            }
        });
    }

    private void ok(String str, List<InetAddress> list) {
        synchronized (this.ok) {
            a aVar = this.ok.get(str);
            if (aVar == null) {
                aVar = new a();
                this.ok.put(str, aVar);
            }
            aVar.ok = list;
            aVar.f10129a = System.currentTimeMillis();
        }
    }
}
