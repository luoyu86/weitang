package cn.admobiletop.adsuyi.tsplugin.adapter;

import cn.admobiletop.adsuyi.a.m.b;
import cn.admobiletop.adsuyi.tsplugin.AdEventPlugin;

/* JADX INFO: loaded from: classes.dex */
public class AdEventPluginAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AdEventPlugin f4343b;

    public static class INSTANCE {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static AdEventPluginAdapter f4344a = new AdEventPluginAdapter();
    }

    public static AdEventPluginAdapter getInstance() {
        return INSTANCE.f4344a;
    }

    public void addErrorReportInfo(String str, String str2, String str3, String str4, String str5) {
        try {
            if (this.f4342a) {
                if (this.f4343b == null) {
                    this.f4343b = (AdEventPlugin) b.b("cn.admobiletop.testplugin.proxy.AdEventPluginImpl");
                }
                AdEventPlugin adEventPlugin = this.f4343b;
                if (adEventPlugin != null) {
                    adEventPlugin.addErrorReportInfo(str, str2, str3, str4, str5);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void addReportInfo(String str, String str2, String str3, String str4, String str5, String str6, int i2, long j, String str7, long j2) {
        try {
            if (this.f4342a) {
                if (this.f4343b == null) {
                    this.f4343b = (AdEventPlugin) b.b("cn.admobiletop.testplugin.proxy.AdEventPluginImpl");
                }
                AdEventPlugin adEventPlugin = this.f4343b;
                if (adEventPlugin != null) {
                    adEventPlugin.addReportInfo(str, str2, str3, str4, str5, str6, i2, j, str7, j2);
                }
            }
        } catch (Exception unused) {
        }
    }

    public AdEventPluginAdapter() {
        this.f4342a = b.a("cn.admobiletop.testplugin.proxy.AdEventPluginImpl");
    }
}
