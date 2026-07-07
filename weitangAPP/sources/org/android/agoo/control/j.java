package org.android.agoo.control;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
public class j implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseIntentService f14965a;

    public j(BaseIntentService baseIntentService) {
        this.f14965a = baseIntentService;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
