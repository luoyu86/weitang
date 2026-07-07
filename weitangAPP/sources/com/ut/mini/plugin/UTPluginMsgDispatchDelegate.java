package com.ut.mini.plugin;

/* JADX INFO: loaded from: classes2.dex */
public abstract class UTPluginMsgDispatchDelegate {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f12376g;

    public UTPluginMsgDispatchDelegate(Object obj) {
        this.f12376g = null;
        this.f12376g = obj;
    }

    public Object getDispatchObject(UTPlugin uTPlugin) {
        return this.f12376g;
    }

    public final Object getMsgObj() {
        return this.f12376g;
    }

    public boolean isMatchPlugin(UTPlugin uTPlugin) {
        return true;
    }
}
