package com.ss.android.socialbase.appdownloader.ok;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;

/* JADX INFO: loaded from: classes2.dex */
public class p extends ok {
    public p(Context context, com.ss.android.socialbase.downloader.h.ok okVar, String str) {
        super(context, okVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.ok.n
    public Intent a() {
        Intent intent = new Intent(com.ss.android.socialbase.downloader.constants.n.bl + ".intent.action.OPEN_FILEMANAGER");
        intent.putExtra("CurrentDir", this.bl);
        intent.putExtra("first_position", 1);
        intent.putExtra("CurrentMode", 1);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(WXVideoFileObject.FILE_SIZE_LIMIT);
        return intent;
    }
}
