package com.chinavisionary.core.app.ad.utils;

import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiClassFindUtils {
    static {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Field declaredField = Class.class.getDeclaredField("classLoader");
                declaredField.setAccessible(true);
                declaredField.set(ADSuyiClassFindUtils.class, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static Class<?> forName(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    public static Field getDeclaredField(Class<?> cls, String str) throws NoSuchFieldException {
        return cls.getDeclaredField(str);
    }

    public static Method getDeclaredMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        return cls.getDeclaredMethod(str, clsArr);
    }

    public static <T> T reflexClass(String str) {
        try {
            return (T) Class.forName(str).newInstance();
        } catch (Exception unused) {
            return null;
        }
    }
}
