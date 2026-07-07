package cn.admobiletop.adsuyi.adapter.gdt.c;

import android.app.Activity;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;

/* JADX INFO: loaded from: classes.dex */
public class b implements DownloadConfirmListener {
    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        try {
            new cn.admobiletop.adsuyi.adapter.gdt.widget.f(activity, str, downloadConfirmCallBack).show();
        } catch (Exception unused) {
            downloadConfirmCallBack.onConfirm();
        }
    }
}
