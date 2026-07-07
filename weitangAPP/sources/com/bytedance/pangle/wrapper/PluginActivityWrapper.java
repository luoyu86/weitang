package com.bytedance.pangle.wrapper;

import android.view.View;
import android.view.Window;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class PluginActivityWrapper extends GenerateActivityWrapper {
    private static final int OBJECT_TAG = Integer.MAX_VALUE;

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:10:0x0024
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public PluginActivityWrapper(android.app.Activity r4, com.bytedance.pangle.PluginContext r5) {
        /*
            r3 = this;
            java.lang.String r0 = "mBase"
            r3.<init>()
            r3.mOriginActivity = r4
            r3.pluginContext = r5
            boolean r1 = r4.isDestroyed()     // Catch: java.lang.Exception -> L24
            if (r1 != 0) goto L30
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L24
            r2 = 29
            if (r1 < r2) goto L20
            android.app.Activity r1 = r3.mOriginActivity     // Catch: java.lang.Exception -> L24
            com.bytedance.pangle.wrapper.PluginActivityWrapper$1 r2 = new com.bytedance.pangle.wrapper.PluginActivityWrapper$1     // Catch: java.lang.Exception -> L24
            r2.<init>()     // Catch: java.lang.Exception -> L24
            r1.registerActivityLifecycleCallbacks(r2)     // Catch: java.lang.Exception -> L24
            goto L30
        L20:
            r3.setTag()     // Catch: java.lang.Exception -> L24
            goto L30
        L24:
            android.app.Application r1 = com.bytedance.pangle.Zeus.getAppApplication()
            com.bytedance.pangle.wrapper.PluginActivityWrapper$2 r2 = new com.bytedance.pangle.wrapper.PluginActivityWrapper$2
            r2.<init>()
            r1.registerActivityLifecycleCallbacks(r2)
        L30:
            com.bytedance.pangle.util.FieldUtils.writeField(r3, r0, r5)     // Catch: java.lang.IllegalAccessException -> L42
            boolean r1 = com.bytedance.pangle.util.i.a()     // Catch: java.lang.IllegalAccessException -> L42
            if (r1 != 0) goto L42
            java.lang.Class<android.content.ContextWrapper> r1 = android.content.ContextWrapper.class
            java.lang.reflect.Field r0 = com.bytedance.pangle.util.FieldUtils.getField(r1, r0)     // Catch: java.lang.IllegalAccessException -> L42
            com.bytedance.pangle.util.FieldUtils.writeField(r0, r3, r5)     // Catch: java.lang.IllegalAccessException -> L42
        L42:
            java.lang.String r5 = "mApplication"
            android.app.Application r0 = r4.getApplication()     // Catch: java.lang.IllegalAccessException -> L4b
            com.bytedance.pangle.util.FieldUtils.writeField(r3, r5, r0)     // Catch: java.lang.IllegalAccessException -> L4b
        L4b:
            com.bytedance.pangle.util.a.a(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.wrapper.PluginActivityWrapper.<init>(android.app.Activity, com.bytedance.pangle.PluginContext):void");
    }

    private void setTag() {
        View decorView;
        String pluginPackageName;
        Window window = this.mOriginActivity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null || (pluginPackageName = this.pluginContext.getPluginPackageName()) == null) {
            return;
        }
        decorView.setTag(pluginPackageName.hashCode(), new com.bytedance.pangle.a() { // from class: com.bytedance.pangle.wrapper.PluginActivityWrapper.3
        });
    }
}
