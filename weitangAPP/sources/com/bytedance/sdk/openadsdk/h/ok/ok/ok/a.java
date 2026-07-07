package com.bytedance.sdk.openadsdk.h.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.bl.ok.ok.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TTAdNative.FeedAdListener f6376a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public a(TTAdNative.FeedAdListener feedAdListener) {
        this.f6376a = feedAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (this.f6376a == null) {
            return null;
        }
        switch (i2) {
            case 164101:
                this.f6376a.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 164102:
                List arrayList = (List) valueSet.objectValue(0, List.class);
                if (arrayList == null) {
                    arrayList = new ArrayList(0);
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new r((Bridge) it.next()));
                }
                this.f6376a.onFeedAdLoad(arrayList2);
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
