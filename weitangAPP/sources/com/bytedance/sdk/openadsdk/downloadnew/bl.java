package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.downloadnew.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.h;
import com.ss.android.download.api.config.j;
import com.ss.android.download.api.config.k;
import com.ss.android.download.api.config.p;
import com.ss.android.download.api.config.td;
import com.ss.android.download.api.config.u;
import com.ss.android.download.api.config.x;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.a;
import com.ss.android.download.api.model.ok;
import com.ss.android.downloadlib.addownload.a.kf;
import com.ss.android.downloadlib.addownload.ok.ok;
import com.ss.android.socialbase.downloader.depend.fb;
import com.ss.android.socialbase.downloader.depend.vz;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.network.q;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bl {
    public static ITTDownloadVisitor bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final com.ss.android.download.api.download.ok.ok f6367h;
    private static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> kf;
    private static Context n;
    public static volatile String ok;
    private static final AtomicBoolean s = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f6366a = true;

    public static class n implements IDownloadHttpService {
        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
        public q downloadWithConnection(int i2, String str, List<com.ss.android.socialbase.downloader.model.bl> list) throws IOException {
            final a.ok okVarOk = com.bytedance.sdk.openadsdk.downloadnew.a.ok(str, list);
            if (okVarOk != null) {
                return new q() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.n.1
                    @Override // com.ss.android.socialbase.downloader.network.h
                    public int a() {
                        return okVarOk.bl;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.h
                    public void bl() {
                    }

                    @Override // com.ss.android.socialbase.downloader.network.q
                    public InputStream ok() {
                        return okVarOk.ok;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.q
                    public void s() {
                        try {
                            okVarOk.s.disconnect();
                        } catch (Exception unused) {
                        }
                    }

                    @Override // com.ss.android.socialbase.downloader.network.h
                    public String ok(String str2) {
                        Map<String, String> map = okVarOk.f6365a;
                        if (map != null) {
                            return map.get(str2);
                        }
                        return null;
                    }
                };
            }
            return null;
        }
    }

    static {
        try {
            ok = getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (Throwable unused) {
        }
        f6367h = new com.ss.android.download.api.download.ok.ok() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.6
            @Override // com.ss.android.download.api.download.ok.ok
            public void a(DownloadInfo downloadInfo, String str) {
                com.bytedance.sdk.openadsdk.api.bl.a("TTDownloadVisitor", "completeListener: onInstalled");
                bl.bl(str);
            }

            @Override // com.ss.android.download.api.download.ok.ok
            public void ok(DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig) {
                com.bytedance.sdk.openadsdk.api.bl.a("TTDownloadVisitor", "completeListener: onDownloadStart");
            }

            @Override // com.ss.android.download.api.download.ok.ok
            public void ok(DownloadInfo downloadInfo, String str) {
                com.bytedance.sdk.openadsdk.api.bl.a("TTDownloadVisitor", "completeListener: onDownloadFinished");
            }

            @Override // com.ss.android.download.api.download.ok.ok
            public void ok(DownloadInfo downloadInfo, BaseException baseException, String str) {
                com.bytedance.sdk.openadsdk.api.bl.a("TTDownloadVisitor", "completeListener: onDownloadFailed");
            }

            @Override // com.ss.android.download.api.download.ok.ok
            public void ok(DownloadInfo downloadInfo) {
                com.bytedance.sdk.openadsdk.api.bl.a("TTDownloadVisitor", "completeListener: onCanceled");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bl(String str) {
        com.ss.android.downloadad.api.ok.a aVarOk;
        JSONObject jSONObjectH;
        if (TextUtils.isEmpty(str) || (aVarOk = kf.ok().ok(str)) == null || (jSONObjectH = aVarOk.h()) == null || n() == null) {
            return;
        }
        n().checkAutoControl(jSONObjectH, str);
    }

    private static Context getContext() {
        Context context = n;
        return context == null ? TTAppContextHolder.getContext() : context;
    }

    private static boolean kf() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ITTDownloadVisitor n() {
        ITTDownloadVisitor iTTDownloadVisitor = bl;
        if (iTTDownloadVisitor != null) {
            return iTTDownloadVisitor;
        }
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager == null) {
            return null;
        }
        return (ITTDownloadVisitor) adManager.getExtra(ITTDownloadVisitor.class, com.bytedance.sdk.openadsdk.downloadnew.ok.ok(1));
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.downloadnew.bl$bl, reason: collision with other inner class name */
    public static class C0113bl implements com.ss.android.download.api.config.q {
        @Override // com.ss.android.download.api.config.q
        public void ok(Activity activity, int i2, String[] strArr, int[] iArr) {
        }

        @Override // com.ss.android.download.api.config.q
        public void ok(Activity activity, String[] strArr, final u uVar) {
            if (bl.n() != null) {
                bl.n().requestPermission(activity, strArr, new ITTPermissionCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.bl.1
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onDenied(String str) {
                        u uVar2 = uVar;
                        if (uVar2 != null) {
                            uVar2.ok(str);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onGranted() {
                        u uVar2 = uVar;
                        if (uVar2 != null) {
                            uVar2.ok();
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.download.api.config.q
        public boolean ok(Context context, String str) {
            if (bl.n() != null) {
                return bl.n().hasPermission(context, str);
            }
            return false;
        }
    }

    public static class ok implements h {
        private void bl(com.ss.android.download.api.model.bl blVar) {
            if (blVar == null) {
                return;
            }
            Object objJ = blVar.j();
            TTDownloadEventModel label = TTDownloadEventModel.builder().setTag(blVar.a()).setExtJson(blVar.p()).setMaterialMeta(objJ instanceof JSONObject ? (JSONObject) objJ : null).setLabel(blVar.bl());
            boolean z = "download_notification".equals(blVar.a()) || "landing_h5_download_ad_button".equals(blVar.a());
            if (bl.n() != null) {
                bl.n().executeLogUpload(label, z);
            }
        }

        @Override // com.ss.android.download.api.config.h
        public void a(com.ss.android.download.api.model.bl blVar) {
            com.bytedance.sdk.openadsdk.api.bl.a("LibEventLogger", "onEvent called");
            ok(blVar, false);
            bl(blVar);
        }

        @Override // com.ss.android.download.api.config.h
        public void ok(com.ss.android.download.api.model.bl blVar) {
            com.bytedance.sdk.openadsdk.api.bl.a("LibEventLogger", "onV3Event");
            ok(blVar, true);
        }

        private void ok(com.ss.android.download.api.model.bl blVar, boolean z) {
            TTDownloadEventLogger tTDownloadEventLogger;
            if (bl.n() == null || (tTDownloadEventLogger = bl.n().getTTDownloadEventLogger()) == null || blVar == null) {
                return;
            }
            if (tTDownloadEventLogger.shouldFilterOpenSdkLog() && bl.n().isOpenSdkEvent(blVar.toString())) {
                return;
            }
            if (z) {
                tTDownloadEventLogger.onV3Event(bl.a(blVar));
            } else {
                tTDownloadEventLogger.onEvent(bl.a(blVar));
            }
        }
    }

    public static void a() {
        ok().h();
        if (n() != null) {
            n().clearAllData(ok);
        }
    }

    public static void ok(Context context) {
        if (context == null) {
            context = TTAppContextHolder.getContext();
        }
        if (context == null) {
            return;
        }
        AtomicBoolean atomicBoolean = s;
        if (atomicBoolean.get()) {
            return;
        }
        synchronized (bl.class) {
            if (!atomicBoolean.get()) {
                n = context.getApplicationContext();
                if (n() != null) {
                    String strInitPath = n().initPath(f6366a);
                    if (!TextUtils.isEmpty(strInitPath)) {
                        ok = strInitPath;
                    }
                }
                atomicBoolean.set(a(n));
            }
        }
    }

    public static class a implements p {
        private a() {
        }

        @Override // com.ss.android.download.api.config.p
        public void ok(String str, String str2, Map<String, Object> map, final td tdVar) {
            str.hashCode();
            int i2 = 0;
            if (!str.equals("GET") && str.equals("POST")) {
                i2 = 1;
            }
            if (bl.n() != null) {
                bl.n().execute(i2, str2, map, new ITTHttpCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.a.1
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onError(Throwable th) {
                        td tdVar2 = tdVar;
                        if (tdVar2 != null) {
                            tdVar2.ok(th);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onResponse(String str3) {
                        td tdVar2 = tdVar;
                        if (tdVar2 != null) {
                            tdVar2.ok(str3);
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.download.api.config.p
        public void ok(String str, byte[] bArr, String str2, int i2, final td tdVar) {
            if (bl.n() != null) {
                bl.n().postBody(str, bArr, str2, new ITTHttpCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.a.2
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onError(Throwable th) {
                        td tdVar2 = tdVar;
                        if (tdVar2 != null) {
                            tdVar2.ok(th);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onResponse(String str3) {
                        td tdVar2 = tdVar;
                        if (tdVar2 != null) {
                            tdVar2.ok(str3);
                        }
                    }
                });
            }
        }
    }

    public static class s implements j {
        private final WeakReference<Context> ok;

        public s(Context context) {
            this.ok = new WeakReference<>(context);
        }

        private DialogBuilder bl(final com.ss.android.download.api.model.a aVar) {
            return DialogBuilder.builder().setTitle(aVar.f9721a).setMessage(aVar.bl).setNegativeBtnText(aVar.n).setPositiveBtnText(aVar.s).setIcon(aVar.f9722h).setDialogStatusChangedListener(new IDialogStatusChangedListener() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.s.1
                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onCancel(DialogInterface dialogInterface) {
                    a.InterfaceC0128a interfaceC0128a = aVar.p;
                    if (interfaceC0128a != null) {
                        interfaceC0128a.bl(dialogInterface);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onNegativeBtnClick(DialogInterface dialogInterface) {
                    a.InterfaceC0128a interfaceC0128a = aVar.p;
                    if (interfaceC0128a != null) {
                        try {
                            interfaceC0128a.a(dialogInterface);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onPositiveBtnClick(DialogInterface dialogInterface) {
                    a.InterfaceC0128a interfaceC0128a = aVar.p;
                    if (interfaceC0128a != null) {
                        interfaceC0128a.ok(dialogInterface);
                    }
                }
            });
        }

        @Override // com.ss.android.download.api.config.j
        public void ok(int i2, Context context, DownloadModel downloadModel, String str, Drawable drawable, int i3) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Toast.makeText(context, str, 0).show();
            } catch (Exception e2) {
                com.ss.android.socialbase.downloader.bl.ok.n("LibUIFactory", "showToastWithDuration e " + e2.getMessage());
            }
        }

        @Override // com.ss.android.download.api.config.j
        /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
        public AlertDialog a(com.ss.android.download.api.model.a aVar) {
            if (aVar != null && bl.n() != null) {
                Context context = aVar.ok;
                if (context != null && (context instanceof Activity)) {
                    return bl.n().showDialogBySelf((Activity) aVar.ok, aVar.k == 1, bl(aVar));
                }
                bl.n().showDialogByDelegate(this.ok, aVar.k == 1, bl(aVar));
            }
            return null;
        }
    }

    private static boolean a(Context context) {
        com.ss.android.download.api.ok okVarOk;
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            packageName = "";
        }
        if (kf()) {
            try {
                okVarOk = com.ss.android.downloadlib.p.ok(applicationContext).ok("pangolin");
            } catch (Throwable unused) {
                okVarOk = com.ss.android.downloadlib.p.ok(applicationContext).ok();
            }
        } else {
            okVarOk = com.ss.android.downloadlib.p.ok(applicationContext).ok();
        }
        if (okVarOk == null) {
            return false;
        }
        okVarOk.ok(new C0113bl()).ok(new ok()).ok(new s(applicationContext)).ok(new a()).ok(new k() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.3
            @Override // com.ss.android.download.api.config.k
            public JSONObject ok() {
                return bl.n() != null ? bl.n().getDownloadSettings() : new JSONObject();
            }
        }).ok(new com.ss.android.download.api.config.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.2
            @Override // com.ss.android.download.api.config.a
            public boolean ok() {
                if (bl.n() != null) {
                    return bl.n().getAppIsBackground();
                }
                return false;
            }
        }).ok(new ok.C0129ok().a("143").ok("open_news").bl("5.9.0.8").s(String.valueOf(5908)).ok()).ok(new x() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.1
            @Override // com.ss.android.download.api.config.x
            public byte[] ok(byte[] bArr, int i2) {
                return new byte[0];
            }
        }).ok(packageName + ".TTFileProvider").ok(ok(applicationContext, n() != null ? n().getDownloadSettings() : new JSONObject())).ok();
        com.ss.android.downloadlib.h.ok.ok();
        com.ss.android.downloadlib.p.ok(applicationContext).s().ok(1);
        com.ss.android.downloadlib.p.ok(applicationContext).ok(f6367h);
        com.ss.android.socialbase.appdownloader.s.k().ok(new fb() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.4
            @Override // com.ss.android.socialbase.downloader.depend.fb
            public boolean ok(Intent intent) {
                return false;
            }
        });
        TTDownloadEventLogger tTDownloadEventLogger = n() != null ? n().getTTDownloadEventLogger() : null;
        if (tTDownloadEventLogger != null) {
            tTDownloadEventLogger.onDownloadConfigReady();
        }
        return true;
    }

    public static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> bl() {
        return kf;
    }

    public static void ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ok = str;
    }

    public static com.ss.android.downloadlib.p ok() {
        ok(getContext());
        return com.ss.android.downloadlib.p.ok(getContext());
    }

    public static boolean ok(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return ok().n().ok(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener);
    }

    public static boolean ok(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return ok().n().ok(context, uri, downloadModel, downloadEventConfig, downloadController);
    }

    public static boolean ok(Uri uri) {
        return com.ss.android.downloadlib.a.k.ok(uri);
    }

    public static void ok(int i2) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> map = kf;
        if (map != null) {
            map.remove(Integer.valueOf(i2));
        }
    }

    public static void ok(int i2, ITTDownloadAdapter.OnEventLogHandler onEventLogHandler) {
        if (onEventLogHandler != null) {
            if (kf == null) {
                kf = Collections.synchronizedMap(new WeakHashMap());
            }
            kf.put(Integer.valueOf(i2), onEventLogHandler);
        }
    }

    public static boolean ok(String str, String str2, JSONObject jSONObject, Object obj) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> mapBl;
        boolean z = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && jSONObject != null && (mapBl = bl()) != null) {
            for (Map.Entry<Integer, ITTDownloadAdapter.OnEventLogHandler> entry : mapBl.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                ITTDownloadAdapter.OnEventLogHandler value = entry.getValue();
                if (value != null) {
                    boolean zOnEventLog = value.onEventLog(iIntValue, jSONObject.toString(), str, str2, obj);
                    if (!z && !zOnEventLog) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    private static DownloaderBuilder ok(Context context, JSONObject jSONObject) {
        return new DownloaderBuilder(context).downloadSetting(new vz() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.5
            @Override // com.ss.android.socialbase.downloader.depend.vz
            public JSONObject ok() {
                return bl.n() != null ? bl.n().getDownloadSettings() : new JSONObject();
            }
        }).downloadExpSwitch(jSONObject.optInt("download_exp_switch_temp", 1040187391)).httpService(new n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject a(com.ss.android.download.api.model.bl blVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", blVar.ok());
            jSONObject.put("tag", blVar.a());
            jSONObject.put("label", blVar.bl());
            jSONObject.put(TTDownloadField.TT_IS_AD, blVar.s());
            jSONObject.put("adId", blVar.n());
            jSONObject.put(TTDownloadField.TT_LOG_EXTRA, blVar.kf());
            jSONObject.put("extValue", blVar.h());
            jSONObject.put("extJson", blVar.p());
            jSONObject.put(TTDownloadField.TT_PARAMS_JSON, blVar.q());
            jSONObject.put("eventSource", blVar.r());
            jSONObject.put(TTDownloadField.TT_EXTRA_OBJECT, blVar.j());
            jSONObject.put(TTDownloadField.TT_CLICK_TRACK_URL, blVar.k());
            jSONObject.put("isV3", blVar.z());
            jSONObject.put("V3EventName", blVar.rh());
            jSONObject.put("V3EventParams", blVar.t());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static boolean ok(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            List<DownloadInfo> listA = com.ss.android.socialbase.appdownloader.s.k().a(context);
            if (!listA.isEmpty()) {
                for (DownloadInfo downloadInfo : listA) {
                    if (downloadInfo != null && str.equals(downloadInfo.getUrl())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean ok(Activity activity, final ExitInstallListener exitInstallListener) {
        return com.ss.android.downloadlib.addownload.ok.ok.ok().ok(activity, false, new ok.InterfaceC0133ok() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.7
            @Override // com.ss.android.downloadlib.addownload.ok.ok.InterfaceC0133ok
            public void ok() {
                ExitInstallListener exitInstallListener2 = exitInstallListener;
                if (exitInstallListener2 != null) {
                    exitInstallListener2.onExitInstall();
                }
            }
        });
    }
}
