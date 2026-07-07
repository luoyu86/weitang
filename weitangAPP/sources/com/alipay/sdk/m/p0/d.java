package com.alipay.sdk.m.p0;

import android.database.ContentObserver;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class d extends ContentObserver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5596d = "VMS_IDLG_SDK_Observer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f5599c;

    public d(c cVar, int i2, String str) {
        super(null);
        this.f5599c = cVar;
        this.f5598b = i2;
        this.f5597a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        c cVar = this.f5599c;
        if (cVar != null) {
            cVar.a(this.f5598b, this.f5597a);
        } else {
            Log.e(f5596d, "mIdentifierIdClient is null");
        }
    }
}
