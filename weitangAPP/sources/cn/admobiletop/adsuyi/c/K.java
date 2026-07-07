package cn.admobiletop.adsuyi.c;

import android.os.Message;
import cn.admobiletop.adsuyi.c.L;

/* JADX INFO: loaded from: classes.dex */
public class K implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Message f4182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ L.a f4183b;

    public K(L.a aVar, Message message) {
        this.f4183b = aVar;
        this.f4182a = message;
    }

    @Override // java.lang.Runnable
    public void run() {
        throw new AssertionError("Unhandled stats message." + this.f4182a.what);
    }
}
