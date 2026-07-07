package com.bytedance.pangle.transform;

import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class HostPartUtils {
    private Class fragmentActivityClazz;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final HostPartUtils f6259a = new HostPartUtils();
    }

    public HostPartUtils() {
        try {
            this.fragmentActivityClazz = FragmentActivity.class;
        } catch (Throwable unused) {
        }
    }

    public static FragmentActivity getFragmentActivity(Object obj, String str) {
        return (FragmentActivity) ZeusTransformUtils._getActivity(obj, str);
    }

    public static final Class getFragmentActivityClass() {
        return a.f6259a.fragmentActivityClazz;
    }
}
