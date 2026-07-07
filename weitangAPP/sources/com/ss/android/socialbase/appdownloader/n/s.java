package com.ss.android.socialbase.appdownloader.n;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import com.ss.android.socialbase.appdownloader.bl.rh;
import com.ss.android.socialbase.appdownloader.q;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<rh> f9947a = new ArrayList();
    private static com.ss.android.socialbase.appdownloader.view.ok bl = null;
    private static final String ok = "s";
    private static AlertDialog s;

    public static void a(@NonNull Activity activity, @NonNull rh rhVar) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    String str = ok;
                    com.ss.android.socialbase.appdownloader.view.ok okVar = (com.ss.android.socialbase.appdownloader.view.ok) fragmentManager.findFragmentByTag(str);
                    bl = okVar;
                    if (okVar == null) {
                        bl = new com.ss.android.socialbase.appdownloader.view.ok();
                        fragmentManager.beginTransaction().add(bl, str).commitAllowingStateLoss();
                        try {
                            fragmentManager.executePendingTransactions();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    bl.ok();
                    return;
                }
            } catch (Throwable th2) {
                try {
                    th2.printStackTrace();
                    rhVar.ok();
                    return;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return;
                }
            }
        }
        rhVar.ok();
    }

    public static boolean ok() {
        try {
            return NotificationManagerCompat.from(com.ss.android.socialbase.downloader.downloader.bl.l()).areNotificationsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public static synchronized void ok(boolean z) {
        try {
            AlertDialog alertDialog = s;
            if (alertDialog != null) {
                alertDialog.cancel();
                s = null;
            }
            for (rh rhVar : f9947a) {
                if (rhVar != null) {
                    if (z) {
                        rhVar.ok();
                    } else {
                        rhVar.a();
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized void ok(@NonNull final Activity activity, @NonNull final rh rhVar) {
        if (rhVar == null) {
            return;
        }
        if (activity != null) {
            try {
            } catch (Throwable th) {
                th.printStackTrace();
                ok(false);
            }
            if (!activity.isFinishing()) {
                int iOk = q.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), "tt_appdownloader_notification_request_title");
                int iOk2 = q.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), "tt_appdownloader_notification_request_message");
                int iOk3 = q.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), "tt_appdownloader_notification_request_btn_yes");
                int iOk4 = q.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), "tt_appdownloader_notification_request_btn_no");
                f9947a.add(rhVar);
                AlertDialog alertDialog = s;
                if (alertDialog == null || !alertDialog.isShowing()) {
                    s = new AlertDialog.Builder(activity).setTitle(iOk).setMessage(iOk2).setPositiveButton(iOk3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.n.s.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            s.a(activity, rhVar);
                            dialogInterface.cancel();
                            AlertDialog unused = s.s = null;
                        }
                    }).setNegativeButton(iOk4, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.n.s.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            s.ok(false);
                        }
                    }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.ss.android.socialbase.appdownloader.n.s.1
                        @Override // android.content.DialogInterface.OnKeyListener
                        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                            if (i2 != 4) {
                                return false;
                            }
                            if (keyEvent.getAction() == 1) {
                                s.ok(false);
                            }
                            return true;
                        }
                    }).setCancelable(false).show();
                }
                return;
            }
        }
        rhVar.a();
    }
}
