package com.bytedance.sdk.openadsdk.bl.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class a implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TTAdNative.CSJSplashAdListener f6354a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public a(TTAdNative.CSJSplashAdListener cSJSplashAdListener) {
        this.f6354a = cSJSplashAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (this.f6354a == null) {
            return null;
        }
        switch (i2) {
            case 114102:
                Bridge bridge = (Bridge) valueSet.objectValue(0, Bridge.class);
                com.bytedance.sdk.openadsdk.bl.ok.ok.a aVar = new com.bytedance.sdk.openadsdk.bl.ok.ok.a(bridge);
                if (bridge != null) {
                    try {
                        if (bridge.values().intValue(1) >= 5700) {
                            this.f6354a.onSplashLoadSuccess(aVar);
                        } else {
                            Method declaredMethod = this.f6354a.getClass().getDeclaredMethod("onSplashLoadSuccess", null);
                            if (declaredMethod != null) {
                                declaredMethod.invoke(this.f6354a, new Object[0]);
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                break;
            case 114103:
                this.f6354a.onSplashLoadFail(new com.bytedance.sdk.openadsdk.bl.ok.ok.ok((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 114104:
                this.f6354a.onSplashRenderSuccess(new com.bytedance.sdk.openadsdk.bl.ok.ok.a((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 114105:
                this.f6354a.onSplashRenderFail(new com.bytedance.sdk.openadsdk.bl.ok.ok.a((Bridge) valueSet.objectValue(0, Bridge.class)), new com.bytedance.sdk.openadsdk.bl.ok.ok.ok((Bridge) valueSet.objectValue(1, Bridge.class)));
                break;
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
