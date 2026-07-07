package anet.channel.request;

import anet.channel.util.ALog;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdySession;

/* JADX INFO: loaded from: classes.dex */
public class c implements Cancelable {
    public static final c NULL = new c(null, 0, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SpdySession f551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f552c;

    public c(SpdySession spdySession, int i2, String str) {
        this.f551b = spdySession;
        this.f550a = i2;
        this.f552c = str;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        int i2;
        try {
            if (this.f551b == null || (i2 = this.f550a) == 0) {
                return;
            }
            ALog.i("awcn.TnetCancelable", "cancel tnet request", this.f552c, "streamId", Integer.valueOf(i2));
            this.f551b.streamReset(this.f550a, 5);
        } catch (SpdyErrorException e2) {
            ALog.e("awcn.TnetCancelable", "request cancel failed.", this.f552c, e2, "errorCode", Integer.valueOf(e2.SpdyErrorGetCode()));
        }
    }
}
