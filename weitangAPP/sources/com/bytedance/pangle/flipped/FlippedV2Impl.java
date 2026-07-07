package com.bytedance.pangle.flipped;

import android.util.Log;
import androidx.annotation.Keep;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class FlippedV2Impl implements c {
    private static final String TAG = "FlippedV2Impl";

    static {
        System.loadLibrary("pangleflipped");
    }

    private native Method getDeclaredMethod(Object obj, String str, Class<?>[] clsArr);

    @Override // com.bytedance.pangle.flipped.c
    public void invokeHiddenApiRestrictions() {
        try {
            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
            Method declaredMethod = getDeclaredMethod(cls, "getRuntime", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = getDeclaredMethod(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(objInvoke, new String[]{"L"});
        } catch (Exception e2) {
            Log.e(TAG, "V2 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e2));
        }
    }
}
