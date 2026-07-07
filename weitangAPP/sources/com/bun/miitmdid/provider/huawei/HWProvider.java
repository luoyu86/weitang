package com.bun.miitmdid.provider.huawei;

import android.content.Context;
import com.bun.miitmdid.j0;
import com.bun.miitmdid.m;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import com.huawei.hms.opendevice.OpenDevice;

/* JADX INFO: loaded from: classes.dex */
public class HWProvider extends m {
    public static final String TAG = "HWProvider";
    private AdvertisingIdClient.Info mAdvertisingIdInfo;
    private int mCallbackCount;
    public Context mContext;

    public HWProvider(Context context) {
        this.mContext = checkContext(context);
        j0.c(TAG, "enter into HWProvider");
    }

    private native void finishCallback();

    private native void initCallbackCount();

    private native boolean isClassExists(String str);

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public native void doStart();

    public void getIdAAID() {
        if (!isGetOAID()) {
            this.isSupportedCache = true;
        }
        if (isClassExists("com.huawei.hms.opendevice.OpenDevice")) {
            HmsInstanceId.getInstance(this.mContext).getAAID().addOnSuccessListener(new OnSuccessListener() { // from class: c.c.a.a.a.b
            }).addOnFailureListener(new OnFailureListener() { // from class: c.c.a.a.a.d
            });
            return;
        }
        j0.a(TAG, "no combined class to unsupport get AAID ");
        this.AAIDCache = "";
        finishCallback();
    }

    public native void getIdOAID();

    public void getIdVAID() {
        if (!isGetOAID()) {
            this.isSupportedCache = true;
        }
        if (isClassExists("com.huawei.hms.opendevice.OpenDevice")) {
            OpenDevice.getOpenDeviceClient(this.mContext).getOdid().addOnSuccessListener(new OnSuccessListener() { // from class: c.c.a.a.a.c
            }).addOnFailureListener(new OnFailureListener() { // from class: c.c.a.a.a.a
            });
            return;
        }
        j0.a(TAG, "no combined class to unsupport get VAID ");
        this.VAIDCache = "";
        finishCallback();
    }

    @Override // com.bun.miitmdid.m, com.bun.miitmdid.interfaces.IdSupplier
    public native boolean isLimited();

    @Override // com.bun.miitmdid.m, com.bun.miitmdid.interfaces.IIdProvider
    public native boolean isSync();

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public native void shutDown();
}
