package com.ss.android.downloadlib.addownload;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.h.z;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ok implements z.ok {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ok f9819a = null;
    private static final String ok = "ok";
    private com.ss.android.downloadlib.h.z bl = new com.ss.android.downloadlib.h.z(Looper.getMainLooper(), this);
    private long s;

    private ok() {
    }

    public static ok ok() {
        if (f9819a == null) {
            synchronized (ok.class) {
                if (f9819a == null) {
                    f9819a = new ok();
                }
            }
        }
        return f9819a;
    }

    public void ok(@NonNull DownloadInfo downloadInfo, long j, long j2, String str, String str2, String str3, String str4) {
        com.ss.android.downloadlib.addownload.a.ok okVar = new com.ss.android.downloadlib.addownload.a.ok(downloadInfo.getId(), j, j2, str, str2, str3, str4);
        if (com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("back_miui_silent_install", 1) == 0 && ((com.ss.android.socialbase.appdownloader.kf.n.z() || com.ss.android.socialbase.appdownloader.kf.n.rh()) && com.ss.android.socialbase.downloader.q.k.ok(r.getContext(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (com.ss.android.socialbase.downloader.q.kf.ok(downloadInfo.getTempCacheData().get("extra_silent_install_succeed"), false)) {
                Message messageObtainMessage = this.bl.obtainMessage(200, okVar);
                messageObtainMessage.arg1 = 2;
                this.bl.sendMessageDelayed(messageObtainMessage, r1.ok("check_silent_install_interval", 60000));
                return;
            }
            com.ss.android.downloadad.api.ok.a aVarS = com.ss.android.downloadlib.addownload.a.kf.ok().s(okVar.f9776a);
            JSONObject jSONObject = new JSONObject();
            int i2 = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                i2 = 5;
            } catch (Exception unused) {
            }
            r.kf().ok(null, new BaseException(i2, jSONObject.toString()), i2);
            com.ss.android.downloadlib.s.ok.ok().ok("embeded_ad", "ah_result", jSONObject, aVarS);
        }
        if (com.ss.android.downloadlib.h.n.bl()) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.s;
            long jS = com.ss.android.downloadlib.h.n.s();
            if (jCurrentTimeMillis < com.ss.android.downloadlib.h.n.n()) {
                long jN = com.ss.android.downloadlib.h.n.n() - jCurrentTimeMillis;
                jS += jN;
                this.s = System.currentTimeMillis() + jN;
            } else {
                this.s = System.currentTimeMillis();
            }
            com.ss.android.downloadlib.h.z zVar = this.bl;
            zVar.sendMessageDelayed(zVar.obtainMessage(200, okVar), jS);
        }
    }

    private void ok(com.ss.android.downloadlib.addownload.a.ok okVar, int i2) {
        if (r.j() == null || r.j().ok() || okVar == null) {
            return;
        }
        if (2 == i2) {
            com.ss.android.downloadad.api.ok.a aVarS = com.ss.android.downloadlib.addownload.a.kf.ok().s(okVar.f9776a);
            JSONObject jSONObject = new JSONObject();
            int i3 = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                if (com.ss.android.downloadlib.h.j.n(r.getContext(), okVar.s)) {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                    i3 = 4;
                } else {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                    i3 = 5;
                }
            } catch (Exception unused) {
            }
            r.kf().ok(null, new BaseException(i3, jSONObject.toString()), i3);
            com.ss.android.downloadlib.s.ok.ok().ok("embeded_ad", "ah_result", jSONObject, aVarS);
        }
        if (com.ss.android.downloadlib.h.j.n(r.getContext(), okVar.s)) {
            com.ss.android.downloadlib.s.ok.ok().ok("delayinstall_installed", okVar.f9776a);
            return;
        }
        if (!com.ss.android.downloadlib.h.j.ok(okVar.f9777h)) {
            com.ss.android.downloadlib.s.ok.ok().ok("delayinstall_file_lost", okVar.f9776a);
        } else if (com.ss.android.downloadlib.addownload.ok.ok.ok().ok(okVar.s)) {
            com.ss.android.downloadlib.s.ok.ok().ok("delayinstall_conflict_with_back_dialog", okVar.f9776a);
        } else {
            com.ss.android.downloadlib.s.ok.ok().ok("delayinstall_install_start", okVar.f9776a);
            com.ss.android.socialbase.appdownloader.s.ok(r.getContext(), (int) okVar.ok);
        }
    }

    @Override // com.ss.android.downloadlib.h.z.ok
    public void ok(Message message) {
        if (message.what != 200) {
            return;
        }
        ok((com.ss.android.downloadlib.addownload.a.ok) message.obj, message.arg1);
    }
}
