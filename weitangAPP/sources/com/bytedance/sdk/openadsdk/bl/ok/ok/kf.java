package com.bytedance.sdk.openadsdk.bl.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.FilterWord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class kf implements Bridge, FilterWord {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private FilterWord f6363a;
    private final Bridge ok;

    public kf(FilterWord filterWord) {
        this.f6363a = filterWord;
        this.ok = c.d.a.a.a.a.a.f919b;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void addOption(FilterWord filterWord) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new kf(filterWord));
        this.ok.call(241101, aVarOk.a(), Void.class);
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        FilterWord filterWord = this.f6363a;
        if (filterWord == null) {
            return null;
        }
        switch (i2) {
            case 241101:
                this.f6363a.addOption(new kf((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 241102:
                this.f6363a.setIsSelected(valueSet.booleanValue(0));
                break;
            case 241103:
                return (T) filterWord.getId();
            case 241104:
                return (T) filterWord.getName();
            case 241105:
                return (T) Boolean.class.cast(Boolean.valueOf(filterWord.getIsSelected()));
            case 241106:
                return (T) Boolean.class.cast(Boolean.valueOf(filterWord.hasSecondOptions()));
            case 241107:
                return (T) Boolean.class.cast(Boolean.valueOf(filterWord.isValid()));
            case 241108:
                return (T) filterWord.getOptions();
        }
        ok(i2, valueSet, cls);
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getId() {
        return (String) this.ok.call(241103, c.d.a.a.a.a.a.ok(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean getIsSelected() {
        return ((Boolean) this.ok.call(241105, c.d.a.a.a.a.a.ok(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getName() {
        return (String) this.ok.call(241104, c.d.a.a.a.a.a.ok(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public List<FilterWord> getOptions() {
        List arrayList = (List) this.ok.call(241108, c.d.a.a.a.a.a.ok(0).a(), List.class);
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

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean hasSecondOptions() {
        return ((Boolean) this.ok.call(241106, c.d.a.a.a.a.a.ok(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean isValid() {
        return ((Boolean) this.ok.call(241107, c.d.a.a.a.a.a.ok(0).a(), Boolean.TYPE)).booleanValue();
    }

    public void ok(int i2, ValueSet valueSet, Class cls) {
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void setIsSelected(boolean z) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, z);
        this.ok.call(241102, aVarOk.a(), Void.class);
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return c.d.a.a.a.a.a.f918a;
    }

    public kf(Bridge bridge) {
        this.ok = bridge == null ? c.d.a.a.a.a.a.f919b : bridge;
    }
}
