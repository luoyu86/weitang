package com.taobao.accs.net;

import anet.channel.strategy.StrategyCenter;

/* JADX INFO: loaded from: classes2.dex */
public class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f10378a;

    public i(h hVar) {
        this.f10378a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        StrategyCenter.getInstance().saveData();
    }
}
