package com.ss.android.downloadlib.addownload.s;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.z;

/* JADX INFO: loaded from: classes2.dex */
public class n implements h {
    @Override // com.ss.android.downloadlib.addownload.s.h
    public boolean ok(com.ss.android.downloadad.api.ok.a aVar, int i2, p pVar, com.ss.android.downloadlib.addownload.ok.bl blVar) {
        if (aVar == null) {
            return false;
        }
        return z.ok(aVar, !TextUtils.isEmpty(aVar.ld()) ? com.ss.android.downloadlib.p.ok(com.ss.android.downloadlib.addownload.r.getContext()).ok(aVar.ld(), null, true) : com.ss.android.downloadlib.p.ok(com.ss.android.downloadlib.addownload.r.getContext()).a(aVar.ok()), i2, pVar, true, blVar);
    }
}
