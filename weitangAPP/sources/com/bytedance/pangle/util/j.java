package com.bytedance.pangle.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ArrayList<String> f6288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f6289b;

    public static List<String> a() {
        AssetManager assetManager;
        try {
            assetManager = (AssetManager) AssetManager.class.newInstance();
        } catch (Exception e2) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "Execute 'AssetManager.class.newInstance()' failed. ", e2);
            assetManager = null;
        }
        return a(assetManager);
    }

    public static String b(AssetManager assetManager) {
        List<String> listA = a(assetManager);
        StringBuilder sb = new StringBuilder("[");
        if (listA.size() > 0) {
            Iterator<String> it = listA.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(" , ");
            }
            sb.delete(sb.lastIndexOf(" , "), sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    public static List<String> a(AssetManager assetManager) {
        ArrayList arrayList = new ArrayList();
        if (assetManager == null) {
            return arrayList;
        }
        try {
            if (i.j()) {
                Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
                if (objArr != null && objArr.length > 0) {
                    for (Object obj : objArr) {
                        arrayList.add((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]));
                    }
                }
            } else {
                int iIntValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                for (int i2 = 0; i2 < iIntValue; i2++) {
                    try {
                        String str = (String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i2 + 1));
                        if (!TextUtils.isEmpty(str)) {
                            arrayList.add(str);
                        }
                    } catch (IndexOutOfBoundsException unused) {
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "ResUtils GetAssetsPaths error. ", th);
        }
        return arrayList;
    }

    public static synchronized List<String> b() {
        if (f6288a == null) {
            synchronized (j.class) {
                if (f6288a == null) {
                    f6288a = new ArrayList<>();
                    boolean z = false;
                    if (i.c()) {
                        try {
                            Resources resources = Zeus.getAppApplication().getResources();
                            f6288a.add(Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", "string", DispatchConstants.ANDROID)), 0).getApplicationInfo().sourceDir);
                        } catch (Exception e2) {
                            ZeusLogger.w(ZeusLogger.TAG_LOAD, "getWebViewPaths1 failed.", e2);
                        }
                    } else if (i.h()) {
                        try {
                            Object objInvokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.webkit.WebViewFactory"), "getWebViewContextAndSetProvider", new Object[0]);
                            int i2 = Build.VERSION.SDK_INT;
                            if (i2 >= 29 || (i2 == 28 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
                                z = true;
                            }
                            if (z) {
                                Collections.addAll(f6288a, a(((Context) objInvokeStaticMethod).getApplicationInfo()));
                            } else {
                                f6288a.add(((Context) objInvokeStaticMethod).getApplicationInfo().sourceDir);
                            }
                        } catch (Exception e3) {
                            ZeusLogger.w(ZeusLogger.TAG_LOAD, "getWebViewPaths2 failed.", e3);
                        }
                    }
                }
            }
        }
        return f6288a;
    }

    public static boolean a(AssetManager assetManager, String str) {
        try {
            if (i.j()) {
                Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
                if (objArr != null && objArr.length > 0) {
                    for (Object obj : objArr) {
                        if (TextUtils.equals((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]), str)) {
                            return true;
                        }
                    }
                }
            } else {
                int iIntValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                int i2 = 0;
                while (i2 < iIntValue) {
                    i2++;
                    if (TextUtils.equals((String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i2)), str)) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "containsPath error. ", th);
        }
        return false;
    }

    @RequiresApi(api = 21)
    private static String[] a(ApplicationInfo applicationInfo) {
        String[] strArr;
        try {
            strArr = (String[]) com.bytedance.pangle.b.b.a.a((Class<?>) ApplicationInfo.class, "resourceDirs").get(applicationInfo);
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "get resourceDirs failed.", th);
            strArr = new String[0];
        }
        String[][] strArr2 = {applicationInfo.splitSourceDirs, applicationInfo.sharedLibraryFiles, strArr};
        ArrayList arrayList = new ArrayList(10);
        String str = applicationInfo.sourceDir;
        if (str != null) {
            arrayList.add(str);
        }
        for (int i2 = 0; i2 < 3; i2++) {
            String[] strArr3 = strArr2[i2];
            if (strArr3 != null) {
                arrayList.addAll(Arrays.asList(strArr3));
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
