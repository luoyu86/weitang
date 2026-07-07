package com.ss.android.socialbase.downloader.s;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.rh;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.downloader.x;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.q;
import com.taobao.accs.AccsClientConfig;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ok {
    public static void ok(DownloadTask downloadTask, BaseException baseException, int i2) {
        if (downloadTask == null) {
            return;
        }
        try {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                return;
            }
            y monitorDepend = downloadTask.getMonitorDepend();
            boolean zIsMonitorStatus = DownloadStatus.isMonitorStatus(i2);
            if (!zIsMonitorStatus && !(zIsMonitorStatus = ok(downloadInfo.getExtraMonitorStatus(), i2)) && monitorDepend != null && (monitorDepend instanceof com.ss.android.socialbase.downloader.depend.bl)) {
                zIsMonitorStatus = ok(((com.ss.android.socialbase.downloader.depend.bl) monitorDepend).ok(), i2);
            }
            if (zIsMonitorStatus) {
                try {
                    rh depend = downloadTask.getDepend();
                    if (depend != null) {
                        depend.ok(downloadInfo, baseException, i2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                ok(monitorDepend, downloadInfo, baseException, i2);
                ok(com.ss.android.socialbase.downloader.downloader.bl.h(), downloadInfo, baseException, i2);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private static boolean ok(int[] iArr, int i2) {
        if (iArr != null && iArr.length > 0) {
            for (int i3 : iArr) {
                if (i2 == i3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void ok(y yVar, DownloadInfo downloadInfo, BaseException baseException, int i2) {
        if (yVar == null) {
            return;
        }
        try {
            String strA = yVar.a();
            if (TextUtils.isEmpty(strA)) {
                strA = AccsClientConfig.DEFAULT_CONFIG_TAG;
            }
            JSONObject jSONObjectOk = ok(strA, downloadInfo, baseException, i2);
            if (jSONObjectOk == null) {
                jSONObjectOk = new JSONObject();
            }
            yVar.ok(jSONObjectOk);
        } catch (Throwable unused) {
        }
    }

    public static void ok(a aVar, DownloadInfo downloadInfo, BaseException baseException, int i2) {
        if (aVar == null || !downloadInfo.isNeedSDKMonitor() || TextUtils.isEmpty(downloadInfo.getMonitorScene())) {
            return;
        }
        try {
            JSONObject jSONObjectOk = ok(downloadInfo.getMonitorScene(), downloadInfo, baseException, i2);
            if (jSONObjectOk == null) {
                jSONObjectOk = new JSONObject();
            }
            if (i2 == -1) {
                jSONObjectOk.put("status", baseException.getErrorCode());
                aVar.ok("download_failed", jSONObjectOk, null, null);
            } else {
                ok(i2, jSONObjectOk, downloadInfo);
                aVar.ok("download_common", jSONObjectOk, null, null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void ok(int i2, JSONObject jSONObject, DownloadInfo downloadInfo) throws JSONException {
        String str;
        if (i2 == -5) {
            str = "download_uncomplete";
        } else if (i2 == -4) {
            str = "download_cancel";
        } else if (i2 != -3) {
            str = i2 != -2 ? i2 != 0 ? i2 != 2 ? i2 != 6 ? "" : "download_first_start" : "download_start" : "download_create" : "download_pause";
        } else {
            double downloadSpeed = downloadInfo.getDownloadSpeed();
            if (downloadSpeed >= 0.0d) {
                jSONObject.put("download_speed", downloadSpeed);
            }
            str = "download_success";
        }
        jSONObject.put("status", str);
    }

    public static String ok(String str) {
        try {
            return TextUtils.isDigitsOnly(str) ? String.valueOf(Long.valueOf(str).longValue() % 100) : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static JSONObject ok(String str, DownloadInfo downloadInfo, BaseException baseException, int i2) {
        JSONObject jSONObject;
        String strA;
        String strOk;
        String strOk2;
        int iBl;
        String lastPathSegment;
        String host;
        String path;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e2) {
            e = e2;
        }
        try {
            x xVarR = com.ss.android.socialbase.downloader.downloader.bl.r();
            if (xVarR != null) {
                strA = xVarR.a();
                strOk = ok(strA);
                strOk2 = xVarR.ok();
                iBl = xVarR.bl();
            } else {
                strA = "";
                strOk = strA;
                strOk2 = strOk;
                iBl = 0;
            }
            String strOk3 = (baseException == null || !(baseException instanceof h)) ? "" : ((h) baseException).ok();
            jSONObject.put("event_page", str);
            jSONObject.put("app_id", strOk2);
            jSONObject.put("device_id", strA);
            jSONObject.put("device_id_postfix", strOk);
            jSONObject.put("update_version", iBl);
            jSONObject.put("download_status", i2);
            if (downloadInfo != null) {
                jSONObject.put("setting_tag", com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).bl("setting_tag"));
                jSONObject.put("download_id", downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
                jSONObject.put(AgooConstants.OPEN_URL, downloadInfo.getUrl());
                jSONObject.put("save_path", downloadInfo.getSavePath());
                jSONObject.put("download_time", downloadInfo.getDownloadTime());
                jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
                jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                int i3 = 1;
                jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                jSONObject.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                jSONObject.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                jSONObject.put(TTDownloadField.TT_MD5, downloadInfo.getMd5() == null ? "" : downloadInfo.getMd5());
                jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                jSONObject.put("is_force", downloadInfo.isForce() ? 1 : 0);
                jSONObject.put("retry_count", downloadInfo.getRetryCount());
                jSONObject.put("cur_retry_time", downloadInfo.getCurRetryTime());
                jSONObject.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                jSONObject.put("need_reuse_first_connection", downloadInfo.isNeedReuseFirstConnection() ? 1 : 0);
                jSONObject.put("default_http_service_backup", downloadInfo.isNeedDefaultHttpServiceBackUp() ? 1 : 0);
                jSONObject.put("retry_delay_status", downloadInfo.getRetryDelayStatus().ordinal());
                jSONObject.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                jSONObject.put("download_byte_error_retry_status", downloadInfo.getByteInvalidRetryStatus().ordinal());
                jSONObject.put("forbidden_handler_status", downloadInfo.getAsyncHandleStatus().ordinal());
                jSONObject.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                jSONObject.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                jSONObject.put("extra", downloadInfo.getExtra() != null ? downloadInfo.getExtra() : "");
                if (!downloadInfo.isAddListenerToSameTask()) {
                    i3 = 0;
                }
                jSONObject.put("add_listener_to_same_task", i3);
                jSONObject.put("backup_url_count", downloadInfo.getBackUpUrls() != null ? downloadInfo.getBackUpUrls().size() : 0);
                jSONObject.put("cur_backup_url_index", downloadInfo.getBackUpUrls() != null ? downloadInfo.getCurBackUpUrlIndex() : -1);
                jSONObject.put("forbidden_urls", downloadInfo.getForbiddenBackupUrls() != null ? downloadInfo.getForbiddenBackupUrls().toString() : "");
                jSONObject.put(AgooConstants.MESSAGE_TASK_ID, TextUtils.isEmpty(downloadInfo.getTaskId()) ? "" : downloadInfo.getTaskId());
                try {
                    String url = downloadInfo.getUrl();
                    if (TextUtils.isEmpty(url)) {
                        lastPathSegment = "";
                        host = lastPathSegment;
                        path = host;
                    } else {
                        Uri uri = Uri.parse(url);
                        host = uri.getHost();
                        path = uri.getPath();
                        lastPathSegment = uri.getLastPathSegment();
                        if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                            try {
                                path = path.substring(0, path.length() - lastPathSegment.length());
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                    jSONObject.put("url_host", host);
                    jSONObject.put("url_path", path);
                    jSONObject.put("url_last_path_segment", lastPathSegment);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            jSONObject.put("error_code", baseException != null ? baseException.getErrorCode() : 0);
            jSONObject.put("error_msg", baseException != null ? baseException.getErrorMessage() : "");
            jSONObject.put("request_log", strOk3);
            return jSONObject;
        } catch (JSONException e3) {
            e = e3;
            jSONObject2 = jSONObject;
            e.printStackTrace();
            return jSONObject2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003c A[PHI: r7
  0x003c: PHI (r7v9 int) = (r7v0 int), (r7v2 int) binds: [B:12:0x0023, B:19:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007e A[PHI: r7
  0x007e: PHI (r7v8 int) = (r7v4 int), (r7v4 int), (r7v6 int), (r7v4 int) binds: [B:32:0x0056, B:36:0x0065, B:35:0x0062, B:25:0x0045] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void ok(@androidx.annotation.Nullable com.ss.android.socialbase.downloader.network.h r14, java.lang.String r15, java.lang.String r16, long r17, java.lang.String r19, int r20, java.io.IOException r21, com.ss.android.socialbase.downloader.model.DownloadInfo r22) {
        /*
            Method dump skipped, instruction units count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.s.ok.ok(com.ss.android.socialbase.downloader.network.h, java.lang.String, java.lang.String, long, java.lang.String, int, java.io.IOException, com.ss.android.socialbase.downloader.model.DownloadInfo):void");
    }

    public static void ok(com.ss.android.socialbase.downloader.h.ok okVar, DownloadInfo downloadInfo, String str, q qVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        ok("download_io", okVar.a("monitor_download_io"), okVar, downloadInfo, str, null, null, qVar, z, z2, baseException, j, j2, z3, j3, j4, j5, null);
    }

    public static void ok(com.ss.android.socialbase.downloader.h.ok okVar, DownloadInfo downloadInfo, String str, String str2, String str3, boolean z, q qVar, BaseException baseException, long j, long j2) {
        ok("segment_io", okVar.a("monitor_segment_io"), okVar, downloadInfo, str, str2, str3, qVar, z, false, baseException, j, j2, false, -1L, -1L, -1L, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0070 A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:47:0x00bb, B:49:0x0108, B:50:0x0119, B:52:0x012b, B:54:0x0134, B:55:0x014f, B:67:0x0182, B:60:0x016e, B:62:0x0174, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:74:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0108 A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:47:0x00bb, B:49:0x0108, B:50:0x0119, B:52:0x012b, B:54:0x0134, B:55:0x014f, B:67:0x0182, B:60:0x016e, B:62:0x0174, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:74:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012b A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:47:0x00bb, B:49:0x0108, B:50:0x0119, B:52:0x012b, B:54:0x0134, B:55:0x014f, B:67:0x0182, B:60:0x016e, B:62:0x0174, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:74:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0134 A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:47:0x00bb, B:49:0x0108, B:50:0x0119, B:52:0x012b, B:54:0x0134, B:55:0x014f, B:67:0x0182, B:60:0x016e, B:62:0x0174, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:74:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x016e A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:47:0x00bb, B:49:0x0108, B:50:0x0119, B:52:0x012b, B:54:0x0134, B:55:0x014f, B:67:0x0182, B:60:0x016e, B:62:0x0174, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:74:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0174 A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:47:0x00bb, B:49:0x0108, B:50:0x0119, B:52:0x012b, B:54:0x0134, B:55:0x014f, B:67:0x0182, B:60:0x016e, B:62:0x0174, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:74:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017b  */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.ss.android.socialbase.downloader.s.bl] */
    /* JADX WARN: Type inference failed for: r11v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v10, types: [com.ss.android.socialbase.downloader.network.ok] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.ss.android.socialbase.downloader.s.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void ok(java.lang.String r19, int r20, com.ss.android.socialbase.downloader.h.ok r21, com.ss.android.socialbase.downloader.model.DownloadInfo r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, com.ss.android.socialbase.downloader.network.q r26, boolean r27, boolean r28, com.ss.android.socialbase.downloader.exception.BaseException r29, long r30, long r32, boolean r34, long r35, long r37, long r39, org.json.JSONObject r41) {
        /*
            Method dump skipped, instruction units count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.s.ok.ok(java.lang.String, int, com.ss.android.socialbase.downloader.h.ok, com.ss.android.socialbase.downloader.model.DownloadInfo, java.lang.String, java.lang.String, java.lang.String, com.ss.android.socialbase.downloader.network.q, boolean, boolean, com.ss.android.socialbase.downloader.exception.BaseException, long, long, boolean, long, long, long, org.json.JSONObject):void");
    }

    public static void ok(DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.kf.q> list) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("segments", com.ss.android.socialbase.downloader.kf.q.ok(list));
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            bl blVarVk = com.ss.android.socialbase.downloader.downloader.bl.vk();
            if (blVarVk != null) {
                blVarVk.ok(downloadInfo.getId(), "segments_error", jSONObject);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
