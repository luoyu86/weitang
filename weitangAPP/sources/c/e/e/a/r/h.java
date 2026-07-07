package c.e.e.a.r;

import android.app.Activity;
import cn.com.heaton.blelibrary.ble.event.CommandResultEvent;
import cn.com.heaton.blelibrary.ble.event.ConnectionChangedEvent;

/* JADX INFO: loaded from: classes2.dex */
public class h extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f2407c;

    public h(int i2, d dVar) {
        super(dVar);
        b(i2);
    }

    public final void b(int i2) {
        if (this.f2407c == null) {
            a aVarA = g.a(i2);
            this.f2407c = aVarA;
            if (aVarA != null) {
                aVarA.a(this.f2383a);
            }
        }
    }

    @Override // c.e.e.a.r.a
    public void onCommandResult(CommandResultEvent commandResultEvent) {
        a aVar = this.f2407c;
        if (aVar != null) {
            aVar.onCommandResult(commandResultEvent);
        }
    }

    @Override // c.e.e.a.r.a
    public void onConnectionChanged(ConnectionChangedEvent connectionChangedEvent) {
        a aVar = this.f2407c;
        if (aVar != null) {
            aVar.onConnectionChanged(connectionChangedEvent);
        }
    }

    @Override // c.e.e.a.r.a
    public void openDoor(c.e.e.a.x.d dVar, Activity activity, c.e.e.a.s.f fVar) {
        a aVar = this.f2407c;
        if (aVar != null) {
            aVar.openDoor(dVar, activity, fVar);
        }
    }

    @Override // c.e.e.a.r.a
    public void release() {
        a aVar = this.f2407c;
        if (aVar != null) {
            aVar.release();
        }
    }
}
