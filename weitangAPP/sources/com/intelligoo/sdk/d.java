package com.intelligoo.sdk;

import android.app.Application;
import android.content.Context;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static Context a() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            return ((Application) cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(null, null), null)).getApplicationContext();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        } catch (IllegalArgumentException e4) {
            e4.printStackTrace();
            return null;
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
            return null;
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
            return null;
        }
    }
}
