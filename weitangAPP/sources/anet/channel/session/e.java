package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.request.Request;

/* JADX INFO: loaded from: classes.dex */
public class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Request f570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f571b;

    public e(d dVar, Request request) {
        this.f571b = dVar;
        this.f570a = request;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2 = b.a(this.f570a, (RequestCb) null).f564a;
        if (i2 > 0) {
            this.f571b.notifyStatus(4, new anet.channel.entity.b(1));
        } else {
            this.f571b.handleCallbacks(256, new anet.channel.entity.b(256, i2, "Http connect fail"));
        }
    }
}
