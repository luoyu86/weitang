package com.bytedance.sdk.openadsdk.mediation.bridge;

import android.content.Context;
import androidx.annotation.RequiresApi;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig;

/* JADX INFO: loaded from: classes.dex */
public class MediationAdClassLoader implements Bridge {
    private static volatile MediationAdClassLoader ok;

    private MediationAdClassLoader() {
    }

    public static MediationAdClassLoader getInstance() {
        if (ok == null) {
            synchronized (MediationAdClassLoader.class) {
                ok = new MediationAdClassLoader();
            }
        }
        return ok;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    @RequiresApi(api = 19)
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (i2 == 8106) {
            MediationLoaderConfig mediationLoaderConfigCreate = MediationLoaderConfig.create(valueSet);
            Context context = (Context) valueSet.objectValue(8009, Context.class);
            try {
                Object objNewInstance = Class.forName(mediationLoaderConfigCreate.getClassName()).newInstance();
                if (objNewInstance instanceof Bridge) {
                    Bridge bridge = (Bridge) objNewInstance;
                    MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
                    mediationValueSetBuilderCreate.add(8009, context);
                    ValueSet valueSet2 = (ValueSet) valueSet.objectValue(8424, ValueSet.class);
                    if (valueSet2 != null) {
                        mediationValueSetBuilderCreate.add(8424, valueSet2);
                    } else {
                        mediationValueSetBuilderCreate.add(8424, valueSet);
                    }
                    bridge.call(8241, mediationValueSetBuilderCreate.build(), null);
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
                e2.printStackTrace();
            }
        } else if (i2 == 8229) {
            try {
                Class.forName(valueSet.stringValue(8010));
                return (T) Boolean.TRUE;
            } catch (ClassNotFoundException e3) {
                e3.printStackTrace();
                return (T) Boolean.FALSE;
            }
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
