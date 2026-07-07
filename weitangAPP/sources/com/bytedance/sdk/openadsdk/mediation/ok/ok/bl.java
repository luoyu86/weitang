package com.bytedance.sdk.openadsdk.mediation.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bl extends com.bytedance.sdk.openadsdk.h.ok.ok.ok.a {
    private TTAdNative.FeedAdListener ok;

    public bl(TTAdNative.FeedAdListener feedAdListener) {
        super(feedAdListener);
        this.ok = feedAdListener;
    }

    @Override // com.bytedance.sdk.openadsdk.h.ok.ok.ok.a, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (i2 != 164102) {
            return (T) super.call(i2, valueSet, cls);
        }
        List arrayList = (List) valueSet.objectValue(0, List.class);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new j((Bridge) it.next()));
        }
        TTAdNative.FeedAdListener feedAdListener = this.ok;
        if (feedAdListener == null) {
            return null;
        }
        feedAdListener.onFeedAdLoad(arrayList2);
        return null;
    }
}
