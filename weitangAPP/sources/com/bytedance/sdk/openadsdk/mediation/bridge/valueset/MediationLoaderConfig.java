package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import android.content.Context;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes.dex */
public class MediationLoaderConfig {
    private ValueSet ok;

    private MediationLoaderConfig(ValueSet valueSet) {
        if (valueSet != null) {
            ValueSet valueSet2 = (ValueSet) valueSet.objectValue(8424, ValueSet.class);
            if (valueSet2 != null) {
                this.ok = valueSet2;
            } else {
                this.ok = valueSet;
            }
        }
    }

    public static MediationLoaderConfig create(ValueSet valueSet) {
        return new MediationLoaderConfig(valueSet);
    }

    private boolean ok() {
        ValueSet valueSet = this.ok;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    public String getADNName() {
        return ok() ? this.ok.stringValue(8003) : "";
    }

    public ValueSet getAdSlotValueSet() {
        if (ok()) {
            return (ValueSet) this.ok.objectValue(8548, ValueSet.class);
        }
        return null;
    }

    public int getAdType() {
        if (ok()) {
            return this.ok.intValue(8008);
        }
        return 0;
    }

    public String getClassName() {
        return ok() ? this.ok.stringValue(8010) : "";
    }

    public Context getContext() {
        if (ok()) {
            return (Context) this.ok.objectValue(8009, Context.class);
        }
        return null;
    }

    public Bridge getGMCustomAdLoader() {
        if (ok()) {
            return (Bridge) this.ok.objectValue(8011, Bridge.class);
        }
        return null;
    }

    public ValueSet getMediationCustomServiceConfigValue() {
        if (ok()) {
            return (ValueSet) this.ok.objectValue(8546, ValueSet.class);
        }
        return null;
    }
}
