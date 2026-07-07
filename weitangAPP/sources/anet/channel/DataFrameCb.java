package anet.channel;

import anet.channel.session.TnetSpdySession;

/* JADX INFO: loaded from: classes.dex */
public interface DataFrameCb {
    void onDataReceive(TnetSpdySession tnetSpdySession, byte[] bArr, int i2, int i3);

    void onException(int i2, int i3, boolean z, String str);
}
