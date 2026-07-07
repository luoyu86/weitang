package cn.admobiletop.adsuyi.a.m;

import cn.admobiletop.adsuyi.ADSuyiSdk;

/* JADX INFO: loaded from: classes.dex */
public class g {
    public static boolean a() {
        int downloadTip = ADSuyiSdk.getInstance().getDownloadTip();
        if (2 == downloadTip) {
            return true;
        }
        return (downloadTip == 0 || 1 != downloadTip || l.a()) ? false : true;
    }
}
