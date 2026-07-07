package com.bytedance.sdk.openadsdk.mediation.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.bytedance.sdk.openadsdk.h.ok.ok.ok.ok {
    private TTAdNative.DrawFeedAdListener ok;

    public a(TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        super(drawFeedAdListener);
        this.ok = drawFeedAdListener;
    }

    @Override // com.bytedance.sdk.openadsdk.h.ok.ok.ok.ok, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (i2 != 172102) {
            return (T) super.call(i2, valueSet, cls);
        }
        List arrayList = (List) valueSet.objectValue(0, List.class);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new r((Bridge) it.next()));
        }
        TTAdNative.DrawFeedAdListener drawFeedAdListener = this.ok;
        if (drawFeedAdListener == null) {
            return null;
        }
        drawFeedAdListener.onDrawFeedAdLoad(arrayList2);
        return null;
    }
}
