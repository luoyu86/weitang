package com.taobao.accs.client;

import com.taobao.accs.utl.UtilityImpl;

/* JADX INFO: loaded from: classes2.dex */
public class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GlobalClientInfo f10262a;

    public d(GlobalClientInfo globalClientInfo) {
        this.f10262a = globalClientInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        GlobalClientInfo.f10250b = UtilityImpl.j(GlobalClientInfo.f10249a);
    }
}
