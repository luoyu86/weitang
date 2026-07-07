package anet.channel;

import android.content.Intent;
import anet.channel.util.ALog;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AccsSessionManager f364b;

    public a(AccsSessionManager accsSessionManager, Intent intent) {
        this.f364b = accsSessionManager;
        this.f363a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = AccsSessionManager.f290c.iterator();
        while (it.hasNext()) {
            try {
                ((ISessionListener) it.next()).onConnectionChanged(this.f363a);
            } catch (Exception e2) {
                ALog.e("awcn.AccsSessionManager", "notifyListener exception.", null, e2, new Object[0]);
            }
        }
    }
}
