package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.appdownloader.bl.bl;
import com.ss.android.socialbase.appdownloader.bl.j;
import com.ss.android.socialbase.appdownloader.bl.r;
import com.ss.android.socialbase.appdownloader.q;
import com.ss.android.socialbase.appdownloader.s;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.q.kf;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadTaskDeleteActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Intent f9964a;
    private r ok;

    private void a() {
        Intent intent;
        if (this.ok != null || (intent = this.f9964a) == null) {
            return;
        }
        try {
            final boolean z = false;
            final int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
            final DownloadInfo downloadInfo = Downloader.getInstance(getApplicationContext()).getDownloadInfo(intExtra);
            if (downloadInfo == null) {
                return;
            }
            String title = downloadInfo.getTitle();
            if (TextUtils.isEmpty(title)) {
                Log.w("DeleteActivity", "Missing appName; skipping handle");
                return;
            }
            String string = String.format(getString(q.ok(this, "tt_appdownloader_notification_download_delete")), title);
            bl blVarOk = s.k().ok();
            j jVarOk = blVarOk != null ? blVarOk.ok(this) : null;
            if (jVarOk == null) {
                jVarOk = new com.ss.android.socialbase.appdownloader.s.ok(this);
            }
            int iOk = q.ok(this, "tt_appdownloader_tip");
            int iOk2 = q.ok(this, "tt_appdownloader_label_ok");
            int iOk3 = q.ok(this, "tt_appdownloader_label_cancel");
            if (com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("cancel_with_net_opt", 0) == 1 && kf.p() && downloadInfo.getCurBytes() != downloadInfo.getTotalBytes()) {
                z = true;
            }
            if (z) {
                iOk2 = q.ok(this, "tt_appdownloader_label_reserve_wifi");
                iOk3 = q.ok(this, "tt_appdownloader_label_cancel_directly");
                string = getResources().getString(q.ok(this, "tt_appdownloader_resume_in_wifi"));
            }
            jVarOk.ok(iOk).ok(string).ok(iOk2, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    if (z) {
                        downloadInfo.setOnlyWifi(true);
                        Downloader.getInstance(DownloadTaskDeleteActivity.this).pause(downloadInfo.getId());
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Downloader.getInstance(DownloadTaskDeleteActivity.this).resume(downloadInfo.getId());
                            }
                        }, 100L);
                    } else {
                        DownloadTaskDeleteActivity.this.ok(downloadInfo, intExtra);
                    }
                    DownloadTaskDeleteActivity.this.finish();
                }
            }).a(iOk3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    if (z) {
                        DownloadTaskDeleteActivity.this.ok(downloadInfo, intExtra);
                    }
                    DownloadTaskDeleteActivity.this.finish();
                }
            }).ok(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    DownloadTaskDeleteActivity.this.finish();
                }
            });
            this.ok = jVarOk.ok();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ok();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f9964a = getIntent();
        a();
        r rVar = this.ok;
        if (rVar != null && !rVar.a()) {
            this.ok.ok();
        } else if (this.ok == null) {
            finish();
        }
    }

    private void ok() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(DownloadInfo downloadInfo, int i2) {
        com.ss.android.socialbase.appdownloader.bl.s sVarA = s.k().a();
        if (sVarA != null) {
            sVarA.ok(downloadInfo);
        }
        ep downloadNotificationEventListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).getDownloadNotificationEventListener(i2);
        if (downloadNotificationEventListener != null) {
            downloadNotificationEventListener.ok(10, downloadInfo, "", "");
        }
        if (com.ss.android.socialbase.downloader.downloader.bl.l() != null) {
            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).cancel(i2);
        }
    }
}
