package cn.admobiletop.adsuyi.tsplugin.adapter;

import cn.admobiletop.adsuyi.a.m.b;
import cn.admobiletop.adsuyi.tsplugin.AdxCheckerPlugin;

/* JADX INFO: loaded from: classes.dex */
public class IniterCheckerPluginAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdxCheckerPlugin f4348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4349b;

    public static class INSTANCE {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static IniterCheckerPluginAdapter f4350a = new IniterCheckerPluginAdapter();
    }

    public static IniterCheckerPluginAdapter getInstance() {
        return INSTANCE.f4350a;
    }

    public void addAdapterItem(String str, String str2, boolean z) {
        try {
            if (this.f4349b) {
                if (this.f4348a == null) {
                    this.f4348a = (AdxCheckerPlugin) b.b("cn.admobiletop.testplugin.proxy.AdxCheckerPluginImpl");
                }
                AdxCheckerPlugin adxCheckerPlugin = this.f4348a;
                if (adxCheckerPlugin != null) {
                    adxCheckerPlugin.addAdxAdapterItem(str, str2, z);
                }
            }
        } catch (Exception unused) {
        }
    }

    public IniterCheckerPluginAdapter() {
        this.f4349b = b.a("cn.admobiletop.testplugin.proxy.AdxCheckerPluginImpl");
    }
}
