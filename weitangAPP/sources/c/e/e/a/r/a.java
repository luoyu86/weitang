package c.e.e.a.r;

import android.app.Activity;
import cn.com.heaton.blelibrary.ble.event.CommandResultEvent;
import cn.com.heaton.blelibrary.ble.event.ConnectionChangedEvent;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f2383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2384b;

    public a(d dVar) {
        this.f2383a = dVar;
    }

    public void a(d dVar) {
        this.f2383a = dVar;
    }

    public void onCommandResult(CommandResultEvent commandResultEvent) {
    }

    public void onConnectionChanged(ConnectionChangedEvent connectionChangedEvent) {
    }

    public abstract void openDoor(c.e.e.a.x.d dVar, Activity activity, c.e.e.a.s.f fVar);

    public abstract void release();
}
