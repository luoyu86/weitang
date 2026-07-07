package com.bytedance.sdk.openadsdk.r.ok.ok.ok;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.bl.ok.ok.rh;

/* JADX INFO: loaded from: classes.dex */
public class ok implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TTNativeAd.AdInteractionListener f6456a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public ok(TTNativeAd.AdInteractionListener adInteractionListener) {
        this.f6456a = adInteractionListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (this.f6456a == null) {
            return null;
        }
        switch (i2) {
            case 141101:
                this.f6456a.onAdClicked((View) valueSet.objectValue(0, View.class), new rh((Bridge) valueSet.objectValue(1, Bridge.class)));
                break;
            case 141102:
                this.f6456a.onAdCreativeClick((View) valueSet.objectValue(0, View.class), new rh((Bridge) valueSet.objectValue(1, Bridge.class)));
                break;
            case 141103:
                this.f6456a.onAdShow(new rh((Bridge) valueSet.objectValue(0, Bridge.class)));
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
