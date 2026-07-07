package com.taobao.accs.net;

import anet.channel.strategy.dispatch.DispatchEvent;
import anet.channel.strategy.dispatch.HttpDispatcher;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class h implements HttpDispatcher.IDispatchEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f10377a;

    public h(g gVar) {
        this.f10377a = gVar;
    }

    @Override // anet.channel.strategy.dispatch.HttpDispatcher.IDispatchEventListener
    public void onEvent(DispatchEvent dispatchEvent) {
        ThreadPoolExecutorFactory.schedule(new i(this), 2000L, TimeUnit.MILLISECONDS);
    }
}
