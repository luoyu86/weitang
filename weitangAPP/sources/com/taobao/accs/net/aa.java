package com.taobao.accs.net;

import com.taobao.accs.utl.UtilityImpl;
import org.android.spdy.AccsSSLCallback;

/* JADX INFO: loaded from: classes2.dex */
public class aa implements AccsSSLCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f10350a;

    public aa(w wVar) {
        this.f10350a = wVar;
    }

    @Override // org.android.spdy.AccsSSLCallback
    public byte[] getSSLPublicKey(int i2, byte[] bArr) {
        return UtilityImpl.a();
    }
}
