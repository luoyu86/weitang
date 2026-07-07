package com.ss.android.socialbase.appdownloader.ok;

import android.content.Context;
import android.content.Intent;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;

/* JADX INFO: loaded from: classes2.dex */
public class j extends ok {
    public j(Context context, com.ss.android.socialbase.downloader.h.ok okVar, String str) {
        super(context, okVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.ok.n
    public Intent a() {
        String strBl = this.f9950a.bl(OperatorName.CLOSE_AND_STROKE);
        String strOk = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f9950a.bl("ag"), strBl);
        String strOk2 = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f9950a.bl("ah"), strBl);
        String strOk3 = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f9950a.bl("ai"), strBl);
        String strOk4 = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f9950a.bl("aj"), strBl);
        Intent intent = new Intent();
        intent.putExtra(strOk, this.bl);
        intent.putExtra(strOk2, "*/*");
        intent.putExtra(strOk3, true);
        intent.setAction(strOk4);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        return intent;
    }
}
