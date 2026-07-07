package com.bytedance.sdk.openadsdk.api.plugin.ok;

import android.text.TextUtils;
import c.d.a.a.a.a.a;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.plugin.Plugin;

/* JADX INFO: loaded from: classes.dex */
public final class ok implements Bridge {
    private static volatile ok ok;

    public static ok ok() {
        if (ok == null) {
            synchronized (ok.class) {
                if (ok == null) {
                    ok = new ok();
                }
            }
        }
        return ok;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0082  */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T call(int r2, com.bykv.vk.openvk.api.proto.ValueSet r3, java.lang.Class<T> r4) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.plugin.ok.ok.call(int, com.bykv.vk.openvk.api.proto.ValueSet, java.lang.Class):java.lang.Object");
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return a.ok().ok(10000, 4).a();
    }

    private Plugin ok(ValueSet valueSet) {
        if (valueSet == null) {
            return null;
        }
        String strStringValue = valueSet.stringValue(0);
        if (TextUtils.isEmpty(strStringValue)) {
            return null;
        }
        return Zeus.getPlugin(strStringValue);
    }
}
