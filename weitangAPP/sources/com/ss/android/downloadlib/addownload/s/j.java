package com.ss.android.downloadlib.addownload.s;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.z;

/* JADX INFO: loaded from: classes2.dex */
public class j implements q {
    @Override // com.ss.android.downloadlib.addownload.s.q
    public boolean ok(com.ss.android.downloadad.api.ok.a aVar, int i2, p pVar) {
        if (aVar == null) {
            return false;
        }
        return z.ok(aVar, !TextUtils.isEmpty(aVar.ld()) ? com.ss.android.downloadlib.p.ok((Context) null).ok(aVar.ld(), null, true) : com.ss.android.downloadlib.p.ok((Context) null).a(aVar.ok()), i2, pVar, false, null);
    }
}
