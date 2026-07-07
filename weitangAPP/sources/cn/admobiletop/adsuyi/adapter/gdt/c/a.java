package cn.admobiletop.adsuyi.adapter.gdt.c;

import android.app.Activity;
import cn.admobiletop.adsuyi.adapter.gdt.widget.DownloadApkConfirmDialogActivity;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;

/* JADX INFO: loaded from: classes.dex */
public class a implements DownloadConfirmListener {
    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        try {
            DownloadApkConfirmDialogActivity.a(activity, str, downloadConfirmCallBack);
        } catch (Exception unused) {
            downloadConfirmCallBack.onConfirm();
        }
    }
}
