package cn.admobiletop.adsuyi.c;

import android.os.Message;
import cn.admobiletop.adsuyi.c.C0336p;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.c.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0335o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Message f4240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0336p.a f4241b;

    public RunnableC0335o(C0336p.a aVar, Message message) {
        this.f4241b = aVar;
        this.f4240a = message;
    }

    @Override // java.lang.Runnable
    public void run() {
        throw new AssertionError("Unknown handler message received: " + this.f4240a.what);
    }
}
