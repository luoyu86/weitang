package cn.admobiletop.adsuyi.tsplugin.adapter;

import cn.admobiletop.adsuyi.a.m.b;
import cn.admobiletop.adsuyi.tsplugin.CrashPlugin;

/* JADX INFO: loaded from: classes.dex */
public class CrashPluginAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CrashPlugin f4346b;

    public static class INSTANCE {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static CrashPluginAdapter f4347a = new CrashPluginAdapter();
    }

    public static CrashPluginAdapter getInstance() {
        return INSTANCE.f4347a;
    }

    public void insert(Throwable th, long j, String str) {
        try {
            if (this.f4345a) {
                if (this.f4346b == null) {
                    this.f4346b = (CrashPlugin) b.b("cn.admobiletop.testplugin.proxy.CrashPluginImpl");
                }
                CrashPlugin crashPlugin = this.f4346b;
                if (crashPlugin != null) {
                    crashPlugin.insert(th, j, str);
                }
            }
        } catch (Exception unused) {
        }
    }

    public CrashPluginAdapter() {
        this.f4345a = b.a("cn.admobiletop.testplugin.proxy.CrashPluginImpl");
    }
}
