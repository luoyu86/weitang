package com.bytedance.sdk.openadsdk.bl.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class s implements DislikeInfo {
    private final Bridge ok;

    public s(Bridge bridge) {
        this.ok = bridge == null ? c.d.a.a.a.a.a.f919b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.DislikeInfo
    public List<FilterWord> getFilterWords() {
        List arrayList = (List) this.ok.values().objectValue(243001, List.class);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new kf((Bridge) it.next()));
        }
        return arrayList2;
    }

    @Override // com.bytedance.sdk.openadsdk.DislikeInfo
    public PersonalizationPrompt getPersonalizationPrompt() {
        return new h((Bridge) this.ok.values().objectValue(243002, Bridge.class));
    }
}
