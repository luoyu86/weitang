package com.alibaba.sdk.android.man.crashreporter.a.a.a.a;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class e implements com.alibaba.sdk.android.man.crashreporter.a.a.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4688a;

    public class a implements ComponentCallbacks {
        private a() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    }

    public e(Context context) {
        this.f4688a = context;
        a();
    }

    private void a() {
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.a.a.a.c
    public void a(Map<com.alibaba.sdk.android.man.crashreporter.global.a, String> map) {
    }
}
