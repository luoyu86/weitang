package com.ss.android.downloadlib.addownload;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.n;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.ss.android.downloadlib.addownload.a.n f9834a;
    private Handler ok;
    private AtomicBoolean bl = new AtomicBoolean(false);
    private AtomicBoolean s = new AtomicBoolean(false);

    public s(Handler handler) {
        this.ok = handler;
    }

    public static long a() {
        if (r.z() != null) {
            return r.z().ok();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long s() {
        return com.ss.android.downloadlib.h.j.a(0L);
    }

    private void a(com.ss.android.downloadad.api.ok.a aVar, JSONObject jSONObject, long j, long j2) {
        aVar.j("1");
        com.ss.android.downloadlib.addownload.a.q.ok().ok(aVar);
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(j2 - j));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().ok("cleanspace_download_after_quite_clean", jSONObject, aVar);
    }

    public void ok(com.ss.android.downloadlib.addownload.a.n nVar) {
        this.f9834a = nVar;
    }

    public boolean ok() {
        return this.s.get();
    }

    public void ok(boolean z) {
        this.s.set(z);
    }

    public void ok(final int i2, final long j, long j2, final n.ok okVar) {
        this.s.set(false);
        if (okVar == null) {
            return;
        }
        if (com.ss.android.downloadlib.h.n.kf(i2) && com.ss.android.downloadlib.h.n.n(i2)) {
            long jBl = com.ss.android.downloadlib.h.n.bl(i2);
            this.bl.set(false);
            final String downloadUrl = this.f9834a.f9775a.getDownloadUrl();
            com.ss.android.downloadad.api.ok.a aVarA = com.ss.android.downloadlib.addownload.a.kf.ok().a(downloadUrl);
            if (aVarA == null) {
                com.ss.android.downloadlib.addownload.a.n nVar = this.f9834a;
                aVarA = new com.ss.android.downloadad.api.ok.a(nVar.f9775a, nVar.bl, nVar.s, 0);
                com.ss.android.downloadlib.addownload.a.kf.ok().ok(aVarA);
            }
            final com.ss.android.downloadad.api.ok.a aVar = aVarA;
            aVar.n(false);
            if (r.z() != null) {
                r.z().ok(aVar.a());
            }
            com.ss.android.downloadlib.addownload.bl.s.ok().ok(aVar.ok());
            boolean zS = com.ss.android.downloadlib.h.n.s(i2);
            if (j2 > 0) {
                ok(i2, downloadUrl, j2, aVar, j, okVar);
            } else if (zS) {
                ok(downloadUrl, aVar, new n.a() { // from class: com.ss.android.downloadlib.addownload.s.1
                    @Override // com.ss.android.downloadlib.addownload.n.a
                    public void ok(long j3) throws Throwable {
                        s.this.ok(i2, downloadUrl, j3, aVar, j, okVar);
                    }
                });
            } else {
                jBl = 0;
            }
            this.ok.postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.s.2
                @Override // java.lang.Runnable
                public void run() {
                    if (s.this.bl.get()) {
                        return;
                    }
                    s.this.bl.set(true);
                    okVar.ok();
                }
            }, jBl);
            return;
        }
        okVar.ok();
    }

    private void ok(String str, com.ss.android.downloadad.api.ok.a aVar, final n.a aVar2) {
        if (aVar2 == null) {
            return;
        }
        com.ss.android.socialbase.downloader.network.ok.a.ok(str, new com.ss.android.socialbase.downloader.network.k() { // from class: com.ss.android.downloadlib.addownload.s.3
            @Override // com.ss.android.socialbase.downloader.network.k
            public void ok(Map<String, String> map) {
                if (s.this.bl.get()) {
                    return;
                }
                s.this.bl.set(true);
                long jOk = s.this.ok(map);
                if (jOk > 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("apk_size", Long.valueOf(jOk));
                        jSONObject.putOpt("available_space", Long.valueOf(s.s()));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                aVar2.ok(jOk);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long ok(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if ("content-length".equalsIgnoreCase(key)) {
                        return Long.parseLong(value);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i2, String str, long j, final com.ss.android.downloadad.api.ok.a aVar, long j2, final n.ok okVar) throws Throwable {
        this.bl.set(true);
        boolean zOk = false;
        if (j > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("apk_size", Long.valueOf(j));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            long jLongValue = (Double.valueOf((com.ss.android.downloadlib.h.n.ok(i2) + 1.0d) * j).longValue() + com.ss.android.downloadlib.h.n.a(i2)) - j2;
            long jS = s();
            if (jS < jLongValue) {
                ok(aVar, jSONObject, jLongValue, jS);
                ok(aVar);
                long jS2 = s();
                if (jS2 < jLongValue) {
                    aVar.s(true);
                    final String strOk = aVar.ok();
                    com.ss.android.downloadlib.addownload.bl.s.ok().ok(strOk, new com.ss.android.downloadlib.addownload.bl.n() { // from class: com.ss.android.downloadlib.addownload.s.4
                    });
                    zOk = ok(i2, aVar, str, jLongValue);
                    if (zOk) {
                        aVar.n(true);
                    }
                } else {
                    a(aVar, jSONObject, jS, jS2);
                }
            }
        }
        if (zOk) {
            return;
        }
        this.ok.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.s.5
            @Override // java.lang.Runnable
            public void run() {
                okVar.ok();
            }
        });
    }

    private boolean ok(int i2, @NonNull com.ss.android.downloadad.api.ok.a aVar, String str, long j) {
        if (!com.ss.android.downloadlib.h.n.kf(i2)) {
            return false;
        }
        if (r.z() != null) {
            return r.z().ok(i2, str, true, j);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_dialog_result", 3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().ok("cleanspace_window_show", jSONObject, aVar);
        return false;
    }

    public static boolean ok(final DownloadInfo downloadInfo, long j) {
        int id = downloadInfo.getId();
        boolean zOk = false;
        if (!com.ss.android.downloadlib.h.n.kf(id)) {
            return false;
        }
        if (r.z() != null && (zOk = r.z().ok(id, downloadInfo.getUrl(), false, j))) {
            com.ss.android.downloadlib.addownload.bl.s.ok().ok(downloadInfo.getUrl(), new com.ss.android.downloadlib.addownload.bl.n() { // from class: com.ss.android.downloadlib.addownload.s.6
            });
        }
        return zOk;
    }

    public static JSONObject ok(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("clean_space_install_params", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static void ok(int i2) {
        if (com.ss.android.downloadlib.h.n.kf(i2) && r.z() != null && r.z().a()) {
            r.z().bl();
        }
    }

    private static void ok(com.ss.android.downloadad.api.ok.a aVar) throws Throwable {
        long jS = s();
        if (r.z() != null) {
            r.z().n();
        }
        com.ss.android.downloadlib.addownload.bl.bl.ok();
        com.ss.android.downloadlib.addownload.bl.bl.a();
        if (com.ss.android.downloadlib.h.n.h(aVar.zz())) {
            com.ss.android.downloadlib.addownload.bl.bl.ok(r.getContext());
        }
        long jS2 = s();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(jS2 - jS));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().ok("clean_quite_finish", jSONObject, aVar);
    }

    private void ok(com.ss.android.downloadad.api.ok.a aVar, JSONObject jSONObject, long j, long j2) {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j2));
            jSONObject.putOpt("apk_download_need_size", Long.valueOf(j));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().ok("clean_space_no_enough_for_download", jSONObject, aVar);
    }
}
