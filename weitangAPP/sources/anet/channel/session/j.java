package anet.channel.session;

import anet.channel.security.ISecurity;
import anet.channel.util.ALog;
import org.android.spdy.AccsSSLCallback;
import org.android.spdy.SpdyProtocol;

/* JADX INFO: loaded from: classes.dex */
public class j implements AccsSSLCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TnetSpdySession f579a;

    public j(TnetSpdySession tnetSpdySession) {
        this.f579a = tnetSpdySession;
    }

    @Override // org.android.spdy.AccsSSLCallback
    public byte[] getSSLPublicKey(int i2, byte[] bArr) {
        byte[] bArrDecrypt;
        try {
            TnetSpdySession tnetSpdySession = this.f579a;
            bArrDecrypt = tnetSpdySession.G.decrypt(tnetSpdySession.f322a, ISecurity.CIPHER_ALGORITHM_AES128, SpdyProtocol.TNET_PUBKEY_SG_KEY, bArr);
            if (bArrDecrypt != null) {
                try {
                    if (ALog.isPrintLog(2)) {
                        ALog.i("getSSLPublicKey", null, "decrypt", new String(bArrDecrypt));
                    }
                } catch (Throwable th) {
                    th = th;
                    ALog.e("awcn.TnetSpdySession", "getSSLPublicKey", null, th, new Object[0]);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bArrDecrypt = null;
        }
        return bArrDecrypt;
    }
}
