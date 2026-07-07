package com.bytedance.sdk.openadsdk.j.ok.ok.ok;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;

/* JADX INFO: loaded from: classes.dex */
public class ok implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TTNativeExpressAd.AdInteractionListener f6384a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public ok(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.f6384a = adInteractionListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        TTNativeExpressAd.AdInteractionListener adInteractionListener = this.f6384a;
        if (adInteractionListener == null) {
            return null;
        }
        switch (i2) {
            case 151101:
                this.f6384a.onAdClicked((View) valueSet.objectValue(0, View.class), valueSet.intValue(1));
                break;
            case 151102:
                this.f6384a.onAdShow((View) valueSet.objectValue(0, View.class), valueSet.intValue(1));
                break;
            case 151103:
                this.f6384a.onRenderFail((View) valueSet.objectValue(0, View.class), (String) valueSet.objectValue(1, String.class), valueSet.intValue(2));
                break;
            case 151104:
                this.f6384a.onRenderSuccess((View) valueSet.objectValue(0, View.class), valueSet.floatValue(1), valueSet.floatValue(2));
                break;
            case 151105:
                adInteractionListener.onAdDismiss();
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
