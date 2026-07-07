package com.bytedance.pangle.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public final class c implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Fragment f6068a;

    public c(Fragment fragment) {
        this.f6068a = fragment;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostSaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        Object[] objArr;
        if (this.f6068a.getActivity() != activity) {
            return;
        }
        try {
            Parcelable parcelable = bundle.getParcelable("android:fragments");
            if (parcelable == null || (objArr = (Object[]) FieldUtils.readField(parcelable, "mActive")) == null) {
                return;
            }
            Object obj = null;
            for (Object obj2 : objArr) {
                Object field = FieldUtils.readField(obj2, "mTag");
                if (!"androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_plugin".equals(field) && (!(field instanceof String) || (!((String) field).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle") && !((String) field).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle")))) {
                }
                obj = obj2;
                break;
            }
            if (obj != null) {
                Object[] objArr2 = (Object[]) Array.newInstance(Class.forName("android.app.FragmentState"), objArr.length - 1);
                int[] iArr = new int[objArr.length - 1];
                int i2 = 0;
                for (int i3 = 0; i3 < objArr.length; i3++) {
                    if (objArr[i3] != obj) {
                        objArr2[i2] = objArr[i3];
                        iArr[i2] = i3;
                        i2++;
                    }
                }
                FieldUtils.writeField(parcelable, "mActive", objArr2);
                FieldUtils.writeField(parcelable, "mAdded", iArr);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Object[] objArr;
        if (this.f6068a.getActivity() != activity) {
            return;
        }
        try {
            Parcelable parcelable = bundle.getParcelable("android:fragments");
            if (parcelable == null || (objArr = (Object[]) FieldUtils.readField(parcelable, "mActive")) == null) {
                return;
            }
            Object obj = null;
            for (Object obj2 : objArr) {
                Object field = FieldUtils.readField(obj2, "mTag");
                if (!"androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_plugin".equals(field) && (!(field instanceof String) || (!((String) field).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle") && !((String) field).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle")))) {
                }
                obj = obj2;
                break;
            }
            if (obj != null) {
                Object[] objArr2 = (Object[]) Array.newInstance(Class.forName("android.app.FragmentState"), objArr.length - 1);
                int[] iArr = new int[objArr.length - 1];
                int i2 = 0;
                for (int i3 = 0; i3 < objArr.length; i3++) {
                    if (objArr[i3] != obj) {
                        objArr2[i2] = objArr[i3];
                        iArr[i2] = i3;
                        i2++;
                    }
                }
                FieldUtils.writeField(parcelable, "mActive", objArr2);
                FieldUtils.writeField(parcelable, "mAdded", iArr);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
