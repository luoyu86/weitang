package com.ss.android.socialbase.appdownloader.ok;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;

/* JADX INFO: loaded from: classes2.dex */
public class r extends ok {
    public r(Context context, com.ss.android.socialbase.downloader.h.ok okVar, String str) {
        super(context, okVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.ok.n
    public Intent a() {
        Intent intent = new Intent("com.android.filemanager.OPEN_FOLDER");
        intent.putExtra("com.android.filemanager.OPEN_FOLDER", this.bl);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(WXVideoFileObject.FILE_SIZE_LIMIT);
        return intent;
    }
}
