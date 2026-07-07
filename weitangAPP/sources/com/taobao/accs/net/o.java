package com.taobao.accs.net;

import anet.channel.session.TnetSpdySession;
import com.taobao.accs.AccsState;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;

/* JADX INFO: loaded from: classes2.dex */
public class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ byte[] f10395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TnetSpdySession f10396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ j f10397e;

    public o(j jVar, int i2, int i3, byte[] bArr, TnetSpdySession tnetSpdySession) {
        this.f10397e = jVar;
        this.f10393a = i2;
        this.f10394b = i3;
        this.f10395c = bArr;
        this.f10396d = tnetSpdySession;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f10397e.t.i("onDataReceive", "type", Integer.valueOf(this.f10393a), Constants.KEY_DATA_ID, Integer.valueOf(this.f10394b));
        AccsState.getInstance().a(this.f10397e.m, AccsState.LAST_MSG_RECEIVE_TIME, Integer.valueOf(this.f10394b));
        if (this.f10393a != 200) {
            this.f10397e.t.e("drop frame len:" + this.f10395c.length + " frameType" + this.f10393a);
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f10397e.f10355e.a(this.f10395c, this.f10396d.getHost());
            com.taobao.accs.ut.a.d dVarG = this.f10397e.f10355e.g();
            if (dVarG != null) {
                dVarG.f10442c = String.valueOf(jCurrentTimeMillis);
                dVarG.f10446g = this.f10397e.f10353c == 0 ? "service" : "inapp";
                dVarG.a();
            }
        } catch (Throwable th) {
            this.f10397e.t.e("onDataReceive", th);
            UTMini.getInstance().commitEvent(66001, "DATA_RECEIVE", UtilityImpl.a(th));
        }
    }
}
