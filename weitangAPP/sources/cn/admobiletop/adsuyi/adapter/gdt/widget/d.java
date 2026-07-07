package cn.admobiletop.adsuyi.adapter.gdt.widget;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
public class d implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DownloadApkConfirmDialogActivity f3774a;

    public d(DownloadApkConfirmDialogActivity downloadApkConfirmDialogActivity) {
        this.f3774a = downloadApkConfirmDialogActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f3774a.finish();
    }
}
