package com.bytedance.sdk.openadsdk.mediation.bridge;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediationAdLoaderImpl implements IMediationAdLoader {
    public static final String TAG = "TTMediationSDK";
    public MediationAdSlotValueSet mSlotValueSet;
    private Bridge ok;

    private Field ok(Class<?> cls, String str) {
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (i2 == 8241) {
            load((Context) valueSet.objectValue(8009, Context.class), (ValueSet) valueSet.objectValue(8424, ValueSet.class));
        }
        return (T) callFunction(i2, valueSet, cls);
    }

    public <T> T callFunction(int i2, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    public String getAdm() {
        Bridge bridge = this.ok;
        return bridge != null ? (String) bridge.call(8137, null, String.class) : "";
    }

    public String getAdnId() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.mSlotValueSet;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getADNId();
        }
        return null;
    }

    public Bridge getGMBridge() {
        Bridge bridge = this.ok;
        if (bridge != null) {
            return (Bridge) bridge.call(8127, null, Bridge.class);
        }
        return null;
    }

    public int getLoadTimeOut() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.mSlotValueSet;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getAdLoadTimeOut();
        }
        return 3000;
    }

    public Activity getOriginActivity(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            return (Activity) ok(activity, "mOriginActivity");
        } catch (Throwable unused) {
            return null;
        }
    }

    public int getOriginType() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.mSlotValueSet;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getOriginType();
        }
        return 0;
    }

    public String getRitId() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.mSlotValueSet;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getRitId();
        }
        return null;
    }

    public boolean getSplashShakeButton() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.mSlotValueSet;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.isSplashShakeButton();
        }
        return false;
    }

    public boolean hasNotifyFail() {
        Boolean bool;
        Bridge bridge = this.ok;
        if (bridge == null || (bool = (Boolean) bridge.call(8210, null, Boolean.class)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isClientBidding() {
        Bridge bridge = this.ok;
        if (bridge != null) {
            return ((Boolean) bridge.call(8110, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    public boolean isMultiBidding() {
        Bridge bridge = this.ok;
        if (bridge != null) {
            return ((Boolean) bridge.call(8141, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    public boolean isServerBidding() {
        Bridge bridge = this.ok;
        if (bridge != null) {
            return ((Boolean) bridge.call(8136, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    public boolean isSplashPreLoad() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.mSlotValueSet;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.isSplashPreLoad();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationAdLoader
    public final void load(Context context, ValueSet valueSet) {
        MediationAdSlotValueSet mediationAdSlotValueSetCreate = MediationAdSlotValueSet.create(valueSet);
        this.mSlotValueSet = mediationAdSlotValueSetCreate;
        this.ok = mediationAdSlotValueSetCreate.getAdLoaderCallback();
        realLoader(context, mediationAdSlotValueSetCreate);
    }

    public void notifyAdCache(Bridge bridge, int i2, String str) {
        if (this.ok != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8303, bridge);
            mediationValueSetBuilderCreate.add(8014, i2);
            mediationValueSetBuilderCreate.add(8015, str);
            this.ok.call(8112, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    public void notifyAdFailed(int i2, String str) {
        if (this.ok != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8014, i2);
            mediationValueSetBuilderCreate.add(8015, str);
            this.ok.call(8108, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    @Deprecated
    public void notifyAdSuccess(Bridge bridge) {
        if (this.ok != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(bridge);
            notifyAdSuccess(arrayList);
        }
    }

    public abstract void realLoader(Context context, MediationAdSlotValueSet mediationAdSlotValueSet);

    public void removeSelfFromParent(View view) {
        if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent == null || !(parent instanceof ViewGroup)) {
                    return;
                }
                ((ViewGroup) parent).removeView(view);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    private Object ok(Field field, Object obj) throws IllegalAccessException {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    public void notifyAdSuccess(Bridge bridge, Bridge bridge2) {
        MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
        mediationValueSetBuilderCreate.add(8035, bridge);
        bridge2.call(8128, mediationValueSetBuilderCreate.build(), Void.class);
        if (this.ok != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(bridge2);
            notifyAdSuccess(arrayList);
        }
    }

    private Object ok(Object obj, String str) throws IllegalAccessException {
        Field fieldOk = ok(obj.getClass(), str);
        if (fieldOk != null) {
            return ok(fieldOk, obj);
        }
        return null;
    }

    public void notifyAdSuccess(List<Bridge> list) {
        if (this.ok != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8303, list);
            this.ok.call(8107, mediationValueSetBuilderCreate.build(), Bridge.class);
        }
    }
}
