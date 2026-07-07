package com.bytedance.pangle.res;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.i;
import com.bytedance.pangle.util.j;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Integer> f6191a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LinkedHashMap<String, Integer> f6192b;

    static {
        List<String> listA = j.a();
        if (listA == null || listA.size() <= 0) {
            return;
        }
        Iterator<String> it = listA.iterator();
        while (it.hasNext()) {
            f6191a.put(it.next(), 0);
        }
    }

    public a() {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        this.f6192b = linkedHashMap;
        linkedHashMap.put(Zeus.getAppApplication().getApplicationInfo().sourceDir, 0);
    }

    private static AssetManager b(AssetManager assetManager, String str, boolean z) {
        String str2 = "addAssetPath";
        String str3 = z ? "addAssetPathAsSharedLibrary" : "addAssetPath";
        int i2 = Build.VERSION.SDK_INT;
        if ((i2 >= 30 || (i2 == 29 && Build.VERSION.PREVIEW_SDK_INT > 0)) && !z && str.startsWith("/product/overlay/")) {
            str3 = "addOverlayPath";
        }
        Method accessibleMethod = MethodUtils.getAccessibleMethod(AssetManager.class, str3, String.class);
        if (accessibleMethod == null && z) {
            accessibleMethod = MethodUtils.getAccessibleMethod(AssetManager.class, "addAssetPath", String.class);
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor AssetManager.addAssetPath() invoke addAssetPathAsSharedLibrary failed. use addAssetPath.");
        } else {
            str2 = str3;
        }
        if (accessibleMethod != null) {
            int i3 = 3;
            while (true) {
                int i4 = i3 - 1;
                if (i3 < 0) {
                    break;
                }
                try {
                    int iIntValue = ((Integer) accessibleMethod.invoke(assetManager, str)).intValue();
                    if (iIntValue != 0) {
                        ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() success, cookie = " + iIntValue + ", path = " + str);
                        break;
                    }
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed, cookie = " + iIntValue + " " + str);
                } catch (Exception e2) {
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed. asSharedLibrary = " + z + ", methodName = " + str2, e2);
                }
                i3 = i4;
            }
        } else {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor reflect AssetManager.addAssetPath() failed. addAssetPathMethod == null. asSharedLibrary = " + z + " methodName:" + str2);
        }
        return assetManager;
    }

    private static AssetManager c(AssetManager assetManager, String str, boolean z) {
        int iIntValue;
        int i2;
        int i3 = 3;
        Throwable th = null;
        int i4 = 3;
        loop0: while (true) {
            int i5 = i4 - 1;
            if (i4 < 0) {
                break;
            }
            try {
                synchronized (assetManager) {
                    int i6 = 0;
                    iIntValue = 0;
                    while (true) {
                        i2 = 1;
                        if (i6 >= i3) {
                            break loop0;
                        }
                        try {
                            if (i.c()) {
                                iIntValue = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new Object[]{str}, new Class[]{String.class})).intValue();
                            } else {
                                int i7 = Build.VERSION.SDK_INT;
                                if (i7 >= 24 && i7 <= 25) {
                                    iIntValue = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new Object[]{str, Boolean.valueOf(z)}, new Class[]{String.class, Boolean.TYPE})).intValue();
                                }
                            }
                            if (iIntValue != 0) {
                                break loop0;
                            }
                            i6++;
                        } finally {
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                i4 = i5;
                i3 = 3;
            }
        }
        if (iIntValue == 0) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.appendAssetPathSafely() failed, cookie = " + iIntValue + " " + str);
        } else {
            Object field = FieldUtils.readField(assetManager, "mStringBlocks");
            int length = field != null ? Array.getLength(field) : 0;
            int iIntValue2 = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
            Object objNewInstance = Array.newInstance(field.getClass().getComponentType(), iIntValue2);
            int i8 = 0;
            while (i8 < iIntValue2) {
                if (i8 < length) {
                    Array.set(objNewInstance, i8, Array.get(field, i8));
                } else {
                    Object[] objArr = new Object[i2];
                    objArr[0] = Integer.valueOf(i8);
                    Class[] clsArr = new Class[i2];
                    clsArr[0] = Integer.TYPE;
                    Array.set(objNewInstance, i8, MethodUtils.invokeConstructor(field.getClass().getComponentType(), new Object[]{Long.valueOf(((Long) MethodUtils.invokeMethod(assetManager, "getNativeStringBlock", objArr, clsArr)).longValue()), Boolean.TRUE}, new Class[]{Long.TYPE, Boolean.TYPE}));
                }
                i8++;
                i2 = 1;
            }
            FieldUtils.writeField(assetManager, "mStringBlocks", objNewInstance);
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely success, sourceDir = ".concat(String.valueOf(str)));
        }
        if (th != null) {
            if (!TextUtils.equals(Build.BRAND.toLowerCase(), "samsung")) {
                ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
            }
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
        }
        return assetManager;
    }

    public final AssetManager a(AssetManager assetManager, String str, boolean z) {
        AssetManager assetManagerA;
        if (str.endsWith(".frro")) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor updateAssetManager skip frro. ".concat(str));
            return assetManager;
        }
        if (!i.a()) {
            assetManagerA = a(assetManager, str);
        } else if (i.e()) {
            assetManagerA = c(assetManager, str, z);
            if (!j.a(assetManagerA, str)) {
                assetManagerA = b(assetManager, str, z);
            }
        } else {
            assetManagerA = b(assetManager, str, z);
        }
        synchronized (this.f6192b) {
            this.f6192b.put(str, 0);
        }
        return assetManagerA;
    }

    private AssetManager a(AssetManager assetManager, String str) {
        AssetManager assetManager2;
        List<String> listA = j.a(assetManager);
        ArrayList<String> arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (String str2 : listA) {
            if (!f6191a.containsKey(str2) && !this.f6192b.containsKey(str2) && !str2.equals(str)) {
                arrayList.add(str2);
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager, runtimeAdditionalAssets path = ".concat(String.valueOf(str)));
        try {
            if (assetManager.getClass().getName().equals("android.content.res.BaiduAssetManager")) {
                assetManager2 = (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(new Class[0]).newInstance(new Object[0]);
            } else {
                assetManager2 = (AssetManager) AssetManager.class.newInstance();
            }
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager = ".concat(String.valueOf(assetManager2)));
            synchronized (this.f6192b) {
                for (Map.Entry<String, Integer> entry : this.f6192b.entrySet()) {
                    if (!f6191a.containsKey(entry.getKey())) {
                        sb.append(entry.getKey());
                        b(assetManager2, entry.getKey(), false);
                    }
                }
            }
            if (!sb.toString().contains(Zeus.getAppApplication().getApplicationInfo().sourceDir)) {
                b(assetManager2, Zeus.getAppApplication().getApplicationInfo().sourceDir, false);
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager lost host path : " + f6191a.containsKey(Zeus.getAppApplication().getApplicationInfo().sourceDir));
            }
            sb.append(str);
            b(assetManager2, str, false);
            if (!arrayList.isEmpty()) {
                for (String str3 : arrayList) {
                    sb.append(str3);
                    b(assetManager2, str3, false);
                }
            }
            if (i.d() && !sb.toString().toLowerCase().contains("webview")) {
                try {
                    Resources resources = Zeus.getAppApplication().getResources();
                    String str4 = Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", "string", DispatchConstants.ANDROID)), 0).getApplicationInfo().sourceDir;
                    if (!TextUtils.isEmpty(str4)) {
                        b(assetManager2, str4, false);
                    }
                } catch (Exception e2) {
                    ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager appendAsset webview failed.", e2);
                }
            }
            assetManager = assetManager2;
        } catch (Exception e3) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager failed.", e3);
            b(assetManager, str, false);
        }
        try {
            MethodUtils.invokeMethod(assetManager, "ensureStringBlocks", new Object[0]);
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks");
        } catch (Exception e4) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks failed.", e4);
        }
        return assetManager;
    }
}
