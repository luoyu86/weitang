package com.bytedance.pangle.f;

import android.os.RemoteException;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.d;

/* JADX INFO: loaded from: classes.dex */
public final class c extends ZeusPluginStateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f6066b;

    public c(d dVar, int i2) {
        this.f6066b = dVar;
        this.f6065a = i2;
    }

    @Override // com.bytedance.pangle.ZeusPluginStateListener
    public final void onStateChangeOnCurThread(String str, int i2, Object... objArr) {
        if (i2 == 5 || i2 == 7 || i2 == 6) {
            String strValueOf = "";
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        strValueOf = String.valueOf(objArr[0]);
                    }
                } catch (RemoteException unused) {
                    return;
                }
            }
            this.f6066b.a(str, i2, strValueOf);
        }
    }
}
