package com.bytedance.sdk.openadsdk.ok;

import android.app.Application;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.ok.ok;

/* JADX INFO: loaded from: classes.dex */
public final class bl implements Bridge {
    private static volatile bl ok;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f6449a;
    private ok bl = new ok();

    private bl() {
    }

    public static bl ok() {
        if (ok == null) {
            synchronized (bl.class) {
                if (ok == null) {
                    ok = new bl();
                }
            }
        }
        return ok;
    }

    public Application.ActivityLifecycleCallbacks a() {
        return this.bl;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        Bridge bridgeOk;
        switch (i2) {
            case 2:
                return (T) this.bl.ok();
            case 3:
                return (T) TTAppContextHolder.getContext();
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                a aVar = this.f6449a;
                if (aVar == null || (bridgeOk = aVar.ok(4)) == null) {
                    return null;
                }
                return (T) bridgeOk.call(i2, valueSet, cls);
            case 9:
                Object objObjectValue = valueSet.objectValue(0, Object.class);
                if (objObjectValue instanceof EventListener) {
                    ok((EventListener) objObjectValue);
                }
                return null;
            case 10:
                a aVar2 = this.f6449a;
                if (aVar2 == null) {
                    return null;
                }
                return (T) aVar2.ok(valueSet.intValue(0));
            default:
                return null;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return c.d.a.a.a.a.a.ok().ok(10000, 5).a();
    }

    public void ok(a aVar) {
        this.f6449a = aVar;
    }

    private void ok(final EventListener eventListener) {
        this.bl.ok(new ok.InterfaceC0115ok() { // from class: com.bytedance.sdk.openadsdk.ok.bl.1
            @Override // com.bytedance.sdk.openadsdk.ok.ok.InterfaceC0115ok
            public void a() {
                eventListener.onEvent(1, null);
            }

            @Override // com.bytedance.sdk.openadsdk.ok.ok.InterfaceC0115ok
            public void ok() {
                eventListener.onEvent(0, null);
            }
        });
    }
}
