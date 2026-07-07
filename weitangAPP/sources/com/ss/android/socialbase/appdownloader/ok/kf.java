package com.ss.android.socialbase.appdownloader.ok;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;

/* JADX INFO: loaded from: classes2.dex */
public class kf extends ok {
    public kf(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.ok.n
    public Intent a() {
        Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(WXVideoFileObject.FILE_SIZE_LIMIT);
        intent.addFlags(8388608);
        return intent;
    }
}
