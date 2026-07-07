package com.bytedance.sdk.openadsdk.h.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.bl.ok.ok.rh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class s implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TTAdNative.NativeAdListener f6381a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public s(TTAdNative.NativeAdListener nativeAdListener) {
        this.f6381a = nativeAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (this.f6381a == null) {
            return null;
        }
        switch (i2) {
            case 143101:
                this.f6381a.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 143102:
                List arrayList = (List) valueSet.objectValue(0, List.class);
                if (arrayList == null) {
                    arrayList = new ArrayList(0);
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new rh((Bridge) it.next()));
                }
                this.f6381a.onNativeAdLoad(arrayList2);
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
