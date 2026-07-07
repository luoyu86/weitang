package com.taobao.accs.internal;

import android.content.Context;
import com.taobao.accs.ConnectionListener;

/* JADX INFO: loaded from: classes2.dex */
public class b implements ConnectionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f10321a;

    public b(a aVar) {
        this.f10321a = aVar;
    }

    @Override // com.taobao.accs.ConnectionListener
    public void onConnect() {
        if (this.f10321a.f10320c.f10309a.j().e(this.f10321a.f10319b.getPackageName()) && this.f10321a.f10320c.f10311c) {
            a aVar = this.f10321a;
            ACCSManagerImpl aCCSManagerImpl = aVar.f10320c;
            Context context = aVar.f10319b;
            com.taobao.accs.net.b bVar = aCCSManagerImpl.f10309a;
            aCCSManagerImpl.a(context, bVar.f10352b, bVar.f10351a);
        }
    }

    @Override // com.taobao.accs.ConnectionListener
    public void onDisconnect(int i2, String str) {
    }
}
