package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements OAuthListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ a f10529f;

    public b(a aVar) {
        this.f10529f = aVar;
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onAuthFinish(OAuthErrCode oAuthErrCode, String str) {
        Log.d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", oAuthErrCode.toString(), str));
        a.c(this.f10529f);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f10529f.f10526c);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((OAuthListener) it.next()).onAuthFinish(oAuthErrCode, str);
        }
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onAuthGotQrcode(String str, byte[] bArr) {
        Log.d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f10529f.f10526c);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((OAuthListener) it.next()).onAuthGotQrcode(str, bArr);
        }
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onQrcodeScanned() {
        Log.d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
        if (this.f10529f.handler != null) {
            this.f10529f.handler.post(new c(this));
        }
    }
}
