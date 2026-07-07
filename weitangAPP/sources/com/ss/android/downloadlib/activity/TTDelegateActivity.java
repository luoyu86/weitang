package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import com.ss.android.download.api.config.u;
import com.ss.android.download.api.model.a;
import com.ss.android.downloadad.api.ok.a;
import com.ss.android.downloadlib.addownload.a.kf;
import com.ss.android.downloadlib.addownload.ok.n;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.addownload.z;
import com.ss.android.downloadlib.guide.install.ok;
import com.ss.android.downloadlib.h.j;
import com.ss.android.downloadlib.h.k;
import com.ss.android.downloadlib.p;
import com.ss.android.socialbase.appdownloader.bl;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTDelegateActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {
    private static ok s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f9762a;
    private a bl;
    public Intent ok = null;

    public static void a(String str, com.ss.android.downloadad.api.ok.ok okVar) {
        Intent intentBl = bl(okVar);
        intentBl.addFlags(268435456);
        intentBl.putExtra("type", 11);
        intentBl.putExtra("package_name", str);
        if (r.getContext() != null) {
            r.getContext().startActivity(intentBl);
        }
    }

    private static Intent bl(@NonNull com.ss.android.downloadad.api.ok.ok okVar) {
        return new Intent(r.getContext(), (Class<?>) TTDelegateActivity.class);
    }

    public static void ok(String str, String[] strArr) {
        Intent intent = new Intent(r.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (r.getContext() != null) {
            r.getContext().startActivity(intent);
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        a();
        this.ok = getIntent();
        r.a(this);
        ok();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.ok = intent;
        r.a(this);
        ok();
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        r.n().ok(this, i2, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onStop() {
        a aVar;
        super.onStop();
        if (!this.f9762a || (aVar = this.bl) == null) {
            return;
        }
        DownloadInfo downloadInfoOk = !TextUtils.isEmpty(aVar.ld()) ? p.ok(r.getContext()).ok(this.bl.ld(), null, true) : p.ok(r.getContext()).a(this.bl.ok());
        if (downloadInfoOk == null || downloadInfoOk.getCurBytes() < downloadInfoOk.getTotalBytes() || isFinishing()) {
            return;
        }
        finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void bl() {
        /*
            Method dump skipped, instruction units count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.activity.TTDelegateActivity.bl():void");
    }

    public static void a(String str, long j, String str2) {
        Intent intent = new Intent(r.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 14);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra("market_app_id", str2);
        if (r.getContext() != null) {
            r.getContext().startActivity(intent);
        }
    }

    public static void ok(String str, com.ss.android.downloadad.api.ok.ok okVar) {
        Intent intentBl = bl(okVar);
        intentBl.addFlags(268435456);
        intentBl.putExtra("type", 2);
        intentBl.putExtra("open_url", str);
        if (r.getContext() != null) {
            r.getContext().startActivity(intentBl);
        }
    }

    public static void ok(com.ss.android.downloadad.api.ok.ok okVar) {
        Intent intentBl = bl(okVar);
        intentBl.addFlags(268435456);
        intentBl.putExtra("type", 4);
        intentBl.putExtra("model_id", okVar.a());
        if (r.getContext() != null) {
            r.getContext().startActivity(intentBl);
        }
    }

    public static void a(@NonNull com.ss.android.downloadad.api.ok.ok okVar) {
        ok(okVar, 5, "", "", "", "");
    }

    public static void a(@NonNull com.ss.android.downloadad.api.ok.ok okVar, String str, String str2, String str3) {
        ok(okVar, 7, str, str2, str3, "");
    }

    public static void a(@NonNull com.ss.android.downloadad.api.ok.ok okVar, String str, String str2, String str3, String str4) {
        ok(okVar, 20, str, str2, str3, str4);
    }

    private void a() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    public static void ok(com.ss.android.downloadad.api.ok.ok okVar, ok okVar2) {
        Intent intentBl = bl(okVar);
        intentBl.addFlags(268435456);
        intentBl.putExtra("type", 9);
        s = okVar2;
        if (r.getContext() != null) {
            r.getContext().startActivity(intentBl);
        }
    }

    private void a(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            u uVar = new u() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.1
                private WeakReference<Activity> bl;

                {
                    this.bl = new WeakReference<>(TTDelegateActivity.this);
                }

                @Override // com.ss.android.download.api.config.u
                public void ok() {
                    k.ok(str);
                    bl.ok(this.bl.get());
                }

                @Override // com.ss.android.download.api.config.u
                public void ok(String str2) {
                    k.ok(str, str2);
                    bl.ok(this.bl.get());
                }
            };
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    r.n().ok(this, strArr, uVar);
                    return;
                } catch (Exception e2) {
                    r.u().ok(e2, "requestPermission");
                    uVar.ok();
                    return;
                }
            }
            uVar.ok();
            return;
        }
        bl.ok((Activity) this);
    }

    public static void ok(long j) {
        Intent intent = new Intent(r.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 10);
        intent.putExtra("app_info_id", j);
        if (r.getContext() != null) {
            r.getContext().startActivity(intent);
        }
    }

    private void a(String str) {
        Intent intentH = j.h(this, str);
        if (intentH == null) {
            return;
        }
        try {
            try {
                intentH.addFlags(268435456);
                intentH.putExtra("start_only_for_android", true);
                startActivity(intentH);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            bl.ok((Activity) this);
        }
    }

    public static void ok(String str, long j, String str2, @NonNull JSONObject jSONObject) {
        Intent intent = new Intent(r.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 12);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra("param", str2);
        intent.putExtra("ext_json", jSONObject.toString());
        if (r.getContext() != null) {
            r.getContext().startActivity(intent);
        }
    }

    private void a(long j) {
        final a aVarS = kf.ok().s(j);
        if (aVarS == null) {
            com.ss.android.downloadlib.n.bl.ok().ok("showOpenAppDialogInner nativeModel null");
            bl.ok((Activity) this);
            return;
        }
        com.ss.android.download.api.config.j jVarBl = r.bl();
        a.ok okVarOk = new a.ok(this).ok("已安装完成");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(aVarS.ah()) ? "刚刚下载的应用" : aVarS.ah();
        jVarBl.a(okVarOk.a(String.format("%1$s已安装完成，是否立即打开？", objArr)).bl("打开").s("取消").ok(false).ok(j.s(this, aVarS.n())).ok(new a.InterfaceC0128a() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.2
            @Override // com.ss.android.download.api.model.a.InterfaceC0128a
            public void a(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.s.ok.ok().a("market_openapp_cancel", aVarS);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                bl.ok((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.model.a.InterfaceC0128a
            public void bl(DialogInterface dialogInterface) {
                bl.ok((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.model.a.InterfaceC0128a
            public void ok(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.a.ok.a(aVarS);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                bl.ok((Activity) TTDelegateActivity.this);
            }
        }).ok(2).ok());
        com.ss.android.downloadlib.s.ok.ok().a("market_openapp_window_show", aVarS);
    }

    public static void ok(String str, long j, String str2) {
        Intent intent = new Intent(r.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 13);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra("need_comment", str2);
        if (r.getContext() != null) {
            r.getContext().startActivity(intent);
        }
    }

    public static void ok(String str, long j) {
        Intent intent = new Intent(r.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 15);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        if (r.getContext() != null) {
            r.getContext().startActivity(intent);
        }
    }

    private void bl(long j) {
        new com.ss.android.downloadlib.addownload.compliance.ok(this, j).show();
    }

    public static void ok(@NonNull com.ss.android.downloadad.api.ok.ok okVar, String str) {
        ok(okVar, 19, "", "", "", str);
    }

    public static void ok(@NonNull com.ss.android.downloadad.api.ok.ok okVar, String str, String str2, String str3) {
        ok(okVar, 8, str, str2, str3, "");
    }

    public static void ok(@NonNull com.ss.android.downloadad.api.ok.ok okVar, String str, String str2, String str3, String str4) {
        ok(okVar, 21, str, str2, str3, str4);
    }

    private static void ok(@NonNull com.ss.android.downloadad.api.ok.ok okVar, int i2, String str, String str2, String str3, String str4) {
        Intent intentBl = bl(okVar);
        intentBl.addFlags(268435456);
        intentBl.putExtra("type", i2);
        if (!TextUtils.isEmpty(str2)) {
            intentBl.putExtra("positive_button_text", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intentBl.putExtra("negative_button_text", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            intentBl.putExtra("delete_button_text", str4);
        }
        if (!TextUtils.isEmpty(str)) {
            intentBl.putExtra("message_text", str);
        }
        intentBl.putExtra("model_id", okVar.a());
        if (r.getContext() != null) {
            r.getContext().startActivity(intentBl);
        }
    }

    public void ok() {
        Intent intent = this.ok;
        if (intent == null) {
            return;
        }
        switch (intent.getIntExtra("type", 0)) {
            case 1:
                a(this.ok.getStringExtra("permission_id_key"), this.ok.getStringArrayExtra("permission_content_key"));
                break;
            case 2:
                ok(this.ok.getStringExtra("open_url"));
                break;
            case 3:
            case 6:
            case 16:
            case 17:
            case 18:
            default:
                bl.ok((Activity) this);
                break;
            case 4:
                a(this.ok.getLongExtra("model_id", 0L));
                break;
            case 5:
                ok(this.ok.getLongExtra("model_id", 0L), "");
                break;
            case 7:
            case 8:
            case 20:
            case 21:
                bl();
                break;
            case 9:
                ok okVar = s;
                if (okVar != null) {
                    okVar.ok();
                }
                bl.ok((Activity) this);
                break;
            case 10:
                bl(this.ok.getLongExtra("app_info_id", 0L));
                break;
            case 11:
                a(this.ok.getStringExtra("package_name"));
                break;
            case 12:
                com.ss.android.downloadlib.h.p.ok(this, this.ok.getStringExtra("package_name"), this.ok.getLongExtra("model_id", 0L), this.ok.getStringExtra("param"), this.ok.getStringExtra("ext_json"));
                bl.ok((Activity) this);
                break;
            case 13:
                com.ss.android.downloadlib.h.p.ok(this, this.ok.getStringExtra("package_name"), this.ok.getLongExtra("model_id", 0L), this.ok.getStringExtra("need_comment"));
                bl.ok((Activity) this);
                break;
            case 14:
                com.ss.android.downloadlib.h.p.a(this, this.ok.getStringExtra("package_name"), this.ok.getLongExtra("model_id", 0L), this.ok.getStringExtra("market_app_id"));
                bl.ok((Activity) this);
                break;
            case 15:
                com.ss.android.downloadlib.h.p.ok(this, this.ok.getStringExtra("package_name"), this.ok.getLongExtra("model_id", 0L));
                bl.ok((Activity) this);
                break;
            case 19:
                ok(this.ok.getLongExtra("model_id", 0L), this.ok.getStringExtra("delete_button_text"));
                break;
        }
        this.ok = null;
    }

    private void ok(long j, String str) {
        if (z.ok() == null) {
            return;
        }
        com.ss.android.downloadad.api.ok.a aVarS = kf.ok().s(j);
        if (aVarS != null) {
            DownloadInfo downloadInfo = Downloader.getInstance(r.getContext()).getDownloadInfo(aVarS.zz());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - aVarS.qx()));
                jSONObject.putOpt("click_download_size", Long.valueOf(aVarS.tr()));
                if (downloadInfo != null) {
                    jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
                    jSONObject.putOpt("download_percent", Long.valueOf(downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_current_bytes", Integer.valueOf((int) (downloadInfo.getCurBytes() / 1048576)));
                    jSONObject.putOpt("download_total_bytes", Integer.valueOf((int) (downloadInfo.getTotalBytes() / 1048576)));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (!TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.s.ok.ok().ok("cancel_pause_reserve_wifi_dialog_show", jSONObject, aVarS);
            } else {
                com.ss.android.downloadlib.s.ok.ok().a("pause_reserve_wifi_dialog_show", jSONObject, aVarS);
            }
        }
        n.ok okVarOk = new n.ok(this).ok(false).ok(z.ok());
        if (!TextUtils.isEmpty(str)) {
            okVarOk.s(str).ok(z.a());
        }
        okVarOk.ok().show();
        this.f9762a = true;
        this.bl = aVarS;
    }

    private void ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                Uri uri = Uri.parse(str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                intent.putExtra("open_url", str);
                intent.addFlags(268435456);
                if (com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_app_link_flag")) {
                    intent.addFlags(67108864);
                }
                intent.putExtra("start_only_for_android", true);
                startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            bl.ok((Activity) this);
        }
    }
}
