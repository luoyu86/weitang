package cn.admobiletop.adsuyi.adapter.gdt.c;

import cn.admobiletop.adsuyi.ADSuyiSdk;
import com.qq.e.comm.compliance.DownloadConfirmListener;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DownloadConfirmListener f3680a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DownloadConfirmListener f3681b = new b();

    public static boolean a() {
        int downloadTip = ADSuyiSdk.getInstance().getDownloadTip();
        if (downloadTip != 0) {
            return downloadTip != 1 ? downloadTip == 2 : !cn.admobiletop.adsuyi.adapter.gdt.e.b.a();
        }
        return false;
    }
}
