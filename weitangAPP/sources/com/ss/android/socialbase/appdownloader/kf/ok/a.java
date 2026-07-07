package com.ss.android.socialbase.appdownloader.kf.ok;

import com.alibaba.android.arouter.utils.Consts;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final void ok(s sVar, int i2) throws IOException {
        int iA = sVar.a();
        if (iA == i2) {
            return;
        }
        throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i2) + ", read 0x" + Integer.toHexString(iA) + Consts.DOT);
    }
}
