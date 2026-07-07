package com.chinavisionary.core.app.ad.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiViewFindUtils {
    private static View getTargetDecorView(Activity activity, View view) {
        Context context = view.getContext();
        if (context == activity) {
            return view;
        }
        while ((context instanceof ContextWrapper) && !(context instanceof Activity) && (context = ((ContextWrapper) context).getBaseContext()) != null) {
            if (context == activity) {
                return view;
            }
        }
        return null;
    }

    public static View tryGetTheFrontView(Activity activity) {
        try {
            WindowManager windowManager = activity.getWindowManager();
            if (Build.VERSION.SDK_INT <= 16) {
                Field declaredField = Class.forName("android.view.WindowManagerImpl$CompatModeWrapper").getDeclaredField("mWindowManager");
                declaredField.setAccessible(true);
                Field declaredField2 = Class.forName("android.view.WindowManagerImpl").getDeclaredField("mViews");
                declaredField2.setAccessible(true);
                List listAsList = Arrays.asList((View[]) declaredField2.get(declaredField.get(windowManager)));
                for (int size = listAsList.size() - 1; size >= 0; size--) {
                    View targetDecorView = getTargetDecorView(activity, (View) listAsList.get(size));
                    if (targetDecorView != null) {
                        return targetDecorView;
                    }
                }
            }
            Field declaredField3 = ADSuyiClassFindUtils.getDeclaredField(ADSuyiClassFindUtils.forName("android.view.WindowManagerImpl"), "mGlobal");
            declaredField3.setAccessible(true);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 <= 23) {
                Field declaredField4 = Class.forName("android.view.WindowManagerGlobal").getDeclaredField("mViews");
                declaredField4.setAccessible(true);
                List list = (List) declaredField4.get(declaredField3.get(windowManager));
                for (int size2 = list.size() - 1; size2 >= 0; size2--) {
                    View targetDecorView2 = getTargetDecorView(activity, (View) list.get(size2));
                    if (targetDecorView2 != null) {
                        return targetDecorView2;
                    }
                }
            } else {
                Field declaredField5 = ADSuyiClassFindUtils.getDeclaredField(ADSuyiClassFindUtils.forName("android.view.WindowManagerGlobal"), "mRoots");
                declaredField5.setAccessible(true);
                List listAsList2 = i2 >= 19 ? (List) declaredField5.get(declaredField3.get(windowManager)) : Arrays.asList((Object[]) declaredField5.get(declaredField3.get(windowManager)));
                for (int size3 = listAsList2.size() - 1; size3 >= 0; size3--) {
                    Class<?> clsForName = ADSuyiClassFindUtils.forName("android.view.ViewRootImpl");
                    Object obj = listAsList2.get(size3);
                    Field declaredField6 = ADSuyiClassFindUtils.getDeclaredField(clsForName, "mWindowAttributes");
                    declaredField6.setAccessible(true);
                    Field declaredField7 = ADSuyiClassFindUtils.getDeclaredField(clsForName, "mView");
                    declaredField7.setAccessible(true);
                    View view = (View) declaredField7.get(obj);
                    if (((WindowManager.LayoutParams) declaredField6.get(obj)).getTitle().toString().contains(activity.getClass().getName()) || getTargetDecorView(activity, view) != null) {
                        return view;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return activity.getWindow().peekDecorView();
    }
}
