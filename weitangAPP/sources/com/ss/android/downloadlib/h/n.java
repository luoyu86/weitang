package com.ss.android.downloadlib.h;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.download.DownloadModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class n {
    @NonNull
    public static com.ss.android.socialbase.downloader.h.ok a(DownloadModel downloadModel) {
        return com.ss.android.socialbase.downloader.h.ok.ok(ok(downloadModel));
    }

    public static int bl(@NonNull DownloadModel downloadModel) {
        return ok(a(downloadModel));
    }

    public static boolean h(int i2) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i2).ok("clean_app_cache_dir", 0) == 1;
    }

    public static boolean kf(int i2) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i2).ok("clean_space_switch", 0) == 1;
    }

    public static boolean n(int i2) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i2).ok("clean_space_before_download_switch", 0L) == 1;
    }

    @Nullable
    public static JSONObject ok() {
        return com.ss.android.downloadlib.addownload.r.q().optJSONObject("ad");
    }

    public static boolean s(int i2) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i2).ok("clean_fetch_apk_switch", 0L) == 1;
    }

    public static boolean a(com.ss.android.downloadad.api.ok.ok okVar) {
        return ok(okVar).ok("pause_reserve_on_wifi", 0) == 1 && okVar.x();
    }

    public static long n() {
        long jOptLong = com.ss.android.downloadlib.addownload.r.q().optLong("next_install_min_interval");
        if (jOptLong == 0) {
            return 10000L;
        }
        return jOptLong;
    }

    public static JSONObject ok(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return null;
        }
        return downloadModel.isAd() ? j.ok(com.ss.android.downloadlib.addownload.r.q(), downloadModel.getDownloadSettings()) : downloadModel.getDownloadSettings();
    }

    public static long s() {
        long jOptLong = com.ss.android.downloadlib.addownload.r.q().optLong("start_install_interval");
        if (jOptLong == 0) {
            return 300000L;
        }
        return jOptLong;
    }

    public static boolean bl(com.ss.android.downloadad.api.ok.ok okVar) {
        return ok(okVar).ok("cancel_pause_optimise_wifi_retain_switch", 0) == 1 && okVar.x();
    }

    public static long a(int i2) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i2).ok("storage_min_size", 0L);
    }

    public static boolean a(com.ss.android.socialbase.downloader.h.ok okVar) {
        return okVar != null && okVar.ok("kllk_need_rename_apk", 0) == 1;
    }

    public static long bl(int i2) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i2).ok("clean_fetch_apk_head_time_out", 800L);
    }

    @NonNull
    public static com.ss.android.socialbase.downloader.h.ok ok(com.ss.android.downloadad.api.ok.ok okVar) {
        if (okVar == null) {
            return com.ss.android.socialbase.downloader.h.ok.bl();
        }
        if (okVar.zz() != 0) {
            return com.ss.android.socialbase.downloader.h.ok.ok(okVar.zz());
        }
        if (okVar.bl()) {
            return com.ss.android.socialbase.downloader.h.ok.ok(ok());
        }
        if (okVar.td() != null) {
            return com.ss.android.socialbase.downloader.h.ok.ok(okVar.td());
        }
        return com.ss.android.socialbase.downloader.h.ok.bl();
    }

    public static boolean a() {
        return com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_notification_anr");
    }

    public static boolean bl() {
        return com.ss.android.downloadlib.addownload.r.q().optInt("is_enable_start_install_again") == 1;
    }

    public static int ok(@NonNull com.ss.android.socialbase.downloader.h.ok okVar) {
        return okVar.ok("external_storage_permission_path_type", 0);
    }

    public static double ok(int i2) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i2).ok("clean_min_install_size", 0.0d);
    }
}
