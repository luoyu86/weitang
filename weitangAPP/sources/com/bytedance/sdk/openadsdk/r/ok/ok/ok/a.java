package com.bytedance.sdk.openadsdk.r.ok.ok.ok;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;

/* JADX INFO: loaded from: classes.dex */
public class a implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TTNativeAd.ExpressRenderListener f6455a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public a(TTNativeAd.ExpressRenderListener expressRenderListener) {
        this.f6455a = expressRenderListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (this.f6455a == null) {
            return null;
        }
        if (i2 == 142101) {
            this.f6455a.onRenderSuccess((View) valueSet.objectValue(0, View.class), valueSet.floatValue(1), valueSet.floatValue(2), valueSet.booleanValue(3));
        }
        ok(i2, valueSet, cls);
        return null;
    }

    public void ok(int i2, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.ok;
    }
}
