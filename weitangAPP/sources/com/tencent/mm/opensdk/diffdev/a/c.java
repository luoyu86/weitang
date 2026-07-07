package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ b f10530g;

    public c(b bVar) {
        this.f10530g = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f10530g.f10529f.f10526c);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((OAuthListener) it.next()).onQrcodeScanned();
        }
    }
}
