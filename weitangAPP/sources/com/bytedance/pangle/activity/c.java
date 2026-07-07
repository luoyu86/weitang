package com.bytedance.pangle.activity;

import android.R;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatViewInflater;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(b bVar, Bundle bundle) {
        List<String> list;
        if (!Zeus.hasInit()) {
            Log.e(ZeusLogger.TAG_INIT, "ProxyActivityUtils.onCreate finish. AppApplication == null.");
            bVar.zeusSuperOnCreate(null);
            bVar.finish();
            return;
        }
        Intent intent = bVar.getIntent();
        String pluginPkgName = bVar.getPluginPkgName();
        Plugin plugin = bVar.getPlugin();
        if (plugin == null) {
            Log.e(ZeusLogger.TAG_INIT, "ProxyActivityUtils.onCreate finish. plugin == null");
            bVar.zeusSuperOnCreate(null);
            bVar.finish();
            return;
        }
        intent.setExtrasClassLoader(plugin.mClassLoader);
        IntentUtils.a(intent);
        String stringExtra = intent.getStringExtra("targetPlugin");
        if (TextUtils.isEmpty(stringExtra) && (list = ComponentManager.stubActivity2TargetActivities.get(bVar.getClass().getName())) != null && list.size() == 1) {
            stringExtra = list.get(0);
            intent.putExtra("targetPlugin", stringExtra);
        }
        if (!plugin.isLoaded() || TextUtils.isEmpty(stringExtra)) {
            try {
                bVar.zeusSuperOnCreate(null);
                ZeusLogger.w(ZeusLogger.TAG_ACTIVITY, "Cant start pluginActivity, plugin load failed! pluginPkgName: " + pluginPkgName + " targetActivity: " + stringExtra);
                bVar.finish();
                return;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        ActivityInfo activityInfo = plugin.pluginActivities.get(stringExtra);
        if (activityInfo == null) {
            ZeusLogger.w(ZeusLogger.TAG_ACTIVITY, "Have you declared " + stringExtra + " in plugin's AndroidManifest.xml!");
            bVar.zeusSuperOnCreate(null);
            bVar.finish();
        }
        int i2 = -1;
        try {
            IPluginActivity iPluginActivity = (IPluginActivity) plugin.mClassLoader.loadClass(stringExtra).newInstance();
            FieldUtils.writeField(iPluginActivity, "mApplication", bVar.getApplication());
            bVar.setTargetActivity(iPluginActivity);
            iPluginActivity.setPluginProxyActivity(bVar, plugin);
            i2 = activityInfo.theme;
            bVar.zeusSuperSetTheme(i2);
            TypedArray typedArrayObtainStyledAttributes = ((Activity) bVar).getTheme().obtainStyledAttributes(new int[]{R.attr.windowIsTranslucent});
            if (typedArrayObtainStyledAttributes.getBoolean(typedArrayObtainStyledAttributes.getIndex(0), false)) {
                a((Activity) bVar);
            }
            typedArrayObtainStyledAttributes.recycle();
            iPluginActivity.attachBaseContext(bVar.getBaseContext());
            try {
                int requestedOrientation = ((Activity) bVar).getRequestedOrientation();
                int i3 = activityInfo.screenOrientation;
                if (requestedOrientation != i3) {
                    ((Activity) bVar).setRequestedOrientation(i3);
                }
            } catch (IllegalStateException unused) {
            }
            iPluginActivity.onCreate(bundle);
        } catch (Exception e3) {
            throw new RuntimeException(e3 instanceof IllegalStateException ? "activityTheme:".concat(String.valueOf(i2)) : "", e3);
        }
    }

    public static void a(b bVar, Context context) {
        if (!Zeus.hasInit()) {
            Log.e(ZeusLogger.TAG_INIT, "ProxyActivityUtils.attachBaseContext. AppApplication == null.");
            bVar.zeusSuperAttachBaseContext(context);
            return;
        }
        String pluginPkgName = bVar.getPluginPkgName();
        boolean zLoadPlugin = PluginManager.getInstance().loadPlugin(pluginPkgName);
        try {
            bVar.setPlugin(PluginManager.getInstance().getPlugin(pluginPkgName));
            if (zLoadPlugin) {
                bVar.zeusSuperAttachBaseContext(ZeusTransformUtils.wrapperContext(context, pluginPkgName));
                FieldUtils.writeField(bVar, "mResources", (Object) null);
            } else {
                bVar.zeusSuperAttachBaseContext(context);
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void a(Activity activity, View view) {
        Object field;
        if (view == null) {
            return;
        }
        try {
            Object field2 = FieldUtils.readField(view, "mListenerInfo");
            if (field2 != null && (field = FieldUtils.readField(field2, "mOnClickListener")) != null) {
                String name = field.getClass().getName();
                if (name.startsWith(AppCompatViewInflater.class.getName()) || name.startsWith(View.class.getName())) {
                    view.setOnClickListener(new a(activity, view.getId(), (String) FieldUtils.readField(field, "mMethodName")));
                }
            }
        } catch (Exception e2) {
            ZeusLogger.errReport(ZeusLogger.TAG_ACTIVITY, "checkOnClickListener failed!".concat(String.valueOf(view)));
            e2.printStackTrace();
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i2 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i2 >= viewGroup.getChildCount()) {
                return;
            }
            a(activity, viewGroup.getChildAt(i2));
            i2++;
        }
    }

    private static Class a() {
        Class<?> cls = null;
        for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
            if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                cls = cls2;
            }
        }
        return cls;
    }

    private static void a(Activity activity) {
        try {
            MethodUtils.getAccessibleMethod(Activity.class, "convertToTranslucent", a(), ActivityOptions.class).invoke(activity, null, MethodUtils.getAccessibleMethod(Activity.class, "getActivityOptions", new Class[0]).invoke(activity, new Object[0]));
        } catch (Throwable unused) {
        }
    }
}
