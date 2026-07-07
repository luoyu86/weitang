package com.bytedance.pangle.f;

import com.bytedance.pangle.ZeusPluginInstallListener;
import com.bytedance.pangle.d;

/* JADX INFO: loaded from: classes.dex */
public final class b extends d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ZeusPluginInstallListener f6064a;

    public b(ZeusPluginInstallListener zeusPluginInstallListener) {
        this.f6064a = zeusPluginInstallListener;
    }

    @Override // com.bytedance.pangle.d
    public final void a(String str, int i2, String str2) {
        ZeusPluginInstallListener zeusPluginInstallListener = this.f6064a;
        if (zeusPluginInstallListener != null) {
            zeusPluginInstallListener.onPluginInstall(str, i2, str2);
        }
    }
}
