package com.taobao.accs.messenger;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public class d implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10335a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Messenger f10337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f10339e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10336b = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f10340f = System.currentTimeMillis();

    public d(Context context, String str, a aVar) {
        this.f10335a = context;
        this.f10338d = str;
        this.f10339e = aVar;
    }

    public void a(Intent intent) throws RemoteException {
        Message message = new Message();
        message.getData().putParcelable(MessengerService.INTENT, intent);
        this.f10337c.send(message);
    }

    public boolean b() {
        int i2 = this.f10336b;
        return i2 == 1 || i2 == 2;
    }

    public boolean c() {
        return this.f10336b == 1 && System.currentTimeMillis() - this.f10340f > 5000;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.f10335a.unbindService(this);
            this.f10336b = 0;
        } else {
            this.f10337c = new Messenger(iBinder);
            this.f10336b = 2;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f10339e.a(this.f10338d, this);
        this.f10336b = 0;
        this.f10337c = null;
    }

    public boolean a() {
        return this.f10336b == 2;
    }
}
