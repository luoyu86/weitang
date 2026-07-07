package com.ss.android.socialbase.appdownloader.ok;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;

/* JADX INFO: loaded from: classes2.dex */
public class h extends ok {
    public h(Context context, com.ss.android.socialbase.downloader.h.ok okVar, String str) {
        super(context, okVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.ok.n
    public Intent a() {
        Intent intent = new Intent(com.ss.android.socialbase.downloader.constants.n.bl + ".filemanager.intent.action.BROWSER_FILE");
        intent.putExtra("CurrentDir", this.bl);
        intent.putExtra("CurrentMode", 1);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(WXVideoFileObject.FILE_SIZE_LIMIT);
        return intent;
    }
}
