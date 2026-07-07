package com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;

/* JADX INFO: loaded from: classes.dex */
public class kf implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediationExpressRenderListener f6413a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public kf(MediationExpressRenderListener mediationExpressRenderListener) {
        this.f6413a = mediationExpressRenderListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        MediationExpressRenderListener mediationExpressRenderListener = this.f6413a;
        if (mediationExpressRenderListener == null) {
            return null;
        }
        switch (i2) {
            case 142101:
                this.f6413a.onRenderSuccess((View) valueSet.objectValue(0, View.class), valueSet.floatValue(1), valueSet.floatValue(2), valueSet.booleanValue(3));
                break;
            case 142102:
                this.f6413a.onRenderFail((View) valueSet.objectValue(0, View.class), (String) valueSet.objectValue(1, String.class), valueSet.intValue(2));
                break;
            case 142103:
                mediationExpressRenderListener.onAdClick();
                break;
            case 142104:
                mediationExpressRenderListener.onAdShow();
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
